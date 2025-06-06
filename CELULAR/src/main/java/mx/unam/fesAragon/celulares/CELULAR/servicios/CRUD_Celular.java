package mx.unam.fesAragon.celulares.CELULAR.servicios;
import jakarta.transaction.Transactional;
import mx.unam.fesAragon.celulares.CELULAR.entidades.Celular;
import mx.unam.fesAragon.celulares.CELULAR.repositorios.CelularCRUD;
import mx.unam.fesAragon.celulares.CELULAR.servicios.interfase.operaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CRUD_Celular implements operaciones {
    @Autowired
    CelularCRUD celularCRUD;

    @Override
    public  Celular crear(Celular celular){return celularCRUD.save(celular);}

    @Override
    public  Iterable<Celular>listarTodas(){return celularCRUD.findAll();}

    @Override
    public Optional<Celular> buscarPorId(long clave) {return celularCRUD.findById(clave);}
    @Override
    public Celular actualizar(long clave, Celular celular) {
        Optional<Celular> actual = celularCRUD.findById(clave);
        if (actual.isPresent()){
            Celular cel = actual.get();
            cel.setMarca(celular.getMarca());
            cel.setModelo(celular.getModelo());
            cel.setPrecio(celular.getPrecio());
            return celularCRUD.save(cel);
        }else{return null;}
    }
    @Override
    @Transactional
    public void eliminar(long clave) { celularCRUD.deleteByClave(clave);}
}
