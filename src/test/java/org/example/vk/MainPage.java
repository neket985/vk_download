package org.example.vk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends AbstractPage{
  @FindBy(xpath = "//*[@id=\"l_aud\"]")
  private WebElement audioButton;

  public MainPage(WebDriver webDriver) {
    super(webDriver);
  }

  public void clickAudioBtn() {
    new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable(audioButton));
    audioButton.click();
  }


}
