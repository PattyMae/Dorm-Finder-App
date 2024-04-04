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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class ReteDormitoryActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private double rating1 = 0;
	private double rating2 = 0;
	private double rating3 = 0;
	private double rating4 = 0;
	private double rating5 = 0;
	private double rating6 = 0;
	private double rating7 = 0;
	private double getRating = 0;
	private String rating = "";
	private double ratings = 0;
	private double ratings1 = 0;
	private boolean isVisible = false;
	private String getPost = "";
	private String str = "";
	
	private ArrayList<HashMap<String, Object>> reviews_listmap = new ArrayList<>();
	
	private LinearLayout bg;
	private LinearLayout top;
	private ScrollView vscroll1;
	private LinearLayout bottom;
	private ImageView back;
	private TextView textview1;
	private LinearLayout linear3;
	private LinearLayout linear1;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear16;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	private RatingBar ratingbar1;
	private TextView textview7;
	private TextView textview8;
	private RatingBar ratingbar2;
	private TextView textview9;
	private TextView textview10;
	private RatingBar ratingbar3;
	private TextView textview17;
	private TextView textview18;
	private RatingBar ratingbar4;
	private TextView textview11;
	private TextView textview12;
	private RatingBar ratingbar5;
	private TextView textview13;
	private TextView textview14;
	private RatingBar ratingbar6;
	private LinearLayout linear17;
	private TextView textview15;
	private TextView textview16;
	private RatingBar ratingbar7;
	private TextView textview6;
	private EditText edittext1;
	private Switch switch1;
	private LinearLayout linear15;
	private CardView cardview1;
	private CardView cardview2;
	private TextView maybe_later_btn;
	private TextView submit_btn;
	
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
	
	private DatabaseReference post = _firebase.getReference("post");
	private ChildEventListener _post_child_listener;
	private DatabaseReference reviews = _firebase.getReference("reviews");
	private ChildEventListener _reviews_child_listener;
	private SharedPreferences data;
	private Calendar cal = Calendar.getInstance();
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private Intent intent = new Intent();
	private DatabaseReference getpost = _firebase.getReference("getpost");
	private ChildEventListener _getpost_child_listener;
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private DatabaseReference booking = _firebase.getReference("booking");
	private ChildEventListener _booking_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.rete_dormitory);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		bg = findViewById(R.id.bg);
		top = findViewById(R.id.top);
		vscroll1 = findViewById(R.id.vscroll1);
		bottom = findViewById(R.id.bottom);
		back = findViewById(R.id.back);
		textview1 = findViewById(R.id.textview1);
		linear3 = findViewById(R.id.linear3);
		linear1 = findViewById(R.id.linear1);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		linear16 = findViewById(R.id.linear16);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		ratingbar1 = findViewById(R.id.ratingbar1);
		textview7 = findViewById(R.id.textview7);
		textview8 = findViewById(R.id.textview8);
		ratingbar2 = findViewById(R.id.ratingbar2);
		textview9 = findViewById(R.id.textview9);
		textview10 = findViewById(R.id.textview10);
		ratingbar3 = findViewById(R.id.ratingbar3);
		textview17 = findViewById(R.id.textview17);
		textview18 = findViewById(R.id.textview18);
		ratingbar4 = findViewById(R.id.ratingbar4);
		textview11 = findViewById(R.id.textview11);
		textview12 = findViewById(R.id.textview12);
		ratingbar5 = findViewById(R.id.ratingbar5);
		textview13 = findViewById(R.id.textview13);
		textview14 = findViewById(R.id.textview14);
		ratingbar6 = findViewById(R.id.ratingbar6);
		linear17 = findViewById(R.id.linear17);
		textview15 = findViewById(R.id.textview15);
		textview16 = findViewById(R.id.textview16);
		ratingbar7 = findViewById(R.id.ratingbar7);
		textview6 = findViewById(R.id.textview6);
		edittext1 = findViewById(R.id.edittext1);
		switch1 = findViewById(R.id.switch1);
		linear15 = findViewById(R.id.linear15);
		cardview1 = findViewById(R.id.cardview1);
		cardview2 = findViewById(R.id.cardview2);
		maybe_later_btn = findViewById(R.id.maybe_later_btn);
		submit_btn = findViewById(R.id.submit_btn);
		fauth = FirebaseAuth.getInstance();
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		network = new RequestNetwork(this);
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		ratingbar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar _ratingBar, float _value, boolean _fromUser) {
				rating1 = _value / 7;
			}
		});
		
		ratingbar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar _ratingBar, float _value, boolean _fromUser) {
				rating2 = _value / 7;
			}
		});
		
		ratingbar3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar _ratingBar, float _value, boolean _fromUser) {
				rating3 = _value / 7;
			}
		});
		
		ratingbar4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar _ratingBar, float _value, boolean _fromUser) {
				rating4 = _value / 7;
			}
		});
		
		ratingbar5.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar _ratingBar, float _value, boolean _fromUser) {
				rating5 = _value / 7;
			}
		});
		
		ratingbar6.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar _ratingBar, float _value, boolean _fromUser) {
				rating6 = _value / 7;
			}
		});
		
		ratingbar7.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar _ratingBar, float _value, boolean _fromUser) {
				rating7 = _value / 7;
			}
		});
		
		switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				
			}
		});
		
		maybe_later_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		submit_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_telegramLoaderDialog(true);
				network.startRequestNetwork(RequestNetworkController.GET, "https://dorm-finder-df3f2-default-rtdb.firebaseio.com/", "Error", _network_request_listener);
			}
		});
		
		_post_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("getPost"))) {
					getRating = Double.parseDouble(_childValue.get("rating").toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("getPost"))) {
					getRating = Double.parseDouble(_childValue.get("rating").toString());
				}
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
				if (_childKey.equals(getIntent().getStringExtra("getPost"))) {
					ratingbar1.setRating((float)Double.parseDouble(_childValue.get("rate1").toString()));
					ratingbar2.setRating((float)Double.parseDouble(_childValue.get("rate2").toString()));
					ratingbar3.setRating((float)Double.parseDouble(_childValue.get("rate3").toString()));
					ratingbar4.setRating((float)Double.parseDouble(_childValue.get("rate4").toString()));
					ratingbar5.setRating((float)Double.parseDouble(_childValue.get("rate5").toString()));
					ratingbar6.setRating((float)Double.parseDouble(_childValue.get("rate6").toString()));
					ratingbar7.setRating((float)Double.parseDouble(_childValue.get("rate7").toString()));
					edittext1.setText(_childValue.get("msg").toString());
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
		reviews.addChildEventListener(_reviews_child_listener);
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				getPost = getpost.push().getKey();
				ratings = rating1 + (rating2 + (rating3 + (rating4 + (rating5 + (rating6 + (rating7 + getRating))))));
				if (String.valueOf((long)(getRating)).equals("0")) {
					ratings1 = ratings;
				}
				else {
					ratings1 = ratings / 2;
				}
				map = new HashMap<>();
				map.put("rating", new DecimalFormat("#.#").format(ratings1));
				map.put("status", "rated");
				post.child(getIntent().getStringExtra("getPost")).updateChildren(map);
				booking.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(getIntent().getStringExtra("getPost")))).updateChildren(map);
				cal = Calendar.getInstance();
				map = new HashMap<>();
				if (switch1.isChecked()) {
					
				}
				else {
					map.put("fullname", FirebaseAuth.getInstance().getCurrentUser().getUid());
					map.put("profile", FirebaseAuth.getInstance().getCurrentUser().getUid());
				}
				map.put("msg", edittext1.getText().toString());
				map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				map.put("date", String.valueOf((long)(cal.getTimeInMillis())));
				map.put("rating", new DecimalFormat("#.#").format(ratings1));
				map.put("rate1", String.valueOf(ratingbar1.getRating()));
				map.put("rate2", String.valueOf(ratingbar2.getRating()));
				map.put("rate3", String.valueOf(ratingbar3.getRating()));
				map.put("rate4", String.valueOf(ratingbar4.getRating()));
				map.put("rate5", String.valueOf(ratingbar5.getRating()));
				map.put("rate6", String.valueOf(ratingbar6.getRating()));
				map.put("rate7", String.valueOf(ratingbar7.getRating()));
				map.put("getPost", getPost);
				post.child(getIntent().getStringExtra("getPost").concat("/reviews/".concat(getPost))).updateChildren(map);
				_telegramLoaderDialog(false);
				intent.setClass(getApplicationContext(), AllReviewsActivity.class);
				intent.putExtra("getPost", getIntent().getStringExtra("getPost"));
				startActivity(intent);
				SketchwareUtil.showMessage(getApplicationContext(), "Review sent");
				finish();
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_getpost_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		getpost.addChildEventListener(_getpost_child_listener);
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		
		_booking_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		booking.addChildEventListener(_booking_child_listener);
		
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
		_advance(bg);
		_ImageColor(back, "#176b87");
		_riffleEffect("#f5f5f5", back);
		_simpleRiffle(maybe_later_btn);
		_simpleRiffle1(submit_btn);
		ratingbar1.setNumStars((int)5);
		ratingbar2.setNumStars((int)5);
		ratingbar3.setNumStars((int)5);
		ratingbar4.setNumStars((int)5);
		ratingbar5.setNumStars((int)5);
		ratingbar6.setNumStars((int)5);
		ratingbar7.setNumStars((int)5);
		rating1 = 0;
		rating2 = 0;
		rating3 = 0;
		rating4 = 0;
		rating5 = 0;
		rating6 = 0;
		rating7 = 0;
		ratingbar1.setRating((float)0);
		ratingbar2.setRating((float)0);
		ratingbar3.setRating((float)0);
		ratingbar4.setRating((float)0);
		ratingbar5.setRating((float)0);
		ratingbar6.setRating((float)0);
		ratingbar7.setRating((float)0);
		post.addChildEventListener(_post_child_listener);
		if (getIntent().getStringExtra("review").equals("")) {
			
		}
		else {
			if (getIntent().getStringExtra("review").equals("true")) {
				textview1.setText("Ratings and Review Details");
				ratingbar1.setEnabled(false);
				ratingbar2.setEnabled(false);
				ratingbar3.setEnabled(false);
				ratingbar4.setEnabled(false);
				ratingbar5.setEnabled(false);
				ratingbar6.setEnabled(false);
				ratingbar7.setEnabled(false);
				edittext1.setEnabled(false);
				bottom.setVisibility(View.GONE);
				str = "post/".concat(getIntent().getStringExtra("post getPost").concat("/reviews"));
				reviews = _firebase.getReference(str);
				reviews.addChildEventListener(_reviews_child_listener);
			}
		}
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
	
	
	public void _simpleRiffle(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
		_view.setBackground(GA8PO9);
	}
	
	
	public void _simpleRiffle1(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#176b87")), null);
		
		_view.setBackground(GA8PO9);
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