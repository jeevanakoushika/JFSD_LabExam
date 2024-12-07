package com.klef.jfsd.exam.labExam;

import javax.persistence.Entity;

@Entity
public class Tablet extends Device {

	
	private String screenSize;
    private int batteryLife;
	public String getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}
	public int getBatteryLife() {
		return batteryLife;
	}
	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}
}
