package cl.andesstay.catalog.controller;

import cl.andesstay.catalog.dto.UnitDTO;
import cl.andesstay.catalog.service.UnitService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog/units")
public class UnitController {

    private final UnitService service;

    public UnitController(UnitService service) {
        this.service = service;
    }

    @GetMapping
    public List<UnitDTO> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UnitDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UnitDTO create(@RequestBody @Valid UnitDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public UnitDTO update(@PathVariable Long id, @RequestBody @Valid UnitDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
