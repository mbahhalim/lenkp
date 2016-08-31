package ch.loway.oss.ari4java.generated.ari_1_7_0.actions;

// ----------------------------------------------------
//      THIS CLASS WAS GENERATED AUTOMATICALLY         
//               PLEASE DO NOT EDIT                    
//    Generated on: Sat Jan 30 13:39:05 CET 2016
// ----------------------------------------------------

import ch.loway.oss.ari4java.generated.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import ch.loway.oss.ari4java.tools.BaseAriAction;
import ch.loway.oss.ari4java.tools.RestException;
import ch.loway.oss.ari4java.tools.AriCallback;
import ch.loway.oss.ari4java.tools.HttpParam;
import ch.loway.oss.ari4java.tools.HttpResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import ch.loway.oss.ari4java.generated.ari_1_7_0.models.*;

/**********************************************************
 * 
 * Generated by: Apis
 *********************************************************/


public class ActionChannels_impl_ari_1_7_0 extends BaseAriAction  implements ActionChannels {
/**********************************************************
 * Active channels
 * 
 * List all active channels in Asterisk.
 *********************************************************/
private void buildList() {
reset();
url = "/channels";
method = "GET";
}

@Override
public List<Channel> list() throws RestException {
buildList();
String json = httpActionSync();
return deserializeJsonAsAbstractList( json,
   new TypeReference<List<Channel_impl_ari_1_7_0>>() {} ); 
}

@Override
public void list(AriCallback<List<Channel>> callback) {
buildList();
httpActionAsync(callback, new TypeReference<List<Channel_impl_ari_1_7_0>>() {});
}

/**********************************************************
 * Active channels
 * 
 * Create a new channel (originate).
 * The new channel is created immediately and a snapshot of it returned. If a Stasis application is provided it will be automatically subscribed to the originated channel for further events and updates.
 *********************************************************/
private void buildOriginate(String endpoint, String extension, String context, long priority, String label, String app, String appArgs, String callerId, int timeout, Map<String,String> variables, String channelId, String otherChannelId, String originator) {
reset();
url = "/channels";
method = "POST";
lParamQuery.add( HttpParam.build( "endpoint", endpoint) );
lParamQuery.add( HttpParam.build( "extension", extension) );
lParamQuery.add( HttpParam.build( "context", context) );
lParamQuery.add( HttpParam.build( "priority", priority) );
lParamQuery.add( HttpParam.build( "label", label) );
lParamQuery.add( HttpParam.build( "app", app) );
lParamQuery.add( HttpParam.build( "appArgs", appArgs) );
lParamQuery.add( HttpParam.build( "callerId", callerId) );
lParamQuery.add( HttpParam.build( "timeout", timeout) );
lParamQuery.add( HttpParam.build( "channelId", channelId) );
lParamQuery.add( HttpParam.build( "otherChannelId", otherChannelId) );
lParamQuery.add( HttpParam.build( "originator", originator) );
lE.add( HttpResponse.build( 400, "Invalid parameters for originating a channel.") );
}

@Override
public Channel originate(String endpoint, String extension, String context, long priority, String label, String app, String appArgs, String callerId, int timeout, Map<String,String> variables, String channelId, String otherChannelId, String originator) throws RestException {
buildOriginate(endpoint, extension, context, priority, label, app, appArgs, callerId, timeout, variables, channelId, otherChannelId, originator);
String json = httpActionSync();
return deserializeJson( json, Channel_impl_ari_1_7_0.class ); 
}

@Override
public void originate(String endpoint, String extension, String context, long priority, String label, String app, String appArgs, String callerId, int timeout, Map<String,String> variables, String channelId, String otherChannelId, String originator, AriCallback<Channel> callback) {
buildOriginate(endpoint, extension, context, priority, label, app, appArgs, callerId, timeout, variables, channelId, otherChannelId, originator);
httpActionAsync(callback, Channel_impl_ari_1_7_0.class);
}

/**********************************************************
 * Active channel
 * 
 * Channel details.
 *********************************************************/
private void buildGet(String channelId) {
reset();
url = "/channels/" + channelId + "";
method = "GET";
lE.add( HttpResponse.build( 404, "Channel not found") );
}

@Override
public Channel get(String channelId) throws RestException {
buildGet(channelId);
String json = httpActionSync();
return deserializeJson( json, Channel_impl_ari_1_7_0.class ); 
}

@Override
public void get(String channelId, AriCallback<Channel> callback) {
buildGet(channelId);
httpActionAsync(callback, Channel_impl_ari_1_7_0.class);
}

/**********************************************************
 * Active channel
 * 
 * Create a new channel (originate with id).
 * The new channel is created immediately and a snapshot of it returned. If a Stasis application is provided it will be automatically subscribed to the originated channel for further events and updates.
 *********************************************************/
private void buildOriginateWithId(String channelId, String endpoint, String extension, String context, long priority, String label, String app, String appArgs, String callerId, int timeout, Map<String,String> variables, String otherChannelId, String originator) {
reset();
url = "/channels/" + channelId + "";
method = "POST";
lParamQuery.add( HttpParam.build( "endpoint", endpoint) );
lParamQuery.add( HttpParam.build( "extension", extension) );
lParamQuery.add( HttpParam.build( "context", context) );
lParamQuery.add( HttpParam.build( "priority", priority) );
lParamQuery.add( HttpParam.build( "label", label) );
lParamQuery.add( HttpParam.build( "app", app) );
lParamQuery.add( HttpParam.build( "appArgs", appArgs) );
lParamQuery.add( HttpParam.build( "callerId", callerId) );
lParamQuery.add( HttpParam.build( "timeout", timeout) );
lParamQuery.add( HttpParam.build( "otherChannelId", otherChannelId) );
lParamQuery.add( HttpParam.build( "originator", originator) );
lE.add( HttpResponse.build( 400, "Invalid parameters for originating a channel.") );
}

@Override
public Channel originateWithId(String channelId, String endpoint, String extension, String context, long priority, String label, String app, String appArgs, String callerId, int timeout, Map<String,String> variables, String otherChannelId, String originator) throws RestException {
buildOriginateWithId(channelId, endpoint, extension, context, priority, label, app, appArgs, callerId, timeout, variables, otherChannelId, originator);
String json = httpActionSync();
return deserializeJson( json, Channel_impl_ari_1_7_0.class ); 
}

@Override
public void originateWithId(String channelId, String endpoint, String extension, String context, long priority, String label, String app, String appArgs, String callerId, int timeout, Map<String,String> variables, String otherChannelId, String originator, AriCallback<Channel> callback) {
buildOriginateWithId(channelId, endpoint, extension, context, priority, label, app, appArgs, callerId, timeout, variables, otherChannelId, originator);
httpActionAsync(callback, Channel_impl_ari_1_7_0.class);
}

/**********************************************************
 * Active channel
 * 
 * Delete (i.e. hangup) a channel.
 *********************************************************/
private void buildHangup(String channelId, String reason) {
reset();
url = "/channels/" + channelId + "";
method = "DELETE";
lParamQuery.add( HttpParam.build( "reason", reason) );
lE.add( HttpResponse.build( 400, "Invalid reason for hangup provided") );
lE.add( HttpResponse.build( 404, "Channel not found") );
}

@Override
public void hangup(String channelId, String reason) throws RestException {
buildHangup(channelId, reason);
String json = httpActionSync();
}

@Override
public void hangup(String channelId, String reason, AriCallback<Void> callback) {
buildHangup(channelId, reason);
httpActionAsync(callback);
}

/**********************************************************
 * Answer a channel
 * 
 * Answer a channel.
 *********************************************************/
private void buildAnswer(String channelId) {
reset();
url = "/channels/" + channelId + "/answer";
method = "POST";
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public void answer(String channelId) throws RestException {
buildAnswer(channelId);
String json = httpActionSync();
}

@Override
public void answer(String channelId, AriCallback<Void> callback) {
buildAnswer(channelId);
httpActionAsync(callback);
}

/**********************************************************
 * Exit application; continue execution in the dialplan
 * 
 * Exit application; continue execution in the dialplan.
 *********************************************************/
private void buildContinueInDialplan(String channelId, String context, String extension, int priority, String label) {
reset();
url = "/channels/" + channelId + "/continue";
method = "POST";
lParamQuery.add( HttpParam.build( "context", context) );
lParamQuery.add( HttpParam.build( "extension", extension) );
lParamQuery.add( HttpParam.build( "priority", priority) );
lParamQuery.add( HttpParam.build( "label", label) );
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public void continueInDialplan(String channelId, String context, String extension, int priority, String label) throws RestException {
buildContinueInDialplan(channelId, context, extension, priority, label);
String json = httpActionSync();
}

@Override
public void continueInDialplan(String channelId, String context, String extension, int priority, String label, AriCallback<Void> callback) {
buildContinueInDialplan(channelId, context, extension, priority, label);
httpActionAsync(callback);
}

/**********************************************************
 * Send DTMF to a channel
 * 
 * Send provided DTMF to a given channel.
 *********************************************************/
private void buildSendDTMF(String channelId, String dtmf, int before, int between, int duration, int after) {
reset();
url = "/channels/" + channelId + "/dtmf";
method = "POST";
lParamQuery.add( HttpParam.build( "dtmf", dtmf) );
lParamQuery.add( HttpParam.build( "before", before) );
lParamQuery.add( HttpParam.build( "between", between) );
lParamQuery.add( HttpParam.build( "duration", duration) );
lParamQuery.add( HttpParam.build( "after", after) );
lE.add( HttpResponse.build( 400, "DTMF is required") );
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public void sendDTMF(String channelId, String dtmf, int before, int between, int duration, int after) throws RestException {
buildSendDTMF(channelId, dtmf, before, between, duration, after);
String json = httpActionSync();
}

@Override
public void sendDTMF(String channelId, String dtmf, int before, int between, int duration, int after, AriCallback<Void> callback) {
buildSendDTMF(channelId, dtmf, before, between, duration, after);
httpActionAsync(callback);
}

/**********************************************************
 * Put a channel on hold
 * 
 * Hold a channel.
 *********************************************************/
private void buildHold(String channelId) {
reset();
url = "/channels/" + channelId + "/hold";
method = "POST";
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public void hold(String channelId) throws RestException {
buildHold(channelId);
String json = httpActionSync();
}

@Override
public void hold(String channelId, AriCallback<Void> callback) {
buildHold(channelId);
httpActionAsync(callback);
}

/**********************************************************
 * Put a channel on hold
 * 
 * Remove a channel from hold.
 *********************************************************/
private void buildUnhold(String channelId) {
reset();
url = "/channels/" + channelId + "/hold";
method = "DELETE";
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public void unhold(String channelId) throws RestException {
buildUnhold(channelId);
String json = httpActionSync();
}

@Override
public void unhold(String channelId, AriCallback<Void> callback) {
buildUnhold(channelId);
httpActionAsync(callback);
}

/**********************************************************
 * Play music on hold to a channel
 * 
 * Play music on hold to a channel.
 * Using media operations such as /play on a channel playing MOH in this manner will suspend MOH without resuming automatically. If continuing music on hold is desired, the stasis application must reinitiate music on hold.
 *********************************************************/
private void buildStartMoh(String channelId, String mohClass) {
reset();
url = "/channels/" + channelId + "/moh";
method = "POST";
lParamQuery.add( HttpParam.build( "mohClass", mohClass) );
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public void startMoh(String channelId, String mohClass) throws RestException {
buildStartMoh(channelId, mohClass);
String json = httpActionSync();
}

@Override
public void startMoh(String channelId, String mohClass, AriCallback<Void> callback) {
buildStartMoh(channelId, mohClass);
httpActionAsync(callback);
}

/**********************************************************
 * Play music on hold to a channel
 * 
 * Stop playing music on hold to a channel.
 *********************************************************/
private void buildStopMoh(String channelId) {
reset();
url = "/channels/" + channelId + "/moh";
method = "DELETE";
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public void stopMoh(String channelId) throws RestException {
buildStopMoh(channelId);
String json = httpActionSync();
}

@Override
public void stopMoh(String channelId, AriCallback<Void> callback) {
buildStopMoh(channelId);
httpActionAsync(callback);
}

/**********************************************************
 * Mute a channel
 * 
 * Mute a channel.
 *********************************************************/
private void buildMute(String channelId, String direction) {
reset();
url = "/channels/" + channelId + "/mute";
method = "POST";
lParamQuery.add( HttpParam.build( "direction", direction) );
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public void mute(String channelId, String direction) throws RestException {
buildMute(channelId, direction);
String json = httpActionSync();
}

@Override
public void mute(String channelId, String direction, AriCallback<Void> callback) {
buildMute(channelId, direction);
httpActionAsync(callback);
}

/**********************************************************
 * Mute a channel
 * 
 * Unmute a channel.
 *********************************************************/
private void buildUnmute(String channelId, String direction) {
reset();
url = "/channels/" + channelId + "/mute";
method = "DELETE";
lParamQuery.add( HttpParam.build( "direction", direction) );
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public void unmute(String channelId, String direction) throws RestException {
buildUnmute(channelId, direction);
String json = httpActionSync();
}

@Override
public void unmute(String channelId, String direction, AriCallback<Void> callback) {
buildUnmute(channelId, direction);
httpActionAsync(callback);
}

/**********************************************************
 * Play media to a channel
 * 
 * Start playback of media.
 * The media URI may be any of a number of URI's. Currently sound:, recording:, number:, digits:, characters:, and tone: URI's are supported. This operation creates a playback resource that can be used to control the playback of media (pause, rewind, fast forward, etc.)
 *********************************************************/
private void buildPlay(String channelId, String media, String lang, int offsetms, int skipms, String playbackId) {
reset();
url = "/channels/" + channelId + "/play";
method = "POST";
lParamQuery.add( HttpParam.build( "media", media) );
lParamQuery.add( HttpParam.build( "lang", lang) );
lParamQuery.add( HttpParam.build( "offsetms", offsetms) );
lParamQuery.add( HttpParam.build( "skipms", skipms) );
lParamQuery.add( HttpParam.build( "playbackId", playbackId) );
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public Playback play(String channelId, String media, String lang, int offsetms, int skipms, String playbackId) throws RestException {
buildPlay(channelId, media, lang, offsetms, skipms, playbackId);
String json = httpActionSync();
return deserializeJson( json, Playback_impl_ari_1_7_0.class ); 
}

@Override
public void play(String channelId, String media, String lang, int offsetms, int skipms, String playbackId, AriCallback<Playback> callback) {
buildPlay(channelId, media, lang, offsetms, skipms, playbackId);
httpActionAsync(callback, Playback_impl_ari_1_7_0.class);
}

/**********************************************************
 * Play media to a channel
 * 
 * Start playback of media and specify the playbackId.
 * The media URI may be any of a number of URI's. Currently sound:, recording:, number:, digits:, characters:, and tone: URI's are supported. This operation creates a playback resource that can be used to control the playback of media (pause, rewind, fast forward, etc.)
 *********************************************************/
private void buildPlayWithId(String channelId, String playbackId, String media, String lang, int offsetms, int skipms) {
reset();
url = "/channels/" + channelId + "/play/" + playbackId + "";
method = "POST";
lParamQuery.add( HttpParam.build( "media", media) );
lParamQuery.add( HttpParam.build( "lang", lang) );
lParamQuery.add( HttpParam.build( "offsetms", offsetms) );
lParamQuery.add( HttpParam.build( "skipms", skipms) );
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public Playback playWithId(String channelId, String playbackId, String media, String lang, int offsetms, int skipms) throws RestException {
buildPlayWithId(channelId, playbackId, media, lang, offsetms, skipms);
String json = httpActionSync();
return deserializeJson( json, Playback_impl_ari_1_7_0.class ); 
}

@Override
public void playWithId(String channelId, String playbackId, String media, String lang, int offsetms, int skipms, AriCallback<Playback> callback) {
buildPlayWithId(channelId, playbackId, media, lang, offsetms, skipms);
httpActionAsync(callback, Playback_impl_ari_1_7_0.class);
}

/**********************************************************
 * Record audio from a channel
 * 
 * Start a recording.
 * Record audio from a channel. Note that this will not capture audio sent to the channel. The bridge itself has a record feature if that's what you want.
 *********************************************************/
private void buildRecord(String channelId, String name, String format, int maxDurationSeconds, int maxSilenceSeconds, String ifExists, boolean beep, String terminateOn) {
reset();
url = "/channels/" + channelId + "/record";
method = "POST";
lParamQuery.add( HttpParam.build( "name", name) );
lParamQuery.add( HttpParam.build( "format", format) );
lParamQuery.add( HttpParam.build( "maxDurationSeconds", maxDurationSeconds) );
lParamQuery.add( HttpParam.build( "maxSilenceSeconds", maxSilenceSeconds) );
lParamQuery.add( HttpParam.build( "ifExists", ifExists) );
lParamQuery.add( HttpParam.build( "beep", beep) );
lParamQuery.add( HttpParam.build( "terminateOn", terminateOn) );
lE.add( HttpResponse.build( 400, "Invalid parameters") );
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel is not in a Stasis application; the channel is currently bridged with other hcannels; A recording with the same name already exists on the system and can not be overwritten because it is in progress or ifExists=fail") );
lE.add( HttpResponse.build( 422, "The format specified is unknown on this system") );
}

@Override
public LiveRecording record(String channelId, String name, String format, int maxDurationSeconds, int maxSilenceSeconds, String ifExists, boolean beep, String terminateOn) throws RestException {
buildRecord(channelId, name, format, maxDurationSeconds, maxSilenceSeconds, ifExists, beep, terminateOn);
String json = httpActionSync();
return deserializeJson( json, LiveRecording_impl_ari_1_7_0.class ); 
}

@Override
public void record(String channelId, String name, String format, int maxDurationSeconds, int maxSilenceSeconds, String ifExists, boolean beep, String terminateOn, AriCallback<LiveRecording> callback) {
buildRecord(channelId, name, format, maxDurationSeconds, maxSilenceSeconds, ifExists, beep, terminateOn);
httpActionAsync(callback, LiveRecording_impl_ari_1_7_0.class);
}

/**********************************************************
 * Send a ringing indication to a channel
 * 
 * Indicate ringing to a channel.
 *********************************************************/
private void buildRing(String channelId) {
reset();
url = "/channels/" + channelId + "/ring";
method = "POST";
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public void ring(String channelId) throws RestException {
buildRing(channelId);
String json = httpActionSync();
}

@Override
public void ring(String channelId, AriCallback<Void> callback) {
buildRing(channelId);
httpActionAsync(callback);
}

/**********************************************************
 * Send a ringing indication to a channel
 * 
 * Stop ringing indication on a channel if locally generated.
 *********************************************************/
private void buildRingStop(String channelId) {
reset();
url = "/channels/" + channelId + "/ring";
method = "DELETE";
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public void ringStop(String channelId) throws RestException {
buildRingStop(channelId);
String json = httpActionSync();
}

@Override
public void ringStop(String channelId, AriCallback<Void> callback) {
buildRingStop(channelId);
httpActionAsync(callback);
}

/**********************************************************
 * Play silence to a channel
 * 
 * Play silence to a channel.
 * Using media operations such as /play on a channel playing silence in this manner will suspend silence without resuming automatically.
 *********************************************************/
private void buildStartSilence(String channelId) {
reset();
url = "/channels/" + channelId + "/silence";
method = "POST";
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public void startSilence(String channelId) throws RestException {
buildStartSilence(channelId);
String json = httpActionSync();
}

@Override
public void startSilence(String channelId, AriCallback<Void> callback) {
buildStartSilence(channelId);
httpActionAsync(callback);
}

/**********************************************************
 * Play silence to a channel
 * 
 * Stop playing silence to a channel.
 *********************************************************/
private void buildStopSilence(String channelId) {
reset();
url = "/channels/" + channelId + "/silence";
method = "DELETE";
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public void stopSilence(String channelId) throws RestException {
buildStopSilence(channelId);
String json = httpActionSync();
}

@Override
public void stopSilence(String channelId, AriCallback<Void> callback) {
buildStopSilence(channelId);
httpActionAsync(callback);
}

/**********************************************************
 * Snoop (spy/whisper) on a channel
 * 
 * Start snooping.
 * Snoop (spy/whisper) on a specific channel.
 *********************************************************/
private void buildSnoopChannel(String channelId, String spy, String whisper, String app, String appArgs, String snoopId) {
reset();
url = "/channels/" + channelId + "/snoop";
method = "POST";
lParamQuery.add( HttpParam.build( "spy", spy) );
lParamQuery.add( HttpParam.build( "whisper", whisper) );
lParamQuery.add( HttpParam.build( "app", app) );
lParamQuery.add( HttpParam.build( "appArgs", appArgs) );
lParamQuery.add( HttpParam.build( "snoopId", snoopId) );
lE.add( HttpResponse.build( 400, "Invalid parameters") );
lE.add( HttpResponse.build( 404, "Channel not found") );
}

@Override
public Channel snoopChannel(String channelId, String spy, String whisper, String app, String appArgs, String snoopId) throws RestException {
buildSnoopChannel(channelId, spy, whisper, app, appArgs, snoopId);
String json = httpActionSync();
return deserializeJson( json, Channel_impl_ari_1_7_0.class ); 
}

@Override
public void snoopChannel(String channelId, String spy, String whisper, String app, String appArgs, String snoopId, AriCallback<Channel> callback) {
buildSnoopChannel(channelId, spy, whisper, app, appArgs, snoopId);
httpActionAsync(callback, Channel_impl_ari_1_7_0.class);
}

/**********************************************************
 * Snoop (spy/whisper) on a channel
 * 
 * Start snooping.
 * Snoop (spy/whisper) on a specific channel.
 *********************************************************/
private void buildSnoopChannelWithId(String channelId, String snoopId, String spy, String whisper, String app, String appArgs) {
reset();
url = "/channels/" + channelId + "/snoop/" + snoopId + "";
method = "POST";
lParamQuery.add( HttpParam.build( "spy", spy) );
lParamQuery.add( HttpParam.build( "whisper", whisper) );
lParamQuery.add( HttpParam.build( "app", app) );
lParamQuery.add( HttpParam.build( "appArgs", appArgs) );
lE.add( HttpResponse.build( 400, "Invalid parameters") );
lE.add( HttpResponse.build( 404, "Channel not found") );
}

@Override
public Channel snoopChannelWithId(String channelId, String snoopId, String spy, String whisper, String app, String appArgs) throws RestException {
buildSnoopChannelWithId(channelId, snoopId, spy, whisper, app, appArgs);
String json = httpActionSync();
return deserializeJson( json, Channel_impl_ari_1_7_0.class ); 
}

@Override
public void snoopChannelWithId(String channelId, String snoopId, String spy, String whisper, String app, String appArgs, AriCallback<Channel> callback) {
buildSnoopChannelWithId(channelId, snoopId, spy, whisper, app, appArgs);
httpActionAsync(callback, Channel_impl_ari_1_7_0.class);
}

/**********************************************************
 * Variables on a channel
 * 
 * Get the value of a channel variable or function.
 *********************************************************/
private void buildGetChannelVar(String channelId, String variable) {
reset();
url = "/channels/" + channelId + "/variable";
method = "GET";
lParamQuery.add( HttpParam.build( "variable", variable) );
lE.add( HttpResponse.build( 400, "Missing variable parameter.") );
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public Variable getChannelVar(String channelId, String variable) throws RestException {
buildGetChannelVar(channelId, variable);
String json = httpActionSync();
return deserializeJson( json, Variable_impl_ari_1_7_0.class ); 
}

@Override
public void getChannelVar(String channelId, String variable, AriCallback<Variable> callback) {
buildGetChannelVar(channelId, variable);
httpActionAsync(callback, Variable_impl_ari_1_7_0.class);
}

/**********************************************************
 * Variables on a channel
 * 
 * Set the value of a channel variable or function.
 *********************************************************/
private void buildSetChannelVar(String channelId, String variable, String value) {
reset();
url = "/channels/" + channelId + "/variable";
method = "POST";
lParamQuery.add( HttpParam.build( "variable", variable) );
lParamQuery.add( HttpParam.build( "value", value) );
lE.add( HttpResponse.build( 400, "Missing variable parameter.") );
lE.add( HttpResponse.build( 404, "Channel not found") );
lE.add( HttpResponse.build( 409, "Channel not in a Stasis application") );
}

@Override
public void setChannelVar(String channelId, String variable, String value) throws RestException {
buildSetChannelVar(channelId, variable, value);
String json = httpActionSync();
}

@Override
public void setChannelVar(String channelId, String variable, String value, AriCallback<Void> callback) {
buildSetChannelVar(channelId, variable, value);
httpActionAsync(callback);
}

/**********************************************************
 * 
 * 
 * @since ari_1_5_0
 *********************************************************/
public void originateWithId(String channelId, String endpoint, String extension, String context, long priority, String app, String appArgs, String callerId, int timeout, Map<String,String> variables, String otherChannelId, AriCallback<Channel> callback){
  throw new UnsupportedOperationException("Method availble from ...");
};

/**********************************************************
 * 
 * 
 * @since ari_0_0_1
 *********************************************************/
public void snoopChannel(String channelId, String spy, String whisper, String app, String appArgs, AriCallback<Channel> callback){
  throw new UnsupportedOperationException("Method availble from ...");
};

/**********************************************************
 * 
 * 
 * @since ari_0_0_1
 *********************************************************/
public void continueInDialplan(String channelId, String context, String extension, int priority, AriCallback<Void> callback){
  throw new UnsupportedOperationException("Method availble from ...");
};

/**********************************************************
 * Start playback of media.
 * The media URI may be any of a number of URI's. Currently sound: and recording: URI's are supported. This operation creates a playback resource that can be used to control the playback of media (pause, rewind, fast forward, etc.)
 * 
 * @since ari_0_0_1
 *********************************************************/
public Playback play(String channelId, String media, String lang, int offsetms, int skipms) throws RestException{
  throw new UnsupportedOperationException("Method availble from ...");
};

/**********************************************************
 * Exit application{
  throw new UnsupportedOperationException("Method availble from ...");
}; continue execution in the dialplan.
 * 
 * 
 * @since ari_0_0_1
 *********************************************************/
public void continueInDialplan(String channelId, String context, String extension, int priority) throws RestException{
  throw new UnsupportedOperationException("Method availble from ...");
};

/**********************************************************
 * 
 * 
 * @since ari_0_0_1
 *********************************************************/
public void originate(String endpoint, String extension, String context, long priority, String app, String appArgs, String callerId, int timeout, AriCallback<Channel> callback){
  throw new UnsupportedOperationException("Method availble from ...");
};

/**********************************************************
 * Redirect the channel to a different location.
 * 
 * 
 * @since ari_1_8_0
 *********************************************************/
public void redirect(String channelId, String endpoint) throws RestException{
  throw new UnsupportedOperationException("Method availble from ...");
};

/**********************************************************
 * 
 * 
 * @since ari_1_8_0
 *********************************************************/
public void redirect(String channelId, String endpoint, AriCallback<Void> callback){
  throw new UnsupportedOperationException("Method availble from ...");
};

/**********************************************************
 * 
 * 
 * @since ari_1_5_0
 *********************************************************/
public void originate(String endpoint, String extension, String context, long priority, String app, String appArgs, String callerId, int timeout, Map<String,String> variables, String channelId, String otherChannelId, AriCallback<Channel> callback){
  throw new UnsupportedOperationException("Method availble from ...");
};

/**********************************************************
 * Create a new channel (originate).
 * The new channel is created immediately and a snapshot of it returned. If a Stasis application is provided it will be automatically subscribed to the originated channel for further events and updates.
 * 
 * @since ari_0_0_1
 *********************************************************/
public Channel originate(String endpoint, String extension, String context, long priority, String app, String appArgs, String callerId, int timeout) throws RestException{
  throw new UnsupportedOperationException("Method availble from ...");
};

/**********************************************************
 * Create a new channel (originate with id).
 * The new channel is created immediately and a snapshot of it returned. If a Stasis application is provided it will be automatically subscribed to the originated channel for further events and updates.
 * 
 * @since ari_1_5_0
 *********************************************************/
public Channel originateWithId(String channelId, String endpoint, String extension, String context, long priority, String app, String appArgs, String callerId, int timeout, Map<String,String> variables, String otherChannelId) throws RestException{
  throw new UnsupportedOperationException("Method availble from ...");
};

/**********************************************************
 * Create a new channel (originate).
 * The new channel is created immediately and a snapshot of it returned. If a Stasis application is provided it will be automatically subscribed to the originated channel for further events and updates.
 * 
 * @since ari_1_5_0
 *********************************************************/
public Channel originate(String endpoint, String extension, String context, long priority, String app, String appArgs, String callerId, int timeout, Map<String,String> variables, String channelId, String otherChannelId) throws RestException{
  throw new UnsupportedOperationException("Method availble from ...");
};

/**********************************************************
 * 
 * 
 * @since ari_0_0_1
 *********************************************************/
public void play(String channelId, String media, String lang, int offsetms, int skipms, AriCallback<Playback> callback){
  throw new UnsupportedOperationException("Method availble from ...");
};

/**********************************************************
 * Start snooping.
 * Snoop (spy/whisper) on a specific channel.
 * 
 * @since ari_0_0_1
 *********************************************************/
public Channel snoopChannel(String channelId, String spy, String whisper, String app, String appArgs) throws RestException{
  throw new UnsupportedOperationException("Method availble from ...");
};

};

