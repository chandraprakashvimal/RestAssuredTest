package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/featureFile/test.feature", glue = {"stepDef"}, plugin = {"pretty", "html:target/cucumber-reports/Cucumber.html"},
        monochrome = true)
public class TestRunner {
}
