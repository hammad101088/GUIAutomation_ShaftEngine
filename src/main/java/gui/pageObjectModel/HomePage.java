package gui.pageObjectModel;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    //****** variables ******//
    private WebDriver driver;

    //****** constructor ******//
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //****** locators ******//
    public static By welcomeText() {
        return By.id("welcome");
    }

    private static By menuItem_adminButton_locator() {
        return By.id("menu_admin_viewAdminModule");
    }

    private static By menuItem_userManagementButton_locator() {
        return By.id("menu_admin_UserManagement");
    }

    private static By menuItem_usersButton_locator() {
        return By.id("menu_admin_viewSystemUsers");
    }

    private static By menuItem_myInfoButton_locator(){ return By.id("menu_pim_viewMyDetails");}

    //****** keywords ******//

    /**
     * open users page by hovering on admin button, user management button, and click on users button
     *
     * @return self-reference for method chaining
     */
    public UsersPage openUsersPage() {
        (new ElementActions(driver))
                .hover(menuItem_adminButton_locator())
                .hover(menuItem_userManagementButton_locator())
                .click(menuItem_usersButton_locator());
        return new UsersPage(driver);
    }
}
