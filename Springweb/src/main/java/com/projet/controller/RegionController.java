package com.projet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.model.Region;
import com.projet.service.IRegionService;

@Controller
public class RegionController {
	
    private IRegionService regionService;
	
    public IRegionService getRegionService() {
		return regionService;
	}
    
    @Autowired(required=true)
    @Qualifier(value="regionService")
	public void setRegionService(IRegionService regionService) {
		this.regionService = regionService;
	}

    @RequestMapping(value="/pageRegions", method = RequestMethod.GET)
    public String recupererListeRegions(ModelMap map) {
    	List<Region> listeRegions = regionService.recupererListeRegions();
        map.addAttribute("listRegions", listeRegions);
        return "pageRegions";
    }
}



