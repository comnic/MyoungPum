package kr.comnic.MyoungPum;

import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;

public class ListActivity extends Activity {
	private Intent clsDetailIntent;
	public String selectedItem = "NONe";
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

		clsDetailIntent = new Intent( ListActivity.this, DetailActivity.class ); //new Intent(Intent.ACTION_VIEW, Uri.parse("file:///android_asset/i001.html"));//, Uri.parse("http://www.naver.com"));//new Intent( this, DetailActivity.class );

        GridView grid = (GridView)findViewById(R.id.gridList);
        ImageAdapter adapter = new ImageAdapter(this);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View v, int position, long id){
				clsDetailIntent.putExtra("selectedItem", String.valueOf(position+1));
		    	startActivity(clsDetailIntent);
			}
        });

    }
}

/*
class MyWebClient extends WebViewClient{
	public boolean shouldOverrideUrlLoading(WebView view, String url){
		view.loadUrl(url);
		return true;
	}
}
*/

class ImageAdapter extends BaseAdapter {
	private Context mContext;
	
	int[] picture = { R.drawable.list004, R.drawable.list002, R.drawable.list001, R.drawable.list003 };
	
	public ImageAdapter(Context c){
		mContext = c;
	}
	
	public int getCount(){
		return 4;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return picture[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView imageView;
		if(convertView == null){
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
			imageView.setAdjustViewBounds(false);
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		}else{
			imageView = (ImageView) convertView;
		}
		
		imageView.setImageResource(picture[position]);
		
		return imageView;
	}
	
}