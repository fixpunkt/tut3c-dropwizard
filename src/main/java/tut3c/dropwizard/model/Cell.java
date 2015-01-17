package tut3c.dropwizard.model;

public enum Cell {
	
    EMPTY, X, O;
    
    public String toString() {
    	return this == EMPTY ? " " : name();
    };
}