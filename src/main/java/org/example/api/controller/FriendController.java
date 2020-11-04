package org.example.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.api.domain.friend.Friend;
import org.example.api.domain.friend.FriendRepository;
import org.example.api.domain.location.Location;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FriendController {

    private final FriendRepository friendRepository;

    @PostMapping("/api/friendsave")
    public ResponseEntity<Friend> save(@RequestBody Friend friend){
        return new ResponseEntity<Friend>(friendRepository.save(friend), HttpStatus.OK);
    }

    @GetMapping("/api/friend/findbyname/{name}")
    public List<Friend> findByName(@PathVariable("name")String name){
        return friendRepository.findByName(name);
    }
}
