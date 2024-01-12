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

import static org.junit.Assert.assertTrue;

public class GetBunNameTests {
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
    @DisplayName("Check switching to buns tab")
    @Description("Проверка переключения на вкладку Булки")
    public void checkTabName() {
        mainPage.open()
                        .burgerConstructor().clickSauceButton();
        mainPage.burgerConstructor().clickBunsButton();
        assertTrue("Неправильное название типа ингредиента", mainPage.burgerConstructor().checkTransitionToBuns());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
