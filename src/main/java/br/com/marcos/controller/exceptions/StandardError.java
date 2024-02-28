package br.com.marcos.controller.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long tiemstamp;
	private Integer status;
	private String error;

	public StandardError() {
		super();
	}

	public StandardError(Long tiemstamp, Integer status, String error) {
		super();
		this.tiemstamp = tiemstamp;
		this.status = status;
		this.error = error;
	}

	public Long getTiemstamp() {
		return tiemstamp;
	}

	public void setTiemstamp(Long tiemstamp) {
		this.tiemstamp = tiemstamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
