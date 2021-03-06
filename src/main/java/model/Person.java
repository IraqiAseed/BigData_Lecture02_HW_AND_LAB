package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Person implements Serializable {
    private static final long serialversionUID = 456;
    private String name;
    //private transient int age;
    private int age;


    public static void printName() {
        Person person = new Person();
        System.out.println(person.getName());
        System.out.println(serialversionUID);
    }

    public Person withName(String name) {
        return this.name == name ? this : new Person(name, this.age);
    }

    public Person withAge(int age) {
        return this.age == age ? this : new Person(this.name, age);
    }
}








