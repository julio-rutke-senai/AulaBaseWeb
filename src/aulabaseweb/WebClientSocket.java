package aulabaseweb;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class WebClientSocket {

    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("127.0.0.1", 8080)){
            OutputStream outputStream = socket.getOutputStream();

            PrintStream printStream = new PrintStream(outputStream);

            printStream.println("GET / HTTP/1.1");
            printStream.println("Host: localhost");
            printStream.println("Operacao: Cadastro");
            printStream.println();
            printStream.print("Teste de Requisição");

            InputStream inputStream = socket.getInputStream();

            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(inputStream));

            String line;
            StringBuilder requestBuilder = new StringBuilder();
            int responseLength = 0;

            while((line = bufferedReader.readLine()) != null
                    && !line.isEmpty()){
                requestBuilder.append(line).append("\n");
                if(line.startsWith("Content-Lenght")){
                    String[] split = line.split(":");
                    responseLength = Integer.parseInt(split[1].trim());
                }
            }

            String responseBody = "";
            if(responseLength > 0){
                byte[] responseBytes = inputStream.readNBytes(responseLength);
                responseBody = new String(responseBytes);
            }

            System.out.println("Response: "+requestBuilder.toString());
            System.out.println("Body: "+responseBody);

        }
    }

}
