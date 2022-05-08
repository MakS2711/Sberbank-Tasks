package dorofeev;

import dorofeev.factory.impl.BankingCompanyFactory;
import dorofeev.factory.interf.*;

public class Task5 {
    public static void main(String[] args) {
        CompanyFactory companyFactory = new BankingCompanyFactory();
        Director director = companyFactory.getDirector();
        Manager manager = companyFactory.getManager();
        Guard guard = companyFactory.getGuard();
        Cleaner cleaner = companyFactory.getCleaner();
        SystemAdministrator systemAdministrator = companyFactory.getSystemAdministrator();

        System.out.println("Banking Company:");
        director.approve();
        manager.toManage();
        systemAdministrator.toFix();
        guard.toGuard();
        cleaner.doCleaning();
    }
}
