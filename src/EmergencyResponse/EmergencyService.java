package EmergencyResponse;

public class EmergencyService {
	
	int id;
	EVehicle vtype; //uses strategy pattern to change the routing's priority
	int deparment_no;
	
	
	public EmergencyService(int id,EVehicle vtype, int deparment_no) {
		super();
		this.id = id;
		this.vtype = vtype;
		this.deparment_no = deparment_no;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public EVehicle getVtype() {
		return vtype;
	}


	public void setVtype(EVehicle vtype) {
		this.vtype = vtype;
	}


	public int getDeparment_no() {
		return deparment_no;
	}


	public void setDeparment_no(int deparment_no) {
		this.deparment_no = deparment_no;
	}
	
	
	
	
	
	

}
