package de.ld.console;


import de.ld.AppConfig;
import de.ld.Game;
import de.ld.MessageGenerator;
import de.ld.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        log.info("Guess the Number Game");

        // create context container
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // get number generator from context

        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        //call method
        int number = numberGenerator.next();

        // log generated number
        log.info("number = {}", number);

        // get game bean from context

        Game game = context.getBean(Game.class);

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        System.out.println(messageGenerator.getMainMessage());
        System.out.println(messageGenerator.getResultMessage());


        // close context
        context.close();

    }


}
