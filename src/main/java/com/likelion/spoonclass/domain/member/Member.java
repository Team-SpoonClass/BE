package com.likelion.spoonclass.domain.member;

import com.likelion.spoonclass.domain.BaseEntity;
import com.likelion.spoonclass.domain.attend.Attend;
import com.likelion.spoonclass.domain.univ.Univ;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Authority authority = Authority.USER;

    @OneToMany
    private List<Attend> attendList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    private Univ univ;
}
