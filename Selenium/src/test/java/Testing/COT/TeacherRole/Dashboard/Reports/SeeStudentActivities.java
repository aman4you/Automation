package Testing.COT.TeacherRole.Dashboard.Reports;

/**
 * Created by om on 11/12/2014.
 */
import java.util.concurrent.TimeUnit;

import Testing.COT.COTFunctions;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeeStudentActivities {
    COTFunctions func;
    private WebDriver driver;
    private WebDriverWait wait;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        func = new COTFunctions(driver);
        wait = new WebDriverWait(driver, func.timeoutOfOneElement);
        driver.manage().timeouts().implicitlyWait(func.timeoutOFAllElement, TimeUnit.SECONDS);

        driver.get(func.baseUrl + "/");
        func.CheckLogin();
        func.LoginRole("Teacher");
        driver.get(func.baseUrl + "/teacher-reports");
    }

    @Test
    public void testSeeStudentActivities() throws Exception {
        // Click Student Activities
        driver.findElement(By.linkText("Student Activities")).click();

        // Enter Name
        driver.findElement(By.id("edit-combine-1")).clear();
        driver.findElement(By.id("edit-combine-1")).sendKeys("paul");
        // Click Search
        driver.findElement(By.id("edit-submit-administration-students")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ajax-progress-throbber")));
        // Enter Name
        driver.findElement(By.id("edit-combine-1")).clear();
        driver.findElement(By.id("edit-combine-1")).sendKeys("shar");
        // Click Search
        driver.findElement(By.id("edit-submit-administration-students")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ajax-progress-throbber")));
        // Enter Name
        driver.findElement(By.id("edit-combine-1")).clear();
        driver.findElement(By.id("edit-combine-1")).sendKeys("shar pau");
        // Click Search
        driver.findElement(By.id("edit-submit-administration-students")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ajax-progress-throbber")));
        // Enter Name
        driver.findElement(By.id("edit-combine-1")).clear();
        driver.findElement(By.id("edit-combine-1")).sendKeys("shar pal");
        // Click Search
        driver.findElement(By.id("edit-submit-administration-students")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ajax-progress-throbber")));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

