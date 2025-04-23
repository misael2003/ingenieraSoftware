package mx.unam.aragon.ico.autos_api.servicios;

import mx.unam.aragon.ico.autos_api.modelos.Automovil;
import mx.unam.aragon.ico.autos_api.repositorios.AutomovilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomovilServiceImpl implements AutomovilService {
    @Autowired
    private AutomovilRepository automovilRepository;

    @Override
    public List<Automovil> getAutomovils() {
        return automovilRepository.findAll();
    }
}
