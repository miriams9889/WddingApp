package com.wedd2.service;


import com.wedd2.event.Wedding;
import com.wedd2.event.WeddingNotFoundException;
import com.wedd2.repository.WeddingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeddingService {
 @Autowired private WeddingRepository repo;
 public List<Wedding> listAll(){
     return (List<Wedding>) repo.findAll();
 }

    public void save(Wedding wedding) {
     repo.save(wedding);
    }

    public Wedding get(Integer id) throws WeddingNotFoundException {
        Optional<Wedding> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new WeddingNotFoundException("Could not find any event with ID" + id);
    }
    public void delete(Integer id) throws WeddingNotFoundException {
     Long count = repo.countById(id);
     if (count == null || count == 0){
         throw new WeddingNotFoundException("Could not find any event with ID" + id);
     }
     repo.deleteById(id);
    }
}
