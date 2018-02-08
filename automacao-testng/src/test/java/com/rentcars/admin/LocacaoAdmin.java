package com.rentcars.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.rentcars.automacao.utils.Elementos;
import com.rentcars.automacao.utils.Utility;

public class LocacaoAdmin {

	private WebElement element;

	private String urlAtual;
	private String numUrl;

	Elementos elementos = new Elementos();
	Utility utility = new Utility();

	@Test
	public void locacaoAdmin() throws InterruptedException {
		WebDriver driver = utility.setUp();
		
		driver.get("http://admin.stage.rentcars.com");

		Thread.sleep(500);

		element = driver.findElement(By.xpath("//li[1]/input"));
		element.sendKeys(elementos.getLoginAdmin());

		element = driver.findElement(By.xpath("//li[2]/input"));
		element.sendKeys(elementos.getSenhaAdmin());

		element = driver.findElement(By.xpath("//span[@class='ui-button-text']"));
		element.click();

		driver.get("http://admin.stage.rentcars.com/reservaV3");

		Thread.sleep(1000);
		element = driver.findElement(By.id("btnNovaReserva"));
		element.click();

		element = driver.findElement(By.xpath(
				"/html/body/div[@id='page-wrapper']/div[@id='main-wrapper']/div[@id='main-content']/div[@class='reservar']/form[@id='pesquisa']/div[@id='canal']/div[@class='page-title ui-widget-content ui-corner-all'][2]/div[@class='one-column']/button[@class='nextBtn btn btn-primary btn-lg pull-right']"));
		element.click();

		element = driver.findElement(By.xpath(
				"/html/body/div[@id='page-wrapper']/div[@id='main-wrapper']/div[@id='main-content']/div[@class='reservar']/form[@id='pesquisa']/div[@id='cliente']/div[@class='page-title ui-widget-content ui-corner-all'][4]/div[@class='one-column']/button[@class='nextBtn btn btn-primary btn-lg pull-right']"));
		element.click();

		element = driver.findElement(By.id("LocalidadeRetirada"));
		element.sendKeys("Florida");
		Thread.sleep(1000);
		element.sendKeys(Keys.ENTER);

		element = driver.findElement(By.id("DataRetirada"));
		element.click();

		element = driver.findElement(By.xpath(
				"/html/body/div[@id='ui-datepicker-div']/div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[@class=' '][1]/a[contains(text(), 12)]"));
		element.click();

		element = driver.findElement(By.id("DataDevolucao"));
		Thread.sleep(1000);
		element.sendKeys("13022018");

		element = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg pull-right btnSubmit']"));
		element.click();

		Thread.sleep(20000);
		element = driver.findElement(By.xpath("//html"));
		element.sendKeys(Keys.PAGE_DOWN);

		Thread.sleep(500);
		element = driver.findElement(By.xpath(
				"/html/body/div[@id='page-wrapper']/div[@id='main-wrapper']/div[@id='main-content']/div[@id='control']/div[@id='returnLoad']/ul[@id='listaBusca']/li[@id='gp-3807-226']/div[@class='searchItem']/div[@class='itemBody']/div[@class='itemPrice']/div[@id='ld-3807-226']/ul/li[10]/span//span[@class='ui-button-text']"));
		element.click();

		Thread.sleep(3000);
		
		element = driver.findElement(By.id("Email"));
		element.sendKeys("reservas@rentcars.com");

		element = driver.findElement(By.xpath(
				"/html/body/div[@id='page-wrapper']/div[@id='main-wrapper']/div[@id='main-content']/form[@id='reservar']/div[@class='page-title ui-widget-content ui-corner-all'][1]/div[@class='other']/ul[@class='box']/li[@class='box_auto'][8]/a[@class='pesquisarCliente red']"));
		element.click();

		Thread.sleep(2000);

		element = driver.findElement(By.xpath(
				"/html/body/div[@id='page-wrapper']/div[@id='main-wrapper']/div[@id='main-content']/form[@id='reservar']/div[@id='continue']/button[@id='prosseguir']/span[@class='ui-button-text']"));
		element.click();

		Select dropdownStatusOperacional = new Select(driver.findElement(By.id("idStatus")));
		dropdownStatusOperacional.selectByVisibleText("Pendente");

		element = driver.findElement(By.id("email_locadora"));
		element.click();

		element = driver.findElement(By.id("email_cliente"));
		element.click();

		element = driver.findElement(By.id("botaoSalvar"));
		element.click();

		Thread.sleep(3000);

		element = driver.findElement(By.id("fallr-button-button1"));
		Thread.sleep(500);
		element.click();

		urlAtual = driver.getCurrentUrl();
		numUrl = utility.numeroReservaUrl(urlAtual);

		Thread.sleep(3000);

		dropdownStatusOperacional = new Select(driver.findElement(By.id("idStatus")));
		dropdownStatusOperacional.selectByVisibleText("Em Processamento");

		element = driver.findElement(By.id("email_locadora"));
		element.click();

		element = driver.findElement(By.id("botaoSalvar"));
		element.click();

		Thread.sleep(3000);

		element = driver.findElement(By.id("fallr-button-button1"));
		Thread.sleep(500);
		element.click();

		urlAtual = driver.getCurrentUrl();
		numUrl = utility.numeroReservaUrl(urlAtual);

		Thread.sleep(3000);

		elementos
				.setCancelarWebserviceReserva(driver.findElement(By.xpath("//a[@data-ref='cancelar/" + numUrl + "']")));
		elementos.getCancelarWebserviceReserva().click();

		Thread.sleep(3000);

		element = driver.findElement(By.id("fallr-button-button1"));
		Thread.sleep(500);
		element.click();

		// wait.until(
		// ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='title
		// title-spac']/span")));
		// elementos.setStatusReserva(driver.findElement(By.xpath("//div[@class='title
		// title-spac']/span")).getText().toString());
		//
		// Thread.sleep(2000);
		//
		// if (elementos.getStatusReserva().equals("Status Atual: Em Processamento")) {
		//
		// driver.get("http://admin.stage.rentcars.com/auto/cancelaReservas");
		//
		// element = driver.findElement(By.xpath(
		// "/html/body/div[@class='container']/div[@class='row'][1]/form[@class='form-horizontal']/div[@class='form-group'][1]/div[@class='col-md-6']/textarea[@class='form-control']"));
		// element.sendKeys(splitTexto[3]);
		//
		// element = driver.findElement(By.id("cancel-btn"));
		// element.click();
		//
		// driver.close();
		//
		// } else {
		// try {
		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("idCancelamento"))));
		// Select dropdownMotivoCancelamento = new
		// Select(driver.findElement(By.id("idCancelamento")));
		// dropdownMotivoCancelamento.selectByVisibleText("Reserva Teste");
		//
		// } catch (NoSuchElementException e) {
		// }

		dropdownStatusOperacional = new Select(driver.findElement(By.id("idCancelamento")));
		dropdownStatusOperacional.selectByVisibleText("Reserva Teste");

		Thread.sleep(1000);

		element = driver.findElement(By.id("email_cliente"));
		element.click();

		Thread.sleep(1000);

		element = driver.findElement(By.id("botaoSalvar"));
		element.click();

		Thread.sleep(3000);

		element = driver.findElement(By.id("fallr-button-button1"));
		Thread.sleep(500);
		element.click();

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
