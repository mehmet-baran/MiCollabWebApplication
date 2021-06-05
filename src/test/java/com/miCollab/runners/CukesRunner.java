package com.miCollab.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/miCollab/step_definitions",
        dryRun = false,
        tags = "",
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber-default-report",
                "rerun:target/failed.txt"}
)
public class CukesRunner {
}
