import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddItemsInBasketTest extends AbstractTest{
    @Test
    void AddItemTest() throws InterruptedException {

        Assertions.assertTrue(getDriver().getTitle().equals("Happy Sushi"), "Cтраница входа недоступна");
        // Создадим экземпляр класса Actions
        Actions addItem = new Actions(getDriver());
        addItem.click(getDriver().findElement(By.xpath(".//div[@id='mixit-block']/div[@class='mixitBlock-menu']/button[@data-btn='cat17']")))
                .build()
                .perform();

        WebElement webElement = getDriver().findElement(By.xpath(".//form[@id='ms_form_137']"));
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView();", webElement);
        Thread.sleep(10000);
        new WebDriverWait(getDriver(), 5);

        addItem.click(getDriver().findElement(By.xpath(".//form[@id='ms_form_137']/a")))
                .build()
                .perform();

        Thread.sleep(2000);
        Assertions.assertTrue(getDriver().getTitle().equals("Сет 4 Оранж"), "Другая страница");

        addItem.click(getDriver().findElement(By.xpath(".//form[@id='product-form']/div[@class='product-page__content']/div[@class='row']/div[@class='col-lg-7 col-xl-6']/div[@class='product-set']/div[@class='product-set__footer']/div[@class='total-amount']/button")))
                .build()
                .perform();

        Thread.sleep(10000);
        new WebDriverWait(getDriver(), 5);

        addItem.click(getDriver().findElement(By.xpath(".//div[@id='msMiniCart']/div[@class='not_empty text-center']/a")))
                .build()
                .perform();

        Thread.sleep(2000);
        Assertions.assertTrue(getDriver().getTitle().equals("Ваша корзина"), "Другая страница");

    }

    @Test
    void AddDoubleItemTest() throws InterruptedException {

        Assertions.assertTrue(getDriver().getTitle().equals("Happy Sushi"), "Cтраница входа недоступна");
        // Создадим экземпляр класса Actions
        Actions addItems = new Actions(getDriver());

        WebElement webElement = getDriver().findElement(By.xpath(".//form[@id='ms_form_147']"));
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView();", webElement);
        Thread.sleep(10000);
        new WebDriverWait(getDriver(), 5);

        addItems.click(getDriver().findElement(By.xpath(".//form[@id='ms_form_147']/button")))
                .build()
                .perform();

        Thread.sleep(10000);
        new WebDriverWait(getDriver(), 5);

        addItems.click(getDriver().findElement(By.xpath(".//div[@id='msMiniCart']/div[@class='not_empty text-center']/a")))
                .build()
                .perform();

        Thread.sleep(2000);
        Assertions.assertTrue(getDriver().getTitle().equals("Ваша корзина"), "Другая страница");

        addItems.click(getDriver().findElement(By.xpath(".//div[@class='product-counter product-counter--big']/button[@class='product-counter--plus product-counter-btn']")))
                .build()
                .perform();

        WebElement element = getDriver().findElement(By.xpath(".//div[@class='basket-btn']/a"));
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView();", element);

        Thread.sleep(10000);
        new WebDriverWait(getDriver(), 5);

        addItems.click(getDriver().findElement(By.xpath(".//div[@class='basket-btn']/a")))
                .build()
                .perform();
    }
}
