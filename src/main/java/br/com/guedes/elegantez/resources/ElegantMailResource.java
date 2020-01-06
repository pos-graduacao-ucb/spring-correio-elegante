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

//    @RequestMapping(method=RequestMethod.GET)
//    public ResponseEntity<Page<ElegantMail>> findPage(
//            @RequestParam(value="page", defaultValue="0") Integer page,
//            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
//            @RequestParam(value="orderBy", defaultValue="instante") String orderBy,
//            @RequestParam(value="direction", defaultValue="DESC") String direction) {
//        Page<ElegantMail> list = service.findPage(page, linesPerPage, orderBy, direction);
//        return ResponseEntity.ok().body(list);
//    }

}
