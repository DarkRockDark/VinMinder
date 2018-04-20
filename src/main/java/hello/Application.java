package hello;

//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {

        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE vehicles IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE vehicles(" +
                "id SERIAL, vinNumber VARCHAR(255), make VARCHAR(255), model VARCHAR(255), year VARCHAR(255))");

        // Split up the array of whole names into an array of first/last names
        List<Object[]> splitUpVins = Arrays.asList(
                "WBAAM17 BMW 535i 2017",
                "WBAAM01 BMW 323i 1999",
                "DODGE01 DODGE Dart 2010",
                "FORD01 FORD Ranger 1999"
                ).stream()
                .map(vehicle -> vehicle.split(" "))
                .collect(Collectors.toList());

        // Use a Java 8 stream to print out each tuple of the list
        splitUpVins.forEach(vehicle -> log.info(String.format("Inserting vehicle record for %s %s %s %s", vehicle[0], vehicle[1], vehicle[2], vehicle[3])));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO vehicles(vinNumber, make, model, year) VALUES (?,?,?,?)", splitUpVins);

        log.info("Querying for vehicle records where first_name = 'DODGE01':");
        jdbcTemplate.query(
                "SELECT id, vinNumber, make, model, year FROM vehicles WHERE vinNumber = ?", new Object[] { "DODGE01" },
                (rs, rowNum) -> new Vehicle(rs.getLong("id"), rs.getString("vinNumber"), rs.getString("make"), rs.getString("model"), rs.getString("year"))
        ).forEach(customer -> log.info(customer.toString()));
    }
    /*
    MongoClientURI uri = new MongoClientURI(
            "mongodb://drogers:fighter1@minder-shard-00-00-pinw4.mongodb.net:27017,minder-shard-00-01-pinw4.mongodb.net:27017,minder-shard-00-02-pinw4.mongodb.net:27017/test?ssl=true&replicaSet=minder-shard-0&authSource=admin");

    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase database = mongoClient.getDatabase("test");
    */

    /*
    @Bean
    CommandLineRunner init(CarRepository carRepository) {
        return (evt) -> Arrays.asList(
                "BMW 323i 1999 WBAAM08, Dodge Dart 2006 DODDGE02, Ford Edge 2014 FRD017".split(","))
                .forEach(
                        a -> {
                            Car car = carRepository.save(new Car(a));
                        });
    }


    @Bean
    CommandLineRunner init(VehicleRepository vehicleRepository) {
        return (evt) -> Arrays.asList(
                "BMW 323i 1999 WBAAM08, Dodge Dart 2006 DODDGE02, Ford Edge 2014 FRD017".split(","))
                .forEach(
                        a -> {
                            Vehicle vehicle = vehicleRepository.save(new Vehicle(a));
                        });
    }

    @Bean
    CommandLineRunner init(AccountRepository accountRepository,
                           BookmarkRepository bookmarkRepository) {
        return (evt) -> Arrays.asList(
                "jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
                .forEach(
                        a -> {
                            Account account = accountRepository.save(new Account(a,
                                    "password"));
                            bookmarkRepository.save(new Bookmark(account,
                                    "http://bookmark.com/1/" + a, "A description"));
                            bookmarkRepository.save(new Bookmark(account,
                                    "http://bookmark.com/2/" + a, "A description"));
                        });
    }
    */
}
