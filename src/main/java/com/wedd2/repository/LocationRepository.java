package com.wedd2.repository;

import com.wedd2.event.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {
   public Long countById(Integer integer);
}
