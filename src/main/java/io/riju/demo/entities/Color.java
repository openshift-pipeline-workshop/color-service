package io.riju.demo.entities;

import javax.persistence.Entity;

@Entity
public class Color {

    public String color;
    public String hexValue;
    
	public Color(String color, String hexValue) {
        this.color = color;
        this.hexValue = hexValue;
    }
}