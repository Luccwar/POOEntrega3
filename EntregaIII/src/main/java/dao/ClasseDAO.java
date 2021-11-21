package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.jdbc.SingleConnection;
import model.Admin;
import model.Usuario;

public class ClasseDAO {

	private Connection connection;

	public ClasseDAO() {
		connection = SingleConnection.getConnection();
	}

	// Insert
	public void salvarUsuario(Usuario usuario) {
		try {
			//String sql = "insert into usuariojdbc(id, login, senha) values(?,?,?)";
			String sql = "insert into usuariojdbc(nome, dianasc, mesnasc, anonasc, cpf, login, email, senha, endereco, renda) values(?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			 /*statement.setLong(1, 1);
			 statement.setString(2, "Rodrigo");
			 statement.setString(3,"rodrigoteste@gmail.com");*/
			 
		    /*statement.setLong(1, usuario.getId());
			statement.setString(2, usuario.getLogin());
			statement.setString(3, usuario.getSenha());*/
			
			statement.setString(1, usuario.getNome());
			statement.setInt(2, usuario.getDiaNasc());
			statement.setInt(3, usuario.getMesNasc());
			statement.setInt(4, usuario.getAnoNasc());
			statement.setString(5, usuario.getCpf());
			statement.setString(6, usuario.getLogin());
			statement.setString(7, usuario.getEmail());
			statement.setString(8, usuario.getSenha());
			statement.setString(9, usuario.getEndereco());
			statement.setDouble(10, usuario.getRenda());
			
			
			statement.execute();
			connection.commit();// Executa no banco

		} catch (Exception e) {
			try {
				connection.rollback();// Reverte a operação
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void salvarAdmin(Admin admin) {
		try {
			//String sql = "insert into usuariojdbc(id, login, senha) values(?,?,?)";
			String sql = "insert into adminjdbc(nome, dianasc, mesnasc, anonasc, cpf, permissoes, login, email, emailsecundario, senha) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			 /*statement.setLong(1, 1);
			 statement.setString(2, "Rodrigo");
			 statement.setString(3,"rodrigoteste@gmail.com");*/
			 
		    /*statement.setLong(1, usuario.getId());
			statement.setString(2, usuario.getLogin());
			statement.setString(3, usuario.getSenha());*/
			
			statement.setString(1, admin.getNome());
			statement.setInt(2, admin.getDiaNasc());
			statement.setInt(3, admin.getMesNasc());
			statement.setInt(4, admin.getAnoNasc());
			statement.setString(5, admin.getCpf());
			
			// Para inserir um array de Strings no banco é necessário converter o array de Strings para uma variável do tipo Array
			Array permissoes = connection.createArrayOf("VARCHAR", admin.getPermissoes());
			statement.setArray(6, permissoes);
			
			statement.setString(7, admin.getLogin());
			statement.setString(8, admin.getEmail());
			statement.setString(9, admin.getEmailSecundario());
			statement.setString(10, admin.getSenha());
			
			
			statement.execute();
			connection.commit();// Executa no banco

		} catch (Exception e) {
			try {
				connection.rollback();// Reverte a operação
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	/*public void salvarTelefone(Telefone telefone) {
		try {
			String sql = "INSERT INTO telefonealuno( numero, tipo, usuario) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			 
			statement.setString(1, telefone.getNumero());	
			statement.setString(2, telefone.getTipo());
			statement.setLong(3, telefone.getIdAluno());
			
			statement.execute();
			connection.commit();// Executa no banco

		} catch (Exception e) {
			try {
				connection.rollback();// Reverte a operação
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}*/

public List<Usuario> listarUsuario() throws Exception {
		
		List<Usuario> list = new ArrayList<Usuario>();

		String sql = "select * from usuariojdbc";

		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {
			Usuario usuario = new Usuario();
			
			usuario.setId(resultado.getLong("id"));
			usuario.setNome(resultado.getString("nome"));
			usuario.setDiaNasc(resultado.getInt("dianasc"));
			usuario.setMesNasc(resultado.getInt("mesnasc"));
			usuario.setAnoNasc(resultado.getInt("anonasc"));
			usuario.setCpf(resultado.getString("cpf"));
			usuario.setLogin(resultado.getString("login"));
			usuario.setEmail(resultado.getString("email"));
			usuario.setSenha(resultado.getString("senha"));
			usuario.setEndereco(resultado.getString("endereco"));
			usuario.setRenda(resultado.getDouble("renda"));

			list.add(usuario);

		}

		return list;
	}

	public List<Admin> listarAdmin() throws Exception {
		
		List<Admin> list = new ArrayList<Admin>();
	
		String sql = "select * from adminjdbc";
	
		PreparedStatement statement = connection.prepareStatement(sql);
	
		ResultSet resultado = statement.executeQuery();
	
		while (resultado.next()) {
			Admin admin = new Admin();
			
			admin.setId(resultado.getLong("id"));
			admin.setNome(resultado.getString("nome"));
			admin.setDiaNasc(resultado.getInt("dianasc"));
			admin.setMesNasc(resultado.getInt("mesnasc"));
			admin.setAnoNasc(resultado.getInt("anonasc"));
			admin.setCpf(resultado.getString("cpf"));
			//admin.setPermissoes(resultado.getString("permissoes"));
			for(int i = 0; i<resultado.getString("permissoes").length();i++)
			{
				admin.setPermissoes(resultado.getArray("permissoes").toString().split(""));
			}
			admin.setLogin(resultado.getString("login"));
			admin.setEmail(resultado.getString("email"));
			admin.setEmail(resultado.getString("emailsecundario"));
			admin.setSenha(resultado.getString("senha"));
	
			list.add(admin);
	
		}
	
		return list;
	}
	
/*public List<BeanAlunoFone> listarAlunoFone(Long idAluno) throws Exception {
		
		List<BeanAlunoFone> list = new ArrayList<BeanAlunoFone>();

		String sql = " select nome, email, numero, tipo from telefonealuno as fone ";
		sql+=" inner join alunojdbc as aluno ";
		sql+=" on fone.usuario = aluno.id ";
		sql+=" where aluno.id = "+idAluno;

		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {
			BeanAlunoFone beanAlunoFone = new BeanAlunoFone();
			beanAlunoFone.setNome(resultado.getString("nome"));
			beanAlunoFone.setNumero(resultado.getString("numero"));
			beanAlunoFone.setEmail(resultado.getString("email"));
			beanAlunoFone.setTipo(resultado.getString("tipo"));

			list.add(beanAlunoFone);
		}

		return list;
	}
*/
	public Usuario buscar(Long id) throws Exception {
		Usuario usuario = new Usuario();

		String sql = "select * from usuariojdbc where id =" + id;

		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {
			usuario.setId(resultado.getLong("id"));
			usuario.setNome(resultado.getString("nome"));
			usuario.setDiaNasc(resultado.getInt("dianasc"));
			usuario.setMesNasc(resultado.getInt("mesnasc"));
			usuario.setAnoNasc(resultado.getInt("anonasc"));
			usuario.setCpf(resultado.getString("cpf"));
			usuario.setLogin(resultado.getString("login"));
			usuario.setEmail(resultado.getString("email"));
			usuario.setSenha(resultado.getString("senha"));
			usuario.setEndereco(resultado.getString("endereco"));
			usuario.setRenda(resultado.getDouble("renda"));

		}

		return usuario;
	}

	public void atualizarNomeUsuario(Usuario usuario) {

		try {
			String sql = "update usuariojdbc set nome = ? where id = " + usuario.getId();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.execute();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void deletarUsuario(Long id) {
		try {
			String sql = "delete from usuariojdbc where id = " + id;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}	
	}
	
	public void deletarCascata(Long id) {
		try {
			//String sqltelefone = "delete from telefonealuno where usuario = "+id;
			String sqlusuario = "delete from usuariojdbc where id = " + id;
			
			/*PreparedStatement statement = connection.prepareStatement(sqltelefone);
			statement.execute();
			connection.commit();*/
			
			PreparedStatement statement = connection.prepareStatement(sqlusuario);
			statement.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

}
