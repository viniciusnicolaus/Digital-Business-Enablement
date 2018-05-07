package br.com.fiap.jsf.bean;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.service.NoticiaService;
import br.com.fiap.ws.to.NoticiaTO;

@ManagedBean
public class NoticiaBean {
	
	private NoticiaTO noticia;
	private NoticiaService service;
	
	@PostConstruct
	private void init() {
		noticia = new NoticiaTO();
		noticia.setData(Calendar.getInstance()); // inicializa a data
		service = new NoticiaService();
	}

	public NoticiaTO getNoticia() {
		return noticia;
	}

	public void setNoticia(NoticiaTO noticia) {
		this.noticia = noticia;
	}

	//Listar
	public List<NoticiaTO> getNoticias() {
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Cadastar e atualizar
	public String salvar() {
		FacesMessage msg;
		
		try {
			if(noticia.getCodigo() == 0) {
				service.cadastrar(noticia);
				msg = new FacesMessage("Noticia gravada com sucesso");
			}else {
				service.atualizar(noticia);
				msg = new FacesMessage("Notícia atualizada com sucesso");
			}
			 // nome da pagina de retorno
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Não foi possível gravar");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Mantem as mensagens na pagina após um redirect
		FacesContext.getCurrentInstance().getExternalContext()
		.getFlash().setKeepMessages(true);
		return "lista-noticias?faces-redirect=true";// nome da página de retorno
	}
	
	public String excluir(int codigo) {
		FacesMessage msg;
		try {
			service.deletar(codigo);
			msg = new FacesMessage("Deletado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Não foi possível deletar");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter as mensagens após um redirect
		FacesContext.getCurrentInstance().getExternalContext()
		.getFlash().setKeepMessages(true);
		return "lista-noticias?faces-redirect=true";
	}
	
}
