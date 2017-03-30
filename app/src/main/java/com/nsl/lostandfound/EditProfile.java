
package com.nsl.lostandfound;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EditProfile extends ActionBarActivity {
    EditText AddressEt, PhoneEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        AddressEt = (EditText)findViewById(R.id.etAddress);
        PhoneEt = (EditText)findViewById(R.id.etPhone);
    }

    public void UpdateProfile(View view) {
        Bundle extras = getIntent().getExtras();
        String address = AddressEt.getText().toString();
        String phone = PhoneEt.getText().toString();
        if(phone.length()<10){
            Toast.makeText(this,"Enter A valid Phone Number", Toast.LENGTH_SHORT).show();
        }
        else {
            String email = extras.getString("email");
            String type = "EditProfile";
            //Toast.makeText(this,address+phone+type, Toast.LENGTH_SHORT).show();
            BackgroundWorkerProfile backgroundWorkerProfile = new BackgroundWorkerProfile(this);
            backgroundWorkerProfile.execute(type, address, phone, email);


            String name = extras.getString("name");
            Intent intent = new Intent(this, UserProfile.class);
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            startActivity(intent);
        }
    }

}