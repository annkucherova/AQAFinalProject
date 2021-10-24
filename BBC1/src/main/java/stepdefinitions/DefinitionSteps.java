package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;

    HomePage homePage;
    NewsPage newsPage;
    CoronavirusPage coronavirusPage;
    CoronavirusStoriesPage coronavirusStoriesPage;
    QuestionsPage questionsPage;
    SearchResultsPage searchResultsPage;

    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @When("User clicks on News")
    public void clickOnNews() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnNewsButton();
    }

    @Then("User checks the name of the headline article equals to {string}")
    public void checkNameOfHeadlineArticle(final String expectedName) {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(newsPage.getHeadlineArticle().getText(), expectedName);
    }

    @Then("^User checks that names of secondary articles equal to the following:$")
    public void checkNamesOfSecondaryArticles(List<String> expectedArticles) {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(newsPage.getSecondaryArticlesList(), expectedArticles);
    }

    @And("User enters the Category link of the headline article in the Search bar")
    public void enterCategoryLinkOfTheHeadlineArticleInSearchBar() {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        String categoryLink = newsPage.getHeadlineArticleCategoryLink().getText();
        newsPage.enterTextToSearchField(categoryLink);
        newsPage.clickOnSearchButton();
    }

    @Then("User checks the name of the first article equals to {string}")
    public void checkNameOfFirstArticle(final String expectedName) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(searchResultsPage.getArticlesList().get(0).getText(), expectedName);
    }

    @And("User clicks on Coronavirus")
    public void clickOnCoronavirus() {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        newsPage.clickOnCoronavirusButton();
    }


    @And("User clicks on Your Coronavirus Stories")
    public void clickOnYourCoronavirusStories() {
        coronavirusPage = pageFactoryManager.getCoronavirusPage();
        coronavirusPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        coronavirusPage.clickOnYourCoronavirusStoriesButton();
    }

    @And("User clicks on 'What questions do you have?'")
    public void clickOnWhatQuestionsDoYouHave() {
        coronavirusStoriesPage = pageFactoryManager.getCoronavirusStoriesPage();
        coronavirusStoriesPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        coronavirusStoriesPage.moveToWhatQuestionsButton();
        coronavirusStoriesPage.clickOnWhatQuestionsButton();
    }

    @And("User checks that question form is visible")
    public void checkThatQuestionFormIsVisible() {
        questionsPage = pageFactoryManager.getQuestionsPage();
        questionsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(questionsPage.getQuestionForm().isDisplayed());
    }

    @When("User enters {string} to the Question field")
    public void enterTextToTheQuestionField(final String keyword) {
        questionsPage.enterTextToQuestionField(keyword);
    }

    @And("User enters {string} to the Name field")
    public void enterTextToTheNameField(final String keyword) {
        questionsPage.enterTextToNameField(keyword);
    }

    @And("User enters {string} to the Email field")
    public void enterEmailToTheEmailField(final String keyword) {
        questionsPage.enterTextToEmailField(keyword);
    }

    @And("User enters {string} to the Number field")
    public void enterTextToTheNumberField(final String keyword) {
        questionsPage.enterTextToNumberField(keyword);
    }

    @And("User enters {string} to the Location field")
    public void enterTextToTheLocationField(final String keyword) {
        questionsPage.enterTextToLocationField(keyword);
    }

    @And("User accepts the Terms Of Service")
    public void clickOnAcceptTheTermsOfService() {
        questionsPage.clickOnCheckbox();
    }

    @And("User clicks on Submit button")
    public void clickOnSubmitButton() {
        questionsPage.clickOnSubmitButton();
    }

    @Then("User checks the warning message {string}")
    public void checkTheWarningMessage(final String expectedWarning) {
        questionsPage = pageFactoryManager.getQuestionsPage();
        questionsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        questionsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, questionsPage.getWarningMessage());
        assertEquals(questionsPage.getWarningMessage().getText(), expectedWarning);
    }

    @Then("User checks warning messages {string} and {string}")
    public void checkEmailWarningAndCheckboxWarning(final String emailWarning, final String checkboxWarning) {
        questionsPage = pageFactoryManager.getQuestionsPage();
        questionsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        questionsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, questionsPage.getWarningMessage());
        assertEquals(questionsPage.getWarningMessage().getText(), emailWarning);
        assertEquals(questionsPage.getCheckboxWarningMessage().getText(), checkboxWarning);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
