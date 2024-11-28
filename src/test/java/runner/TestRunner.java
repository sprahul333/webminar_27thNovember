package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "./src/test/resources/features",
        glue="stepDefs", //Under which package the code for each step is there
        dryRun = false, //Start the trigger of the test cases
        monochrome = true, //To make the console output in a better format
        tags="@Login_Scenarios"
)

public class TestRunner extends AbstractTestNGCucumberTests
{

    @DataProvider
    public Object[][] getScenarios()
    {
        return super.scenarios();
    }
}
