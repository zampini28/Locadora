package locadora.controle;

import locadora.modelo.Produto;
import locadora.modelo.dao.ProdutoDAO;
import locadora.modelo.dao.CategoriaDAO;

public class ProdutoControle {
    public static boolean controle(String[] dados, String operacao) {
        return switch (operacao) {
            case "Inserir" -> inserirProduto(dados);
            case "Deletar" -> deletarProduto(dados);
            case "Atualizar" -> atualizarProduto(dados);
            case "Buscar" -> buscarProduto(dados);
            default -> throw new IllegalArgumentException("Operação inválida!");
        };
    }

    public static boolean inserirProduto(String[] dados) {
        return ProdutoDAO.inserirProduto(new Produto(
            null, 
            dados[1], 
            CategoriaDAO.buscarId(dados[2]))
        );
    }

    public static boolean deletarProduto(String[] dados) {
        return ProdutoDAO.deletarProduto(new Produto(
            Integer.parseInt(dados[0]), 
            null, 
            null)
        );
    }

    public static boolean atualizarProduto(String[] dados) {
        return ProdutoDAO.atualizarProduto(new Produto(
            Integer.parseInt(dados[0]), 
            dados[1], 
            CategoriaDAO.buscarId(dados[2]))
        );
    }

    public static boolean buscarProduto(String[] dados) {
        Produto produto = ProdutoDAO.buscarProduto(new Produto(
            Integer.parseInt(dados[0]), 
            null, 
            null)
        );

        if (produto != null) {
            dados[0] = produto.getId().toString();
            dados[1] = produto.getNome();
            dados[2] = CategoriaDAO.buscarNome(produto.getCategoria());
            return true;
        }

        return false;
    }
}
