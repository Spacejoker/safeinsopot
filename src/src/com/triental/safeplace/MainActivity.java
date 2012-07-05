package com.triental.safeplace;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    /** Called when the user selects the Send button 
     * @throws Throwable */
    public void sendMessage(View view) throws Throwable {
    	
    	String FILENAME = "contacts";
    	String string = "Pink skirts in sopot!";
    	FileInputStream openFileInput = openFileInput(FILENAME);
    	String s = convertStreamToString(openFileInput);
    	string = s + string;
    	openFileInput.close();
    	
    	FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
    	fos.write(string.getBytes());
    	fos.close();

    	openFileInput = openFileInput(FILENAME);
    	s = "In file we now have: " + convertStreamToString(openFileInput);
    	openFileInput.close();
    	
    	Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    	
    }
    
    String convertStreamToString(java.io.InputStream is) {
        try {
            return new java.util.Scanner(is).useDelimiter("\\A").next();
        } catch (java.util.NoSuchElementException e) {
            return "";
        }
    }
}
