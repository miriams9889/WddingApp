package com.wedd2.service;


import com.wedd2.event.Baptism;
import com.wedd2.event.BaptismNotFoundException;
import com.wedd2.repository.BaptismRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaptismService {
 @Autowired private BaptismRepository repo;
 public List<Baptism> listAll(){
     return (List<Baptism>) repo.findAll();
 }

    public void save(Baptism baptism) {
     repo.save(baptism);
    }

    public Baptism get(Integer id) throws BaptismNotFoundException {
        Optional<Baptism> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new BaptismNotFoundException("Could not find any event with ID" + id);
    }
    public void delete(Integer id) throws BaptismNotFoundException {
     Long count = repo.countById(id);
     if (count == null || count == 0){
         throw new BaptismNotFoundException("Could not find any event with ID" + id);
     }
     repo.deleteById(id);
    }
}
