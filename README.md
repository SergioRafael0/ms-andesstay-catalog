# 🏨 AndesStay — Microservicio de Catálogo

Caso 5 EP1 — DSY1107 Cloud Native I.

Microservicio **Spring Boot 3** que gestiona el **catálogo de unidades hoteleras** (habitaciones y cabañas).

## 📡 Endpoints

| Método | Path                          | Descripción                        |
|--------|-------------------------------|------------------------------------|
| GET    | `/api/catalog/units`          | Listar todas las unidades          |
| GET    | `/api/catalog/units/{id}`     | Obtener por ID                     |
| POST   | `/api/catalog/units`          | Crear unidad (Admin/Recep)         |
| PUT    | `/api/catalog/units/{id}`     | Actualizar unidad (Admin/Recep)    |
| DELETE | `/api/catalog/units/{id}`     | Eliminar unidad (Admin/Recep)      |

## 🏠 Tipos de unidad

- `HABITACION` — habitación de hotel
- `CABANA` — cabaña independiente

## 🗄️ Persistencia

**H2 en memoria.** Consola H2: `http://localhost:8082/h2-console`
- JDBC URL: `jdbc:h2:mem:catalog`
- User: `sa`
- Password: (vacío)

## 🚀 Comandos

```bash
mvn clean package -DskipTests
java -jar target/ms-andesstay-catalog.jar
```

## 🧪 Pruebas rápidas (con curl)

```bash
# Listar
curl http://localhost:8082/api/catalog/units

# Crear
curl -X POST http://localhost:8082/api/catalog/units \
  -H "Content-Type: application/json" \
  -d '{"code":"HAB-301","type":"HABITACION","capacity":2,"pricePerNight":65000,"available":true}'

# Actualizar
curl -X PUT http://localhost:8082/api/catalog/units/1 \
  -H "Content-Type: application/json" \
  -d '{"code":"HAB-101","type":"HABITACION","capacity":2,"pricePerNight":60000,"available":false}'

# Eliminar
curl -X DELETE http://localhost:8082/api/catalog/units/1
```

## 📁 Estructura

```
src/main/java/cl/andesstay/catalog/
├── CatalogApplication.java
├── config/
│   ├── CorsConfig.java
│   └── DataLoader.java              # 5 unidades de ejemplo
├── controller/
│   └── UnitController.java
├── dto/
│   └── UnitDTO.java
├── exception/
│   ├── BusinessException.java
│   └── GlobalExceptionHandler.java
├── model/
│   └── Unit.java                    # Entidad JPA
├── repository/
│   └── UnitRepository.java
└── service/
    └── UnitService.java
```

## 🌱 Datos iniciales

Al arrancar, carga 5 unidades:
- HAB-101 (Habitación, 2 personas, $55.000)
- HAB-102 (Habitación, 3 personas, $75.000)
- HAB-201 (Habitación, 4 personas, $95.000)
- CAB-1 (Cabaña, 6 personas, $180.000)
- CAB-2 (Cabaña, 8 personas, $250.000)
