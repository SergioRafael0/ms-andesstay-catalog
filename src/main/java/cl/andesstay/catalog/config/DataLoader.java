package cl.andesstay.catalog.config;

import cl.andesstay.catalog.model.Unit;
import cl.andesstay.catalog.repository.UnitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {
    @Bean
    public CommandLineRunner initData(UnitRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.saveAll(List.of(
                    build("HAB-101", Unit.UnitType.HABITACION, 2, 55000.0, true),
                    build("HAB-102", Unit.UnitType.HABITACION, 3, 75000.0, true),
                    build("HAB-201", Unit.UnitType.HABITACION, 4, 95000.0, true),
                    build("CAB-1", Unit.UnitType.CABANA, 6, 180000.0, true),
                    build("CAB-2", Unit.UnitType.CABANA, 8, 250000.0, true)
                ));
            }
        };
    }

    private Unit build(String code, Unit.UnitType type, int capacity, double price, boolean available) {
        Unit u = new Unit();
        u.setCode(code);
        u.setType(type);
        u.setCapacity(capacity);
        u.setPricePerNight(price);
        u.setAvailable(available);
        return u;
    }
}
