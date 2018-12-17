package org.dragard.employees;

import java.util.Date;

public class Other extends Employee{

    private final String Description;

    public Other(String name, String surname, String patronimic, Date dateOfEmployment, String description) {
        super(name, surname, patronimic, dateOfEmployment);
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
