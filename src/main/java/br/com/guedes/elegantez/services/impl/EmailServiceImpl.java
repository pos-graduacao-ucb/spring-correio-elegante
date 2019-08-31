package br.com.guedes.elegantez.services.impl;

import br.com.guedes.elegantez.domain.User;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public interface EmailServiceImpl {

    void emailDeConfirmacaoHtml(User user) throws MessagingException;
    void sendHtmlEmail(MimeMessage mimeMessage);
}
