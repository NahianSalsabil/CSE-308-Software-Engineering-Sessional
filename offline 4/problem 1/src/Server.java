import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Server {
    private static ArrayList<ServerThreadforClient> clientList = new ArrayList<>();
    private static ArrayList<User> userList = new ArrayList<>();
    private static ArrayList<Stocks> stockList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File fileobj = new File("src/com/company/input.txt");
        Scanner filereader = new Scanner(fileobj);
        while (filereader.hasNextLine()) {
            String data = filereader.nextLine();
//            System.out.println(data);
            Stocks stock = new Stocks(data.split(" ")[0],Integer.parseInt(data.split(" ")[1]),Float.parseFloat(data.split(" ")[2]));
            stockList.add(stock);
        }
        ServerSocket serverSocket = new ServerSocket(1309);
        System.out.println("Server Started..");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("connected..");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String start = dis.readUTF();
            System.out.println(start);
            if(start.equalsIgnoreCase("client login")){
                ServerThreadforClient client = new ServerThreadforClient(socket);
                System.out.println("new thread started for this client");
                clientList.add(client);
            }
            else if(start.equalsIgnoreCase("admin login")){
                ServerThreadforAdmin admin = new ServerThreadforAdmin(socket);
                System.out.println("new thread started for admin");
            }
        }
    }

    public ArrayList<Stocks> getStockList(){
        return stockList;
    }

    public ArrayList<ServerThreadforClient> getClientList(){
        return clientList;
    }
}



