package EmergencyResponse;

import java.util.ArrayList;
//import java.util.Vector;

public class Session {
	
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
	
	

}
