package org.example.web07_mvc.board;

import java.util.ArrayList;
import java.util.List;

public class BoardDAOimpl implements BoardDAO{
    @Override
    public int insert(BoardVO vo) {
        System.out.println("b_insert()...");
        System.out.println(vo);
        int flag = 0;
        flag = 1;
        return flag;
    }

    @Override
    public int update(BoardVO vo) {
        System.out.println("b_update()...");
        System.out.println(vo);
        int flag = 0;
        flag = 1;
        return flag;
    }

    @Override
    public int delete(BoardVO vo) {
        System.out.println("b_delete()...");
        System.out.println(vo);
        int flag = 0;
        flag = 1;
        return flag;
    }

    @Override
    public BoardVO selectOne(BoardVO vo) {
        System.out.println("b_selectOne()...");
        System.out.println(vo);
        BoardVO vo2 = null;

        vo2 = new BoardVO(vo.getNum(),"title","content","kim1","2025-02-1");

        return vo2;
    }

    @Override
    public List<BoardVO> selectAll() {
        System.out.println("b_selectAll()...");

        List<BoardVO> vos = new ArrayList<BoardVO>();
        for (int i = 0; i < 10; i++) {
            BoardVO vo = new BoardVO(1+i,"title"+(1+i),"content"+(1+i),"kim"+(1+i),"2025-02-1"+(1+i));
            vos.add(vo);

        }
        return vos;
    }

    @Override
    public List<BoardVO> searchList(String searchKey, String searchWord) {
        System.out.println("b_searchList()...");
        System.out.println(searchKey);
        System.out.println(searchWord);

        List<BoardVO> vos = new ArrayList<BoardVO>();
        for (int i = 0; i < 3; i++) {
            BoardVO vo = new BoardVO(1+i,"title"+(1+i),"content"+(1+i),"kim"+(1+i),"2025-02-1"+(1+i));
            vos.add(vo);
        }

        return vos;
    }
}
