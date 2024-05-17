package com.plass.traveling.domain.trap.repository;

import com.plass.traveling.domain.trap.entity.Trap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrapRepository extends JpaRepository<Trap, Long> {
}
