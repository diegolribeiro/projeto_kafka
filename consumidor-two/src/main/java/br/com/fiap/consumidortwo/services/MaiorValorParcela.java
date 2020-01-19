package br.com.fiap.consumidortwo.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MaiorValorParcela {
	private String nisFavorecido;
	private String nomeFavorecido;
	private BigDecimal valor;
	private String nomeMunicipio;
	private String uf;
	static List<MaiorValorParcela> listaParcelas = new ArrayList<>();

	public BigDecimal getValor() {
		return valor;
	}

	public String getNisFavorecido() {
		return nisFavorecido;
	}

	public String getNomeFavorecido() {
		return nomeFavorecido;
	}

	public String getNomeMunicipio() {
		return nomeMunicipio;
	}

	public String getUf() {
		return uf;
	}

	public static List<MaiorValorParcela> getListaParcelas() {
		return listaParcelas;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public MaiorValorParcela(String nisFavorecido, String nomeFavorecido, BigDecimal valor, String nomeMunicipio,
			String uf) {
		this.nisFavorecido = nisFavorecido;
		this.nomeFavorecido = nomeFavorecido;
		this.valor = valor;
		this.nomeMunicipio = nomeMunicipio;
		this.uf = uf;
	}

}
