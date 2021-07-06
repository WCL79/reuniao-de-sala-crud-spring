package br.com.crud.saladereuniao.controller;


import br.com.crud.saladereuniao.exception.ResourceNotFoudException;
import br.com.crud.saladereuniao.model.Sala;
import br.com.crud.saladereuniao.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;

    @GetMapping("/salas")
    public Iterable<Sala> obterTodasSalas() {
        return salaRepository.findAll();
    }

    @GetMapping("/salas/{id}")
    public ResponseEntity<Sala> obterSalaPorID(@PathVariable(value = "id") long idSala) throws ResourceNotFoudException {
        Sala sala = salaRepository.findById(idSala)
                .orElseThrow(() -> new ResourceNotFoudException("Sala não encontrada::" + idSala));
        return ResponseEntity.ok().body(sala);
    }

    @PostMapping("/salas")
    public Sala criarSala(@Valid @RequestBody Sala sala) {
        return salaRepository.save(sala);
    }

    @PutMapping("/salas/{id}")
    public ResponseEntity<Sala> atualizarSala(@PathVariable(value = "id") Long idSala,
                                              @Valid @RequestBody Sala detalhesSala) throws ResourceNotFoudException {
        Sala sala = salaRepository.findById(idSala)
                .orElseThrow(() -> new ResourceNotFoudException("Sala não encontrada com esse id::" + idSala));
        sala.setNome(detalhesSala.getNome());
        sala.setData(detalhesSala.getData());
        sala.setHorarioInicio(detalhesSala.getHorarioInicio());
        sala.setHorairioFinal(detalhesSala.getHorairioFinal());
        final Sala atualizarSala = salaRepository.save(sala);
        return ResponseEntity.ok(atualizarSala);
    }

    public Map<String, Boolean> excluirSala(@PathVariable(value = "id") Long idSala) throws ResourceNotFoudException{
        Sala sala = salaRepository.findById(idSala)
                .orElseThrow(() -> new ResourceNotFoudException("Sala não encontrada com esse id::"+idSala));

        salaRepository.delete(sala);
        Map<String, Boolean> resposta =  new HashMap<>();
        resposta.put("Excluido!", Boolean.TRUE);
        return resposta;
    }
}
