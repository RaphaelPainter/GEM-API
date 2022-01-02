package main.api.Security;

import main.api.Bean.AdherentBean;
import main.api.REP.AdherentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class SecurityUtils {

    private AdherentRepository adherentRepository;

    @Autowired
    public SecurityUtils(AdherentRepository adherentRepository) {
        this.adherentRepository = adherentRepository;
    }

    public Boolean validAuthentification(
            final String login,
            final String password) {
        List<AdherentBean> adherents =  adherentRepository.findByLoginAndPassword(login,password);
        return adherents.size() == 1;
    }

    public Boolean validRole(
            final String login,
            final String password,
            final Integer role){
        List<AdherentBean> adherents =  adherentRepository.findByLoginAndPassword(login,password);
        AdherentBean adherent = adherents.get(0);
        if(adherent.getRole() < role){
            return false;
        }
        return true;
    }

}
