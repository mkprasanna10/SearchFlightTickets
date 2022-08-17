package com.brownfield.pss.search.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brownfield.pss.search.entity.Flight;
import com.brownfield.pss.search.repository.FlightRepository;

@Service
public class SearchComponent 
{
	private FlightRepository flightrepo;

	private static final Logger logger = LoggerFactory.getLogger(SearchComponent.class);
	
	@Autowired
	public SearchComponent(FlightRepository flightrepo)
	{
		this.flightrepo = flightrepo;
	}

	public List<Flight> search(SearchQuery query)
	{
		System.out.println("Origin---->"+query.getOrigin());
		System.out.println("Destination--->"+query.getDestination());
		System.out.println("FlightDate---->"+query.getFlightDate());
		List<Flight> searchResult = flightrepo.findByOriginAndDestinationAndFlightDate(query.getOrigin(), query.getDestination(), query.getFlightDate());	
	
		System.out.println("Post Query");
		
		return searchResult.stream().filter(e -> e.getInventory().getCount() > 0).collect(Collectors.toList());	
	}	
	}
