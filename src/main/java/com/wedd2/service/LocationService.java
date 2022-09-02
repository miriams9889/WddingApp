package com.wedd2.service;


import com.wedd2.event.Location;
import com.wedd2.event.LocationNotFoundException;
import com.wedd2.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
 @Autowired private LocationRepository repo;
 public List<Location> listAll(){
     return (List<Location>) repo.findAll();
 }

    public void save(Location location) {
     repo.save(location);
    }

    public Location get(Integer id) throws LocationNotFoundException {
        Optional<Location> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new LocationNotFoundException("Could not find any event with ID" + id);
    }
    public void delete(Integer id) throws LocationNotFoundException {
     Long count = repo.countById(id);
     if (count == null || count == 0){
         throw new LocationNotFoundException("Could not find any location with ID" + id);
     }
     repo.deleteById(id);
    }
}
