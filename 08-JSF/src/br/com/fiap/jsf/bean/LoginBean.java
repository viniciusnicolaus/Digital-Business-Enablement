package br.com.fiap.jsf.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {
	
	private String login;
	private String senha;
	
	public void logar() {
		if ("FIAP".equals(getLogin()) && "FIAP2018".equals(getSenha())) {
		System.out.println("Usuario logado: " + getLogin());
		} else {
		System.out.println("Usuario com senha incorreta");
		}
		}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
