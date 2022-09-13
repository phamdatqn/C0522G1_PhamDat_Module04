package medical_declaration_management.service;

import medical_declaration_management.model.Declaration;

import java.util.List;

public interface IDeclarationService {
    List<Declaration> displayAll();

    List<String> gender();

    List<String> country();

    List<String> vehicle();

    Declaration findById(int id);

    boolean update(Declaration declaration);

    void create(Declaration declaration);

}
