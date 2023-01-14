package put.selenium.linear;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import put.selenium.utils.ScreenshotAndQuitOnFailureRule;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


public class AccountsLinearScriptAT {

    private WebDriver driver;
    JavascriptExecutor js;
    private Map<String, Object> vars;
    @Rule
    public ScreenshotAndQuitOnFailureRule screenshotOnFailureAndWebDriverQuitRule =
            new ScreenshotAndQuitOnFailureRule();


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver-win-108.exe");
        this.driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        screenshotOnFailureAndWebDriverQuitRule.setWebDriver(driver);
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
    }

    @Test
    public void successfulUserRegistration() throws Exception {

        // Test name: AT01: Udana rejestracja użytkownika
        // Step # | name | target | value | comment
        // 1 | open | http://localhost:8080/accounts/controller?action=db_reset |  |
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
        // 2 | click | linkText=Register |  |
        driver.findElement(By.linkText("Register")).click();
        // 3 | click | name=username |  |
        driver.findElement(By.name("username")).click();
        // 4 | type | name=username | asd |
        driver.findElement(By.name("username")).sendKeys("asd");
        // 5 | click | css=tr:nth-child(3) > td:nth-child(2) |  |
        driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(2)")).click();
        // 6 | click | name=password |  |
        driver.findElement(By.name("password")).click();
        // 7 | type | name=password | asd |
        driver.findElement(By.name("password")).sendKeys("asd");
        // 8 | click | name=repeat_password |  |
        driver.findElement(By.name("repeat_password")).click();
        // 9 | type | name=repeat_password | asd |
        driver.findElement(By.name("repeat_password")).sendKeys("asd");
        // 10 | click | name=name |  |
        driver.findElement(By.name("name")).click();
        // 11 | type | name=name | asd |
        driver.findElement(By.name("name")).sendKeys("asd");
        // 12 | click | name=addressData |  |
        driver.findElement(By.name("addressData")).click();
        // 13 | type | name=addressData | asd |
        driver.findElement(By.name("addressData")).sendKeys("asd");
        // 14 | click | name=submit |  |
        driver.findElement(By.name("submit")).click();
        // 15 | click | linkText=Login |  |
        driver.findElement(By.linkText("Login")).click();
        // 16 | click | name=username |  |
        driver.findElement(By.name("username")).click();
        // 17 | type | name=username | asd |
        driver.findElement(By.name("username")).sendKeys("asd");
        // 18 | click | name=password |  |
        driver.findElement(By.name("password")).click();
        // 19 | type | name=password | asd |
        driver.findElement(By.name("password")).sendKeys("asd");
        // 20 | click | name=submit |  |
        driver.findElement(By.name("submit")).click();
        // 21 | click | name=submitAdd |  |
        driver.findElement(By.name("submitAdd")).click();
        // 22 | click | css=tr:nth-child(2) > td:nth-child(1) |  |
        driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(1)")).click();
        // 23 | storeText | css=tr:nth-child(2) > td:nth-child(1) | account_number |
        vars.put("account_number", driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(1)")).getText());
        // 24 | click | name=accountDeposit |  |

        String account_number = driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(1)")).getText();
        driver.findElement(By.name("accountDeposit")).click();
        {
            WebElement dropdown = driver.findElement(By.name("accountDeposit"));
            dropdown.findElement(By.xpath("//option[. = '" + account_number + "']")).click();
        }

        // 26 | click | name=accountPayUp |  |
        driver.findElement(By.name("accountPayUp")).click();
        // 27 | select | name=accountPayUp | ${account_number} |
        {
            WebElement dropdown = driver.findElement(By.name("accountPayUp"));
            dropdown.findElement(By.xpath("//option[. = '" + account_number + "']")).click();
        }

        // 28 | click | name=amountPayUp |  |
        driver.findElement(By.name("amountPayUp")).click();
        // 29 | click | name=amountDeposit |  |
        driver.findElement(By.name("amountDeposit")).click();
        // 30 | type | name=amountDeposit | 100 |
        driver.findElement(By.name("amountDeposit")).sendKeys("100");
        // 31 | click | name=submitDeposit |  |
        driver.findElement(By.name("submitDeposit")).click();
        // 32 | click | css=tr:nth-child(2) > td:nth-child(3) |  |
        driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(3)")).click();
        // 33 | click | name=accountPayUp |  |
        driver.findElement(By.name("accountPayUp")).click();
        // 34 | select | name=accountPayUp | ${account_number} |
        {
            WebElement dropdown = driver.findElement(By.name("accountPayUp"));
            dropdown.findElement(By.xpath("//option[. = '" + account_number + "']")).click();
        }
        // 35 | click | name=amountPayUp |  |
        driver.findElement(By.name("amountPayUp")).click();
        // 36 | type | name=amountPayUp | 1 |
        driver.findElement(By.name("amountPayUp")).sendKeys("1");
        // 37 | click | name=submitPayUp |  |
        driver.findElement(By.name("submitPayUp")).click();
        // 38 | click | css=#accounts tr:nth-child(2) |  |
        driver.findElement(By.cssSelector("#accounts tr:nth-child(2)")).click();
        // 39 | close |  |  |
        driver.close();
    }


}
