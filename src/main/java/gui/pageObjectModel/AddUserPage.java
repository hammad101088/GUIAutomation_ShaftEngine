package gui.pageObjectModel;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUserPage {
    //****** variables ******//
    private WebDriver driver;

    //****** constructor ******//
    public AddUserPage(WebDriver driver) {
        this.driver = driver;
    }

    //****** enums ******//
    public static enum userRoleEnum{
        Admin,ESS
    }
    public static enum statusEnum{
        Enabled,Disabled
    }

    //****** locators ******//
    private static By userRole_dropDown_locator(){ return By.id("systemUser_userType");}
    private static By employeeName_textField_locator(){ return By.id("systemUser_employeeName_empName"); }
    private static By userName_textField_locator(){ return By.id("systemUser_userName"); }
    private static By status_dropDown_locator(){ return By.id("systemUser_status"); }
    private static By password_textField_locator(){ return By.id("systemUser_password"); }
    private static By confirmPassword_textField_locator(){ return By.id("systemUser_confirmPassword"); }
    private static By save_button_locator(){ return By.id("btnSave"); }

    //****** keywords ******//
    /**
     * add user
     * @param userRole it's recommended to use it as enum. example "AddUserPage.userRoleEnum.Admin"
     * @param employeeName
     * @param userName
     * @param status it's recommended to use it as enum. example "AddUserPage.statusEnum.Enabled"
     * @param password
     * @param confirmPassword
     * @return self-reference for method chaining
     */
    public UsersPage addUser(userRoleEnum userRole, String employeeName, String userName, statusEnum status, String password, String confirmPassword){
        (new ElementActions(driver))
                .select(userRole_dropDown_locator(), String.valueOf(userRole))
                .type(employeeName_textField_locator(),employeeName)
                .type(userName_textField_locator(),userName)
                .select(status_dropDown_locator(), String.valueOf(status))
                .type(password_textField_locator(),password)
                .type(confirmPassword_textField_locator(),confirmPassword)
                .click(save_button_locator());

        return new UsersPage(driver);
    }
}
