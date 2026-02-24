package com.example.fieldinjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.example.fieldinjection");

        EmployeeService service = context.getBean(EmployeeService.class);

        service.createEmployee(1, "Navya");
        service.createEmployee(2, "John");

        service.displayEmployees();

        context.close();
    }
}
