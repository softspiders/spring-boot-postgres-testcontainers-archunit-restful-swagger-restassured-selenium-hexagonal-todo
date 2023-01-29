package org.softspiders.starters.application;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaConstructor;
import com.tngtech.archunit.core.domain.JavaField;
import com.tngtech.archunit.core.domain.JavaType;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAPackage;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideOutsideOfPackage;
import static com.tngtech.archunit.core.domain.JavaModifier.STATIC;
import static com.tngtech.archunit.lang.SimpleConditionEvent.violated;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.constructors;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;
import static com.tngtech.archunit.library.GeneralCodingRules.*;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.substringAfterLast;

/**
 * Architecture tests are used to make sure that application architecture patterns and principles are followed in appropriate manner
 */
@AnalyzeClasses(packages = "org.softspiders.todos", importOptions = ImportOption.DoNotIncludeTests.class)
@SuppressWarnings("unused")
public class ArchitectureTest {

    public static final PrimaryPortArchCondition PRIMARY_PORT_ARCH_CONDITION = new PrimaryPortArchCondition();
    public static final SecondaryPortArchCondition SECONDARY_PORT_ARCH_CONDITION = new SecondaryPortArchCondition();
    public static final RestDependencyArchCondition REST_DEPENDENCY_ARCH_CONDITION = new RestDependencyArchCondition();
    public static final RestConstructorArchCondition REST_CONSTRUCTOR_ARCH_CONDITION = new RestConstructorArchCondition();

    /**
     * A rule that checks that none of the given classes access Java Util Logging.
     */
    @ArchTest
    public static final ArchRule JAVA_UTIL_LOGGING_IS_FORBIDDEN = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING.because("We use Log4J");

    /**
     * A rule that checks that none of the given classes uses field injection.
     */
    @ArchTest
    public static final ArchRule FIELD_INJECTION_SHOULD_NOT_BE_USED = NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

    /**
     * A rule that checks that none of the given classes access the standard streams System.out and System.err.
     */
    @ArchTest
    public static final ArchRule STANDARD_OUTPUT_STREAMS_SHOULD_NOT_BE_USED = NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

    /**
     * Architecture test to check if hexagonal architecture pattern is followed
     */
    @ArchTest
    public static final ArchRule HEXAGONAL_ARCH_RULE = onionArchitecture()
            .domainModels("org.softspiders.todos.domain.model..")
            .domainServices("org.softspiders.todos.domain.port..")
            .adapter("crud", "org.softspiders.todos.adapter.crud_jpa..")
            .applicationServices("org.softspiders.todos.application..")
            .adapter("rest", "org.softspiders.todos.adapter.rest..");

    /**
     * Architecture test to check following arch conditions:
     * <ul>
     *     <li>Primary port is dependent on primary ports from other packages</li>
     *     <li>Primary port is dependent on secondary ports from same package</li>
     * </ul>
     */
    @ArchTest
    public static final ArchRule PRIMARY_PORT_ARCH_RULE = classes()
            .that()
            .resideInAPackage("org.softspiders.todos.application.service..")
            .and()
            .haveSimpleNameEndingWith("ApplicationService")
            .should(PRIMARY_PORT_ARCH_CONDITION);

    /**
     * Architecture test to check following arch conditions:
     * <ul>
     *    <li>Secondary port is not dependent on secondary ports from other packages</li>
     * </ul>
     */
    @ArchTest
    public static final ArchRule SECONDARY_PORT_ARCH_RULE = classes()
            .that()
            .resideInAPackage("org.softspiders.todos.adapter..")
            .and()
            .haveSimpleNameEndingWith("Adapter")
            .and()
            .haveSimpleNameNotStartingWith("Abstract")
            .should(SECONDARY_PORT_ARCH_CONDITION)
            .andShould()
            .dependOnClassesThat(resideOutsideOfPackage("org.softspiders.todos.domain.port.spi.."));


