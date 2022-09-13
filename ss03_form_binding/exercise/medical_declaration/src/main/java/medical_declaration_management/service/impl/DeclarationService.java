package medical_declaration_management.service.impl;

import medical_declaration_management.model.Declaration;
import medical_declaration_management.repository.IDeclarationRepository;
import medical_declaration_management.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationService implements IDeclarationService {

    @Autowired
    private IDeclarationRepository iDeclarationRepository;

    @Override
    public List<Declaration> displayAll() {
        return iDeclarationRepository.displayAll();
    }

    @Override
    public List<String> gender() {
        return iDeclarationRepository.gender();
    }

    @Override
    public List<String> country() {
        return iDeclarationRepository.country();
    }

    @Override
    public List<String> phuongTien() {
        return iDeclarationRepository.phuongTien();
    }

    @Override
    public void save(Declaration declaration) {
        iDeclarationRepository.save(declaration);
    }
}
