package catchs;

public class ServiceCGateway {
    public void doExecute() {
        System.out.println("Calling ServiceCGateway:doExecute");
        throw new RuntimeException("exception from ServiceCGateway:doExecute");
    }
}
