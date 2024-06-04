package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * Write the following Test:
 * 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 * 1.1 Mouse hover on “Desktops” Tab and click
 * 1.2 call selectMenu method and pass the menu = “Show All Desktops”
 * 1.3 Verify the text ‘Desktops’
 * 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
 * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
 * 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
 * 2.3 Verify the text ‘Laptops & Notebooks’
 * 3. verifyUserShouldNavigateToComponentsPageSuccessfully()
 * 3.1 Mouse hover on “Components” Tab and click
 * 3.2 call selectMenu method and pass the menu = “Show All Components”
 * 3.3 Verify the text ‘Components’
 */
public class TopMenuTest extends Utility {
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
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        String menuName = "Show AllDesktops";
        // Mouse hover on “Desktops” Tab and click
        mouseHoverOnElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
        // call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu(menuName);
        Thread.sleep(2000);
        String expectedMessage = "Desktops";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Desktops']"));
        // Verify the text ‘Desktops’
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        String menuName = "Show AllLaptops & Notebooks";
        // Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        // call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu(menuName);
        Thread.sleep(2000);
        String expectedMessage = "Laptops & Notebooks";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"));
        // Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals(expectedMessage, actualMessage);


    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        String menuName = "Show AllComponents";
        // Mouse hover on “Components” Tab and click
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Components']"));
        // call selectMenu method and pass the menu = “Show All Components”
        selectMenu(menuName);
        Thread.sleep(2000);
        String expectedMessage = "Components";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Components']"));
        // Verify the text ‘Components’
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        // close all windows
        closeBrowser();
    }
}
