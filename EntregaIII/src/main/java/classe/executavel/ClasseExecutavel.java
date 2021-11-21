package classe.executavel;

import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.JOptionPane;

import model.Admin;
import model.Carro;
import model.Manutencao;
import model.Usuario;
import model.Vaga;

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
			String mes = JOptionPane.showInputDialog("Informe o m�s de nascimento do administrador:");	
			int mesInt = Integer.parseInt(mes);
			String ano = JOptionPane.showInputDialog("Informe o ano de nascimento do administrador:");	
			int anoInt = Integer.parseInt(ano);
			String email1 = JOptionPane.showInputDialog("Informe o email do administrador:");
			String email2 = JOptionPane.showInputDialog("Informe um email secund�rio para recupera��o da conta do administrador:");
			String qtd = JOptionPane.showInputDialog("Quantas permiss�es o administrador ter�?");
			int tamanho = Integer.parseInt(qtd);
			String[] permissoes = new String[tamanho];
			for(int i=0;i <permissoes.length;i++)
			{
				String permissao = JOptionPane.showInputDialog("Qual a "+(i+1)+"� permiss�o?");
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
					JOptionPane.showMessageDialog(null, "Acesso n�o permitido");
				}
			}
			
			//USO DO M�TODO PESSOAIDADE QUE RETORNA A IDADE QUE A PESSOA POSSUI
			//System.out.println(admin.pessoaIdade(dataNasc, LocalDate.of(agora.get(Calendar.YEAR), agora.get(Calendar.MONTH), agora.get(Calendar.DAY_OF_MONTH))));
		}
		
		cadastrar = JOptionPane.showConfirmDialog(null, "Quer cadastrar um Usu�rio?");
		
		if(cadastrar==0)
		{
			Usuario usuario = new Usuario();
			String nome = JOptionPane.showInputDialog("Informe o nome do usu�rio:");
			String login = JOptionPane.showInputDialog("Informe o login do usu�rio:");
			String senha = JOptionPane.showInputDialog("Informe a senha do usu�rio:");		
			String cpf = JOptionPane.showInputDialog("Informe o CPF do usu�rio:");	
			String dia = JOptionPane.showInputDialog("Informe o dia de nascimento do usu�rio:");	
			int diaInt = Integer.parseInt(dia);
			String mes = JOptionPane.showInputDialog("Informe o m�s de nascimento do usu�rio:");	
			int mesInt = Integer.parseInt(mes);
			String ano = JOptionPane.showInputDialog("Informe o ano de nascimento do usu�rio:");	
			int anoInt = Integer.parseInt(ano);
			String email = JOptionPane.showInputDialog("Informe o email do usu�rio:");
			String endereco = JOptionPane.showInputDialog("Informe o endere�o do usu�rio:");
			String renda = JOptionPane.showInputDialog("Informe a renda do usu�rio:");
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
			String placa = JOptionPane.showInputDialog("Informe a placa do ve�culo:");
			String modelo = JOptionPane.showInputDialog("Informe o modelo do ve�culo:");
			String preco = JOptionPane.showInputDialog("Informe o pre�o do ve�culo:");
			//double precoDouble = Double.parseDouble(preco);
			double precoDouble = carro.ValorCarro(preco);
			carro.setPlaca(placa);
			carro.setModelo(modelo);
			carro.setPreco(precoDouble);
			cadastrar = JOptionPane.showConfirmDialog(null, "Este Carro recebeu manuten��o recentemente?");
			if(cadastrar==0)
			{
				Manutencao manutencao = new Manutencao();
				String dataManutencao = JOptionPane.showInputDialog("Qual foi a data desta manuten��o?");
				String valorManutencao = JOptionPane.showInputDialog("Qual foi o valor desta manuten��o?");
				//double valorManutencaoDouble = Double.parseDouble(valorManutencao);
				double valorManutencaoDouble = manutencao.ValorManutencao(valorManutencao);
				String descManutencao = JOptionPane.showInputDialog("Escreva uma breve descri��o desta manuten��o:");
				manutencao.setManutencaoData(dataManutencao);
				manutencao.setManutencaoValor(valorManutencaoDouble);
				manutencao.setDescricaoServico(descManutencao);
				manutencao.setCarro(carro);
			}
			cadastrar = JOptionPane.showConfirmDialog(null, "Este Carro est� presente em uma vaga?");
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
