package locadora.view;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import locadora.controle.ProdutoControle;

public class Tela implements Runnable {
    JLabel idLabel;
    JLabel nomeLabel;
    JLabel categoriaLabel;
    JLabel resultLabel;

    JTextField idField;
    JTextField nomeField;
    JTextField categoriaField;

    JButton registerButton;
    JButton deleteButton;
    JButton updateButton;
    JButton findButton;

    public void run() {
        // Create a JFrame, which is a window that allows us to add components
        JFrame frame = new JFrame("Produtos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(null);

        // Create a JLabel for each JTextField and set their bounds
        idLabel = new JLabel("ID");
        idLabel.setBounds(20, 20, 100, 30);

        nomeLabel = new JLabel("Nome");
        nomeLabel.setBounds(20, 80, 100, 30);

        categoriaLabel = new JLabel("Categoria");
        categoriaLabel.setBounds(20, 140, 100, 30);

        resultLabel = new JLabel();
        resultLabel.setBounds(20, 200, 200, 30);

        // Create a JTextField for each JLabel and set their bounds
        idField = new JTextField();
        idField.setBounds(130, 20, 100, 30);

        nomeField = new JTextField();
        nomeField.setBounds(130, 80, 100, 30);

        categoriaField = new JTextField();
        categoriaField.setBounds(130, 140, 100, 30);

        // Create a JButton for each operation and set their bounds
        registerButton = new JButton("Inserir");
        registerButton.setBounds(240, 20, 100, 30);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText((
                    ProdutoControle.controle(new String[] {
                        idField.getText(), nomeField.getText(), categoriaField.getText()
                    }, registerButton.getText())) 
                    ? "Produto inserido com sucesso!" : "Erro ao inserir produto!");
            }
        });

        deleteButton = new JButton("Excluir");
        deleteButton.setBounds(240, 80, 100, 30);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText((
                    ProdutoControle.controle(new String[] {
                        idField.getText(), nomeField.getText(), categoriaField.getText()
                    }, deleteButton.getText())) 
                    ? "Produto excluido com sucesso!" : "Erro ao excluir produto!");
            }
        });

        updateButton = new JButton("Atualizar");
        updateButton.setBounds(240, 140, 100, 30);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText((
                    ProdutoControle.controle(new String[] {
                        idField.getText(), nomeField.getText(), categoriaField.getText()
                    }, updateButton.getText())) 
                    ? "Produto atualizado com sucesso!" : "Erro ao atualizar produto!");
            }
        });

        findButton = new JButton("Buscar");
        findButton.setBounds(240, 200, 100, 30);
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] produto = {idField.getText(), nomeField.getText(), categoriaField.getText()};
                resultLabel.setText((
                    ProdutoControle.controle(produto, findButton.getText())) 
                    ? "| ID: " + produto[0] + " | Nome: " + produto[1] + " | Categoria: " + produto[2] + " |"
                    : "Erro ao buscar produto!");
            }
        });

        // Add all the components to the frame
        frame.add(idLabel);
        frame.add(nomeLabel);
        frame.add(categoriaLabel);
        frame.add(resultLabel);
        frame.add(idField);
        frame.add(nomeField);
        frame.add(categoriaField);
        frame.add(registerButton);
        frame.add(deleteButton);
        frame.add(updateButton);
        frame.add(findButton);

        // Make the frame visible
        frame.setVisible(true);
    }
}