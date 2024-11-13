package org.example.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\imam.hussain\\IdeaProjects\\newporjects\\Ascendion\\src\\main\\java\\org\\example\\Cucumber_feature\\snapdeal.feature",
        glue = "Cucumber_feature", // Package name where your step definitions are located
        plugin = {"pretty"},
        monochrome = true
)
public class TestRunner {
}
