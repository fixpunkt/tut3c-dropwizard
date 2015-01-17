package com.example.helloworld;

public enum Cell {
	
    EMPTY, X, O;
    
    public String toString() {
    	return this == EMPTY ? " " : name();
    };
}