package by.bsuir.markovsky.nursewebapp.service;

import by.bsuir.markovsky.nursewebapp.exception.ServiceException;
import by.bsuir.markovsky.nursewebapp.model.WebIdentity;
import by.bsuir.markovsky.nursewebapp.model.enumeration.RoleType;
import by.bsuir.markovsky.nursewebapp.repository.WebIdentityRepository;
import by.bsuir.markovsky.nursewebapp.util.EncryptedPasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("webIdentityService")
@Transactional(rollbackFor = ServiceException.class)
public class WebIdentityService {

    @Autowired
    @Qualifier("webIdentityRepository")
    private WebIdentityRepository webIdentityRepository;

    @Value("${user.admin.username}")
    private String adminUsername;

    public void addOrUpdateWebIdentity(WebIdentity webIdentity) {
        webIdentity.setPassword(EncryptedPasswordUtil.encrytePassword(webIdentity.getUnencryptedPassword()));
        webIdentity.setRoleType(RoleType.ROLE_USER);
        webIdentityRepository.save(webIdentity);
    }
    public boolean checkUserExists(String username) {
        WebIdentity user = webIdentityRepository.findByUsername(username);
        return username.equals(adminUsername) || (user != null);
    }
    public void deleteUser(int id) {
        Optional<WebIdentity> user = webIdentityRepository.findById(id);
        user.ifPresent(userToDelete -> webIdentityRepository.delete(userToDelete));
    }
    public WebIdentity getUserById(int id) {
        Optional<WebIdentity> user = webIdentityRepository.findById(id);
        return user.orElse(null);
    }
    public WebIdentity getUserByUsername(String username) {
        WebIdentity user = webIdentityRepository.findByUsername(username);
        return user;
    }
    public List<WebIdentity> getAllUsers() {
        return webIdentityRepository.findAll();
    }

}
