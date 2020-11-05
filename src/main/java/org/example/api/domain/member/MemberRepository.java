package org.example.api.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    GetToken findByUname(String uname);
    Member findByPhoneNumber(String phoneNumber);
    Optional<Member> findByUid(String uid);
}
