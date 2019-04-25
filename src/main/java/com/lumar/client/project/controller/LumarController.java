package com.lumar.client.project.controller;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.lumar.client.project.models.data.Field;
import com.lumar.client.project.models.data.Type;
import com.lumar.client.project.models.view.DisplayTypeView;
import com.lumar.client.project.models.view.FieldView;
import com.lumar.client.project.services.BuildAProjectService;


@Controller
public class LumarController {

	private static final Logger logger = LoggerFactory.getLogger(LumarController.class);

	@Autowired
	private BuildAProjectService projectService;

	@Autowired
	Type type;
	
	@Autowired
	Field field;

	@RequestMapping("/home")
	public String home() {
		return "running Lumar client on  google cloud ";
	}

	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "Hello Tony");
		return "welcome";
	}
	
	@RequestMapping(value = "/type", method = RequestMethod.GET)
    public ModelAndView showTypeForm() {
        return new ModelAndView("typeHome", "type", new Type());
    }
	
	@RequestMapping(value = "/subType", method = RequestMethod.GET)
    public ModelAndView showSubTypeForm() {
        return new ModelAndView("subHomeType", "type", new Type());
    }
	
	@RequestMapping(value = "/field", method = RequestMethod.GET)
    public ModelAndView showFieldForm() {
        return new ModelAndView("fieldHome", "fieldView", new FieldView());
    }
	
	@RequestMapping(value = "/displayType", method = RequestMethod.GET)
    public ModelAndView showTypeSearchForm() {
        return new ModelAndView("displayType", "displayTypeView", new DisplayTypeView());
    }

	@RequestMapping(value = "/createType", method = RequestMethod.POST)
	public String submit(@Valid @ModelAttribute("type") Type type, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		logger.info("Creating project "+type.toString());
		projectService.buildAType(type);
		model.addAttribute("id", type.getId());
		model.addAttribute("Name", type.getName());
		return "buildTypeView";
	}
	
	@RequestMapping(value = "/createSubType", method = RequestMethod.POST)
	public String submitSub(@Valid @ModelAttribute("type") Type type, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		logger.info("Creating a subProject "+type.toString());
		projectService.buildASubType(type);
		model.addAttribute("parentId", type.getParentId());
		model.addAttribute("id", type.getId());
		model.addAttribute("Name", type.getName());
		return "buildTypeView";
	}
	
	@RequestMapping(value = "/createField", method = RequestMethod.POST)
	public String submit(@Valid @ModelAttribute("fieldView") FieldView fieldView, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		logger.info("Creating fields "+fieldView.toString());
		projectService.buildAField(fieldView);
		model.addAttribute("id", fieldView.getTypeId());
		model.addAttribute("Name", fieldView.getName());
		model.addAttribute("Primitive", fieldView.getPrimitive());
		model.addAttribute("Option", fieldView.getOptions());
		return "buildFieldView";
	}

	@RequestMapping(value = "/displayViewType", method = RequestMethod.POST)
	public ModelAndView submit(@Valid @ModelAttribute("displayTypeView") DisplayTypeView displayTypeView, BindingResult result, ModelMap model) throws URISyntaxException {
		logger.info("Display type for  "+displayTypeView.getTypeId());
		Type resp = projectService.displayType(displayTypeView.getTypeId());
		return new ModelAndView("displayTypeView", "Display", resp.toString());

	}

}
