package hospital;

/**
 *
 * @author Henry Arend
 */
public class Queue {
    private Node head = null;
    private Node tail = null;

    private class Node {
        private Patient newbie;
        private Node nextNode;
        
        public Node(Patient newbie) {
            this.newbie = newbie;
        }
    }
    
    public void enqueue(Patient newPatient){
        Node thisPatient = new Node(newPatient);
        if(isEmpty()){
            head = thisPatient;
        }
        else{
        tail.nextNode = thisPatient;
        }
        tail = thisPatient;
        
        //TreatmentRoom room = new TreatmentRoom();
        //room.setName(newPatient.getName());
        //room.setID(newPatient.getID());
    }
    public Patient dequeue(){
        Patient temp = head.newbie;
        head = head.nextNode;
        if(head == null){
            tail = null;
        }
        return temp;
    }
    
    public boolean isEmpty(){
        if(head == null && tail == null){
            return true;
        }
        else{
            return false;
        }
    }
    
}
