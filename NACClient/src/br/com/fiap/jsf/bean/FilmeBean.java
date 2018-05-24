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
	
	//M�todo de inicializa��o
	@PostConstruct
	private void init() {
		service = new FilmeService();
		setFilme(new Filme());
				
	}

	//M�todo para o clique do bot�o
	public String cadastrar() {
		FacesMessage msg;
		try {
			service.cadastrar(filme);
			msg = new FacesMessage("Sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		//Adicionar a mensagem para a p�gina
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter a mensagem ap�s um redirect
		FacesContext.getCurrentInstance().getExternalContext()
		.getFlash().setKeepMessages(true);
		//Redireciona para a p�gina filme
		return "filme?faces-redirect=true";
	}
	
	//M�todo para enviar a lista de filmes paa a p�gina
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
