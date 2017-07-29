import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;


/**
 * Created by antip on 25.07.2017.
 */
public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {


        System.out.println("Начало игры");
        log.info("Начало игры");



            Race team1;
            Race team2;


            int rand1 = (int) (Math.random()*2);
            if (rand1==1) team1 = new Race(Race_name.Эльфы);
            else team1=new Race(Race_name.Люди);

            int rand2 = (int) (Math.random()*2);
            if (rand2==1) team2 = new Race(Race_name.Орки);
            else team2=new Race(Race_name.Нежить);

            System.out.println(team1.name.toString());
            System.out.println(team2.name.toString());


            boolean endOfGame = false;
            int move=1;
            while(!endOfGame){
                System.out.println("Ход "+move);
                log.info("Ход "+move);
                move++;
                System.out.println();



            Random random = new Random();


            if (random.nextBoolean()) {

                endOfGame = team1.attackOppnent(team2);
                System.out.println();
                System.out.println(team1.liveReport());
                log.info(team1.liveReport());
                System.out.println();
                System.out.println(team2.liveReport());
                log.info(team2.liveReport());
            if (endOfGame) {System.out.println("Команда "+team1.name+" победила");
            log.info("Команда "+team1.name+" победила");}}


            else {

                endOfGame = team2.attackOppnent(team1) ;
                System.out.println();
                System.out.println(team2.liveReport());
                log.info(team2.liveReport());
                System.out.println();
                System.out.println(team1.liveReport());
                log.info(team1.liveReport());
            if (endOfGame) {
                System.out.println("Команда "+team2.name+" победила");
            log.info("Команда "+team2.name+" победила");}}




            }




        System.out.println("Конец игры");
        log.info("Конец игры");

    }

    }



