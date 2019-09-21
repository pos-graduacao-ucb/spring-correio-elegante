package br.com.guedes.elegantez.services;

import br.com.guedes.elegantez.domain.User;
import br.com.guedes.elegantez.services.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class AbstractEmailService implements EmailServiceImpl {

    @Value("$default.sender")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void confirmationEmailHtml(User user) throws MessagingException {
    }

    @Override
    public void sendEmailHtml(MimeMessage mimeMessage) {
    }
}