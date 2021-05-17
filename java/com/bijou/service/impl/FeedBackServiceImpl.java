package com.bijou.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bijou.domain.FeedBack;
import com.bijou.domain.Product;
import com.bijou.domain.User;
import com.bijou.repository.FeedBackRepository;
import com.bijou.service.FeedBackService;

@Service
public class FeedBackServiceImpl implements FeedBackService {

	@Autowired
	private FeedBackRepository feedBackRepository;

	public synchronized FeedBack createFeedBack(User user, String textFeedBack, int rating) {

		FeedBack feedBack = new FeedBack();

		feedBack.setTextFeedBack(textFeedBack);
		feedBack.setRating(rating);
		feedBack.setUser(user);
		feedBack.setCreatedAt(Calendar.getInstance().getTime());

		feedBack = feedBackRepository.save(feedBack);

		return feedBack;
	}

	public List<FeedBack> findAll() {
		return (List<FeedBack>) feedBackRepository.findAll();
	}
	
	public FeedBack findByProduct(Product product) {
		
		return feedBackRepository.findByProduct(product);
		
	}

}

