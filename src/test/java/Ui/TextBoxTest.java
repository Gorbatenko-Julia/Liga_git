package Ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.DrbgParameters;


public class TextBoxTest {

    public WebDriver driver;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkTextBox() {
        driver.get("https://demoqa.com/text-box");

        WebElement userNameInput = driver.findElement(By.xpath("//input[@id='userName']"));
        userNameInput.sendKeys("Julia");

        WebElement userEmailInput = driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmailInput.sendKeys("ellis.tom@internet.ru");

        WebElement currentAddressTextArea = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddressTextArea.sendKeys("Москва");

        WebElement permanentAddressTextArea = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddressTextArea.sendKeys("Брянск");

        WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", button);
        button.click();


        try{
            Thread.sleep(6000);
        }catch(InterruptedException e){
           throw new RuntimeException(e);
        }

        WebElement userNameOutput = driver.findElement(By.xpath("//p[@id='name']"));
        WebElement userEmailOutput = driver.findElement(By.xpath("//p[@id='email']"));
        WebElement currentAddressOutput = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        WebElement permanentAddressOutput = driver.findElement(By.xpath("//p[@id='permanentAddress']"));

        String name = userNameOutput.getText();
String email = userEmailOutput.getText();
String currentAddress = currentAddressOutput.getText();
String permanentAddress = permanentAddressOutput.getText();


        System.out.println("Name: " + name + " , email: " + email + " , current address : " + currentAddress + " , permanent address : " + permanentAddress);

        Assert.assertEquals(email, "Email:ellis.tom@internet.ru");

    }

    @Test
    public void checkTitleTextBox() {
        String pageTitle = driver.getTitle();
        System.out.println("Title : " + pageTitle);
    }


    }
