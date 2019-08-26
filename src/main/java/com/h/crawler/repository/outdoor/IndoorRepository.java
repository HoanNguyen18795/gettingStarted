package com.h.crawler.repository.outdoor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.h.crawler.dto.InDoorDTO;
import com.h.crawler.dto.InDoorDetailDTO;
import com.h.crawler.dto.OutDoorDTO;
import com.h.crawler.repository.BaseDAOCustom;

@Repository
@Transactional
public class IndoorRepository extends BaseDAOCustom {

	public List<OutDoorDTO> getOutDoorList() {
		String sql = "SELECT " + "  ID as id," + "  NAME as name " + "FROM " + " OUT_DOOR";
		Query query = entityManager.createNativeQuery(sql);
		List<OutDoorDTO> result = new ArrayList<OutDoorDTO>();
		OutDoorDTO outDoorDTO;
		List<Object[][]> queryResult = query.getResultList();
		for (Object[] object : queryResult) {
			outDoorDTO = new OutDoorDTO();
			Long id = ((BigDecimal) object[0]).longValue();
			outDoorDTO.setIndoorList(getInDoorList(id));
			outDoorDTO.setId(id);
			outDoorDTO.setName((String) object[1]);
			result.add(outDoorDTO);
		}
		return result;
	}

	public List<InDoorDTO> getInDoorList(Long outDoorId) {
		String sql = "SELECT " + " ID, " + " IP_ADDRESS, " + " NAME " + "FROM " + " IN_DOOR " + "WHERE "
				+ " OUT_DOOR_ID = :outDoorId";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter("outDoorId", outDoorId);
		List<InDoorDTO> result = new ArrayList<InDoorDTO>();
		InDoorDTO inDoorDTO;
		List<Object[][]> queryResult = query.getResultList();
		for (Object[] object : queryResult) {
			inDoorDTO = new InDoorDTO();
			Long id = ((BigDecimal) object[0]).longValue();
			inDoorDTO.setId(id);
			inDoorDTO.setIpAddress((String) object[1]);
			inDoorDTO.setName((String) object[2]);
			result.add(inDoorDTO);
		}
		return result;
	}

	public List<InDoorDetailDTO> getIndoorDetaiList(Long indoorId, Date operationDate, Long start, Long maxResult) {
		StringBuilder sqlString = new StringBuilder();
		sqlString.append(" SELECT ");
		sqlString.append("  indoor.IP_ADDRESS, ");
		sqlString.append("  indoorDetail.COST_PER_DAY, ");
		sqlString.append("  indoorDetail.DAY, ");
		sqlString.append("  indoorDetail.POWER_CONSUMTION_PER_DAY, ");
		sqlString.append("  indoorDetail.TIME_IN_USE,");
		sqlString.append("  indoorDetail.STATUS ");
		sqlString.append(" FROM ");
		sqlString.append(" IN_DOOR_DETAIL indoorDetail ");
		sqlString.append(" INNER JOIN ");
		sqlString.append("  IN_DOOR indoor ");
		sqlString.append(" ON ");
		sqlString.append("  indoorDetail.IN_DOOR_ID = indoor.ID ");
		if(indoorId != null) {
			sqlString.append(" WHERE ");
			sqlString.append("  indoor.ID = :indoorId " );
		}
		sqlString.append(" ORDER BY indoorDetail.DAY DESC ");
		
		Query query = entityManager.createNativeQuery(sqlString.toString());
		if(indoorId != null) {
			query.setParameter("indoorId", indoorId);
		}
		
		query.setFirstResult(start.intValue());
		query.setMaxResults(maxResult.intValue());
		List<InDoorDetailDTO> indoorDetailList = new ArrayList<InDoorDetailDTO>();
		InDoorDetailDTO detailDTO = null;
		List<Object[][]> queryResult = query.getResultList();
		for(Object[] object : queryResult) {
			detailDTO = new InDoorDetailDTO();
			detailDTO.setIpAddress((String)object[0]);
			detailDTO.setCostPerDay((BigDecimal)object[1]);
			detailDTO.setDay((Date)object[2]);
			detailDTO.setPowerConsumtionPerDay(((BigDecimal)object[3]).longValue());
			detailDTO.setTimeInUse(((BigDecimal)object[4]).longValue());
			detailDTO.setStatus(((BigDecimal)object[5]).longValue());
			indoorDetailList.add(detailDTO);
		}
		return !CollectionUtils.isEmpty(indoorDetailList)? indoorDetailList : null;
	}

	public Long countIndoorDetailListById(Long indoorId) {
		StringBuilder sqlString = new StringBuilder();
		sqlString.append("SELECT count(1) FROM  IN_DOOR_DETAIL ");
		if(indoorId != null) {
			sqlString.append("where IN_DOOR_ID =:indoorId");
		}
		
		Query query = entityManager.createNativeQuery(sqlString.toString());
		if(indoorId != null) {
			query.setParameter("indoorId", indoorId);
		}

		return ((BigDecimal) query.getSingleResult()).longValue();
	}
}
