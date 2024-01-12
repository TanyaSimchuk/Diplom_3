package edu.praktikum.seleniumTestsClasses;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BurgerConstructor {
    private final WebDriver webDriver;
    private final By bunType = By.xpath(".//div[1]['tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    private final By sauceType = By.xpath(".//div[2]['tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    private final By fillingType = By.xpath(".//div[3]['tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    public BurgerConstructor (WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Нажать на вкладку Соусы")
    public void clickSauceButton() {
        webDriver.findElement(sauceType).click();
    }
    @Step("Нажать на вкладку Начинки")
    public void clickFillingButton() {
        webDriver.findElement(fillingType).click();
    }
    @Step("Нажать на вкладку Булки")
    public void clickBunsButton() {
        webDriver.findElement(bunType).click();
    }
    @Step("Проверка что переключились на вкладку Соусы")
    public Boolean checkTransitionToSauce(){
        WebElement sauceTab = webDriver.findElement(sauceType);
        String activeFlex = sauceTab.getAttribute("class");
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.attributeToBe(sauceType, "class", activeFlex));
    }
    @Step("Проверка что переключились на вкладку Булки")
    public Boolean checkTransitionToBuns(){
        WebElement bunsTab = webDriver.findElement(bunType);
        String activeFlex = bunsTab.getAttribute("class");
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.attributeToBe(bunType, "class", activeFlex));
    }
    @Step("Проверка что переключились на вкладку Начинки")
    public Boolean checkTransitionToFillings(){
        WebElement sauceTab = webDriver.findElement(fillingType);
        String activeFlex = sauceTab.getAttribute("class");
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        return wait.until(ExpectedConditions.attributeToBe(fillingType, "class", activeFlex));
    }
}