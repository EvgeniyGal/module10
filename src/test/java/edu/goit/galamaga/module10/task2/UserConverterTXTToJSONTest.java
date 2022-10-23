package edu.goit.galamaga.module10.task2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.io.File;


class UserConverterTXTToJSONTest {

    @Test
    void convertTXTToJSONTest(){

        UserConverterTXTToJSON.convertTXTToJSON("src/test/resources/User.txt", "src/test/resources/User.json");

        File expectedFile = new File("src/test/resources/ExpectedUser.json");
        File actualFile = new File("src/test/resources/User.json");

        assertThat(actualFile).hasSameContentAs(expectedFile);

    }

}