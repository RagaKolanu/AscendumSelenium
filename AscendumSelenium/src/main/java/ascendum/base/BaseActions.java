package ascendum.base;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;


public class BaseActions extends TestBase {

    String url = "";
    String homePage = "https://ascendum.com";
    String link = "";


    // Verify if the element is present and prints the text of the element accordingly
    public void checkIfWebElementIsPresent(By locator) {
        WebElement element = driver.findElement(locator);
        final Boolean checkElementPresent = element.isDisplayed();
        if (checkElementPresent.equals(true)) {
            System.out.println("The webelement : " + retrieveText(locator) + " is present on the web page.");
        } else {
            System.out.println("The welelment : " + "" + retrieveText(locator) + "\""
                    + " is miising - There might be some error in loading of the page. Please refresh and try again.");
        }
    }

    //Method to get all the anchor tags in a list
    public void checkAllAnchorTags() {
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = allLinks.iterator();
        while (it.hasNext()) {

            url = it.next().getAttribute("href");
            if (url == null || url.equals("")) {
                continue;
            }

            if (!url.startsWith(homePage)) {
                System.out.println(url + " - URL belongs to another domain. Hence, skipping it.");
                System.out.println("*************************************************************");
                continue;
            }

            validateUrl(url);
        }
    }

    // verify if the url is valid or broken
    public void validateUrl(String link) {
        try {
            URL url = new URL(link);

            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setConnectTimeout(2000);
            httpConn.connect();

            if (httpConn.getResponseCode() == 200) {
                System.out.println();
            }

            this.checkFor200Status(httpConn.getResponseCode());

            if (httpConn.getResponseCode() >= 300) {
                System.out.println(link + " - " + httpConn.getResponseMessage() + ". The URL is being redirected");
            }

            if (httpConn.getResponseCode() >= 400) {
                System.out.println(link + " - " + httpConn.getResponseMessage() + ". The URL is either broken or not configured");
            }

            if (httpConn.getResponseCode() >= 500) {
                System.out.println(link + " - " + httpConn.getResponseMessage() + ". There are server errors");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Method to validate the http - status code
    public void checkFor200Status(int statusCode) {
        switch (statusCode) {
            case 201: {
                System.out.println(link + " - Created");
            }
            case 202: {
                System.out.println(link + " - Accepted");
            }
            case 203: {
                System.out.println(link + " - Non-Authoritative Information");
            }
            case 204: {
                System.out.println(link + " - No Content");
            }
            case 205: {
                System.out.println(link + " - Reset Content");
            }
            case 206: {
                System.out.println(link + " - Partial Content");
            }
            case 207: {
                System.out.println(link + " - Multi Status (WebDAV)");
            }
            case 208: {
                System.out.println(link + " - Non-Authoritative Information (WebDAV)");
            }
            case 226: {
                System.out.println(link + " - IM Used");
            }
        }

    }

    // Method to fetch the retrieved text
    public String retrieveText(By locator) {
        WebElement element = driver.findElement(locator);
        final String elementText = element.getText();
        return elementText;
    }

    //Method to enter text in the search text box
    public String searchText(By locator, String enterText) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(enterText);
        return enterText;
    }

    //Method to click on an elemenet based on the element locator
    public void clickLinksAndButtons(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    // Method to validate the search results (if entered text and retrieved text are same)
    public void retrievedSearchResults(By locator, String searchText) {
        WebElement element = driver.findElement(locator);
        String retrievedText = element.getText();
        String s = StringUtils.substringBetween(retrievedText, "'", "'");
        String expected = searchText;
        Assert.assertEquals(expected, s);
    }

    //Mouse over on the webelement
    public void mousehover(By locator)
    {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

}
