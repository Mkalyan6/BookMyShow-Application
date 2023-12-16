package com.example.BookMyShow_Project.Repository;

import com.example.BookMyShow_Project.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer> {
}
