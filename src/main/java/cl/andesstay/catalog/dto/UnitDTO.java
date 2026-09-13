package cl.andesstay.catalog.dto;

import cl.andesstay.catalog.model.Unit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class UnitDTO {
    private Long id;
    @NotBlank
    private String code;
    @NotNull
    private String type;
    @NotNull
    @Positive
    private Integer capacity;
    @NotNull
    @Positive
    private Double pricePerNight;
    private Boolean available = true;

    public static UnitDTO fromEntity(Unit u) {
        UnitDTO dto = new UnitDTO();
        dto.id = u.getId();
        dto.code = u.getCode();
        dto.type = u.getType().name();
        dto.capacity = u.getCapacity();
        dto.pricePerNight = u.getPricePerNight();
        dto.available = u.getAvailable();
        return dto;
    }

    public Unit toEntity() {
        Unit u = new Unit();
        u.setCode(this.code);
        u.setType(Unit.UnitType.valueOf(this.type));
        u.setCapacity(this.capacity);
        u.setPricePerNight(this.pricePerNight);
        u.setAvailable(this.available != null ? this.available : true);
        return u;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public Double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(Double pricePerNight) { this.pricePerNight = pricePerNight; }
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
}
