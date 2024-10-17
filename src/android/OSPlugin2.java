package com.example.osplugin2;

import android.widget.Toast;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.print.PrintManager;
import android.print.PrintDocumentAdapter;

public class OSPlugin2 extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("print")) {
            String content = args.getString(0);
            this.print(content, callbackContext);
            return true;
        }
        return false;
    }

    private void print(String content, CallbackContext callbackContext) {
        Context context = this.cordova.getActivity().getApplicationContext();
        PrintManager printManager = (PrintManager) context.getSystemService(Context.PRINT_SERVICE);
        PrintDocumentAdapter printAdapter = new CustomPrintAdapter(content);
        printManager.print("Print Job", printAdapter, null);
        callbackContext.success("Print job started");
    }
}
