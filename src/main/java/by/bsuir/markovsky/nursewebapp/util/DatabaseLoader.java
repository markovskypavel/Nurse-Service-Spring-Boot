package by.bsuir.markovsky.nursewebapp.util;

import by.bsuir.markovsky.nursewebapp.model.Identity;
import by.bsuir.markovsky.nursewebapp.model.WebIdentity;
import by.bsuir.markovsky.nursewebapp.model.enumeration.RoleType;
import by.bsuir.markovsky.nursewebapp.repository.WebIdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    @Qualifier("webIdentityRepository")
    private WebIdentityRepository webIdentityRepository;

    @Override
    public void run(String... args) throws Exception {
/*        Identity identity = new Identity("Pavel", "Markovsky", 21);
        WebIdentity webIdentity = new WebIdentity("markovskypavel", EncryptedPasswordUtil.encrytePassword("Qwerty123"), "markovskypavel@gmail.com", "293041779",
                RoleType.ROLE_ADMIN, null, "Tikhaya 1", identity);
        webIdentityRepository.save(webIdentity);*/
    }

}
