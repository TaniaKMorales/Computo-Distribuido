package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.Color;

import code.*;
import codigo.BufferLimitado;
import codigo.Consumidor;
import codigo.Productor;
import monte_carlo.Punto;

public class MainWindow {

	private JFrame frmProductorconsumidorgui;
	MyCanvas canvas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmProductorconsumidorgui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProductorconsumidorgui = new JFrame();
		frmProductorconsumidorgui.setTitle("Productor-Consumidor_GUI");
		frmProductorconsumidorgui.setBounds(100, 100, 551, 610);
		frmProductorconsumidorgui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProductorconsumidorgui.getContentPane().setLayout(null);
		
		JSpinner n_consumos = new JSpinner();
		n_consumos.setBounds(19, 38, 166, 26);
		n_consumos.setValue(8);
		frmProductorconsumidorgui.getContentPane().add(n_consumos);
		
		JLabel lblNewLabel = new JLabel("No. artículos a consumir");
		lblNewLabel.setBounds(19, 17, 166, 16);
		frmProductorconsumidorgui.getContentPane().add(lblNewLabel);
		
		JLabel lblNoArtculosA = new JLabel("No. artículos a producir");
		lblNoArtculosA.setBounds(19, 76, 166, 16);
		frmProductorconsumidorgui.getContentPane().add(lblNoArtculosA);
		
		JSpinner n_productos = new JSpinner();
		n_productos.setValue(10);
		n_productos.setBounds(19, 97, 166, 26);
		frmProductorconsumidorgui.getContentPane().add(n_productos);
		
		JLabel lblTiempoDeProduccin = new JLabel("Tiempo de consumo");
		lblTiempoDeProduccin.setBounds(197, 17, 166, 16);
		frmProductorconsumidorgui.getContentPane().add(lblTiempoDeProduccin);
		
		JSpinner t_consumo = new JSpinner();
		t_consumo.setValue(200);
		t_consumo.setBounds(197, 38, 166, 26);
		frmProductorconsumidorgui.getContentPane().add(t_consumo);
		
		JLabel lblTiempoDeProduccin_1 = new JLabel("Tiempo de producción");
		lblTiempoDeProduccin_1.setBounds(197, 76, 166, 16);
		frmProductorconsumidorgui.getContentPane().add(lblTiempoDeProduccin_1);
		
		JSpinner t_produccion = new JSpinner();
		t_produccion.setValue(200);
		t_produccion.setBounds(197, 97, 166, 26);
		frmProductorconsumidorgui.getContentPane().add(t_produccion);
		
		canvas = new MyCanvas();
		canvas.setBackground(Color.GRAY);
		canvas.setBounds(19, 152, 500, 410);
		frmProductorconsumidorgui.getContentPane().add(canvas);
		
		
		JButton btn_iniciar = new JButton("Iniciar");
		btn_iniciar.setBounds(386, 29, 141, 47);
		frmProductorconsumidorgui.getContentPane().add(btn_iniciar);
		btn_iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferLimitado buffer = new BufferLimitado(canvas);
				Productor productor = new Productor( buffer, (Integer)n_productos.getValue(), (Integer)t_produccion.getValue(), canvas );
				Consumidor consumidor = new Consumidor( buffer, (Integer)n_consumos.getValue(), (Integer)t_consumo.getValue(), canvas);
			}
		});
		
		
		JButton btn_parar = new JButton("Reiniciar");
		btn_parar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.productorActivo = false;
				canvas.consumidorActivo = false;
				canvas.globalActivo = false;
				canvas.cableProductorActivo = false;
				canvas.cableConsumidorActivo = false;
				canvas.slotProductorActivo = false;
				canvas.slotConsumidorActivo = false;
				canvas.capacidadBuffer = 10;
				canvas.nProductosBuffer = 0;
				canvas.repaint();
			}
		});
		btn_parar.setBounds(386, 76, 141, 47);
		frmProductorconsumidorgui.getContentPane().add(btn_parar);
		
		
		
	}
}