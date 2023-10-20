package saucedemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/features",
        glue = "saucedemo.cucumber.stepDefs",
        plugin = {"pretty",
                "html:target/HTML-Reports/ReportAll.html",
                "json:target/JSONReports/ReportAll.json",
                "junit:target/JUnitReports/ReportAll.xml"}
)
public class RunAll {
}
