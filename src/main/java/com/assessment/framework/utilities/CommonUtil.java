package com.assessment.framework.utilities;

import com.assessment.framework.base.DriverContext;
import com.assessment.framework.config.Settings;
import cucumber.api.Scenario;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

/**
 * Created by Roberto C. on 05/11/20.
 */
public class CommonUtil {

    private static final Logger logger = Logger.getLogger(CommonUtil.class);
    private static String stringHelper = "";

    public static String getStringHelper() {
        return stringHelper;
    }

    public static void setStringHelper(String helper) {
        stringHelper = helper;
    }

    public static String generateRandomWord() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public static String generateRandomNumber() {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public static boolean isElementEnabled(WebElement welement) {

        try {
            if (welement.isEnabled()) {
                return true;
            }
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }


    }

    public static boolean isElementDisplayed(WebElement webelement) {

        try {
            if (webelement.isDisplayed()) {
                return true;
            }
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }


    }


    public static void deleteAllCookies() {
        DriverContext.Driver.manage().deleteAllCookies();
    }

    public static String randomNumber(int low, int high) {

        Random r = new Random();
        int result = r.nextInt(high - low) + low;
        return result + "";
    }

    public static void embedScreenshot(WebDriver driver, Scenario scenario) {
        try {
            final byte[] byteFile = ((TakesScreenshot) DriverContext.Driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(byteFile, "image/png");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void takeScreenshot(WebDriver driver, Scenario scenario) {

        try {
            File dir = new File(Settings.ScreenPath);
            if (!dir.exists())
                dir.mkdir();
        } catch (Exception e) {
        }

        File scrFile = ((TakesScreenshot) DriverContext.Driver).getScreenshotAs(OutputType.FILE);
        String NewFileNamePath = null;
        File directory = new File(".");

        ZoneId zid = ZoneId.of("America/Lima");
        ZonedDateTime date = ZonedDateTime.now(zid);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String fileNameFormat = date.format(formatter);
        String classAndMethodName = fileNameFormat + "_" + scenario.getId();

        try {
            NewFileNamePath = directory.getCanonicalPath() + File.separator + Settings.ScreenPath + File.separator + classAndMethodName + ".png";
            FileUtils.copyFile(scrFile, new File(NewFileNamePath));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public static String getFeatureName(String id) {
        String[] strName = id.split(";");
        String output = strName[0].substring(0, 1).toUpperCase() + strName[0].substring(1);
        return output.replace('-', ' ');
    }

    public static String getExecutiveTime(long endMillis, long startMillis) {

        long millis = endMillis - startMillis;
        long second = (millis / 1000) % 60;
        long minute = (millis / (1000 * 60)) % 60;
        long hour = (millis / (1000 * 60 * 60)) % 24;

        return String.format("%02d:%02d:%02d:%d", hour, minute, second, millis);
    }

    public static String getConfigDate(String pFormatDate, String time, String... format) {

        ZoneId zid = ZoneId.of("America/Lima");

        if (pFormatDate.length() > 0) {

            ZonedDateTime localDate = null;

            if (time.equals("Initial Time")) {
                if (pFormatDate.equals("NOW")) {
                    localDate = ZonedDateTime.now(zid);
                } else {
                    localDate = ZonedDateTime.now(zid).withHour(0).withMinute(0).withSecond(0);
                }
            } else {
                localDate = ZonedDateTime.now(zid).withHour(23).withMinute(59).withSecond(59);
            }

            //Initial Time
            if (pFormatDate.equals("NOW")) {
                localDate = localDate;
            } else {
                String signal = pFormatDate.substring(3, 4);
                int days = Integer.parseInt(pFormatDate.substring(4));
                if (signal.equals("+")) {
                    localDate = localDate.plusDays(days);
                } else {
                    localDate = localDate.minusDays(days);
                }
            }

            if (format.length > 0) {
                return localDate.format(DateTimeFormatter.ofPattern(format[0]).withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault())); //.toLowerCase()
            }

            int year = localDate.getYear();
            int month = localDate.getMonth().getValue();
            String strMonth = month < 10 ? "0" + month : month + "";
            int day = localDate.getDayOfMonth();
            String strDay = day < 10 ? "0" + day : day + "";

            return strMonth + strDay + year + "";
        }
        return "";
    }

    public static String responseMessage(Response response, int statusExpected) {

        String strMessageError = "Error don't expected";

        if (response.getStatusCode() != statusExpected) {

            if (response.getStatusCode() != 200) {
                String respMsg = response.path("message") != null ? response.path("message").toString() : response.asString();
                strMessageError = response.getStatusCode() != statusExpected ? respMsg : null;
                if (response.contentType().equals("text/html")) {
                    strMessageError = response.htmlPath().get().toString();
                }
            }
        }
        return strMessageError;
    }


    public static void waitForVisibility(WebElement element) {
        new WebDriverWait(DriverContext.Driver, 60).until(ExpectedConditions.visibilityOf(element));
    }

}