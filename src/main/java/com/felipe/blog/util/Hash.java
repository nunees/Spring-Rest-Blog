package com.felipe.blog.util;

import org.mindrot.jbcrypt.BCrypt;

public class Hash {
    private String password;
    private static final int saltRounds = 12;

    public Hash(){}

    public Hash(String password){
        this.password = password;
    }

    public String hashPassword(){
        return BCrypt.hashpw(this.password, BCrypt.gensalt(saltRounds));
    }

    public boolean verifyHash(String password, String hash){
        return BCrypt.checkpw(password, hash);
    }


}
