package case_study_management.dto;

import case_study_management.model.employee.Division;
import case_study_management.model.employee.EducationDegree;
import case_study_management.model.employee.Position;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EmployeeDto {
    private int id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String idCard;
    private double salary;
    private String phoneNumber;
    private String email;
    private String address;
    private boolean isDelete;
    private int position;
    private int educationDegree;
    private int division;

    public EmployeeDto() {
    }

    public EmployeeDto(int id) {
        this.id = id;
    }

    public EmployeeDto(int id, String name, Date dateOfBirth, String idCard, double salary, String phoneNumber,
                       String email, String address, boolean isDelete, int position, int educationDegree, int division) {
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
        this.division = division;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(int educationDegree) {
        this.educationDegree = educationDegree;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }
}
