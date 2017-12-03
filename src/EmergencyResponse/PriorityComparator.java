package EmergencyResponse;

import java.util.Comparator;

public class PriorityComparator implements Comparator<Session>{

	@Override
	public int compare(Session o1, Session o2) {
		
		Long k = o2.getEr().getPriority(),
				x = o1.getEr().getPriority();
		
		return k.compareTo(x);
	}

}
