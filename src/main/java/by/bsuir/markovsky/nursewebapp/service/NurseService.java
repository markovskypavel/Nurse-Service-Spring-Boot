package by.bsuir.markovsky.nursewebapp.service;

import by.bsuir.markovsky.nursewebapp.model.Nurse;
import by.bsuir.markovsky.nursewebapp.model.WebIdentity;
import by.bsuir.markovsky.nursewebapp.repository.NurseRepository;
import by.bsuir.markovsky.nursewebapp.util.EncryptedPasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("nurseService")
public class NurseService {

    @Autowired
    @Qualifier("nurseRepository")
    private NurseRepository nurseRepository;

    public void addOrUpdateNurse(Nurse nurse) {
        WebIdentity webIdentity = nurse.getWebIdentity();
        webIdentity.setPassword(EncryptedPasswordUtil.encrytePassword(webIdentity.getUnencryptedPassword()));
        nurseRepository.save(nurse);
    }
    public void deleteNurse(Nurse nurse) {
        nurseRepository.delete(nurse);
    }
    public Nurse getNurseById(int id) {
        Optional<Nurse> nurse = nurseRepository.findById(id);
        return nurse.orElse(null);
    }
    public List<Nurse> getNursesByUsername(String username) {
        List<Nurse> nurse = nurseRepository.findAllByWebIdentity_username(username);
        return nurse;
    }
    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

}
