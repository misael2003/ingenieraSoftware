package mx.unam.fesAragon.celulares.CELULAR.servicios.interfase;

import mx.unam.fesAragon.celulares.CELULAR.entidades.Celular;
import java.util.Optional;

public interface operaciones {
    public  abstract Celular crear(Celular celular);
    public abstract Iterable<Celular>listarTodas();
    public abstract Optional<Celular> buscarPorId(long clave);
    public abstract Celular actualizar(long clave,Celular celular);
    public abstract void eliminar(long clave);
}
