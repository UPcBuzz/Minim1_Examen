import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/juego")
public class GameManagerService {

    private GameManagerFachada GameManagerFachada;

    public GameManagerService() {
        this.GameManagerFachada = GameManagerFachada.getInstance();
    }

    @POST
    @Path("/crear")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearJuego(JuegoDTO juegoDTO) {
        GameManagerFachada.crearJuego(juegoDTO.getIdentificador(), juegoDTO.getDescripcion(), juegoDTO.getNumeroNiveles());
        return Response.status(Response.Status.CREATED).entity(juegoDTO).build();
    }

    @POST
    @Path("/iniciarPartida")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response iniciarPartida(PartidaDTO partidaDTO) {

        return Response.status(Response.Status.OK).entity(partidaDTO).build();
    }

    @GET
    @Path("/consultaNivel/{identificadorUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarNivelActual(@PathParam("identificadorUsuario") String identificadorUsuario) {

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/consultaPuntuacion/{identificadorUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPuntuacionActual(@PathParam("identificadorUsuario") String identificadorUsuario) {

        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/pasarNivel")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response pasarNivel(PasoNivelDTO pasoNivelDTO) {

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/finalizarPartida/{identificadorUsuario}")
    public Response finalizarPartida(@PathParam("identificadorUsuario") String identificadorUsuario) {

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/usuariosPorPuntuacion/{identificadorJuego}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response usuariosPorPuntuacion(@PathParam("identificadorJuego") String identificadorJuego) {

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/partidasUsuario/{identificadorUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response partidasUsuario(@PathParam("identificadorUsuario") String identificadorUsuario) {

        return Response.status(Response.Status.OK).build();
    }
}