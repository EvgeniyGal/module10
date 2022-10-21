package edu.goit.galamaga.module10.task1;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FilePhoneNumberReaderTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess() {

        String expected = "987-123-4567\n(123) 456-7890";
        FilePhoneNumberReader filePhoneNumberReader = new FilePhoneNumberReader();
        filePhoneNumberReader.printPhoneNumToConsole();
//        System.out.println("Hello Baeldung Readers!!\n123\n321");

        Assert.assertEquals(expected, outputStreamCaptor.toString().trim());
    }


}