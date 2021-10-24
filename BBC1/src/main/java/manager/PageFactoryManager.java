package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public NewsPage getNewsPage() {
        return new NewsPage(driver);
    }

    public CoronavirusPage getCoronavirusPage() {
        return new CoronavirusPage(driver);
    }

    public CoronavirusStoriesPage getCoronavirusStoriesPage() {
        return new CoronavirusStoriesPage(driver);
    }

    public QuestionsPage getQuestionsPage() {
        return new QuestionsPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }
}
