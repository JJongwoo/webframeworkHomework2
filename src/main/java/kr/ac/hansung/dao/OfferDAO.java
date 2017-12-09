package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;

@Repository // 이 클래스를 bean으로 등록하겠다
public class OfferDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired // 매개변수인 dataSource에 해당하는 bean을 연결
	public void setDataSource(DataSource dataSource) {
		
		jdbcTemplate = new JdbcTemplate(dataSource);// DAO가 사용하는 jdbc템플릿 이때 datasource를 인자로 넘김
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from grade";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	public Offer getOffer(String classcode) {
		String sqlStatement = "select * from grade where classcode=?";

		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { classcode },
				new RowMapper<Offer>() {
					@Override
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {//rs에는 레코드가 넘어온다.
						
						Offer offer = new Offer();
						offer.setYear(rs.getInt("year"));
						offer.setSemester(rs.getInt("semester"));
						offer.setClasscode(rs.getString("classcode"));
						offer.setClassname(rs.getString("classname"));
						offer.setType(rs.getString("type"));
						offer.setCredit(rs.getFloat("credit"));
						return offer;
					}
				}
		); // DB에서 읽은 resultset을 실제 객체에 매핑 시켜주는 객체
	}
	
	public List<Offer> getOffers() {
		String sqlStatement = "select * from grade";

		return jdbcTemplate.query(sqlStatement,
				new RowMapper<Offer>() {
					@Override
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Offer offer = new Offer();
						
						offer.setYear(rs.getInt("year"));
						offer.setSemester(rs.getInt("semester"));
						offer.setClasscode(rs.getString("classcode"));
						offer.setClassname(rs.getString("classname"));
						offer.setType(rs.getString("type"));
						offer.setCredit(rs.getFloat("credit"));
						
						return offer;
					}
				}
		); 
	}
	
	
	
	public boolean insert(Offer offer) {
		int year = 2018;
		int semester = 1;
		String classcode = offer.getClasscode();
		String classname = offer.getClassname();
		String type = offer.getType();
		float credit = offer.getCredit();
		
		String sqlStatement = "insert into grade (year, semester, classcode, classname, type, credit) "
							+ "values (?, ?, ?, ?, ?, ?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year,  semester, classcode, classname, type, credit})==1); //update�떆 紐뉕컻媛� �뾽�뜲�씠�듃 �릺�뿀�뒗吏� 媛쒖닔媛� �꽆�뼱�샂
	}

}
