import java.util.Date;

public class Partida {
    private Integer id;
    private Juego game;
    private Usuario user;
    private int nivelActual;
    private int puntuacionAcumulada;
    private Date fechaInicio;

    public Partida() {

    }
    public Partida(Integer ID, Juego game, Usuario user, int nivelActual, int puntuacionAcumulada, Date fechaInicio) {
        this.id = ID;
        this.game = game;
        this.user = user;
        this.nivelActual = nivelActual;
        this.puntuacionAcumulada = puntuacionAcumulada;
        this.fechaInicio = fechaInicio;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public Juego getGame() {
        return game;
    }

    public void setJuego(Juego game) {
        this.game = game;
    }

    public Usuario getUsuario() {
        return user;
    }

    public void setUsuario(Usuario user) {
        this.user = user;
    }

    public int getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(int nivelActual) {
        this.nivelActual = nivelActual;
    }

    public int getPuntuacionAcumulada() {
        return puntuacionAcumulada;
    }

    public void setPuntuacionAcumulada(int puntuacionAcumulada) {
        this.puntuacionAcumulada = puntuacionAcumulada;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}