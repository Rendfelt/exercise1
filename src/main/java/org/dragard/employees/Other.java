package org.dragard.employees;

import java.util.Date;

public class Other extends Employee{

    private final String Description;

    public Other(long id, String name, String surname, String patronymic, Date dateOfEmployment, String description) {
        super(id, name, surname, patronymic, Position.OTHER, dateOfEmployment);
        Description = description;
    }

    public String getDescription() {
        return Description;
    }

    @Override
    public String toString() {
        return "Other{" +
                super.toString() +
                ", Description=" + getDescription() +
                '}';
    }
}
