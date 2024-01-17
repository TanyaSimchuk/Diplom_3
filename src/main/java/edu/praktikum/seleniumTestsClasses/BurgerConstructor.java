package edu.praktikum.seleniumTestsClasses;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;

public class BurgerConstructor {
    private final WebDriver webDriver;
    private final By bunType = By.xpath(".//section/*/div[1]['tab_tab__1SPyG']");
    private final By sauceType = By.xpath(".//section/*/div[2]['tab_tab__1SPyG']");
    private final By fillingType = By.xpath(".//section/*/div[3]['tab_tab__1SPyG']");
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
    public boolean checkTransitionToSauce(){
        WebElement sauceTab = webDriver.findElement(sauceType);
        clickSauceButton();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(attributeContains(sauceTab, "class", "current"));
        return sauceTab.getAttribute("class").contains("current");
    }
    @Step("Проверка что переключились на вкладку Начинки")
    public boolean checkTransitionToFillings(){
        WebElement fillingTab = webDriver.findElement(fillingType);
        clickFillingButton();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(attributeContains(fillingTab, "class", "current"));
        return fillingTab.getAttribute("class").contains("current");
    }
    @Step("Проверка что переключись на вкладку Соусы и обратно на вкладку Булки")
    public boolean checkTransitionToBuns() {
        WebElement bunsTab = webDriver.findElement(bunType);
        attributeContains(bunsTab, "class", "current");
        clickSauceButton();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(not(attributeContains(bunsTab, "class", "current")));
        clickBunsButton();
        wait.until(attributeContains(bunsTab, "class", "current"));
        return bunsTab.getAttribute("class").contains("current");
    }
}