package Ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebFormTest {
    public WebDriver driver;

    //метод для запуска драйвера и передачи настроек
    @BeforeClass//означает что метод выполняется перед классом
    public void set_up() {
        WebDriverManager.chromedriver().setup();//инициализируем драйвер
        ChromeOptions chromeOptions = new ChromeOptions();//новая настройка браузера
        driver = new ChromeDriver(); //присвоила значение в ранее объявленную переменную
        driver.manage().window().maximize();//открытие на весь экран
    }

//    @AfterClass//после запуска класса
//    public void tear_down(){//закрытие странички
//        driver.quit();
//    }


    @Test
    public void authorizationWebForm() {
        //открытие странички в браузере
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        //ввод значения «Text input»
        WebElement textInputWeb = driver.findElement(By.xpath("//input[@id='my-text-id']"));
        textInputWeb.sendKeys("Gorbatenko Julia");

        WebElement passwordWeb = driver.findElement(By.xpath("//input[@type='password']"));
        passwordWeb.sendKeys("123456678");

        WebElement textAreaWeb = driver.findElement(By.xpath("//label[@class='form-label w-100']/textarea"));
        textAreaWeb.sendKeys("Liga");


//        try{
//            Thread.sleep(6000);
//        }catch(InterruptedException e){
//            throw new RuntimeException(e);
//        }


    }

    // «Dropdown select» выбрать значение «two»
    @Test(description = "Выпадающие списки")
    public void dropdownWeb() {
        WebElement dropDownSelect = driver.findElement(By.xpath("//select[@name='my-select']/option[@value='2']"));
        dropDownSelect.click();
    }

    //В поле «Dropdown (datalist)» выбрать значение «Seattle»
    @Test(description = "Выпадающие списки")
    public void dropdownDataListWeb() {
        WebElement dropdownDataList = driver.findElement(By.xpath("//input[@list='my-options']"));
//        input_field = driver.find_element(By.XPATH, "//input[@list='my-options']")
        dropdownDataList.sendKeys("Seattle");
    }

////    отметить чекбокс
//    @Test
//    public void CheckBoxDefaultWeb() {
//        WebElement checkBoxDefault = driver.findElement(By.xpath("//div[@class='form-check']/descendant::input[@id='my-check-2']"));
//        checkBoxDefault.click();
//        // Проверяем, отмечен ли чекбокс
//        boolean isChecked =  checkBoxDefault.isSelected();
//    }

//    Выбрать радиобаттон «Default radio»
//    @Test(description = "Отметить радиобатон 'Default radio')")
//    public void DefaultRadioWeb() {
//        WebElement DefaultRadio = driver.findElement(By.xpath(""));
//        DefaultRadio.click();
//
//    }



    //нажать на кнопку Submit
    @Test
    public void submitWeb() {
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        button.click();

    }

}
