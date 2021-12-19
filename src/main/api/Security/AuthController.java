package main.api.Security;


import main.resources.RolesLabels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
final class AuthController {

    private SecurityUtils securityUtils;

    @Autowired
    public AuthController(SecurityUtils securityUtils) {
        this.securityUtils = securityUtils;
    }

    @PostMapping("/checkAuthentification")
    Boolean checkAuthentification(
            @RequestParam("login") final String login,
            @RequestParam("password") final String password) {
        return securityUtils.validAuthentification(login,password, RolesLabels.user);
    }
}