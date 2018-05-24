package br.com.fiap.jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.entity.Filme;
import br.com.fiap.ws.service.FilmeService;

@ManagedBean
public class FilmeBean {

	private FilmeService service;
	
	private Filme filme;
	
	//Método de inicialização
	@PostConstruct
	private void init() {
		service = new FilmeService();
		setFilme(new Filme());
				
	}

	//Método para o clique do botão
	public String cadastrar() {
		FacesMessage msg;
		try {
			service.cadastrar(filme);
			msg = new FacesMessage("Sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		//Adicionar a mensagem para a página
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter a mensagem após um redirect
		FacesContext.getCurrentInstance().getExternalContext()
		.getFlash().setKeepMessages(true);
		//Redireciona para a página filme
		return "filme?faces-redirect=true";
	}
	
	//Método para enviar a lista de filmes paa a página
	public List<Filme> listar(){
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
}
