package dorofeev.factory.impl;

import dorofeev.factory.interf.Director;

public class BankingDirector implements Director {
    @Override
    public void approve() {
        System.out.println("Performs the work of the director");
    }
}
