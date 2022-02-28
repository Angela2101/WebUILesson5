import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class AuthorizationTest extends AbstractTest{
    @Test
    void PositiveTest() throws InterruptedException {

        // Создадим экземпляр класса Actions
        Actions loginIn = new Actions(getDriver());
        loginIn.click(getDriver().findElement(By.xpath(".//div[@class='user-log-in']/a")))
                .build()
                .perform();

        Assertions.assertTrue(getDriver().getTitle().equals("Вход в личный кабинет"), "страница входа недоступна");

        loginIn.sendKeys(getDriver().findElement(By.xpath(".//div[@class='form-item__group form-item__username']/input")),"lik.bobrova@yandex.ru")
                .sendKeys(getDriver().findElement(By.xpath(".//div[@class='form-item__group form-item__password']/input")),"Angela21A")
                .click(getDriver().findElement(By.xpath(".//div[@class='custom-tab__box custom-tab__one active']/form[@class='authorization-form']/div[@class='form-item form-item--btn']/button")))
                .build()
                .perform();

        Thread.sleep(2000);
        Assertions.assertTrue(getDriver().findElement(By.xpath(".//button[@class='tabs__nav-item active']")).getText().equals("Личный кабинет"), "Другая страница");
    }

    @Test
    void NegativeTest() throws InterruptedException {

        // Создадим экземпляр класса Actions
        Actions loginIn = new Actions(getDriver());
        loginIn.click(getDriver().findElement(By.xpath(".//div[@class='user-log-in']/a")))
                .build()
                .perform();

        Assertions.assertTrue(getDriver().getTitle().equals("Вход в личный кабинет"), "страница входа недоступна");

        loginIn.sendKeys(getDriver().findElement(By.xpath(".//div[@class='form-item__group form-item__username']/input")),"lik.bobrova@yandex.ru")
                .sendKeys(getDriver().findElement(By.xpath(".//div[@class='form-item__group form-item__password']/input")),"Angela2221A")
                .click(getDriver().findElement(By.xpath(".//div[@class='custom-tab__box custom-tab__one active']/form[@class='authorization-form']/div[@class='form-item form-item--btn']/button")))
                .build()
                .perform();

        Thread.sleep(2000);
        Assertions.assertTrue(getDriver().getTitle().equals("Вход в личный кабинет"), "Другая страница");
    }

    @Test
    void AuthorizeCheckHistoryAndLogOutTest() throws InterruptedException {

        // Создадим экземпляр класса Actions
        Actions loginIn = new Actions(getDriver());
        loginIn.click(getDriver().findElement(By.xpath(".//div[@class='user-log-in']/a")))
                .build()
                .perform();

        Assertions.assertTrue(getDriver().getTitle().equals("Вход в личный кабинет"), "страница входа недоступна");

        loginIn.sendKeys(getDriver().findElement(By.xpath(".//div[@class='form-item__group form-item__username']/input")),"lik.bobrova@yandex.ru")
                .sendKeys(getDriver().findElement(By.xpath(".//div[@class='form-item__group form-item__password']/input")),"Angela21A")
                .click(getDriver().findElement(By.xpath(".//div[@class='custom-tab__box custom-tab__one active']/form[@class='authorization-form']/div[@class='form-item form-item--btn']/button")))
                .build()
                .perform();

        Thread.sleep(2000);
        Assertions.assertTrue(getDriver().findElement(By.xpath(".//button[@class='tabs__nav-item active']")).getText().equals("Личный кабинет"),"Другая страница");

        loginIn.click(getDriver().findElement(By.xpath(".//button[@class='tabs__nav-item']")))
                .build()
                .perform();
        Thread.sleep(2000);

        loginIn.click(getDriver().findElement(By.xpath(".//div[@class='btn-link']/a")))
                .build()
                .perform();
        
        Thread.sleep(2000);
        Assertions.assertTrue(getDriver().getTitle().equals("Вход в личный кабинет"), "страница входа недоступна");
    }
}
