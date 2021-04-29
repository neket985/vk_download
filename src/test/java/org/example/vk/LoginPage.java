package org.example.vk;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends AbstractPage{
  @FindBy(xpath = "//*[@id=\"email\"]")
  private WebElement loginField;
  @FindBy(xpath = "//*[@id=\"pass\"]")
  private WebElement passField;
  @FindBy(xpath = "//*[@id=\"login_button\"]")
  private WebElement loginButton;

  public LoginPage(WebDriver webDriver) {
    super(webDriver);
  }

  public void inputLogin(String login) {
    loginField.sendKeys(login);
  }
  public void inputPassw(String passw) {
    passField.sendKeys(passw);
  }
  public void clickLoginBtn() {
    loginButton.click();
  }


}
