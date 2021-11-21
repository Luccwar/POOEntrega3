package EntregaIII.EntregaIII;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import conexao.jdbc.SingleConnection;
import dao.ClasseDAO;
import model.Admin;
import model.Usuario;

public class TesteBancoJdbc {
	
	/*@Test
	public void initBanco()
	{
		SingleConnection.getConnection();
	}*/
	
	@Test
	public void initBancoUsuario() {
		Usuario usuario = new Usuario();
		ClasseDAO classeDao = new ClasseDAO();
		
		//classeDao.salvar(usuario);
		
		//usuario.setId(2L);
		usuario.setNome("Lucas");
		usuario.setDiaNasc(5);
		usuario.setMesNasc(3);
		usuario.setAnoNasc(2001);
		usuario.setCpf("098.987.406-16");
		usuario.setLogin("Lucas");
		usuario.setEmail("Lucas@gmail.com");
		usuario.setSenha("123321");
		usuario.setEndereco("Rua Viela Dezenove");
		usuario.setRenda(400.00);
		
		/*usuario.setNome("Robervaldo");
		usuario.setDiaNasc(25);
		usuario.setMesNasc(10);
		usuario.setAnoNasc(1997);
		usuario.setCpf("498.256.168-98");
		usuario.setLogin("Robs");
		usuario.setEmail("Robs@gmail.com");
		usuario.setSenha("321123");
		usuario.setEndereco("Rua Segunda");
		usuario.setRenda(2350.00);*/
		
		/*usuario.setNome("Janice");
		usuario.setDiaNasc(13);
		usuario.setMesNasc(12);
		usuario.setAnoNasc(2000);
		usuario.setCpf("984.549.654-85");
		usuario.setLogin("Janilce");
		usuario.setEmail("Janilce@gmail.com");
		usuario.setSenha("221133");
		usuario.setEndereco("Rua Dois Mais Dois");
		usuario.setRenda(800.00);*/
		
		classeDao.salvarUsuario(usuario);
	}
	
	@Test
	public void initBancoAdmin() {
		Admin admin = new Admin();
		ClasseDAO classeDao = new ClasseDAO();
		
		admin.setNome("Ademiro");
		admin.setDiaNasc(16);
		admin.setMesNasc(9);
		admin.setAnoNasc(1991);
		admin.setCpf("495.785.351-65");
		String[] permissoes = {"Criar","Editar","Deletar"};
		admin.setPermissoes(permissoes);
		admin.setLogin("Admin");
		admin.setEmail("Admin@gmail.com");
		admin.setEmailSecundario("Ademiro@gmail.com");
		admin.setSenha("grandeAdemiro");
		
		/*admin.setNome("Kerolin");
		admin.setDiaNasc(14);
		admin.setMesNasc(2);
		admin.setAnoNasc(1997);
		admin.setCpf("039.569.000-56");
		String[] permissoes2 = {"Criar","Editar"};
		admin.setPermissoes(permissoes2);
		admin.setLogin("Keroline");
		admin.setEmail("Kerolin@outlook.com");
		admin.setEmailSecundario("Kerolin@gmail.com");
		admin.setSenha("Kerolin123");*/

		/*admin.setNome("Ezequiéu");
		admin.setDiaNasc(6);
		admin.setMesNasc(1);
		admin.setAnoNasc(2000);
		admin.setCpf("684.128.988-90");
		String[] permissoes3 = {"Criar","Editar","Deletar", "Front-End", "Back-End"};
		admin.setPermissoes(permissoes3);
		admin.setLogin("Ezequielo");
		admin.setEmail("EzequielDeRegata@gmail.com");
		admin.setEmailSecundario("EzequielDeOculos@gmail.com");
		admin.setSenha("EzequielDeRegataEOculos");*/
		
		
		classeDao.salvarAdmin(admin);
	}
	
