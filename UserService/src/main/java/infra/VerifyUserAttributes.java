package infra;

import core.exceptions.InvalidUserAttributes;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class VerifyUserAttributes implements aplication.VerifyUserAttributes {
    @Override
    public boolean verifyAttributes(String name, String email, String cellphone) throws InvalidUserAttributes{
        boolean isOk = true;
        if(!((validateEmail(email))&&(name.length()>=4)&&(cellphone.length()>=10&&cellphone.length()<=11))){
            isOk = false;
        }
        return isOk;
    }
    public boolean validateEmail(String email){

        boolean ok = true;
        try{
            InternetAddress emailValidator = new InternetAddress(email);
            emailValidator.validate();
        } catch (AddressException ex){
            ok = false;
        }
        return ok;

    }
    @Override
    public boolean verifyLoginAttributes(String email, String password) {
        boolean isLoginOk = true;
        if(!(validateEmail(email)&&(!password.isEmpty()))) isLoginOk = false;
        return isLoginOk;
    }
}
