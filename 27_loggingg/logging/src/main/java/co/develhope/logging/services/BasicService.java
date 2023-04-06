package co.develhope.logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    Logger logger = LoggerFactory.getLogger(BasicService.class);

    @Autowired
    private Environment environment;





    //customEnvs:
    //  n1: 2
    //  n2: 8


    public String sayHello(){
        String s = "hello";
        logger.info(s);
        return s;
    }


    public int powerOf(int var1, int var2){
        logger.info("before operation");
        int sum=var1*var2;
        logger.info("after operation");
        return sum;
    }




}
