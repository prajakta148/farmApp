package e.nikita.farmapp;

import android.app.Application;

public class User {
    private String userName;
    private String password;
    private String mobile;
    public User()
    {

    }

    public User(String userName, String password, String mobile) {

        this.userName = userName;
        this.password = password;
        this.mobile = mobile;
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }
}
