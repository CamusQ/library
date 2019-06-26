package com.Camus.entity;

/**
 * @auther camus
 * date 2019/6/26 16:40
 */
public class BookAdmin {
    private int id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "BookAdmin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
