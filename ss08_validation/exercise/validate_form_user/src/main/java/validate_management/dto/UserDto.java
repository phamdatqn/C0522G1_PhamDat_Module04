package validate_management.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;


public class UserDto implements Validator {
    @NotEmpty(message = "Không được để trống !")
    @NotBlank(message = "Không được nhập ký tự trống đầu tiên !")
    @Size(min = 5, max = 45, message = "Tối thiểu 5 ký tự, tối đa 45 ký tự !")
    private String firstName;

    @NotEmpty(message = "Không được để trống !")
    @NotBlank(message = "Không được nhập ký tự trống đầu tiên !")
    @Size(min = 5, max = 45, message = "Tối thiểu 5 ký tự, tối đa 45 ký tự !")
    private String lastName;

    @NotEmpty(message = "Không được để trống !")
    @Pattern(regexp = "^(090|091)[0-9]{7}$", message = "SĐT có định dạng 090|091 + 7 số")
    private String phoneNumber;

    @NotEmpty(message = "Không được để trống !")
    @Min(value = 18, message = "Tuổi phải lớn hơn 18 !")
    private String age;

    @NotEmpty(message = "Không được để trống !")
    @Email
    private String email;

    public UserDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto= (UserDto) target;
        if ("admin".equals(userDto.getLastName())){
            errors.rejectValue("lastName","","Không được dùng Admin !!!");
        }

    }
}
