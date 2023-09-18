package infra.db.actions;

import core.db.ConnectionJDBC;
import core.exceptions.InvalidUserAttributes;
import infra.Consumer;
import infra.VerifyUserAttributes;
import org.jasypt.util.password.BasicPasswordEncryptor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUserDB {
    private Consumer consumer;
    private final Connection connection = ConnectionJDBC.getConnection();
    private VerifyUserAttributes verify;

    public CreateUserDB(Consumer consumer){
        this.consumer = consumer;
        this.verify = new VerifyUserAttributes();
    }
    public boolean createUserMySql(){
        boolean ok = true;
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(consumer.getPassword());
        this.consumer = new Consumer.ConsumerBuilder().setName(this.consumer.getName()).setEmail(this.consumer.getEmail()).setCellphone(this.consumer.getCellphone()).setPassword(encryptedPassword).build();

        try {
            if((verify.verifyAttributes(this.consumer.getName(), this.consumer.getEmail(), this.consumer.getCellphone()))){
                String sqlQuery = "INSERT INTO `concessionaria`.`consumer` (`username`, `userpassword`, `email`, `cellphone`) VALUES ('"+consumer.getName()+"', '"+consumer.getPassword()+"', '"+consumer.getEmail()+"', '"+consumer.getCellphone()+"');";

                try {
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate(sqlQuery);
                    ConnectionJDBC.close(connection, stmt);
                } catch (SQLException e) {
                    ok = false;
                    throw new RuntimeException(e);
                }
            }
        } catch (InvalidUserAttributes e) {
            throw new RuntimeException(e);
        }


        return ok;
    }
}
