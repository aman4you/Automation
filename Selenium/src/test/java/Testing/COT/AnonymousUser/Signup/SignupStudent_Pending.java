package Testing.COT.AnonymousUser.Signup;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SignupStudent_Pending {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://collegeontrackdev.prod.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSignupStudent() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("SIGN UP")).click();
        driver.findElement(By.id("edit-lookup")).clear();
        driver.findElement(By.id("edit-lookup")).sendKeys("282010");
        driver.findElement(By.id("edit-lookup-submit")).click();
        driver.findElement(By.id("edit-student-student-id")).clear();
        driver.findElement(By.id("edit-student-student-id")).sendKeys("900099");
        driver.findElement(By.id("edit-student-last-name")).clear();
        driver.findElement(By.id("edit-student-last-name")).sendKeys("Sharma");
        driver.findElement(By.id("edit-student-email-address")).clear();
        driver.findElement(By.id("edit-student-email-address")).sendKeys("basant.sharma@gmail.com");
        driver.findElement(By.id("edit-student-password-pass1")).clear();
        driver.findElement(By.id("edit-student-password-pass1")).sendKeys("password");
        driver.findElement(By.id("edit-student-password-pass2")).clear();
        driver.findElement(By.id("edit-student-password-pass2")).sendKeys("password");
        driver.findElement(By.id("edit-gender-male")).click();
        driver.findElement(By.id("edit-ethnicity-unknown")).click();
        driver.findElement(By.id("edit-race-white")).click();
        driver.findElement(By.id("edit-student-submit")).click();
        driver.findElement(By.id("edit-legal-accept")).click();
        driver.findElement(By.id("edit-save")).click();
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
