package com.plass.traveling.domain.place.repository;

import com.plass.traveling.domain.place.entity.Place;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findByPlaceNameContaining(String deviceName, Sort id);
}
