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
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
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
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class AdminBookingActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private String str1 = "";
	private String str2 = "";
	private String str3 = "";
	
	private ArrayList<HashMap<String, Object>> request_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> active_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> completed_listmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView back;
	private TextView textview1;
	private TabLayout tablayout1;
	private RecyclerView recyclerview1;
	private RecyclerView recyclerview2;
	private RecyclerView recyclerview3;
	
	private DatabaseReference booking_request = _firebase.getReference("booking");
	private ChildEventListener _booking_request_child_listener;
	private Intent intent = new Intent();
	private DatabaseReference active_booking = _firebase.getReference("booking");
	private ChildEventListener _active_booking_child_listener;
	private DatabaseReference completed_booking = _firebase.getReference("booking");
	private ChildEventListener _completed_booking_child_listener;
	private FirebaseAuth fauth;
	private OnCompleteListener<AuthResult> _fauth_create_user_listener;
	private OnCompleteListener<AuthResult> _fauth_sign_in_listener;
	private OnCompleteListener<Void> _fauth_reset_password_listener;
	private OnCompleteListener<Void> fauth_updateEmailListener;
	private OnCompleteListener<Void> fauth_updatePasswordListener;
	private OnCompleteListener<Void> fauth_emailVerificationSentListener;
	private OnCompleteListener<Void> fauth_deleteUserListener;
	private OnCompleteListener<Void> fauth_updateProfileListener;
	private OnCompleteListener<AuthResult> fauth_phoneAuthListener;
	private OnCompleteListener<AuthResult> fauth_googleSignInListener;
	
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.admin_booking);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		back = findViewById(R.id.back);
		textview1 = findViewById(R.id.textview1);
		tablayout1 = findViewById(R.id.tablayout1);
		recyclerview1 = findViewById(R.id.recyclerview1);
		recyclerview2 = findViewById(R.id.recyclerview2);
		recyclerview3 = findViewById(R.id.recyclerview3);
		fauth = FirebaseAuth.getInstance();
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		tablayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				final int _position = tab.getPosition();
				if (_position == 0) {
					recyclerview1.setVisibility(View.VISIBLE);
					recyclerview2.setVisibility(View.GONE);
					recyclerview3.setVisibility(View.GONE);
				}
				if (_position == 1) {
					recyclerview1.setVisibility(View.GONE);
					recyclerview2.setVisibility(View.VISIBLE);
					recyclerview3.setVisibility(View.GONE);
				}
				if (_position == 2) {
					recyclerview1.setVisibility(View.GONE);
					recyclerview2.setVisibility(View.GONE);
					recyclerview3.setVisibility(View.VISIBLE);
				}
			}
			
			@Override
			public void onTabUnselected(TabLayout.Tab tab) {
				final int _position = tab.getPosition();
				
			}
			
			@Override
			public void onTabReselected(TabLayout.Tab tab) {
				final int _position = tab.getPosition();
				
			}
		});
		
		_booking_request_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				booking_request.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						request_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								request_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
							recyclerview1.setAdapter(new Recyclerview1Adapter(request_listmap));
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
				booking_request.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						request_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								request_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
							recyclerview1.setAdapter(new Recyclerview1Adapter(request_listmap));
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
		booking_request.addChildEventListener(_booking_request_child_listener);
		
		_active_booking_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				active_booking.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						active_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								active_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
							recyclerview2.setAdapter(new Recyclerview2Adapter(active_listmap));
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
				active_booking.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						active_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								active_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
							recyclerview2.setAdapter(new Recyclerview2Adapter(active_listmap));
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
		active_booking.addChildEventListener(_active_booking_child_listener);
		
		_completed_booking_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				completed_booking.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						completed_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								completed_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
							recyclerview3.setAdapter(new Recyclerview3Adapter(completed_listmap));
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
				completed_booking.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						completed_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								completed_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
							recyclerview3.setAdapter(new Recyclerview3Adapter(completed_listmap));
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
		completed_booking.addChildEventListener(_completed_booking_child_listener);
		
		fauth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		fauth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_fauth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fauth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fauth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		_advance(linear1);
		_ImageColor(back, "#176b87");
		_riffleEffect("#f5f5f5", back);
		tablayout1.setTabTextColors(0xFFE0E0E0, 0xFF186B87);
		tablayout1.setTabRippleColor(new android.content.res.ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}}, 
		
		new int[] {0xFFFFFFFF}));
		tablayout1.setSelectedTabIndicatorColor(0xFF176B87);
		tablayout1.setInlineLabel(true);
		tablayout1.addTab(tablayout1.newTab().setText("Booking Request"));
		tablayout1.addTab(tablayout1.newTab().setText("Active"));
		tablayout1.addTab(tablayout1.newTab().setText("Completed"));
		recyclerview1.setLayoutManager(new LinearLayoutManager(this));
		recyclerview2.setLayoutManager(new LinearLayoutManager(this));
		recyclerview3.setLayoutManager(new LinearLayoutManager(this));
		str1 = "booking/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
		booking_request = _firebase.getReference(str1);
		booking_request.addChildEventListener(_booking_request_child_listener);
		str2 = "booking/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
		active_booking = _firebase.getReference(str2);
		active_booking.addChildEventListener(_active_booking_child_listener);
		str3 = "booking/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
		completed_booking = _firebase.getReference(str3);
		completed_booking.addChildEventListener(_completed_booking_child_listener);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		recyclerview1.setLayoutManager(new LinearLayoutManager(this));
		recyclerview2.setLayoutManager(new LinearLayoutManager(this));
		recyclerview3.setLayoutManager(new LinearLayoutManager(this));
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
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#9E9E9E")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
		_view.setBackground(GA8PO9);
	}
	
	
	public void _simpleRiffle1(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#176b87")), null);
		
		_view.setBackground(GA8PO9);
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.booking_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout bg = _view.findViewById(R.id.bg);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout line = _view.findViewById(R.id.line);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final androidx.cardview.widget.CardView cardview3 = _view.findViewById(R.id.cardview3);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final ImageView photo = _view.findViewById(R.id.photo);
			final TextView title = _view.findViewById(R.id.title);
			final TextView date = _view.findViewById(R.id.date);
			final TextView guess_name = _view.findViewById(R.id.guess_name);
			final TextView payment_method = _view.findViewById(R.id.payment_method);
			final TextView payment_status = _view.findViewById(R.id.payment_status);
			final androidx.cardview.widget.CardView view_details_layout = _view.findViewById(R.id.view_details_layout);
			final androidx.cardview.widget.CardView edit_details_layout = _view.findViewById(R.id.edit_details_layout);
			final LinearLayout view_details_btn = _view.findViewById(R.id.view_details_btn);
			final TextView textview6 = _view.findViewById(R.id.textview6);
			final LinearLayout edit_details_btn = _view.findViewById(R.id.edit_details_btn);
			final TextView textview7 = _view.findViewById(R.id.textview7);
			
			_simpleRiffle1(view_details_btn);
			_simpleRiffle1(edit_details_btn);
			payment_status.setVisibility(View.GONE);
			if (_data.get((int)(_data.size() - 1) - _position).get("status").toString().equals("pending") || _data.get((int)(_data.size() - 1) - _position).get("status").toString().equals("process")) {
				bg.setVisibility(View.VISIBLE);
			}
			else {
				bg.setVisibility(View.GONE);
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("photo")) {
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)(_data.size() - 1) - _position).get("photo").toString())).into(photo);
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("dormitory name")) {
				title.setText(_data.get((int)(_data.size() - 1) - _position).get("dormitory name").toString());
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("date")) {
				date.setText(_data.get((int)(_data.size() - 1) - _position).get("date").toString());
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("guess name")) {
				guess_name.setText("Guess Name: ".concat(_data.get((int)(_data.size() - 1) - _position).get("guess name").toString()));
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("payment method")) {
				payment_method.setText("Payment Method: ".concat(_data.get((int)(_data.size() - 1) - _position).get("payment method").toString()));
			}
			else {
				
			}
			view_details_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), BookingDetailsActivity.class);
					intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
					intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
					intent.putExtra("status", _data.get((int)(_data.size() - 1) - _position).get("status").toString());
					startActivity(intent);
				}
			});
			edit_details_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), UserDetailsActivity.class);
					intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
					intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
					intent.putExtra("status", _data.get((int)(_data.size() - 1) - _position).get("status").toString());
					startActivity(intent);
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
	
	public class Recyclerview2Adapter extends RecyclerView.Adapter<Recyclerview2Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.booking_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout bg = _view.findViewById(R.id.bg);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout line = _view.findViewById(R.id.line);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final androidx.cardview.widget.CardView cardview3 = _view.findViewById(R.id.cardview3);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final ImageView photo = _view.findViewById(R.id.photo);
			final TextView title = _view.findViewById(R.id.title);
			final TextView date = _view.findViewById(R.id.date);
			final TextView guess_name = _view.findViewById(R.id.guess_name);
			final TextView payment_method = _view.findViewById(R.id.payment_method);
			final TextView payment_status = _view.findViewById(R.id.payment_status);
			final androidx.cardview.widget.CardView view_details_layout = _view.findViewById(R.id.view_details_layout);
			final androidx.cardview.widget.CardView edit_details_layout = _view.findViewById(R.id.edit_details_layout);
			final LinearLayout view_details_btn = _view.findViewById(R.id.view_details_btn);
			final TextView textview6 = _view.findViewById(R.id.textview6);
			final LinearLayout edit_details_btn = _view.findViewById(R.id.edit_details_btn);
			final TextView textview7 = _view.findViewById(R.id.textview7);
			
			_simpleRiffle1(view_details_btn);
			_simpleRiffle1(edit_details_btn);
			if (_data.get((int)(_data.size() - 1) - _position).get("status").toString().equals("active")) {
				bg.setVisibility(View.VISIBLE);
			}
			else {
				bg.setVisibility(View.GONE);
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("photo")) {
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)(_data.size() - 1) - _position).get("photo").toString())).into(photo);
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("dormitory name")) {
				title.setText(_data.get((int)(_data.size() - 1) - _position).get("dormitory name").toString());
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("date")) {
				date.setText(_data.get((int)(_data.size() - 1) - _position).get("date").toString());
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("guess name")) {
				guess_name.setText("Guess Name: ".concat(_data.get((int)(_data.size() - 1) - _position).get("guess name").toString()));
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("payment method")) {
				payment_method.setText("Payment Method: ".concat(_data.get((int)(_data.size() - 1) - _position).get("payment method").toString()));
			}
			else {
				
			}
			view_details_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), BookingDetailsActivity.class);
					intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
					intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
					intent.putExtra("status", _data.get((int)(_data.size() - 1) - _position).get("status").toString());
					startActivity(intent);
				}
			});
			edit_details_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), UserDetailsActivity.class);
					intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
					intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
					intent.putExtra("status", _data.get((int)(_data.size() - 1) - _position).get("status").toString());
					startActivity(intent);
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
	
	public class Recyclerview3Adapter extends RecyclerView.Adapter<Recyclerview3Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview3Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.booking_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout bg = _view.findViewById(R.id.bg);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout line = _view.findViewById(R.id.line);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final androidx.cardview.widget.CardView cardview3 = _view.findViewById(R.id.cardview3);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final ImageView photo = _view.findViewById(R.id.photo);
			final TextView title = _view.findViewById(R.id.title);
			final TextView date = _view.findViewById(R.id.date);
			final TextView guess_name = _view.findViewById(R.id.guess_name);
			final TextView payment_method = _view.findViewById(R.id.payment_method);
			final TextView payment_status = _view.findViewById(R.id.payment_status);
			final androidx.cardview.widget.CardView view_details_layout = _view.findViewById(R.id.view_details_layout);
			final androidx.cardview.widget.CardView edit_details_layout = _view.findViewById(R.id.edit_details_layout);
			final LinearLayout view_details_btn = _view.findViewById(R.id.view_details_btn);
			final TextView textview6 = _view.findViewById(R.id.textview6);
			final LinearLayout edit_details_btn = _view.findViewById(R.id.edit_details_btn);
			final TextView textview7 = _view.findViewById(R.id.textview7);
			
			_simpleRiffle1(view_details_btn);
			_simpleRiffle1(edit_details_btn);
			if (_data.get((int)(_data.size() - 1) - _position).get("status").toString().equals("completed")) {
				bg.setVisibility(View.VISIBLE);
				payment_status.setText("Payment Status: ".concat(_data.get((int)(_data.size() - 1) - _position).get("payment status").toString()));
			}
			else {
				bg.setVisibility(View.GONE);
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("photo")) {
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)(_data.size() - 1) - _position).get("photo").toString())).into(photo);
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("dormitory name")) {
				title.setText(_data.get((int)(_data.size() - 1) - _position).get("dormitory name").toString());
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("date")) {
				date.setText(_data.get((int)(_data.size() - 1) - _position).get("date").toString());
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("guess name")) {
				guess_name.setText("Guess Name: ".concat(_data.get((int)(_data.size() - 1) - _position).get("guess name").toString()));
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("payment method")) {
				payment_method.setText("Payment Method: ".concat(_data.get((int)(_data.size() - 1) - _position).get("payment method").toString()));
			}
			else {
				
			}
			view_details_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), BookingDetailsActivity.class);
					intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
					intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
					intent.putExtra("status", _data.get((int)(_data.size() - 1) - _position).get("status").toString());
					startActivity(intent);
				}
			});
			edit_details_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), UserDetailsActivity.class);
					intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
					intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
					intent.putExtra("status", _data.get((int)(_data.size() - 1) - _position).get("status").toString());
					startActivity(intent);
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