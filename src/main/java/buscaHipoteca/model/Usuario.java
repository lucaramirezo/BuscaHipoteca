<<<<<<< HEAD
package buscaHipoteca.model;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;    
    private String name;
    private String pass;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
=======
package buscaHipoteca.model;

public class Usuario {
    private String name;

    public Usuario(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
>>>>>>> 4787f1bafb9d970f685025c027e057187e45223a
