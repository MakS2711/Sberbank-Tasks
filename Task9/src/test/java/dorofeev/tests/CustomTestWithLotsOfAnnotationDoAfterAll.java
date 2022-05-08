package dorofeev.tests;

import dorofeev.annotation.DoAfterAll;
import dorofeev.annotation.DoBeforeAll;
import dorofeev.annotation.DoTest;

public class CustomTestWithLotsOfAnnotationDoAfterAll {
    @DoBeforeAll()
    public int customMethodDoBeforeAll() {
        return -1000;
    }

    @DoAfterAll()
    public int customTest1() {
        return 10;
    }

    @DoTest(order = 1)
    public int customTest2() {
        return 20;
    }

    @DoTest(order = 2)
    public int customTest3() {
        return 30;
    }

    @DoAfterAll()
    public int customMethodDoAfterAll() {
        return 1000;
    }
}
