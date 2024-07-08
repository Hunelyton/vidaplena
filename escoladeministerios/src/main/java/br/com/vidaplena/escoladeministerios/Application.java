package br.com.vidaplena.escoladeministerios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
@ComponentScan({"br.com.vidaplena.escoladeministerios.controllers"})
public class Application extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
