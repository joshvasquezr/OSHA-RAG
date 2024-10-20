package org.vaadin.example;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication

@PWA(name = "Project 3 - GenAI Project", shortName = "CS514 Project 3", description = "Co-developed by John Riordan and Joshua Vasquez-Ruiz, this application was produced for the course CS514 taught by Dr. David Wolber at the University of San Francisco. Assigned as the course's third project, this project was designed to leverage the capabilities that Vaadin, an open-source web application development platform for Java, offered to develop an Generative AI application using OpenAI.")
@Theme("my-theme")
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
