<<<<<<< HEAD
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
=======
package buscaHipoteca;

import buscaHipoteca.app.App;

public class Main {    

    public static void main(String[] args) {
        App.main(args);
        System.out.println("Prueba");
    }
}
>>>>>>> 4787f1bafb9d970f685025c027e057187e45223a
