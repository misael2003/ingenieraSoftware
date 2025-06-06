package mx.unam.fesAragon.celulares.CELULAR.repositorios;

import jakarta.transaction.Transactional;
import mx.unam.fesAragon.celulares.CELULAR.entidades.Celular;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CelularCRUD extends CrudRepository<Celular, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Celular c WHERE c.clave = :clave")
    void deleteByClave(long clave);
}
