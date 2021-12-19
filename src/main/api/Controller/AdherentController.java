package main.api.Controller;

import main.api.ApiApplication;
import main.api.Bean.AdherentBean;
import main.api.REP.AdherentRepository;
import main.api.Security.SecurityUtils;
import main.resources.JsonLabel;
import main.resources.RolesLabels;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
public class AdherentController {

    private final AdherentRepository adherentRepository;
    private SecurityUtils securityUtils;


    AdherentController(AdherentRepository adherentRepository,SecurityUtils securityUtils) {
        this.adherentRepository = adherentRepository;
        this.securityUtils = securityUtils;
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @PostMapping("/adherents")
    ResponseEntity<List<AdherentBean>> getUsers(
            @RequestBody Map<String, Object> payload) {
        String login = payload.get(JsonLabel.login).toString();
        String password = payload.get(JsonLabel.password).toString();
        ApiApplication.logger.warn(login);
        if(!securityUtils.validAuthentification(login, password, RolesLabels.administrator)){
            return ResponseEntity.status(666).build();
        }else{
            return ResponseEntity.ok(adherentRepository.findAll());
        }
    }
}
