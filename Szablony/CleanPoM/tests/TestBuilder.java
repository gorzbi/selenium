package tests;

import data.LoginDataBuilder;
import org.testng.annotations.Test;
import pages.LoginPageBuilder;
import pages.MainPage;
import settings.Configuration;

public class TestBuilder extends Configuration {

    // https://www.saucedemo.com/

    @Test(priority = 1, testName = "firstTestC-ok", groups= {"kat3"}, description = "Test - testing builder")
    public void firstTestC() {

        LoginPageBuilder lpb = new LoginPageBuilder(driver);

        // wykorzystanie bulider() z klasy Data zamiast konstruktorów, gdzie sami wybieramy jakie pola nas interesują w danym teście

        LoginDataBuilder d = LoginDataBuilder.builder()
                .username("standard_user")
                .password("secret_sauce")
                .build();

        lpb.login(d);

        MainPage mp = new MainPage(driver);
        mp.checkAfterCorrectLogin();
    }

    @Test(priority = 1, testName = "secondTestC-wrong", groups= {"kat3"}, description = "Test - testing builder")
    public void secondTestC() {

        LoginPageBuilder lpb = new LoginPageBuilder(driver);

        LoginDataBuilder d = LoginDataBuilder.builder()
                .username("wrong")
                .password("wrong")
                .build();

        lpb.login(d);

        lpb.checkWrongPasswordErrorMessage();
    }

    @Test(priority = 1, testName = "thirdTestC-blocked", groups= {"kat3"}, description = "Test - testing builder")
    public void thirdTestC() {

        LoginPageBuilder lpb = new LoginPageBuilder(driver);

        LoginDataBuilder d = LoginDataBuilder.builder()
                .username("locked_out_user")
                .password("secret_sauce")
                .build();

        lpb.login(d);

        lpb.checkBlockedErrorMessage();
    }

    @Test(priority = 1, testName = "fourthTestC-emptyUsername", groups= {"kat3"}, description = "Test - testing builder")
    public void fourthTestC() {

        LoginPageBuilder lpb = new LoginPageBuilder(driver);

        LoginDataBuilder d = LoginDataBuilder.builder()
                .password("secret_sauce")
                .build();

        lpb.login(d);

        lpb.checkEmptyUsernameErrorMessage();
    }

    @Test(priority = 1, testName = "fifthTestC-emptyPassword", groups= {"kat3"}, description = "Test - testing builder")
    public void fifthTestC() {

        LoginPageBuilder lpb = new LoginPageBuilder(driver);

        LoginDataBuilder d = LoginDataBuilder.builder()
                .username("secret_sauce")
                .build();

        lpb.login(d);

        lpb.checkEmptyPasswordErrorMessage();
    }

    @Test(priority = 1, testName = "sixthTestC-empty", groups= {"kat3"}, description = "Test - testing builder")
    public void sixthTestC() {

        LoginPageBuilder lpb = new LoginPageBuilder(driver);

        LoginDataBuilder d = LoginDataBuilder.builder()
                .build();

        lpb.login(d);

        lpb.checkEmptyUsernameErrorMessage(); // tu akurat gdy nie ma żadnych danych to jest komunikat o pustym polu username
    }
}