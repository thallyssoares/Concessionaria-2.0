package core.exceptions;

public class InvalidUserAttributes extends Exception{

    @Override
    public String toString() {
        return "User attributes are invalid";
    }
}
