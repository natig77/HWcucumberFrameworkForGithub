package steps;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;

public class PageInitializer {
    public static LoginPage login;
    public static DashboardPage dash;
    public static AddEmployeePage addEmployeePage;

    public static void initializePageObjects(){
        login=new LoginPage();
        dash = new DashboardPage();
        addEmployeePage=new AddEmployeePage();
    }
}
