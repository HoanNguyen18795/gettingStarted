package com.h.crawler.controller.admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.h.crawler.dto.InDoorDetailDTO;
import com.h.crawler.dto.ResultDTO;
import com.h.crawler.repository.outdoor.IndoorRepository;
import com.h.crawler.util.Constants;

@RestController
public class RestIndex {

	@Autowired
	private IndoorRepository indoorRepository;
	
    @RequestMapping("/getIndoorList")
    public ResultDTO getIndoorList(@RequestParam Long draw, @RequestParam Long start, @RequestParam Long length, @RequestParam(value = "indoorId", required=false) Long indoorId) {
        ResultDTO result = new ResultDTO();
        DateFormat format = new SimpleDateFormat(Constants.DD_MM_YYYY);
        List<InDoorDetailDTO> indoorDetailList = indoorRepository.getIndoorDetaiList(indoorId, null, start, length);
        if(CollectionUtils.isEmpty(indoorDetailList)) {
        	indoorDetailList = new ArrayList<InDoorDetailDTO>();
        	InDoorDetailDTO emptyData = new InDoorDetailDTO();
        	indoorDetailList.add(emptyData);
        } else {
        	indoorDetailList.forEach(element -> {
            	String ddmmyyyy = format.format(element.getDay());
            	element.setDayToString(ddmmyyyy);
            });
        }
        
        result.setData(indoorDetailList);
        Long totalRecords = indoorRepository.countIndoorDetailListById(indoorId);
        result.setDraw(draw);
        result.setRecordsTotal(totalRecords);
        result.setRecordsFiltered(totalRecords);
        return result;
    }
}
