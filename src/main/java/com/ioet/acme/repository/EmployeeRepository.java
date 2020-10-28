package com.ioet.acme.repository;

public class EmployeeRepository implements InEmployeeRepository{

    public void employee (String name, int salary) {
        System.out.printf("The amount to pay %s is: %d USD\n", name, salary);
    }

}
