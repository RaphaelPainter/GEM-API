package main.api.Controller;

import main.api.ApiApplication;
import main.api.Bean.AdherentBean;
import main.api.REP.AdherentRepository;
import main.api.Security.SecurityUtils;
import main.resources.ConstantProperties;
import main.resources.referentials.ErrorHeaders;
import main.resources.referentials.JsonLabel;
import main.resources.referentials.RolesLabels;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = ConstantProperties.webappUrl)
    @RequestMapping(
            value = "/adherents",
            produces = { "application/json", "application/xml" },
            method = RequestMethod.POST)
    ResponseEntity<List<AdherentBean>> getUsers(
            @RequestBody Map<String, Object> payload) {
        //PARAMS
        String login = payload.get(JsonLabel.login).toString();
        String password = payload.get(JsonLabel.password).toString();
        ApiApplication.logger.warn(login);

        //SECU
        if(!securityUtils.validAuthentification(login, password)){
            return ResponseEntity.status(666).headers(ErrorHeaders.Auth).build();
        }else if(!securityUtils.validRole(login, password, RolesLabels.administrator)){
            return ResponseEntity.status(666).headers(ErrorHeaders.Role).build();
        }else{
            //JOB
            return ResponseEntity.ok(adherentRepository.findAll());
        }
    }
}
