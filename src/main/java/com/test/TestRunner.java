package com.test;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "Features", // Folder name where your feature files are located
  glue = {"stepDefinition"}, // Package name for step definitions
  plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports/cucumber.json"}, // Plugin to generate reports
  monochrome = true, // Optional: Makes console output more readable
  tags = "@search" // Specify the tag to run only logout scenarios
)
public class TestRunner {}
