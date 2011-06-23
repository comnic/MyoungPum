package kr.comnic.MyoungPum;

import net.daum.mobilead.AdHttpListener;
import net.daum.mobilead.MobileAdView;

import com.cauly.android.ad.AdInfo;
import com.cauly.android.ad.AdListener;
import com.cauly.android.ad.AdView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.RelativeLayout;

public class DetailActivity extends Activity implements AdListener, AdHttpListener {
	private RelativeLayout m_adLayout;
	private AdView m_caulyADView = null;
	private MobileAdView m_adamADView = null;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        m_adLayout = (RelativeLayout)findViewById(R.id.ADLayout2);        
        AdInfo ads_info = new AdInfo();
        //ads_info.initData("", adtype, gender, age, gps, effect, allowcall, reloadInterval)
        //irmWTe609U
        ads_info.initData("wCrQXfwGKF", "CPC", "all", "all", "off", "circle", "no", 30);
       
        m_caulyADView = new AdView(this);
        m_caulyADView.setAdListener(this);
        
        m_adLayout.addView(m_caulyADView);        

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

	@Override
	public void onFailedToReceiveAd(boolean arg0) {
		// TODO Auto-generated method stub
		net.daum.mobilead.AdConfig.setClientId("a30Z0CT130bc82253c");
		m_adamADView = new MobileAdView(this);
		
		m_adamADView.setAdListener(this);
		m_adamADView.setVisibility(View.VISIBLE);
		
		m_caulyADView.setVisibility(View.GONE);
		m_adLayout.addView(m_adamADView);
		
	}

	@Override
	public void onReceiveAd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void didDownloadAd_AdListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void failedDownloadAd_AdListener(int arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

}
