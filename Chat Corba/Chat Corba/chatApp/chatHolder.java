package chatApp;


public final class chatHolder implements org.omg.CORBA.portable.Streamable
{
  public chatApp.chat value = null;

  public chatHolder ()
  {
  }

  public chatHolder (chatApp.chat initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = chatApp.chatHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    chatApp.chatHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return chatApp.chatHelper.type ();
  }

}
