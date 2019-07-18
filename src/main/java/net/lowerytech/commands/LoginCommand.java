package net.lowerytech.commands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginCommand {

    @NotEmpty
    @Size(min = 8, max= 20)
    private String userName;

    @NotEmpty
    @Size(min = 8, max = 20)
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
