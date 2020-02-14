package de.limago.atom.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import de.limago.atom.services.TryService;

@RestController
@RequestMapping("/demo")
public class DemoAtomFeedController {
	
	private TryService tryService;
	
	public DemoAtomFeedController(TryService tryService) {
		this.tryService = tryService;
	}
	
	@RequestMapping(value = "/feed", produces = "application/atom+xml")
	public ModelAndView orderFeed(WebRequest webRequest) {
		return new ModelAndView(new DemoAtomFeedModelAndView(tryService));
	}

}
