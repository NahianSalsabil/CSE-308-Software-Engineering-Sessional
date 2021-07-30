import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Admin {
    public static void main(String[] args) throws IOException {
        System.out.println("Admin started..");
        Socket socket = new Socket("127.0.0.1", 1309);
        System.out.println("Admin Connected..");
        System.out.println("Enter \"admin login\"");

        Scanner scanner = new Scanner(System.in);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        Thread Write = new Thread(new Runnable()
        {
            @Override
            public void run() {
                while (true) {
                    String msg = scanner.nextLine();
                    try {
                        dos.writeUTF(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread Read = new Thread(new Runnable()
        {
            @Override
            public void run() {

                while (true) {
                    try {
                        // read the message sent to this client
                        String msg = dis.readUTF();
                        System.out.println(msg);
                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                }
            }
        });

        Write.start();
        Read.start();

    }
}
