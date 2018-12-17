package org.dragard.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Manager extends Employee {

    private final List<Worker> subordinates;

    public Manager(String name, String surname, String patronimic, Date dateOfEmployment) {
        super(name, surname, patronimic, dateOfEmployment);
        subordinates = new ArrayList<>();
    }

    public Manager(String name, String surname, String patronimic, Date dateOfEmployment, List<Worker> subordinates) {
        super(name, surname, patronimic, dateOfEmployment);
        this.subordinates = subordinates;
    }

    @Override
    public String toString() {
        return "Manager{" +
                super.toString() +
                "subordinates=" + subordinates +
                '}';
    }

    public List<Worker> getSubordinates() {
        return subordinates;
    }

    public boolean addSubordinate(Worker worker){
        return subordinates.add(worker);
    }

    public boolean removeSubordinate(Worker worker){
        return subordinates.remove(worker);
    }

    public boolean addSubordinates(List<Worker> workers){
        return subordinates.addAll(workers);
    }

    public boolean removeSubordinates(List<Worker> workers){
        return subordinates.removeAll(workers);
    }
}
