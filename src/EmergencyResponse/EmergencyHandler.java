package EmergencyResponse;

import java.util.PriorityQueue;
import java.util.Queue;

public class EmergencyHandler {
	
	Queue<Emergency> q;
	SessionManagementCenter smc;
	
	public EmergencyHandler(SessionManagementCenter smc){

		q = new PriorityQueue<Emergency>();
		this.smc = smc;

		Runnable R1 = new Runnable()
		{
			public void run() {
				
				while(true)
					if(!q.isEmpty())
						handel();
			}
			
		};
		
		new Thread(R1, "Emergency Handeler").start();
	}
		
	void update(Emergency e){
		//interfaced with the CRS to add emergencies to TERS' queue
		q.add(e);
	}
	
	synchronized void handel(){
		new ERequest(smc, q.remove()); //creates a new request to handle the emergency
	}
}
