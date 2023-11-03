import java.util.StringTokenizer;

public class Juego {
    private Integer GameID;
    private String GameDesc;
    private Integer LvlNum;
    private Integer puntosPorNivel;

    public Juego(Integer GID, String GDesc, Integer LN, Integer puntosPorNivel) {
        this.GameID = GID;
        this.GameDesc = GDesc;
        this.LvlNum = LN;
        this.puntosPorNivel = puntosPorNivel;
    }

    public Juego(){

    }

    // Getters y setters
    public Integer getGameID() {
        return GameID;
    }

    public void setGameID(Integer GameID) {
        this.GameID = GameID;
    }

    public String getGameDesc() {
        return GameDesc;
    }

    public void setDescription(String description) {
        this.GameDesc = description;
    }

    public int getLvlNum() {
        return LvlNum;
    }

    public void setLvlNum(int LN) {
        this.LvlNum = LN;
    }

    public Integer getPuntosPorNivel() {
        return puntosPorNivel;
    }
}
