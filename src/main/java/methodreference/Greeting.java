package methodreference;

public class Greeting {

    private String name = "";

    public Greeting(){

    }

    public Greeting(String name){
        this.name = name;
    }

    public void sayHi(){
        System.out.print("Hi " + name);
    }

    public String getName() {
        return name;
    }

    public static void sayName(String name) {
        System.out.print(name + "!!");
    }
}
