package com.selfGroup.firstEmpCrud;

import com.selfGroup.firstEmpCrud.Controller.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstEmpCrudApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirstEmpCrudApplication.class, args);
		EmployeeController empController = context.getBean(EmployeeController.class);

		// Call the desired method
		empController.insetEmployee();
	}
}