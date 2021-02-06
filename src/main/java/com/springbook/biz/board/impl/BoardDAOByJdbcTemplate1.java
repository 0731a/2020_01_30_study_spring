package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

// Spring JDBC ��� , JdbcDaoSupport�� ����Ͽ� getJbcTemplate()�� ���� JdbcTemplate ��ü�� �̿��ϴ� ��� 
@Repository("boardDAOByJdbcTemplate1")
public class BoardDAOByJdbcTemplate1 extends JdbcDaoSupport {
	// SQL ���ɾ�� 
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=? content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	@Autowired
	public void setSupterDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	// CRUD ����� �޼ҵ� ����
	// �� ��� 
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� insertBoard() ��� ó��");
		getJdbcTemplate().update(BOARD_INSERT,vo.getTitle(),vo.getWriter(),vo.getContent());
	}
		
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� updateBoard() ��� ó��");
		getJdbcTemplate().update(BOARD_UPDATE,vo.getTitle(),vo.getContent(),vo.getSeq());
	}
		
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� deleteBoard() ��� ó��");
		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	}
		
	// �� �� ��ȸ 
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� getBoard() ��� ó��");
		Object[] args = {vo.getSeq()};
		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
			
	}
		
	// �� ��� ��ȸ
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC�� getBoardList() ��� ó��");
		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());	
	}
}

class BoardRowMapper implements RowMapper<BoardVO>{
	public BoardVO mapRow(ResultSet rs,int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));
		return board;
	}
}