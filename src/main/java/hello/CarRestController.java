package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
/*
@RestController
@RequestMapping("/car/{vin}")
public class CarRestController {
    private final CarRepository carRepository;

    @Autowired
    CarRestController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    String returnVin(@PathVariable String vin) {
        //return this.carRepository.findCarByVinLike(vin);
        if (vin.equalsIgnoreCase("bmw")) {
            return "bmw car";
        }

        if (vin.equalsIgnoreCase("dodge")) {
            return "dodge car";
        }

        if (vin.equalsIgnoreCase("ford")) {
            return "ford car";
        }


        return "Car Not Found";
    }

}
*/