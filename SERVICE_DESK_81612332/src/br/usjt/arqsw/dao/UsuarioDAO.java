package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Usuario;


/**
 * 
 * @author Gabrielle Nascimento da Anunciação ra: 81612332
 */
@Repository
public class UsuarioDAO {
	private Connection conn;
		
		@Autowired
		public UsuarioDAO(DataSource dataSource) throws IOException{
			try {
				this.conn = dataSource.getConnection();
			} catch (SQLException e) {
				throw new IOException(e);
			}
		}
	
	/**
	 * 
	 * @param usuario Procura username e password no banco
	 * @return Valida username e password
	 * @throws IOException
	 */
	public boolean validar(Usuario usuario) throws IOException{
		String sqlSelect = "SELECT username, password FROM usuario "
				+ "WHERE username = ? and password = ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, usuario.getUsername());
			stm.setString(2, usuario.getPassword());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				throw new IOException(e);
			}
		} catch (SQLException e1) {
			throw new IOException(e1);
			}
		}
}