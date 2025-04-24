package DanceGroupPractice.com.step_definitions;

import DanceGroupPractice.com.utilities.Driver;
import io.cucumber.java.Before;

import java.time.Duration;

public class Hooks {
    @Before
    public void setup() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
