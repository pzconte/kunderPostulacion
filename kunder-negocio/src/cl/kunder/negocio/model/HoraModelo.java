package cl.kunder.negocio.model;

public class HoraModelo {
	private String data;
	private String description;
	private String code;
	
	public HoraModelo(){
		super();
	}
	
	public HoraModelo(String data, String description, String code){
		setData(data);
		setDescription(description);
		setCode(code);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
