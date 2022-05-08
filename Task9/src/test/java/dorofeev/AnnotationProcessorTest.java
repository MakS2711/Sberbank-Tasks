package dorofeev;

import dorofeev.annotation.AnnotationProcessor;
import dorofeev.exception.AnnotationException;
import dorofeev.tests.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnnotationProcessorTest {

    @Test
    public void customTest_ReturnCorrectOrderInvoke() throws Exception {
        Assertions.assertArrayEquals(new Object[]{-1000, 30, 20, 10, 1000}, AnnotationProcessor.runningCustomTest(CustomTest.class).toArray());
        Assertions.assertArrayEquals(new Object[]{30, 20, 10, 1000}, AnnotationProcessor.runningCustomTest(CustomTest1.class).toArray());
        Assertions.assertArrayEquals(new Object[]{-1000, 30, 20, 10}, AnnotationProcessor.runningCustomTest(CustomTest2.class).toArray());
        Assertions.assertArrayEquals(new Object[]{20, 30, 10}, AnnotationProcessor.runningCustomTest(CustomTest3.class).toArray());
    }

    @Test
    public void customTest_ThrowExceptionNoAnnotationDoTest() {
        Assertions.assertThrows(AnnotationException.class, () -> {
            AnnotationProcessor.runningCustomTest(CustomTestWithoutAnnotationsDoTest.class);
        });
    }

    @Test
    public void customTest_ThrowExceptionNoAnnotationIncorrectNumberDoTest() {
        Assertions.assertThrows(AnnotationException.class, () -> {
            AnnotationProcessor.runningCustomTest(CustomTestWithIncorrectNumberDoTest.class);
        });
    }

    @Test
    public void customTest_ThrowExceptionLotsOfSingleAnnotation() {
        Assertions.assertThrows(AnnotationException.class, () -> {
            AnnotationProcessor.runningCustomTest(CustomTestWithLotsOfAnnotationDoBeforeAll.class);
        });

        Assertions.assertThrows(AnnotationException.class, () -> {
            AnnotationProcessor.runningCustomTest(CustomTestWithLotsOfAnnotationDoAfterAll.class);
        });
    }
}