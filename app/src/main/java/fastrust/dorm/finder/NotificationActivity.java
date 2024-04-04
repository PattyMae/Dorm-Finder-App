package fastrust.dorm.finder;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.media.SoundPool;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.android.prime.arab.ware.everythingutils.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.shobhitpuri.custombuttons.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class NotificationActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String str = "";
	private double sound1 = 0;
	private HashMap<String, Object> map = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private LinearLayout bg;
	private LinearLayout linear1;
	private RecyclerView recyclerview1;
	private ImageView imageview1;
	private ImageView back;
	private TextView textview1;
	
	private DatabaseReference notification = _firebase.getReference("notification");
	private ChildEventListener _notification_child_listener;
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private Calendar cal = Calendar.getInstance();
	private Calendar now = Calendar.getInstance();
	private SoundPool sp;
	private Vibrator vb;
	private SharedPreferences data;
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.notification);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		bg = findViewById(R.id.bg);
		linear1 = findViewById(R.id.linear1);
		recyclerview1 = findViewById(R.id.recyclerview1);
		imageview1 = findViewById(R.id.imageview1);
		back = findViewById(R.id.back);
		textview1 = findViewById(R.id.textview1);
		auth = FirebaseAuth.getInstance();
		vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		_notification_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				notification.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (listmap.size() > 0) {
							recyclerview1.setAdapter(new Recyclerview1Adapter(listmap));
							imageview1.setVisibility(View.GONE);
							recyclerview1.setVisibility(View.VISIBLE);
						}
						else {
							imageview1.setVisibility(View.VISIBLE);
							recyclerview1.setVisibility(View.GONE);
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				notification.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (listmap.size() > 0) {
							recyclerview1.setAdapter(new Recyclerview1Adapter(listmap));
							imageview1.setVisibility(View.GONE);
							recyclerview1.setVisibility(View.VISIBLE);
						}
						else {
							imageview1.setVisibility(View.VISIBLE);
							recyclerview1.setVisibility(View.GONE);
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		notification.addChildEventListener(_notification_child_listener);
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		_advance(bg);
		_ImageColor(back, "#176b87");
		_riffleEffect("#f5f5f5", back);
		recyclerview1.setVisibility(View.GONE);
		sp = new SoundPool((int)(1), AudioManager.STREAM_MUSIC, 0);
		sound1 = sp.load(getApplicationContext(), R.raw.notification, 1);
		recyclerview1.setLayoutManager(new LinearLayoutManager(this));
		str = "notification/".concat(getIntent().getStringExtra("uid"));
		notification = _firebase.getReference(str);
		notification.addChildEventListener(_notification_child_listener);
	}
	
	public void _advance(final View _linear) {
		try{
			
			_linear.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
			Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(Color.parseColor("#ffffff"));
			
		}catch (Exception ex) {
			
		}finally{
			
		}
	}
	
	
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	
	public void _riffleEffect(final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)}); android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null); _view.setBackground(ripdr);
	}
	
	
	public void _simpleRiffle(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
		_view.setBackground(GA8PO9);
	}
	
	
	public void _notify() {
		if (data.getString("noti", "").equals("true")) {
			
		}
		else {
			if (data.getString("noti", "").equals("false")) {
				
			}
		}
		if (data.getString("sound", "").equals("true")) {
			sound1 = sp.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f);
		}
		else {
			if (data.getString("sound", "").equals("false")) {
				
			}
		}
		if (data.getString("vibrate", "").equals("true")) {
			vb.vibrate((long)(500));
		}
		else {
			if (data.getString("vibrate", "").equals("false")) {
				
			}
		}
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.notification_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout bg = _view.findViewById(R.id.bg);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView message = _view.findViewById(R.id.message);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final ImageView profile = _view.findViewById(R.id.profile);
			final TextView title = _view.findViewById(R.id.title);
			final TextView date = _view.findViewById(R.id.date);
			final TextView new_layout = _view.findViewById(R.id.new_layout);
			
			_simpleRiffle(bg);
			if (_data.get((int)(_data.size() - 1) - _position).get("seen").toString().contains("true")) {
				cardview2.setVisibility(View.GONE);
			}
			else {
				if (_data.get((int)(_data.size() - 1) - _position).get("seen").toString().contains("false")) {
					cardview2.setVisibility(View.VISIBLE);
					_notify();
				}
				else {
					
				}
			}
			if (_data.get((int)(_data.size() - 1) - _position).get("profile").toString().contains("account")) {
				profile.setImageResource(R.drawable.profile);
				profile.setBackgroundColor(0xFFF5F5F5);
			}
			else {
				if (_data.get((int)(_data.size() - 1) - _position).get("profile").toString().contains("book")) {
					profile.setImageResource(R.drawable.calendar);
					_ImageColor(profile, "#176b87");
					profile.setBackgroundColor(0xFFE0E0E0);
				}
				else {
					
				}
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("title")) {
				title.setText(_data.get((int)(_data.size() - 1) - _position).get("title").toString());
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("date")) {
				cal.setTimeInMillis((long)(Double.parseDouble(_data.get((int)(_data.size() - 1) - _position).get("date").toString())));
				now = Calendar.getInstance();
				if ((long)(now.getTimeInMillis() - cal.getTimeInMillis()) > (1000 * (3600 * 24))) {
					date.setText(new SimpleDateFormat("MMM dd, yyyy").format(cal.getTime()).concat(" | ".concat(new SimpleDateFormat("hh:mm a").format(cal.getTime()))));
				}
				else {
					date.setText(new SimpleDateFormat("hh:mm a").format(cal.getTime()));
				}
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("message")) {
				message.setText(_data.get((int)(_data.size() - 1) - _position).get("message").toString());
			}
			else {
				
			}
			bg.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					map = new HashMap<>();
					map.put("seen", "true");
					notification.child(_data.get((int)(_data.size() - 1) - _position).get("getPost").toString()).updateChildren(map);
					if (_data.get((int)(_data.size() - 1) - _position).get("profile").toString().contains("account")) {
						
					}
					else {
						if (data.getString("user", "").equals("owner")) {
							intent.setClass(getApplicationContext(), UserDetailsActivity.class);
							intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
							intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
							intent.putExtra("status", _data.get((int)(_data.size() - 1) - _position).get("status").toString());
							startActivity(intent);
						}
						else {
							if (data.getString("user", "").equals("student")) {
								if (_data.get((int)(_data.size() - 1) - _position).get("status").toString().equals("pending")) {
									intent.setClass(getApplicationContext(), BookingDetailsActivity.class);
									intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
									intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
									startActivity(intent);
								}
								else {
									if (_data.get((int)(_data.size() - 1) - _position).get("status").toString().equals("canceled")) {
										intent.setClass(getApplicationContext(), BookingDetailsActivity.class);
										intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
										intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
										startActivity(intent);
									}
									else {
										if (_data.get((int)(_data.size() - 1) - _position).get("status").toString().equals("rejected")) {
											intent.setClass(getApplicationContext(), BookingDetailsActivity.class);
											intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
											intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
											startActivity(intent);
										}
										else {
											intent.setClass(getApplicationContext(), BookingActivity.class);
											intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
											intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
											intent.putExtra("book", "true");
											startActivity(intent);
										}
									}
								}
							}
						}
					}
				}
			});
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
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