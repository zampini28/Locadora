## Getting Started

Bem-vindo ao projeto Locadora. Para utilizá-lo, verifique se você tem o **MySQL Server** instalado e em execução. O usuário deve ser o root e não deve ter senha. Se estiver usando um usuário ou senha diferente, modifique esse [arquivo](path://src/locadora/FabricaConexao.java).

Antes de executar o projeto, certifique-se de executar o seguinte comando para criar o banco de dados necessário:
```
sudo mysql < sql/BancoDeDados.sql
```

Para compilar e executar o projeto, utilize o seguinte comando no Linux:
```
./build
```

> Esse projeto já possui o *Driver JDBC*.