package br.com.sysbot;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.mail.Email;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

import br.com.sysbot.send.*;
import br.com.sysbot.valida.*;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Conversation {
	private ConversationService service;
	private Map<String, Object> context;
	private List<Conversa> listaConversa;
	private Email email;

	public Conversation() {
//		if (email == null) {
//			email = new Email();
//		}
		
		if (listaConversa == null) {
			listaConversa = new ArrayList<Conversa>();
		}
		
		init();
	}

	public void init() {
		service = new ConversationService(ConversationService.VERSION_DATE_2016_09_20,
				"af4f73a7-cf6b-4363-8ee5-96b3a19dc623", "IZp4svTRAK47");
		context = null;
	}

	public String conversar(String frase) {	
		MessageRequest request = new MessageRequest.Builder().context(context).inputText(frase).build();
		MessageResponse resp = service.message("d0457475-8bef-420c-b582-7e3fad7ba87a", request).execute();
//pocAmericanas		MessageResponse resp = service.message("b974801f-e070-4c98-a58a-8e7545837171", request).execute();//WorkspaceAmericanas

		context = resp.getContext();
		//validação de email
	
		String valida = (String) resp.getContext().get("valida");
		
		 if (valida != null && valida.equals("email")) {
			 boolean valido = ValidaDados.validEmail(resp.getContext().get("email").toString());
			 if(valido){
				 resp.getContext().put("valido", true);
				 
			 }else{
				 resp.getContext().put("valido", false);
			 }
		 }
		//
//		String JsonRetorno;// = "false|" + resp.getTextConcatenated("");		
//
		Conversa conversa = new Conversa(frase, resp.getTextConcatenated(""));
		listaConversa.add(conversa);

		String resolucao = null;
		resolucao =  (String) resp.getContext().get("resolucao");
		String JsonRetorno = null;
		
		if (resolucao != null && resolucao.equals("verdadeiro")) {
			JsonRetorno = "true|" + resp.getTextConcatenated("");
		}else{
			JsonRetorno = "false|" + resp.getTextConcatenated("");
		}
//		return retorno;´
		return JsonRetorno;
	}
	
	public void fecharConversa(String fecharChat) {

		StringBuffer corpoEmail = new StringBuffer();

		for (Conversa conversaTemp : listaConversa) {
			if(conversaTemp.getPergunta().equals("Avaliação")){
				corpoEmail.append("\n" + conversaTemp.getPergunta() + " = " + conversaTemp.getResposta() + "\n");
			} else {
				corpoEmail.append("\nPergunta: " + conversaTemp.getPergunta() + "\nResposta: " + conversaTemp.getResposta());					
			}
		}

		SendEmail se = new SendEmail();

//		String tempCorpoEmail = "Cod." + codSF + ")" + "\n\n" + corpoEmail.toString();
		String tempCorpoEmail = corpoEmail.toString();
		
		se.sendEmailSysprice(tempCorpoEmail);
		se.sendEmailCliente();
		listaConversa.clear();
		
	}

	public void setAvaliacao(String avaliacao) {
		this.listaConversa.add(new Conversa("Avaliação", avaliacao));
	}
	//

	
	
	
	
	
	
	
	
	
	
	
	
//	public void setAvaliacao(String avaliacao) {
//		this.listaConversa.add(new Conversa("Avaliação", avaliacao));
//		
//	}
//
//	public void fecharConversa(String fecharChat) {
//		StringBuffer corpoEmail = new StringBuffer();
//		
//		for (Conversa conversaTemp : listaConversa) {
//			if(conversaTemp.getPergunta().equals("Avaliação")){
//				corpoEmail.append("\n" + conversaTemp.getPergunta() + " = " + conversaTemp.getResposta() + "\n");
//			} else {
//				corpoEmail.append("\nPergunta: " + conversaTemp.getPergunta() + "\nResposta: " + conversaTemp.getResposta());					
//			}
//		}
//
//		SendEmail se = new SendEmail();
//
//		String tempCorpoEmail = "Cod." + codSF + ")" + "\n\n" + corpoEmail.toString();
//
//		se.sendEmail(email, tempCorpoEmail);
//		listaConversa.clear();
//		
//	}

}



















//
/////////                 BKP - 
//package br.com.agillitas;
//
//import java.util.Map;
//
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;
//import org.springframework.stereotype.Component;
//
//import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
//import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
//import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
//
////import br.com.agillitas.twilio.SendSMS;
//
//@Component
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
//public class Conversation {
//	private ConversationService service;
//	private Map<String, Object> context;
//
//	public Conversation() {
//		init();
//	}
//
//	public void init() {
//		service = new ConversationService(ConversationService.VERSION_DATE_2016_09_20,
//				"298bf007-cba9-4337-a7b1-d111df54c1a6", "5QWIwMsYZAnL");
//		context = null;
//	}
//
//	// String = MessageResponse
//	public MessageResponse conversar(String frase) {	
//		MessageRequest request = new MessageRequest.Builder().context(context).inputText(frase).build();
//		MessageResponse resp = service.message("92cca8fe-60fd-41a7-9a5a-43803116ff0b", request).execute();
//		context = resp.getContext();
////		String JsonRetorno = resp.getTextConcatenated("");
//		
////		String fala = (String) resp.getContext().get("fala");
////		String sms = (String) resp.getContext().get("sms");
////		String codBarras = (String) resp.getContext().get("ligaCam");
////		
////		String acao = (String) resp.getContext().get("acao");
////		
////		System.out.println(acao);
////		
////		if(acao.equals("fala")){
////			
////			MyTTS sa = new MyTTS();
////			try {
////				JsonRetorno = "true|" + resp.getTextConcatenated("");
////				sa.salvarAudios(JsonRetorno);
////				return JsonRetorno;
////			} catch (Exception e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////			
////		}if(acao.equals("sms")){
////			System.out.println("SMS " + acao);// colocando SendSMS com parametro String ele responde duas vezes
////		//SendSMS ssms = new SendSMS();
////			try {
////				SendSMS.SendSMS();
//////				SendSMS.SendSMS();
////			} catch (Exception e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////
////		}if(acao.equals("ligaCam")){
////			JsonRetorno = acao;
////			return JsonRetorno;
////		}else{
////			JsonRetorno = "false |" + resp.getTextConcatenated("");
////		}
////		System.out.println(JsonRetorno);
////		return "ligaCam";
//		return resp;
//	}
//
//}

/////
//import java.util.Map;
//
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;
//import org.springframework.stereotype.Component;
//
//import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
//import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
//import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
//
//
//@Component
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
//public class Conversation {
//	private ConversationService service;
//	private Map<String, Object> context;
//
//	public Conversation() {
//		init();
//	}
//
//	public void init() {
//		service = new ConversationService(ConversationService.VERSION_DATE_2016_09_20,
//				"76115160-ec0d-41d2-b36f-f3f80b151b88", "dyYdeJnj4lFs");
//		context = null;
//	}
//
//	// String = MessageResponse
//	public String conversar(String frase) {	
//		MessageRequest request = new MessageRequest.Builder().context(context).inputText(frase).build();
//		MessageResponse resp = service.message("549e59f7-00c2-4647-bd66-e23bf4904ae6", request).execute();
//		context = resp.getContext();
//		String JsonRetorno = "false|" + resp.getTextConcatenated("");
//		
////		return resp.getTextConcatenated("");
//		return JsonRetorno;
//	}
//
//}