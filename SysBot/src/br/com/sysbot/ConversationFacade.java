package br.com.sysbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

import br.com.sysbot.valida.ValidaDados;

//import br.com.agillitas.twilio.SendSMS;

@RestController
public class ConversationFacade {
	@Autowired
	private Conversation conversation;
	
	@Autowired
	private ValidaDados validaDados;
	
	 @CrossOrigin(origins = "*")
	 @GetMapping("/conversa/{frase}")
	 public String conversar(@PathVariable String frase) {
		 String resp = conversation.conversar(frase);
//		 String validar = (String) resp.getContext().get("validar");
//		 if (validar != null && validar.equals("email")) {
//			 boolean valido = validaDados.validEmail(resp.getContext().get("email").toString());
//			 if(valido){
//				 resp.getContext().put("valido", true);
//				 
//			 }else{
//				 resp.getContext().put("valido", false);
//			 }
//		 }
		 return resp;
	 }
	 
	 @CrossOrigin(origins = "*")
	 @GetMapping("/avaliacao/{avaliacao}")
	 public void avaliar(@PathVariable String avaliacao) {
		conversation.setAvaliacao(avaliacao); 
	 }
	 
	 @CrossOrigin(origins = "*") 
	 @GetMapping("/fecharConversa/{fecharChat}")
   	 public void fecharConversa(@PathVariable String fecharChat) {
		conversation.fecharConversa(fecharChat);
		}
	 
}



////////////////// backup
//package br.com.agillitas;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
//
////import br.com.agillitas.twilio.SendSMS;
//
//@RestController
//public class ConversationFacade {
//	@Autowired
//	private Conversation conversation;
//	
//	 @CrossOrigin(origins = "*")
//	 @GetMapping("/conversa/{frase}")
//	 public String conversar(@PathVariable String frase){
//	 return conversation.conversar(frase);
//	 }
//
//}

