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
import android.widget.ScrollView;
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

public class MyBookingActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String str1 = "";
	private String str2 = "";
	private String str3 = "";
	private String str4 = "";
	private String str5 = "";
	
	private ArrayList<HashMap<String, Object>> requesting_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> active_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> completed_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> canceled_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> rejected_listmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView back;
	private TextView textview1;
	private TabLayout tablayout1;
	private ScrollView vscroll1;
	private TextView textview2;
	private LinearLayout linear5;
	private RecyclerView recyclerview1;
	private RecyclerView recyclerview2;
	private RecyclerView recyclerview3;
	private RecyclerView recyclerview4;
	private RecyclerView recyclerview5;
	
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
	
	private DatabaseReference active = _firebase.getReference("booking");
	private ChildEventListener _active_child_listener;
	private DatabaseReference pending = _firebase.getReference("booking");
	private ChildEventListener _pending_child_listener;
	private DatabaseReference completed = _firebase.getReference("booking");
	private ChildEventListener _completed_child_listener;
	private Intent intent = new Intent();
	private DatabaseReference cancelled = _firebase.getReference("booking");
	private ChildEventListener _cancelled_child_listener;
	private DatabaseReference rejected = _firebase.getReference("booking");
	private ChildEventListener _rejected_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.my_booking);
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
		vscroll1 = findViewById(R.id.vscroll1);
		textview2 = findViewById(R.id.textview2);
		linear5 = findViewById(R.id.linear5);
		recyclerview1 = findViewById(R.id.recyclerview1);
		recyclerview2 = findViewById(R.id.recyclerview2);
		recyclerview3 = findViewById(R.id.recyclerview3);
		recyclerview4 = findViewById(R.id.recyclerview4);
		recyclerview5 = findViewById(R.id.recyclerview5);
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
					recyclerview4.setVisibility(View.GONE);
					recyclerview5.setVisibility(View.GONE);
				}
				if (_position == 1) {
					recyclerview1.setVisibility(View.GONE);
					recyclerview2.setVisibility(View.VISIBLE);
					recyclerview3.setVisibility(View.GONE);
					recyclerview4.setVisibility(View.GONE);
					recyclerview5.setVisibility(View.GONE);
				}
				if (_position == 2) {
					recyclerview1.setVisibility(View.GONE);
					recyclerview2.setVisibility(View.GONE);
					recyclerview3.setVisibility(View.VISIBLE);
					recyclerview4.setVisibility(View.GONE);
					recyclerview5.setVisibility(View.GONE);
				}
				if (_position == 3) {
					recyclerview1.setVisibility(View.GONE);
					recyclerview2.setVisibility(View.GONE);
					recyclerview3.setVisibility(View.GONE);
					recyclerview4.setVisibility(View.VISIBLE);
					recyclerview5.setVisibility(View.GONE);
				}
				if (_position == 4) {
					recyclerview1.setVisibility(View.GONE);
					recyclerview2.setVisibility(View.GONE);
					recyclerview3.setVisibility(View.GONE);
					recyclerview4.setVisibility(View.GONE);
					recyclerview5.setVisibility(View.VISIBLE);
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
		
		_active_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				active.addListenerForSingleValueEvent(new ValueEventListener() {
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
						recyclerview2.setAdapter(new Recyclerview2Adapter(active_listmap));
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
				active.addListenerForSingleValueEvent(new ValueEventListener() {
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
						recyclerview2.setAdapter(new Recyclerview2Adapter(active_listmap));
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
		active.addChildEventListener(_active_child_listener);
		
		_pending_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				pending.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						requesting_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								requesting_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (requesting_listmap.size() > 0) {
							recyclerview1.setAdapter(new Recyclerview1Adapter(requesting_listmap));
							recyclerview1.setVisibility(View.VISIBLE);
							textview2.setVisibility(View.GONE);
						}
						else {
							recyclerview1.setVisibility(View.GONE);
							textview2.setVisibility(View.VISIBLE);
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
				pending.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						requesting_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								requesting_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (requesting_listmap.size() > 0) {
							recyclerview1.setAdapter(new Recyclerview1Adapter(requesting_listmap));
							recyclerview1.setVisibility(View.VISIBLE);
							textview2.setVisibility(View.GONE);
						}
						else {
							recyclerview1.setVisibility(View.GONE);
							textview2.setVisibility(View.VISIBLE);
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
		pending.addChildEventListener(_pending_child_listener);
		
		_completed_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				completed.addListenerForSingleValueEvent(new ValueEventListener() {
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
						recyclerview3.setAdapter(new Recyclerview3Adapter(completed_listmap));
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
				completed.addListenerForSingleValueEvent(new ValueEventListener() {
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
						recyclerview3.setAdapter(new Recyclerview3Adapter(completed_listmap));
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
		completed.addChildEventListener(_completed_child_listener);
		
		_cancelled_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				cancelled.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						canceled_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								canceled_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						recyclerview4.setAdapter(new Recyclerview4Adapter(canceled_listmap));
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
				cancelled.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						canceled_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								canceled_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						recyclerview4.setAdapter(new Recyclerview4Adapter(canceled_listmap));
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
		cancelled.addChildEventListener(_cancelled_child_listener);
		
		_rejected_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				rejected.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						rejected_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								rejected_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						recyclerview5.setAdapter(new Recyclerview5Adapter(rejected_listmap));
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
				rejected.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						rejected_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								rejected_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						recyclerview5.setAdapter(new Recyclerview5Adapter(rejected_listmap));
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
		rejected.addChildEventListener(_rejected_child_listener);
		
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
		_simpleRiffle(back);
		_ImageColor(back, "#176b87");
		recyclerview1.setVisibility(View.GONE);
		recyclerview2.setVisibility(View.GONE);
		recyclerview3.setVisibility(View.GONE);
		recyclerview4.setVisibility(View.GONE);
		recyclerview5.setVisibility(View.GONE);
		_removeScollBar(vscroll1);
		textview2.setVisibility(View.GONE);
		tablayout1.setTabTextColors(0xFFE0E0E0, 0xFF186B87);
		tablayout1.setTabRippleColor(new android.content.res.ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}}, 
		
		new int[] {0xFFFFFFFF}));
		tablayout1.setSelectedTabIndicatorColor(0xFF176B87);
		tablayout1.setTabMode(com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE);
		tablayout1.addTab(tablayout1.newTab().setText("Pending"));
		tablayout1.addTab(tablayout1.newTab().setText("Active"));
		tablayout1.addTab(tablayout1.newTab().setText("Completed"));
		tablayout1.addTab(tablayout1.newTab().setText("Cancelled"));
		tablayout1.addTab(tablayout1.newTab().setText("Rejected"));
		recyclerview1.setLayoutManager(new LinearLayoutManager(this));
		recyclerview2.setLayoutManager(new LinearLayoutManager(this));
		recyclerview3.setLayoutManager(new LinearLayoutManager(this));
		recyclerview4.setLayoutManager(new LinearLayoutManager(this));
		recyclerview5.setLayoutManager(new LinearLayoutManager(this));
		str1 = "booking/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
		pending = _firebase.getReference(str1);
		pending.addChildEventListener(_pending_child_listener);
		str2 = "booking/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
		active = _firebase.getReference(str2);
		active.addChildEventListener(_active_child_listener);
		str3 = "booking/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
		completed = _firebase.getReference(str3);
		completed.addChildEventListener(_completed_child_listener);
		str4 = "booking/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
		cancelled = _firebase.getReference(str4);
		cancelled.addChildEventListener(_cancelled_child_listener);
		str5 = "booking/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
		rejected = _firebase.getReference(str5);
		rejected.addChildEventListener(_rejected_child_listener);
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
	
	
	public void _setRadiusCorner(final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
	}
	
	
	public void _simpleRiffle1(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#176b87")), null);
		
		_view.setBackground(GA8PO9);
	}
	
	
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
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
			payment_status.setVisibility(View.GONE);
			edit_details_layout.setVisibility(View.GONE);
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
							intent.setClass(getApplicationContext(), BookingActivity.class);
							intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
							intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
							intent.putExtra("book", "true");
							startActivity(intent);
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
			payment_status.setVisibility(View.GONE);
			edit_details_layout.setVisibility(View.GONE);
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
							intent.setClass(getApplicationContext(), BookingActivity.class);
							intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
							intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
							intent.putExtra("book", "true");
							startActivity(intent);
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
			textview7.setText("Rate");
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
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("payment status")) {
				payment_status.setText("Payment Status: ".concat(_data.get((int)(_data.size() - 1) - _position).get("payment status").toString()));
			}
			else {
				
			}
			view_details_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
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
							intent.setClass(getApplicationContext(), BookingActivity.class);
							intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
							intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
							intent.putExtra("book", "true");
							startActivity(intent);
						}
					}
				}
			});
			edit_details_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), ReteDormitoryActivity.class);
					intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("dorm post").toString());
					intent.putExtra("review", "");
					startActivity(intent);
					finish();
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
	
	public class Recyclerview4Adapter extends RecyclerView.Adapter<Recyclerview4Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview4Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
			payment_status.setVisibility(View.GONE);
			edit_details_layout.setVisibility(View.GONE);
			if (_data.get((int)(_data.size() - 1) - _position).get("status").toString().equals("canceled")) {
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
	
	public class Recyclerview5Adapter extends RecyclerView.Adapter<Recyclerview5Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview5Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
			payment_status.setVisibility(View.GONE);
			edit_details_layout.setVisibility(View.GONE);
			if (_data.get((int)(_data.size() - 1) - _position).get("status").toString().equals("rejected")) {
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