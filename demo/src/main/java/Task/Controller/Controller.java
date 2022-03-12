package Task.Controller;

import Task.Services.CityServices;
import Task.exception.CityException;
import Task.models.Cites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CityServices CiteService;

    @PostMapping("/CreateCity")
    public ResponseEntity<?> createCite(@RequestBody Cites Cite) {
        try {
            CiteService.createCity(Cite);
            return new ResponseEntity<Cites>(Cite, HttpStatus.OK);
       } catch (CityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/City")
    public ResponseEntity<?> getAllCites() {
        List<Cites> Cites = CiteService.getAllCites();
        return new ResponseEntity<>(Cites, Cites.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/Cites/{id}")
    public ResponseEntity<?> getSingleCite(@PathVariable("id") String id){
        try {
            return new ResponseEntity<>(CiteService.getSingleCity(id), HttpStatus.OK);
        } catch (CityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Cites/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) throws CityException{
        try{
            CiteService.deleteCiteById(id);
            return new ResponseEntity<>("Successfully deleted Cite with id "+id, HttpStatus.OK);
        }
        catch (CityException e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/Cites/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody Cites Cite)
    {
        try {
            CiteService.updateCity(id,Cite);
            return new ResponseEntity<>("Updated movie with id "+id+"", HttpStatus.OK);
        }
        catch (CityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
