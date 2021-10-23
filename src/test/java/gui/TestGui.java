package gui;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import gui.pageObjectModel.AddUserPage;
import gui.pageObjectModel.LoginPage;
import gui.pageObjectModel.UserDetailsPage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;

public class TestGui {

    //****** variables ******//
    private WebDriver driver;
    private JSONFileManager jsonFileManager_forTestData;
    Date date = new Date();
    String currentTime_forUniqueFields = date.getTime() + "";

    //****** methods ******//
    @BeforeClass
    public void beforeClass() {
        driver = DriverFactory.getDriver();
        jsonFileManager_forTestData = new JSONFileManager(System.getProperty("testDataFolderPath")+"/guiTestData/addNewUser.json");
    }

    @Test(description = "Test adding a new user using valid data - should be accepted")
    @Description("""
            Steps:
            - open the website
            - login
            - open users page
            - add user
            - search for the added user
            - assert that the data is saved correctly
            """)
    public void TestAddingNewUser_validInputData_shouldBeAccepted() {

        String userName = jsonFileManager_forTestData.getTestData("TestAddingNewUser_validInputData_shouldBeAccepted.addUser.userName") + currentTime_forUniqueFields.substring(4,12);
        (new LoginPage(driver))
                .openTheWebSite()
                .login(
                        jsonFileManager_forTestData.getTestData("TestAddingNewUser_validInputData_shouldBeAccepted.login.userName"),
                        jsonFileManager_forTestData.getTestData("TestAddingNewUser_validInputData_shouldBeAccepted.login.password"))
                .openUsersPage()
                .openAddUserPage()
                .addUser(
                        AddUserPage.userRoleEnum.ESS,
                        jsonFileManager_forTestData.getTestData("TestAddingNewUser_validInputData_shouldBeAccepted.addUser.employeeName"),
                        userName,
                        AddUserPage.statusEnum.Enabled,
                        jsonFileManager_forTestData.getTestData("TestAddingNewUser_validInputData_shouldBeAccepted.addUser.password"),
                        jsonFileManager_forTestData.getTestData("TestAddingNewUser_validInputData_shouldBeAccepted.addUser.confirmPassword"))
                .searchForUser(
                        userName,
                        AddUserPage.userRoleEnum.ESS,
                        jsonFileManager_forTestData.getTestData("TestAddingNewUser_validInputData_shouldBeAccepted.addUser.employeeName"),
                        AddUserPage.statusEnum.Enabled)
                .openUserDetailsPage(
                        userName);

        /*Validations.verifyThat()
                .element(driver, UserDetailsPage.userType_dropDown_locator())
                .text()
                .isEqualTo(AddUserPage.userRoleEnum.ESS)
                .withCustomReportMessage("verify that \"user type\" of the added user is correct")
                .perform();*/

        Validations.verifyThat()
                .element(driver, UserDetailsPage.employeeName_text_locator())
                .text()
                .isEqualTo(
                        jsonFileManager_forTestData.getTestData("TestAddingNewUser_validInputData_shouldBeAccepted.addUser.employeeName"))
                .withCustomReportMessage("verify that \"employee name\" of the added user is correct")
                .perform();

        Validations.verifyThat()
                .element(driver, UserDetailsPage.userName_text_locator())
                .text()
                .isEqualTo(userName)
                .withCustomReportMessage("verify that \"user name\" of the added user is correct")
                .perform();

        /*Validations.assertThat()
                .element(driver, UserDetailsPage.status_dropDown_locator())
                .text()
                .contains(AddUserPage.statusEnum.Enabled)
                .withCustomReportMessage("assert that \"status\" of the added user is correct")
                .perform();*/
    }

    @AfterMethod
    public void afterMethod() {
        BrowserActions.closeCurrentWindow(driver);
    }
}
