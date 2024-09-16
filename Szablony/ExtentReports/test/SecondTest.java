package test;

import dane.DaneLogin;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import settings.Konfiguration;

public class SecondTest extends Konfiguration {

    @Test (priority = 1, testName = "secondTestA", groups= {"kat2","kat3"})
    public void secondTestA() {

        DaneLogin dane = new DaneLogin();

        LoginPage lp = new LoginPage(driver);
        lp.login(dane);

    }

    @Test (priority = 1, testName = "secondTestB", groups= {"kat2"})
    public void secondTestB() {

        DaneLogin dane = new DaneLogin();

        LoginPage lp = new LoginPage(driver);
        lp.error();

    }
}
