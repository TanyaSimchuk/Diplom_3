package edu.praktikum.seleniumTestsClasses;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserLogin {
    private final WebDriver webDriver;
    private final By personalCabinet = By.xpath(".//*[@href='/account']");
    private final By loginButtonMainPage = By.xpath(".//*['Войти в аккаунт']/button");
    private final By loginButtonRegForm = By.xpath(".//*[@href='/login']");
    private final By resetPasswordButton = By.xpath(".//*[@href='/forgot-password']");
    private final By inputEmailField = By.xpath(".//fieldset[1]/.//*['Email']/input");
    private final By inputPasswordField = By.xpath(".//fieldset[2]/.//*['Пароль']/input");
    private final By entranceButton = By.xpath(".//*['Войти']/button");
    private final By createBurgerMenu = By.xpath(".//*['Соберите бургер']");
    private final By authButtonWithScroll = By.xpath(".//*[@href='/register']");

    public UserLogin(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Нажать на кнопку Личный кабинет")
    public UserLogin clickPersonalCabinet() {
        webDriver.findElement(personalCabinet).click();
        return this;
    }
    @Step("Нажать на кнопку Войти в аккаунт")
    public UserLogin clickLoginButtonMagePage() {
        webDriver.findElement(loginButtonMainPage).click();
        return this;
    }
    @Step("Нажать на кнопку Войти в форме регистрации")
    public UserLogin clickLoginButtonRegForm() {
        webDriver.findElement(loginButtonRegForm).click();
        return this;
    }
    @Step("Нажать на кнопку Восстановить пароль")
    public UserLogin clickResetPasswordButton() {
        WebElement element = webDriver.findElement(resetPasswordButton);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        webDriver.findElement(resetPasswordButton).click();
        return this;
    }
    @Step("Ввести электронную почту")
    public UserLogin inputEmail(String email) {
        webDriver.findElement(inputEmailField).sendKeys(email);
        return this;
    }
    @Step("Ввести пароль")
    public UserLogin inputPassword(String password) {
        webDriver.findElement(inputPasswordField).sendKeys(password);
        return this;
    }
    @Step("Нажать на кнопку Войти")
    public UserLogin clickEntranceButton() {
        webDriver.findElement(entranceButton).click();
        return this;
    }
    @Step("Блок Соберите бургер виден")
    public boolean createBurgerFormIsVisible() {
        return webDriver.findElements(createBurgerMenu).size() > 0;
    }
    @Step("Нажать кнопку Зарегистрироваться")
    public UserLogin clickAuthFormButton() {
        WebElement element = webDriver.findElement(authButtonWithScroll);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        webDriver.findElement(authButtonWithScroll).click();
        return this;
    }

}