    /**
     * Architecture test to check if controller depends on primary port from the same package
     */
    @ArchTest
    public static final ArchRule REST_DEPENDENCY_ARCH_RULE = classes()
            .that()
            .resideInAPackage("org.softspiders.todos.adapter.rest..")
            .and()
            .haveSimpleNameEndingWith("Controller")
            .should()
            .dependOnClassesThat(resideInAPackage("org.softspiders.todos.domain.port.api.."))
            .andShould(REST_DEPENDENCY_ARCH_CONDITION);

    /**
     * Architecture test to check if controller depends on single primary port
     */
    @ArchTest
    public static final ArchRule REST_CONSTRUCTOR_ARCH_RULE = constructors()
            .that()
            .areDeclaredInClassesThat()
            .resideInAPackage("org.softspiders.todos.adapter.rest..")
            .and()
            .areDeclaredInClassesThat()
            .haveSimpleNameEndingWith("Controller")
            .should(REST_CONSTRUCTOR_ARCH_CONDITION);

    static class RestDependencyArchCondition extends ArchCondition<JavaClass> {

        public RestDependencyArchCondition() {
            super("should depend on port from same package");
        }

        @Override
        public void check(JavaClass clazz, ConditionEvents conditionEvents) {
            String packageName = clazz.getPackageName();
            if (!clazz.getFields().stream()
                    .filter(field -> !field.getModifiers().contains(STATIC))
                    .allMatch(field -> {
                        String lastPackagePart = substringAfterLast(field.getRawType().getPackageName(), ".");
                        return packageName.contains(lastPackagePart);
                    })) {
                conditionEvents.add(violated(clazz, clazz.getDescription()));
            }
        }
    }

    static class RestConstructorArchCondition extends ArchCondition<JavaConstructor> {

        public RestConstructorArchCondition() {
            super("should depend on single port");
        }

        @Override
        public void check(JavaConstructor constructor, ConditionEvents conditionEvents) {
            List<JavaClass> filteredParameterTypes = constructor.getRawParameterTypes().stream().toList();
            Optional<String> notAPort = filteredParameterTypes.stream()
                    .map(JavaClass::getSimpleName)
                    .filter(s -> !s.endsWith("Port"))
                    .findAny();

            if (filteredParameterTypes.size() > 1 || notAPort.isPresent()) {
                conditionEvents.add(violated(constructor, constructor.getDescription()));
            }
        }
    }

    private static class PrimaryPortArchCondition extends ArchCondition<JavaClass> {

        public PrimaryPortArchCondition() {
            super("should depend on single port");
        }

        @Override
        public void check(JavaClass clazz, ConditionEvents events) {
            String lastPackageNamePart = substringAfterLast(clazz.getPackageName(), ".");
            Stream<JavaField> fieldStream = clazz.getFields().stream().filter(field -> field.getRawType().getPackageName().contains("org.softspiders.todos.domain.port.spi"));

            if (!fieldStream.allMatch(field -> field.getRawType().getPackageName().contains("." + lastPackageNamePart))) {
                events.add(violated(clazz, clazz.getDescription()));
            }
        }
    }

    static class SecondaryPortArchCondition extends ArchCondition<JavaClass> {

        public SecondaryPortArchCondition() {
            super("should implement port from same or from parent package");
        }

        @Override
        public void check(JavaClass clazz, ConditionEvents conditionEvents) {
            Optional<JavaType> portOptional = clazz.getInterfaces().stream().findFirst();
            String portPackage = portOptional.map(javaType -> ((JavaClass) javaType).getPackageName()).orElse(EMPTY);

            String lastPackagePortPart = substringAfterLast(portPackage, ".");
            String lastPackageAdapterPart = substringAfterLast(clazz.getPackageName(), ".");

            if (!lastPackagePortPart.equals(lastPackageAdapterPart) && !clazz.getPackageName().contains(lastPackagePortPart)) {
                conditionEvents.add(violated(clazz, clazz.getDescription()));
            }
        }
    }
}