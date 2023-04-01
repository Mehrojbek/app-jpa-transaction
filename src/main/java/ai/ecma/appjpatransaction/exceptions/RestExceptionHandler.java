package ai.ecma.appjpatransaction.exceptions;

import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    //TRANSAKSIYA PAYTIDA O'ZGARISH YUZ BERSA VA VERSIYALAR BIRI BIRIGA TO'G'RI KELMASA SHU XATOLIKKA TUSHADI
    @ExceptionHandler(value = ObjectOptimisticLockingFailureException.class)
    public String handler(ObjectOptimisticLockingFailureException ex){
        System.err.println(ex.getMessage());
        return "ObjectOptimisticLockingFailureException";
    }


    @ExceptionHandler(value = Exception.class)
    public String handler(Exception ex){
        System.err.println(ex.getMessage());
        return "Exception";
    }

}
