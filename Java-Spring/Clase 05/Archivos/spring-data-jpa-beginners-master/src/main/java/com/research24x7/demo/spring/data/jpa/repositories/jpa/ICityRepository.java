
package com.research24x7.demo.spring.data.jpa.repositories.jpa;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.research24x7.demo.spring.data.jpa.entities.jpa.CityEntity;


@Repository
public interface ICityRepository extends JpaRepository<CityEntity, Integer> {

}