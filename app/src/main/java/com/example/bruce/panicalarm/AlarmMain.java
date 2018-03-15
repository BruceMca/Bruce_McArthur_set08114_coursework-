package com.example.bruce.panicalarm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class AlarmMain extends Activity {

    private ImageButton sendBtn;
    EditText txtPhoneNumber;
    EditText txtMessage;
    String phoneNo;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_alarm_main );

        txtPhoneNumber = (EditText) findViewById( R.id.editNumber );
        txtMessage = (EditText) findViewById( R.id.editMessage );

        sendBtn = (ImageButton) findViewById( R.id.smsButton );

        sendBtn.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                sendPanicCall();
                sendPanicSMS();
            }
        } );
    }

    public void sendPanicSMS()
    {
        phoneNo = txtPhoneNumber.getText().toString();
        message = txtMessage.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage( "tel:" + phoneNo, null, message, null, null );
    }

    public void sendPanicCall()
    {
        phoneNo = txtPhoneNumber.getText().toString();

        Intent panicCall = new Intent(  );
        panicCall.setAction(Intent.ACTION_DIAL);
        panicCall.setData( Uri.parse("tel:" + phoneNo));
        startActivity(panicCall);
    }
}