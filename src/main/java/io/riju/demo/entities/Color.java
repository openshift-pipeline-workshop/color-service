package io.riju.demo.entities;

import javax.persistence.Entity;

@Entity
public class Color {

    public String color;
    public String hexValue;
    
	public Color(String color) {
        this.color = color;

        switch(color){
            case "red":
                this.hexValue = "#E53E3E";
                break;
            case "green":
                this.hexValue = "#38A169";
                break;
            case "blue":
                this.hexValue = "#3182CE";
                break;
            case "yellow":
                this.hexValue = "#D69E2E";
                break;
            default:
                this.hexValue = "#FFFFFF";

        }
    }
}