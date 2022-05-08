package dorofeev.factory.interf;

public interface CompanyFactory {
    Director getDirector();
    Manager getManager();
    Guard getGuard();
    Cleaner getCleaner();
    SystemAdministrator getSystemAdministrator();
}
