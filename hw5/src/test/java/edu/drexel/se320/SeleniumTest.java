// Based on the example code at http://www.seleniumhq.org/docs/03_webdriver.jsp
package edu.drexel.se320;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SeleniumTest {

    protected final String uiPath = "file:///Users/Tik_Weiying/hw5/web/index.html";

    @Test
    public void testOneItem() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            // Find the + to click to display the form to add a todo
            // Looking up by the id, not the name attribute
            WebElement elt = driver.findElement(By.id("controls1plus"));

            // Click on the [+]
            elt.click();

            // Find the form field
            WebElement input = driver.findElement(By.id("itemtoadd"));

            // Make up a todo
            input.sendKeys("Something to do");

            // Find and click the "Add to list" button
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();

            /* The first element added to the list will have id "item1"
             * Subsequent list items will have IDs item2, item3, etc.
             * Arguably this is too brittle, but rather than forcing you
             * all to become experts on the DOM, you may assume this is done
             * correctly, and/or you're testing this functionality implicitly. */
            WebElement deleteButton = driver.findElement(By.id("button1"));
            deleteButton.click();
            // We use startsWith because getText includes the text of the Delete button
            List<WebElement> li = driver.findElements(By.id("item1"));

            assertEquals(li.size(), 0);
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testDeleteAllItem() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            // Find the + to click to display the form to add a todo
            // Looking up by the id, not the name attribute
            WebElement elt = driver.findElement(By.id("controls1plus"));

            // Click on the [+]
            elt.click();

            // Find the form field
            WebElement input = driver.findElement(By.id("itemtoadd"));

            // Make up a todo
            input.sendKeys("Something to do");

            // Find and click the "Add to list" button
            WebElement add = driver.findElement(By.id("addbutton"));
            add.click();

            input.sendKeys("A second TODO");
            add.click();

            /* The first element added to the list will have id "item1"
             * Subsequent list items will have IDs item2, item3, etc.
             * Arguably this is too brittle, but rather than forcing you
             * all to become experts on the DOM, you may assume this is done
             * correctly, and/or you're testing this functionality implicitly. */
            WebElement delete = driver.findElement(By.id("button1"));
            delete.click();

            WebElement delete2 = driver.findElement(By.id("button2"));
            delete2.click();

            List<WebElement> li = driver.findElements(By.id("item1"));
            // We use startsWith because getText includes the text of the Delete button
            assertEquals(li.size(), 0);
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testDelteItem() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            // Find the + to click to display the form to add a todo
            // Looking up by the id, not the name attribute
            WebElement elt = driver.findElement(By.id("controls1plus"));

            // Click on the [+]
            elt.click();

            // Find the form field
            WebElement input = driver.findElement(By.id("itemtoadd"));

            // Make up a todo
            input.sendKeys("Something to do");

            // Find and click the "Add to list" button
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();

            // Find and click the "Delete" button
            WebElement deleteButton = driver.findElement(By.id("button1"));
            deleteButton.click();

            List<WebElement> li = driver.findElements(By.id("item1"));

            assertEquals(li.size(), 0);

        } finally {
            driver.quit();
        }
    }

    @Test
    public void testControlPlus() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            // Find the + to click to display the form to add a todo
            // Looking up by the id, not the name attribute
            WebElement controlButton = driver.findElement(By.id("controls1plus"));

            // Click on the [+]
            controlButton.click();

            // Find the form field
            WebElement controls1 = driver.findElement(By.id("controls1"));

            assertTrue(controls1.getAttribute("style").contains("block"),
                    "Checking that controls is being displayed");
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testDeleteFirstItem() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            // Find the + to click to display the form to add a todo
            // Looking up by the id, not the name attribute
            WebElement elt = driver.findElement(By.id("controls1plus"));

            // Click on the [+]
            elt.click();

            // Find the form field
            WebElement input = driver.findElement(By.id("itemtoadd"));

            // Make up a todo
            input.sendKeys("Something to do");

            // Find and click the "Add to list" button
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();

            /* The first element added to the list will have id "item1"
             * Subsequent list items will have IDs item2, item3, etc.
             * Arguably this is too brittle, but rather than forcing you
             * all to become experts on the DOM, you may assume this is done
             * correctly, and/or you're testing this functionality implicitly. */
            WebElement delete = driver.findElement(By.id("button1"));
            delete.click();

            List<WebElement> li = driver.findElements(By.id("item1"));
            // We use startsWith because getText includes the text of the Delete button
            assertEquals(li.size(), 0);

        } finally {
            driver.quit();
        }
    }

    @Test
    public void testDeleteSecondItem() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            // Find the + to click to display the form to add a todo
            // Looking up by the id, not the name attribute
            WebElement elt = driver.findElement(By.id("controls1plus"));

            // Click on the [+]
            elt.click();

            // Find the form field
            WebElement input = driver.findElement(By.id("itemtoadd"));

            // Make up a todo
            input.sendKeys("Something to do");

            // Find and click the "Add to list" button
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();

            // Make up a todo 2
            input.clear();
            input.sendKeys("Something else to do");
            addButton.click();

            WebElement delete2 = driver.findElement(By.id("button2"));
            delete2.click();

            /* The first element added to the list will have id "item1"
             * Subsequent list items will have IDs item2, item3, etc.
             * Arguably this is too brittle, but rather than forcing you
             * all to become experts on the DOM, you may assume this is done
             * correctly, and/or you're testing this functionality implicitly. */
            WebElement delete = driver.findElement(By.id("item1"));

            // We use startsWith because getText includes the text of the Delete button
            assertTrue(delete.getText().contains("Something to do"), "Checking we didnt find the text");

            assertTrue(driver.findElements( By.id("item2") ).size() == 0,
                    "Checking correct text for added element");

        } finally {
            driver.quit();
        }
    }


}
