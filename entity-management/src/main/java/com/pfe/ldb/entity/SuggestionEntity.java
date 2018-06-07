package com.pfe.ldb.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="suggestion")
public class SuggestionEntity extends AbstractEntity {
	

	private String name;
	private String description;
	private Date suggestionDate;
	
	@ManyToOne
	@JoinColumn(name = "voteId")
	private VoteEntity vote;
	
	public SuggestionEntity() {
		
	}
	
	public SuggestionEntity(String name, String description, Date suggestionDate, VoteEntity vote) {
		super();
		this.name = name;
		this.description = description;
		this.suggestionDate = suggestionDate;
		this.vote = vote;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getSuggestionDate() {
		return suggestionDate;
	}

	public void setSuggestionDate(Date suggestionDate) {
		this.suggestionDate = suggestionDate;
	}

	public VoteEntity getVote() {
		return vote;
	}

	public void setVote(VoteEntity vote) {
		this.vote = vote;
	}
	

}
