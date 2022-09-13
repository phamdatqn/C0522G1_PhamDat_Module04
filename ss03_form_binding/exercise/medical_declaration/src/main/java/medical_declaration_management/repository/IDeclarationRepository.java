package medical_declaration_management.repository;

import medical_declaration_management.model.Declaration;

import java.util.List;

public interface IDeclarationRepository {
    List<Declaration> displayAll();

    List<String> gender();

    List<String> country();

    List<String> vehicle();

    Declaration findById(int id);

    void create(Declaration declaration);

    boolean update(Declaration declaration);

}
