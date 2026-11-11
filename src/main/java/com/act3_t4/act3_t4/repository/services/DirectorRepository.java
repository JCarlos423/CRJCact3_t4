package com.act3_t4.act3_t4.repository.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.act3_t4.act3_t4.models.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}