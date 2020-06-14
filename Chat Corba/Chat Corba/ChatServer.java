import chatApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

	
	class chatImpl extends chatPOA{
		JFrame ventana_chat=null;
		JButton btn_enviar=null;
		JTextField txt_mensaje=null;
		JTextArea area_chat=null;
		JPanel contenedor_areachat=null;
		JPanel contenedor_btntxt=null;
		JScrollPane scroll=null;
		public void setORB(ORB orb_val){
		}
		public void hacerInterfaz() throws IOException{
			ventana_chat=new JFrame("chat");
			btn_enviar=new JButton("Enviar");
			txt_mensaje=new JTextField(4);
			area_chat=new JTextArea(10,12);
			scroll=new JScrollPane(area_chat);
			contenedor_areachat=new JPanel();
			contenedor_areachat.setLayout(new GridLayout(1,1));
			contenedor_areachat.add(scroll);
			contenedor_btntxt=new JPanel();
			contenedor_btntxt.setLayout(new GridLayout(1,2));
			contenedor_btntxt.add(txt_mensaje);
			contenedor_btntxt.add(btn_enviar);
			btn_enviar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evento){
					while(true){
						chat.enviar(txt_mensaje.getText());
					}
				}
			});
			((Appendable) txt_mensaje).append("Anonimo dice:  "+txt_mensaje);
			ventana_chat.setLayout(new BorderLayout());
			ventana_chat.add(contenedor_areachat,BorderLayout.NORTH);
			ventana_chat.add(contenedor_btntxt, BorderLayout.SOUTH);
			ventana_chat.setSize(300, 220);
			ventana_chat.setVisible(true);
			ventana_chat.setResizable(false);
			ventana_chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		@Override
		public void shutdown() {
			// TODO Auto-generated method stub
			
		}
	}
	
	public class ChatServer{
	
		public static void main(String args[]){
			try{
				ORB orb= ORB.init(args,null);
				POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
				rootpoa.the_POAManager().activate();
				chatImpl chatImpl = new chatImpl();
				chatImpl.setORB(orb); 
				org.omg.CORBA.Object ref = rootpoa.servant_to_reference(chatImpl);
				chat href = chatHelper.narrow(ref);
				org.omg.CORBA.Object objRef =orb.resolve_initial_references("NameService");
				NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
				String name = "Chat";
				NameComponent path[] = ncRef.to_name( name );
				ncRef.rebind(path, href);
				System.out.println("Servidor del chat listo y en espera...");
				orb.run();		
			}catch(Exception e){
				System.err.println("Error: "+e);
				e.printStackTrace(System.out);
			}
			System.out.println("Gracias por usar nuestro servicio de Chat");
		}	
	}