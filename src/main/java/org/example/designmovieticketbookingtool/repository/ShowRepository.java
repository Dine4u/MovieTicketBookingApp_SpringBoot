package org.example.designmovieticketbookingtool.repository;

import org.example.designmovieticketbookingtool.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {
}
