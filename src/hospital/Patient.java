package hospital;

/**
 *
 * @author Henry Arend
 */
public class Patient {
    String name;
    String SSN;
    String DOB;
    String hospitalID;
    String priority;
    
    Patient(String Name, String SSN, String DOB, String hospitalID, String priority){
        this.name = Name;
        this.SSN = SSN;
        this.DOB = DOB;
        this.hospitalID = hospitalID;
        this.priority = priority;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSSN(){
        return SSN;
    }
    
    public String getDOB(){
        return DOB;
    }
    public String getID(){
        return hospitalID;
    }
}
