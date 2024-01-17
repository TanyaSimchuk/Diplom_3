package edu.praktikum.seleniumTestsClasses;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegistration {
    private final WebDriver webDriver;
    private final By personalCabinet = By.xpath(".//*[@href='/account']");
    private final By authButtonWithScroll = By.xpath(".//*[@href='/register']");
    private final By inputNameField = By.xpath(".//fieldset[1]/.//*['Имя']/input");
    private final By inputEmailField = By.xpath(".//fieldset[2]/.//*['Email']/input");
    private final By inputPasswordField = By.xpath(".//fieldset[3]/.//*['Пароль']/input");
    private final By authSubmitButton = By.xpath(".//*['Зарегистрироваться']/button");
    private final By loginForm = By.xpath(".//*['Вход']");
    private final By enterAccountButton = By.xpath(".//*['Войти в аккаунт']/button");
    private final By mistakeInfo = By.xpath(".//*['Некорректный пароль']");

    public UserRegistration(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Нажать на Личный кабинет")
    public UserRegistration clickPersonalCabinet() {
        webDriver.findElement(personalCabinet).click();
        return this;
    }
    @Step("Нажать кнопку Зарегистрироваться")
    public UserRegistration clickAuthFormButton() {
        WebElement element = webDriver.findElement(authButtonWithScroll);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        webDriver.findElement(authButtonWithScroll).click();
        return this;
    }
    @Step("Ввести имя")
    public UserRegistration inputName(String name) {
        webDriver.findElement(inputNameField).click();
        webDriver.findElement(inputNameField).sendKeys(name);
        return this;
    }
    @Step("Ввести электронную почту")
    public UserRegistration inputEmail(String email) {
        webDriver.findElement(inputEmailField).click();
        webDriver.findElement(inputEmailField).sendKeys(email);
        return this;
    }
    @Step("Ввести пароль")
    public UserRegistration inputPassword(String password) {
        webDriver.findElement(inputPasswordField).click();
        webDriver.findElement(inputPasswordField).sendKeys(password);
        return this;
    }
    @Step("Нажать кнопку Зарегистрироваться")
    public UserRegistration clickAuthSubmitButton() {
        webDriver.findElement(authSubmitButton).click();
        return this;
    }
    @Step("Форма авторизации видна")
    public boolean checkLoginFormIsVisible() {
        return webDriver.findElements(loginForm).size() > 0;
    }
    @Step("Нажать кнопку Войти в аккаунт")
    public UserRegistration clickEnterAccountButton() {
        WebElement element = webDriver.findElement(enterAccountButton);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        webDriver.findElement(enterAccountButton).click();
        return this;
    }
    @Step("Сообщение о некорректном пароле показано")
    public boolean mistakeInfoIsVisible() {
        return webDriver.findElements(mistakeInfo).size() > 0;
    }

}
