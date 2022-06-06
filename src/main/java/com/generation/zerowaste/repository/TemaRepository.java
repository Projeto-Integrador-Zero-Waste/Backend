package com.generation.zerowaste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.zerowaste.model.Tema;
@Repository
public interface TemaRepository   extends JpaRepository<Tema,Long>{

}
