package gui.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserDetailsPage {

    //****** variables ******//
    private WebDriver driver;

    //****** constructor ******//
    public UserDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    //****** locators ******//
    public static By userType_dropDown_locator(){ return By.id("systemUser_userType"); }
    public static By employeeName_text_locator(){ return By.id("systemUser_employeeName_empName"); }
    public static By userName_text_locator(){ return By.id("systemUser_userName"); }
    public static By status_dropDown_locator(){ return By.id("systemUser_status"); }

    //****** keywords ******//

}
