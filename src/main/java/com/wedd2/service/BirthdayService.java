package com.wedd2.service;

import com.wedd2.event.Birthday;
import com.wedd2.event.BirthdayNotFoundException;
import com.wedd2.repository.BirthdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BirthdayService {
    @Autowired private BirthdayRepository repo;
    public List<Birthday> listAll(){return (List<Birthday>) repo.findAll(); }


    public void save(Birthday birthday){repo.save(birthday);}

    public Birthday get(Integer id) throws BirthdayNotFoundException {

        Optional<Birthday> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new BirthdayNotFoundException("Could not find any event with ID" + id);
    }



    public void delete(Integer id) throws BirthdayNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0){
            throw new BirthdayNotFoundException("Could not find any event with ID" + id);
        }
        repo.deleteById(id);
    }

}
