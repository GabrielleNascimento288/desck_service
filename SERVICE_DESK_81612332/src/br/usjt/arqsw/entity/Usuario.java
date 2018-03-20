package br.usjt.arqsw.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 
 * @author Gabrielle Nascimento da Anunciação ra: 81612332
 */
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String LOGADO = "logado";
	
	@NotNull 
	@Size(max=100,min=2, message="Informe o username")
	private String username;
	
	@NotNull 
	@Size(max=100,min=2, message="Informe o password")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password
				+ "]";
	}


}
