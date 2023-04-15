package catchs;

public class ServiceBGateway {
    private ServiceCGateway gateway;

    public ServiceBGateway(ServiceCGateway gateway) {
        this.gateway = gateway;
    }

    public void doExecute() {
        System.out.println("Calling ServiceBGateway:doExecute");
        gateway.doExecute();
    }
}
