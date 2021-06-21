package com.rapstar.following.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rapstar.entity.Following;
import com.rapstar.following.service.FollowingService;

@Controller
@RequestMapping("/following")
public class FollowingController {

	@Resource
	private FollowingService followingService;
	
	/**
	 * ��ȡ����followings
	 * 
	 * @return
	 */
//	@RequestMapping("/getAllFollowings")
	public List<Following> getAllFollowings() {
		return followingService.getAllFollowings();
	}

	/**
	 * ����һ����¼
	 * 
	 * @param following
	 * @return
	 */
//	@RequestMapping("/addFollowing")
	public boolean addFollowing(@RequestParam("starId")int starId,@RequestParam("followerId")int followerId) {
		Following following = new Following(starId,followerId);
		return followingService.addFollowing(following);
	}

	/**
	 * �����ҵ�folowers
	 * 
	 * @param starId
	 * @return
	 */
//	@RequestMapping("/getFollowersById")
	public List<Following> getFollowersById(@RequestParam("starId")int starId) {
		return followingService.getFollowersById(starId+"");
	}

	/**
	 * �����ҵ�stars
	 * 
	 * @param starId
	 * @return
	 */
//	@RequestMapping("/getStarsById")
	public List<Following> getStarsById(@RequestParam("followerId")int followerId) {
		
		return followingService.getStarsById(followerId+"");
	}
	
	/**
	 * ȡ����ע
	 * 
	 * @param following
	 * @return
	 */
	public boolean dismissFollowing(@RequestParam("starId")int starId,@RequestParam("followerId")int followerId) {
		Following following = new Following(starId,followerId);
		return followingService.dismissFollowing(following);
	}
	
}
