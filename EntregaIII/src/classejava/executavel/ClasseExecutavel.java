package classejava.executavel;

import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.JOptionPane;

import classes.java.Admin;
import classes.java.Carro;
import classes.java.Manutencao;
import classes.java.Usuario;
import classes.java.Vaga;

public class ClasseExecutavel {
	public static void main(String[] args) throws ClassNotFoundException {
		
		int cadastrar = JOptionPane.showConfirmDialog(null, "Quer cadastrar um administrador?");
		
		
		if(cadastrar==0)
		{
			Admin admin = new Admin();
			String nome = JOptionPane.showInputDialog("Informe o nome do administrador:");
			String login = JOptionPane.showInputDialog("Informe o login do administrador:");
			String senha = JOptionPane.showInputDialog("Informe a senha do administrador:");		
			String cpf = JOptionPane.showInputDialog("Informe o CPF do administrador:");	
			String dia = JOptionPane.showInputDialog("Informe o dia de nascimento do administrador:");
			int diaInt = Integer.parseInt(dia);
			String mes = JOptionPane.showInputDialog("Informe o mês de nascimento do administrador:");	
			int mesInt = Integer.parseInt(mes);
			String ano = JOptionPane.showInputDialog("Informe o ano de nascimento do administrador:");	
			int anoInt = Integer.parseInt(ano);
			String email1 = JOptionPane.showInputDialog("Informe o email do administrador:");
			String email2 = JOptionPane.showInputDialog("Informe um email secundário para recuperação da conta do administrador:");
			String qtd = JOptionPane.showInputDialog("Quantas permissões o administrador terá?");
			int tamanho = Integer.parseInt(qtd);
			String[] permissoes = new String[tamanho];
			for(int i=0;i <permissoes.length;i++)
			{
				String permissao = JOptionPane.showInputDialog("Qual a "+(i+1)+"ª permissão?");
				permissoes[i] = permissao; 
			}
			LocalDate dataNasc = LocalDate.of(anoInt, mesInt, diaInt);
			Calendar agora = Calendar.getInstance();
			
			admin.setNome(nome);
			admin.setLogin(login);
			admin.setSenha(senha);
			admin.setEmail(email1);
			admin.setEmailSecundario(email2);
			admin.setCpf(cpf);
			admin.setDiaNasc(diaInt);
			admin.setMesNasc(mesInt);
			admin.setAnoNasc(anoInt);
			admin.setPermissoes(permissoes);
			
			cadastrar = JOptionPane.showConfirmDialog(null, "Gostaria de testar o login do administrador?");
			
			if(cadastrar==0)
			{
				String loginVerifica = JOptionPane.showInputDialog("Informe o login do administrador:");
				String senhaVerifica = JOptionPane.showInputDialog("Informe a senha do administrador:");
				
				if(admin.autenticar(loginVerifica, senhaVerifica)) {
					JOptionPane.showMessageDialog(null, "Acesso permitido");
					
				}else {
					JOptionPane.showMessageDialog(null, "Acesso não permitido");
				}
			}
			
			//USO DO MÉTODO PESSOAIDADE QUE RETORNA A IDADE QUE A PESSOA POSSUI
			//System.out.println(admin.pessoaIdade(dataNasc, LocalDate.of(agora.get(Calendar.YEAR), agora.get(Calendar.MONTH), agora.get(Calendar.DAY_OF_MONTH))));
		}
		
		cadastrar = JOptionPane.showConfirmDialog(null, "Quer cadastrar um Usuário?");
		
		if(cadastrar==0)
		{
			Usuario usuario = new Usuario();
			String nome = JOptionPane.showInputDialog("Informe o nome do usuário:");
			String login = JOptionPane.showInputDialog("Informe o login do usuário:");
			String senha = JOptionPane.showInputDialog("Informe a senha do usuário:");		
			String cpf = JOptionPane.showInputDialog("Informe o CPF do usuário:");	
			String dia = JOptionPane.showInputDialog("Informe o dia de nascimento do usuário:");	
			int diaInt = Integer.parseInt(dia);
			String mes = JOptionPane.showInputDialog("Informe o mês de nascimento do usuário:");	
			int mesInt = Integer.parseInt(mes);
			String ano = JOptionPane.showInputDialog("Informe o ano de nascimento do usuário:");	
			int anoInt = Integer.parseInt(ano);
			String email = JOptionPane.showInputDialog("Informe o email do usuário:");
			String endereco = JOptionPane.showInputDialog("Informe o endereço do usuário:");
			String renda = JOptionPane.showInputDialog("Informe a renda do usuário:");
			//double rendaDouble = Double.parseDouble(renda);
			double rendaDouble = usuario.ValorRenda(renda);
			usuario.setNome(nome);
			usuario.setLogin(login);
			usuario.setSenha(senha);
			usuario.setEmail(email);
			usuario.setCpf(cpf);
			usuario.setDiaNasc(diaInt);
			usuario.setMesNasc(mesInt);
			usuario.setAnoNasc(anoInt);
			usuario.setEndereco(endereco);
			usuario.setRenda(rendaDouble);
			}
		
		cadastrar = JOptionPane.showConfirmDialog(null, "Quer cadastrar um Carro?");
		
		if(cadastrar==0)
		{
			Carro carro = new Carro();
			String placa = JOptionPane.showInputDialog("Informe a placa do veículo:");
			String modelo = JOptionPane.showInputDialog("Informe o modelo do veículo:");
			String preco = JOptionPane.showInputDialog("Informe o preço do veículo:");
			//double precoDouble = Double.parseDouble(preco);
			double precoDouble = carro.ValorCarro(preco);
			carro.setPlaca(placa);
			carro.setModelo(modelo);
			carro.setPreco(precoDouble);
			cadastrar = JOptionPane.showConfirmDialog(null, "Este Carro recebeu manutenção recentemente?");
			if(cadastrar==0)
			{
				Manutencao manutencao = new Manutencao();
				String dataManutencao = JOptionPane.showInputDialog("Qual foi a data desta manutenção?");
				String valorManutencao = JOptionPane.showInputDialog("Qual foi o valor desta manutenção?");
				//double valorManutencaoDouble = Double.parseDouble(valorManutencao);
				double valorManutencaoDouble = manutencao.ValorManutencao(valorManutencao);
				String descManutencao = JOptionPane.showInputDialog("Escreva uma breve descrição desta manutenção:");
				manutencao.setManutencaoData(dataManutencao);
				manutencao.setManutencaoValor(valorManutencaoDouble);
				manutencao.setDescricaoServico(descManutencao);
				manutencao.setCarro(carro);
			}
			cadastrar = JOptionPane.showConfirmDialog(null, "Este Carro está presente em uma vaga?");
			Vaga vaga = new Vaga();
			vaga.setCarro(carro);
			if(cadastrar==0)
			{
				vaga.setDisponivel(false);
			}
			else
			{
				vaga.setDisponivel(true);
			}
		}
		
	}
}
