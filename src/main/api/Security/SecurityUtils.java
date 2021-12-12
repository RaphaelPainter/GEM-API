package main.api.Security;

import main.api.REP.AdherentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SecurityUtils {

    private AdherentRepository adherentRepository;

    @Autowired
    public SecurityUtils(AdherentRepository adherentRepository) {
        this.adherentRepository = adherentRepository;
    }

    public Boolean validAuthentification(
            @RequestParam("login") final String login,
            @RequestParam("password") final String password) {
        return adherentRepository.findByLoginAndPassword(login,password).size() == 1;
    }

}
