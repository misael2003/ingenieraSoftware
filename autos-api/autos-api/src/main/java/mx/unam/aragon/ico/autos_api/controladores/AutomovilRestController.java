package mx.unam.aragon.ico.autos_api.controladores;


import mx.unam.aragon.ico.autos_api.modelos.Automovil;
import mx.unam.aragon.ico.autos_api.servicios.AutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/autos")
public class AutomovilRestController {

    @Autowired
    private AutomovilService automovilService;

    @GetMapping("/")
    public ResponseEntity<List<Automovil>> getAutomovil() {
        return ResponseEntity.ok(automovilService.getAutomovils());

    }
}
