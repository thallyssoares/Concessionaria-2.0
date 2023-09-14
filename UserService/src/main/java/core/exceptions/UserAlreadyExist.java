package core.exceptions;

public class UserAlreadyExist extends Exception{
    @Override
    public String toString() {
        return "Não é possivel criar a conta. Usuario já existe.";
    }
}
