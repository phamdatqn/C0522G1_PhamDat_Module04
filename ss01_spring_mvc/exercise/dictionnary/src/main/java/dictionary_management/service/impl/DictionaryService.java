package dictionary_management.service.impl;

import dictionary_management.repository.IDictionaryRepository;
import dictionary_management.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {

    @Autowired
    private IDictionaryRepository iDictionaryRepository;

    @Override
    public String search(String input) {
        return iDictionaryRepository.search(input);
    }
}
