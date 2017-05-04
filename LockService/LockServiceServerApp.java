package LockService;

public class LockServiceServerApp {
    static final int DEFAULT_PORT = 1717;

    public static void main(String[] args) throws Exception {

        OncRpcSvc service = new OncRpcSvcBuilder()
                .withTCP()
                .withAutoPublish()
                .withPort(DEFAULT_PORT)
                .withSameThreadIoStrategy()
                .withRpcService(new OncRpcProgram(LockService.LockService, LockService.LockServiceVERS), new LockServiceImpl())
                .build();
        service.start();
        System.in.read();
    }
}
