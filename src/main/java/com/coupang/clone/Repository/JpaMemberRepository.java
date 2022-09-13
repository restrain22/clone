package com.coupang.clone.Repository;

import com.coupang.clone.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface JpaMemberRepository extends JpaRepository<Member,Long> {
}
