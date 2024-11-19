import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServerTCP {

    public static void main(String[] args) throws Exception {
        /*
        if (args.length <1) {
            System.out.println("Syntax: SimpleServerTCP <port>");
            return;
        }
        */

        int port = Integer.parseInt("8888");

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server attivo su porta: " + port );

        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("NUOVO CLIENT CONNESSO: " +
                    socket.getInetAddress().getHostAddress() +
                    " - CLIENT PORT: " + socket.getPort());

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            int value = input.read();

            output.write(value + 1);

            input.close();
            output.close();
            socket.close();
        }

    }

}

