package com.plass.traveling.domain.member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByPhone(String phone);

    Boolean existsByPhone(String phone);

}
