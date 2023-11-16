package com.Img.photon.saloon.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

	@GetMapping("/search-item")
	public String getSearchItem() {
		return "This is the search Item APPle";
	}
	// http://localhost:8092/api/v1/item/search-item
}
