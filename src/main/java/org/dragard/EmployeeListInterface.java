package org.dragard;

import org.dragard.employees.Employee;
import org.dragard.employees.Manager;
import org.dragard.employees.Position;
import org.dragard.employees.Worker;

import java.util.List;

public interface EmployeeListInterface {

    void addNewEmployee(Employee employee);

    void removeEmployee(Employee employee);

    void changeEmployeePosition(Employee employee, Position position);

    void bindWorkerToManager(Worker worker, Manager manager);

    void sortBySurname();

    void sortByDateOfEmployment();

    List<Employee> getUnmodifiableList();
}
