package org.example.vk;

import java.io.InputStreamReader;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AuthCheckPage extends AbstractPage{
  @FindBy(xpath = "//*[@id=\"authcheck_code\"]")
  private WebElement codeInput;
  @FindBy(xpath = "//*[@id=\"login_authcheck_submit_btn\"]")
  private WebElement submitButton;

  public AuthCheckPage(WebDriver webDriver) {
    super(webDriver);
  }

  public boolean pageOpened(){
    return webDriver.getCurrentUrl().endsWith("authcheck");
  }

  public void waitForInput() {
    System.out.println("Введите код из смс:");
    String code = new Scanner(System.in).nextLine();
    codeInput.sendKeys(code);
  }

  public void clickSubmitBtn() {
    submitButton.click();
  }


}
