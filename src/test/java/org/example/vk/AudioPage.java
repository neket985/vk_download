package org.example.vk;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AudioPage extends AbstractPage{

  @FindBy(xpath = "//*[@id=\"content\"]/div/div[3]/div[1]/h2/ul/li[1]")
  private WebElement myMusicTab;

  public AudioPage(WebDriver webDriver) {
    super(webDriver);
  }

  public void downloadAllMusic() throws InterruptedException {
    new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable(myMusicTab));

    while (true){
      List<WebElement> audio_row = webDriver.findElements(By.className("audio_row"));
      audio_row.forEach(audio -> {
        new Actions(webDriver).moveToElement(audio).perform();
        WebElement downloadButton = webDriver.findElement(By.className("savefrom_vk_download"));
        downloadButton.click();
      });
      webDriver.wait(1000);
    }
  }


}
