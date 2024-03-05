package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features", glue="stepDefinitions", 
monochrome=true, tags = "@tdpnew7")
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
}
