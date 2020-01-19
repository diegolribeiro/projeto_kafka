package br.com.fiap.consumidortwo.services;

import java.math.BigDecimal;
import java.util.Comparator;

import org.springframework.stereotype.Service;

import br.com.fiap.consumidortwo.domain.BolsaFamiliaModel;

@Service
public class ConsumerService {

	public void consume(BolsaFamiliaModel model) {
		if (model != null) {
			String nisFavorecido = model.getNisFavorecido();
			String nomeFavorecido = model.getNomeFavorecido();
			String value = model.getValorParcela();
			String nomeMunicipio = model.getNomeMunicipio();
			String uf = model.getUf();

			BigDecimal valor = new BigDecimal(value.replace(',', '.'));

			MaiorValorParcela.listaParcelas
					.add(new MaiorValorParcela(nisFavorecido, nomeFavorecido, valor, nomeMunicipio, uf));
		}
		
		if (MaiorValorParcela.listaParcelas.size() > 0) {
			System.out.println("<<================Maior Parcela Paga pelo Bolsa Familia==============>>");
			MaiorValorParcela.listaParcelas.sort(Comparator.comparing(MaiorValorParcela::getValor).reversed());
			MaiorValorParcela maiorValorParcela = MaiorValorParcela.listaParcelas.get(0);
			System.out.println("Nome do Favorecido: " + maiorValorParcela.getNomeFavorecido());
			System.out.println("Nis do Favorecido: " + maiorValorParcela.getNisFavorecido());
			System.out.println("Nome do Municipio: " + maiorValorParcela.getNomeMunicipio());
			System.out.println("Estado: " + maiorValorParcela.getUf());
			System.out.println("Valor da Parcela: " + maiorValorParcela.getValor());
			System.out.println("");
		}

	}

}
