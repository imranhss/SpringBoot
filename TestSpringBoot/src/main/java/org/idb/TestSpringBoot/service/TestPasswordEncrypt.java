package org.idb.TestSpringBoot.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPasswordEncrypt {

    public  static  void main(String[] asd){

        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String regPass="1234";
        String encPass= encoder.encode(regPass);
        System.out.println(encPass);

       // $2a$10$CrmwhLqqpTRajOzeiR/4d./HLCfxozCPh1cWBa2BR1Gk3FW1STV26

    }
}
