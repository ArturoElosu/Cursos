

package com.research24x7.demo.spring.data.jpa.repositories.jpa;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research24x7.demo.spring.data.jpa.entities.jpa.CountryEntity;
import com.research24x7.demo.spring.data.jpa.entities.jpa.ProvinceEntity;


@Repository
public interface IProvinceRepository extends JpaRepository<ProvinceEntity, Integer> {


    List<ProvinceEntity> findAllByCountryOrderByNameDesc (CountryEntity country);
}