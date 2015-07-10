package friend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import friend.dao.DTOFriend;
import friend.service.FriendService;




@Controller
public class FriendController {

	@Autowired FriendService dao;
	 /**
	   * POST requests to http://localhost:8080/FriendMgt/addPerson goes here.
	   * The new person data is passed from HTML from and bound into the
	   * Person object.
	   */
	@RequestMapping (value="/addFriend" , method = RequestMethod.GET)
	public ModelAndView addFriend(){
		return new ModelAndView("AddFriend","friend",new DTOFriend());
	}
	
	@RequestMapping (value="/saveFriend" , method = RequestMethod.POST)
	public ModelAndView saveFriend(DTOFriend friend){
		dao.persist(friend);
		return new ModelAndView("friend_list","friends",dao.listFriend());
	}
	
}
