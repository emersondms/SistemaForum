package model;

public class Comentario {
    
    private int id;
    private String comentario;
    private String login;
    private int idTopico;

    public Comentario() {}

    public Comentario(int id, String comentario, String login, int idTopico) {
        this.id = id;
        this.comentario = comentario;
        this.login = login;
        this.idTopico = idTopico;
    }
    
    public Comentario(String comentario, String login, int idTopico) {
        this.comentario = comentario;
        this.login = login;
        this.idTopico = idTopico;
    }
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getIdTopico() {
        return idTopico;
    }

    public void setIdTopico(int idTopico) {
        this.idTopico = idTopico;
    }
}
