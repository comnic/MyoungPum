package kr.comnic.MyoungPum;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyoungPumActivity extends Activity {
    /** Called when the activity is first created. */

	Intent clsIntent;
	Timer tt ;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        clsIntent = new Intent( this, ListActivity.class );
        tt = new Timer();
        
        TimerTask tTask = new TimerTask() {
			@Override
			public void run() {
				Log.i("MyoungPumActivity", "run");
				changeActivety();
			}
		};
		
		
		tt.schedule(tTask,1000);
    }

    public void changeActivety(){
    	startActivity(clsIntent);
    	finish();
    }

    @Override
    protected void onStop() {
    	tt.cancel();
    	finish();
    	super.onStop();
    	
    }

}