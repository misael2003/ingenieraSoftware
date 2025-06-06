package mx.unam.fesAragon.celulares.CELULAR.controladores;

import mx.unam.fesAragon.celulares.CELULAR.entidades.Celular;
import mx.unam.fesAragon.celulares.CELULAR.servicios.CRUD_Celular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/celulares")
public class CelularController {
    @Autowired
    CRUD_Celular CELULAR;

    @GetMapping("")
    public ResponseEntity<Iterable<Celular>> verTodos(){
        return new ResponseEntity<>(CELULAR.listarTodas(),HttpStatus.OK);
    }

    @GetMapping("/{clave}")
    public ResponseEntity<Celular> verCelular(@PathVariable long clave) {
        Optional<Celular> tmp = CELULAR.buscarPorId(clave);
        if (tmp.isPresent()){
            return new ResponseEntity<>(tmp.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{clave}")
    public ResponseEntity<String> noExiste(){
        return new ResponseEntity<>("Ruta no soportada",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Celular> crearCelular(@RequestBody Celular celular){
        try{
            Celular nuevo = CELULAR.crear(celular);
            return new ResponseEntity<>(nuevo,HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{clave}")
    public ResponseEntity<Celular> putCelular(@PathVariable long clave,@RequestBody Celular celular){
        Optional<Celular> tmp = CELULAR.buscarPorId(clave);
        if (tmp.isPresent()){
            return new ResponseEntity<>(CELULAR.actualizar(clave,celular),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/")
    public ResponseEntity<String> noPermitidoPut(){
        return new ResponseEntity<>("Accion no permitido",
                HttpStatusCode.valueOf(405));
    }

    @PatchMapping("/{clave}")
    public ResponseEntity<Celular> actualisarParcial(@PathVariable long clave,@RequestBody Celular celular){
        Optional<Celular> tmp = CELULAR.buscarPorId(clave);
        if(tmp.isPresent()){
            Celular temporal = tmp.get();
            if(celular.getMarca() == null) temporal.setMarca(celular.getMarca());
            if (celular.getPrecio()==0.0) temporal.setPrecio(celular.getPrecio());
            return new ResponseEntity<>(CELULAR.actualizar(clave,temporal),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/")
    public ResponseEntity<String> noPermitidoPatch(){
        return new ResponseEntity<>("Accion no permitido",HttpStatusCode.valueOf(405));
    }

    @DeleteMapping("/{clave}")
    public ResponseEntity<String> eliminarCelular(@PathVariable long clave){
        Optional<Celular> tmp = CELULAR.buscarPorId(clave);
        if (tmp.isPresent()){
            CELULAR.eliminar(clave);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
    }

    @DeleteMapping("/")
    public ResponseEntity<String> noPermitido(){
        return new ResponseEntity<>("Accion no permitido",
            HttpStatusCode.valueOf(405));}

}
