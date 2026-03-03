package aulabaseweb.controller;

import aulabaseweb.repository.ProdutoRepository;
import aulabaseweb.service.ProdutoService;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ProdutoController {

    private ProdutoService produtoService = new ProdutoService();

    public void handle(){

    }

    public void buscarProduto(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();

        PrintStream printStream = new PrintStream(outputStream);

        StringBuilder bodyResponse = produtoService.buscarProdutos();

        montarResposta(printStream, bodyResponse);
    }

    private static void montarResposta(PrintStream printStream, StringBuilder bodyResponse) {
        printStream.println("HTTP/1.1 200 OK");
        printStream.println("Content-Type: application/json");
        printStream.println("Content-Lenght: "+ bodyResponse.toString()
                .getBytes(StandardCharsets.UTF_8)
                .length);
        printStream.println("");
        printStream.println(bodyResponse);
    }

    public void adicionar(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        StringBuilder bodyResponse = produtoService.adicionarProduto();

        montarResposta(printStream, bodyResponse);
    }
}
