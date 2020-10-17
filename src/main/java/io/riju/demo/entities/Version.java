package io.riju.demo.entities;

import javax.persistence.Entity;

@Entity
public class Version {

    public String versionString;
    
	public Version(String versionString) {
        this.versionString = versionString;
    }
}