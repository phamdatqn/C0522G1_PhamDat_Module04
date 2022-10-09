package case_study_management.dto;

import case_study_management.model.employee.Divisions;
import case_study_management.model.employee.EducationDegree;
import case_study_management.model.employee.Position;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class EmployeeDto implements Validator {
    private int id;

//    @NotEmpty(message = "Không được để trống !")
//    @NotBlank(message = "Không được nhập ký tự trống đầu tiên !")
//    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
//            message = "Tên người dùng phải tiếng Việt có dấu & viết hoa chữ đầu tiên !")
    private String name;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

//    @NotEmpty(message = "Không được để trống !")
//    @NotBlank(message = "Không được nhập ký tự trống đầu tiên !")
//    @Pattern(regexp = "^[0-9]{12}|[0-9]{9}$", message = "Số CMND/CCCD: phải 9 hoặc 12 số")
    private String idCard;

//    @NotEmpty(message = "Không được để trống !")
//    @NotBlank(message = "Không được nhập ký tự trống đầu tiên !")
    private double salary;

    private String phoneNumber;
    private String email;
    private String address;
    private boolean isDelete;
    private Position position;
    private EducationDegree educationDegree;
    private Divisions divisions;

    public EmployeeDto() {
    }

    public EmployeeDto(int id, String name, Date dateOfBirth, String idCard, double salary, String phoneNumber,
                       String email, String address, boolean isDelete, Position position,
                       EducationDegree educationDegree, Divisions divisions) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.isDelete = isDelete;
        this.position = position;
        this.educationDegree = educationDegree;
        this.divisions = divisions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Divisions getDivisions() {
        return divisions;
    }

    public void setDivisions(Divisions divisions) {
        this.divisions = divisions;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}


