package edu.goit.galamaga.module10.task1;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilePhoneNumberReader {

    public static void printPhoneNumToConsole() {

        for (String phoneNumber :
                getPhoneNumbers()) {
            System.out.println(phoneNumber);
        }

    }

    private static List<String> getPhoneNumbers() {

        LinkedList<String> phoneNumbers = new LinkedList<>();

        try (FileReader fileReader = new FileReader("src/main/resources/PhoneNumbers.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while (bufferedReader.ready()) {
                String phoneNumber = bufferedReader.readLine().strip();
                if (isPhoneNumberCorrect(phoneNumber)) phoneNumbers.add(phoneNumber);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return phoneNumbers;
    }

    private static boolean isPhoneNumberCorrect(String phoneNumber) {

//        Pattern pattern = Pattern.compile("([0-9]{3})-([0-9]{3})-([0-9]{4})");
        Pattern pattern = Pattern.compile("(\\d{3})-(\\d{3})-(\\d{4})|\\((\\d{3})\\) (\\d{3})-(\\d{4})");

        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.find();
    }


}
