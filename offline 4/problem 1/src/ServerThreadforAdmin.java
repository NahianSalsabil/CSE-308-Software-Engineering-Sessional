import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThreadforAdmin implements Runnable{
    Server server = new Server();
    Socket adminSocket;
    DataInputStream dis;
    DataOutputStream dos;
    Thread t;

    ServerThreadforAdmin(Socket adminSocket) throws IOException {
        this.adminSocket = adminSocket;
//        this.dis = dis;
//        this.dos = dos;
        dis = new DataInputStream(adminSocket.getInputStream());
        dos = new DataOutputStream(adminSocket.getOutputStream());
        ArrayList<Stocks> stocklist = server.getStockList();
        String stockdetails = "Stocks: \n";
        for(int i = 0; i < stocklist.size(); i++){
            stockdetails += stocklist.get(i).getStockname() + " " + stocklist.get(i).getStockcount() + " " + stocklist.get(i).getStockprice() + "\n";
        }
        dos.writeUTF(stockdetails);
        t= new Thread(this);
        t.start();

    }

    @Override
    public void run() {

        try {
//            DataInputStream dis = new DataInputStream(adminSocket.getInputStream());
//            DataOutputStream dos = new DataOutputStream(adminSocket.getOutputStream());

            while (true) {
                //read from client...
                String cMsg = dis.readUTF();
                if(cMsg==null)
                    break;
                System.out.println(cMsg);
                if(cMsg.split(" ")[0].equalsIgnoreCase("I")){
                    String stockname = cMsg.split(" ")[1];
                    float stockprice = Float.parseFloat(cMsg.split(" ")[2]);
                    ArrayList<Stocks> stocklist = server.getStockList();
                    for(int i =0; i < stocklist.size(); i++){
                        if(stocklist.get(i).getStockname().equalsIgnoreCase(stockname)){
                            stocklist.get(i).IncreaseStockPrice(stockprice);

                            ArrayList<ServerThreadforClient> clientList = server.getClientList();
                            for(int j = 0; j < clientList.size(); j++){
                                ArrayList<Stocks> clientstock = clientList.get(j).getUser().getSubscribedStock();
                                for(int k = 0; k < clientstock.size(); k++){
                                    if(clientstock.get(k) == stocklist.get(i)){
                                        String stockdetails = clientList.get(j).getUser().ShowStock();
                                        clientList.get(j).dos.writeUTF("Your Subscribed Stock " + stocklist.get(i).getStockname() + "'s price has been increased by " + stockprice);
                                        clientList.get(j).dos.writeUTF(stockdetails);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                else if(cMsg.split(" ")[0].equalsIgnoreCase("D")){
                    String stockname = cMsg.split(" ")[1];
                    float stockprice = Float.parseFloat(cMsg.split(" ")[2]);
                    ArrayList<Stocks> stocklist = server.getStockList();
                    for(int i =0; i < stocklist.size(); i++){
                        if(stocklist.get(i).getStockname().equalsIgnoreCase(stockname)){
                            stocklist.get(i).DecreaseStockPrice(stockprice);

                            ArrayList<ServerThreadforClient> clientList = server.getClientList();
                            for(int j = 0; j < clientList.size(); j++){
                                ArrayList<Stocks> clientstock = clientList.get(j).getUser().getSubscribedStock();
                                for(int k = 0; k < clientstock.size(); k++){
                                    if(clientstock.get(k) == stocklist.get(i)){
                                        String stockdetails = clientList.get(j).getUser().ShowStock();
                                        clientList.get(j).dos.writeUTF("Your Subscribed Stock " + stocklist.get(i).getStockname() + "'s price has been decreased by " + stockprice);
                                        clientList.get(j).dos.writeUTF(stockdetails);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                else if(cMsg.split(" ")[0].equalsIgnoreCase("C")){
                    String stockname = cMsg.split(" ")[1];
                    int stockcount = Integer.parseInt(cMsg.split(" ")[2]);
                    ArrayList<Stocks> stocklist = server.getStockList();
                    for(int i =0; i < stocklist.size(); i++){
                        if(stocklist.get(i).getStockname().equalsIgnoreCase(stockname)){
                            stocklist.get(i).changeStockCount(stockcount);

                            ArrayList<ServerThreadforClient> clientList = server.getClientList();
                            for(int j = 0; j < clientList.size(); j++){
                                ArrayList<Stocks> clientstock = clientList.get(j).getUser().getSubscribedStock();
                                for(int k = 0; k < clientstock.size(); k++){
                                    if(clientstock.get(k) == stocklist.get(i)){
                                        String stockdetails = clientList.get(j).getUser().ShowStock();
                                        clientList.get(j).dos.writeUTF("Your Subscribed Stock " + stocklist.get(i).getStockname() + "'s count has been increased by " + stockcount);
                                        clientList.get(j).dos.writeUTF(stockdetails);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            adminSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
