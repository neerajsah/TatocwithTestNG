package tatoc1;


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
public class Frame {
    
    WebDriver driver;
    
    public Frame(WebDriver driver)
    {
      this.driver=driver;
    }
    
    public void frameDungeon()
    {  
        AssertCheck ac=new AssertCheck(driver);
        FindElement find=new FindElement(driver);
        
       driver.switchTo().frame("main");
       
       String box1= find.findElement("id", "answer").getAttribute("class");
//       String box1= driver.findElement(By.id("answer")).getAttribute("class");

       driver.switchTo().frame("child");
       
       String box2= find.findElement("id", "answer").getAttribute("class");
//       String box2= driver.findElement(By.id("answer")).getAttribute("class");

       while(!box1.equals(box2))
        {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("main");
        
        find.findElement("linkText", "Repaint Box 2").click();
//        driver.findElement(By.linkText("Repaint Box 2")).click();

        driver.switchTo().frame("child");
        
        box2= find.findElement("id", "answer").getAttribute("class");
//        box2= driver.findElement(By.id("answer")).getAttribute("class");
        }
        driver.switchTo().defaultContent();
        driver.switchTo().frame("main");
        
        find.findElement("linkText", "Proceed").click();
//        driver.findElement(By.linkText("Proceed")).click();
        
        ac.assertCheck("http://10.0.1.86/tatoc/basic/drag", "Assert Failed");
       //Assert.assertEquals("http://10.0.1.86/tatoc/basic/drag",driver.getCurrentUrl(),"Assert Failed");
    }
}
