package main.java.localizadorcep;

import br.com.correios.Endereco;

public class AdapterEndereco implements TargetCEP {
	
	Endereco endereco;
	
	public String buscarPorCEP(Long cep){
		String enderecoCompleto = null;
		
		String cepS = converteCEP(cep);
		
		if(cepS != null){
			endereco =  new Endereco(cepS);
			enderecoCompleto = concatenaEndereco();		
		}
		
		return enderecoCompleto;		
	}

	private String concatenaEndereco() {
		String enderecoCompleto;
		enderecoCompleto = 	endereco.getTipoLogradouro(); 
				
		if (!endereco.getPrefixoLogradouro().equals("") || endereco.getPrefixoLogradouro() == null){
			enderecoCompleto += " " + endereco.getPrefixoLogradouro();
		}
		enderecoCompleto +=	" " + endereco.getLogradouro() + 
							", " + endereco.getCidade() +
							", " + endereco.getEstado();
		return enderecoCompleto;
	}

	private String converteCEP(Long cep) {
		String cepS = String.valueOf(cep);
		
		if(cepS.length() == 8){
		
			StringBuilder cepBuilder = new StringBuilder(cepS);
			cepBuilder.insert(5, "-");
			return cepBuilder.toString();
		}
		
		return null;
	}
}
