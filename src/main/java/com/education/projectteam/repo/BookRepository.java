package com.education.projectteam.repo;
import com.education.projectteam.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
    Book findByName(String name);
}
