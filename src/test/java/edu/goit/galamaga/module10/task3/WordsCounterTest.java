package edu.goit.galamaga.module10.task3;

import edu.goit.galamaga.module10.task1.FilePhoneNumberReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class WordsCounterTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void countWordsTest() {

        String expected = "the 4\r\nday 1\r\nis 3\r\nsunny 2";

        WordsCounter.countWords();

        Assertions.assertEquals(expected, outputStreamCaptor.toString().trim());

    }

}