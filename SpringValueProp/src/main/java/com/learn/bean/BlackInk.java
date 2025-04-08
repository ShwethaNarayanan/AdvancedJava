package com.learn.bean;

import org.springframework.beans.factory.annotation.Value;

public class BlackInk implements Ink {
@Value("${ink.color}")
private String color;
	public BlackInk() {
		
	}
public BlackInk(String color) {
		this.color = color;
	}
	@Override
	public String getColor() {
		return this.color;
	}

}
