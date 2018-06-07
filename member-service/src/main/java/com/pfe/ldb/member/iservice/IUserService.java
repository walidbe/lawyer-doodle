package com.pfe.ldb.member.iservice;
import java.util.List;

import com.pfe.ldb.entity.UserAuthoritiesEntity;

public interface IUserService {
	
	public List<UserAuthoritiesEntity> loadByEmail(String email);
	public List<UserAuthoritiesEntity> loadByUsername(String username);
}
