package com.doug.hospitalmanager;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class HospitalmanagerApplication {

	public static void main(String[] args) {
		Application.launch(JavaFxApplication.class, args);
	}

}
