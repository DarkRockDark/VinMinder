package hello;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "vehicle", path = "vehicle")

public interface VehicleRepository extends MongoRepository<Vehicle, String> {

    Vehicle findVehicleByVinNumberLike(@Param("vin") String vin);
}
