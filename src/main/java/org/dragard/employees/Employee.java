package org.dragard.employees;

import java.util.Date;

public abstract class Employee {

    private final long id;
    private final String name;
    private final String surname;
    private final String patronymic;
    private final Position position;

    private final Date dateOfEmployment;

    public Employee(long id, String name, String surname, String patronymic, Position position, Date dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.position = position;
        this.dateOfEmployment = dateOfEmployment;
    }

    public long getId() {
        return id;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
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
        return "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", position=" + position +
                ", dateOfEmployment=" + dateOfEmployment;
    }
}
