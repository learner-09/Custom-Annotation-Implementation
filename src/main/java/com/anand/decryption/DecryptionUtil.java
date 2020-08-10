package com.anand.decryption;

import com.anand.Decrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

import static java.util.Objects.requireNonNull;

@Component
public class DecryptionUtil {

    private static Logger logger= LoggerFactory.getLogger(DecryptionUtil.class);

    public Object decryptString(Object object){
        try {
            Class<?> objectClass = requireNonNull(object).getClass();
            logger.info("",objectClass);
            for (Field field: objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                logger.info("",field);
                boolean h=field.isAnnotationPresent(Decrypt.class);
                if (h) {
                    Object k=field.get(object);
                    String msg=manipulate(String.valueOf(field.get(object)));
                    field.set(object,msg);
                }
            }
        }
        catch (IllegalAccessException e) {
            logger.warn("ex",e);
        }
        logger.info("effefe",object);
        return object;
    }


    private String manipulate(String s){
        return s.toUpperCase();
    }
}
