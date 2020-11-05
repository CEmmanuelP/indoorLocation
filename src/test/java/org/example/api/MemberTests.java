package org.example.api;

import lombok.extern.java.Log;
import org.example.api.domain.member.Member;
import org.example.api.domain.member.MemberRepository;
import org.example.api.domain.member.MemberRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class MemberTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testInsert(){
        for(int i = 0; i <= 100; i++){
            Member member = new Member();
            member.setUid("user" + i);
            member.setUpassword("pw" + i);
            member.setUname("name" + i);
            member.setToken("token" + i);
            member.setPhoneNumber("0101234567" + i);

            memberRepository.save(member);
        }
    }
}
