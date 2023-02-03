package org.softspiders.starters.adapter.crud_jpa;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("org.softspiders.starters.adapter.crud_jpa")
@EnableJpaRepositories("org.softspiders.starters.adapter.crud_jpa")
public class JpaConfig {
}