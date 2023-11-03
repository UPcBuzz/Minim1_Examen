
import java.util.List;
import java.util.Date;

public interface GameManager {
    public void addJuego(Juego juego);
    public void crearJuego(Integer GID, String GDesc, Integer LN, Integer puntosPorNivel);

    public void iniciarPartida(String GID, String UID);

    public void getNivelActual(String UID) ;

    public void getPuntuacionActual(String UID) ;

    public void pasarNivel(String IDU, int puntosConseguidos, Date fecha) ;

    public void finalizarPartida(String UID) ;

    public List<String> usuariosPorPuntuacion(String identificadorJuego) ;

    public List<String> partidasUsuario(String identificadorUsuario) ;

    public Juego buscarJuego(String identificadorJuego);
    public Usuario buscarUsuario(String identificadorUsuario);
    public Partida buscarPartida(String usuarioId);
    public Usuario getUser(String idUser);
    public Usuario addUsuario(String idUser);
    public int getListaPartidas();
    public void clear();
}