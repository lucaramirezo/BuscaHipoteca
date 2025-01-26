package buscaHipoteca;

//import buscaHipoteca.app.App;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import buscaHipoteca.app.App;

@SpringBootApplication
public class Main {    

    public static void main(String[] args) {
    	SpringApplication.run(Main.class, args);
        System.setProperty("logging.level.org.springframework.web", "DEBUG");
        App.main(args);
       // System.out.println("Prueba");
    }
}
