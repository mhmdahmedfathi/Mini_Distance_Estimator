package Task.Services;

import Task.Repo.MongoRebo;
import Task.exception.CityException;
import Task.models.Cites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class implementation implements CityServices {

    @Autowired
    private MongoRebo CityRepo;

    public List<Cites> getAllCites() {
        List<Cites> Cites = CityRepo.findAll();
        if (Cites.size() > 0) {
            return Cites;
        } else {
            return new ArrayList<Cites>();
        }
    }

    public Cites getSingleCity(String id) throws CityException {
        Optional<Cites> CiteOptional = CityRepo.findById(id);
        if (!CiteOptional.isPresent()) {
            throw new CityException(CityException.NotFoundException(id));
        } else {
            return CiteOptional.get();
        }
    }

    public void createCity(Cites City) throws CityException {
        CityRepo.save(City);
    }

    public void updateCity(String id, Cites City) throws CityException {
        Optional<Cites> CityWithId = CityRepo.findById(id);
        if (CityWithId.isPresent()) {
            Cites CityToUpdate = CityWithId.get();

            CityToUpdate.setId(City.getId());
            CityToUpdate.setDistance(City.getDistance());
            CityToUpdate.setTo(City.getTo());
            CityRepo.save(CityToUpdate);
        } else {
            throw new CityException(CityException.NotFoundException(id));
        }
    }

    public void deleteCiteById(String id) throws CityException {
        Optional<Cites> CiteOptional = CityRepo.findById(id);
        if (!CiteOptional.isPresent()) {
            throw new CityException(CityException.NotFoundException(id));
        } else {
            CityRepo.deleteById(id);
        }

    }
}
