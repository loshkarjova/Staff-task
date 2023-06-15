package org.example.app.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.app.entities.Employee;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadService {

    public void readData(String path) {

        try (Reader reader = Files.newBufferedReader(Paths.get(path))) {
            Gson gson = new Gson();
            List<Employee> employees = gson.fromJson(reader, new TypeToken<List<Employee>>() {
            }.getType());

            AtomicInteger atomicInteger = new AtomicInteger(0);
            employees.forEach(employee -> System.out.println(atomicInteger.incrementAndGet() + ") " +
                                                             employee.getName() + " " +
                                                             employee.getPosition() + " " +
                                                             employee.getPhone() + " " +
                                                             employee.getSalary()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
