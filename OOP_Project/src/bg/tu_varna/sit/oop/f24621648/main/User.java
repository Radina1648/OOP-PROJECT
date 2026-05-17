package bg.tu_varna.sit.oop.f24621648.main;

/**
 * Клас, описващ потребител в системата.
 */

public class User {
    private String username;
    private String password;
    private boolean admin;

    /**
     * Създава нов потребител.
     *
     * @param username потребителско име
     * @param password парола
     * @param admin администраторски права
     */

    public User(String username, String password, boolean admin){
        this.username=username;
        this.password=password;
        this.admin=admin;
    }

    /**
     * Връща потребителското име.
     *
     * @return потребителско име
     */

    public String getUsername() {
        return username;
    }

    /**
     * Връща паролата.
     *
     * @return парола
     */

    public String getPassword() {
        return password;
    }

    /**
     * Проверява дали потребителят е администратор.
     *
     * @return true ако е администратор
     */

    public boolean isAdmin() {
        return admin;
    }
}
