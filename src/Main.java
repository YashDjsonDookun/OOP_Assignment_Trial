package src;
public class Main{
	public static void main(String[] args){
		ConnectDatabase Db = new ConnectDatabase();
		Db.DB_Connect();
		Patient patient = new Patient();
		patient.RegisterPatient();
	}
}
