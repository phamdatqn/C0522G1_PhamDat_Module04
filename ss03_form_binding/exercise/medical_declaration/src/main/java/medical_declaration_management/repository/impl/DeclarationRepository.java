package medical_declaration_management.repository.impl;

import medical_declaration_management.model.Declaration;
import medical_declaration_management.repository.IDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeclarationRepository implements IDeclarationRepository {
    private static List<Declaration> declarationList = new ArrayList<>();
    private static List<String> genderList = new ArrayList<>();
    private static List<String> countryList = new ArrayList<>();
    private static List<String> danhSachPhuongTien = new ArrayList<>();
    private static int autoId = 0;

    static {
        declarationList.add(new Declaration(autoId++,"Phạm Đạt","1993-03-03","Nam","Việt Nam","123456789","Tàu bay","VN123","D32","2022-12-12","2022-12-13","Đà nẵng"));
        declarationList.add(new Declaration(autoId++,"Nguyễn Băng","1993-03-03","Nữ","Việt Nam","123456789","Tàu bay","VN123","D32","2022-12-12","2022-12-13","Đà nẵng"));
        declarationList.add(new Declaration(autoId++,"Thanh Hường","1993-03-03","Nam","Việt Nam","123456789","Tàu bay","VN123","D32","2022-12-12","2022-12-13","Đà nẵng"));
    }
    static {
        genderList.add("Nam");
        genderList.add("Nữ");
        genderList.add("Khác");
    }
    static {
        countryList.add("Việt Nam");
        countryList.add("Anh");
        countryList.add("Nhật Bản");
    }
    static {
        danhSachPhuongTien.add("Tàu bay");
        danhSachPhuongTien.add("Tàu thuyền");
        danhSachPhuongTien.add("Ô tô");
        danhSachPhuongTien.add("Khác (ghi rõ)");
    }

    @Override
    public List<Declaration> displayAll() {
        return new ArrayList<>(declarationList);
    }

    @Override
    public List<String> gender() {
        return new ArrayList<>(genderList);
    }

    @Override
    public List<String> country() {
        return new ArrayList<>(countryList);
    }

    @Override
    public List<String> phuongTien() {
        return new ArrayList<>(danhSachPhuongTien);
    }

    @Override
    public void save(Declaration declaration) {
        declarationList.add(declaration);
    }
}
