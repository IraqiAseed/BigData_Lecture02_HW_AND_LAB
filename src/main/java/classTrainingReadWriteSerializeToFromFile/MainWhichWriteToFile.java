package classTrainingReadWriteSerializeToFromFile;

import file_examples.Employee;
import lombok.SneakyThrows;
import model.Person;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class MainWhichWriteToFile {

    @SneakyThrows
    public static void main(String[] args) {
        File file = new File("c:\\tmp\\data.obj");

        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        Person daniel = new Person("Daniel", 28);
        List<Object> list = List.of(new Employee(10), new Employee(20), new Person("Reut", 18));


        FileOutputStream fos = new FileOutputStream(file);


        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(daniel);
        oos.writeObject(list);

        oos.close();
    }
}
