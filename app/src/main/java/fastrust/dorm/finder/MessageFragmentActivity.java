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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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

public class MessageFragmentActivity extends Fragment {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private FloatingActionButton _fab;
	private String str = "";
	private HashMap<String, Object> map = new HashMap<>();
	private HashMap<String, Object> fullname = new HashMap<>();
	private HashMap<String, Object> profile = new HashMap<>();
	private HashMap<String, Object> UserProfile = new HashMap<>();
	private HashMap<String, Object> UserName = new HashMap<>();
	ImageView user_profile;
	TextView user_fullname;
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private LinearLayout bg;
	private LinearLayout linear3;
	private RecyclerView recyclerview1;
	private TextView textview2;
	
	private DatabaseReference message = _firebase.getReference("message");
	private ChildEventListener _message_child_listener;
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
	
	private Calendar cal = Calendar.getInstance();
	private Calendar now = Calendar.getInstance();
	private Intent intent = new Intent();
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.message_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		_fab = _view.findViewById(R.id._fab);
		
		bg = _view.findViewById(R.id.bg);
		linear3 = _view.findViewById(R.id.linear3);
		recyclerview1 = _view.findViewById(R.id.recyclerview1);
		textview2 = _view.findViewById(R.id.textview2);
		fauth = FirebaseAuth.getInstance();
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getContext().getApplicationContext(), SearchUserActivity.class);
				startActivity(intent);
			}
		});
		
		_message_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				message.addListenerForSingleValueEvent(new ValueEventListener() {
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
						recyclerview1.setAdapter(new Recyclerview1Adapter(listmap));
						if (_childValue.containsKey("date")) {
							_SortMap(listmap, "date", false, false);
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
				message.addListenerForSingleValueEvent(new ValueEventListener() {
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
						recyclerview1.setAdapter(new Recyclerview1Adapter(listmap));
						if (_childValue.containsKey("date")) {
							_SortMap(listmap, "date", false, false);
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
		message.addChildEventListener(_message_child_listener);
		
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
				if (_childValue.containsKey("userKey") && _childValue.containsKey("profile")) {
					UserProfile.put(_childValue.get("userKey").toString(), _childValue.get("profile").toString());
				}
				if (_childValue.containsKey("userKey") && _childValue.containsKey("fullname")) {
					UserName.put(_childValue.get("userKey").toString(), _childValue.get("fullname").toString());
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
		users.addChildEventListener(_users_child_listener);
		
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
		recyclerview1.setLayoutManager(new LinearLayoutManager(getContext()));
		str = "message/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
		message = _firebase.getReference(str);
		message.addChildEventListener(_message_child_listener);
		users.addChildEventListener(_users_child_listener);
	}
	
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	
	public void _setSingleLine(final TextView _view, final boolean _bool) {
		_view.setSingleLine(_bool);
	}
	
	
	public void _SortMap(final ArrayList<HashMap<String, Object>> _listMap, final String _key, final boolean _isNumber, final boolean _Ascending) {
		Collections.sort(_listMap, new Comparator<HashMap<String,Object>>(){
			public int compare(HashMap<String,Object> _compareMap1, HashMap<String,Object> _compareMap2){
				if (_isNumber) {
					int _count1 = Integer.valueOf(_compareMap1.get(_key).toString());
					int _count2 = Integer.valueOf(_compareMap2.get(_key).toString());
					if (_Ascending) {
						return _count1 < _count2 ? -1 : _count1 < _count2 ? 1 : 0;
					}
					else {
						return _count1 > _count2 ? -1 : _count1 > _count2 ? 1 : 0;
					}
				}
				else {
					if (_Ascending) {
						return (_compareMap1.get(_key).toString()).compareTo(_compareMap2.get(_key).toString());
					}
					else {
						return (_compareMap2.get(_key).toString()).compareTo(_compareMap1.get(_key).toString());
					}
				}
			}});
	}
	
	
	public void _simpleRiffle(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
		_view.setBackground(GA8PO9);
	}
	
	
	public void _Glide(final ImageView _img, final String _url) {
		Glide.with(MessageFragmentActivity.this)
		        .load(_url)
		        .circleCrop()
		        .into(_img);
		
	}
	
	
	public void _setRadiusCorner(final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.chat_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final ImageView user_profile = _view.findViewById(R.id.user_profile);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final TextView user_fullname = _view.findViewById(R.id.user_fullname);
			final TextView message = _view.findViewById(R.id.message);
			final androidx.cardview.widget.CardView chat_count_layout = _view.findViewById(R.id.chat_count_layout);
			final TextView date = _view.findViewById(R.id.date);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			
			_simpleRiffle(linear1);
			_setSingleLine(user_fullname, true);
			_setSingleLine(message, true);
			if (_data.get((int)_position).get("seen").toString().equals("true")) {
				chat_count_layout.setVisibility(View.GONE);
			}
			else {
				if (_data.get((int)_position).get("seen").toString().equals("false")) {
					chat_count_layout.setVisibility(View.VISIBLE);
				}
			}
			if (_data.get((int)_position).containsKey("uid")) {
				_Glide(user_profile, UserProfile.get(_data.get((int)_position).get("uid").toString()).toString());
				user_fullname.setText(UserName.get(_data.get((int)_position).get("uid").toString()).toString());
			}
			else {
				
			}
			if (_data.get((int)_position).containsKey("message")) {
				if (FirebaseAuth.getInstance().getCurrentUser().getUid().equals(_data.get((int)_position).get("myuid").toString())) {
					message.setText("You: ".concat(_data.get((int)_position).get("message").toString()));
				}
				else {
					message.setText(_data.get((int)_position).get("message").toString());
				}
			}
			else {
				
			}
			if (_data.get((int)_position).containsKey("date")) {
				cal.setTimeInMillis((long)(Double.parseDouble(_data.get((int)_position).get("date").toString())));
				now = Calendar.getInstance();
				if ((long)(now.getTimeInMillis() - cal.getTimeInMillis()) > (1000 * (3600 * 24))) {
					date.setText(new SimpleDateFormat("MMM dd").format(cal.getTime()));
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
					intent.setClass(getContext().getApplicationContext(), ChatActivity.class);
					intent.putExtra("firstuser", FirebaseAuth.getInstance().getCurrentUser().getUid());
					intent.putExtra("seconduser", _data.get((int)_position).get("uid").toString());
					intent.putExtra("getPost", _data.get((int)_position).get("getPost").toString());
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
}