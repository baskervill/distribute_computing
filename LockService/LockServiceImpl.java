package LockService;

public class LockServiceImpl extends LockServiceServerStub{
	/*
	   public int strlen_1(RpcCall call$, String arg) {
	       return arg.length();
	   }
	   */
	@Override
	public void lock() {
		Thread currentThread = Thread.currentThread();
		if(headThread == currentThread){
			return ;
		}
		try{
		for(;;){
			if(compareAndSetHeadThread(null, currentThread)){
				while(!tryAcquire()){
					LockSupport.parkNanos(timepart());
					Thread.interrupted();
						}
					return ;
				}else{
					waitingQueue.add(currentThread);
					LockSupport.park();
					while(Thread.interrupted()){
						LockSupport.park();
					}
				}
			}
		}catch(RuntimeException ex){
			cancelAcquire();
			throw ex;
		}
	}
}
