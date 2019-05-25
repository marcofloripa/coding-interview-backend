package br.com.odaguiri.codinginterview.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="problem")
public class Problem implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column
	private String title;
	
	@Column
	private String description;

	public Problem(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	
	protected Problem() {}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
	
}
