package dorofeev.factory.impl;

import dorofeev.factory.interf.*;

public class BankingCompanyFactory implements CompanyFactory {
    @Override
    public Director getDirector() {
        return new BankingDirector();
    }

    @Override
    public Manager getManager() {
        return new BankingManager();
    }

    @Override
    public Guard getGuard() {
        return new BankingGuard();
    }

    @Override
    public Cleaner getCleaner() {
        return new BankingCleaner();
    }

    @Override
    public SystemAdministrator getSystemAdministrator() {
        return new BankingSystemAdministrator();
    }
}
