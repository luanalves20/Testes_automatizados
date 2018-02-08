package com.rentcars.site;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.rentcars.automacao.gravaLog.GravarArquivosLog;
import com.rentcars.automacao.utils.Elementos;
import com.rentcars.automacao.utils.Utility;

public class LocacaoOpcional {

	private WebDriver driver;

	private WebElement element;

	private WebDriverWait wait;

	private boolean validaTipoPagamento = false;

	private String urlLocacao;

	Elementos elementos = new Elementos();
	Utility utility = new Utility();
	GravarArquivosLog gravaArquivosLog = new GravarArquivosLog();

	@Test
	public void locacaoOpcional() throws InterruptedException {
		driver = utility.setUp();

		element = driver.findElement(By.id("LocalidadeRetirada"));
		element.sendKeys("Afonso Pena");

		element = driver.findElement(By.id("DataRetirada"));
		element.click();

		elementos.setElementoDataAtual(
				driver.findElement(By.xpath("//td/a[@class='ui-state-default ui-state-highlight ui-state-hover']")));
		elementos.setDataAtual(elementos.getElementoDataAtual().getText().toString());

		int dataAtual = Integer.parseInt(elementos.getDataAtual());

		if (dataAtual <= 30) {
			element = driver.findElement(By.xpath(
					"/html/body[@class='homepage pt-br']/div[@id='ui-datepicker-div']/div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody//a[contains(text(),"
							+ utility.somaDia(elementos.getDataAtual()) + ")]"));
			element.click();
		} else {
			element = driver.findElement(By.xpath(
					"/html/body[@class='homepage pt-br']/div[@id='ui-datepicker-div']/div[@class='ui-datepicker-group ui-datepicker-group-last']/table[@class='ui-datepicker-calendar']/tbody/tr[2]/td[2]"));
			element.click();
		}

		element = driver.findElement(By.xpath("/html/body[@class='homepage pt-br']/header[@class='nav-header']"));
		element.click();

		wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("submitPesquisa")));
		element = driver.findElement(By.id("submitPesquisa"));
		element.submit();

		// Seleciona para o veiculos com maior valor primeiro, a fim de garantir que ele vá apresentar um opcional na tela adiante
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body[@class='booking-results pt-br']/div[@class='container head_s_a page-car-list']/div[@id='searchResult']/div[@id='mainCol']/div[@id='filterOptions']/div[@class='row']/div[@class='col-xs-12 col-sm-12 col-md-7 col-lg-7 filterOptions1 hidden-xs']/div[@class='nav-order nav-order-color1']/a[@class='sortElement'][2]")));
		element = driver.findElement(By.xpath(
				"/html/body[@class='booking-results pt-br']/div[@class='container head_s_a page-car-list']/div[@id='searchResult']/div[@id='mainCol']/div[@id='filterOptions']/div[@class='row']/div[@class='col-xs-12 col-sm-12 col-md-7 col-lg-7 filterOptions1 hidden-xs']/div[@class='nav-order nav-order-color1']/a[@class='sortElement'][2]"));
		element.click();

		Thread.sleep(1500);
		element = driver.findElement(By.xpath(
				"//div[@class='box_c clearfix']/div[@class='box_c_content car-list']/ul[@id='gridSource']/li[@class='car-result element visible null'][1]/div[@class='item-content']/div[@class='c_price']/a[@class='button green medium radius']"));
		element.click();

		// Alterar a guia do navegador
		ArrayList<String> guias = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(guias.get(1));

		// Validar pagamento online
		try {
			elementos.setTextoTipoPagamento(
					driver.findElement(By.xpath("//strong[contains(text(), 'Pagamento online')]")));
			validaTipoPagamento = true;
		} catch (Exception e) {
			validaTipoPagamento = false;
		}

		// Validar pagamento destino e online
		try {
			elementos.setTextoTipoPagamento(driver.findElement(By.xpath("//div[contains(text(), 'A pagar online')]")));
			validaTipoPagamento = true;
		} catch (Exception e) {
			if (validaTipoPagamento == true) {
				validaTipoPagamento = true;
			} else {
				validaTipoPagamento = false;
			}
		}

		// Altera para a página configurar
		urlLocacao = driver.getCurrentUrl();
		elementos.setNewUrl(utility.botaoLogar(urlLocacao));
		driver.get(elementos.getNewUrl());

		// Seleciona primeiro opcional que é apresentado
		element = driver.findElement(By.xpath("//ul[@id='lista-adicionais-visualizar']/li[1]"));
		element.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-full-register-has-account")));
		element = driver.findElement(By.id("js-full-register-has-account"));
		element.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("EmailLogin")));
		elementos.setCampoLogin(driver.findElement(By.id("EmailLogin")));
		elementos.getCampoLogin().sendKeys(elementos.getEmailPadrao());

		elementos.setCampoSenha(driver.findElement(By.id("SenhaLogin")));
		elementos.getCampoSenha().sendKeys(elementos.getSenhaPadrao());
		elementos.getCampoSenha().sendKeys(Keys.ENTER);

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		element = driver.findElement(By.id("Lazer"));
		element.click();

		element = driver.findElement(By.id("Aceito"));
		element.click();

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(
				By.xpath("//div[@class='configure-btn col-xs-12 col-sm-12 col-md-7 col-lg-7 pull-left']"))));
		element = driver
				.findElement(By.xpath("//div[@class='configure-btn col-xs-12 col-sm-12 col-md-7 col-lg-7 pull-left']"));
		element.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status-pedido")));	
		element = driver.findElement(By.id("status-pedido"));
		String statusPedido = element.getText().toString();

		if (statusPedido.equals("Aguardando Aprovação")) {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='box_s_reg codigoPedido']/h2/b")));
			elementos.setNumReserva(driver.findElement(By.xpath("//div[@class='box_s_reg codigoPedido']/h2/b")));
			elementos.setNumeroReserva(elementos.getNumReserva().getText().toString());
		} else {

			if (validaTipoPagamento == true) {
				wait.until(ExpectedConditions.elementToBeClickable(By.id("NumeroCartao")));
				elementos.setCampoNumCartao(driver.findElement(By.id("NumeroCartao")));
				elementos.getCampoNumCartao().sendKeys(elementos.getNumeroCartao());

				Thread.sleep(500);

				Select dropDownParcela = new Select(driver.findElement(By.id("CodigoOpcaoPagamento")));
				dropDownParcela.selectByIndex(0);

				Thread.sleep(500);

				elementos.setCampoNomeCartao(driver.findElement(By.id("NomeCartao")));
				elementos.getCampoNomeCartao().sendKeys(elementos.getNomeTitular());

				Thread.sleep(500);

				Select dropDownMes = new Select(driver.findElement(By.id("MesCartao")));
				dropDownMes.selectByValue("04");

				Thread.sleep(500);

				Select dropDownAno = new Select(driver.findElement(By.id("AnoCartao")));
				dropDownAno.selectByValue("2018");

				Thread.sleep(500);

				elementos.setCampoCodSeg(driver.findElement(By.id("CVC")));
				elementos.getCampoCodSeg().sendKeys(elementos.getCodigoSeguranca());

				Thread.sleep(500);

				elementos.setBtAceitoTermosCond(driver.findElement(By.id("creditcard-accept")));
				elementos.getBtAceitoTermosCond().click();

				Thread.sleep(500);

				elementos.setBtPagarSeg(driver
						.findElement(By.xpath("//button[@class='submitPagamento btn btn-reserva btn-block btn-lg']")));
				elementos.getBtPagarSeg().click();

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='box_s_reg codigoPedido']/h2/b")));
				elementos.setNumReserva(driver.findElement(By.xpath("//div[@class='box_s_reg codigoPedido']/h2/b")));
				elementos.setNumeroReserva(elementos.getNumReserva().getText().toString());

			} else {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='box_s_reg codigoPedido']/h2/b")));
				elementos.setNumReserva(driver.findElement(By.xpath("//div[@class='box_s_reg codigoPedido']/h2/b")));
				elementos.setNumeroReserva(elementos.getNumReserva().getText().toString());
			}
		}
		try {
			gravaArquivosLog.GravaLocacaoOpcional(elementos.getNumeroReserva());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@AfterTest
	public void afterTest() {
		 driver.quit();
	}
}
