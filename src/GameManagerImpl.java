
import org.apache.log4j.Logger;

import java.util.*;

public class GameManagerImpl implements GameManager {

    private List<Juego> gamesList;
    private HashMap<String, Usuario> usuarioHashMap;
    private List<Partida> partidasList;
    public static GameManagerImpl instance = null;
    private static final Logger logger = LogManager.getLogger(GameManagerImpl.class);

    private GameManagerImpl() {
        gamesList = new ArrayList<>();
        usuarioHashMap = new HashMap<>();
        partidasList = new ArrayList<>();
    }

    public static GameManagerImpl getInstance() {
        if (instance == null) {
            instance = new GameManagerImpl();
        }
        return instance;
    }

    public static void setInstance(GameManagerImpl instance) {
        GameManagerImpl.instance = instance;
    }

    @Override
    public void crearJuego(Integer GID, String GDesc, Integer LN, Integer puntosPorNivel) {
        for (Juego juego : gamesList) {
            if (juego.getGameID().equals(GID)) {
                logger.info("Error: ya existe un juego con ese identificador");
                return;
            }
        }
        gamesList.add(new Juego(GID, GDesc, LN, puntosPorNivel));
    }

    @Override
    public void addJuego(Juego juego) {
        gamesList.add(juego.getGameID(), juego);
        logger.info("Añadiendo juego: " + juego.getGameID() + "descripcion: " + juego.getGameDesc() + "niveles: " + juego.getLvlNum());
    }

    @Override
    public void iniciarPartida(String idJ, String idU) {
        Juego juego = buscarJuego(idJ);
        if (juego == null) {
            logger.info("No existe este juego");
            return;
        }
        Usuario usuario = buscarUsuario(idU);
        if (usuario == null) {
            logger.info("No existe este usuario");
            return;
        }
        for (Partida partida : partidasList) {
            if (partida.getUsuario().getIdUsuario().equals(idU)) {
                logger.info("Error: el usuario ya tiene una partida en curso");
                return;
            }
        }

        Partida partida = new Partida();
        partida.setPuntuacionAcumulada(50);// comença amb 50 punts
        partida.setNivelActual(1); // comença al nivell 1
        partidasList.add(partida);
        logger.info(idU + " comienza una partida en el juego " + idJ);
    }


    @Override
    public void getNivelActual(String idU) {
        Partida partida = buscarPartida(idU);
        if (partida == null) {
            logger.info("No existe la partida");
            return;
        }
        logger.info("Usuario " + idU + " en partida " + partida.getId() + " en nivel " + partida.getNivelActual());
    }

    @Override
    public void getPuntuacionActual(String UID) {
        Partida partida = buscarPartida(UID);
        if (partida == null) {
            logger.info("No existe la partida");
            return;
        }
        logger.info("Usuario " + UID + " en partida " + partida.getId() + " con los puntos " + partida.getPuntosAcumulados());
    }

    @Override
    public void pasarNivel(String idU, int puntosAcumulados, Date fechaInicio) {

        Partida partida = buscarPartida(idU);
        if (partida == null) {
            logger.info("No se encontró ninguna partida en curso");
            return;
        }


        int nivelActual = partida.getNivelActual();
        int numNiveles = partida.getGame().getLvlNum();
        int puntosAnteriores = partida.getPuntuacionAcumulada();
        int nuevosPuntos = puntosAnteriores + puntosAcumulados;


        if (nivelActual == numNiveles) {
            logger.info("El usuario ha completado todos los niveles y se han sumado 100 puntos adicionales");
            partida.setPuntuacionAcumulada(nuevosPuntos + 100);
            finalizarPartida(idU);
        } else {
            int puntosParaSiguienteNivel = partida.getGame().getPuntosPorNivel() * nivelActual;
            if (nuevosPuntos >= puntosParaSiguienteNivel) {
                int nuevosNivel = nivelActual + 1;
                partida.setNivelActual(nuevosNivel);
                partida.setPuntuacionAcumulada(nuevosPuntos);
                logger.info("El usuario ha subido al nivel " + nuevosNivel);
            } else {
                partida.setPuntuacionAcumulada(nuevosPuntos);
                logger.info("El usuario tiene " + nuevosPuntos + " puntos, faltan " + (puntosParaSiguienteNivel - nuevosPuntos) + "puntos para pasar al siguiente nivel.");
            }
        }
    }

    @Override
    public void finalizarPartida(String user) {
        Partida partida = buscarPartida(user);
        if (partida == null) {
            logger.info("No se encontró una partida en curso para el usuario especificado");
            return;
        }
        Usuario usuario = partida.getUsuario();
        Juego juego = partida.getGame();
        int puntuacionActual = partida.getPuntuacionAcumulada();
        partidasList.remove(partida);
        logger.info("Partida finalizada para el usuario " + user + "con la siguiente puntuacion: " + puntuacionActual);
    }

    @Override
    public List<String> usuariosPorPuntuacion(String identificadorJuego) throws Exception {
        logger.info("Consultando usuarios por puntuación para el juego: {}", identificadorJuego);

        return null;
    }

    @Override
    public List<String> partidasUsuario(String identificadorUsuario) throws Exception {
        logger.info("Consultando partidas del usuario: {}", identificadorUsuario);

        return null;
    }
    public void clear(){
        partidasList.clear();
        usuarioHashMap.clear();
        gamesList.clear();
    }
}
