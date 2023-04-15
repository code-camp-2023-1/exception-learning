package catchs;

public class ServiceAGateway {
    private ServiceBGateway gateway;

    public ServiceAGateway(ServiceBGateway gateway) {
        this.gateway = gateway;
    }
    public void doExecute() {
        System.out.println("Calling ServiceAGateway:doExecute");

        gateway.doExecute();
    }
}
