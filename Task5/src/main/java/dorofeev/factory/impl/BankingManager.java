package dorofeev.factory.impl;

import dorofeev.factory.interf.Manager;

public class BankingManager implements Manager {
    @Override
    public void toManage() {
        System.out.println("Performs the manager's work");
    }
}