	@Test
	public void initListarUsuario() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			List<Usuario> list = classeDao.listarUsuario();
			System.out.println("----------------");
			for(Usuario usuario : list) {
				System.out.println("Nome: " + usuario.getNome());
				System.out.println("Dia em que nasceu: " + usuario.getDiaNasc());
				System.out.println("Mês em que nasceu: " + usuario.getMesNasc());
				System.out.println("Ano em que nasceu: " + usuario.getAnoNasc());
				System.out.println("CPF: " + usuario.getCpf());
				System.out.println("Login: " + usuario.getLogin());
				System.out.println("Email: " + usuario.getEmail());
				System.out.println("Senha: " + usuario.getSenha());
				System.out.println("Endereço: " + usuario.getEndereco());
				System.out.println("Renda: " + usuario.getRenda());
				System.out.println("----------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void initListarAdmin() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			List<Admin> list = classeDao.listarAdmin();
			System.out.println("----------------");
			for(Admin admin : list) {
				System.out.println("Nome: " + admin.getNome());
				System.out.println("Dia em que nasceu: " + admin.getDiaNasc());
				System.out.println("Mês em que nasceu: " + admin.getMesNasc());
				System.out.println("Ano em que nasceu: " + admin.getAnoNasc());
				System.out.println("CPF: " + admin.getCpf());
				//A linha abaixo pega o array passado na DAO e exibe as informações convertidas
				System.out.println("Permissões: " + Arrays.toString(admin.getPermissoes()));
				System.out.println("Login: " + admin.getLogin());
				System.out.println("Email: " + admin.getEmail());
				System.out.println("Senha: " + admin.getSenha());
				System.out.println("----------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void initBuscarUsuario() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			Usuario usuario = classeDao.buscarUsuario(1L);
			
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Dia em que nasceu: " + usuario.getDiaNasc());
			System.out.println("Mês em que nasceu: " + usuario.getMesNasc());
			System.out.println("Ano em que nasceu: " + usuario.getAnoNasc());
			System.out.println("CPF: " + usuario.getCpf());
			System.out.println("Login: " + usuario.getLogin());
			System.out.println("Email: " + usuario.getEmail());
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Endereço: " + usuario.getEndereco());
			System.out.println("Renda: " + usuario.getRenda());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscarAdmin() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			Admin admin = classeDao.buscarAdmin(5L);
			
			System.out.println("Nome: " + admin.getNome());
			System.out.println("Dia em que nasceu: " + admin.getDiaNasc());
			System.out.println("Mês em que nasceu: " + admin.getMesNasc());
			System.out.println("Ano em que nasceu: " + admin.getAnoNasc());
			System.out.println("CPF: " + admin.getCpf());
			//A linha abaixo pega o array passado na DAO e exibe as informações convertidas
			System.out.println("Permissões: " + Arrays.toString(admin.getPermissoes()));
			System.out.println("Login: " + admin.getLogin());
			System.out.println("Email: " + admin.getEmail());
			System.out.println("Senha: " + admin.getSenha());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizarNomeUsuario() {
		
		try {
			ClasseDAO classeDao = new ClasseDAO();
			Usuario usuario = classeDao.buscarUsuario(1L);
			
			usuario.setNome("Lucástico");
			
			classeDao.atualizarNomeUsuario(usuario);
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
	}
	
	@Test
	public void initAtualizarNomeAdmin() {
		
		try {
			ClasseDAO classeDao = new ClasseDAO();
			Admin admin = classeDao.buscarAdmin(5L);
			
			admin.setNome("Ademiroliro");
			
			classeDao.atualizarNomeAdmin(admin);
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
	}
	
	@Test
	public void initDeletarUsuario() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			classeDao.deletarUsuario(3L);
					
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void initDeletarAdmin() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			classeDao.deletarAdmin(7L);
					
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	/*@Test
	public void salvarTelefone() {
		Telefone telefone = new Telefone();
		ClasseDAO classeDAO = new ClasseDAO();
		telefone.setNumero("99900334455");
		telefone.setTipo("comercial");
		telefone.setIdAluno(10L);
		
		classeDAO.salvarTelefone(telefone);
	}
	@Test
	public void initListarAlunoTelefone() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			List<BeanAlunoFone> list = classeDao.listarAlunoFone(11L);
			
			for(BeanAlunoFone beanAlunoFone : list) {
				System.out.println(beanAlunoFone.toString());
				System.out.println("--------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}*/
	
	@Test
	public void initDeletarCascata() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			classeDao.deletarCascata(10L);
					
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
