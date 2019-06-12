/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.text.DateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;

@ManagedBean( name="webTimeBean" )

public class WebTimeBean 
{
   // return the time on the server at which the request was received
   public String getTime()
   {
      return DateFormat.getTimeInstance( DateFormat.LONG ).format(new Date() );
   } // end method getTime
} // end class WebTimeBean
