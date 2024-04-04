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
import com.google.firebase.FirebaseApp;
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

public class AllReviewsActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private boolean isVisible = false;
	private HashMap<String, Object> map = new HashMap<>();
	private double rating = 0;
	private double reviewCount = 0;
	private double PcountN = 0;
	private HashMap<String, Object> UserProfile = new HashMap<>();
	private HashMap<String, Object> UserName = new HashMap<>();
	TextView user_fullname;
	ImageView user_profile;
	private String str = "";
	
	private ArrayList<HashMap<String, Object>> review_listmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private RecyclerView recyclerview1;
	private TextView textview2;
	private ImageView back;
	private TextView textview1;
	
	private DatabaseReference post = _firebase.getReference("post");
	private ChildEventListener _post_child_listener;
	private DatabaseReference reviews = _firebase.getReference("reviews");
	private ChildEventListener _reviews_child_listener;
	private Calendar cal = Calendar.getInstance();
	private Calendar now = Calendar.getInstance();
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.all_reviews);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		recyclerview1 = findViewById(R.id.recyclerview1);
		textview2 = findViewById(R.id.textview2);
		back = findViewById(R.id.back);
		textview1 = findViewById(R.id.textview1);
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		_post_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("getPost"))) {
					rating = Double.parseDouble(_childValue.get("rating").toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		post.addChildEventListener(_post_child_listener);
		
		_reviews_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				reviews.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						review_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								review_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						recyclerview1.setAdapter(new Recyclerview1Adapter(review_listmap));
						textview2.setVisibility(View.GONE);
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
		reviews.addChildEventListener(_reviews_child_listener);
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("userKey") && _childValue.containsKey("profile")) {
					UserProfile.put(_childValue.get("userKey").toString(), _childValue.get("profile").toString());
				}
				if (_childValue.containsKey("userKey") && _childValue.containsKey("fullname")) {
					UserName.put(_childValue.get("userKey").toString(), _childValue.get("fullname").toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		users.addChildEventListener(_users_child_listener);
	}
	
	private void initializeLogic() {
		_advance(linear1);
		_ImageColor(back, "#176b87");
		_riffleEffect("#176b87", back);
		users.addChildEventListener(_users_child_listener);
		post.addChildEventListener(_post_child_listener);
		recyclerview1.setLayoutManager(new LinearLayoutManager(this));
		textview1.setText(getIntent().getStringExtra("review"));
		str = "post/".concat(getIntent().getStringExtra("getPost").concat("/reviews"));
		reviews = _firebase.getReference(str);
		reviews.addChildEventListener(_reviews_child_listener);
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
	
	
	public void _telegramLoaderDialog(final boolean _visibility) {
		if (_visibility) {
			isVisible = true;
			if (coreprog == null){
				coreprog = new ProgressDialog(this);
				coreprog.setCancelable(false);
				coreprog.setCanceledOnTouchOutside(false);
				
				coreprog.requestWindowFeature(Window.FEATURE_NO_TITLE);  coreprog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				
			}
			coreprog.show();
			coreprog.setContentView(R.layout.loading);
			
			
			LinearLayout linear2 = (LinearLayout)coreprog.findViewById(R.id.linear2);
			
			LinearLayout background = (LinearLayout)coreprog.findViewById(R.id.background);
			
			LinearLayout layout_progress = (LinearLayout)coreprog.findViewById(R.id.layout_progress);
			
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); 
			gd.setColor(Color.parseColor("#E0E0E0")); /* color */
			gd.setCornerRadius(40); /* radius */
			gd.setStroke(0, Color.WHITE); /* stroke heigth and color */
			linear2.setBackground(gd);
			
			RadialProgressView progress = new RadialProgressView(this);
			layout_progress.addView(progress);
		}
		else {
			isVisible = false;
			if (coreprog != null){
				coreprog.dismiss();
			}
		}
	}
	private ProgressDialog coreprog;
	{
	}
	
	
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	
	public void _setSingleLine(final TextView _view, final boolean _bool) {
		_view.setSingleLine(_bool);
	}
	
	
	public void _simpleRiffle(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
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
			View _v = _inflater.inflate(R.layout.review_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final TextView message = _view.findViewById(R.id.message);
			final TextView date = _view.findViewById(R.id.date);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final TextView user_fullname = _view.findViewById(R.id.user_fullname);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final ImageView see_review = _view.findViewById(R.id.see_review);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final androidx.cardview.widget.CardView cardview4 = _view.findViewById(R.id.cardview4);
			final ImageView user_profile = _view.findViewById(R.id.user_profile);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final androidx.cardview.widget.CardView cardview3 = _view.findViewById(R.id.cardview3);
			final TextView rate = _view.findViewById(R.id.rate);
			
			_simpleRiffle(linear1);
			_riffleEffect("#f5f5f5", see_review);
			_setSingleLine(user_fullname, true);
			_ImageColor(see_review, "#176b87");
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("profile")) {
				Glide.with(getApplicationContext()).load(Uri.parse(UserProfile.get(_data.get((int)(_data.size() - 1) - _position).get("profile").toString()).toString())).into(user_profile);
			}
			else {
				user_profile.setImageResource(R.drawable.profile);
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("fullname")) {
				user_fullname.setText(UserName.get(_data.get((int)(_data.size() - 1) - _position).get("fullname").toString()).toString());
			}
			else {
				user_fullname.setText("Anonymous");
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("rating")) {
				rate.setText("⭐ ".concat(_data.get((int)(_data.size() - 1) - _position).get("rating").toString()));
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("msg")) {
				message.setText(_data.get((int)(_data.size() - 1) - _position).get("msg").toString());
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("date")) {
				cal.setTimeInMillis((long)(Double.parseDouble(_data.get((int)(_data.size() - 1) - _position).get("date").toString())));
				now = Calendar.getInstance();
				if ((long)(now.getTimeInMillis() - cal.getTimeInMillis()) > (1000 * (3600 * 24))) {
					date.setText(new SimpleDateFormat("MMM dd, yyyy").format(cal.getTime()));
				}
				else {
					date.setText(new SimpleDateFormat("hh:mm a").format(cal.getTime()));
				}
			}
			else {
				
			}
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					
				}
			});
			see_review.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), ReteDormitoryActivity.class);
					intent.putExtra("post getPost", getIntent().getStringExtra("getPost"));
					intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
					intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
					intent.putExtra("review", "true");
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