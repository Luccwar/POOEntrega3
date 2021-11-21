package classes.java;

import java.util.Objects;

public class Vaga {
	private boolean disponivel;
	private Carro carro;
	
	public Vaga()
	{
		
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carro, disponivel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaga other = (Vaga) obj;
		return Objects.equals(carro, other.carro) && disponivel == other.disponivel;
	}

	@Override
	public String toString() {
		return "Vaga [disponivel=" + disponivel + ", carro=" + carro + "]";
	}
	
	public String carroPlaca()
	{
		return carro.getPlaca();
	}
	
	
}
