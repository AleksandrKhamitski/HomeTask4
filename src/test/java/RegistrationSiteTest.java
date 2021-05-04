import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationSiteTest {
    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        Path path = Paths.get("registrationSite.html");
        String pathURL = path.toUri().toString();
        driver.get(pathURL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public  void isTableDisplayed1 () {
        WebElement table = driver.findElement(By.xpath("//table[1]"));
        //find table
        System.out.println("1) " + table.isDisplayed());
        Assert.assertTrue(table.isDisplayed());
    }

    @Test
    public  void isInputDisplayed2 () {
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id=\"fname\"]"));
        //find input
        System.out.println("2) " + firstNameInput.isDisplayed());
        Assert.assertTrue(firstNameInput.isDisplayed());
    }

    @Test
    public  void isCheckboxesDisplayed3 () {
        System.out.print("3) ");
        WebElement checkbox1 = driver.findElement(By.xpath("//form//input[1][@type=\"checkbox\"]"));
        //find checkbox1
        System.out.print(checkbox1.isDisplayed() + " ");
        Assert.assertTrue(checkbox1.isDisplayed());
        WebElement checkbox2 = driver.findElement(By.xpath("//form//input[2][@type=\"checkbox\"]"));
        //find checkbox2
        System.out.print(checkbox2.isDisplayed() + " ");
        Assert.assertTrue(checkbox2.isDisplayed());
        WebElement checkbox3 = driver.findElement(By.xpath("//form//input[3][@type=\"checkbox\"]"));
        //find checkbox3
        System.out.print(checkbox3.isDisplayed() + " ");
        Assert.assertTrue(checkbox3.isDisplayed());
        WebElement checkbox4 = driver.findElement(By.xpath("//form//input[4][@type=\"checkbox\"]"));
        //find checkbox4
        System.out.print(checkbox4.isDisplayed() + " ");
        Assert.assertTrue(checkbox4.isDisplayed());
        System.out.println(" ");
    }

    @Test
    public void isSelectedDisplayed4 () {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id=\"allcountries\"]"));
        dropdown.click();
        //click to dropdown
        boolean found = false;
        //create boolean found
        WebElement elementsOfDropdown = driver.findElement(By.xpath("//select[@id=\"allcountries\"]"));
        Select selectAllElementsOfDropdown = new Select(elementsOfDropdown);
        //select all elements of dropdown
        List<WebElement> allElements = selectAllElementsOfDropdown.getOptions();
        //create list of all elements
        System.out.print("4) ");
        for (int i=0; i<allElements.size(); i++) {
            WebElement tempOption = allElements.get(i);
            String textDropdownOptions = allElements.get(i).getText();
            if (i == 0) {
                System.out.print(" " + i + " " + textDropdownOptions + " " + "-" + " ");
                System.out.print(tempOption.isDisplayed());
                Assert.assertTrue(tempOption.isDisplayed());
            }
            else {
                System.out.print(" " + i + " " + textDropdownOptions + " " + "-" + " ");
                System.out.print(tempOption.isDisplayed());
                Assert.assertTrue(tempOption.isDisplayed());
            }
        }
        System.out.println(" ");
        driver.get("file:///D:/Howe%20work/registrationSite/registrationSite.html");
    }

    @Test
    public void isButtonDisplayed5 () {
        WebElement signUpButton = driver.findElement(By.xpath("//input[@type=\"button\"]"));
        //find sign up button
        System.out.println("5) " + signUpButton.isDisplayed());
        Assert.assertTrue(signUpButton.isDisplayed());
    }

    @Test
    public void isImageDisplayed6 () {
        WebElement image = driver.findElement(By.xpath("//img[1]"));
        //find image
        System.out.println("6) " + image.isDisplayed());
    }

    @Test
    public void isPTextTrue7 () {
        String pText = driver.findElement(By.xpath("//h2[2]")).getText();
        //get text from paragraph
        System.out.println("7) " + pText);
        Assert.assertTrue(pText.contains("Here you can write some information about yourself and sign up!"));
    }

    @Test
    public  void isLinkEnabled8 () throws InterruptedException {
        WebElement link = driver.findElement(By.xpath("//a"));
        //find link
        System.out.println("8) " + link.isDisplayed());
        Assert.assertTrue(link.isEnabled());
//        link.click();
//        Thread.sleep(5000);
//        WebElement image = driver.findElement(By.xpath("//img"));
//        System.out.println("8) " + image.isDisplayed());

        //driver.get("file:///C:/Users/mts/Desktop/Howe%20work/myPage/registrationSite.html");
    }

    @AfterMethod(alwaysRun = true)
    public void startPage () {
        driver.get("file:///D:/Howe%20work/registrationSite/registrationSite.html");
    }

    @AfterTest
    public void quit () {
        //driver.quit();
    }
}
