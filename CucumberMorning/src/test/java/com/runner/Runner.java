package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		features = "src/test/java/com/featurefile/Login.feature",
        glue = "com/stepdefinition",                
		monochrome = true,
		stepNotifications = true
		//dryRun = true
				
		
		)
public class Runner {

}
