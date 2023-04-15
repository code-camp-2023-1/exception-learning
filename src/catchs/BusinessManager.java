package catchs;

public class BusinessManager {
    private APIAccessor accessor;


    public BusinessManager(APIAccessor accessor) {
        this.accessor = accessor;
    }

    public void handle() {
        accessor.execute();
    }
}
