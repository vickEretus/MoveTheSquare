package edu.ycp.cs320.movethesquare.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import edu.ycp.cs320.movethesquare.controllers.GameController;
import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Square;
import edu.ycp.cs320.movethesquare.model.Sphere;


public class GameView extends JPanel {
	private static final Color MIDNIGHT_BLUE = new Color(25, 25, 112);
	private static final Color MIDNIGHT_GREEN = new Color(25, 125, 12);

	
	private Game model;
	private GameController controller;
	private Timer timer;
	
	public GameView(Game model) {
		this.model = model;
		setPreferredSize(new Dimension((int) model.getWidth(), (int)model.getHeight()));
		setBackground(MIDNIGHT_GREEN);

		// djh2-KEC119-21: changed from 30 to 45
		// djh2-YCPlaptop: change from 45 to 100
		this.timer = new Timer(1000 / 100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				handleTimerTick();
			}
		});
	}
	
	public void setController(GameController controller) {
		this.controller = controller;
	}
	
	public void startAnimation() {
		timer.start();
	}

	protected void handleTimerTick() {
		if (controller == null) {
			return;
		}
		Square square = model.getSquare();
		Sphere sphere = model.getSphere();
		Point mouseLoc = getMousePosition();
		if (mouseLoc != null) {
			controller.computeSquareMoveDirection(model, square, mouseLoc.getX(), mouseLoc.getY());
			controller.computeSphereMoveDirection(model, sphere, mouseLoc.getX(), mouseLoc.getY());
		}
		controller.moveSquare(model, square);
		controller.moveSphere(model, sphere);
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // paint background
		
		// djh2-KEC110-21: changed from GREEN to RED
		// djh2-YCPlaptop: change from RED to YELLOW
		g.setColor(Color.YELLOW);

		Square square = model.getSquare();
		
		g.fillRect((int) square.getX(), (int) square.getY(), (int) square.getWidth(), (int) square.getHeight());
		
		g.setColor(Color.BLACK);

		Sphere sphere = model.getSphere();
		

		g.fillOval( (int)sphere.getX(),(int) sphere.getY(),(int) sphere.getRadius(),(int) sphere.getRadius());
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Game model = new Game();
				model.setWidth(640.0);
				model.setHeight(480.0);
				
				Square square = new Square();
				square.setX(300.0);
				square.setY(220.0);
				square.setWidth(4.0);
				square.setHeight(40.0);
				model.setSquare(square);
				
				Sphere sphere = new Sphere();
				sphere.setX(150.0);
				sphere.setY(450.0);
				sphere.setRadius(55.0);
				model.setSphere(sphere);
				
				GameController controller = new GameController();
				
				GameView view = new GameView(model);
				view.setController(controller);
				
				JFrame frame = new JFrame("Move the Square!");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(view);
				frame.pack();
				frame.setVisible(true);
				
				view.startAnimation();
			}
		});
	}
}
