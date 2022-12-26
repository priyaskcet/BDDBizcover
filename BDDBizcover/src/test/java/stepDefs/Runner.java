package stepDefs;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"/Users/priyae/BDD/BDDBizcover/src/test/resources/Features/Login.feature"},
glue= {"stepDefs"},
tags= "@Login",
plugin = {"pretty","html:target//reports.html"}

		)

public class Runner  {
	

}
