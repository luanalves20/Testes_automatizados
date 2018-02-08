package com.rentcars.automacao.utils;

import org.openqa.selenium.WebElement;

public class Elementos {

	private WebElement elementoDataAtual;
	private WebElement textoTipoPagamento;
	private WebElement campoLogin;
	private WebElement campoSenha;
	private WebElement campoNumCartao;
	private WebElement campoNomeCartao;
	private WebElement campoCodSeg;
	private WebElement btAceitoTermosCond;
	private WebElement btPagarSeg;
	private WebElement numReserva;
	private WebElement cancelarWebserviceReserva;
	private WebElement maiorPreco;
	
	private String dataAtual;
	private String urlAtual;
	private String statusReserva;
	private String newUrl;
	private String loginAdmin = "luan.alves";
	private String senhaAdmin = "rent123";
	private String emailPadrao = "reservas@rentcars.com";
	private String senhaPadrao = "4003rent";
	private String numeroCartao = "5398681961583610";
	private String nomeTitular = "Teste Testersom";
	private String codigoSeguranca = "165";
	private String numeroReserva;
	private String splitUrl[];
	private String movida = "3";
	
	public WebElement getMaiorPreco() {
		return maiorPreco;
	}
	public void setMaiorPreco(WebElement maiorPreco) {
		this.maiorPreco = maiorPreco;
	}
	public String[] getSplitUrl() {
		return splitUrl;
	}
	public void setSplitUrl(String[] splitUrl) {
		this.splitUrl = splitUrl;
	}
	public String getMovida() {
		return movida;
	}
	public void setMovida(String movida) {
		this.movida = movida;
	}
	public WebElement getCancelarWebserviceReserva() {
		return cancelarWebserviceReserva;
	}
	public void setCancelarWebserviceReserva(WebElement cancelarWebserviceReserva) {
		this.cancelarWebserviceReserva = cancelarWebserviceReserva;
	}
	public String getLoginAdmin() {
		return loginAdmin;
	}
	public void setLoginAdmin(String loginAdmin) {
		this.loginAdmin = loginAdmin;
	}
	public String getSenhaAdmin() {
		return senhaAdmin;
	}
	public void setSenhaAdmin(String senhaAdmin) {
		this.senhaAdmin = senhaAdmin;
	}
	public String getNumeroReserva() {
		return numeroReserva;
	}
	public void setNumeroReserva(String numeroReserva) {
		this.numeroReserva = numeroReserva;
	}
	public WebElement getBtPagarSeg() {
		return btPagarSeg;
	}
	public void setBtPagarSeg(WebElement btPagarSeg) {
		this.btPagarSeg = btPagarSeg;
	}
	public WebElement getNumReserva() {
		return numReserva;
	}
	public void setNumReserva(WebElement numReserva) {
		this.numReserva = numReserva;
	}
	public WebElement getBtAceitoTermosCond() {
		return btAceitoTermosCond;
	}
	public void setBtAceitoTermosCond(WebElement btAceitoTermosCond) {
		this.btAceitoTermosCond = btAceitoTermosCond;
	}
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}
	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}
	public WebElement getCampoNumCartao() {
		return campoNumCartao;
	}
	public void setCampoNumCartao(WebElement campoNumCartao) {
		this.campoNumCartao = campoNumCartao;
	}
	public WebElement getCampoNomeCartao() {
		return campoNomeCartao;
	}
	public void setCampoNomeCartao(WebElement campoNomeCartao) {
		this.campoNomeCartao = campoNomeCartao;
	}
	public WebElement getCampoCodSeg() {
		return campoCodSeg;
	}
	public void setCampoCodSeg(WebElement campoCodSeg) {
		this.campoCodSeg = campoCodSeg;
	}
	public String getEmailPadrao() {
		return emailPadrao;
	}
	public void setEmailPadrao(String emailPadrao) {
		this.emailPadrao = emailPadrao;
	}
	public String getSenhaPadrao() {
		return senhaPadrao;
	}
	public void setSenhaPadrao(String senhaPadrao) {
		this.senhaPadrao = senhaPadrao;
	}
	public WebElement getCampoLogin() {
		return campoLogin;
	}
	public void setCampoLogin(WebElement campoLogin) {
		this.campoLogin = campoLogin;
	}
	public WebElement getCampoSenha() {
		return campoSenha;
	}
	public void setCampoSenha(WebElement campoSenha) {
		this.campoSenha = campoSenha;
	}
	public String getNewUrl() {
		return newUrl;
	}
	public void setNewUrl(String newUrl) {
		this.newUrl = newUrl;
	}
	public WebElement getTextoTipoPagamento() {
		return textoTipoPagamento;
	}
	public void setTextoTipoPagamento(WebElement textoTipoPagamento) {
		this.textoTipoPagamento = textoTipoPagamento;
	}
	public WebElement getElementoDataAtual() {
		return elementoDataAtual;
	}
	public void setElementoDataAtual(WebElement elementoDataAtual) {
		this.elementoDataAtual = elementoDataAtual;
	}
	public String getDataAtual() {
		return dataAtual;
	}
	public void setDataAtual(String dataAtual) {
		this.dataAtual = dataAtual;
	}
	public String getUrlAtual() {
		return urlAtual;
	}
	public void setUrlAtual(String urlAtual) {
		this.urlAtual = urlAtual;
	}
	public String getStatusReserva() {
		return statusReserva;
	}
	public void setStatusReserva(String statusReserva) {
		this.statusReserva = statusReserva;
	}
	
}