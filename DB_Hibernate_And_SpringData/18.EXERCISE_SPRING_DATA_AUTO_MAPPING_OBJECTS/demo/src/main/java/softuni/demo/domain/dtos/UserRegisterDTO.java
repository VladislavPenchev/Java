package softuni.demo.domain.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegisterDTO {
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    public UserRegisterDTO(){

    }

    public UserRegisterDTO(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
    }

    @NotNull(message = "Email cannot be null.")
    @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-z]+\\.[a-z]{2,4}", message = "Invalid Email.")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull(message = "Password cannot be null.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?!.*[&%$]).{6,}$", message = "Incorrect password")
    @Size(min = 6, message = "Password must be at least 6 symbol long.")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull(message = "Confirm Password cannot be null.")
    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
