package com.rapstar.keyword.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rapstar.entity.KeyWord;
import com.rapstar.keyword.dao.KeywordDao;
import com.rapstar.util.Page;

@Service
@Transactional(readOnly = false)
public class KeywordService {
	@Resource
	private KeywordDao keywordDao;
	
	public List<KeyWord> listByPage() {
		List<KeyWord> words = new ArrayList<>();		
		int count = keywordDao.countByPage();
		words = keywordDao.findAll();
		
		return words;
	}

}
