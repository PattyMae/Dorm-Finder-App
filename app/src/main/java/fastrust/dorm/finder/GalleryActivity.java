package fastrust.dorm.finder;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.prime.arab.ware.everythingutils.*;
import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import com.shobhitpuri.custombuttons.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class GalleryActivity extends AppCompatActivity {
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview2;
	private HorizontalScrollView hscroll1;
	private TextView textview3;
	private HorizontalScrollView hscroll2;
	private TextView textview4;
	private HorizontalScrollView hscroll3;
	private ImageView back;
	private TextView textview1;
	private LinearLayout linear3;
	private CardView cardview1;
	private CardView cardview2;
	private CardView cardview3;
	private CardView cardview4;
	private ImageView imageview1;
	private ImageView imageview2;
	private ImageView imageview4;
	private ImageView imageview3;
	private LinearLayout linear4;
	private CardView cardview5;
	private CardView cardview6;
	private CardView cardview7;
	private CardView cardview8;
	private ImageView imageview5;
	private ImageView imageview6;
	private ImageView imageview7;
	private ImageView imageview8;
	private LinearLayout linear5;
	private CardView cardview9;
	private CardView cardview10;
	private CardView cardview11;
	private CardView cardview12;
	private ImageView imageview9;
	private ImageView imageview10;
	private ImageView imageview11;
	private ImageView imageview12;
	
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.gallery);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		textview2 = findViewById(R.id.textview2);
		hscroll1 = findViewById(R.id.hscroll1);
		textview3 = findViewById(R.id.textview3);
		hscroll2 = findViewById(R.id.hscroll2);
		textview4 = findViewById(R.id.textview4);
		hscroll3 = findViewById(R.id.hscroll3);
		back = findViewById(R.id.back);
		textview1 = findViewById(R.id.textview1);
		linear3 = findViewById(R.id.linear3);
		cardview1 = findViewById(R.id.cardview1);
		cardview2 = findViewById(R.id.cardview2);
		cardview3 = findViewById(R.id.cardview3);
		cardview4 = findViewById(R.id.cardview4);
		imageview1 = findViewById(R.id.imageview1);
		imageview2 = findViewById(R.id.imageview2);
		imageview4 = findViewById(R.id.imageview4);
		imageview3 = findViewById(R.id.imageview3);
		linear4 = findViewById(R.id.linear4);
		cardview5 = findViewById(R.id.cardview5);
		cardview6 = findViewById(R.id.cardview6);
		cardview7 = findViewById(R.id.cardview7);
		cardview8 = findViewById(R.id.cardview8);
		imageview5 = findViewById(R.id.imageview5);
		imageview6 = findViewById(R.id.imageview6);
		imageview7 = findViewById(R.id.imageview7);
		imageview8 = findViewById(R.id.imageview8);
		linear5 = findViewById(R.id.linear5);
		cardview9 = findViewById(R.id.cardview9);
		cardview10 = findViewById(R.id.cardview10);
		cardview11 = findViewById(R.id.cardview11);
		cardview12 = findViewById(R.id.cardview12);
		imageview9 = findViewById(R.id.imageview9);
		imageview10 = findViewById(R.id.imageview10);
		imageview11 = findViewById(R.id.imageview11);
		imageview12 = findViewById(R.id.imageview12);
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ViewPhotoActivity.class);
				intent.putExtra("link", getIntent().getStringExtra("photo1"));
				startActivity(intent);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ViewPhotoActivity.class);
				intent.putExtra("link", getIntent().getStringExtra("photo2"));
				startActivity(intent);
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ViewPhotoActivity.class);
				intent.putExtra("link", getIntent().getStringExtra("photo3"));
				startActivity(intent);
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ViewPhotoActivity.class);
				intent.putExtra("link", getIntent().getStringExtra("photo4"));
				startActivity(intent);
			}
		});
		
		imageview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ViewPhotoActivity.class);
				intent.putExtra("link", getIntent().getStringExtra("photo5"));
				startActivity(intent);
			}
		});
		
		imageview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ViewPhotoActivity.class);
				intent.putExtra("link", getIntent().getStringExtra("photo6"));
				startActivity(intent);
			}
		});
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ViewPhotoActivity.class);
				intent.putExtra("link", getIntent().getStringExtra("photo7"));
				startActivity(intent);
			}
		});
		
		imageview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ViewPhotoActivity.class);
				intent.putExtra("link", getIntent().getStringExtra("photo8"));
				startActivity(intent);
			}
		});
		
		imageview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ViewPhotoActivity.class);
				intent.putExtra("link", getIntent().getStringExtra("photo9"));
				startActivity(intent);
			}
		});
		
		imageview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ViewPhotoActivity.class);
				intent.putExtra("link", getIntent().getStringExtra("photo10"));
				startActivity(intent);
			}
		});
		
		imageview11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ViewPhotoActivity.class);
				intent.putExtra("link", getIntent().getStringExtra("photo11"));
				startActivity(intent);
			}
		});
		
		imageview12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ViewPhotoActivity.class);
				intent.putExtra("link", getIntent().getStringExtra("photo12"));
				startActivity(intent);
			}
		});
	}
	
	private void initializeLogic() {
		_advance(linear1);
		_riffleEffect("#176b87", back);
		_ImageColor(back, "#176b87");
		_removeScollBar(hscroll1);
		_removeScollBar(hscroll2);
		_removeScollBar(hscroll3);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("photo1"))).into(imageview1);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("photo2"))).into(imageview2);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("photo3"))).into(imageview3);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("photo4"))).into(imageview4);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("photo5"))).into(imageview5);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("photo6"))).into(imageview6);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("photo7"))).into(imageview7);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("photo8"))).into(imageview8);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("photo9"))).into(imageview9);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("photo10"))).into(imageview10);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("photo11"))).into(imageview11);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("photo12"))).into(imageview12);
	}
	
	public void _advance(final View _linear) {
		try{
			
			_linear.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
			Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(Color.parseColor("#ffffff"));
			
		}catch (Exception ex) {
			
		}finally{
			
		}
	}
	
	
	public void _riffleEffect(final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)}); android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null); _view.setBackground(ripdr);
	}
	
	
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}