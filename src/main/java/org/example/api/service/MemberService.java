package org.example.api.service;

import lombok.RequiredArgsConstructor;
import org.example.api.domain.friend.Friend;
import org.example.api.domain.location.Location;
import org.example.api.domain.member.GetToken;
import org.example.api.domain.member.Member;
import org.example.api.domain.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public String getToken(String name){

        GetToken getToken = memberRepository.findByName(name);
        String token = getToken.getToken();
        return token;
    }

    public Member save(Member member){
        memberRepository.save(member);
        return member;
    }

    public Member myPage(String phoneNumber){
        return memberRepository.findByPhoneNumber(phoneNumber);
    }

    public Member findByPhoneNumber(String phoneNumber){
        return memberRepository.findByPhoneNumber(phoneNumber);
    }
}
