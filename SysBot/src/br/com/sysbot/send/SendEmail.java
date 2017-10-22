package br.com.sysbot.send;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;;

public class SendEmail {
	
	String usuario = "teste.ykp@gmail.com";
	String senha = "Ykp@010203";
	String emailSysprice = "douglasjandre@gmail.com";
	String emailCliente = "douglasjandre@gmail.com";

	@SuppressWarnings("deprecation")
//	public void sendEmail(Email emailConfig, String corpoEmail) {
//	public void sendEmailCliente(String emailCliente) {
	public void sendEmailCliente() {
		SimpleEmail email = new SimpleEmail();
		
//		String usuario = "teste.ykp@gmail.com";
//		String senha = "Ykp@010203";

		try {
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(Integer.parseInt("465"));
			email.setAuthenticator(new DefaultAuthenticator(usuario, senha));
			email.setSSL(true);
			email.addTo(emailCliente);
			email.setFrom("teste.ykp@gmail.com");
			email.setSubject("TESTES 003(Cliente)");
			email.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);
			email.setMsg("(Cliente) o que achou da nossa conversa? ");

			email.send();
		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}

	public void sendEmailSysprice(String corpoEmail) {
		SimpleEmail email = new SimpleEmail();
	
//		String usuario = "teste.ykp@gmail.com";
//		String senha = "Ykp@010203";

		try {
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(Integer.parseInt("465"));
			email.setAuthenticator(new DefaultAuthenticator(usuario, senha));
			email.setSSL(true);
			email.addTo(emailSysprice);
			email.setFrom("teste.ykp@gmail.com");
			email.setSubject("TESTES 003 (Sysprice)");
			email.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);
			email.setMsg(corpoEmail);
	
			email.send();
		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
}
//	public String removerTags(String str) {
//		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\<.*?>", "");
//	}
}
