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
public class BasicCourse 
{
   WebDriver driver;
   
   public BasicCourse(WebDriver driver)
   {
     this.driver=driver;
   }
   
   
    public void basicCourseSelection() throws InterruptedException
    { 
        AssertCheck ac=new AssertCheck(driver);
        FindElement find=new FindElement(driver);
               
        find.findElement("linkText", "Basic Course").click();
//        driver.findElement(By.linkText("Basic Course")).click();
        
        Thread.sleep(0500);
        ac.assertCheck("http://10.0.1.86/tatoc/basic/grid/gate","Assert Failed");
      //Assert.assertEquals("http://10.0.1.86/tatoc/basic/grid/gate",driver.getCurrentUrl(),"Assert Failed");
    }
}
