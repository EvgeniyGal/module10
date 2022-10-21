package edu.goit.galamaga.module10.task1;

import java.io.*;
import java.util.List;

public class FilePhoneNumberReader {

    public void printPhoneNumToConsole() {
        System.out.println(getPhoneNumbers());
    }

    private List<String> getPhoneNumbers() {

        List<String> phoneNumbers = null;
        File file = new File("PhoneNumbers.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("file.getPath() = " + file.getPath());

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while (bufferedReader.ready()) {
                String phoneNumber = bufferedReader.readLine();
                if (isPhoneNumberCorrect(phoneNumber)) phoneNumbers.add(phoneNumber);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist!");
            ;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ;
        }

        return phoneNumbers;
    }

    private boolean isPhoneNumberCorrect(String phoneNumber) {

        return false;
    }


}
