package kr.comnic.MyoungPum;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

public class DetailActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        Intent intent = getIntent();
        String selectedItem = intent.getStringExtra("selectedItem");
        

        WebView wvDetail = (WebView)findViewById(R.id.wvDetail);
        wvDetail.getSettings().setJavaScriptEnabled(true);
        wvDetail.loadUrl(String.format("file:///android_asset/i00%s.html", selectedItem));
/*        
        findViewById(R.id.btnList).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
*/
	}

}
