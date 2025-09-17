package vn.iotstar.controllers.admin;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import vn.iotstar.entity.User;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.impl.UserService;



@Controller
@RequestMapping("admin/accounts")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/add")
	public String add(ModelMap model) { 
		UserModel user = new UserModel();
		model.addAttribute("user", user);
		
		return "admin/accounts/add";
	}
	
	@RequestMapping("")
	public String list(ModelMap model) {
	    List<User> list = userService.findAll();
	    model.addAttribute("users", list);
	    return "admin/accounts/list";
	}
	
	@PostMapping("/save")
	public ModelAndView saveOrUpdate(ModelMap model, 
			@Valid @ModelAttribute("user") UserModel userModel, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin/accounts/add");
		}
		User entity = new User();
		BeanUtils.copyProperties(userModel, entity);
		userService.save(entity);
		String message ="";
		if (userModel.getIsEdit()==true) {
			message="User is Edited!";
		}else {
			message="User is saved!";
		}
		model.addAttribute("message", message);
		return new ModelAndView("forward:/admin/accounts", model);
	}
	
	@GetMapping("delete/{userId}")
	public ModelAndView delet(ModelMap model, @PathVariable("userId") int userId) {
	    userService.deleteById(userId);
	    model.addAttribute("message", "User is deleted");
	    return new ModelAndView("redirect:/admin/accounts/searchpaginated", model);
	}

	@RequestMapping("search")
	public String search(ModelMap model, @RequestParam(name="name", required = false) String name) {
	    List<User> list = null;

	    if (StringUtils.hasText(name)) {
	        list = userService.findByUsernameContaining(name);
	        		
	    } else {
	        list = userService.findAll();
	    }

	    model.addAttribute("users", list);
	    return "admin/accounts/search";
	}

}
