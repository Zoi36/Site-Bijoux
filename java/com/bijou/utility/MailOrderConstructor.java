package com.bijou.utility;

import java.util.Locale;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.bijou.domain.OrderProduct;
import com.bijou.domain.User;

@Component
public class MailOrderConstructor {

	@Autowired
	private Environment env;

	@Autowired
	private TemplateEngine templateEngine;

	public SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, User user,
			String password) {

		String message = "\nVous avez créé un compte sur notre site Bijou En Ligne.Veuillez cliquer sur le lien pour mettre a jour votre informations personnelles: "
				+ "Votre mot de passe est: \n" + password+"\nMerci de votre fidélité et à très bientôt sur Bijou En Ligne.\r\n" + "\r\n"
						+ "Cordialement,\r\n" + "L'équipe Bijou En Ligne\r\n" + " \n";

		String url = contextPath + "/newUser?token=" + token;
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("Bijou En Ligne - Nouveau compte");
		email.setText(url + message);
		email.setFrom(env.getProperty("support.email"));
		return email;

	}

	public SimpleMailMessage constructForgetPasswordEmail(String contextPath, Locale locale, String token, User user,
			String password) {

		String message1 = "\nVOTRE MODIFICATION DE MOT DE PASSE \n"
				+ "\nVotre demande de modification de mot de passe a bien été enregistrée. \n"
				+ "\nVotre nom d'utilisateur: \n" + user.getUsername() + "\nVotre nouveau mot de passe: \n" + password
				+ "\nVous pouvez le modifie sur 'MODIFIER MON COMPTE'. \n"
				+ "\nVeuillez cliquer sur le lien pour se connecter: \n";
		String message2 = "\nMerci de votre fidélité et à très bientôt sur Bijou En Ligne.\r\n" + "\r\n"
				+ "Cordialement,\r\n" + "L'équipe Bijou En Ligne\r\n" + " \n";

		String url = contextPath + "/login";
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("Bijou En Ligne - Mot de passe oublié");
		email.setText(message1 + url + message2);
		email.setFrom(env.getProperty("support.email"));
		return email;

	}

	public MimeMessagePreparator constructOrderConfirmationMail(User user, OrderProduct orderProduct, Locale locale) {
		Context context = new Context();
		context.setVariable("orderProduct", orderProduct);
		context.setVariable("user", user);
		context.setVariable("lineProductList", orderProduct.getLineProductList());
		String text = templateEngine.process("orderConfirmationMail", context);

		MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
				email.setTo(user.getEmail());
				email.setSubject("Order Confirmation - " + orderProduct.getId());
				email.setText(text, true);
				email.setFrom(new InternetAddress("sotiriadou.zoi@gmail.com"));
			}
		};

		return messagePreparator;
	}
}
