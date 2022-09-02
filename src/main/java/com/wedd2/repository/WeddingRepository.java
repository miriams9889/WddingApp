package com.wedd2.repository;

import com.wedd2.event.Wedding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeddingRepository extends JpaRepository<Wedding, Integer> {

    public Long countById(Integer integer);


}
