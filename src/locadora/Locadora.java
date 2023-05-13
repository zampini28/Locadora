package locadora;

import locadora.controle.ProdutoControle;
import locadora.modelo.dao.ProdutoDAO;
import locadora.view.Tela;

public class Locadora implements Runnable {
    public static void main(String[] args) {
        new Thread(new Locadora()).start();
        new Thread(new Tela()).start();
        System.out.println("end");
    }

    public void run() {
        while (true) {
            ProdutoDAO.listarTodos().forEach(System.out::println);
            System.console().readLine();
        }
    }
}