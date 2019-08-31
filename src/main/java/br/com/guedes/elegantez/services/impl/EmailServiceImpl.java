package br.com.guedes.elegantez.services.impl;

import br.com.guedes.elegantez.domain.User;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public interface EmailServiceImpl {

    void confirmationEmailHtml(User user) throws MessagingException;
    void sendEmailHtml(MimeMessage mimeMessage);
}
