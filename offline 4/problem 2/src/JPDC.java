import java.util.PriorityQueue;
import java.util.Queue;

public class JPDC extends ServiceOrganization {
    private String orgName;
    private String serviceName;
    private Mediator mediator;
    private Queue<String> serviceQueue = new PriorityQueue<String>();

    public JPDC(Mediator mediator){
        this.mediator = mediator;
    }

    @Override
    public void RequestService() {
        mediator.RequestService(this);
    }

    @Override
    public void ProvideService(){
        mediator.ProvideService(this);
    }

    @Override
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String getOrgName() {
        return this.orgName;
    }

    @Override
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String getServiceName() {
        return this.serviceName;
    }

}
