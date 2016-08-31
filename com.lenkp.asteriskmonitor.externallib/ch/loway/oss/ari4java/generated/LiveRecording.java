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


public interface LiveRecording {

// void setState String
/**********************************************************
 * 
 * 
 * @since ari_0_0_1
 *********************************************************/
 public void setState(String val );



// int getSilence_duration
/**********************************************************
 * Duration of silence, in seconds, detected in the recording. This is only available if the recording was initiated with a non-zero maxSilenceSeconds.
 * 
 * @since ari_1_5_0
 *********************************************************/
 public int getSilence_duration();



// void setTarget_uri String
/**********************************************************
 * URI for the channel or bridge being recorded
 * 
 * @since ari_1_5_0
 *********************************************************/
 public void setTarget_uri(String val );



// String getCause
/**********************************************************
 * Cause for recording failure if failed
 * 
 * @since ari_0_0_1
 *********************************************************/
 public String getCause();



// String getTarget_uri
/**********************************************************
 * URI for the channel or bridge being recorded
 * 
 * @since ari_1_5_0
 *********************************************************/
 public String getTarget_uri();



// void setDuration int
/**********************************************************
 * Duration in seconds of the recording
 * 
 * @since ari_1_5_0
 *********************************************************/
 public void setDuration(int val );



// void setTalking_duration int
/**********************************************************
 * Duration of talking, in seconds, detected in the recording. This is only available if the recording was initiated with a non-zero maxSilenceSeconds.
 * 
 * @since ari_1_5_0
 *********************************************************/
 public void setTalking_duration(int val );



// String getState
/**********************************************************
 * 
 * 
 * @since ari_0_0_1
 *********************************************************/
 public String getState();



// void setCause String
/**********************************************************
 * Cause for recording failure if failed
 * 
 * @since ari_0_0_1
 *********************************************************/
 public void setCause(String val );



// int getDuration
/**********************************************************
 * Duration in seconds of the recording
 * 
 * @since ari_1_5_0
 *********************************************************/
 public int getDuration();



// String getFormat
/**********************************************************
 * 
 * 
 * @since ari_0_0_1
 *********************************************************/
 public String getFormat();



// void setName String
/**********************************************************
 * Base name for the recording
 * 
 * @since ari_0_0_1
 *********************************************************/
 public void setName(String val );



// int getTalking_duration
/**********************************************************
 * Duration of talking, in seconds, detected in the recording. This is only available if the recording was initiated with a non-zero maxSilenceSeconds.
 * 
 * @since ari_1_5_0
 *********************************************************/
 public int getTalking_duration();



// String getName
/**********************************************************
 * Base name for the recording
 * 
 * @since ari_0_0_1
 *********************************************************/
 public String getName();



// void setFormat String
/**********************************************************
 * 
 * 
 * @since ari_0_0_1
 *********************************************************/
 public void setFormat(String val );



// void setSilence_duration int
/**********************************************************
 * Duration of silence, in seconds, detected in the recording. This is only available if the recording was initiated with a non-zero maxSilenceSeconds.
 * 
 * @since ari_1_5_0
 *********************************************************/
 public void setSilence_duration(int val );


}
;