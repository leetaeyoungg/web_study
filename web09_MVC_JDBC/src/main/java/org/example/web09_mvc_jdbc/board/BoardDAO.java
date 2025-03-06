package org.example.web09_mvc_jdbc.board;

import java.util.List;

public interface BoardDAO {
    public int insert(BoardVO vo);
    public int update(BoardVO vo);
    public int delete(BoardVO vo);
    public BoardVO selectOne(BoardVO vo);
    public List<BoardVO> selectAll();
    List<BoardVO> searchList(String searchKey, String searchWord);
}
