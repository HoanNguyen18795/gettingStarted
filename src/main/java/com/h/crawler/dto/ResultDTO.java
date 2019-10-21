package com.h.crawler.dto;

import java.util.List;

public class ResultDTO {
	private List<InDoorDetailDTO> data;
	
	private Long draw;
	
	private Long recordsTotal;
	
	private Long recordsFiltered;

	public List<InDoorDetailDTO> getData() {
		return data;
	}

	public void setData(List<InDoorDetailDTO> data) {
		this.data = data;
	}

	public Long getDraw() {
		return draw;
	}

	public void setDraw(Long draw) {
		this.draw = draw;
	}

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

}
