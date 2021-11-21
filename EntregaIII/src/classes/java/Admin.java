package classes.java;

import java.util.Arrays;
import java.util.Objects;

import interfaces.PermitirAcesso;

public class Admin extends Pessoa implements PermitirAcesso{
	private String[] permissoes;
	private String login;
	private String email;
	private String emailSecundario;
	private String senha;
	
	public Admin()
	{
		
	}
	
	public Admin(String login, String senha) {
		this.login = login;
		this.senha = senha;
		
	}
	
	public String[] getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(String[] permissoes) {
		this.permissoes = permissoes;
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
	public String getEmailSecundario() {
		return emailSecundario;
	}
	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(permissoes);
		result = prime * result + Objects.hash(email, emailSecundario, login, senha);
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
		Admin other = (Admin) obj;
		return Objects.equals(email, other.email) && Objects.equals(emailSecundario, other.emailSecundario)
				&& Objects.equals(login, other.login) && Arrays.equals(permissoes, other.permissoes)
				&& Objects.equals(senha, other.senha);
	}
	@Override
	public String toString() {
		return "Admin [permissoes=" + Arrays.toString(permissoes) + ", login=" + login + ", email=" + email
				+ ", emailSecundario=" + emailSecundario + ", senha=" + senha + "]";
	}

	@Override
	public boolean autenticar(String login, String senha) {
		return this.login.equals(login) && this.senha.equals(senha);
		
	}

	
	public boolean autenticar() {
		
		return false;
	}
	
}
