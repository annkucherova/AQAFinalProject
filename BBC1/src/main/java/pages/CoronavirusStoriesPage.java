package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CoronavirusStoriesPage extends BasePage {

    @FindBy(xpath = "//a[@href='/news/52143212']")
    private WebElement whatQuestionsButton;

    public CoronavirusStoriesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getWhatQuestionsButton() {
        return whatQuestionsButton;
    }

    public void moveToWhatQuestionsButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(whatQuestionsButton).build().perform();
    }

    public void clickOnWhatQuestionsButton() {
        whatQuestionsButton.click();
    }
}
