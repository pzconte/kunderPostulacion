package cl.kunder.web.api;

public class Respuesta<T> {
	private boolean success;
	private long total;
	private T data;
	private String error;
	
	public Respuesta(){
		super();
	}
	
	public Respuesta(boolean success){
		super();
		setSuccess(success);
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
}
