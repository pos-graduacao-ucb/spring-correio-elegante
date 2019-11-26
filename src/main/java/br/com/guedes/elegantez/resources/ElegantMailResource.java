package br.com.guedes.elegantez.resources;

import br.com.guedes.elegantez.domain.ElegantMail;
import br.com.guedes.elegantez.domain.User;
import br.com.guedes.elegantez.services.ElegantMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/mails")
public class ElegantMailResource {

    @Autowired
    private ElegantMailService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ElegantMail>> findAll() {
        List<ElegantMail> mailList = service.findAll();
        return ResponseEntity.ok().body(mailList);
    }

}
