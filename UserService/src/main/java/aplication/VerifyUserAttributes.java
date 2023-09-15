package aplication;

import core.exceptions.InvalidUserAttributes;

public interface VerifyUserAttributes{
    boolean verifyAttributes(String name, String email, String cellphone)  throws InvalidUserAttributes;
    boolean verifyLoginAttributes(String email, String password)  throws InvalidUserAttributes;
}
