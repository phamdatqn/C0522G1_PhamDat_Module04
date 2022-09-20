package validate_management.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


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

    @Pattern(regexp = "[1-8][0-9]", message = "Tuổi phải lớn hơn 18 nhớ hơn 89 !")
    private String age;

    @Pattern(regexp = "^[a-zA-Z][.\\w]{7,}@[a-z]{2,9}([.][a-z]{2,3}){1,2}$")
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
