package com.h.crawler.repository.outdoor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h.crawler.dto.InDoorDTO;
import com.h.crawler.dto.OutDoorDTO;
import com.h.crawler.repository.BaseDAOCustom;

@Repository
@Transactional
public class IndoorRepository extends BaseDAOCustom{
	
	public List<OutDoorDTO> getOutDoorList() {
		String sql = "SELECT " + 
					 "  ID as id," + 
					 "  NAME as name " + 
					 "FROM " + 
					 " OUT_DOOR";
		Query query = entityManager.createNativeQuery(sql);
		List<OutDoorDTO> result = new ArrayList<OutDoorDTO>();
		OutDoorDTO outDoorDTO;
		List<Object[][]> queryResult = query.getResultList();
		for(Object[] object : queryResult) {
			outDoorDTO = new OutDoorDTO();
			Long id = ((BigDecimal)object[0]).longValue();
			outDoorDTO.setIndoorList(getInDoorList(id));
			outDoorDTO.setId(id);
			outDoorDTO.setName((String)object[1]);
			result.add(outDoorDTO);
		}
		return result;
	}
	
	public List<InDoorDTO> getInDoorList(Long outDoorId) {
		String sql = "SELECT " + 
					" ID, " + 
					" IP_ADDRESS, " + 
					" NAME " + 
					"FROM " + 
					" IN_DOOR " + 
					"WHERE " + 
					" OUT_DOOR_ID = :outDoorId";
		Query query = entityManager.createNativeQuery(sql);
		List<InDoorDTO> result = new ArrayList<InDoorDTO>();
		InDoorDTO inDoorDTO;
		List<Object[][]> queryResult = query.getResultList();
		for(Object[] object : queryResult) {
			inDoorDTO = new InDoorDTO();
			Long id = ((BigDecimal)object[0]).longValue();
			inDoorDTO.setId(id);
			inDoorDTO.setIpAddress((String)object[1]);
			inDoorDTO.setName((String)object[2]);
			result.add(inDoorDTO);
		}
		return result;
	}
}
