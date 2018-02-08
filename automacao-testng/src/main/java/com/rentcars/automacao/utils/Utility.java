package com.rentcars.automacao.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Utility {

	private String splitUrl[];
	private String novaUrl;
	private String config = "configurar";
	
	public WebDriver setUp() {
		WebDriver driver;
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("-start-maximized");
		chromeOptions.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://site.stage.rentcars.com/pt-br/");

		return driver;
	}
	
	public String somaDia(String diaAtual) {
		int diaAtualInt = Integer.parseInt(diaAtual);
		diaAtualInt ++;
		
		diaAtual = Integer.toString(diaAtualInt);
		
		return diaAtual;
	}
	
	public String botaoLogar(String urlLocacao) {

		splitUrl = urlLocacao.split("visualizar");
		novaUrl = splitUrl[0].concat(config).concat(splitUrl[1]);

		return novaUrl;

	}
	
	public String nomeOS() {
		String os = System.getProperty("os.name").toLowerCase();
		return os;
	}
	
	public String numeroReservaUrl(String url){
		String[] numeroReservaUrl = url.split("/");
		
		return numeroReservaUrl[5];
	}
	
}