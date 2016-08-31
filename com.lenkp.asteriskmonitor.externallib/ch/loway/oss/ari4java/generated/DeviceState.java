package ch.loway.oss.ari4java.generated;

// ----------------------------------------------------
//      THIS CLASS WAS GENERATED AUTOMATICALLY         
//               PLEASE DO NOT EDIT                    
//    Generated on: Sat Jan 30 13:39:05 CET 2016
// ----------------------------------------------------

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import ch.loway.oss.ari4java.tools.RestException;
import ch.loway.oss.ari4java.tools.AriCallback;
import ch.loway.oss.ari4java.tools.tags.*;

/**********************************************************
 * 
 * Generated by: JavaInterface
 *********************************************************/


public interface DeviceState extends EventSource  {

// void setState String
/**********************************************************
 * Device's state
 * 
 * @since ari_0_0_1
 *********************************************************/
 public void setState(String val );



// void setName String
/**********************************************************
 * Name of the device.
 * 
 * @since ari_0_0_1
 *********************************************************/
 public void setName(String val );



// String getName
/**********************************************************
 * Name of the device.
 * 
 * @since ari_0_0_1
 *********************************************************/
 public String getName();



// String getState
/**********************************************************
 * Device's state
 * 
 * @since ari_0_0_1
 *********************************************************/
 public String getState();


}
;
