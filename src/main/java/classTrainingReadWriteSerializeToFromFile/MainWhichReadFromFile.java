package classTrainingReadWriteSerializeToFromFile;

import file_examples.Employee;
import lombok.SneakyThrows;
import model.Person;


import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;


public class MainWhichReadFromFile {


    @SneakyThrows
    public static void main(String[] args) {
        File file = new File("c:\\tmp\\data.obj");

        FileInputStream fis = new FileInputStream(file);


        ObjectInputStream ois = new ObjectInputStream(fis);

        Person p1 = (Person) ois.readObject();
        System.out.println(p1);

        List list = (List) ois.readObject();

        for (Object o : list) {
            System.out.println(o);
            if (o instanceof Employee) {
                System.out.println("salary is: " + ((Employee) o).getSalary());
            }
            if (o instanceof Person) {
                Person person = (Person) o;
                System.out.println(person.getName());
            }


        }
        ois.close();


    }
}
