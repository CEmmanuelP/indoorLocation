package org.example.api.service;

import org.example.api.domain.location.Location;
import org.example.api.domain.location.LocationRepository;
import org.example.api.dto.LocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location save(Location location){
        locationRepository.save(location);
        return location;
    }

    public List<Location> findAll(){
        List<Location> location = new ArrayList<>();
        locationRepository.findAll().forEach(e -> location.add(e));
        return location;
    }

    public void updateByName(String name, Location location){
        Location l = locationRepository.findByName(name);

        l.setX(location.getX());
        l.setY(location.getY());

        locationRepository.save(l);
    }

    public Location findByName(String name){
        return locationRepository.findByName(name);
    }





}
