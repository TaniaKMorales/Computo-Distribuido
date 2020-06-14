import chatApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;

	public class ChatClient{
		static chat chatImpl;
		public static void main(String args[]){
			try{
				ORB orb= ORB.init(args,null);
				org.omg.CORBA.Object objRef =orb.resolve_initial_references("NameService");
				NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
				String name = "Chat";
				chatImpl=chatHelper.narrow(ncRef.resolve_str(name));
				System.out.println("El servicio de chat se encuentra activo");
				chatImpl.hacerInterfaz();
				chatImpl.shutdown();
			}catch(Exception e) {
				System.out.println("ERROR : " + e) ;
				e.printStackTrace(System.out);
			}
		}
	}