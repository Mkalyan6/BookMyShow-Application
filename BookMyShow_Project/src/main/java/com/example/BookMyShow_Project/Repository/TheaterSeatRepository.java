package com.example.BookMyShow_Project.Repository;

import com.example.BookMyShow_Project.Models.TheaterSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatRepository extends JpaRepository<TheaterSeat,Integer> {
}
