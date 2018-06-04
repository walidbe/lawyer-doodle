package com.pfe.ldb.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class ModelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	protected Integer id;
	
    @Temporal(TemporalType.DATE)
    private final Date createdDate;
    
    public ModelEntity() {
    	this.createdDate = new Date(Calendar.getInstance().getTime().getTime());
    }

	public Integer getId() {
		return id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
    
    
    
}
