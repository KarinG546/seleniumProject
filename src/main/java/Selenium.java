import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class Selenium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Please enter your user name:");
        String userName = scanner.nextLine();
        System.out.println("Now please enter your password:");
        String userPassword = scanner.nextLine();
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\karin\\OneDrive\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aac.ac.il/");

        WebElement menu = driver.findElement(By.id("menu-%d7%9b%d7%9c%d7%9c%d7%99"));
       if (menu != null) {
        List<WebElement> menuItems = menu.findElements(By.tagName("li"));
        WebElement personalInfo = menuItems.get(Definitions.PERSONAL_INFO_INDEX);
        personalInfo.click();
        WebElement userNameInput = driver.findElement(By.id("Ecom_User_ID"));
        if (userNameInput != null) {
            userNameInput.sendKeys(userName);
        }
        WebElement userPasswordInput = driver.findElement(By.id("Ecom_Password"));
        if (userPasswordInput != null) {
            userPasswordInput.sendKeys(userPassword);
        }
        WebElement login = driver.findElement(By.id("wp-submit"));
        login.click();
    }
      WebElement moodleLogIn = driver.findElement(By.xpath("//*[text()='מערכת Moodle']"));
      moodleLogIn.click();
      try {
          Thread.sleep(Definitions.DELAY_TIME);
      }catch (InterruptedException e){
          e.printStackTrace();
      }
        System.out.println("Your course list:");
      List<WebElement> courseList = driver.findElements(By.className("multiline"));
         for (int i = 0; i < courseList.size(); i++) {
             WebElement courseListItem = courseList.get(i);
             System.out.println(courseListItem.getText() + " : " + i);
             System.out.println("-------");
         }
        System.out.println("Please enter the index of the course page you would like to enter:");
         int usersChoice = scanner.nextInt();
         WebElement chosenCourse = courseList.get(usersChoice);
         chosenCourse.click();
         WebElement clickOnUserMenu = driver.findElement(By.className("userbutton"));
         clickOnUserMenu.click();
         WebElement moodleLogOut = driver.findElement(By.id("actionmenuaction-6"));
         moodleLogOut.click();
        WebElement personalInfoLogOut = driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-log-out']"));
        personalInfoLogOut.click();
           }
        }


