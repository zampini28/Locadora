package locadora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver do MySQL não encontrado.");
        }
    }

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/locadora",
                "root",
                "dennis_ritchie"
            );
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível fazer conexão.");
        }
    }
}
