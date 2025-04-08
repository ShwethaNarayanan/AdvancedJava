package com.learn.bean;

public class Writer {
	private Pen pen;
	
	public Writer() {
	}
	public Writer(Pen pen) {
		this.pen = pen;
	}

	public Pen getPen() {
		return pen;
	}

	public void setPen(Pen pen) {
		this.pen = pen;
	}

	public void write() {
		pen.write();
	}
}
