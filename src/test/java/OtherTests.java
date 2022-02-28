import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class OtherTests extends AbstractTest{
    @Test
    void Test() throws InterruptedException {

        Assertions.assertTrue(getDriver().getTitle().equals("Happy Sushi"), "Cтраница входа недоступна");

        // Создадим экземпляр класса Actions
        Actions addItem = new Actions(getDriver());
        addItem.sendKeys(getDriver().findElement(By.cssSelector("body")),Keys.CONTROL, Keys.END)
                .build()
                .perform();

        Thread.sleep(2000);

        addItem.click(getDriver().findElement(By.xpath(".//button[@class='page-btn2']")))
                .build()
                .perform();

        Thread.sleep(1000);
        Assertions.assertTrue(getDriver().findElement(By.xpath(".//form[@id='contact-form']/h3")).getText().equals("Оставьте свою заявку, и мы перезвоним вам в течение 5 минут!"), "Cтраница недоступна");

        addItem.sendKeys(getDriver().findElement(By.xpath(".//form[@id='contact-form']/div[@class='form-group']/input[@class='required form-control2']")),"Admin")
                .sendKeys(getDriver().findElement(By.xpath(".//div[@class='form-group']/textarea[@class='form-control2']")),"Как можно быстрее")
                .click(getDriver().findElement(By.xpath(".//div[@class='form-group']/input[@class='page-btn2']")))
                .build()
                .perform();
    }

}
