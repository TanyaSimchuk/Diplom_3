package edu.praktikum.seleniumTestsClasses;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAuthorized {
    private final WebDriver webDriver;
    private final By constructorButton = By.xpath(".//*['Конструктор']");
    private final By logo = By.xpath(".//*['http://www.w3.org/2000/svg']");
    private final By profileMenu = By.xpath(".//*[@href='/account/profile']");
    private final By exitButton = By.xpath(".//*['Выход']");

    public UserAuthorized(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Нажать на кнопку Конструктор")
    public UserAuthorized clickConstructor() {
        webDriver.findElement(constructorButton).click();
        return this;
    }
    @Step("Нажать на логотип Stellar Burgers")
    public UserAuthorized clickLogo() {
        webDriver.findElement(logo).click();
        return this;
    }
    @Step("Личный кабинет виден")
    public boolean checkProfileMenuIsVisible() {
        return webDriver.findElements(profileMenu).size() > 0;
    }
    @Step("Нажать на кнопку Выход")
    public UserAuthorized clickExitButton() {
        webDriver.findElement(exitButton).click();
        return this;
    }
}
