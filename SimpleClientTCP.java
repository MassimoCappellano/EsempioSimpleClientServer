import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClientTCP {

        public static void main(String[] args) throws Exception {
           
            /*
            if (args.length <2) {
                System.out.println("Syntax: SimpleClientTCP <serverHost> <serverPort>");
                return;
            }
            */

            String serverHost = "localhost";
            int serverPort = Integer.parseInt("8888");

            Socket socket = new Socket(serverHost, serverPort);

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            int requestInt = 1;
            System.out.println("Invio >> " + requestInt);
            output.write(requestInt);

            int responseInt = input.read();
            System.out.println("Ricevuto << " + responseInt);

            output.close();
            input.close();
            socket.close();
        }
}

