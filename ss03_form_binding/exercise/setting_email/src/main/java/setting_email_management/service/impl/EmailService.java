package setting_email_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import setting_email_management.model.Email;
import setting_email_management.repository.IEmailRepository;
import setting_email_management.service.IEmailService;

import java.util.List;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private IEmailRepository iEmailRepository;

    @Override
    public List<Email> displayAll() {
        return iEmailRepository.displayAll();
    }

    @Override
    public Email findById(int id) {
        return iEmailRepository.findById(id);
    }

    @Override
    public List<String> languagesList() {
        return iEmailRepository.languagesList();
    }

    @Override
    public List<Integer> pagaSizeList() {
        return iEmailRepository.pagaSizeList();
    }

    @Override
    public boolean save(Email email) {
        return iEmailRepository.save(email);
    }

}
