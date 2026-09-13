package cl.andesstay.catalog.service;

import cl.andesstay.catalog.dto.UnitDTO;
import cl.andesstay.catalog.exception.BusinessException;
import cl.andesstay.catalog.model.Unit;
import cl.andesstay.catalog.repository.UnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitService {

    private final UnitRepository repository;

    public UnitService(UnitRepository repository) {
        this.repository = repository;
    }

    public List<UnitDTO> findAll() {
        return repository.findAll().stream().map(UnitDTO::fromEntity).collect(Collectors.toList());
    }

    public UnitDTO findById(Long id) {
        Unit u = repository.findById(id)
            .orElseThrow(() -> new BusinessException("Unidad no encontrada: " + id));
        return UnitDTO.fromEntity(u);
    }

    public UnitDTO create(UnitDTO dto) {
        if (repository.findAll().stream().anyMatch(u -> u.getCode().equalsIgnoreCase(dto.getCode()))) {
            throw new BusinessException("Ya existe una unidad con el código " + dto.getCode());
        }
        return UnitDTO.fromEntity(repository.save(dto.toEntity()));
    }

    public UnitDTO update(Long id, UnitDTO dto) {
        Unit u = repository.findById(id)
            .orElseThrow(() -> new BusinessException("Unidad no encontrada: " + id));
        try {
            u.setType(Unit.UnitType.valueOf(dto.getType()));
        } catch (IllegalArgumentException e) {
            throw new BusinessException("Tipo inválido: " + dto.getType());
        }
        u.setCode(dto.getCode());
        u.setCapacity(dto.getCapacity());
        u.setPricePerNight(dto.getPricePerNight());
        u.setAvailable(dto.getAvailable() != null ? dto.getAvailable() : u.getAvailable());
        return UnitDTO.fromEntity(repository.save(u));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("Unidad no encontrada: " + id);
        }
        repository.deleteById(id);
    }
}
