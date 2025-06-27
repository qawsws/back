package org.zerock.tourist_springboot.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.zerock.tourist_springboot.board.domain.Board;

import java.util.List;

public interface BoardRepository
        extends JpaRepository<Board,Long>,
        BoardRepositoryCustom, BoardDslRepository {
}
