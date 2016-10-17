package main.java.localizadorcep;

import javax.swing.JOptionPane;

public class Main {

    TargetCEP localizador;
    public Main(TargetCEP localizador) {
       this.localizador=localizador;
    }

    public static void main(String[] args) {
        Main main=new Main(new AdapterEndereco());
        main.repetirBuscasPorCEP();
    }

    void repetirBuscasPorCEP() {
        String cepString;
        do {
            cepString=JOptionPane.showInputDialog("Entre um cep (-1 para finalizar)");
            Long cep=null;
            //Modifiquei essa parte porque ao digitar -1 o programa procurava o cep invalido pra depois sair
            if(!cepString.equals("-1")){
	            try {
	                cep=Long.valueOf(cepString);
	            } catch(NumberFormatException nfe) {
	                System.out.println("Valor inválido!");
	            }
	            String endereco=localizador.buscarPorCEP(cep);
	            System.out.println(endereco);
            }            
        } while(!cepString.equals("-1"));
    }

}
