package case_study_management.model.employee;

import case_study_management.model.contract.Contract;
import case_study_management.model.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date dateOfBirth;
    private String idCard;
    private double salary;
    private String phoneNumber;
    private String email;
    private String address;
    private boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id",referencedColumnName = "id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "divisions_id",referencedColumnName = "id")
    private Divisions divisions;

    @OneToOne
    @JoinColumn(name = "user_name",referencedColumnName = "userName")
    private User user;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;

    public Employee() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", idCard='" + idCard + '\'' +
                ", salary=" + salary +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", isDelete=" + isDelete +
                ", position=" + position +
                ", educationDegree=" + educationDegree +
                ", division=" + divisions +
                ", user=" + user +
                ", contracts=" + contracts +
                '}';
    }
}
