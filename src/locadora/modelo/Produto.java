package locadora.modelo;

public class Produto {
    private final Integer id;
    private final String nome;
    private final Integer categoria;

    public Produto(Integer id, String nome, Integer categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCategoria() {
        return categoria;
    }
}
