package test;

import org.testng.annotations.Test;
import pages.LoginPage;
import settings.Konfiguration;

public class SecondTest extends Konfiguration {

    @Test (priority = 1, testName = "secondTestA", groups= {"kat2","kat3"}, description = "Test - validation for blocked user")
    public void secondTestA() {

        LoginPage lp = new LoginPage(driver);

        lp.loginManual("locked_out_user", "secret_sauce");
        lp.checkBlockedErrorMessage();

    }

    @Test (priority = 1, testName = "secondTestB", groups= {"kat2"}, description = "Test failed - no such element")
    public void secondTestB() {

        LoginPage lp = new LoginPage(driver);
        lp.error();

    }
}