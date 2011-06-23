package kr.comnic.MyoungPum;

import android.graphics.Bitmap;

public class MPItem {
	public static final int MPITEM_RATING_1 = 1;
	public static final int MPITEM_RATING_2 = 2;
	public static final int MPITEM_RATING_3 = 3;
	public static final int MPITEM_RATING_4 = 4;
	public static final int MPITEM_RATING_5 = 5;
	
	private String m_name;
	private int m_imageId;
	private boolean m_isLike;
	private int m_rating;
	
	public MPItem(){
		
	}
	
	public MPItem(String _name, int _imgId, boolean _isLike, int _rate){
		setName(_name);
		setImageId(_imgId);
		setLike(_isLike);
		setRating(_rate);		
	}
	
	public void setName(String _name) {
		this.m_name = _name;
	}
	
	public String getName() {
		return m_name;
	}

	public void setImageId(int _imageId) {
		this.m_imageId = _imageId;
	}

	public int getImageId() {
		return m_imageId;
	}

	public void setLike(boolean _isLike) {
		this.m_isLike = _isLike;
	}

	public boolean isLike() {
		return m_isLike;
	}

	public void setRating(int _rating) {
		this.m_rating = _rating;
	}

	public int getRating() {
		return m_rating;
	}
	
}
