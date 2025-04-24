package DanceGroupPractice.com.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber.json" // cucumber report

        },
        features = "src/test/resources/features",
        glue = "DanceGroupPractice/com/step_definitions",
        dryRun = false,
        tags = "@googleSearch"

)
public class CukesRunner {
}
