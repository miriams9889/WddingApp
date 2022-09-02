package com.wedd2.repository;

import com.wedd2.event.Baptism;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaptismRepository extends JpaRepository<Baptism, Integer> {

    public Long countById(Integer integer);


}
