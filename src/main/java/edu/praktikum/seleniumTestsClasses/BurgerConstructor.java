package edu.praktikum.seleniumTestsClasses;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BurgerConstructor {
    private final WebDriver webDriver;
    private final By sauceType = By.xpath(".//div[2]/*['Соусы']");
    private final By fillingType = By.xpath(".//div[3]/*['Начинки']");
    private final By nameBun = By.xpath(".//h2['Булки']");
    private final By nameSauce = By.xpath(".//h2['Соусы']");
    private final By nameFilling = By.xpath(".//h2['Начинки']");

    public BurgerConstructor(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Нажать на вкладку Соусы")
    public BurgerConstructor clickSauceButton() {
        webDriver.findElement(sauceType).click();
        return this;
    }
    @Step("Нажать на вкладку Начинки")
    public BurgerConstructor clickFillingButton() {
        webDriver.findElement(fillingType).click();
        return this;
    }
    @Step("Блок Булки виден")
    public boolean bunNameIsVisible() {
        WebElement element = webDriver.findElement(nameBun);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        return webDriver.findElements(nameBun).size() > 0;
    }
    @Step("Блок Соусы виден")
    public boolean sauceNameIsVisible() {
        WebElement element = webDriver.findElement(nameSauce);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        return webDriver.findElements(nameSauce).size() > 0;
    }
    @Step("Блок Начинки виден")
    public boolean fillingNameIsVisible() {
        WebElement element = webDriver.findElement(nameFilling);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        return webDriver.findElements(nameFilling).size() > 0;
    }
}
