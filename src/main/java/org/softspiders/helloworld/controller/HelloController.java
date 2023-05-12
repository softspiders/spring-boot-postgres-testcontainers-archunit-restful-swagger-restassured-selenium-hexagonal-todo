package org.softspiders.helloworld.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Operation(summary = "Get example resource")
    @GetMapping("/hello")
  public String hello() {
	  return "Hello World";
  }
}
