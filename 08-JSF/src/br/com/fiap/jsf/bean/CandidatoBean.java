package br.com.fiap.jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.service.CandidatoService;
import br.com.fiap.to.CandidatoTO;

@ManagedBean
public class CandidatoBean {
	
	private CandidatoTO candidato;
	private CandidatoService service;
	
	//Criar um método de inicialização
	@PostConstruct
	private void init()	{
		candidato = new CandidatoTO();
		service = new CandidatoService();
	}

	public CandidatoTO getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoTO candidato) {
		this.candidato = candidato;
	}
	
	//Método para enviar a lista de candidatos para a tabela HTML
	public List<CandidatoTO> getCandidatos(){
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	//Método para o clique do botão excluir da listagem
	public void excluir(int codigo) {
		FacesMessage msg;
		try {
			service.deletar(codigo);
			msg = new FacesMessage("Removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao remover");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	//método cadastar para o botão salvar
	public String salvar() {
		FacesMessage msg;
		try {
			if(candidato.getCodigo() == 0) {
				service.cadastrar(candidato);
				msg = new FacesMessage("Cadastrado com sucesso");
			}else {
				service.atualizar(candidato);
				msg = new FacesMessage("Atualizao com sucesso!");
			}
			return "lista-candidato"; // nome da página de retorno
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Não foi possível cadastrar");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		}
		//Adicionar a mensagem para a pagina
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "candidato"; // nome da página de retorno
	}
	
}
