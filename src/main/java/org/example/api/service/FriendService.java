package org.example.api.service;

import org.example.api.domain.friend.Friend;
import org.example.api.domain.friend.FriendRepository;
import org.example.api.domain.location.Location;
import org.example.api.domain.location.LocationRepository;
import org.example.api.domain.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;

    public List<Friend> findByName(String name){
        List<Friend> friend = friendRepository.findByName(name);
        return friend;
    }
}
