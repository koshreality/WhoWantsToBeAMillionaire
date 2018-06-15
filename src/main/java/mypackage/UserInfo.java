package mypackage;

public class UserInfo
{
    private String name;
    private String password;
    private boolean active;

    public UserInfo(String name, String password, boolean active) {
        this.name = name;
        this.password = password;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}