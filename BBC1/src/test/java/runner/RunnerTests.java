package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/articles.feature", "src/main/resources/form.feature"},
        glue = "stepdefinitions"
)
public class RunnerTests {
}
