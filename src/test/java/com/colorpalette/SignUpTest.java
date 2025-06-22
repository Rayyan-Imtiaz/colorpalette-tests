package com.colorpalette;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SignUpTest {

    private WebDriver driver;

    @BeforeAll
    public void setupClass() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testSignUp() {
        driver.get("http://13.53.205.210:3000/sign-up");

        driver.findElement(By.id("name")).sendKeys("Rayyan");
        driver.findElement(By.id("username")).sendKeys("rayyan123");
        driver.findElement(By.id("email")).sendKeys("rayyan123@example.com");
        driver.findElement(By.id("password")).sendKeys("securePass123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("/dashboard"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
