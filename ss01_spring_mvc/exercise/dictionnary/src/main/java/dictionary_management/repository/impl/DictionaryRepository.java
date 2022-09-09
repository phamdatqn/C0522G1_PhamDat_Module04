package dictionary_management.repository.impl;

import dictionary_management.model.Dictionary;
import dictionary_management.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static List<Dictionary>dictionaryList=new ArrayList<>();
    static {
        dictionaryList.add(new Dictionary("hello","Xin chào"));
        dictionaryList.add(new Dictionary("good bye","Tạm biệt"));
        dictionaryList.add(new Dictionary("red","Màu đỏ"));
        dictionaryList.add(new Dictionary("white","Màu trắng"));
    }
    @Override
    public String search(String input) {
        for (Dictionary dictionary: dictionaryList){
            if (input.toLowerCase().equals(dictionary.getEnglish())){
                return dictionary.getVietNam();
            }
        }
        return "Không tìm thấy";
    }
}
