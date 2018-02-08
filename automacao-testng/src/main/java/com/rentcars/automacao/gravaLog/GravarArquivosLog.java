package com.rentcars.automacao.gravaLog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GravarArquivosLog {

	private static Format format;

	private static String dataFormatada;
	
	private static Date data;
	
	public void GravaLocacaoNacional(String numeroReserva) throws IOException {
		data = new Date();

		format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dataFormatada = format.format(data);

		File doc = new File("Sucesso-Locacao-Site.txt");
	
		if (doc.exists()) {
			FileWriter arquivo = new FileWriter("Sucesso-Locacao-Site.txt", true);
			PrintWriter gravarArq = new PrintWriter(arquivo, true);
			gravarArq.printf("\n" + dataFormatada + " --> Reserva nacional confirmada. Código: " + numeroReserva);
			arquivo.close();
		} else {
			FileWriter arquivo = new FileWriter("Sucesso-Locacao-Site.txt");
			PrintWriter gravarArq = new PrintWriter(arquivo);
			gravarArq.printf(dataFormatada + " --> Reserva nacional confirmada. Código: " + numeroReserva);
			arquivo.close();

		}

	}
	
	public void GravaLocacaoInternacional(String numeroReserva) throws IOException {
		data = new Date();

		format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dataFormatada = format.format(data);

		File doc = new File("Sucesso-Locacao-Site.txt");
	
		if (doc.exists()) {
			FileWriter arquivo = new FileWriter("Sucesso-Locacao-Site.txt", true);
			PrintWriter gravarArq = new PrintWriter(arquivo, true);
			gravarArq.printf("\n" + dataFormatada + " --> Reserva internacional confirmada. Código: " + numeroReserva);
			arquivo.close();
		} else {
			FileWriter arquivo = new FileWriter("Sucesso-Locacao-Site.txt");
			PrintWriter gravarArq = new PrintWriter(arquivo);
			gravarArq.printf(dataFormatada + " --> Reserva internacional confirmada. Código: " + numeroReserva);
			arquivo.close();

		}

	}
	
	public void GravaLocacaoOpcional(String numeroReserva) throws IOException {
		data = new Date();

		format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dataFormatada = format.format(data);

		File doc = new File("Sucesso-Locacao-Site.txt");
	
		if (doc.exists()) {
			FileWriter arquivo = new FileWriter("Sucesso-Locacao-Site.txt", true);
			PrintWriter gravarArq = new PrintWriter(arquivo, true);
			gravarArq.printf("\n" + dataFormatada + " --> Reserva com opcional confirmada. Código: " + numeroReserva);
			arquivo.close();
		} else {
			FileWriter arquivo = new FileWriter("Sucesso-Locacao-Site.txt");
			PrintWriter gravarArq = new PrintWriter(arquivo);
			gravarArq.printf(dataFormatada + " --> Reserva com opcional confirmada. Código: " + numeroReserva);
			arquivo.close();

		}

	}
	
	public void GravaLocacaoHoraExcedente(String numeroReserva) throws IOException {
		data = new Date();

		format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dataFormatada = format.format(data);

		File doc = new File("Sucesso-Locacao-Site.txt");
	
		if (doc.exists()) {
			FileWriter arquivo = new FileWriter("Sucesso-Locacao-Site.txt", true);
			PrintWriter gravarArq = new PrintWriter(arquivo, true);
			gravarArq.printf("\n" + dataFormatada + " --> Reserva com hora excedente confirmada. Código: " + numeroReserva);
			arquivo.close();
		} else {
			FileWriter arquivo = new FileWriter("Sucesso-Locacao-Site.txt");
			PrintWriter gravarArq = new PrintWriter(arquivo);
			gravarArq.printf(dataFormatada + " --> Reserva com hora excedente confirmada. Código: " + numeroReserva);
			arquivo.close();

		}

	}
	
	public void GravaLocacaoTaxaRetorno(String numeroReserva) throws IOException {
		data = new Date();

		format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dataFormatada = format.format(data);

		File doc = new File("Sucesso-Locacao-Site.txt");
	
		if (doc.exists()) {
			FileWriter arquivo = new FileWriter("Sucesso-Locacao-Site.txt", true);
			PrintWriter gravarArq = new PrintWriter(arquivo, true);
			gravarArq.printf("\n" + dataFormatada + " --> Reserva com taxa de retorno confirmada. Código: " + numeroReserva);
			arquivo.close();
		} else {
			FileWriter arquivo = new FileWriter("Sucesso-Locacao-Site.txt");
			PrintWriter gravarArq = new PrintWriter(arquivo);
			gravarArq.printf(dataFormatada + " --> Reserva com taxa de retorno confirmada. Código: " + numeroReserva);
			arquivo.close();

		}

	}
	
	public void GravaCancelamentoLocacao(String splitTexto) throws IOException{	
		data = new Date();

		format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dataFormatada = format.format(data);

		File doc = new File("Cancelamento-Locacao-Site.txt");
		if (doc.exists()) {
			FileWriter arquivo = new FileWriter("Cancelamento-Locacao-Site.txt", true);
			PrintWriter gravarArq = new PrintWriter(arquivo, true);
			gravarArq.printf("\n" + dataFormatada + " --> Reserva cancelada. NÂº:" + splitTexto);
			arquivo.close();
		} else {
			FileWriter arquivo = new FileWriter("Cancelamento-Locacao-Site.txt");
			PrintWriter gravarArq = new PrintWriter(arquivo);
			gravarArq.printf(dataFormatada + " --> Reserva cancelada. NÂº:" + splitTexto);
			arquivo.close();
		}
		
	}
	
}
