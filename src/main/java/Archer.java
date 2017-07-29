import java.util.Random;

/**
 * Created by antip on 25.07.2017.
 */
public class Archer extends Person {

    int const_attack_value;
    double attack_value;
    int const_shoot_value;
    double shoot_value;
    String attack_name;
    String shoot_name;

    Archer(int i, Race race_team){
        if (race_team.name==Race_name.Эльфы) {name="лучник"; shoot_name = " стрелять из лука "; attack_name=" атаковать ";}
        else if  (race_team.name==Race_name.Люди) {name="арбалетчик"; shoot_name = " стрелять из арбалета "; attack_name=" атаковать ";}
        else if  (race_team.name==Race_name.Орки) {name="лучник"; shoot_name = " стрелять из лука "; attack_name=" удар клинком ";}
        else { name="охотник"; shoot_name = " стрелять из лука "; attack_name=" атаковать ";}

        name+=i;

        race=race_team;
        if (race_team.name==Race_name.Эльфы) {
            const_shoot_value =7; const_attack_value =3;}
        else  if (race_team.name==Race_name.Люди) {
            const_shoot_value =5;
            const_attack_value =3;}
        else  if (race_team.name==Race_name.Орки) {
            const_shoot_value =3;
            const_attack_value =2;}
        else  if (race_team.name==Race_name.Нежить) {
            const_shoot_value =4;
            const_attack_value =2;}

            attack_value=const_attack_value;
            shoot_value=const_shoot_value;
    }


    public String action(Person person){

        Random random = new Random();
        if (random.nextBoolean()){

            return shoot(person);
          }
        else {

            return attack(person);
            }
    }


    public String shoot(Person person){
        String priv="";
        if (this.privileged) priv=" привилегирован ";
        if (this.sick) priv+=" болен ";


        if (this.privileged)shoot_value*=1.5;
        if (this.sick) shoot_value/=2;

        person.health=person.health- shoot_value;

        String result = this.race.name+" "+name+priv+shoot_name+shoot_value+" hp "+ person.race.name+" "+person.name;

        shoot_value=const_shoot_value;

        return result;
}
    public String attack(Person person){
        String priv="";
        if (this.privileged) priv=" привилегирован ";
        if (this.sick) priv+=" болен ";


        if (this.privileged)attack_value*=1.5;
        if (this.sick) attack_value/=2;

        person.health=person.health- attack_value;

        String result = this.race.name+" "+name+priv+attack_name+attack_value+" hp "+ person.race.name+" "+person.name;
        attack_value=const_attack_value;
        return  result;
    }
}
