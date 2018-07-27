package tatoc1;


import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author neerajsah
 */
public class Pop {
    
    WebDriver driver;
    
    public Pop(WebDriver driver)
    {
      this.driver=driver;
    }
   
    public void popWindow()
    { 
        AssertCheck ac=new AssertCheck(driver);
        FindElement find=new FindElement(driver);
        
        find.findElement("linkText", "Launch Popup Window").click();
//      driver.findElement(By.linkText("Launch Popup Window")).click();

      ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
      driver.switchTo().window(tabs.get(1));
      
      find.findElement("id", "name").sendKeys("Just_Testing");
//      driver.findElement(By.id("name")).sendKeys("Just_Testing");

      find.findElement("id", "submit").click();
//      driver.findElement(By.id("submit")).click();

      driver.switchTo().window(tabs.get(0));
      
      find.findElement("linkText", "Proceed").click();
//      driver.findElement(By.linkText("Proceed")).click();
      
      ac.assertCheck("http://10.0.1.86/tatoc/basic/cookie", "Assert Failed");
     // Assert.assertEquals("http://10.0.1.86/tatoc/basic/cookie",driver.getCurrentUrl(),"Assert Failed");
    }
}
