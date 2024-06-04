package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.UUID;

/**
 * 1.1 create method with name "selectMyAccountOptions" it has one parameter name
 * "option" of type string
 * 1.2 This method should click on the options whatever name is passed as parameter.
 * (Hint: Handle List of Element and Select options)
 * <p>
 * Write the following test
 * 1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
 * <p>
 * 1.1 Clickr on My Account Link.
 * 1.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Register”
 * 1.3 Verify the text “Register Account”.
 * <p>
 * 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
 * <p>
 * 2.1 Clickr on My Account Link.
 * 2.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Login”
 * 2.3 Verify the text “Returning Customer”.
 * <p>
 * 3. Test name verifyThatUserRegisterAccountSuccessfully()
 * <p>
 * 3.1 Clickr on My Account Link.
 * 3.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Register”
 * 3.3 Enter First Name
 * 3.4 Enter Last Name
 * 3.5 Enter Email
 * 3.6 Enter Telephone
 * 3.7 Enter Password
 * 3.8 Enter Password Confirm
 * 3.9 Select Subscribe Yes radio button
 * 3.10 Click on Privacy Policy check box
 * 3.11 Click on Continue button
 * 3.12 Verify the message “Your Account Has Been Created!”
 * 3.13 Click on Continue button
 * <p>
 * 3.14 Clickr on My Account Link.
 * 3.15 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Logout”
 * 3.16 Verify the text “Account Logout”
 * 3.17 Click on Continue button
 * <p>
 * 4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
 * <p>
 * 4.1 Clickr on My Account Link.
 * 4.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Login”
 * 4.3 Enter Email address
 * 4.4 Enter Last Name
 * 4.5 Enter Password
 * 4.6 Click on Login button
 * 4.7 Verify text “My Account”
 * 4.8 Clickr on My Account Link.
 * 4.9 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Logout”
 * 4.10 Verify the text “Account Logout”
 * 4.11 Click on Continue button
 */
public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
   String email;

    @Before
    public void setUp() {
        // Open browser and launch url
        openBrowser(baseUrl);
    }
        public void selectMyAccountOptions(String option) {
            clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
            clickOnElement(By.xpath("(//a[normalize-space()='" + option + "'])[1]"));
        }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        String option = "Register";
        //  Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        selectMyAccountOptions(option);
        Thread.sleep(1000);
        // Verify the text “Register Account”.
        String expectedMessage = "Register Account";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Register Account']"));
        Assert.assertEquals(expectedMessage, actualMessage);

    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        String option = "Login";
        // Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions(option);
        Thread.sleep(1000);
        // Verify the text “Returning Customer”.
        String expectedMessage = "Returning Customer";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Returning Customer']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        String name = UUID.randomUUID().toString();
        email = name + "@gmail.com";
        String option = "Register";
        //  Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        selectMyAccountOptions(option);
        Thread.sleep(2000);
        // Enter first name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Prime");
        // Enter Last name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Testing");
        // Enter email
        sendTextToElement(By.xpath("//input[@id='input-email']"), email);
        // Enter mobile number
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "98888888888");
        // Enter password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Admin@123");
        // Enter confirm password
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "Admin@123");
        // Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        // Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        // Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        // Verify the message “Your Account Has Been Created!”
        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        option = "Logout";
        // Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        selectMyAccountOptions(option);
        // Verify the text “Account Logout”
        expectedMessage = "Account Logout";
        actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }
    @After
    public void tearDown() {
        // close all windows
        closeBrowser();
    }

}
