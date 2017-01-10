package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparator<Person>, Comparable<Person>{
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  private static List<Person> list;

  public Person() {
    this("", 0, 0.0d);
  }

  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
    list.add(this);
  }

  public void setAge(int age){
     if(age < 0)
      throw new IllegalArgumentException();
     int old = this.age;
     this.age = age;
     this.pcs.firePropertyChange("age", old, age);
     this.propertyChangeFired = true;
  }

  public void setName(String name){
     if(name.equals(null))
      throw new IllegalArgumentException();
     String old = this.name;
     this.name = name;
     this.pcs.firePropertyChange("name", old, name);
     this.propertyChangeFired = true;
  }

  public void setSalary(double salary){
     double old = this.salary;
     this.salary = salary;
     this.pcs.firePropertyChange("salary", old, salary);
     this.propertyChangeFired = true;
  }

  public int getAge(){
     return this.age;
  }

  public String getName(){
    return this.name;
  }

  public static List<Person> getNewardFamily(){
     return list;
 }

  public void setSSN(String value) {
    String old = ssn;
    ssn = value;

    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }
  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }

  public String becomeJudge() {
    return "The Honorable " + name;
  }

  public int timeWarp() {
    return age + 10;
  }

  public String tostring() {
    return "{{FIXME}}";
  }

  public int count(){
     return this.list.size();
  }

  public int compareTo(Person other){
     return Double.compare(other.salary, this.salary);
  }

  private static class AgeComparator{
    public int compare(Person other){
      return this.getAge() - other.getAge();
    }
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }
}
