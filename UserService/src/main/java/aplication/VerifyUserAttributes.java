package aplication;

public interface VerifyUserAttributes {
    boolean verifyAttributes(String name, String email, String cellphone);
    boolean verifyLoginAttributes(String email, String password);
}
