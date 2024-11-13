package org.example.Cucumber_project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/Cucumber_Feature/snapdeal.feature",  // Adjusted path to be relative
        glue = "Cucumber_feature",
        plugin = {"pretty"},
        monochrome = true
)
public class TestRunner {
}