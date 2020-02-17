package com.jaxb.marshalling;

import java.io.File;
import java.util.Arrays;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import com.jaxb.beans.Person;

public class JAXBMarshallExForPerson {

  public static void main(String[] args) {
    Person person = new Person(Arrays.asList("Cricket", "Movies"));
    marshall(person);
    System.out.println("Marshalling completed");
    Person person1 = unMarshall();
    System.out.println("person1 :" + person1);
  }

  public static void marshall(Person person) {
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
      Marshaller marshaller = jaxbContext.createMarshaller();
      // used to specify the encoding type. Default encoding type is UTF-8
      marshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
      // used to specify the xml formatting is needed or not. Default is false. It
      // won't format the xml
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      // used to specify the schema location
      marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "person-test");
      marshaller.marshal(person, new File("G:\\Photon workspace\\JAXBMarshallingEx\\person-marshalling-ex.xml"));
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

  public static Person unMarshall() {
    Person person = null;
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
      Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
      person = (Person) unMarshaller
          .unmarshal(new File("G:\\Photon workspace\\JAXBMarshallingEx\\person-marshalling-ex.xml"));
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return person;
  }
}
