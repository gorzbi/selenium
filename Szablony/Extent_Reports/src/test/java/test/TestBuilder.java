package tests;

import data.Data;
import org.testng.annotations.Test;
import pages.LoginPageBuilder;
import pages.MainPage;
import settings.Configuration;

public class TestBuilder extends Configuration {

    // https://www.saucedemo.com/


    @Test(priority = 1, testName = "firstTestC-ok", groups= {"kat3"}, description = "Test - testing builder")
    public void firstTestC() {

        // wykorzystanie bulider() z klasy Data zamiast konstruktorów, gdzie sami wybieramy jakie pola nas interesują w danym teście

        Data d = Data.builder()
                .username("standard_user")
                .password("secret_sauce")
                .build();

        new LoginPageBuilder(driver)
                .withData(d)
                .login();  // zero parametrów, czysto i przejrzyście

        MainPage mp = new MainPage(driver);
        mp.checkAfterCorrectLogin();
    }

    @Test(priority = 1, testName = "secondTestC-wrong", groups= {"kat3"}, description = "Test - testing builder")
    public void secondTestC() {

        LoginPageBuilder lpb = new LoginPageBuilder(driver);

        Data d = Data.builder()
                .username("wrong")
                .password("wrong")
                .build();

        new LoginPageBuilder(driver)
                .withData(d)
                .login();

        lpb.checkWrongPasswordErrorMessage();
    }

    @Test(priority = 1, testName = "thirdTestC-blocked", groups= {"kat3"}, description = "Test - testing builder")
    public void thirdTestC() {

        LoginPageBuilder lpb = new LoginPageBuilder(driver);

        Data d = Data.builder()
                .username("locked_out_user")
                .password("secret_sauce")
                .build();

        new LoginPageBuilder(driver)
                .withData(d)
                .login();

        lpb.checkBlockedErrorMessage();
    }

    @Test(priority = 1, testName = "fourthTestC-emptyUsername", groups= {"kat3"}, description = "Test - testing builder")
    public void fourthTestC() {

        LoginPageBuilder lpb = new LoginPageBuilder(driver);

        Data d = Data.builder()
                .password("secret_sauce")
                .build();

        new LoginPageBuilder(driver)
                .withData(d)
                .login();

        lpb.checkEmptyUsernameErrorMessage();
    }

    @Test(priority = 1, testName = "fifthTestC-emptyPassword", groups= {"kat3"}, description = "Test - testing builder")
    public void fifthTestC() {

        LoginPageBuilder lpb = new LoginPageBuilder(driver);

        Data d = Data.builder()
                .username("secret_sauce")
                .build();

        new LoginPageBuilder(driver)
                .withData(d)
                .login();

        lpb.checkEmptyPasswordErrorMessage();
    }

    @Test(priority = 1, testName = "sixthTestC-empty", groups= {"kat3"}, description = "Test - testing builder")
    public void sixthTestC() {

        LoginPageBuilder lpb = new LoginPageBuilder(driver);

        Data d = Data.builder()
                .build();

        new LoginPageBuilder(driver)
                .withData(d)
                .login();

        lpb.checkEmptyUsernameErrorMessage(); // tu akurat gdy nie ma żadnych danych to jest komunikat o pustym polu username
    }
}