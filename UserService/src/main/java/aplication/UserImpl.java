package aplication;

import core.User;
import core.exceptions.InvalidUserAttributes;
import core.exceptions.UserAlreadyExist;
import core.usecase.UserUseCase;

public class UserImpl implements UserUseCase{
    private VerifyUserExist verifyUserExist;
    private VerifyUserAttributes verifyUserAttributes;

    public void create(User user) throws InvalidUserAttributes, UserAlreadyExist{
        if (verifyUserExist.userExist(user.getId())){
            throw new UserAlreadyExist();
        }
        if (!verifyUserAttributes.verifyAttributes(user.getName(), user.getEmail(), user.getCellphone())){
            throw new InvalidUserAttributes();
        }
    }
    public void delete(User user) throws InvalidUserAttributes{
        if(!verifyUserAttributes.verifyAttributes(user.getName(), user.getEmail(), user.getCellphone())){
            throw new InvalidUserAttributes();
        }
    }

    @Override
    public void update(String update) throws InvalidUserAttributes, Exception {
        switch(update){
            case "email":
                break;
            case "password":
                break;
            case "cellphone":
                break;
            case "name":
                break;
            default:
                throw new Exception("Opção incorreta");
        }
    }


    public boolean login(String email, String password) throws InvalidUserAttributes {
        if(!verifyUserAttributes.verifyLoginAttributes(email, password)){
            throw new InvalidUserAttributes();
        }
        return true;
    }

}
