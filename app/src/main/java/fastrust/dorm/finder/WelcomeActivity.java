package fastrust.dorm.finder;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.prime.arab.ware.everythingutils.*;
import com.google.firebase.FirebaseApp;
import com.shobhitpuri.custombuttons.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class WelcomeActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private double lat = 0;
	private double lng = 0;
	private double acc = 0;
	private double valid = 0;
	private double lat1 = 0;
	private double lng1 = 0;
	private String strAdd = "";
	private String strCity = "";
	private String strState = "";
	private String strCountry = "";
	private String strPC = "";
	private String strKN = "";
	
	private LinearLayout linear1;
	private LinearLayout welcome1;
	private LinearLayout welcome2;
	private LinearLayout welcome3;
	private LinearLayout welcome4;
	private LinearLayout linear2;
	private CardView cardview1;
	private LinearLayout next1;
	private TextView textview1;
	private LinearLayout linear3;
	private CardView cardview2;
	private LinearLayout next2;
	private TextView textview2;
	private LinearLayout linear4;
	private CardView cardview3;
	private LinearLayout get_started;
	private TextView textview3;
	
	private TimerTask timer;
	private Intent intent = new Intent();
	private SharedPreferences data;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.welcome);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		welcome1 = findViewById(R.id.welcome1);
		welcome2 = findViewById(R.id.welcome2);
		welcome3 = findViewById(R.id.welcome3);
		welcome4 = findViewById(R.id.welcome4);
		linear2 = findViewById(R.id.linear2);
		cardview1 = findViewById(R.id.cardview1);
		next1 = findViewById(R.id.next1);
		textview1 = findViewById(R.id.textview1);
		linear3 = findViewById(R.id.linear3);
		cardview2 = findViewById(R.id.cardview2);
		next2 = findViewById(R.id.next2);
		textview2 = findViewById(R.id.textview2);
		linear4 = findViewById(R.id.linear4);
		cardview3 = findViewById(R.id.cardview3);
		get_started = findViewById(R.id.get_started);
		textview3 = findViewById(R.id.textview3);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		next1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				welcome1.setVisibility(View.GONE);
				welcome2.setVisibility(View.GONE);
				welcome3.setVisibility(View.VISIBLE);
				welcome4.setVisibility(View.GONE);
			}
		});
		
		next2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				welcome1.setVisibility(View.GONE);
				welcome2.setVisibility(View.GONE);
				welcome3.setVisibility(View.GONE);
				welcome4.setVisibility(View.VISIBLE);
			}
		});
		
		get_started.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("welcome", "true").commit();
				intent.setClass(getApplicationContext(), Welcome1Activity.class);
				startActivity(intent);
				_fade_translate();
			}
		});
	}
	
	private void initializeLogic() {
		_advance(linear1);
		_rippleRoundStroke(next1, "#176b87", "#ffffff", 100, 0, "#176b87");
		_rippleRoundStroke(next2, "#176b87", "#ffffff", 100, 0, "#176b87");
		_rippleRoundStroke(get_started, "#176b87", "#ffffff", 100, 0, "#176b87");
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						welcome1.setVisibility(View.GONE);
						welcome2.setVisibility(View.VISIBLE);
						welcome3.setVisibility(View.GONE);
						welcome4.setVisibility(View.GONE);
					}
				});
			}
		};
		_timer.schedule(timer, (int)(2000));
	}
	
	@Override
	public void onBackPressed() {
		finishAffinity();
	}
	public void _advance(final View _linear) {
		try{
			
			_linear.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
			Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(Color.parseColor("#ffffff"));
			
		}catch (Exception ex) {
			
		}finally{
			
		}
	}
	
	
	public void _fade_translate() {
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	}
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	
	public void _setSingleLine(final TextView _view, final boolean _bool) {
		_view.setSingleLine(_bool);
	}
	
	
	public void _simpleRiffle(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#9E9E9E")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
		_view.setBackground(GA8PO9);
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