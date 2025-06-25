package org.zerock.tourist_springboot.board.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.tourist_springboot.board.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Board b SET b.visitCount = b.visitCount+1 WHERE b.num=?1")
    void updateVisitCount(Long num);

}
