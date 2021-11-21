package classes.java;

import java.util.Objects;

public class Carro {
	private String placa;
	private String modelo;
	private double preco;
	
	public Carro()
	{
		
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(modelo, placa, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(modelo, other.modelo) && Objects.equals(placa, other.placa)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}

	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", modelo=" + modelo + ", preco=" + preco + "]";
	}
	
	public double ValorCarro(String valor)
	{
		double valorCarro = Double.parseDouble(valor);
		return valorCarro;
	}
	
	
}
