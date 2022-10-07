package com.coupang.clone.Repository;

import com.coupang.clone.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCategoryRepository extends JpaRepository<Category,Long>,CategoryRepository {
}
