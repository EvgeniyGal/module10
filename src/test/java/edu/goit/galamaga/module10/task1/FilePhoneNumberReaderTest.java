package edu.goit.galamaga.module10.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class FilePhoneNumberReaderTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void getPhoneNumbersTest() {

        String expected = "987-123-4567\r\n(123) 456-7890";
        FilePhoneNumberReader.printPhoneNumToConsole();

        Assertions.assertEquals(expected, outputStreamCaptor.toString().trim());
    }


}