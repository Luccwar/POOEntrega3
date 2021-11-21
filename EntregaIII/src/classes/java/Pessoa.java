package classes.java;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Pessoa {
	protected String nome;
	protected int diaNasc;
	protected int mesNasc;
	protected int anoNasc;
	protected String cpf;
	
	public Pessoa()
	{
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDiaNasc() {
		return diaNasc;
	}
	public void setDiaNasc(int diaNasc) {
		this.diaNasc = diaNasc;
	}
	public int getMesNasc() {
		return mesNasc;
	}
	public void setMesNasc(int mesNasc) {
		this.mesNasc = mesNasc;
	}
	public int getAnoNasc() {
		return anoNasc;
	}
	public void setAnoNasc(int anoNasc) {
		this.anoNasc = anoNasc;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(anoNasc, cpf, diaNasc, mesNasc, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return anoNasc == other.anoNasc && Objects.equals(cpf, other.cpf) && diaNasc == other.diaNasc
				&& mesNasc == other.mesNasc && Objects.equals(nome, other.nome);
	}
	
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", diaNasc=" + diaNasc + ", mesNasc=" + mesNasc + ", anoNasc=" + anoNasc
				+ ", cpf=" + cpf + "]";
	}
	
	public int pessoaIdade(LocalDate dataNascimento, LocalDate dataAtual) {
		if ((dataNascimento != null) && (dataAtual != null)) {
            return Period.between(dataNascimento, dataAtual).getYears();
        } else {
            return 0;
        }
	}
	
	
}
