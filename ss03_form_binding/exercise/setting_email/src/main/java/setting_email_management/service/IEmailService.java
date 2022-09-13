package setting_email_management.service;

import setting_email_management.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> displayAll();

    Email findById(int id);

    List<String> languagesList();

    List<Integer> pagaSizeList();

    boolean save(Email email);
}
