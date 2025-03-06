package org.example.web07_mvc.member;

import java.util.List;

public interface MemberDAO {

    public int insert(MemberVO vo);
    public int update(MemberVO vo);
    public int delete(MemberVO vo);
    public MemberVO selectOne(MemberVO vo);
    public List<MemberVO> selectAll();
    List<MemberVO> searchList(String searchKey, String searchWord);
}
