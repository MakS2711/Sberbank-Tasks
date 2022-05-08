package dorofeev.factory.impl;

import dorofeev.factory.interf.Guard;

public class BankingGuard implements Guard {
    @Override
    public void toGuard() {
        System.out.println("Performs the guard's work");
    }
}
