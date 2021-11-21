package model;

import java.util.Objects;

public class Manutencao {
	private String manutencaoData;
	private double manutencaoValor;
	private String descricaoServico;
	private Carro carro;
	
	public Manutencao()
	{
		
	}

	public String getManutencaoData() {
		return manutencaoData;
	}

	public void setManutencaoData(String manutencaoData) {
		this.manutencaoData = manutencaoData;
	}

	public double getManutencaoValor() {
		return manutencaoValor;
	}

	public void setManutencaoValor(double manutencaoValor) {
		this.manutencaoValor = manutencaoValor;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carro, descricaoServico, manutencaoData, manutencaoValor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manutencao other = (Manutencao) obj;
		return Objects.equals(carro, other.carro) && Objects.equals(descricaoServico, other.descricaoServico)
				&& Objects.equals(manutencaoData, other.manutencaoData)
				&& Double.doubleToLongBits(manutencaoValor) == Double.doubleToLongBits(other.manutencaoValor);
	}

	@Override
	public String toString() {
		return "Manutencao [manutencaoData=" + manutencaoData + ", manutencaoValor=" + manutencaoValor
				+ ", descricaoServico=" + descricaoServico + ", carro=" + carro + "]";
	}
	
	public double ValorManutencao(String valor)
	{
		double valorManutencao = Double.parseDouble(valor);
		return valorManutencao;
	}
	
	
}
