package constructorTests;

import edu.praktikum.seleniumTestsClasses.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


import static org.junit.Assert.*;

public class GetSauceNameTest {
    private WebDriver webDriver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage = new MainPage(webDriver);
    }
    @Test
    @DisplayName("Check switching to sauce tab")
    @Description("Проверка переключения на вкладку Соусы")
    public void checkTabName() {
        mainPage.open();
        assertTrue("Неправильный тип ингредиента в вкладке", mainPage.burgerConstructor().checkTransitionToSauce());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
