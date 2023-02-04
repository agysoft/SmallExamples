package lambda;

public class Program {
    public void doSomething(Ugat a){
        System.out.println("Ugat:");
        a.ugass();
        //a.fuss();
    }
    
    public void doSomething(Fut a){
        System.out.println("Fut:");
        //a.ugass();
        a.fuss(10);
    }
}
