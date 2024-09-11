package test;

import dane.DaneLogin;
import org.testng.annotations.Test;
import pages.LoginPage;
import settings.Konfiguration;

public class SecondTest extends Konfiguration {

    @Test
    public void secondTestA() {

        DaneLogin dane = new DaneLogin();

        LoginPage lp = new LoginPage(driver);
        lp.login(dane);

    }

    @Test
    public void secondTestB() {

        DaneLogin dane = new DaneLogin();

        LoginPage lp = new LoginPage(driver);
        lp.login(dane);

    }
}
