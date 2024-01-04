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
    private final By tabCurrentType = By.xpath(".//*['tab_tab_type_current__2BEPc']");

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
    @Step("Показан флекс по выбранному типу ингредиента")
    public boolean currentTypeFlex() {
        WebElement element = webDriver.findElement(tabCurrentType);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        return webDriver.findElements(tabCurrentType).size() > 0;
    }
}
