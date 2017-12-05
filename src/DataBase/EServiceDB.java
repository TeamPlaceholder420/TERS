package DataBase;

import DataBase.OracleJDBCConnection;

//class acts as a facade for all of the databases
public class EServiceDB {
	Police_DB pdb;
	Medical_DB mdb;
	FireDept_DB fdb;
		
	public EServiceDB() {
		super();
		this.pdb = new Police_DB();
		this.mdb = new Medical_DB();
		this.fdb = new FireDept_DB();
	}

	public void getp(int amount, double x, double y){
		for(int i=0; i<amount; i++)
			pdb.register(x, y);
	}
	
	public void returnp(int amount, int id, double new_x, double new_y){
		for(int i=0; i<amount; i++)
			pdb.unregister(id, new_x, new_y);
	}
	
	
	public void getm(int amount, double x, double y){
		for(int i=0; i<amount; i++)
			mdb.register(x, y);
	}
	
	public void returnm(int amount, int id, double new_x, double new_y){
		for(int i=0; i<amount; i++)
			mdb.unregister(id, new_x, new_y);
	}
	
	public void getf(int amount, double x, double y){
		for(int i=0; i<amount; i++)
			fdb.register(x, y);
	}
	
	public void returnf(int amount, int id, double new_x, double new_y){
		for(int i=0; i<amount; i++)
			fdb.unregister(id, new_x, new_y);
	}
}
