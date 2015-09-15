package feature.book;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		features= 	"D:\\dev\\CodingDojo\\ownCodingDojo\\20150910_cucumbertest\\features\\"
		/*glue = 		"D:\\dev\\CodingDojo\\ownCodingDojo\\20150910_cucumbertest\\src\\main\\java\\com\\cucumbertest"*/
)
public class BookSearchTest {
}