package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class ApplicationController {
	
	@Autowired
	private ProducerController producerController = null;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model){
		return "index";
	}
	
	@RequestMapping(value = "/addProducer", method = RequestMethod.GET)
	public String addEmployee(ModelMap model){		
		producerController.addProducer();
		return "index";
	}
	
	@RequestMapping(value = "/stopAllProducers", method = RequestMethod.GET)
	public String stopAllProducers(ModelMap model){		
		producerController.stopAllProducers();
		return "index";
	}
}
