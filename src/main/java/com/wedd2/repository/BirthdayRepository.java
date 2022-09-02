package com.wedd2.repository;

import com.wedd2.event.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthdayRepository extends JpaRepository <Birthday,Integer >{
    public Long countById(Integer integer);
}
