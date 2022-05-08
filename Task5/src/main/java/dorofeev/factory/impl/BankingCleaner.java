package dorofeev.factory.impl;

import dorofeev.factory.interf.Cleaner;

public class BankingCleaner implements Cleaner {
    @Override
    public void doCleaning() {
        System.out.println("Performs the work of a cleaner");
    }
}
