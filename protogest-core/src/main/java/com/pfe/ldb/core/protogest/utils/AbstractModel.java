package com.pfe.ldb.core.protogest.utils;

import java.io.Serializable;

public class AbstractModel implements Serializable {

    private static final long  serialVersionUID = 235240299732838987L;

	private final Integer id;

    public AbstractModel() {
        super();
        this.id = null;    }


    public AbstractModel(final Integer id) {
        super();
        this.id = id;
    }


    public Integer getId() {
        return this.id;
    }


    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass().equals(obj.getClass())) {
        	if(this.id == null) {
        		if(this.id == ((AbstractModel)obj).getId()) {
        			return true;
        		}
        	}
            if (this.id.equals(((AbstractModel) obj).getId())) {
                return true;
            }
        }

        return false;
    }
}
