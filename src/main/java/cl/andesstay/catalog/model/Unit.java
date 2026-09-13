package cl.andesstay.catalog.model;

import jakarta.persistence.*;

@Entity
@Table(name = "units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 32)
    private String code;

    @Column(nullable = false, length = 16)
    @Enumerated(EnumType.STRING)
    private UnitType type;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private Double pricePerNight;

    @Column(nullable = false)
    private Boolean available = true;

    public enum UnitType {
        HABITACION, CABANA
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public UnitType getType() { return type; }
    public void setType(UnitType type) { this.type = type; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public Double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(Double pricePerNight) { this.pricePerNight = pricePerNight; }
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
}
