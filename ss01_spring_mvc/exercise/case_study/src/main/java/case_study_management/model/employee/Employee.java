package case_study_management.model.employee;

import javax.persistence.*;
import java.util.Date;

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
    @JoinColumn(name = "division_id",referencedColumnName = "id")
    private Division division;
}
