package br.com.sysbot;

import br.com.sysbot.valida.ValidaDados;

//import br.com.agillitas.twilio.SendSMS;

public class NotMain {
	
	public static void main(String[] args){
		
		ValidaDados vd = new ValidaDados();
		
		String email = "dougals@google.com";
		String telefone = "1111-11111";
		
		vd.validEmail(email);
		vd.validTelefone(telefone);
		System.out.println();
		
	}
	
	
	
}
