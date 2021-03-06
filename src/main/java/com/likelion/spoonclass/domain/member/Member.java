package com.likelion.spoonclass.domain.member;

import com.likelion.spoonclass.domain.BaseEntity;
import com.likelion.spoonclass.domain.attend.Attend;
import com.likelion.spoonclass.domain.univ.Univ;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority = Authority.USER;

    @OneToMany
    private List<Attend> attendList = new ArrayList<>();

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    private Univ univ;

    @Builder
    public Member(String email, String password, String name){
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
