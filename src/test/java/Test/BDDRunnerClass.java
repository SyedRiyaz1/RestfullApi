package Test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features= {"E:\\batch 244\\BDD\\src\\test\\resources\\Features\\feature1.feature",
		  "E:\\batch 244\\BDD\\src\\test\\resources\\Features\\feature2.feature"},
 monochrome=true,
 //glue= "classpath:Test",
 glue= {"classpath:Test"},
 plugin= {"pretty","html:target\\BDDresults.txt"}
 )
public class BDDRunnerClass 
{

}
