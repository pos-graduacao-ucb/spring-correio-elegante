package br.com.guedes.elegantez.services.impl;

import br.com.guedes.elegantez.domain.User;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public interface EmailServiceImpl {

    void confirmationEmailHtml(User user) throws MessagingException;
    void sendEmailHtml(SimpleMailMessage simpleMailMessage);

    void sendNewPasswordEmail(User user, String newPassword);
}
