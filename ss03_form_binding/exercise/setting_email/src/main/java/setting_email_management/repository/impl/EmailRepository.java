package setting_email_management.repository.impl;

import org.springframework.stereotype.Repository;
import setting_email_management.model.Email;
import setting_email_management.repository.IEmailRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private static List<Email> emailList = new ArrayList<>();
    private static List<String> languagesList = new ArrayList<>();
    private static List<Integer> pageSizesList = new ArrayList<>();

    private static int autoId = 0;

    static {
        emailList.add(new Email(autoId++, "English", 25, true, "King, Asgard"));
        emailList.add(new Email(autoId++, "Japanese", 5, true, "King, Asgard"));
        emailList.add(new Email(autoId++, "Vietnamese", 100, false, "King, Asgard"));
        emailList.add(new Email(autoId++, "Chinese", 50, true, "King, Asgard"));
        emailList.add(new Email(autoId++, "English", 10, true, "King, Asgard"));
    }

    static {
        languagesList.add("English");
        languagesList.add("Japanese");
        languagesList.add("Chinese");
    }

    static {
        pageSizesList.add(5);
        pageSizesList.add(10);
        pageSizesList.add(15);
        pageSizesList.add(20);
        pageSizesList.add(25);
        pageSizesList.add(50);
        pageSizesList.add(100);
    }


    @Override
    public List<Email> displayAll() {
        return new ArrayList<>(emailList);
    }

    @Override
    public Email findById(int id) {
        return emailList.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<String> languagesList() {
        return new ArrayList<>(languagesList);
    }

    @Override
    public List<Integer> pagaSizeList() {
        return new ArrayList<>(pageSizesList);
    }

    @Override
    public boolean save(Email email) {
        for (int i = 0; i < emailList.size(); i++) {
            if (emailList.get(i).getId() == email.getId()) {
                emailList.set(i, email);
                return true;
            }
        }
        return false;
    }
}
