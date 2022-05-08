package dorofeev.factory.impl;

import dorofeev.factory.interf.SystemAdministrator;

public class BankingSystemAdministrator implements SystemAdministrator {

    @Override
    public void toFix() {
        System.out.println("Performs the work of the system administrator");
    }
}
