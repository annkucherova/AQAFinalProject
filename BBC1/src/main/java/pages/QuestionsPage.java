package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class QuestionsPage extends BasePage {

    @FindBy(xpath = "//div[@class='embed-content-container']")
    private WebElement questionForm;

    @FindBy(xpath = "//div[@class='long-text-input-container']//textarea")
    private WebElement questionField;

    @FindBy(xpath = "//input[@aria-label='Name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@aria-label='Email address']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@aria-label='Contact number']")
    private WebElement numberField;

    @FindBy(xpath = "//input[@aria-label='Location ']")
    private WebElement locationField;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkbox;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='input-error-message']")
    private WebElement warningMessage;

    @FindBy(xpath = "//div[@class='checkbox']//div[@class='input-error-message']")
    private WebElement checkboxWarningMessage;

    public QuestionsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getQuestionForm() {
        return questionForm;
    }

    public void enterTextToQuestionField(final String keyword) {
        questionField.clear();
        questionField.sendKeys(keyword);
    }

    public void enterTextToNameField(final String keyword) {
        nameField.clear();
        nameField.sendKeys(keyword);
    }

    public void enterTextToEmailField(final String keyword) {
        emailField.clear();
        emailField.sendKeys(keyword);
    }

    public void enterTextToNumberField(final String keyword) {
        numberField.clear();
        numberField.sendKeys(keyword);
    }

    public void enterTextToLocationField(final String keyword) {
        locationField.clear();
        locationField.sendKeys(keyword);
    }

    public void clickOnCheckbox() {
        checkbox.click();
    }

    public void moveToWhatSubmitButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).build().perform();
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public WebElement getWarningMessage() {
        return warningMessage;
    }

    public WebElement getCheckboxWarningMessage() {
        return checkboxWarningMessage;
    }

}
