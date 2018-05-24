package br.com.fiap.jsf.validator;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

import br.com.fiap.jsf.util.BundleUtil;

@FacesValidator("pontoFinal")
public class ValidarPontoFinal implements javax.faces.validator.Validator {


	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String valor = value.toString();
		
		if(!valor.endsWith(".")) {
			String mensagem = BundleUtil.getMessageResourceString(
					context.getApplication().getMessageBundle(), 
					"msg_end_with_dot", null,
					context.getViewRoot().getLocale());
			
			throw new ValidatorException(new FacesMessage(mensagem));
		}
		
	}

}
