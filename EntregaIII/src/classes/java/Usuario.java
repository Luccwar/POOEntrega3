package classes.java;

import java.util.Objects;

public class Usuario extends Pessoa {
	private String login;
	private String email;
	private String senha;
	private String endereco;
	private double renda;
	
	public Usuario()
	{
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(email, endereco, login, renda, senha);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(login, other.login)
				&& Double.doubleToLongBits(renda) == Double.doubleToLongBits(other.renda)
				&& Objects.equals(senha, other.senha);
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", email=" + email + ", senha=" + senha + ", endereco=" + endereco
				+ ", renda=" + renda + "]";
	}
	
	public double ValorRenda(String valor)
	{
		double valorRenda = Double.parseDouble(valor);
		return valorRenda;
	}
	
}
