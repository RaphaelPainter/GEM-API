package main.api.Security;


import main.api.ApiApplication;
import main.resources.ConstantProperties;
import main.resources.referentials.JsonLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
final class AuthController {

    private SecurityUtils securityUtils;

    @Autowired
    private Environment env;

    @Autowired
    public AuthController(SecurityUtils securityUtils) {
        this.securityUtils = securityUtils;
    }

    @CrossOrigin(origins = ConstantProperties.webappUrl)
    @PostMapping("/checkAuthentification")
    Boolean checkAuthentification(
            @RequestBody Map<String, Object> payload) {
        //PARAMS
        String login = payload.get(JsonLabel.login).toString();
        String password = payload.get(JsonLabel.password).toString();
        ApiApplication.logger.warn(login + "checks Auth");

        //JOB
        return securityUtils.validAuthentification(login,password);
    }
}