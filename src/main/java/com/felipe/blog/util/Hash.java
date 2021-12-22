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

//    public boolean verifyAndUpdateHash(String password, String hash, Function<String, Boolean> updateFunc) {
//        if (BCrypt.checkpw(password, hash)) {
//            int rounds = getRounds(hash);
//            // It might be smart to only allow increasing the rounds.
//            // If someone makes a mistake the ability to undo it would be nice though.
//            if (rounds != logRounds) {
//                log.debug("Updating password from {} rounds to {}", rounds, logRounds);
//                String newHash = hash(password);
//                return updateFunc.apply(newHash);
//            }
//            return true;
//        }
//        return false;
//    }
}
