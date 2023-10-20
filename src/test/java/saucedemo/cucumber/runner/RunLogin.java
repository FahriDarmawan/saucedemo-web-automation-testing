package saucedemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/features/Login.feature",
        glue = "saucedemo.cucumber.stepDefs",
        plugin = {"pretty",
                "html:target/HTML-Reports/LoginReport.html",
                "json:target/JSONReports/LoginReport.json",
                "junit:target/JUnitReports/LoginReport.xml"}
)

public  class RunLogin {
}

