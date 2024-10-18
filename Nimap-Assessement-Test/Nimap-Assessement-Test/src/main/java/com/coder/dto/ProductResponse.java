package com.coder.dto;

import java.util.List;

import com.coder.model.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

	private List<Product> products;
	private long totalElements;
	private int totalPage;
	private Boolean isFirst;
	private Boolean isLast;
	private int pageNo;
	private int pageSize;

}
