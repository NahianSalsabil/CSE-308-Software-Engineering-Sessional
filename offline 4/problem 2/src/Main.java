import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Mediator mediator = new Con_Mediator_JCC();
        JPDC jpdc = null;
        JRTA jrta = null;
        JTRC jtrc = null;
        JWSA jwsa = null;
        System.out.println("Type \"init\" to instantiate all services");
        Scanner scanner = new Scanner(System.in);
        while(true){
            String command = scanner.nextLine();
            if(command.equalsIgnoreCase("init")){
                jpdc = new JPDC(mediator);
                jrta = new JRTA(mediator);
                jtrc = new JTRC(mediator);
                jwsa = new JWSA(mediator);
                System.out.println("All four services are initiated through mediator");
            }
            else if(command.split(" ")[1].equalsIgnoreCase("serve")){
                String serveorgName = command.split(" ")[0];
                if(serveorgName.equalsIgnoreCase("jpdc")){
                    jpdc.setOrgName("jpdc");
                    jpdc.ProvideService();
                }
                else if(serveorgName.equalsIgnoreCase("jrta")) {
                    jrta.setOrgName("jrta");
                    jrta.ProvideService();
                }
                else if(serveorgName.equalsIgnoreCase("jtrc")) {
                    jtrc.setOrgName("jtrc");
                    jtrc.ProvideService();
                }
                else if(serveorgName.equalsIgnoreCase("jwsa")){
                    jwsa.setOrgName("jwsa");
                    jwsa.ProvideService();
                }
            }
            else{
                String orgName = command.split(" ")[0];
                String serviceName = command.split(" ")[1];
                if(orgName.equalsIgnoreCase("jpdc")) {
                    jpdc.setOrgName(orgName);
                    jpdc.setServiceName(serviceName);
                    jpdc.RequestService();
                }
                else if(orgName.equalsIgnoreCase("jrta")){
                    jrta.setOrgName("jrta");
                    jrta.setServiceName(serviceName);
                    jrta.RequestService();
                }
                else if(orgName.equalsIgnoreCase("jtrc")){
                    jtrc.setOrgName("jtrc");
                    jtrc.setServiceName(serviceName);
                    jtrc.RequestService();
                }
                else if(orgName.equalsIgnoreCase("jwsa")){
                    jwsa.setOrgName("jwsa");
                    jwsa.setServiceName(serviceName);
                    jwsa.RequestService();
                }
            }
        }
    }
}
