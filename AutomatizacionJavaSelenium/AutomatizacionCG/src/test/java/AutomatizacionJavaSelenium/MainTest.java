package AutomatizacionJavaSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainTest {

	private WebDriver driver;
	
	/*--------------Declaracion de localizadores------------------*/
	By localizadorDeBotonContactenos = By.linkText("Contáctenos");
	By localizadorDePaginaContactenos = By.className("entry-title");
	
	By localizadorDeNombre = By.name("your-name");
	By localizadorDeEmail = By.name("your-email");
	By localizadorDeAsunto = By.name("your-subject");
	By localizadorDeMensaje = By.name("your-message");
	By localizadorDeCaptcha = By.name("captcha-636");
	
	By localizadorBotonEnviar = By.className("wpcf7-submit");
	/*----------------------------------------------------------*/
	
	@Before
	
	public void setUp() {
		driver = Utilidades.configuracion(driver);
		/*-------------------------------------------------------*/
		System.out.println("Se abre la pagina de Consultoria global");
		/*-------------------------------------------------------*/
	}
	
	@After
	
	public void tearDown() throws Exception{
		driver.quit();
	}
	
	@Test
	
	public void completarFormularioDeContacto() throws InterruptedException{
		
		driver.findElement(localizadorDeBotonContactenos).click(); // Clickea en contactenos
		Thread.sleep(2000); // 2 seg de espera
		/*------------------------------------------------------*/
		System.out.println("Se ingresa a la pestania de Contactenos");
		/*------------------------------------------------------*/
		
		if(driver.findElement(localizadorDePaginaContactenos).isDisplayed()) { // Si entro a contactenos
			
			driver.findElement(localizadorDeNombre).sendKeys("Leonardo Corrales");
			driver.findElement(localizadorDeEmail).sendKeys("direccionInvalida@gmail.com.");
			driver.findElement(localizadorDeAsunto).sendKeys("Aplicar en un puesto de trabajo");
			driver.findElement(localizadorDeMensaje).sendKeys("Buenas tardes, busco empleo como developer, me gustaria ser parte de su empresa.");
			driver.findElement(localizadorDeCaptcha).sendKeys("----");
			/*----------------------------------------------------------------------------*/
			System.out.println("Se llenan todos los campos requeridos, con el email invalido");
			/*----------------------------------------------------------------------------*/
			
			driver.findElement(localizadorBotonEnviar).click();
			Thread.sleep(2000);
			/*-------------------------------------*/
			System.out.println("Se envia la solicitud");
			/*-------------------------------------*/
			
			WebElement localizadorDireccionInvalida = driver.findElement(By.xpath("//*[@id=\"wpcf7-f1297-p370-o1\"]/form/p[2]/span/span"));
			
			if(localizadorDireccionInvalida.isDisplayed()) {
				Assert.assertEquals("La dirección e-mail parece inválida.", localizadorDireccionInvalida.getText());
				/*-------------------------------------------------------------------------------*/
				System.out.println("Se testea que la direccion del email sea efectivamente invalida");
				/*-------------------------------------------------------------------------------*/
			}
			
		}else {
			System.out.print("No entro a la pagina de contacto");
		}
		
	}
}
