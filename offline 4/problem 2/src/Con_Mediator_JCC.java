import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class Con_Mediator_JCC implements Mediator{
    Queue<String> JPDC_queue = new LinkedList<>();
    Queue<String> JRTA_queue = new LinkedList<>();
    Queue<String> JTRC_queue = new LinkedList<>();
    Queue<String> JWSA_queue = new LinkedList<>();
    @Override
    public void RequestService(ServiceOrganization orgName) {
        System.out.println(orgName.getOrgName().toUpperCase(Locale.ROOT) + " requests for " + orgName.getServiceName().toUpperCase(Locale.ROOT) + " service");
        if(orgName.getServiceName().equalsIgnoreCase("water"))
            JWSA_queue.add(orgName.getOrgName().toUpperCase(Locale.ROOT));
        else if(orgName.getServiceName().equalsIgnoreCase("power"))
            JPDC_queue.add(orgName.getOrgName().toUpperCase(Locale.ROOT));
        else if(orgName.getServiceName().equalsIgnoreCase("transport"))
            JRTA_queue.add(orgName.getOrgName().toUpperCase(Locale.ROOT));
        else if(orgName.getServiceName().equalsIgnoreCase("telecom"))
            JTRC_queue.add(orgName.getOrgName().toUpperCase(Locale.ROOT));
    }

    @Override
    public void ProvideService(ServiceOrganization serveorgName) {
        if(serveorgName.getOrgName().equalsIgnoreCase("jpdc")){
            System.out.println(serveorgName.getOrgName().toUpperCase(Locale.ROOT) + " serves the request of " + JPDC_queue.remove());
        }
        else if(serveorgName.getOrgName().equalsIgnoreCase("jrta")){
            System.out.println(serveorgName.getOrgName().toUpperCase(Locale.ROOT) + " serves the request of " + JRTA_queue.remove());
        }
        else if(serveorgName.getOrgName().equalsIgnoreCase("jtrc")){
            System.out.println(serveorgName.getOrgName().toUpperCase(Locale.ROOT) + " serves the request of " + JTRC_queue.remove());
        }
        else if(serveorgName.getOrgName().equalsIgnoreCase("jwsa")){
            System.out.println(serveorgName.getOrgName().toUpperCase(Locale.ROOT) + " serves the request of " + JWSA_queue.remove());
        }
    }
}
