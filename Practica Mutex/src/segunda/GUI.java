package segunda;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import segunda.ImageOperator;

public class GUI extends JFrame implements ActionListener, ItemListener, ChangeListener, MouseListener
{
	
	private static final long serialVersionUID = 1L;

	private char op;
	
	private BufferedImage i1, i2, i3;
	
	private JLabel img1, img2, img3;
	private JButton btn1, btn2, btn3, guardar;
	private JPanel jp;
	private JComboBox<String> cb1;
	private JSlider sli1;
	private JTextField te1, te2;
	
	public GUI()
	{
		super(""); 
		this.setBounds(10, 20, 600, 400);
		getContentPane().setLayout(null); 
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Se define la operacion de cierre, en este caso se termina el proceso (Aplicacion)
		jp = new JPanel();
		img1 = new JLabel();
		img2 = new JLabel();
		img3 = new JLabel();
		btn1 = new JButton("Ejecutar");
		btn2 = new JButton("Imagen 1");
		btn3 = new JButton("Imagen 2");
		sli1 = new JSlider(0, 1000, 500);
		te1 = new JTextField();
		te2 = new JTextField();
		cb1 = new JComboBox<String>();
		this.setContentPane(jp);
		jp.setBackground(Color.WHITE);
		jp.setLayout(null);
		jp.setOpaque(true);
		cb1.addItem("+");
		cb1.addItem("-");
		cb1.addItem("*");
		cb1.addItem("#");
		img1.setBounds(10, 10, 200, 100);
		img2.setBounds(375, 10, 200, 100);
		img3.setBounds(200, 150, 200, 100);
		btn1.setBounds(240, 300, 100, 25);
		btn2.setBounds(25, 150, 150, 25);
		btn3.setBounds(405, 150, 150, 25);
		cb1.setBounds(270, 100, 50, 25);
		sli1.setBounds(245, 50, 100, 15);
		te1.setBounds(200, 200, 45, 25);
		te2.setBounds(350, 200, 45, 25);
		btn1.setBackground(Color.white);
		btn1.setBorder(null);
		btn2.setBackground(Color.white);
		btn2.setBorder(null);
		btn3.setBackground(Color.white);
		btn3.setBorder(null);
		te1.setBackground(Color.white);
		te1.setBorder(null);
		te2.setBackground(Color.white);
		te2.setBorder(null);
		getContentPane().add(img1);
		getContentPane().add(img2);
		getContentPane().add(img3);
		getContentPane().add(btn1);
		getContentPane().add(btn2);
		getContentPane().add(btn3);
		getContentPane().add(cb1);
		getContentPane().add(te1);
		getContentPane().add(te2);
		btn1.addActionListener(this);
		btn1.addMouseListener(this);
		btn2.addActionListener(this);
		btn2.addMouseListener(this);
		btn3.addActionListener(this);
		btn3.addMouseListener(this);
		sli1.addChangeListener(this);
		cb1.addItemListener(this);
		op = cb1.getItemAt(0).toString().charAt(0);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(btn1))
		{
			if(i1 != null && i2 != null)
			{
				JFrame resultado = new JFrame("Resultado");
				resultado.setVisible(true);
				resultado.getContentPane().setLayout(null);
				resultado.setBounds(100, 100, 435, 300);
				JPanel jp2 = new JPanel();
				resultado.setContentPane(jp2);
				jp2.setBackground(new Color(Integer.parseInt("00BFFF", 16)));
				jp2.setLayout(null);
				jp2.setOpaque(true);
				JLabel rL = new JLabel();
				rL.setBounds(10, 10, 400, 200);
				resultado.getContentPane().add(rL);
				i3 = ImageOperator.imageProcessor(i1, i2, op, (sli1.getValue()/1000.0), Integer.parseInt(te1.getText().trim()), Integer.parseInt(te2.getText().trim()));
				rL.setIcon(ImageOperator.iconMaker(i3, rL.getWidth(), rL.getHeight()));
				guardar = new JButton("Guardar");
				guardar.setBounds(175, 225, 85, 20);
				resultado.getContentPane().add(guardar);
				guardar.addActionListener(this);
				guardar.addMouseListener(this);
			}
			else
				JOptionPane.showMessageDialog(this, "Cargue dos imagenes para poder continuar ^-^");
			
		}
		if(e.getSource().equals(btn2))
		{
			try 
			{
				i1 = ImageOperator.imagePicker();
				img1.setIcon(ImageOperator.iconMaker(i1, img3.getWidth(), img3.getHeight()));
			} 
			catch (IOException e1) 
			{
				JOptionPane.showMessageDialog(this, "Ha ocurrido un erroooooooooooooor :'c");
			}
		}
		if(e.getSource().equals(btn3))
		{
			try 
			{
				i2 = ImageOperator.imagePicker();
				img2.setIcon(ImageOperator.iconMaker(i2, img3.getWidth(), img3.getHeight()));
			} 
			catch (IOException e1) 
			{
				JOptionPane.showMessageDialog(this, "Ha ocurrido un erroooooooooooooor :'c");
			}
		}
		if(e.getSource().equals(guardar))
		{
			System.out.println("Holi");
			try 
			{
				ImageOperator.imageSaver(i3);
			} 
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
	}

	public void itemStateChanged(ItemEvent e) 
	{
		if(e.getSource().equals(cb1))
		{
			op = cb1.getSelectedItem().toString().charAt(0);
			if(op == '#')
				getContentPane().add(sli1);
			else
				this.remove(sli1);
			this.repaint();
		}
	}
	
	public void stateChanged(ChangeEvent e) 
	{	
		if(e.getSource().equals(cb1))
			op = cb1.getSelectedItem().toString().charAt(0);
	}
	
	public void mouseClicked(MouseEvent e) {
		
		
	}

	public void mousePressed(MouseEvent e) 
	{	
		if(e.getSource().equals(btn1)){
			btn1.setBackground(Color.white);
		}
		if(e.getSource().equals(btn2)){
			btn2.setBackground(Color.white);
		}
		if(e.getSource().equals(btn3)){
			btn3.setBackground(Color.white);
		}
		if(e.getSource().equals(guardar)){
			guardar.setBackground(Color.white);
		}
	}

	public void mouseReleased(MouseEvent e) 
	{
		if(e.getSource().equals(btn1)){
			btn1.setBackground(Color.lightGray);
		}
		if(e.getSource().equals(btn2)){
			btn2.setBackground(Color.lightGray);
		}
		if(e.getSource().equals(btn3)){
			btn3.setBackground(Color.lightGray);
		}
		if(e.getSource().equals(guardar)){
			guardar.setBackground(Color.lightGray);
		}
	}

	public void mouseEntered(MouseEvent e) 
	{
		if(e.getSource().equals(btn1)){
			btn1.setBackground(Color.lightGray);
		}
		if(e.getSource().equals(btn2)){
			btn2.setBackground(Color.lightGray);
		}
		if(e.getSource().equals(btn3)){
			btn3.setBackground(Color.lightGray);
		}
		if(e.getSource().equals(guardar)){
			guardar.setBackground(Color.lightGray);
		}
	}

	public void mouseExited(MouseEvent e) 
	{
		if(e.getSource().equals(btn1)){
			btn1.setBackground(Color.white);
		}
		if(e.getSource().equals(btn2)){
			btn2.setBackground(Color.white);
		}
		if(e.getSource().equals(btn3)){
			btn3.setBackground(Color.white);
		}
		if(e.getSource().equals(guardar)){
			guardar.setBackground(Color.white);
		}
	}
	
	public static void main(String[]args)
	{
		GUI g = new GUI();
		g.setVisible(true);
	}

	
}