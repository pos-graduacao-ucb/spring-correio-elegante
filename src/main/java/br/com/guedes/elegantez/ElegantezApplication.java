package br.com.guedes.elegantez;

import br.com.guedes.elegantez.domain.ElegantMail;
import br.com.guedes.elegantez.domain.User;
import br.com.guedes.elegantez.domain.enums.Profile;
import br.com.guedes.elegantez.repositories.ElegantMailRepository;
import br.com.guedes.elegantez.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@RestController
public class ElegantezApplication implements CommandLineRunner {

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ElegantMailRepository elegantMailRepository;

	@Autowired
	private BCryptPasswordEncoder bc;

	public static void main(String[] args) {
		SpringApplication.run(ElegantezApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User gabriela = new User(null, "Gabriela", "azooiverde", "zooiv3rde@gmail.com", bc.encode("123"), "23", "feminino");
		gabriela.addProfile(Profile.ADMIN);

		ElegantMail myCorreioElegante = new ElegantMail(null, "É muito programar, na verdade é muito bom fazer o que gostamos!!");

		elegantMailRepository.deleteAll();;
		userRepository.deleteAll();
		elegantMailRepository.saveAll(Arrays.asList(myCorreioElegante));
		userRepository.saveAll(Arrays.asList(gabriela));
	}

}
