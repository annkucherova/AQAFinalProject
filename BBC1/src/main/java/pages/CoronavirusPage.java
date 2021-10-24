package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'gs-u-display-none ')]//span[text()='Your Coronavirus Stories']")
    private WebElement yourCoronavirusStoriesButton;

    public CoronavirusPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnYourCoronavirusStoriesButton() {
        yourCoronavirusStoriesButton.click();
    }
}
