package case_study_management.dto;

import case_study_management.model.customer.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class CustomerDto implements Validator {
    private int id;

    @NotEmpty(message = "Không được để trống !")
    @NotBlank(message = "Không được nhập ký tự trống đầu tiên !")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Tên người dùng phải tiếng Việt có dấu & viết hoa chữ đầu tiên !")
    private String name;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private boolean gender;

    @Pattern(regexp = "^[0-9]{12}|[0-9]{9}$", message = "Số CMND/CCCD: phải 9 hoặc 12 số")
    private String idCard;

    @NotEmpty(message = "Không được để trống !")
    @Pattern(regexp = "^((\\(\\+84\\-\\))|0)(90|91)[0-9]{7}$", message = "SĐT có định dạng 090|091|+84 + 7 số")
    private String phoneNumber;

    @Email
    @Pattern(regexp = "^[a-zA-Z][.\\w]{7,}@[a-z]{2,9}([.][a-z]{2,3}){1,2}$", message = "Email sai định dạng !")
    private String email;

    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "Vui lòng ghi tiếng Việt có dấu, viết Hoa chữ cái đầu !")
    private String address;
    private CustomerType customerType;
    private boolean isDelete;

    public CustomerDto() {
    }

    public CustomerDto(int id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
