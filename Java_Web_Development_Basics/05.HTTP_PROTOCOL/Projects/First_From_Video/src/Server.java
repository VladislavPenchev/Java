import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private int port;
    private ServerSocket tcpListener;

    public Server(int port){
        this.port = port;

    }

    private String getResponse(){
        return "HTTP/1.1 200 OK" + System.lineSeparator()
                + "Host: SoftUni Server 2019" + System.lineSeparator()
                + "Content-Type: text/html" + System.lineSeparator()
                + System.lineSeparator()
                + "<center><h1>Hello, World!</h1></center>";
    }

    public void run() throws IOException {
        this.tcpListener = new ServerSocket(this.port);

        System.out.println("Listening on: http//localhost:" +  this.port);

        while(true){
            Socket clientConnection = this.tcpListener.accept();

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));

            List<String> requestContent = new ArrayList<>();
            String line = "";

            while((line = reader.readLine()) != null && line.length() > 0){
                requestContent.add(line);
            }

            if(requestContent.size() == 0) continue;

            String requestUrl = requestContent.get(0).split("\\s")[1];

            if(requestUrl.contains(".")){
                this.processFile(clientConnection, requestUrl);
                continue;
            }

            System.out.println(requestContent);
            //clientConnection.close();


        }
    }

    private void processFile(Socket clientConnection, String requestUrl) {
        try {
            String content = String.join(System.lineSeparator(), Files.readAllLines(Paths.get(requestUrl)));

            OutputStream outputStream = clientConnection.getOutputStream();

            outputStream.write((this.getResponse() + "<p>" + content + "</p>").getBytes());

            clientConnection.getInputStream().close();
            clientConnection.getOutputStream().close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
