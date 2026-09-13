package cl.andesstay.catalog.repository;

import cl.andesstay.catalog.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
    List<Unit> findByAvailable(Boolean available);
}
