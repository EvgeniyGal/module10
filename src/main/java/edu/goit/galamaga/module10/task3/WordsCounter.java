package edu.goit.galamaga.module10.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class provides methods that count words from different stream.
 */
public class WordsCounter {

    /**
     * This method counts words in Words.txt
     */
    public static void countWords() {

        LinkedHashMap<String, Integer> words = new LinkedHashMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        try (var fileReader = new FileReader("src/main/resources/Words.txt");
             var bufferedReader = new BufferedReader(fileReader)) {

            while (bufferedReader.ready()){
                stringBuilder.append(bufferedReader.readLine()).append("\n");
            }

            Pattern pattern = Pattern.compile("\\w+");
            Matcher matcher = pattern.matcher(stringBuilder);

            while (matcher.find()) {
                words.put(matcher.group(), 0);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (Map.Entry<String, Integer> mapItem :
                words.entrySet()) {

            Pattern pattern = Pattern.compile("" + mapItem.getKey());
            Matcher matcher = pattern.matcher(stringBuilder);
            int count = 0;

            while (matcher.find()) {
                words.put(matcher.group(), 1);
                count++;
            }

            mapItem.setValue(count);

        }


        for (Map.Entry<String, Integer> mapItem :
                words.entrySet()) {

            System.out.println(mapItem.getKey() + " " +  mapItem.getValue());

        }

    }

}
