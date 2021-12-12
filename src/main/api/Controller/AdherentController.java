package main.api.Controller;

import main.api.Bean.AdherentBean;
import main.api.REP.AdherentRepository;
import main.api.Security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdherentController {

    private final AdherentRepository adherentRepository;
    private SecurityUtils securityUtils;


    AdherentController(AdherentRepository adherentRepository,SecurityUtils securityUtils) {
        this.adherentRepository = adherentRepository;
        this.securityUtils = securityUtils;
    }

    @PostMapping("/adherents")
    ResponseEntity<List<AdherentBean>> getUsers(
            @RequestParam("login") final String login,
            @RequestParam("password") final String password) {
        if(!securityUtils.validAuthentification(login, password)){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(adherentRepository.findAll());
        }
    }
}
