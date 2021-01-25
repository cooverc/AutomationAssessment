package assessment.test.runner;


import assessment.test.listeners.TestNGListener;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Listeners;

@Listeners(TestNGListener.class)
@CucumberOptions(
        features = {"src/test/java/assessment/test/features/"},
        glue = {"assessment/test/steps"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        tags = {"@TestReport"})
public class TestRunnerTest extends AbstractTestNGCucumberTests {


}
