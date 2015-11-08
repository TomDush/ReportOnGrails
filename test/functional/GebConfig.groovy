/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.chrome.ChromeDriver

baseUrl = "http://localhost:8080/validis-reports/"
driver = { new ChromeDriver() }
reportsDir = "target/geb-reports"