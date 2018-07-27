/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tatoc1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author neerajsah
 */
public class FindElement {
    
    WebDriver driver;
    
    public FindElement(WebDriver driver)
    {
      this.driver=driver; 
    }
    
    public WebElement findElement(String by,String search)
    {
        WebElement element = null;
        if(by.equals("linkText"))
        {
            element=driver.findElement(By.linkText(search));
        }
        
        else if(by.equals("id"))
        {
            element= driver.findElement(By.id(search));
        }
          
        else if(by.equals("className"))
        {
            element= driver.findElement(By.className(search));
        }
    
    
        return element;
    }
    
}
