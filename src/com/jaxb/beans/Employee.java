package com.jaxb.beans;

import java.util.Date;
import java.util.List;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "employeeId", "employeeName", "salary", "joiningDate", "hobbies", "deptId" })
public class Employee {

  @XmlElement(name = "employeeId")
  private int employeeId;

  @XmlElement(name = "employeeName")
  private String employeeName;

  @XmlElement(name = "salary")
  private Long salary;

  @XmlElement(name = "deptId")
  private int deptId;

  @XmlElement(name = "joiningDate")
  private Date joiningDate;

  @XmlElementWrapper(name = "hobbies")
  @XmlElement(name = "hobby")
  private List<String> hobbies;

  public Employee() {
  }

  public Employee(int employeeId, String employeeName, Long salary, int deptId, Date joiningDate) {
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.salary = salary;
    this.deptId = deptId;
    this.joiningDate = joiningDate;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public Long getSalary() {
    return salary;
  }

  public void setSalary(Long salary) {
    this.salary = salary;
  }

  public int getDeptId() {
    return deptId;
  }

  public void setDeptId(int deptId) {
    this.deptId = deptId;
  }

  public Date getJoiningDate() {
    return joiningDate;
  }

  public void setJoiningDate(Date joiningDate) {
    this.joiningDate = joiningDate;
  }

  public List<String> getHobbies() {
    return hobbies;
  }

  public void setHobbies(List<String> hobbies) {
    this.hobbies = hobbies;
  }

  // Invoked by Marshaller after it has created an instance of this object.
  boolean beforeMarshal(Marshaller marshaller) {
    System.out.println("Before Marshaller Callback");
    return true;
  }

  // Invoked by Marshaller after it has marshalled all properties of this object.
  void afterMarshal(Marshaller marshaller) {
    System.out.println("After Marshaller Callback");
  }

  // It is called immediately after the object is created and before the
  // unmarshalling begins.
  // The callback provides an opportunity to initialize JavaBean properties prior
  // to unmarshalling.
  void beforeUnmarshal(Unmarshaller unmarshaller, Object parent) {
    System.out.println("Before Unmarshaller Callback");
  }

  // It is called after all the properties are unmarshalled for this object,
  // but before this object is set to the parent object.
  void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
    System.out.println("After Unmarshaller Callback");
  }

  @Override
  public String toString() {
    return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary + ", deptId="
        + deptId + ", joiningDate=" + joiningDate + ", hobbies=" + hobbies + "]";
  }

}
