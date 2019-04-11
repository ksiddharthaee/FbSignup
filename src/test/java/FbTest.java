import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;


public class FbTest {

    public static String url = "https://www.facebook.com";
    public String id = "u_.*";
    public static WebDriver driver;
    public String idFirstName = "u_0_j";
    public String idSurName = "u_0_r";
    public String idMob = "u_0_u";
    public String idPwd = "u_0_11";
    public String idPhone = "u_0_o";


    @Before

    public void Start(){


       // ChromeDriverManager.getInstance().setup();
        System.setProperty("webdriver.chrome.driver", "/Users/Sid/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void Close(){
        driver.quit();

    }


    /*protected static void clickTextBoxWithText(String buttonText, String x) {
     //   WebDriverWait wait = new WebDriverWait(driver, 45);
       // String buttonXpath =  "//div[input()[contains(.,'"+buttonText+"')]]";
       // String buttonXpath = "//*[@name='"+buttonText+"']";
        String buttonXpath = "//[@id="+"\"u_0_j\"]";
        System.out.println(buttonXpath);
       // String buttonXpath = "//*[@name='+buttonText"
        WebElement element = driver.findElement(By.xpath(buttonXpath));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();


      //  element.click();
      //  element.sendKeys(x);


       // actions.moveToElement(buttonXpath).click().perform();
    }*/

    @Test

    public void url200OKTest() {


        given().when().get(url).then().statusCode(200);
    }


   /* @Test

    public void fbMainPageTest() {
        clickTextBoxWithText("First name", "Kumar");

    }*/


    @Test

    public void validateSignupTest() {
       WebElement element = driver.findElement(By.id(idFirstName));
       element.click();
       element.sendKeys("Kumar");
       String x = element.getText();
       element = driver.findElement(By.id(idSurName));
       element.click();
       element.sendKeys("Siddhartha");
        element = driver.findElement(By.id(idPhone));
        element.click();
        element.sendKeys("0466989947");
       element = driver.findElement(By.id(idPwd));
       element.click();
       element.sendKeys("12345678");
       Select dob = new Select(driver.findElement(By.name("birthday_day")));
       dob.selectByValue("3");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dob = new Select(driver.findElement(By.name("birthday_month")));
        dob.selectByValue("Aug");
        dob = new Select(driver.findElement(By.name("birthday_year")));
        dob.selectByValue("1987");
        List<WebElement> radio1 = driver.findElements(By.name("u_0_a"));
        radio1.get(2).click();
        element = driver.findElement(By.id("u_0_11"));
        element.click();







   }





}
