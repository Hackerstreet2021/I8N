package com.realcoderz.controller;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.realcoderz.dto.ProductDto;
import com.realcoderz.model.Product;
import com.realcoderz.service.ProductService;
import com.realcoderz.utils.dto.DtoUtils;

@RequestMapping("/products")
@RestController
@CrossOrigin("*")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	
	
	@Autowired
	private ProductService productService;

	private static final DtoUtils<ProductDto, Product> PRODUCTS_DTO_UTILS = new DtoUtils<>(ProductDto.class,
			Product.class);

	@GetMapping("i18n/{id}")
	public ProductDto viewI18n(@PathVariable Long id) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		LOGGER.info("currentLocale [{}]", currentLocale);
		Product product = productService.findById(id);
		return PRODUCTS_DTO_UTILS.convertToDto(product);
	}

	@GetMapping
	public List<ProductDto> list() throws ParseException {
		LOGGER.info("Inside ProductController.list()");
		List<Product> productList = productService.findAll();
		List<ProductDto> productDtoList = new ArrayList<>();
		
		LOGGER.info("Converting model to DTO");
		for (Product p : productList)
			productDtoList.add(PRODUCTS_DTO_UTILS.convertToDto(p));

		for (ProductDto p : productDtoList) {
			double d = Double.parseDouble(p.getPrice());
			Locale currentLocale = LocaleContextHolder.getLocale();
			LOGGER.info("currentLocale [{}]", currentLocale);
			NumberFormat nf2 = NumberFormat.getInstance(LocaleContextHolder.getLocale());

			if (LocaleContextHolder.getLocale().equals(new Locale("hi"))) {
                double d1=Double.parseDouble(p.getPrice())*75;                
				Currency cur = Currency.getInstance(new Locale("hi", "IN"));
				p.setPrice(cur.getSymbol() + " " + nf2.format(d1));

			} 
			else if(LocaleContextHolder.getLocale().equals(new Locale("fr")) || LocaleContextHolder.getLocale().equals(new Locale("es")) ) {
				double d1=Double.parseDouble(p.getPrice())/1.134f;                
				Currency cur = Currency.getInstance(new Locale("fr", "FR"));
				p.setPrice(cur.getSymbol() + " " + nf2.format(d1));
			}
			
			else {

				Currency cur = Currency.getInstance(LocaleContextHolder.getLocale());
				p.setPrice(cur.getSymbol() + " " + nf2.format(d));

			}

			LOGGER.info("formatting date value according to a particular Locale");

			String date = showBothStyles(p.getCreateAt(), LocaleContextHolder.getLocale());
			p.setCreateAt(date);
		}

		return productDtoList;
	}

	@GetMapping("{id}")
	public Product view(@PathVariable Long id) {
		LOGGER.info("Returning product by ID");
		return productService.findById(id);
	}

	@RequestMapping(consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE }, produces = {
			MimeTypeUtils.APPLICATION_JSON_VALUE })
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product product) throws ParseException {
		LOGGER.info("Saving Product");		
		return productService.save(product);
	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Product edit(@RequestBody Product product, @PathVariable Long id) {
		LOGGER.info("Updating Product");
		Product productBD = productService.findById(id);
		productBD.setName(product.getName());
		productBD.setPrice(product.getPrice());
		return productService.save(productBD);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		LOGGER.info("Deleting  Product");
		productService.deleteById(id);
	}

	static public String showBothStyles(String dateInString, Locale currentLocale) throws ParseException {
		LOGGER.info("Formatting Date according to a particular Locale");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));		
		Date date = sdf.parse(dateInString);
		String result = null;
		DateFormat formatter;
		int[] styles = { DateFormat.DEFAULT };
		for (int k = 0; k < styles.length; k++) {
			formatter = DateFormat.getDateTimeInstance(styles[k], styles[k], currentLocale);
			result = formatter.format(date);
		}
		return result;
	}

}
