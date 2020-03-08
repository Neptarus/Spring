package Mensagem.entities;

public class ResponseModel {
	private int codigo;
	private String msg;
	
	public ResponseModel(int codigo, String msg) {
		this.codigo = codigo;
		this.msg = msg;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getmsg() {
		return msg;
	}

	public void setmsg(String msg) {
		this.msg = msg;
	}

}