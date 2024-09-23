package com.shop.espringshop.repository;

import com.shop.espringshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findByName(String name);

    @Query("SELECT c FROM Category c WHERE c.name=:levelCategoryName AND c.parentCategory.name=:parentCategoryName")
    public Category findByNameAndParent(@Param("levelCategoryName") String levelCategoryName, @Param("parentCategoryName") String parentCategoryName);
}
