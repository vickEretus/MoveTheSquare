package edu.ycp.cs320.movethesquare.model;

public class Game {
	public static final double MOVE_DIST = 2.0; // x/y distance square moves each tick 
	private double width, height;
	private Square square;
	private double squareDx;
	private double squareDy;
	
	private double radius;
	private Sphere sphere;
	private double sphereDx;
	private double sphereDy;
	public Game() {
		
	}
	
	public void setSphere(Sphere sphere) {
		this.sphere = sphere;
	}
	
	public Sphere getSphere() {
		return sphere;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	
	public void setSphereDx(double sphereDx) {
		this.sphereDx = sphereDx;
	}
	
	public double getSphereDx() {
		return sphereDx;
	}
	
	public void setSphereDy(double sphereDy) {
		this.sphereDy = sphereDy;
	}
	
	public double getSphereDy() {
		return sphereDy;
	}
	
	
	public void setSquare(Square square) {
		this.square = square;
	}
	
	public Square getSquare() {
		return square;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setSquareDx(double squareDx) {
		this.squareDx = squareDx;
	}
	
	public double getSquareDx() {
		return squareDx;
	}
	
	public void setSquareDy(double squareDy) {
		this.squareDy = squareDy;
	}
	
	public double getSquareDy() {
		return squareDy;
	}
}
