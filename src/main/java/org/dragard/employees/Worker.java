package org.dragard.employees;

import java.util.Date;

public class Worker extends Employee {

    public Worker(long id, String name, String surname, String patronymic, Date dateOfEmployment) {
        super(id, name, surname, patronymic, Position.WORKER, dateOfEmployment);
    }

    @Override
    public String toString() {
        return "Worker{" +
                super.toString() +
                "}";
    }
}
