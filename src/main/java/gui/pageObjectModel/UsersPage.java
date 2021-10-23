package gui.pageObjectModel;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersPage {

    //****** variables ******//
    private WebDriver driver;

    //****** constructor ******//
    public UsersPage(WebDriver driver) {
        this.driver = driver;
    }

    //****** locators ******//
    private static By addUser_button_locator() {
        return By.id("btnAdd");
    }

    private static By userName_textField_locator() {
        return By.id("searchSystemUser_userName");
    }

    private static By userRole_dropDown_locator() {
        return By.id("searchSystemUser_userType");
    }

    private static By employeeName_textField_locator() {
        return By.id("searchSystemUser_employeeName_empName");
    }

    private static By status_dropDown_locator() {
        return By.id("searchSystemUser_status");
    }

    private static By search_button_locator() {
        return By.id("searchBtn");
    }

    private static By searchResults_tableRow_locator(String userName) {
        return By.xpath("//tr[contains(.,'" + userName + "')]/td[2]/a");
    }

    //****** keywords ******//
    /**
     * open add user page by clicking add button
     *
     * @return self-reference for method chaining
     */
    public AddUserPage openAddUserPage() {
        (new ElementActions(driver))
                .click(addUser_button_locator());
        return new AddUserPage(driver);
    }

    /**
     * search for specific user by filling all fields' data and clicking the search button
     *
     * @param userName
     * @param userRole
     * @param employeeName
     * @param status
     * @return self-reference for method chaining
     */
    public UsersPage searchForUser(String userName, AddUserPage.userRoleEnum userRole, String employeeName, AddUserPage.statusEnum status) {
        (new ElementActions(driver))
                .type(userName_textField_locator(), userName)
                .select(userRole_dropDown_locator(), String.valueOf(userRole))
                .type(employeeName_textField_locator(), employeeName)
                .select(status_dropDown_locator(), String.valueOf(status))
                .click(search_button_locator());
        return new UsersPage(driver);
    }

    /**
     * open user's details page by clicking the userName from the users' list
     *
     * @param userName
     * @return self-reference for method chaining
     */
    public UserDetailsPage openUserDetailsPage(String userName) {
        (new ElementActions(driver))
                .click(searchResults_tableRow_locator(userName));
        return new UserDetailsPage(driver);
    }
}
