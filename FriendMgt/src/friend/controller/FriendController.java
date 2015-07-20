package friend.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import friend.model.DTOFriend;
import friend.service.FriendService;

@Controller
public class FriendController {

	@Autowired FriendService dao;
	
	 /**
	   * POST requests to http://localhost:8080/FriendMgt/addFriend goes here.
	   * The new person data is passed from HTML from and bound into the
	   * friend object.
	   */
	@RequestMapping (value="/addFriend" , method = RequestMethod.GET)
	public ModelAndView addFriendPage(){
		return new ModelAndView("AddFriend","friend",new DTOFriend());
	}
	

	@RequestMapping (value="/addFriend" , method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	
	public @ResponseBody DTOFriend addFriend(@RequestBody DTOFriend dtoFriend,final RedirectAttributes redirectAttributes){
		
		String message= "New Friend "+dtoFriend.getNAMES()+"was added!";
		redirectAttributes.addFlashAttribute("message", message);
		return dao.persist(dtoFriend);
	}
	
	
	@RequestMapping (value="/listFriends" , method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE 
			)
	@ResponseBody
	public List<DTOFriend> listFriend(){
		return dao.listFriend();
	}
	
	@RequestMapping(value="/listFriend", method = RequestMethod.GET)
	public ModelAndView listAllFriend(){
		ModelAndView mav=new ModelAndView("friend_list");
		List<DTOFriend> list=new ArrayList<>();
		list.addAll(listFriend());
		mav.addObject("friends", list);
		return mav;
	}
	
	
	@RequestMapping(value="/deleteFriend/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public DTOFriend deleteFriend(@PathVariable int id,final RedirectAttributes redirectAttribute){
		DTOFriend friend = dao.findFriend(id);
		String message= "a Friend "+friend.getNAMES()+"was deleted!";
		redirectAttribute.addFlashAttribute("message", message);
		return dao.delete(friend);
	}
	
	@RequestMapping(value="/updateFriend/{id}",method=RequestMethod.GET)
	public ModelAndView editFriendPage(@PathVariable int id){
		ModelAndView mav = new ModelAndView("EditFriend");
		DTOFriend friend= dao.findFriend(id);
		mav.addObject("friend",friend);
		return mav;
	}
	
	@RequestMapping(value="/updateFriend/{id}", method=RequestMethod.PUT, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public DTOFriend editFriend(@PathVariable Integer id,@RequestBody DTOFriend friend,final RedirectAttributes redirectAttributes){
		friend.setNUM(id);
		String message= "A Friend "+friend.getNAMES()+"was updated!";
		redirectAttributes.addFlashAttribute("message", message);
		return dao.update(friend);
	}
	
}
