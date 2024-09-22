package test;

import dane.DaneLogin;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import settings.Konfiguration;

public class FirstTest extends Konfiguration {

    @Test (priority = 1, testName = "firstTestA", groups= {"kat1","kat2"}, description = "Test - Correct login")
    public void firstTestA() {

        DaneLogin dane = new DaneLogin();
        MainPage mp = new MainPage(driver);

        LoginPage lp = new LoginPage(driver);
        lp.loginAuto(dane);
        mp.checkAfterCorrectLogin();
    }

    @Test (priority = 1, testName = "firstTestB", groups= {"kat3"}, description = "Test - Validation for wrong user and password")
    public void firstTestB() {

        LoginPage lp = new LoginPage(driver);
        lp.loginManual("wrong", "wrong");
        lp.checkWrongPasswordErrorMessage();
    }
}
