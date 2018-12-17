package org.dragard.employees;

import java.util.Date;

public abstract class Employee {

    private final String name;
    private final String surname;
    private final String patronymic;

    private final Date dateOfEmployment;

    public Employee(String name, String surname, String patronymic, Date dateOfEmployment) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfEmployment = dateOfEmployment;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String
    toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfEmployment=" + dateOfEmployment;
    }
}
