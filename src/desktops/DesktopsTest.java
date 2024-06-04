package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Mouse hover on Desktops Tab.and click
 * 1.2 Click on “Show All Desktops”
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * <p>
 * 2.1 Mouse hover on Currency Dropdown and click
 * 2.2 Mouse hover on £Pound Sterling and click
 * 2.3 Mouse hover on Desktops Tab.
 * 2.4 Click on “Show All Desktops”
 * 2.5 Select Sort By position "Name: A to Z"
 * 2.6 Select product “HP LP3065”
 * 2.7 Verify the Text "HP LP3065"
 * 2.8 Select Delivery Date "2023-11-27"
 * 2.9.Enter Qty "1” using Select class.
 * 2.10 Click on “Add to Cart” button
 * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
 * 2.12 Click on link “shopping cart” display into success message
 * 2.13 Verify the text "Shopping Cart"
 * 2.14 Verify the Product name "HP LP3065"
 * 2.15 Verify the Delivery Date "2023-11-27"
 * 2.16 Verify the Model "Product21"
 * 2.17 Verify the Todat "£74.73"
 */
public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        // Open browser and launch url
        openBrowser(baseUrl);
    }

    // Method is used to select menu
    public void selectMenu(String menu) {
        clickOnElement(By.xpath("//nav[@id='menu']//a[normalize-space()='" + menu + "']"));
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {

        String menuName = "Show AllDesktops";
        // Mouse hover on Desktops Tab.and click
        mouseHoverOnElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
        // Click on “Show All Desktops”
        selectMenu(menuName);

        // before shorting value
        List<WebElement> beforeShortValue = driver.findElements(By.xpath("//div[@class='caption']//h4"));
        List<String> beforeShortDesktopValue = new ArrayList<>();
        for (WebElement value : beforeShortValue) {
            beforeShortDesktopValue.add(value.getText());
        }
        // Select Sort By position "Name: Z to A"
        SelectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");

        Thread.sleep(2000);
        // After shorting value
        List<WebElement> afterShortValue = driver.findElements(By.xpath("//div[@class='caption']//h4"));
        List<String> afterShortDesktopValue = new ArrayList<>();
        Thread.sleep(2000);
        for (WebElement value1 : afterShortValue) {
            afterShortDesktopValue.add(value1.getText());
        }

        Collections.sort(beforeShortDesktopValue, String.CASE_INSENSITIVE_ORDER);// Ascending order

        Collections.reverse(beforeShortDesktopValue); // descending order

        // Verify the Product will arrange in Descending order.
        Assert.assertEquals(beforeShortDesktopValue, afterShortDesktopValue);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Mouse hover on Currency Dropdown and click
        mouseHoverOnElement(By.xpath("//span[normalize-space()='Currency']"));
        //Mouse hover on £Pound Sterling and click
        mouseHoverOnElement(By.xpath("//button[normalize-space()='£Pound Sterling']"));
        String menuName = "Show AllDesktops";
        // Mouse hover on Desktops Tab.and click
        mouseHoverOnElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
        // Click on “Show All Desktops”
        selectMenu(menuName);
        // Select Sort By position "Name: A to Z"
        SelectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        //  Select product “HP LP3065”
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));

        String expectedMessage = "HP LP3065";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='HP LP3065']"));
        //Verify the Text "HP LP3065"
        Assert.assertEquals(expectedMessage, actualMessage);
        // Select Delivery Date "2023-11-27"
        String year = "2023";
        String month = "November";
        String date = "27";
        clickOnElement(By.xpath("//div[@class='input-group date']//button[@type='button']")); // Open the calendar
        while (true) {
            String monthAndYear = getTextFromElement(By.xpath("//div[@class='datepicker-days']//thead//tr[1]"));
            String[] a = monthAndYear.split(" ");
            String mon = a[1];
            String yer = a[2];
            if (mon.equals(month) && yer.equals(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
            }
        }
        // Select the Date
        List<WebElement> allDates = driver.findElements(By.xpath("//td[contains(@class,'day')]"));
        for (WebElement dt : allDates) {
            if (dt.getText().equals(date)) {
                dt.click();
                break;
            }
        }
        // Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        // Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        expectedMessage = "Success: You have added HP LP3065 to your shopping cart!\n";
        actualMessage = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String[] actualmsg = actualMessage.split("×");
        Assert.assertEquals(expectedMessage, actualmsg[0]);
        // Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // Verify the text "Shopping Cart"
        expectedMessage = "Shopping Cart  (1.00kg)";
        actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        //Verify the Product name "HP LP3065"
        expectedMessage = "HP LP3065";
        actualMessage = getTextFromElement(By.xpath("(//a[contains(text(),'HP LP3065')])[2]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Verify the Delivery Date "2023-11-27"
        expectedMessage = "2023-11-27";
        actualMessage = getTextFromElement(By.xpath("(//small)[2]"));
        String[] actualmsg1 = actualMessage.split(":");
        Assert.assertEquals(expectedMessage, actualmsg1[1]);
        // Verify the Model "Product21"
        expectedMessage = "Product 21";
        actualMessage = getTextFromElement(By.xpath("//td[normalize-space()='Product 21']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Verify the Total "£74.73"
        expectedMessage = "£74.73";
        actualMessage = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        // close all windows
        closeBrowser();
    }
}
