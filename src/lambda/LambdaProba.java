
package lambda;


public class LambdaProba {
    
    public static void main(String[] args) {
        //System.out.println("Vau-vau!");
        
        Program prog = new Program();
      
        Ugat ugass = () -> System.out.println("Vau-vau!");
        Fut fuss = (int i) -> System.out.println("Fut-fut!" +i+"km-t");
        
        prog.doSomething(ugass);
        prog.doSomething(fuss);

    }
    
}
