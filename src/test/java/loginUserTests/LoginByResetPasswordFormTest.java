package loginUserTests;

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

public class LoginByResetPasswordFormTest {
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
    @Test
    @DisplayName("Login user by Login button on Reset password form")
    @Description("Авторизация юзера через кнопку Войти на странице восстановления пароля")
    public void checkLoginByLoginButtonOnResetPasswordForm() {
        mainPage.userClient().create(mainPage.userCreate());
        String email = mainPage.userCreate().getEmail();
        String password = mainPage.userCreate().getPassword();

        mainPage.open()
                .userLogin().clickLoginButtonMagePage()
                .clickResetPasswordButton()
                .clickLoginButtonRegForm()
                .inputEmail(email)
                .inputPassword(password)
                .clickEntranceButton();

        assertTrue("Не показано меню создания бургера", mainPage.userLogin().createBurgerFormIsVisible());
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
