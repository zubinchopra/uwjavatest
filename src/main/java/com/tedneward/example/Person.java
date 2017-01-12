package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person>{
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  private int count;

  public Person() {
    this("", 0, 0.0d);
  }

  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
    this.count++;
  }

  public void setAge(int age){
     if(age < 0)
      throw new IllegalArgumentException();
     this.age = age;
  }

  public void setName(String name){
     if(name == null)
      throw new IllegalArgumentException();
     this.name = name;
  }

  public void setSalary(double salary){
     this.salary = salary;
  }

  public int getAge(){
     return this.age;
  }

  public String getName(){
    return this.name;
  }

  public static List<Person> getNewardFamily(){
     List<Person> list = new ArrayList<Person>();
     list.add(new Person("Ted", 41, 250000));
     list.add(new Person("Charlotte", 43, 150000));
     list.add(new Person("Michael", 22, 10000));
     list.add(new Person("Matthew", 15, 0));
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
    return "The Honorable " + this.name;
  }

  public int timeWarp() {
    return age + 10;
  }

  public String toString() {
     //[Person name:Fird Birfle age:20 salary:195750.22]
    return "[Person name:" + this.name + " age:" + this.age + " salary:" +
                                                               this.salary +"]";
  }

  public int count(){
     return this.count;
  }

  public boolean equals(Object other){
     if (other instanceof Person) {
         Person p = (Person)other;
         return p.name == this.name && p.age == this.age;
     }
     return false;
  }

  public int compareTo(Person other){
     return Double.compare(other.salary, this.salary);
  }

  public static class AgeComparator implements Comparator<Person>{
    public int compare(Person one, Person two){
      return one.getAge() - two.getAge();
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
