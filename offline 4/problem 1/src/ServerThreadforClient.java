import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class ServerThreadforClient implements Runnable {

    Server server = new Server();
    Socket clientSocket;
    DataInputStream dis;
    DataOutputStream dos;
    Thread t;
    private User user;

    ServerThreadforClient(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        dis = new DataInputStream(clientSocket.getInputStream());
        dos = new DataOutputStream(clientSocket.getOutputStream());
        ArrayList<Stocks> stocklist = server.getStockList();
        String stockdetails = "Stocks: \n";
        for(int i = 0; i < stocklist.size(); i++){
            stockdetails += stocklist.get(i).getStockname() + " " + stocklist.get(i).getStockcount() + " " + stocklist.get(i).getStockprice() + "\n";
        }
        dos.writeUTF(stockdetails);
        t= new Thread(this);
        user = new User();
        t.start();

    }

    public User getUser(){
        return this.user;
    }

    @Override
    public void run() {

        try {
            while (true) {
                //read from client...
                String cMsg = dis.readUTF();
                if(cMsg==null)
                    break;
                System.out.println(cMsg);
                if(cMsg.split(" ")[0].equalsIgnoreCase("S")){
                    String stockname = cMsg.split(" ")[1];
                    ArrayList<Stocks> stocklist = server.getStockList();
                    for(int i =0; i < stocklist.size(); i++){
                        if(stocklist.get(i).getStockname().equalsIgnoreCase(stockname)){
                            user.addStock(stocklist.get(i));
                        }
                    }
                    String stockdetails = user.ShowStock();
                    dos.writeUTF(stockdetails);
                }
                else if(cMsg.split(" ")[0].equalsIgnoreCase("U")){
                    String stockname = cMsg.split(" ")[1];
                    ArrayList<Stocks> stocklist = server.getStockList();
                    for(int i =0; i < stocklist.size(); i++){
                        if(stocklist.get(i).getStockname().equalsIgnoreCase(stockname)){
                            user.removeStock(stocklist.get(i));
                        }
                    }
                    String stockdetails = user.ShowStock();
                    dos.writeUTF(stockdetails);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
