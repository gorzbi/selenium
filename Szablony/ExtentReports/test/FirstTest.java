package test;

import dane.DaneLogin;
import org.testng.annotations.Test;
import pages.LoginPage;
import settings.Konfiguration;

public class FirstTest extends Konfiguration {

    @Test (priority = 1, testName = "firstTestA", groups= {"kat1","kat2"}, description = "opis1A")
    public void firstTestA() {

        DaneLogin dane = new DaneLogin();

        LoginPage lp = new LoginPage(driver);
        lp.login(dane);
    }

    @Test (priority = 1, testName = "firstTestB", groups= {"kat3"}, description = "opis1B")
    public void firstTestB() {

        DaneLogin dane = new DaneLogin();

        LoginPage lp = new LoginPage(driver);
        lp.login(dane);
    }
}
