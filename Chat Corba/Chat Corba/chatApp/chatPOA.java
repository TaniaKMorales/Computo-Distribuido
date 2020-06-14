package chatApp;

import java.io.IOException;



public abstract class chatPOA extends org.omg.PortableServer.Servant
 implements chatApp.chatOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable<String, Integer> _methods = new java.util.Hashtable<String, Integer> ();
  static
  {
    _methods.put ("hacerInterfaz", new java.lang.Integer (0));
    _methods.put ("shutdown", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // chatApp/chat/hacerInterfaz
       {
         try {
			this.hacerInterfaz ();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         out = $rh.createReply();
         break;
       }

       case 1:  // chatApp/chat/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:chatApp/chat:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public chat _this() 
  {
    return chatHelper.narrow(
    super._this_object());
  }

  public chat _this(org.omg.CORBA.ORB orb) 
  {
    return chatHelper.narrow(
    super._this_object(orb));
  }


} // class chatPOA
