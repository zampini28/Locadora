package locadora.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import locadora.FabricaConexao;

public class CategoriaDAO {
    private static final String FETCH = "SELECT id FROM categoria WHERE nome = ?";
    private static final String FETCH_NOME = "SELECT nome FROM categoria WHERE id = ?";
    public static int buscarId(String nome) {
        try (Connection conexao = FabricaConexao.getConexao()) {
            PreparedStatement ps = conexao.prepareStatement(FETCH);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException("Nome da categoria não encontrado.");
        }
    }

    public static String buscarNome(int id) {
        try (Connection conexao = FabricaConexao.getConexao()) {
            PreparedStatement ps = conexao.prepareStatement(FETCH_NOME);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString("nome");
        } catch (SQLException e) {
            throw new RuntimeException("ID da categoria não encontrado.");
        }
    }
}
