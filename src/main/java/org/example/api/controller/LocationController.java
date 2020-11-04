package org.example.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.api.domain.friend.Friend;
import org.example.api.domain.location.Location;
import org.example.api.dto.LocationDto;
import org.example.api.service.FriendService;
import org.example.api.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;
    private final FriendService friendService;

    @PostMapping("/api/insertLocation")
    public ResponseEntity<Location> save(@RequestBody Location location){
        return new ResponseEntity<Location>(locationService.save(location), HttpStatus.OK);
    }

    @PutMapping(value = "/api/update/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Location> updateLocation(@PathVariable("name") String name, @RequestBody Location location){

        locationService.updateByName(name, location);
        return new ResponseEntity<Location>(location, HttpStatus.OK);
    }

    @GetMapping(value = "/api/locationList", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Location>> getAllLocations(){
        List<Location> locations = locationService.findAll();
        return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
    }

    @PostMapping("/api/function1/{name}")
    public List<Location> function1(@PathVariable("name") String name, @RequestBody Location location){
        Location locations = locationService.findByName(name);

        if(locations == null){
            locationService.save(location);
        }else{
            locationService.updateByName(name, location);
        }

        return locationService.findAll();
    }

    @PostMapping("/api/function2/{name}")
    public List<Location> function2(@PathVariable("name") String name, @RequestBody Location location){
        Location locations = locationService.findByName(name);

        if(locations == null){
            locationService.save(location);
        }else{
            locationService.updateByName(name, location);
        }

        List<Friend> friend = friendService.findByName(name);
        List<String> friends = new ArrayList<>();
        friend.forEach(e -> friends.add(e.getFriendName()));

        List<Location> friendsLocation = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++){
            friendsLocation.add(i, locationService.findByName(friends.get(i)));
        }

        return friendsLocation;
    }




    @GetMapping(value = "/api/location/findbyname/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Location findByName(@PathVariable("name") String name){
        return locationService.findByName(name);
    }


}
