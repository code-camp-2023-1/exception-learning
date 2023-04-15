package catchs;

import java.util.logging.Logger;

public class APIAccessor {
    Logger logger = Logger.getLogger("API-Accessor");
    private ServiceAGateway gateway;

    public APIAccessor(ServiceAGateway gateway) {
        this.gateway = gateway;
    }

    public void execute() {
        try {
            gateway.doExecute();
        } catch (RuntimeException ex) {
            logger.info("Execute error" + ex);
        }
    }
}
