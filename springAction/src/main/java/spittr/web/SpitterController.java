package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.data.Spitter;
import spittr.data.SpittleRepository;

import javax.validation.Valid;

/**
 * @author mingchengtianxia
 * @date 2022/5/18--20:09
 */

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	public SpittleRepository repository;

	@Autowired
	public SpitterController(SpittleRepository repository){
		this.repository = repository;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterForm(){
		return "registerForm";
	}

	//获取表单数据
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String processRegistration(@Valid Spitter spitter, Errors errors){
		if(errors.hasErrors()){
			return "registerForm";
		}
		repository.save(spitter);
		return "redirect:/spitter/"+spitter.getUsername();
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String findName(@PathVariable("username") String username, Model model){
		model.addAttribute(repository.findByUsername(username));
		return "profile";
	}

}
