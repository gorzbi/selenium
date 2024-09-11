package test;

import dane.DaneLogin;
import org.testng.annotations.Test;
import pages.LoginPage;
import settings.Konfiguration;

public class FirstTest extends Konfiguration {

    @Test
    public void firstTestA() {

        DaneLogin dane = new DaneLogin();

        LoginPage lp = new LoginPage(driver);
        lp.login(dane);

    }

    @Test
    public void firstTestB() {

        DaneLogin dane = new DaneLogin();

        LoginPage lp = new LoginPage(driver);
        lp.login(dane);

    }
}
