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
public class HealthController {


    HealthController() {

    }

    @CrossOrigin(origins = ConstantProperties.webappUrl)
    @GetMapping("/health")
    String getUsers() {
        return "UP";
    }
}
