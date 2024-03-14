package com.example.abbs.service;

import java.util.List;

import com.example.abbs.entity.Anniversary;

public interface AnniversaryService {
	
	List<Anniversary> getAnnivListByDay(String uid, String sdate);
	
	List<Anniversary> getAnnivList(String uid, String startDay, String endDay); // 기념일 하루 Or 기간
	
	void insertAnniv(Anniversary anniv);
	
	
}
