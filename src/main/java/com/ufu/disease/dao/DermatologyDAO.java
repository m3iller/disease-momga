package com.ufu.disease.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ufu.disease.to.Chromossomo;

public class DermatologyDAO {

	
	public List<Chromossomo> searchDermtology(Integer top, Integer claz) {

		try {
			List<Chromossomo> listDerm = new ArrayList<Chromossomo>();

			StringBuilder sq = new StringBuilder();
			sq.append(" select * from tb_dermatology ");
			if(top != null && claz != null) {
				sq.append(String.format(" where class_disease = %d", claz));
				sq.append(String.format(" limit %d", top));
			}
			mountSql(listDerm, sq);

			return listDerm;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Chromossomo> searchDermtologyNotIn(Integer claz,List<Chromossomo> listChromoSearched) {

		String notin = convertListToIns(listChromoSearched);
		
		try {
			List<Chromossomo> listDerm = new ArrayList<Chromossomo>();

			StringBuilder sq = new StringBuilder();
			sq.append(" select * from tb_dermatology ");
			sq.append(String.format(" where class_disease = %d and idDermatology not in (%s)",claz, notin));
			mountSql(listDerm, sq);

			return listDerm;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void mountSql(List<Chromossomo> listDerm, StringBuilder sq)
			throws SQLException {
		Connection con = ConnectionUtil.connect();
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sq.toString());

		while (rs.next()) {

			Chromossomo d = new Chromossomo();

			d.setIdDermatology(rs.getInt(1));
			d.getErythema().setValue(rs.getInt(2));
			d.getScaling().setValue(rs.getInt(3));
			d.getDefiniteBorders().setValue(rs.getInt(4));
			d.getItching().setValue(rs.getInt(5));
			d.getKoebnerPhenomenon().setValue(rs.getInt(6));
			d.getPolygonalPapules().setValue(rs.getInt(7));
			d.getFollicularPapules().setValue(rs.getInt(8));
			d.getOralMucosalInvolvement().setValue(rs.getInt(9));
			d.getKneeElbowInvolvement().setValue(rs.getInt(10));
			d.getScalpInvolvement().setValue(rs.getInt(11));
			d.getFamilyHistory().setValue(rs.getInt(12));
			d.getMelaninIncontinence().setValue(rs.getInt(13));
			d.getEosinophils().setValue(rs.getInt(14));
			d.getPnlInfiltrate().setValue(rs.getInt(15));
			d.getFibrosis().setValue(rs.getInt(16));
			d.getExocytosis().setValue(rs.getInt(17));
			d.getAcanthosis().setValue(rs.getInt(18));
			d.getHyperkeratosis().setValue(rs.getInt(19));
			d.getParakeratosis().setValue(rs.getInt(20));
			d.getClubbing().setValue(rs.getInt(21));
			d.getElongation().setValue(rs.getInt(22));
			d.getThinning().setValue(rs.getInt(23));
			d.getSpongiform().setValue(rs.getInt(24));
			d.getMunroIcroabcess().setValue(rs.getInt(25));
			d.getFocalHypergranulosis().setValue(rs.getInt(26));
			d.getDisappearance().setValue(rs.getInt(27));
			d.getVacuolisation().setValue(rs.getInt(28));
			d.getSpongiosis().setValue(rs.getInt(29));
			d.getSawYooth().setValue(rs.getInt(30));
			d.getFollicular().setValue(rs.getInt(31));
			d.getPerifollicular().setValue(rs.getInt(32));
			d.getInflammatory().setValue(rs.getInt(33));
			d.getBandLike().setValue(rs.getInt(34));
			d.getAge().setValue(rs.getInt(35));
			d.getClassDisease().setValue(rs.getInt(36));

			listDerm.add(d);
		}
	}
	
	
	public String convertListToIns(List<Chromossomo> chromos) {
		StringBuilder sq = new StringBuilder();

		for(Chromossomo c:chromos) {
			sq.append(c.getIdDermatology()+",");
		}
		sq.setLength(sq.length() - 1);
		
		return sq.toString();
	}

}
