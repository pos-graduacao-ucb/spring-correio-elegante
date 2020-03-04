package br.com.guedes.elegantez.services;

import br.com.guedes.elegantez.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;
import java.util.Date;

public abstract class AbstractEmailService implements EmailService {

    @Value("$default.sender")
    private String sender;

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