package dorofeev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestWorkWithText {

    @Test
    void frequencyOfWordsInTheText_ThrowEmptyStringException() {
        Assertions.assertThrows(EmptyStringException.class, () -> {
            String text = "";
            WorkWithText.frequencyOfWordsInTheText(text);
        });
    }

    @Test
    void frequencyOfWordsInTheText_ReturnElementInOrder() throws EmptyStringException {
        String text = "AAA aaa TTT ZZZ ss tq ba";
        String[] arrayWords = WorkWithText.frequencyOfWordsInTheText(text);

        Assertions.assertEquals("aaa", arrayWords[0]);

        text = "D D D G G g C C C A a A";
        arrayWords = WorkWithText.frequencyOfWordsInTheText(text);

        Assertions.assertEquals("a", arrayWords[arrayWords.length - 1]);

        text = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        arrayWords = WorkWithText.frequencyOfWordsInTheText(text);

        Assertions.assertEquals("q", arrayWords[9]);
    }

    @Test
    void frequencyOfWordsInTheText_ReturnLengthIs10() throws EmptyStringException {
        String text = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        String[] arrayWords = WorkWithText.frequencyOfWordsInTheText(text);

        Assertions.assertEquals(10, arrayWords.length);
    }

    @Test
    void frequencyOfWordsInTheText_WorkingWithCustomRegex() throws EmptyStringException {
        String text = "s!s:s;s.s";
        String customRegex = "\\W";
        String[] arrayWords = WorkWithText.frequencyOfWordsInTheText(text, customRegex);

        Assertions.assertEquals(1, arrayWords.length);
        Assertions.assertEquals("s", arrayWords[0]);
    }

}