package org.example.api.domain.member;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "members")
@EqualsAndHashCode(of = "uid")
@ToString
public class Member{

    @Id
    private String uid;

    //@Column(nullable = false)
    private String upassword;

    //@Column(nullable = false)
    private String uname;

    //@Column(nullable = false)
    private String email;

    //@Column(nullable = false)
    private String phoneNumber;

    //@Column(nullable = false)
    private String token;

    private Date birthday;
    private Integer gender;
    private String image;
    private String nickName;

    @CreationTimestamp
    private LocalDateTime regdate;
    @UpdateTimestamp
    private LocalDateTime updatedate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "member")
    private List<MemberRole> roles;

}