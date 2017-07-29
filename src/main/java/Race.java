import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by antip on 25.07.2017.
 */
public class Race {
    private static final Logger log = Logger.getLogger(Race.class);

    Race_name name;
    Person[]persons=new Person[8];

    public Race(Race_name race_name){

            name=race_name;
            this.persons[0]=new Magician(this);
            this.persons[1]=new Archer(1,this);
            this.persons[2]=new Archer(2,this);
            this.persons[3]=new Archer(3,this);
            this.persons[4]=new Warrior(1,this);
            this.persons[5]=new Warrior(2,this);
            this.persons[6]=new Warrior(3,this);
            this.persons[7]=new Warrior(4,this);

            for (Person person:persons){
                person.race=this; }

    }


    public Person getRandomOpponent(Race race){

        while (true){
        int index = (int) (Math.random()*8);
        if (race.persons[index].health>0) {
            return race.persons[index];}
    }}

    public int checkAlive(){

        int count = 0;
        for (Person person : persons){if (person.health>0) count++;}
        return count;
    }

    public boolean attackOppnent(Race race){

        System.out.println(this.name+" атакуют\n");
        log.info(this.name+" атакуют");


        ArrayList<Person> normalList=new ArrayList<>();
        ArrayList<Person> previligList=new ArrayList<>();

        for (Person person:persons){
            if (person.privileged) previligList.add(person);
            else normalList.add(person);
        }

        Collections.shuffle(normalList);
        Collections.shuffle(previligList);



        Iterator<Person> iterPriv = previligList.iterator();
        while(iterPriv.hasNext()) {
            Person person = iterPriv.next();
            if (person.health>0){
                Person opp=getRandomOpponent(race);
                String action=person.action(opp);
                System.out.println(action);
                log.info(action);
                person.privileged=false;
                person.sick=false;
                if (race.checkAlive()==0) {return true;}}
        }

        Iterator<Person> iterNorm = normalList.iterator();
        while(iterNorm.hasNext()) {
            Person person = iterNorm.next();
            if (person.health>0){
                Person opp=getRandomOpponent(race);
                String action=person.action(opp);
                System.out.println(action);
                log.info(action);
                person.privileged=false;
                person.sick=false;
                if (race.checkAlive()==0) {return true;}}
        }


       /* for (Person person : persons){
            if (person.health>0){
                Person opp=getRandomOpponent(race);
                String action=person.action(opp);
                System.out.println(action);
                person.privileged=false;
                person.sick=false;
                if (race.checkAlive()==0) {return true;}}
        }*/
        return false;
    }

    public String liveReport(){

        String result="Команда "+this.name+":\t\n";

        for (Person person:persons){if (person.health>0)
        {
            String priv="";
            String sick="";
            if (person.sick) sick="больной";
            if (person.privileged) priv="привилегирован";
            result+=person.race.name+" "+person.name+" "+person.health+" hp "+ priv+" "+sick+"\t\n";
        }
            else result+=person.race.name+" "+person.name+" "+person.health+ " hp мертв "+"\t\n";
        }
        return result;
    }

}
