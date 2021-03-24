public class Main{
	public static void main(String[] args){
		Patient patient;
		patient = Patient.RegisterPatient();
		patient.PatientSummary(patient);
	}
}
