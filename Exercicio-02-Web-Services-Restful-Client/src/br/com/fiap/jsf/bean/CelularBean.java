package br.com.fiap.jsf.bean;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.entity.CelularTO;
import br.com.fiap.ws.service.CelularService;

@ManagedBean
public class CelularBean {

	private CelularTO celular;
	private CelularService service;

	@PostConstruct
	private void init() {
		celular = new CelularTO();
		service = new CelularService();

	}

	public List<CelularTO> getCelulares(){
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String salvar() {
		FacesMessage msg;

		try {
			if(celular.getCodigo() == 0) {
				service.cadastrar(celular);
				msg = new FacesMessage("Celular gravado com sucesso");
			}else {
				service.atualizar(celular);
				msg = new FacesMessage("Celular atualizado com sucesso");

			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao gravar celular");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);

		FacesContext.getCurrentInstance().getExternalContext()
		.getFlash().setKeepMessages(true);

		return "lista-celular?faces-redirect=true";
	}

	public String excluir(int codigo) {
		FacesMessage msg;
		
		try {
			service.deletar(codigo);
			msg = new FacesMessage("Item excluído com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao deletar item");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);

		FacesContext.getCurrentInstance().getExternalContext()
		.getFlash().setKeepMessages(true);
		
		return "lista-celular?faces-redirect=true";
	}

	public CelularTO getCelular() {
		return celular;
	}
	public void setCelular(CelularTO celular) {
		this.celular = celular;
	}
	public CelularService getService() {
		return service;
	}
	public void setService(CelularService service) {
		this.service = service;
	}


}
