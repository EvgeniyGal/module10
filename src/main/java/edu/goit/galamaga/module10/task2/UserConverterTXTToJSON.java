package edu.goit.galamaga.module10.task2;

import com.google.gson.Gson;

import java.io.*;
import java.util.LinkedList;

/**
 * This class creates User objects from the data in User.txt and then
 * converts those objects to Json format.
 */
public class UserConverterTXTToJSON {

    public static void convertTXTToJSON() {

        LinkedList<User> users = new LinkedList<>();

        try (var fileReader = new FileReader("src/main/resources/User.txt");
             var bufferedReader = new BufferedReader(fileReader)) {

            while (bufferedReader.ready()) {

                String line = bufferedReader.readLine();

                if (!line.contains("name age")) {
                    String[] data = line.strip().split(" ");
                    users.add(new User(data[0], Integer.parseInt(data[1])));
                }

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (var fileWriter = new FileWriter("src/main/resources/User.json")) {

            fileWriter.write(new Gson().toJson(users));
            fileWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static class User {

        private final String name;
        private final int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }
}
