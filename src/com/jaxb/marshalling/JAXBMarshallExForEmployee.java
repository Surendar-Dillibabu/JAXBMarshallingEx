package com.jaxb.marshalling;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import com.jaxb.beans.Employee;

public class JAXBMarshallExForEmployee {

  public static void main(String[] args) {
    Employee employee = new Employee(10, "Surendar", 10000L, 4, new Date());
    employee.setHobbies(Arrays.asList("Cricket", "Movies"));
    marshall(employee);
    System.out.println("Marshalling completed successfully");
    Employee employee1 = unMarshall();
    System.out.println("Unmarshalled employee :" + employee1);
  }

  public static void marshall(Employee employee) {
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
      Marshaller marshaller = jaxbContext.createMarshaller();
      // used to specify the encoding type. Default encoding type is UTF-8
      marshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
      // used to specify the xml formatting is needed or not. Default is false. It
      // won't format the xml
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      // used to specify the schema location
      marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "employee-test");
      marshaller.marshal(employee, new File("G:\\Photon workspace\\JAXBMarshallingEx\\employee-marshall-ex.xml"));
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

  public static Employee unMarshall() {
    Employee employee = null;
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
      Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
      employee = (Employee) unMarshaller
          .unmarshal(new File("G:\\Photon workspace\\JAXBMarshallingEx\\employee-marshall-ex.xml"));
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return employee;
  }
}
