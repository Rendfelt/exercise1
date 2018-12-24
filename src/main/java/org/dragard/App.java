package org.dragard;

import org.dragard.employees.Employee;
import org.dragard.employees.Manager;
import org.dragard.employees.Other;
import org.dragard.employees.Worker;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 *
 */
public class App
{

    private String[] maleNames = {"Mike", "Carl", "Bob"};
    private String[] maleSurnames = {"Mike", "Carl", "Bob"};
    private String[] malePatronymic = {"Mike", "Carl", "Bob"};

    private List<Employee> employees = new ArrayList<>();

    public static void main( String[] args )
    {

        EmployeeListXML employeeList = EmployeeListXML.INSTANCE;
        for (Employee e :
                employeeList.getUnmodifiableList()) {
            System.out.println(e);
        }

        /*URL resource = App.class.getResource("/employeeList.xml");
        File file = null;
        try {
            Paths.get(resource.toURI()).toFile();
            file = Paths.get(resource.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(new FileInputStream(file)))
        ){

            String s;
            while ((s = br.readLine()) != null){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*App app = new App();
        for (int i = 0; i < 10; i++) {
            app.addOther();
            app.addManager();
            app.addWorker();
        }
        for (Employee m :
                app.employees) {
            if (m instanceof Manager){
                for (Employee w :
                        app.employees) {
                    if (w instanceof Worker){
                        if ((int)(Math.random() * 3) == 1){
                            ((Manager) m).addSubordinate((Worker) w);
                        }
                    }
                }
            }
        }

        for (Employee e :
                app.employees) {
            System.out.println(e);
        }*/


    }

/*    private Worker randomWorker(){
        String name = maleNames[(int) (Math.random() * 3)];
        String surname = maleSurnames[(int) (Math.random() * 3)];
        String patronymic = malePatronymic[(int) (Math.random() * 3)];
        Date date = new Date();
        return new Worker(name, surname, patronymic,date);
    }

    private void addWorker (){
        employees.add(randomWorker());
    }

    private void addManager (){
        Worker tempWorker = randomWorker();
        employees.add(new Manager(tempWorker.getName(), tempWorker.getSurname(), tempWorker.getPatronymic(),
                tempWorker.getDateOfEmployment()));
    }

    private void addOther (){
        Worker tempWorker = randomWorker();
        employees.add(new Other(tempWorker.getName(), tempWorker.getSurname(), tempWorker.getPatronymic(),
                tempWorker.getDateOfEmployment(), "Description " + (int)(Math.random() * 10)));
    }*/
}
