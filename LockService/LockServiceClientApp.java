package LockService;

public class LockServiceClientApp {
	  
    static final int DEFAULT_PORT = 1717;
    
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName(args[0]);

        LockServiceClient client = new LockServiceClient(address, DEFAULT_PORT,
                LockService.LockService,
                LockService.LockServiceVERS,
                IpProtocolType.TCP);
        System.out.println("Length of " + args[1] + " = " + client.tryAcquire_1(args[1]));
        client.shutdown();
    }
	
}
