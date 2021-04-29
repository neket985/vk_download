package org.example.vk;

import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {

  public static LoginPage loginPage;
  public static AuthCheckPage authCheckPage;
  public static MainPage mainPage;
  public static AudioPage audioPage;
  public static SaveFromNetPage saveFromNetPage;

  private static String targetUrl = "https://vk.com/audios***";
  private static ChromeDriver driver;

  private String login = "***";
  private String password = "***";

  @BeforeClass
  public static void setup() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver89");

    ChromeOptions options = new ChromeOptions();
    options.addExtensions(new File("/home/nikita/IdeaProjects/vk_download/src/test/resources/SaveFromHelper.crx"));

    driver = new ChromeDriver(options);

    loginPage = new LoginPage(driver);
    authCheckPage = new AuthCheckPage(driver);
    mainPage = new MainPage(driver);
    saveFromNetPage = new SaveFromNetPage(driver);
    audioPage = new AudioPage(driver);

    driver.manage().window().maximize();

    Set<String> windowHandles = driver.getWindowHandles().stream().skip(1).collect(Collectors.toSet());
    String currentHandle = driver.getWindowHandle();
    for (String windowHandle : windowHandles) {
        driver.switchTo().window(windowHandle);
        driver.close();
    }
    driver.switchTo().window(currentHandle);

    driver.get(targetUrl);
  }

  @AfterClass
  public static void tearDown() {
//    profilePage.entryMenu();
//    profilePage.userLogout();
//    driver.quit();
  }

  @Test
  public void test() throws InterruptedException {
    loginPage.inputLogin(login);
    loginPage.inputPassw(password);
    loginPage.clickLoginBtn();

    if(authCheckPage.pageOpened()){
      authCheckPage.waitForInput();
      authCheckPage.clickSubmitBtn();
    }

    mainPage.clickAudioBtn();

    audioPage.downloadAllMusic();

    Thread.sleep(100_000);
  }

}
