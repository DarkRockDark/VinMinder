package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// reference:
// https://spring.io/guides/gs/accessing-mongodb-data-rest/
// adding a record:
// curl -i -X POST -H "Content-Type:application/json" -d "{  \"firstName\" : \"Frodo\",  \"lastName\" : \"Baggins\" }" http://localhost:8080/people
// curl -i -X POST -H "Content-Type:application/json" -d "{  \"vinNumber\" : \"WBAAM01\",  \"make\" : \"BMW\" ,  \"model\" : \"323i\" ,  \"year\" : \"1999\" }" http://localhost:8080/vehicle
// http://localhost:8080/people
// http://localhost:8080/vehicle
// http://localhost:8080/vehicle/search/findVehicleByVinNumberEquals?vin=WBAAM01

@SpringBootApplication
public class Application {

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }
}
