package com.example.demo.vo;

import lombok.Data;

@Data
public class porder {
	private Integer id;
	private Integer porderNO;
	private String memberNO;
	private String productNO;
	private Integer amount;
	static Integer value=13;
	
	public void setPorderNO() {
		porderNO=value+1;
		value+=1;
	}
	
	
}
