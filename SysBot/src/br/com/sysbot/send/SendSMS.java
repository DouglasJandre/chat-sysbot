package br.com.sysbot.send;
//package br.com.agillitas.twilio;
//
////package br.com.ykp.bancorendimentos.twilio;
//
////https://www.twilio.com/blog/2016/04/sending-sms-with-java.html
////
////import com.twilio.sdk.TwilioRestClient;
////import com.twilio.sdk.TwilioRestException;
////import com.twilio.sdk.resource.factory.SmsFactory;
////import com.twilio.sdk.resource.instance.Account;
////
////import java.util.HashMap;
////
////public class SendSMS {
////public static void main(String[] args) throws TwilioRestException {
////    TwilioRestClient client = new TwilioRestClient("AC45279b494328fd6696b6938c34e58a7f", "bce209ce45779bcb0807ffd11675c83c");
////
////    Account account = client.getAccount();
////
////    SmsFactory factory = account.getSmsFactory();
////
////    HashMap<String, String> message = new HashMap<>();
////
////    message.put("To", "11958781260");
////    message.put("From", "+13368037147");
////    message.put("Body", "Hi Twilio!");
////
////    factory.create(message);
////}
////}
//
////Site Twilio
////https://www.twilio.com/console/sms/getting-started/basics
////
////import java.util.*;
////
////import javax.xml.soap.MessageFactory;
////
////import org.apache.http.NameValuePair;
////import org.apache.http.message.BasicNameValuePair;
////
////import com.twilio.sdk.*;
////import com.twilio.sdk.resource.factory.*;
////import com.twilio.sdk.resource.instance.*;
////import com.twilio.sdk.resource.list.*;
////import com.twilio.twiml.Message;
////
////public class SendSMS {
////// Find your Account Sid and Token at twilio.com/user/account
////public static final String ACCOUNT_SID = "AC45279b494328fd6696b6938c34e58a7f";
////public static final String AUTH_TOKEN = "bce209ce45779bcb0807ffd11675c83c";
////
////public static void main(String[] args) throws TwilioRestException {
////    TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
////
////    // Build the parameters
////    List<NameValuePair> params = new ArrayList<NameValuePair>();
////    params.add(new BasicNameValuePair("To", "11958781260"));
////    params.add(new BasicNameValuePair("From", "+13368037147"));
////    params.add(new BasicNameValuePair("Body", "Teste Enviando SMS via Twilio, com Java."));
////
////    SmsFactory messageFactory = client.getAccount().getSmsFactory();
//////    Message message = messageFactory.create(params);
////    System.out.println(params);
////}
////}
//
////https://www.twilio.com/docs/quickstart/java/sms/hello-monkey
//
////import javax.servlet.http.HttpServlet;
////import javax.servlet.http.HttpServletRequest;
////import javax.servlet.http.HttpServletResponse;
////import java.io.IOException;
////
////import com.twilio.twiml.Body;
////import com.twilio.twiml.Message;
////import com.twilio.twiml.MessagingResponse;
////import com.twilio.twiml.TwiMLException;
////
////public class SendSMS extends HttpServlet {
////
////// service() responds to both GET and POST requests.
////// You can also use doGet() or doPost()
////public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
////    Message message = new Message.Builder()
////            .body(new Body("Hello, Mobile Monkey"))
////            .build();
////
////    MessagingResponse twiml = new MessagingResponse.Builder()
////            .message(message)
////            .build();
////
////    response.setContentType("application/xml");
////
////    try {
////        response.getWriter().print(twiml.toXml());
////    } catch (TwiMLException e) {
////        e.printStackTrace();
////    }
////}
////}
//
////
////https://docs.microsoft.com/pt-br/azure/partner-twilio-java-how-to-use-voice-sms
////Fail
//
/////
////https://www.twilio.com/blog/2016/04/sending-sms-with-java.html
////
////import com.twilio.sdk.TwilioRestClient;
////import com.twilio.sdk.TwilioRestException;
////import com.twilio.sdk.resource.factory.SmsFactory;
////import com.twilio.sdk.resource.instance.Account;
////
////import java.util.HashMap;
////
////public class SendSMS {
////	
////public static void main(String[] args){
////   
////	TwilioRestClient client = new TwilioRestClient("AC45279b494328fd6696b6938c34e58a7f", "bce209ce45779bcb0807ffd11675c83c");
////
////    Account account = client.getAccount();
////
////    SmsFactory factory = account.getSmsFactory();
////
////    HashMap<String, String> message = new HashMap<>();
////
////    message.put("To", "+5511958781260");
////    message.put("From", "+13368037147");
////    message.put("Body", "Enviando Sms java com Twilio...");
////
////    try {
////			factory.create(message);
////		} catch (TwilioRestException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////}
////}
//
//
////import br.com.facilitamovel.bean.Retorno;
//
//import br.com.facilitamovel.bean.SmsSimples;
//import br.com.facilitamovel.service.SendMessage;
//
//public class SendSMS {
//
//	/**
//	 * Exemplo de um envio Simples de SMS para a Plataforma
//	 * @throws Exception
//	 */
////	public static void simple(String usuario, String senha) throws Exception {
////	public static void main(String[] args)throws Exception{
////	public static void SendSMS()throws Exception{
//	public SendSMS(String string)throws Exception{ // puclic static void... ele responde 2 vezes.
//	// Simple Send
//		SmsSimples sms = new SmsSimples();
//		sms.setUser("teste.ykp");
//		sms.setPassword("Ykp@010203");
//		sms.setDestinatario("11958781260");
//		sms.setMessage("Teste 003, huehuehueheu.... enviar SMS com JAVA.. " );
//		//sms.setAno(2015);
//		Retorno retorno = SendMessage.simpleSend(sms);
//		System.out.println("Codigo:" + retorno.getCodigo());
//		System.out.println("Descricao:" + retorno.getMensagem());
//	}
//
//	public static String SendSMS(String string) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}