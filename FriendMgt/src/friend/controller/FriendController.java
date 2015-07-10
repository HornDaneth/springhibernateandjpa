package friend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping (value="/addFriend" , method = RequestMethod.POST)
	public ModelAndView addFriend(@ModelAttribute DTOFriend friend,final RedirectAttributes redirectAttributes){
		ModelAndView mav= new ModelAndView();
		dao.persist(friend);
		String message= "New Friend "+friend.getNAMES()+"was added!";
		mav.setViewName("redirect:listFriend");
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping (value="/listFriend" , method = RequestMethod.GET)
	public ModelAndView saveFriend(DTOFriend friend,BindingResult result,ModelMap model){
		return new ModelAndView("friend_list","friends",dao.listFriend());
	}
	
	@RequestMapping(value="/deleteFriend/{id}",method=RequestMethod.GET)
	public ModelAndView deleteFriend(@PathVariable int id,final RedirectAttributes redirectAttribute){
		ModelAndView mav = new ModelAndView("redirect:../listFriend");
		
		DTOFriend friend = dao.findFriend(id);
		dao.delete(friend);
		String message= "a Friend "+friend.getNAMES()+"was deleted!";
		redirectAttribute.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value="/updateFriend/{id}",method=RequestMethod.GET)
	public ModelAndView editFriend(@PathVariable int id){
		ModelAndView mav = new ModelAndView("EditFriend");
		DTOFriend friend= dao.findFriend(id);
		mav.addObject("friend",friend);
		return mav;
	}
	
	@RequestMapping(value="/updateFriend/{id}",method=RequestMethod.POST)
	public ModelAndView editFriend(@PathVariable Integer id,@ModelAttribute DTOFriend friend,final RedirectAttributes redirectAttributes){
		ModelAndView mav= new ModelAndView();
		friend.setNUM(id);
		dao.update(friend);
		String message= "A Friend "+friend.getNAMES()+"was updated!";
		mav.setViewName("redirect:../listFriend");
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
}
