package com.realcoderz.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse {
	
	private String header;
	private String loggedInUsername;
	private String logoutButton;
	private String productHeader;
	private String addProduct;
	
	private String productId;
	private String productName;
	private String price;
	private String dateAdded;
	private String measurement;
	private String images;
	private String actions;	
	private String update;
	private String view;
	private String delete;
	private String footer;
	private String df;
	
	
	private String save;
	private String cancel;
	
}
