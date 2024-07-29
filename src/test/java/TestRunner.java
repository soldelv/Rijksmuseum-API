import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepsdefinitions",
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"},
        monochrome = true,
        tags = ("@regressions"),
        publish = true
)

public class TestRunner {

    @BeforeClass
    public static void initialSequence() {
    }

    @AfterClass
    public static void finalSequence() {
    }
}