package br.com.guedes.elegantez.services;

import br.com.guedes.elegantez.domain.User;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;

public interface EmailService {

    void confirmationEmailHtml(User user) throws MessagingException;
    void sendEmailHtml(SimpleMailMessage simpleMailMessage);

    void sendNewPasswordEmail(User user, String newPassword);
}
