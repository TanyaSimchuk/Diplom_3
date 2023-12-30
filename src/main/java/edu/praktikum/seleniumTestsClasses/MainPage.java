package edu.praktikum.seleniumTestsClasses;

import edu.praktikum.apiUserProfile.UserClient;
import edu.praktikum.apiUserProfile.UserCreate;
import edu.praktikum.apiUserProfile.TestUser;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    private final WebDriver webDriver;
    private final UserRegistration userRegistration;
    private final UserLogin userLogin;
    private final UserAuthorized userAuthorized;
    private final BurgerConstructor burgerConstructor;
    private final UserCreate userCreate;
    private final UserClient userClient;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        userRegistration = new UserRegistration(webDriver);
        userLogin = new UserLogin(webDriver);
        userAuthorized = new UserAuthorized(webDriver);
        burgerConstructor = new BurgerConstructor(webDriver);
        userCreate = TestUser.testUserCreate();
        userClient = new UserClient();
}
    public MainPage open() {
        webDriver.get(URL);
        return this;
    }
    public UserRegistration userRegistration() {
    return userRegistration;
    }
    public UserLogin userLogin() {
        return userLogin;
    }
    public UserAuthorized userAuthorized() {
        return userAuthorized;
    }
    public BurgerConstructor burgerConstructor() {
        return burgerConstructor;
    }
    public UserCreate userCreate() {
        return userCreate;
    }
    public UserClient userClient() {
        return userClient;
    }
}