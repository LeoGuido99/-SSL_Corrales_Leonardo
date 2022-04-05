package AutomatizacionJavaSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utilidades {

	public static WebDriver configuracion(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.consultoriaglobal.com.ar/cgweb/");
		return driver;
	}
}
