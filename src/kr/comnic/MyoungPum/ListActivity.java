package kr.comnic.MyoungPum;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ListActivity extends Activity {
	private ArrayList<MPItem> m_items;
	private ListView m_list;
	private Intent clsDetailIntent;
	public String selectedItem = "NONe";
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        
        m_items = new ArrayList<MPItem>();
        m_items.add(new MPItem("Hermes", R.drawable.list_s001, false, MPItem.MPITEM_RATING_1));
        m_items.add(new MPItem("Chanel", R.drawable.list_s002, false, MPItem.MPITEM_RATING_1));
        m_items.add(new MPItem("Louis Vuitton", R.drawable.list_s003, false, MPItem.MPITEM_RATING_1));
        m_items.add(new MPItem("D&G", R.drawable.list_s004, false, MPItem.MPITEM_RATING_1));
        m_items.add(new MPItem("BURBERRY", R.drawable.list_s005, false, MPItem.MPITEM_RATING_1));
        
        m_list = (ListView)findViewById(R.id.listView);
        m_list.setAdapter(new MPItemAdapter(this, R.layout.list_item, m_items));
        m_list.setOnItemClickListener(onClickListen);
        
		clsDetailIntent = new Intent( ListActivity.this, DetailActivity.class ); //new Intent(Intent.ACTION_VIEW, Uri.parse("file:///android_asset/i001.html"));//, Uri.parse("http://www.naver.com"));//new Intent( this, DetailActivity.class );
/*
        GridView grid = (GridView)findViewById(R.id.gridList);
        ImageAdapter adapter = new ImageAdapter(this);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View v, int position, long id){
				clsDetailIntent.putExtra("selectedItem", String.valueOf(position+1));
		    	startActivity(clsDetailIntent);
			}
        });
*/
    }
    
    AdapterView.OnItemClickListener onClickListen = new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			// TODO Auto-generated method stub
			clsDetailIntent.putExtra("selectedItem", String.valueOf(arg2+1));
	    	startActivity(clsDetailIntent);
		}
	
    };
    	
    
}

/*
class MyWebClient extends WebViewClient{
	public boolean shouldOverrideUrlLoading(WebView view, String url){
		view.loadUrl(url);
		return true;
	}
}
*/
class MPItemAdapter extends BaseAdapter{

	private Context m_context;
	private int m_layout;
	private LayoutInflater m_inflater;
	private ArrayList<MPItem> m_items;
	
	public MPItemAdapter(Context _c, int _layout, ArrayList<MPItem> _items){
		m_context = _c;
		m_layout = _layout;
		m_items = _items;
		init();
	}
	
	public void init(){
		m_inflater = (LayoutInflater)m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return m_items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return m_items.get(position).getName();
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final int pos = position;
		if(convertView == null){
			convertView = m_inflater.inflate(m_layout, parent, false);
		}
		ImageView img = (ImageView)convertView.findViewById(R.id.item_image);
		img.setImageResource(m_items.get(pos).getImageId());
		
		TextView txt = (TextView)convertView.findViewById(R.id.item_text);
		txt.setText(m_items.get(pos).getName());		
		
		return convertView;
	}
	
}

class ImageAdapter extends BaseAdapter {
	private Context mContext;
	
	int[] picture = { R.drawable.list001, R.drawable.list002, R.drawable.list003, R.drawable.list004, R.drawable.list005 };
	
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