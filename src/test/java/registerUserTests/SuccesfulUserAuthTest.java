package registerUserTests;

import edu.praktikum.seleniumTestsClasses.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class SuccesfulUserAuthTest {
    private WebDriver webDriver;
    private MainPage mainPage;
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage = new MainPage(webDriver);
        RestAssured.baseURI = BASE_URL;
    }
//Авторизация через кнопку Личный кабинет и корректными данными
    @Test
    @DisplayName("Check registration with right data user")
    @Description("Проверка регистрации юзера через кнопку Личный кабинет с корректными данными")
    public void checkPositiveUserCreateCheckList() {
        mainPage.userClient().create(mainPage.userCreate());
        String name = mainPage.userCreate().getName();
        String email = mainPage.userCreate().getEmail();
        String password = mainPage.userCreate().getPassword();

        mainPage.open()
                .userRegistration().clickPersonalCabinet()
                .clickAuthFormButton()
                .inputName(name)
                .inputEmail(email)
                .inputPassword(password)
                .clickAuthSubmitButton();

        assertTrue("Не показана форма авторизации после регистрации юзера", mainPage.userRegistration().checkLoginFormIsVisible());
    }

    @After
    public void tearDown() {
        webDriver.quit();

        mainPage.userClient().create(mainPage.userCreate());
        String token = mainPage.userClient().loginUser(mainPage.userCreate()).path("accessToken");
        int Response = mainPage.userClient().loginUser(mainPage.userCreate()).statusCode();
        if (Response == HttpStatus.SC_OK) {
            mainPage.userClient().deleteByToken(token);
        }
    }

}
