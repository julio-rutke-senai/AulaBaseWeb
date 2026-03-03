package aulabaseweb.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {

    private ProdutoController produtoController = new ProdutoController();

    public void start() throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(8080)){

            System.out.println("Server Started!");

            while(true){
                try(Socket socket = serverSocket.accept()){
                    System.out.println("Client Connected!");
                    InputStream inputStream = socket.getInputStream();

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(inputStream));

                    String line = reader.readLine();
                    StringBuilder requestBuilder = new StringBuilder();

                    String[] split = line.split(" ");

                    String metodo = split[0];
                    String caminho = split[1];

                    while((line = reader.readLine()) != null
                            && !line.isEmpty()){
                        requestBuilder.append(line).append("\n");
                    }

                    System.out.println("Requisição Recebida: ");
                    System.out.println(requestBuilder);

                    if(caminho.equals("/buscar_produto")){
                        produtoController.buscarProduto(socket);
                    } else if(caminho.equals("/adicionar")){
                        produtoController.adicionar(socket);
                    }

                }
            }

        }
    }

}
