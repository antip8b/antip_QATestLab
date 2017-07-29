/**
 * Created by antip on 25.07.2017.
 */
public class Warrior extends Person {

    int const_attack_value;
    double attack_value;
    String attack_name;

    Warrior(int i, Race race_team)
    {
        if (race_team.name== Race_name.Эльфы) {name="воин"; attack_name=" атаковать мечом ";}
        else if  (race_team.name== Race_name.Люди) {name="воин"; attack_name=" атаковать мечем ";}
        else if  (race_team.name== Race_name.Орки) {name="гоблин"; attack_name=" атака дубиной ";}
        else  {name="зомби"; attack_name=" удар копьем ";}

        name+=i;

    race=race_team;
    if (race_team.name== Race_name.Эльфы) const_attack_value =15;
    else  if (race_team.name== Race_name.Люди) const_attack_value =18;
    else  if (race_team.name== Race_name.Орки) const_attack_value =20;
    else   const_attack_value =18;

    attack_value=const_attack_value;
    }



    public String action(Person person){
        String priv="";
        if (this.privileged) priv=" привилегирован ";
        if (this.sick) priv+=" болен ";

        if (this.privileged)attack_value*=1.5;
        if (this.sick) attack_value/=2;

        person.health=person.health- attack_value;



        String result = this.race.name+" "+name+priv+attack_name+attack_value+" hp "+ person.race.name+" "+person.name;
        attack_value=const_attack_value;
        return result;
    }


}
