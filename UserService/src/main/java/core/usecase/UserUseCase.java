package core.usecase;

import core.User;
import core.exceptions.InvalidUserAttributes;
import core.exceptions.UserAlreadyExist;

public interface UserUseCase {
    void create(User user) throws InvalidUserAttributes, UserAlreadyExist;
    void delete(User user) throws InvalidUserAttributes;
    void update(String update) throws InvalidUserAttributes, Exception;
    boolean login(String email, String password) throws InvalidUserAttributes;

}
