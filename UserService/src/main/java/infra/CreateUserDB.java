package infra;

import core.db.ConnectionJDBC;
import core.exceptions.InvalidUserAttributes;
import org.jasypt.util.password.BasicPasswordEncryptor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUserDB {
    private Consumer consumer;
    private Connection connection = ConnectionJDBC.getConnection();
    private VerifyUserAttributes verifyUserAttributes;
    public boolean createUserMySql() throws InvalidUserAttributes {
        boolean ok = true;
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(consumer.getPassword());
        this.consumer = new Consumer.ConsumerBuilder().setPassword(encryptedPassword).build();

        if(!(verifyUserAttributes.verifyAttributes(this.consumer.getName(), this.consumer.getEmail(), this.consumer.getCellphone()))){

        }

        String sqlQuery = "INSERT INTO `concessionaria`.`consumer` (`username`, `userpassword`, `email`, `cellphone`) VALUES ('"+consumer.getName()+"', '"+consumer.getPassword()+"', '"+consumer.getEmail()+"', '"+consumer.getCellphone()+"');";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sqlQuery);
        } catch (SQLException e) {
            ok = false;
            throw new RuntimeException(e);
        }
        return ok;
    }
}
