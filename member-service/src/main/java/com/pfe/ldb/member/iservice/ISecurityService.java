package com.pfe.ldb.member.iservice;

public interface ISecurityService {

    void login(String username, String password);
    public String findLoggedInUsername();

}
