package org.amazon;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Amazon {

    //selenium code to get all the available links
    public static void main(String[] args) throws InterruptedException {
        //amazon assignment //Scroll down to  Programs and Features menu after clicking on the hamburger icon
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebElement acctsMenu = driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']"));
        //mouse hover account and lists menu
        Actions action = new Actions(driver);
        action.moveToElement(acctsMenu).build().perform();
        //click on sign in button
        driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']")).click();
        // enter email
        driver.findElement(By.id("ap_email")).sendKeys("rangarajbharathibalaji@gmail.com");
        //click on continue
        driver.findElement(By.id("continue")).click();
        //Enter password
        driver.findElement(By.id("ap_password")).sendKeys("Thavanvishnu400%");
        //click on signin submit button
        driver.findElement(By.id("signInSubmit")).click();
        //click on Hamburger menu
        driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
        Thread.sleep(3000);
        //scroll down to Programs and Features section and click on Gift cards link
        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        //identify element on scroll down
        WebElement giftCards = driver.findElement(By.xpath("//*[@id='hmenu-content']/ul[1]/li[14]/a"));
        String strn = giftCards.getText();
        System.out.println(strn);
        Thread.sleep(2000);
        giftCards.click();
        System.out.println("Gift cards has been clicked successfully");
        Thread.sleep(3000);
        WebElement allGiftCards = driver.findElement(By.linkText("All gift cards"));
        Actions actions = new Actions(driver);
        actions.doubleClick(allGiftCards).perform();
        System.out.println("All Gift cards has been clicked successfully");
        List<WebElement> links
                = driver.findElements(By.tagName("a"));

        // Iterating through all the Links and printing link
        // text
        for (WebElement link : links) {
            System.out.println(link.getText());
        }
        //click Thanks much gift card and add to cart
        WebElement thanksCards = driver.findElement(By.xpath("//*[@id='acsProductBlockV1-2']/a/div[1]/img"));
        Actions actions1 = new Actions(driver);
        actions1.doubleClick(thanksCards).perform();
        System.out.println("Thanks Gift card has been clicked successfully");
        Thread.sleep(3000);
        //select Happy Birthday Gift card and add to card
        WebElement card = driver.findElement(By.xpath("//*[@id='gc-mini-picker-design-swatch-image-12']"));
        card.click();
        System.out.println("Happy Birthday card has been clicked successfully");
        driver.close();
        driver.quit();

    }
}
