package br.com.marcos.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.marcos.domain.enuns.Prioridade;
import br.com.marcos.domain.enuns.Status;

@Entity
public class OS {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy Hh:mm")
	private LocalDate dataAbertura;
	
	@JsonFormat(pattern = "dd/MM/yyyy Hh:mm")
	private LocalDate dataFechamento;
	private Integer prioridade;
	private String observacao;
	private Integer status;

	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public OS() {
		super();
		this.setDataAbertura(LocalDate.now());
		this.setPrioridade(Prioridade.BAIXA);
		this.setStatus(Status.ABERTO);
	}

	public OS(Integer id, Prioridade prioridade, String observacao, 
			Status status, Tecnico tecnico, Cliente cliente) {
		super();
		this.id = id;
		this.setDataAbertura(LocalDate.now());
		this.prioridade = (prioridade == null) ? 0 : prioridade.getCod();
		this.observacao = observacao;
		this.status = (status == null) ? 0 : status.getCod();
		this.tecnico = tecnico;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDate getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Prioridade getPrioridade() {
		return Prioridade.toEnun(this.prioridade);
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade.getCod();
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Status getStatus() {
		return Status.toEnun(this.status);
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OS other = (OS) obj;
		return Objects.equals(id, other.id);
	}

}
