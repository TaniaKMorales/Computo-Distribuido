package segunda;


import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JLabel;

import segunda.Chunk;

public class ImageOperator
{
	
	public ImageOperator()
	{
		
	}
	
	public static BufferedImage imagePicker() throws IOException
	{
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("Imagenes JPG", "jpg"));
		int val = fc.showOpenDialog(null);
		if(val == fc.APPROVE_OPTION)
			return ImageIO.read(ImageIO.createImageInputStream(new FileInputStream(fc.getSelectedFile().getPath())));
		else
			return null;
	}
	
	public static void imageSaver(BufferedImage img) throws IOException
	{
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("Imagenes JPG", "jpg"));
		int val = fc.showSaveDialog(null);
		if(val == fc.APPROVE_OPTION)
		{
			ImageIO.write(img,"jpg",new File(fc.getSelectedFile().getPath() + ".jpg"));
			JOptionPane.showMessageDialog(null, "Se ha guardado: " + fc.getSelectedFile().getAbsolutePath() );
		}
	}
	
	public static ImageIcon iconMaker(BufferedImage imagen1, int w, int h)
	{
		return new ImageIcon(imagen1.getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}
	
	public static int resultWidth(BufferedImage imagen1, BufferedImage imagen2)
	{
		if(imagen1.getWidth() <= imagen2.getWidth())
			return imagen1.getWidth();
		else
			return imagen2.getWidth();
	}
	
	public static int resultHeight(BufferedImage imagen1, BufferedImage imagen2)
	{
		if(imagen1.getHeight() <= imagen2.getHeight())
			return imagen1.getHeight();
		else
			return imagen2.getHeight();
	}
	
	public static int[][][] addition(int [][][] imagen1, int [][][] imagen2, int w, int h)
	{
		int imagen3[][][] = new int[w][h][3];
		for(int x = 0; x < w; x++)
		{
			for(int y = 0; y < h; y++)
			{
				imagen3[x][y][0] = (imagen1[x][y][0] + imagen2[x][y][0])/2;
				imagen3[x][y][1] = (imagen1[x][y][1] + imagen2[x][y][1])/2;
				imagen3[x][y][2] = (imagen1[x][y][2] + imagen2[x][y][2])/2;
			}
		}
		return imagen3;
	}
	
	public static int[][][] linearCombination(int [][][] imagen1, int [][][] imagen2, int w, int h, double alpha, double beta)
	{
		int imagen3[][][] = new int[w][h][3];
		for(int x = 0; x < w; x++)
		{
			for(int y = 0; y < h; y++)
			{
				imagen3[x][y][0] = (int)(alpha * imagen1[x][y][0] + beta * imagen2[x][y][0]);
				imagen3[x][y][1] = (int)(alpha * imagen1[x][y][1] + beta * imagen2[x][y][1]);
				imagen3[x][y][2] = (int)(alpha * imagen1[x][y][2] + beta * imagen2[x][y][2]);
			}
		}
		return imagen3;
	}
	
	public static int[][][] subtraction(int [][][] imagen1, int [][][] imagen2, int w, int h)
	{
		int imagen3[][][] = new int[w][h][3];
		for(int x = 0; x < w; x++)
		{
			for(int y = 0; y < h; y++)
			{
				imagen3[x][y][0] = 255/2 + (imagen1[x][y][0] - imagen2[x][y][0])/2;
				imagen3[x][y][1] = 255/2 + (imagen1[x][y][1] - imagen2[x][y][1])/2;
				imagen3[x][y][2] = 255/2 + (imagen1[x][y][2] - imagen2[x][y][2])/2;
			}
		}
		return imagen3;
	}
	
	public static int[][][] multiplication(int [][][] imagen1, int [][][] imagen2, int w, int h)
	{
		int imagen3[][][] = new int[w][h][3];
		for(int x = 0; x < w; x++)
		{
			for(int y = 0; y < h; y++)
			{
				imagen3[x][y][0] = (imagen1[x][y][0] * imagen2[x][y][0])/255;
				imagen3[x][y][1] = (imagen1[x][y][1] * imagen2[x][y][1])/255;
				imagen3[x][y][2] = (imagen1[x][y][2] * imagen2[x][y][2])/255;
			}
		}
		return imagen3;
	}
	
	public static int[][][] imageExtractor(BufferedImage img1, BufferedImage img2)
	{
		return new int[ImageOperator.resultWidth(img1, img2)][ImageOperator.resultHeight(img1, img2)][3];
	}
	
	public static int[][][] pixel2matrix(BufferedImage img1, BufferedImage img2)
	{
		int imagen[][][] = ImageOperator.imageExtractor(img1, img2);
		for(int x = 0; x < ImageOperator.resultWidth(img1, img2); x++)
		{
			for(int y = 0; y < ImageOperator.resultHeight(img1, img2); y++)
			{
				Color c = new Color(img1.getRGB(x, y)); //
				imagen[x][y][0] = c.getRed();
				imagen[x][y][1] = c.getGreen();
				imagen[x][y][2] = c.getBlue();
			}
		}
		return imagen;
	}
	
	public static BufferedImage matrix2pixel(int [][][] arreglo, int w, int h)
	{
		BufferedImage result = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		for(int x = 0; x < w; x++)
		{
			for(int y = 0; y < h; y++)
			{
				Color  c = new Color(arreglo[x][y][0], arreglo[x][y][1], arreglo[x][y][2]);
				result.setRGB(x, y, c.getRGB());
			}
		}
		return result;
	}
	
	public static void windowCreator(ImageIcon i)
	{
		JFrame resultado = new JFrame("Resultado");
		resultado.setVisible(true);
		resultado.setLayout(null);
		resultado.setBounds(100, 100, 435, 300);
		JPanel jp2 = new JPanel();
		resultado.setContentPane(jp2);
		jp2.setBackground(new Color(Integer.parseInt("00BFFF", 16)));
		jp2.setLayout(null);
		jp2.setOpaque(true);
		JLabel rL = new JLabel();
		rL.setBounds(10, 10, 400, 200);
		resultado.add(rL);
		rL.setIcon(i);
	}
	
	public static BufferedImage imageProcessor(BufferedImage img1, BufferedImage img2, char op, double sPos, int chunkRows, int chunkCols)
	{
		int imagen1[][][] = ImageOperator.pixel2matrix(img1, img2), imagen2[][][] = ImageOperator.pixel2matrix(img2, img1), imagen3[][][] = ImageOperator.imageExtractor(img1, img2);		
		int tW = ImageOperator.resultWidth(img1, img2)/chunkCols, tH = ImageOperator.resultHeight(img1, img2)/chunkRows, cA = 0, cW = 0, cH = 0;
		final int chunkCounter = chunkRows * chunkCols;
		Chunk chunkMatrix[] = new Chunk[chunkCounter];
		for(int i = 0; i < chunkRows; i++)
		{
			for(int k = 0; k < chunkCols; k++)
			{
				chunkMatrix[cA] = new Chunk(cW, cH, tW, tH);
				cW = cW + tW;
				System.out.println(cW + " " + cH);
				cA++;
			}
			cH = cH + tH;
			cW = 0;
		}
		switch(op)
		{
			case '+':
			{
				imagen3 = ImageOperator.addition(imagen1, imagen2, ImageOperator.resultWidth(img1, img2), ImageOperator.resultHeight(img1, img2));
				break;
			}
			case '-':
			{
				imagen3 = ImageOperator.subtraction(imagen1, imagen2, ImageOperator.resultWidth(img1, img2), ImageOperator.resultHeight(img1, img2));
				break;
			}
			case '#':
			{
				imagen3 = ImageOperator.linearCombination(imagen1, imagen2, ImageOperator.resultWidth(img1, img2), ImageOperator.resultHeight(img1, img2), (sPos), (1.0 - sPos));
				break;
			}
			case '*':
			{
				imagen3 = ImageOperator.multiplication(imagen1, imagen2, ImageOperator.resultWidth(img1, img2), ImageOperator.resultHeight(img1, img2));
				break;
			}
			default:
			{
				
			}
		}
		BufferedImage imgR = new BufferedImage(ImageOperator.resultWidth(img1, img2), ImageOperator.resultHeight(img1, img2), BufferedImage.TYPE_INT_RGB);
		BufferedImage imgC = new BufferedImage(ImageOperator.resultWidth(img1, img2), ImageOperator.resultHeight(img1, img2), BufferedImage.TYPE_INT_RGB);
		imgC = ImageOperator.matrix2pixel(imagen3, ImageOperator.resultWidth(img1, img2), ImageOperator.resultHeight(img1, img2));
		cW = 0;
		cH = 0;
		for(int i = 0; i < chunkRows; i++)
		{
			if(i == chunkCounter -1)
				break;
			for(int k = 0; k < chunkCols; k++)
			{
				for(int j = cH; j < cH + tH; j++)
				{
					for(int l = cW; l < cW + tW; l++)
					{
						imgR.setRGB(l, j, imgC.getRGB(l, j));
					}
				}
				cW = cW + tW;
				cA++;
				ImageOperator.windowCreator(ImageOperator.iconMaker(imgR, 400, 200));
			}
			cH = cH + tH;
			cW = 0;
			try 
			{
				Thread.sleep (1000);
			}
			catch (Exception e) 
			{}
		}
		return ImageOperator.matrix2pixel(imagen3, ImageOperator.resultWidth(img1, img2), ImageOperator.resultHeight(img1, img2));
	}
	
}
