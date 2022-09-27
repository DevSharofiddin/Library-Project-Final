package com.library.LibraryProject.JwtToken;

public class AuthenticationRequestDTO {
    private String email;
    private String password;

    public AuthenticationRequestDTO() {
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
