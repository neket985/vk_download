package org.example.vk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SaveFromNetPage extends AbstractPage{
  public SaveFromNetPage(WebDriver webDriver) {
    super(webDriver);
  }

  public void waitForOpenAndClose() throws InterruptedException {
      webDriver.close();
    while(true){
    if(webDriver.getCurrentUrl().contains("savefrom")){
      webDriver.close();
      break;
    }
      Thread.sleep(500);
    }
  }


}
