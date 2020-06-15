package pract.service;

public interface ServiceSecurity {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}