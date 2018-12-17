package org.dragard.employees;

import java.util.Date;

public class Worker extends Employee {

    public Worker(String name, String surname, String patronimic, Date dateOfEmployment) {
        super(name, surname, patronimic, dateOfEmployment);
    }

    @Override
    public String toString() {
        return "Worker{" +
                super.toString() +
                "}";
    }
}
