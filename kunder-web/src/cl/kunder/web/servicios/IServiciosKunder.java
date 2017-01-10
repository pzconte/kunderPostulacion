package cl.kunder.web.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cl.kunder.negocio.model.WordModelo;

@Path("/servicio")
public interface IServiciosKunder {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	@Path("/word")
	Response mayusculasLargoCuatro(WordModelo wordModelo);
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	@Path("/time?value={hora}")
	Response horaUTCISODATE(@PathParam("hora") String hora);

}
