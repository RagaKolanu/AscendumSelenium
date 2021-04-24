package com.ascendum.lopal.pageActions;

import com.ascendum.lopal.base.BaseActions;
import com.ascendum.lopal.base.ExcelOperations;
import com.ascendum.lopal.base.Getter_Setter;
import com.ascendum.lopal.base.TestBase;
import com.ascendum.lopal.pageLocators.Google;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoogleSearch extends TestBase {

    BaseActions baseActions = new BaseActions();
    Google googleLocators = new Google();
    ExcelOperations excelOperations = new ExcelOperations();
    Getter_Setter testdata = new Getter_Setter();
    ArrayList<String> Websites = new ArrayList<>();

    public GoogleSearch() throws IOException {
    }
    @Test(priority = 2)
    public void performGoogleSearch(){

        for(String str:Websites) {
            WebElement searchTextbox = driver.findElement(googleLocators.searchTextBox);
            searchTextbox.sendKeys(testdata.getLO_Name()+ " NMLS "+testdata.getLO_NMLS()+" "+str);
            WebElement searchButton = driver.findElement(googleLocators.searchButton);
            searchButton.click();

            //Get list of web-elements with text containing desired website name
            int noOfLinks = driver.findElements(By.xpath("//a[contains(text(),'www."+str.toLowerCase()+".com')]")).size();
            log.info("Found "+noOfLinks+" matching links");

            if(noOfLinks>0){

                String[] LoNames = testdata.getLO_Name().split(" ");
                boolean booName = false;
                boolean booNmls = false;
                boolean missingInfo = false;
                for(int i=1;i<=noOfLinks;i++) {
                    WebElement container = driver.findElement(By.xpath("//div[@class='g'][" + i + "]"));
                    String strtext = container.getText();
                    log.info(strtext);
                    if (strtext.toLowerCase().contains(str.toLowerCase())) {
                        if (strtext.contains("Missing:")) {
                            String missingText = strtext.substring(strtext.indexOf("Missing:"), strtext.length());
                            if (missingText.contains(testdata.getLO_NMLS())) {
                                log.info(missingText);
                            } else {
                                for (String name : LoNames) {
                                    if (strtext.toLowerCase().contains(name.toLowerCase())) {
                                        booName = true;
                                    }
                                }
                                if (strtext.toLowerCase().contains(testdata.getLO_NMLS())) {
                                    booNmls = true;
                                }
                            }
                            if (booName == true && booNmls == true) {
                                WebElement desiredLink = driver.findElement(googleLocators.link);
                                desiredLink.click();
                                break;
                            }
                        }else {
                            for (String name : LoNames) {
                                if (strtext.toLowerCase().contains(name.toLowerCase())) {
                                    booName = true;
                                }
                            }
                            if (strtext.toLowerCase().contains(testdata.getLO_NMLS())) {
                                booNmls = true;
                            }
                        }
                        if (booName == true && booNmls == true) {
                            WebElement desiredLink = driver.findElement(googleLocators.link);
                            desiredLink.click();
                            break;
                        }
                    }
                }
            }else {
                log.info("No matching search results found for "+ testdata.getLO_NMLS() +" in "+str);
            }
        }

    }
    @Test(priority = 0)
    public void getLoanOfficerDetailsFromExcel(){
        testdata.setLO_NMLS(excelOperations.readDataFromExcel(3,0));
        testdata.setLO_Name(excelOperations.readDataFromExcel(3,1));
        testdata.setLO_StreetAddress(excelOperations.readDataFromExcel(3, 2));
        testdata.setLO_City(excelOperations.readDataFromExcel(3,3));
        testdata.setLO_State(excelOperations.readDataFromExcel(3,4));
        testdata.setLO_Zipcode(excelOperations.readDataFromExcel(3,5));
    }
    @Test(priority = 1)
    public void websitesToValidate(){
        String strWebsiteVal;
        for(int i=0;i<5;i++) {
            strWebsiteVal = excelOperations.readDataFromExcel(3, i + 7);
            if (strWebsiteVal.equalsIgnoreCase("yes")) {
                Websites.add(excelOperations.readDataFromExcel(0, i + 7));
            }
        }
            for(String str:Websites) {
                log.info("Websites to validate : " + str);
            }

    }
}
