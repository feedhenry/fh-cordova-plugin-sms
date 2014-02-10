package com.feedhenry.phonegap.sms;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.telephony.SmsManager;

public class Sms extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext pCallbackContext) {
    try{
      if("send".equalsIgnoreCase(action)){
        sendSmsMessage(args.getString(0), args.getString(1));
        pCallbackContext.success();
        return true;
      } else {
        pCallbackContext.error("Unknown action : " + action);
        return false;
      }
    }catch(JSONException e){
      pCallbackContext.error(e.getMessage());
      return false;
    }
  }

  private void sendSmsMessage(String pNumber, String pText) {
    SmsManager sm = SmsManager.getDefault();
    sm.sendTextMessage(pNumber, null, pText, null, null);
  }

}
