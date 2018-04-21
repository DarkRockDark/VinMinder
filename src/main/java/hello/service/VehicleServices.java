package hello.service;

import hello.Vehicle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import hello.VehicleRepository;

import hello.spring.aop.ProfileExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServices {
    private static final Log logger = LogFactory.getLog(VehicleServices.class);
    @Autowired
    private VehicleRepository vehicleRepository;

    @ProfileExecution
    public Vehicle findByVin(String vin) {
        Vehicle vehicle = vehicleRepository.findVehicleByVinNumber(vin);
        return vehicle;
    }
    @ProfileExecution
    public void deleteAll() {
        vehicleRepository.deleteAll();
    }
    @ProfileExecution
    public void save(Vehicle vehicle) {
        // verifyUser(user);
        // user.setPassword(sha256(user.getPassword()));
        vehicleRepository.save(vehicle);
    }

}
