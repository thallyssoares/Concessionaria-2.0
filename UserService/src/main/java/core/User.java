package core;

public abstract class User {
    protected String name;
    protected int id;
    protected String email;
    protected String cellphone;
    protected String password;

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCellphone() {
        return this.cellphone;
    }
}
