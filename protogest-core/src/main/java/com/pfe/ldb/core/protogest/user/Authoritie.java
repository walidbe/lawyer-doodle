package com.pfe.ldb.core.protogest.user;

import com.pfe.ldb.core.protogest.utils.AbstractModel;

public class Authoritie extends AbstractModel {
	
	private String name;
	
	public Authoritie(final Integer id, String name) {
		super(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
