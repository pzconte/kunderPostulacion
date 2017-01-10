package cl.kunder.negocio.servicio;

import javax.ejb.Stateless;

import cl.kunder.negocio.model.WordModelo;

import javax.inject.Named;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;

@Stateless
@Named(PalabraNegocio.NAME)

public class PalabraNegocio {
	public static final String NAME = "PalabraNegocio";
	
	public PalabraNegocio(){
		super();
	}
	
	public WordModelo mayusculasLargoCuatro(WordModelo wordModelo){
		String palabra = wordModelo.getData();	
		try{
			if(palabra.trim().length() == 4){
				wordModelo.setData(palabra.toUpperCase());
				wordModelo.setCode("00");
				wordModelo.setDescription("OK");
			}
			else{
				throw new BadRequestException("La palabra debe tener largo 4");
			}
		} catch(Exception ex){
			throw new InternalServerErrorException("Error interno del servidor");
		}
		return wordModelo;		
	}

}
