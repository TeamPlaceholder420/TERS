package EmergencyResponse;

import java.util.Date;

public class ERequest {
	
	Date date;
	Emergency e;
	SessionManagementCenter smc;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Emergency getE() {
		return e;
	}

	public void setE(Emergency e) {
		this.e = e;
	}

	public long getPriority() {
		return priority;
	}

	public void setPriority(long priority) {
		this.priority = priority;
	}

	long priority;
	
	
	public ERequest(SessionManagementCenter smc, Emergency e) {
		super();
		this.date = new Date();
		this.e = e;
		this.smc = smc;
		this.priority = CalcPriority();
		
		smc.insert_session(new Session(this));
	}
	
	private long CalcPriority(){
		
		//using a new date to calculate the instantaneous delay
		priority = (new Date().getTime() - e.date.getTime()); //how late is the response made
		priority += (e.type.ordinal() + 1) * e.no_of_involved;
		
		return priority;
	}
	
}
