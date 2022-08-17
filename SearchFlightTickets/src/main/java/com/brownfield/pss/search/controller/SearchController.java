package com.brownfield.pss.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brownfield.pss.search.entity.Flight;
import com.brownfield.pss.search.service.SearchComponent;
import com.brownfield.pss.search.service.SearchQuery;

@RestController
@CrossOrigin
@RequestMapping("/search")
public class SearchController 
{
	private SearchComponent searchComponent;
	
	@Autowired
	public SearchController(SearchComponent searchComponent)
	{
		this.searchComponent = searchComponent;
	}
	
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public List<Flight> getFlightDetails(@RequestBody SearchQuery query)
	{
		return searchComponent.search(query);
	}
}
