import java.net.InetSocketAddress;
import java.net.Socket;

public class PortScanner {

    public static void main(String[] args) {
        String targetHost = "localhost"; // Change this to the target IP or hostname
        int startPort = 1;
        int endPort = 65535; // Change this to the last port you want to scan

        System.out.println("Scanning ports on " + targetHost + " from " + startPort + " to " + endPort);

        for (int port = startPort; port <= endPort; port++) {
            if (isPortOpen(targetHost, port)) {
                System.out.println("Port " + port + " is open.");
            } 
        }
    }

    public static boolean isPortOpen(String host, int port) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 1000); // 1000 ms timeout
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

