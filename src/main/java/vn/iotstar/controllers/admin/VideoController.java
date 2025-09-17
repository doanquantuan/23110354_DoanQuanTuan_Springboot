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
import vn.iotstar.entity.Video;
import vn.iotstar.models.VideoModel;
import vn.iotstar.services.impl.VideoServiceImpl;

@Controller
@RequestMapping("admin/videos")
public class VideoController {

	@Autowired
	VideoServiceImpl videoService;

	@GetMapping("/add")
	public String add(ModelMap model) { 
		VideoModel category = new VideoModel();
		model.addAttribute("category", category);
		return "admin/categories/add";
	}
	
	@RequestMapping("")
	public String list(ModelMap model) {
	    List<Video> list = videoService.findAll();
	    model.addAttribute("videos", list);
	    return "admin/videos/list";
	}
	
	@PostMapping("/save")
	public ModelAndView saveOrUpdate(ModelMap model, 
			@Valid @ModelAttribute("video") VideoModel videoModel, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin/videos/add");
		}
		Video entity = new Video();
		BeanUtils.copyProperties(videoModel, entity);
		
		videoService.save(entity);
		String message ="";
		if (videoModel.getIsEdit()==true) {
			message="Video is Edited!";
		}else {
			message="Video is saved!";
		}
		model.addAttribute("message", message);
		return new ModelAndView("forward:/admin/videos", model);
	}
	
	@GetMapping("delete/{videoId}")
	public ModelAndView delet(ModelMap model, @PathVariable("videoId") int videoId) {
	    videoService.deleteById(videoId);
	    model.addAttribute("message", "Video is deleted!!!!");
	    return new ModelAndView("redirect:/admin/videos/searchpaginated", model);
	}

	@RequestMapping("search")
	public String search(ModelMap model, @RequestParam(name="name", required = false) String name) {
	    List<Video> list = null;

	    if (StringUtils.hasText(name)) {
	        list = videoService.findByTitleContaining(name);
	    } else {
	        list = videoService.findAll();
	    }

	    model.addAttribute("titles", list);
	    return "admin/titless/search";
	}
}
