package Task.Repo;

import Task.models.Cites;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface MongoRebo extends MongoRepository<Cites,String> {
    @Query("{'city': ?0}")
    Optional<Cites> findByCity(String city);
}
