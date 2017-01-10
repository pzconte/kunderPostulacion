package cl.kunder.web.api;

import javax.ws.rs.core.Response;

public class BaseServicio {
	
	public BaseServicio(){
		super();
	}
	
	public Response construirRespuesta(final Respuesta<?> respuesta){
		return Response.ok(respuesta).
				header("Cache-Control", "no-cache").
				header("Pragma","no-cache").
				header("Expires", 0).
				build();
	}

}
