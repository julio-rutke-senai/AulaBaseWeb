package aulabaseweb;

import aulabaseweb.controller.SimpleHttpServer;
import aulabaseweb.model.Produto;
import aulabaseweb.repository.ProdutoRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class WebServerSocket {
    
    public static void main(String[] args) throws IOException{
        new SimpleHttpServer().start();
    }
    
}
