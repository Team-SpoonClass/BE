package com.likelion.spoonclass.domain.univ;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnivRepository extends JpaRepository<Univ,Long> {
    Optional<Univ> findByName(String univ);
}
