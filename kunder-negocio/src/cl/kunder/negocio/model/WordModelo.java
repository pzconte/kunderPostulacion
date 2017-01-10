package cl.kunder.negocio.model;

public class WordModelo {
	private String data;
	private String code;
	private String description;
	
	public WordModelo(){
		super();
	}
	
	public WordModelo(String data, String code, String descripcion){
		setData(data);
		setCode(code);
		setDescription(descripcion);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
