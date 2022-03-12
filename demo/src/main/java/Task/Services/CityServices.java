package Task.Services;

import Task.models.Cites;
import Task.exception.CityException;

import java.util.List;

public interface CityServices {
    public List<Cites> getAllCites();

    public Cites getSingleCity(String id) throws CityException;

    public void createCity(Cites city) throws CityException;

    public void updateCity(String id, Cites city) throws CityException;

    public void deleteCiteById(String id) throws CityException;
}
