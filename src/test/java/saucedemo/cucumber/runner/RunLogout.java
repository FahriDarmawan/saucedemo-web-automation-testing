package saucedemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/features/Logout.feature",
        glue = "saucedemo.cucumber.stepDefs",
        plugin = {"pretty",
                "html:target/HTML-Reports/LogoutReport.html",
                "json:target/JSONReports/LogoutReport.json",
                "junit:target/JUnitReports/LogoutReport.xml"}
)

public class RunLogout {
}
