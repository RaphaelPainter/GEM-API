package main.api.REP;

import main.api.Bean.AdherentBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdherentRepository extends JpaRepository<AdherentBean, Long> {

    @Query("SELECT a FROM AdherentBean a WHERE a.login = ?1 AND a.password = ?2")
    List<AdherentBean> findByLoginAndPassword(String login, String password);
}
