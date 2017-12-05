package EmergencyResponse;

import java.util.ArrayList;
//import java.util.Vector;
import java.util.Date;

public class Session {
	
	Date session_initial_date;
	static int TOTAL_NO_SESSIONS = 0;
	int session_ID;
	ERequest er;
	int session_priority;
	//Vector<EmergencyService> servicesVector;
	ArrayList<EmergencyService> servicesArray;

	
	
	public ERequest getEr() {
		return er;
	}
	
	public Session(ERequest er) {
		super();
		session_initial_date = new Date();
		this.er = er;
		session_ID = TOTAL_NO_SESSIONS++;
		session_priority = (int)er.priority;
		servicesArray = new ArrayList<EmergencyService>();
	}
	
	public void addEmergencyService(EmergencyService es){
		//servicesVector.add(es);
		servicesArray.add(es);
	}
	
	public void rmEmergencyService(int id_toremove){
		
		/*
		int i;
		for( i=0; i<servicesVector.size(); i++){
			if(servicesVector.elementAt(i).getId() ==  id_toremove)
				break;
		}
		*/
		
		
		int i;
		for( i=0; i<servicesArray.size(); i++){
			if(servicesArray.get(i).getId() ==  id_toremove)
				break;
		}
		
		//servicesVector.remove(i);
		servicesArray.remove(i);
	}
	
	public void rmEmergencyService(EmergencyService es){
				
		//servicesVector.remove(es);
		servicesArray.remove(es);
	}

	public ArrayList<EmergencyService> getServicesArray() {
		return servicesArray;
	}

	public void setServicesArray(ArrayList<EmergencyService> servicesArray) {
		this.servicesArray = servicesArray;
	}
	
	public int ReCalcPriority(){
		
		//using a new date to calculate the instantaneous delay
		session_priority += (new Date().getTime() - session_initial_date.getTime()); //how increase the priority depending on the wait time
		
		return session_priority;
	}
	

}
