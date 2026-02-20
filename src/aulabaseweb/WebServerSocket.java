package aulabaseweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebServerSocket {
    
    public static void main(String[] args) throws IOException{
        
        
        List<Produto> produtos = new ArrayList();
        
        produtos.add(new Produto(1, "Teclado", 50.0f));
        produtos.add(new Produto(2, "Mouse", 150.0f));
        produtos.add(new Produto(3, "Monitor", 1500.0f));
        produtos.add(new Produto(4, "Processador", 950.0f));
        produtos.add(new Produto(5, "Memoria", 500.0f));
        
        
        try(ServerSocket serverSocket = new ServerSocket(8080)){
            
            System.out.println("Server Started!");
            
            while(true){
                try(Socket socket = serverSocket.accept()){               
                    System.out.println("Client Connected!");
                    
                    InputStream inputStream = socket.getInputStream();

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(inputStream));
                    
                    String line;
                    StringBuilder requestBuilder = new StringBuilder();
                    
                    while((line = reader.readLine()) != null 
                            && !line.isEmpty()){
                        requestBuilder.append(line).append("\n");
                    }
                    
                    System.out.println("Requisição Recebida: ");
                    System.out.println(requestBuilder);
              
                    OutputStream outputStream = socket.getOutputStream();
                    
                    PrintStream printStream = new PrintStream(outputStream);
                    
                    printStream.println("HTTP/1.1 200 OK");
                    printStream.println("Content-Type: application/json");
                    printStream.println("");
                    printStream.println("""
                                        { 
                                            "status": "OK", 
                                            "message": "Servidor funcionando!"
                                        }
                                        """);
                            
                    
                    
                }
            }
            
        }
        
        
         
    }
    
}
