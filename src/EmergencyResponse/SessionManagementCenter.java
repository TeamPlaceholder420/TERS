package EmergencyResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import DataBase.EServiceDB;

public class SessionManagementCenter {
	
	List<Session> l;
	Hashtable<Session, Resource> ht;
	PriorityComparator c;
	EServiceDB esdb;
	int session_NOT_served_counter;
	
	
	public SessionManagementCenter(EServiceDB esdb) {
		super();
		this.esdb = new EServiceDB();
		this.c = new PriorityComparator();
		this.l = new ArrayList<Session>();
		//this.r = new ArrayList<Resource>();
		this.ht = new Hashtable<Session, Resource>();
		session_NOT_served_counter = 0;
		
		Runnable R2 = new Runnable()
		{
			public void run() {
				
				while(true)
					if(session_NOT_served_counter>0){
						serve(l.get(0));
					}
			}
			
		};
		
		new Thread(R2, "SMC").start();
	}

	public void insert_session(Session s){
		l.add(s);
		session_NOT_served_counter++;
		Collections.sort(l, c);
		
	}
	
	public void remove_session(Session s){
		l.remove(s);
		
		Resource r = ht.get(s);
		
		ArrayList<EmergencyService> esArray = s.getServicesArray();
		
		for(int i = 0; i< esArray.size(); i++){
			if(esArray.get(i).getVtype().getClass().getName() == new Police_Car(0.0, 0.0).getClass().getName())
				esdb.returnp(r.getP(), esArray.get(i).getId(), 0.0, 0.0);
			else if(esArray.get(i).getVtype().getClass().getName() == new Ambulance(0.0, 0.0).getClass().getName())
				esdb.returnm(r.getP(), esArray.get(i).getId(), 0.0, 0.0);
			else if(esArray.get(i).getVtype().getClass().getName() == new Fire_Truck(0.0, 0.0).getClass().getName())
				esdb.returnf(r.getP(), esArray.get(i).getId(), 0.0, 0.0);
		}
		
		ht.remove(s); //remove from the hashmap
		
		Collections.sort(l, c);
		
	}
	
	public synchronized void serve(Session s){
		Type t = s.getEr().getE().getType();
		int inv = s.getEr().getE().getNo_of_involved();
		
		int pneed = 0, fneed = 0, aneed = 0;
		
		switch(t){
			case Theft:
				pneed = 1;
				break;
			case Traffic_Accident:
				pneed = 1;
				aneed = 1;
				break;
			case Fire:
				aneed = 3;
				pneed = 1;
				fneed = 3;
				break;
			case Medical_Emergency:
				aneed = 1;
				break;
			default:
				//do nothing
		}
		
		//multiplied needed service based on the amount of involved parties
		pneed *= inv;
		aneed *= inv;
		fneed *= inv;
		
		ht.put(s, new Resource(pneed, fneed, aneed));
		
		
		esdb.getp(pneed, s.getEr().getE().getX(), s.getEr().getE().getY());
		esdb.getf(fneed, s.getEr().getE().getX(), s.getEr().getE().getY());
		esdb.getm(aneed, s.getEr().getE().getX(), s.getEr().getE().getY());
		

		//to remove from its high priority location
		s.getEr().setPriority((long)0);
		
		//sort again based on priority
		Collections.sort(this.l, this.c);
		
		//session is served
		session_NOT_served_counter--;
		
	}

}
