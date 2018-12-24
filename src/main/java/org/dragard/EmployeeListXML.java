package org.dragard;

import javafx.util.Pair;
import org.dragard.employees.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeListXML implements EmployeeListInterface{

    private List<Employee> employeeList = new ArrayList<>();

    private static final String XML_LIST_FILE_NAME = "/employeeList.xml";

    private Document xmlDocument;
    
    public static final EmployeeListXML INSTANCE = new EmployeeListXML();
    
    /**
     * Приватный конструктор, запрещает создание экземпляров класса.
     * В конструкторе инициализируется список сотрудников, который загружается из XML-файла.
     * */
    private EmployeeListXML() {
        try {
            loadFromXML();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Загрузка списка из XML
     */
    private void loadFromXML () throws IOException, URISyntaxException, SAXException, ParserConfigurationException {
        List<Pair<Long, Long>> managerSubsIds = new ArrayList<>();

        xmlDocument = getXMLDocument();

        NodeList el = xmlDocument.getElementsByTagName("employee");
        for (int i = 0; i < el.getLength(); i++) {
            if (el.item(i).getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) el.item(i);
                String tPosition = element.getElementsByTagName("position").item(0).getTextContent();
                //TODO: Нахождение максимального ID и присвоение его статической переменной листа, которая
                // будет выдавать ID новым сотрудникам.

                if (Position.WORKER.name().equals(tPosition)){
                    addNewWorker(element);
                } else if (Position.MANAGER.name().equals(tPosition)){
                    addNewManager(element, managerSubsIds);
                } else if (Position.OTHER.name().equals(tPosition)){
                    addNewOther(element);
                }



            }
        }

        //TODO: Привязка сотрудника к менеджеру

    }

    /**
     * Вспомогательныый метод. В процессе чтения XML-файла добавляет других сотрудников в список
     * */

    private void addNewOther(Element element) {
        try {
            employeeList.add(new Other(
                    Long.parseLong(element.getElementsByTagName("id").item(0).getTextContent()),
                    element.getElementsByTagName("name").item(0).getTextContent(),
                    element.getElementsByTagName("surname").item(0).getTextContent(),
                    element.getElementsByTagName("patronymic").item(0).getTextContent(),
                    new SimpleDateFormat("dd/MM/yyyy").parse(element.getElementsByTagName("dateOfEmployment").item(0).getTextContent()),
                    element.getElementsByTagName("description").item(0).getTextContent()
            ));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("addNewOther");
    }

    /**
     * Вспомогательныый метод. В процессе чтения XML-файла менеджеров в список.
     * Также заполняет список соответствия ИД менеджера ИД его подчиненных для
     * дальнейшего заполнения списка подчиненных менеджера.
     * */

    private List<Pair<Long, Long>> addNewManager(Element element, List<Pair<Long, Long>> managerSubsIds) {

        long tManagerId = Long.parseLong(element.getElementsByTagName("id").item(0).getTextContent());
        try {
            employeeList.add(new Manager(
                    tManagerId,
                    element.getElementsByTagName("name").item(0).getTextContent(),
                    element.getElementsByTagName("surname").item(0).getTextContent(),
                    element.getElementsByTagName("patronymic").item(0).getTextContent(),
                    new SimpleDateFormat("dd/MM/yyyy").parse(element.getElementsByTagName("dateOfEmployment").item(0).getTextContent())
            ));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Element tElement = (Element) element.getElementsByTagName("subordinates").item(0);
        NodeList tNodeList = tElement.getElementsByTagName("id");
        for (int i = 0; i < tNodeList.getLength(); i++) {
            managerSubsIds.add(new Pair<>(tManagerId, Long.parseLong(tNodeList.item(i).getTextContent())));
        }

        System.out.println("addNewManager");
        return managerSubsIds;
    }

    /**
     * Вспомогательныый метод. В процессе чтения XML-файла добавляет работников в список
     * */
    private void addNewWorker(Element element) {
        try {
            employeeList.add(new Worker(
                    Long.parseLong(element.getElementsByTagName("id").item(0).getTextContent()),
                    element.getElementsByTagName("name").item(0).getTextContent(),
                    element.getElementsByTagName("surname").item(0).getTextContent(),
                    element.getElementsByTagName("patronymic").item(0).getTextContent(),
                    new SimpleDateFormat("dd/MM/yyyy").parse(element.getElementsByTagName("dateOfEmployment").
                            item(0).getTextContent())
            ));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("addNewWorker");

    }

    /**
     * Метод получает DOM-объект из XML-файла
     * */
    private Document getXMLDocument() throws URISyntaxException, ParserConfigurationException, IOException, SAXException {
        URL resource = EmployeeListXML.class.getResource(XML_LIST_FILE_NAME);
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        return db.parse(Paths.get(resource.toURI()).toFile());
    }

    /**
     * Сохранение в XML
     */
    private void saveToXML(){
        //TODO:
    }


    /**
     * Добавление нового сотрудника
     */
    @Override
    public void addNewEmployee(Employee employee) {

    }

    /**
     * Удаление сотрудника
     */
    @Override
    public void removeEmployee(Employee employee) {

    }

    /**
     * Изменение должности сотрудника
     */
    @Override
    public void changeEmployeePosition(Employee employee, Position position) {

    }

    /**
     * Привязка работника к менеджеру
     */
    @Override
    public void bindWorkerToManager(Worker worker, Manager manager) {

    }

    /**
     * Сортировка по фамилии
     */
    @Override
    public void sortBySurname() {

    }

    /**
     * Сортировка по дате приема на работу
     */
    @Override
    public void sortByDateOfEmployment() {

    }

    /**
     * Возвращает список сотрудников, без возможности редактировать его, для дальнейшего отображения
     * */
    @Override
    public List<Employee> getUnmodifiableList() {
        return Collections.unmodifiableList(employeeList);
    }


}
