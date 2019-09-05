package com.kosta.board.dao;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Controller;

import com.kosta.board.dto.BDto;
import com.kosta.board.utilConn.ConnectionUtil;

@Controller
public class BDao implements IBDao {

	// DataSource dataSource;
	private JdbcTemplate jdbcTemplate;  // DML 명령어처리 

	/*
	 * @Autowired public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	 * this.jdbcTemplate = jdbcTemplate;
	 * ConnectionUtil.jdbcTemplate=this.jdbcTemplate; }
	 */

	public BDao() {
		this.jdbcTemplate = ConnectionUtil.jdbcTemplate;
	}

	public BDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		ConnectionUtil.jdbcTemplate = this.jdbcTemplate;
	}

	@Override
	public List<BDto> list() {

		String sql = "select bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent, bDate"
				+ " from mvc_board order by bGroup desc, bStep asc";
														// select
		List<BDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<BDto>(BDto.class));

		return list;

	}// list()

	@Override
	public void write(String bName, String bTitle, String bContent) {
				//insert, update, delete 
		this.jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String sql = "insert into mvc_board (bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent, bdate) "
						+ " values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0, sysdate)";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);

				return pstmt;
			}
		});

	}

	@Override
	public BDto contentView(String bId) {
		updateReadCount(bId);
		String sql = "select * from mvc_board where bId=" + bId;
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

	@Override
	public void updateReadCount(String bId) {
		String sql = "update mvc_board set bHit = bHit+1 where bId= ?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, Integer.parseInt(bId));
			}
		});
	}

	@Override
	public void modify(String bId, String bName, String bTitle, String bContent) {
		String sql = "update mvc_board set bName=?, bTitle=?, bContent=? where bId=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				pstmt.setInt(4, Integer.parseInt(bId));
			}
		});

	}

	@Override
	public void delete(String bId) {
		String sql = "delete from mvc_board where bid=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, Integer.parseInt(bId));
			}
		});
	}

	@Override
	public BDto reply_view(String bId) {
		String query = "select * from mvc_board where bId = " + bId;
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	} // reply_view() end
	
	@Override
	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent) {

		replyShape(bGroup, bStep);

		String sql = "insert into mvc_board (bId, bName, bTitle, bContent, "
				+ " bGroup, bStep, bIndent, bHit, bDate) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?, 0, sysdate)";

		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bGroup));
				ps.setInt(5, Integer.parseInt(bStep) + 1);
				ps.setInt(6, Integer.parseInt(bIndent) + 1);
			}
		});
	} // reply() end

	@Override
	public void replyShape(String bGroup, String bStep) {
		String sql = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ? ";
		/*
		 * String sql =
		 * "update mvc_board set bGroup = bGroup + 1 where bGroup = ? and bStep > ? "
		 * ;
		 */

		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bGroup);
				ps.setString(2, bStep);

				/*
				 * ps.setInt(1, Integer.parseInt(bGroup)); ps.setInt(2,
				 * Integer.parseInt(bStep));
				 */
			}
		});
	} // replyShape() end

}
