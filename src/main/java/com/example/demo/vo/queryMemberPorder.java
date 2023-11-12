package com.example.demo.vo;

import lombok.Data;

@Data
public class queryMemberPorder {
	private String porderNO;
	private String productNO;
	private String memberNO;
	private String productName;
	private Integer amount;
	private Integer productPrice;
	private Integer sum;
}
