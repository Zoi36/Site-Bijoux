package com.bijou.service;

import java.util.List;

import com.bijou.domain.FeedBack;
import com.bijou.domain.Product;
import com.bijou.domain.User;

public interface FeedBackService {

	FeedBack createFeedBack(User user, String textFeedBack, int rating);

	List<FeedBack> findAll();

	FeedBack findByProduct(Product product);
}
