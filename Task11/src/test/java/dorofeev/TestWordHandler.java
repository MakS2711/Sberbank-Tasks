package dorofeev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class TestWordHandler {

    @Test
    void countWord_ReturnCorrectCountWord() throws IOException, InterruptedException {
        File pathToProperties = new File(getClass().getClassLoader().getResource("dorofeev.properties").getFile());
        int countWordFlower = WordHandler.countWord("flower", pathToProperties.getAbsolutePath());
        Assertions.assertEquals(11, countWordFlower);
    }
}