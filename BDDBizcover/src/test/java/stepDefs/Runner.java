package stepDefs;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"/Users/priyae/git/BDDBizcoverAssignment/src/test/resources/Features/Luma.feature"},
glue= {"stepDefs"},
tags= "@Login",
plugin = {"pretty","html:target//reports.html"},
monochrome = true


		)

public class Runner  {
	

}
