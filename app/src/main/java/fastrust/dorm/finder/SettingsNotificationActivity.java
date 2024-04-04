package fastrust.dorm.finder;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.media.SoundPool;
import android.net.*;
import android.os.*;
import android.os.Vibrator;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.prime.arab.ware.everythingutils.*;
import com.google.firebase.FirebaseApp;
import com.shobhitpuri.custombuttons.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class SettingsNotificationActivity extends AppCompatActivity {
	
	private double sound1 = 0;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private Switch switch1;
	private LinearLayout select_general_notification;
	private Switch switch2;
	private LinearLayout select_sound;
	private Switch switch3;
	private LinearLayout select_vibrate;
	private ImageView back_icon;
	private TextView textview1;
	
	private SharedPreferences data;
	private SoundPool notify;
	private Vibrator vb;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.settings_notification);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		switch1 = findViewById(R.id.switch1);
		select_general_notification = findViewById(R.id.select_general_notification);
		switch2 = findViewById(R.id.switch2);
		select_sound = findViewById(R.id.select_sound);
		switch3 = findViewById(R.id.switch3);
		select_vibrate = findViewById(R.id.select_vibrate);
		back_icon = findViewById(R.id.back_icon);
		textview1 = findViewById(R.id.textview1);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					data.edit().putString("noti", "true").commit();
					sound1 = notify.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				}
				else {
					data.edit().putString("noti", "false").commit();
				}
			}
		});
		
		switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					data.edit().putString("sound", "true").commit();
				}
				else {
					data.edit().putString("sound", "false").commit();
				}
			}
		});
		
		switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					data.edit().putString("vibrate", "true").commit();
					vb.vibrate((long)(500));
				}
				else {
					data.edit().putString("vibrate", "false").commit();
				}
			}
		});
		
		back_icon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		_advance(linear1);
		_ImageColor(back_icon, "#176b87");
		_simpleRiffle(switch1);
		_simpleRiffle(switch2);
		_simpleRiffle(switch3);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		notify = new SoundPool((int)(1), AudioManager.STREAM_MUSIC, 0);
		sound1 = notify.load(getApplicationContext(), R.raw.notification, 1);
		if (data.getString("noti", "").equals("true")) {
			switch1.setChecked(true);
		}
		else {
			if (data.getString("noti", "").equals("false")) {
				switch1.setChecked(false);
			}
		}
		if (data.getString("sound", "").equals("true")) {
			switch2.setChecked(true);
		}
		else {
			if (data.getString("sound", "").equals("false")) {
				switch2.setChecked(false);
			}
		}
		if (data.getString("vibrate", "").equals("true")) {
			switch3.setChecked(true);
		}
		else {
			if (data.getString("vibrate", "").equals("false")) {
				switch3.setChecked(false);
			}
		}
	}
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	
	public void _advance(final View _linear) {
		try{
			
			_linear.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
			Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(Color.parseColor("#ffffff"));
			
		}catch (Exception ex) {
			
		}finally{
			
		}
	}
	
	
	public void _simpleRiffle(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
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