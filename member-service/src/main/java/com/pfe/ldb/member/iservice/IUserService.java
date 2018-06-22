package com.pfe.ldb.member.iservice;
import java.util.List;

import com.pfe.ldb.core.protogest.user.User;
import com.pfe.ldb.entity.UserAuthoritiesEntity;

public interface IUserService {
	
	public List<UserAuthoritiesEntity> loadByEmail(String email);
	public User loadByUsername(String username);
	public void save(User user);
}
