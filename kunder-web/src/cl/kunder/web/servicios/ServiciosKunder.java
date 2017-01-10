package cl.kunder.web.servicios;

import javax.ws.rs.core.Response;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cl.kunder.negocio.model.HoraModelo;
import cl.kunder.negocio.model.WordModelo;
import cl.kunder.negocio.servicio.HoraNegocio;
import cl.kunder.negocio.servicio.PalabraNegocio;
import cl.kunder.web.api.Respuesta;
import cl.kunder.web.api.BaseServicio;

@RequestScoped
@Named(ServiciosKunder.NAME)

public class ServiciosKunder extends BaseServicio implements IServiciosKunder {

	public static final String NAME = "ServiciosKunder";
	
	@Inject
	private PalabraNegocio palabraNegocio;
	@Inject
	private HoraNegocio horaNegocio;

	@Override
	public Response mayusculasLargoCuatro(WordModelo wordModelo) {
		final Respuesta<WordModelo> respuesta = new Respuesta<WordModelo>(true);
		respuesta.setTotal(1L);
		respuesta.setData(palabraNegocio.mayusculasLargoCuatro(wordModelo));	
		return construirRespuesta(respuesta);
	}

	@Override
	public Response horaUTCISODATE(String hora) {
		final Respuesta<HoraModelo> respuesta = new Respuesta<HoraModelo>(true);
		respuesta.setTotal(1L);
		respuesta.setData(horaNegocio.horaUTCISODATE(hora));
		return construirRespuesta(respuesta);
	}
}
