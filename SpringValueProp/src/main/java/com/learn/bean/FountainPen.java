package com.learn.bean;


public class FountainPen implements Pen{

	private Ink ink;
	
	// No argument constructor is important for setter injection
	public FountainPen() {
		
	}
	
	public FountainPen(Ink ink) {
		this.ink = ink;
	}
	@Override
	public void write() {
		System.out.println("Ink color "+ ink.getColor());

	}
	public Ink getInk() {
		return ink;
	}
	public void setInk(Ink ink) {
		this.ink = ink;
	}

}



