import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by antip on 25.07.2017.
 */
public class Magician extends Person {

    int const_attack_value;
    double attack_value;
    String attack_name;

    Magician( Race race_team){


        if (race_team.name== Race_name.Эльфы) {name="маг"; attack_name=" нанесение урона магией ";}
        else if  (race_team.name== Race_name.Люди) {name="маг"; attack_name=" атаковать магией ";}
        else if  (race_team.name== Race_name.Орки) {name="шаман"; attack_name=" наложение проклятия ";}
        else   {name="некромант"; attack_name=" атака ";}


        race=race_team;

        if (race_team.name== Race_name.Эльфы) const_attack_value =10;
        else  if (race_team.name== Race_name.Люди) const_attack_value =4;
        else  if (race_team.name== Race_name.Нежить) const_attack_value =5;

        attack_value=const_attack_value;}

    public String action(Person person){

        Random random = new Random();
        if (random.nextBoolean()){

            return help(person);
           }
        else {

            return attack(person);
            }
    }

    public String help(Person person){

        if (race.name== Race_name.Эльфы ||race.name== Race_name.Люди ||race.name== Race_name.Орки)
        {
            boolean anybodyAlive=false;
            for (int count=1;count<8;count++){
                if (this.race.persons[count].health>0 ) {anybodyAlive=true;break;}
            }
            if (anybodyAlive){
            while (true) {
            Person person1;
            int index = (int) (Math.random()*7+1);
                person1=this.race.persons[index];
                if (person1.health>0) {
                    person1.privileged=true;


                    String result = this.race.name+" "+name+" наложить улучшение "+ person1.race.name+" "+person1.name;
                    return result;}
        }}
        else {String result = this.race.name+" "+name+" наложить улучшение - нет никого в живых ";
            return result;}
        }

        else {person.sick=true;
            String result = this.race.name+" "+name+" наслать недуг "+ person.race.name+" "+person.name;
        return result;}
    }



    public String attack(Person person){

        String priv="";
        if (this.privileged) priv=" привилегирован ";
        if (this.sick) priv+=" болен ";

        if (race.name== Race_name.Орки){
            ArrayList<Person> previligList=new ArrayList<>();

            for (Person person1:person.race.persons){
                if (person1.privileged) previligList.add(person1);
            }

            Collections.shuffle(previligList);

            if (!previligList.isEmpty()){
                Person attackPerson = previligList.get(0);
                attackPerson.privileged=false;
                String result = this.race.name+" "+name+priv+attack_name+ attackPerson.race.name+" "+attackPerson.name;
                return result;
            }
            else  {String result = this.race.name+" "+name+" наложить проклятие - все непривилегированные  ";
            return result;}


        }
        else {
            if (this.privileged)attack_value*=1.5;
            if (this.sick) attack_value/=2;

            person.health=person.health- attack_value;

            String result = this.race.name+" "+name+attack_name+attack_value+" hp "+ person.race.name+" "+person.name;
            attack_value=const_attack_value;
            return result;
        }
       }
    }

