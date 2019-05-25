package br.com.odaguiri.codinginterview.web.dto;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.ResourceSupport;

public class ProblemDto extends ResourceSupport {
	
	private Integer idProblem;
	
	@NotNull
	private String title;
	
	@NotNull
	private String description;
	
	public ProblemDto(Integer idProblem, String title, String description) {
		super();
		this.idProblem = idProblem;
		this.title = title;
		this.description = description;
	}

	protected ProblemDto() {}

	public Integer getIdProblem() {
		return idProblem;
	}

	public void setIdProblem(Integer idProblem) {
		this.idProblem = idProblem;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
