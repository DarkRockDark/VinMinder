package hello.api.rest;

import hello.Vehicle;
import hello.service.VehicleServices;
import hello.exception.Message;
import hello.spring.aop.ProfileExecution;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class RESTVehicleAPI extends org.shop.api.rest.RESTBaseAPI {


    @Autowired
    private VehicleServices vehicleServices;

    @RequestMapping(value = "/vehicle", method = POST, produces = APPLICATION_JSON_VALUE)
    @ProfileExecution
    @ApiOperation(value = "createVehicle", nickname = "createVehicle")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Vehicle.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Message.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Message.class)})
    public ResponseEntity<Vehicle> createUser(@Valid @RequestBody Vehicle vehicle) {
        vehicleServices.save(vehicle);
        return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
    }
}
