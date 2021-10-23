package gui.pageObjectModel;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //****** variables ******//
    private final WebDriver driver;
    private final String loginPage_url = "https://opensource-demo.orangehrmlive.com/";

    //****** constructor ******//
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //****** locators ******//
    private static By userName_textField_locator() {
        return By.id("txtUsername");
    }
    private static By password_textField_locator() {
        return By.id("txtPassword");
    }
    private static By login_button_locator() {
        return By.id("btnLogin");
    }

    //****** keywords ******//
    /**
     * navigate to the website URL and open the login page
     * @return self-reference for method chaining
     */
    public LoginPage openTheWebSite() {
        BrowserActions.navigateToURL(driver, loginPage_url);
        return new LoginPage(driver);
    }

    /**
     * login by filling the fields' data and clicking login button
     * @param userName
     * @param password
     * @return self-reference for method chaining
     */
    public HomePage login(String userName, String password) {
        (new ElementActions(driver))
                .type(userName_textField_locator(), userName)
                .type(password_textField_locator(), password)
                .click(login_button_locator());
        return new HomePage(driver);
    }
}
