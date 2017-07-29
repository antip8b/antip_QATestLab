/**
 * Created by antip on 25.07.2017.
 */
public abstract class Person {
   public double health=100;
   public boolean privileged=false;
   public String name;
   public Race race;
   public boolean sick=false;



   public abstract String action(Person person);
}