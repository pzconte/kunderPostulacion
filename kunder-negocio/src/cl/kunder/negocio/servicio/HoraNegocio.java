package cl.kunder.negocio.servicio;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.Stateless;

import cl.kunder.negocio.model.HoraModelo;
import cl.kunder.negocio.model.WordModelo;

import javax.inject.Named;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;

@Stateless
@Named(HoraNegocio.NAME)

public class HoraNegocio {
	public static final String NAME = "HoraNegocio";
	
	public HoraNegocio(){
		super();
	}
	
	public HoraModelo horaUTCISODATE(String hora){
		try{
			String horaSolicitada = hora.trim();
			if(horaSolicitada.length()!=8){
				throw new BadRequestException("El formato solicitado es hh:mm:ss");
			}
			for(int i=0; i<horaSolicitada.length();i++){
				String valorActual = horaSolicitada.substring(i, i+1);
				if(i==0){
					valorActual = horaSolicitada.substring(i, i+2);
					validarHora(valorActual);
				}
				else if(i==2 || i==5){
					if(valorActual != ":"){
						throw new BadRequestException("El formato solicitado es hh:mm:ss");
					}
				}
				else if(i==3 || i==6){
					valorActual = horaSolicitada.substring(i, i+2);
					validarMinutoSegundo(valorActual);
				}
			}
			/*si se llega a esta línea el formato está correcto*/
			int horaActual = Integer.parseInt(horaSolicitada.substring(0,2));
			int minutoActual = Integer.parseInt(horaSolicitada.substring(3,5));
			int segundoActual = Integer.parseInt(horaSolicitada.substring(6,8));
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, Calendar.DATE, Calendar.DAY_OF_WEEK_IN_MONTH, horaActual, minutoActual, segundoActual);
			String year = Integer.toString(calendar.get(Calendar.YEAR));
			String mes = Integer.toString(calendar.get((Calendar.MONTH)+1));
			String dia = Integer.toString(calendar.get((Calendar.DAY_OF_WEEK_IN_MONTH)));
			String horaString = Integer.toString(horaActual);
			String minuto = Integer.toString(minutoActual);
			String segundo = Integer.toString(segundoActual);
			String milisegundos = "00";
			String tzd = ZonedDateTime.now().toString();		
			String horaFormatoUTCISODATE = year+"-"+mes+"-"+dia+"T"+horaString+":"+minuto+":"+segundo+":"+milisegundos+"+"+tzd;
			HoraModelo horaModelo = new HoraModelo("00", "OK", horaFormatoUTCISODATE);
			return horaModelo;
			
		} catch (Exception ex){
			throw new InternalServerErrorException("Error interno del servidor");
		}
	}
	
	/*Valida hora, puede estar entre 0 y 23*/
	private int validarHora(String valorActual){
		try{
			int valor = Integer.parseInt(valorActual);	
			if(valor >=0 && valor <=23){
				return valor;
			}
			else{
				throw new BadRequestException("El formato solicitado es hh:mm:ss");
			}
		}
		catch(Exception ex){
			throw new BadRequestException("El formato solicitado es hh:mm:ss");
		}
	}
	
	
	/*Valida minuto y segundo que pueden estar entre 0 y 59*/
	private int validarMinutoSegundo(String valorActual){
		try{
			int valor = Integer.parseInt(valorActual);
			if(valor >=0 && valor <=59){
				return valor;
			}
			else{
				throw new BadRequestException("El formato solicitado es hh:mm:ss");
			}
		}
		catch(Exception ex){
			throw new BadRequestException("El formato solicitado es hh:mm:ss");
		}
	}
	
	

}
