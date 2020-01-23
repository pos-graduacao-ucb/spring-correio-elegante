package br.com.guedes.elegantez.services;

import br.com.guedes.elegantez.domain.User;
import br.com.guedes.elegantez.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Autowired
    private UserRepository repository;

    @Autowired
    private EmailService emailService;

    private Random random = new Random();

    public void sendNewPassword(String email) {
        User user = repository.findByEmail(email);
        if (user == null) {
            throw new NullPointerException("Email não encontrado");
        }

        String newPassword = newPassword();
        user.setPassword(bcrypt.encode(newPassword));
        repository.save(user);

        emailService.sendNewPasswordEmail(user, newPassword);
    }

    private String newPassword() {
        char[] vetor = new char[10];
        for (int i = 0; i<10; i++) {
            vetor[i] = randomChar();
        }
        return new String(vetor);
    }

    private char randomChar() {
        int option = random.nextInt(3);
        if(option == 0) {
            return (char) (random.nextInt(10) + 48);
        } else if(option == 1) {
            return (char) (random.nextInt(26) + 65);
        } else {
            return (char) (random.nextInt(26) + 95);
        }
    }
}
