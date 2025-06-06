package mx.unam.fesAragon.celulares.CELULAR.errores;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;

@RestControllerAdvice
public class errorCelular {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String,String>> espacioBlanco(HttpMessageNotReadableException ex){
        HashMap<String,String> respuesta = new HashMap<>();
        respuesta.put("mensaje",ex.getLocalizedMessage());
        respuesta.put("estatus",HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(respuesta,HttpStatus.OK);
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> metodoIncorrecto(){
        return new ResponseEntity<>("Metodo HTTP no permitido para esta ruta",HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<String> rutaIncorrecta(){
        return new ResponseEntity<>("La ruta no existe",HttpStatus.NOT_FOUND);
    }
}
