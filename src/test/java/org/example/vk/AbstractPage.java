package org.example.vk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
  protected final WebDriver webDriver;

  public AbstractPage(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
    this.webDriver = webDriver;
  }

}
