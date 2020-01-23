package br.com.guedes.elegantez.services;

import br.com.guedes.elegantez.domain.User;
import br.com.guedes.elegantez.services.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public class AbstractEmailService implements EmailServiceImpl {

    @Value("$default.sender")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void confirmationEmailHtml(User user) throws MessagingException {}

    @Override
    public void sendEmailHtml(SimpleMailMessage simpleMailMessage) {}

    @Override
    public void sendNewPasswordEmail(User user, String newPassword) {
        SimpleMailMessage sm = prepareNewPasswordEmail(user, newPassword);
        sendEmailHtml(sm);
    }

    protected SimpleMailMessage prepareNewPasswordEmail(User user, String newPassword) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setReplyTo(user.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova senha " + newPassword);
        return sm;
    }
}