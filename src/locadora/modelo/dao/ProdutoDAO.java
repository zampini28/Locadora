package locadora.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import locadora.FabricaConexao;
import locadora.modelo.Produto;

public class ProdutoDAO {
    private static final String SELECT = "SELECT * FROM produto";
    private static final String INSERT = "INSERT INTO produto (nome, categoria_id) VALUES (?, ?)";
    private static final String DELETE = "DELETE FROM produto WHERE id = ?";
    private static final String UPDATE = "UPDATE produto SET nome = ?, categoria_id = ? WHERE id = ?";
    private static final String FETCH = "SELECT * FROM produto WHERE id = ?";

    public static List<Produto> listarTodos() {
        try (Connection conexao = FabricaConexao.getConexao()) {
            ResultSet rs = conexao.createStatement().executeQuery(SELECT);
            List<Produto> produtos = new ArrayList<>();
            while (rs.next())
                produtos.add(new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("categoria_id")) {
                        @Override
                        public String toString() {
                            return "\nID.........: " + this.getId() +
                                   "\nNome.......: " + this.getNome() +
                                   "\nCategoria..: " +
                                   CategoriaDAO.buscarNome(this.getCategoria());
                        }});
            return produtos;
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível listar todos os produtos.");
        }
    }

    public static boolean inserirProduto(Produto produto) {
        try (Connection conexao = FabricaConexao.getConexao()) {
            PreparedStatement ps = conexao.prepareStatement(INSERT);
            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getCategoria());
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível inserir o produto.");
        }
    }

    public static boolean deletarProduto(Produto produto) {
        try (Connection conexao = FabricaConexao.getConexao()) {
            PreparedStatement ps = conexao.prepareStatement(DELETE);
            ps.setInt(1, produto.getId());
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível deletar o produto.");
        }
    } 

    public static boolean atualizarProduto(Produto produto) {
        try (Connection conexao = FabricaConexao.getConexao()) {
            PreparedStatement ps = conexao.prepareStatement(UPDATE);
            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getCategoria());
            ps.setInt(3, produto.getId());
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível atualizar o produto.");
        }  
    }

    public static Produto buscarProduto(Produto produto) {
        try (Connection conexao = FabricaConexao.getConexao()) {
            PreparedStatement ps = conexao.prepareStatement(FETCH);
            ps.setInt(1, produto.getId());
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Produto(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("categoria_id")
            );
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar o produto.");
        }
    }
}
   