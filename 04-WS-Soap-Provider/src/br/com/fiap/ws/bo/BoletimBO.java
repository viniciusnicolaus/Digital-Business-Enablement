package br.com.fiap.ws.bo;

import br.com.fiap.ws.to.BoletimTO;

public class BoletimBO {

	public BoletimTO buscar(int codigo) {
		BoletimTO to = null;
		switch (codigo) {
		case 1:
			to = new BoletimTO("Android", 0, 10, true);
			break;
		case 2: 
			to = new BoletimTO("IOT", 2, 5, false);
			break;
		}
		return to;
	}
}
