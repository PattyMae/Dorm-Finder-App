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
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;
import com.android.prime.arab.ware.everythingutils.*;
import com.bumptech.glide.Glide;
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
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import androidx.core.widget.NestedScrollView;
import androidx.cardview.widget.CardView;

public class HomeFragmentActivity extends Fragment {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private boolean isVisible = false;
	private String category = "";
	private String str = "";
	private double sound1 = 0;
	
	private ArrayList<HashMap<String, Object>> users_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> post_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> recommend_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> category_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> categories_list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private LinearLayout bg;
	private LinearLayout top;
	private SwipeRefreshLayout swiperefreshlayout1;
	private CardView profile_layout;
	private TextView username;
	private CardView notification_layout;
	private ImageView profile_icon;
	private LinearLayout linear13;
	private ImageView notification_icon;
	private CardView notify_dot;
	private LinearLayout linear14;
	private NestedScrollView vscroll1;
	private LinearLayout linear1;
	private CardView search_layout;
	private LinearLayout linear3;
	private RecyclerView recyclerview1;
	private LinearLayout linear4;
	private LinearLayout linear15;
	private RecyclerView recyclerview2;
	private RecyclerView recyclerview3;
	private LinearLayout search_layout2;
	private ImageView search_icon;
	private TextView textview1;
	private ImageView filter_icon;
	private TextView textview2;
	private TextView featured_see_all;
	private TextView textview3;
	private TextView recommend_see_all;
	private HorizontalScrollView hscroll1;
	private LinearLayout linear5;
	private CardView cardview1;
	private CardView cardview2;
	private CardView cardview3;
	private CardView cardview4;
	private CardView cardview5;
	private CardView cardview11;
	private LinearLayout linear8;
	private CardView cardview7;
	private TextView all_text;
	private LinearLayout linear9;
	private CardView cardview6;
	private TextView female_text;
	private LinearLayout linear10;
	private CardView cardview8;
	private TextView male_text;
	private LinearLayout linear11;
	private CardView cardview9;
	private TextView coed_text;
	private LinearLayout linear12;
	private CardView cardview10;
	private TextView gender_text;
	private LinearLayout linear16;
	private CardView cardview12;
	private TextView transcient_text;
	
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
	
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private DatabaseReference post = _firebase.getReference("post");
	private ChildEventListener _post_child_listener;
	private SharedPreferences data;
	private Intent intent = new Intent();
	private DatabaseReference post1 = _firebase.getReference("post");
	private ChildEventListener _post1_child_listener;
	private DatabaseReference post2 = _firebase.getReference("post");
	private ChildEventListener _post2_child_listener;
	private TimerTask timer;
	private DatabaseReference notification = _firebase.getReference("notification");
	private ChildEventListener _notification_child_listener;
	private SoundPool sp;
	private Vibrator vb;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.home_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		bg = _view.findViewById(R.id.bg);
		top = _view.findViewById(R.id.top);
		swiperefreshlayout1 = _view.findViewById(R.id.swiperefreshlayout1);
		profile_layout = _view.findViewById(R.id.profile_layout);
		username = _view.findViewById(R.id.username);
		notification_layout = _view.findViewById(R.id.notification_layout);
		profile_icon = _view.findViewById(R.id.profile_icon);
		linear13 = _view.findViewById(R.id.linear13);
		notification_icon = _view.findViewById(R.id.notification_icon);
		notify_dot = _view.findViewById(R.id.notify_dot);
		linear14 = _view.findViewById(R.id.linear14);
		vscroll1 = _view.findViewById(R.id.vscroll1);
		linear1 = _view.findViewById(R.id.linear1);
		search_layout = _view.findViewById(R.id.search_layout);
		linear3 = _view.findViewById(R.id.linear3);
		recyclerview1 = _view.findViewById(R.id.recyclerview1);
		linear4 = _view.findViewById(R.id.linear4);
		linear15 = _view.findViewById(R.id.linear15);
		recyclerview2 = _view.findViewById(R.id.recyclerview2);
		recyclerview3 = _view.findViewById(R.id.recyclerview3);
		search_layout2 = _view.findViewById(R.id.search_layout2);
		search_icon = _view.findViewById(R.id.search_icon);
		textview1 = _view.findViewById(R.id.textview1);
		filter_icon = _view.findViewById(R.id.filter_icon);
		textview2 = _view.findViewById(R.id.textview2);
		featured_see_all = _view.findViewById(R.id.featured_see_all);
		textview3 = _view.findViewById(R.id.textview3);
		recommend_see_all = _view.findViewById(R.id.recommend_see_all);
		hscroll1 = _view.findViewById(R.id.hscroll1);
		linear5 = _view.findViewById(R.id.linear5);
		cardview1 = _view.findViewById(R.id.cardview1);
		cardview2 = _view.findViewById(R.id.cardview2);
		cardview3 = _view.findViewById(R.id.cardview3);
		cardview4 = _view.findViewById(R.id.cardview4);
		cardview5 = _view.findViewById(R.id.cardview5);
		cardview11 = _view.findViewById(R.id.cardview11);
		linear8 = _view.findViewById(R.id.linear8);
		cardview7 = _view.findViewById(R.id.cardview7);
		all_text = _view.findViewById(R.id.all_text);
		linear9 = _view.findViewById(R.id.linear9);
		cardview6 = _view.findViewById(R.id.cardview6);
		female_text = _view.findViewById(R.id.female_text);
		linear10 = _view.findViewById(R.id.linear10);
		cardview8 = _view.findViewById(R.id.cardview8);
		male_text = _view.findViewById(R.id.male_text);
		linear11 = _view.findViewById(R.id.linear11);
		cardview9 = _view.findViewById(R.id.cardview9);
		coed_text = _view.findViewById(R.id.coed_text);
		linear12 = _view.findViewById(R.id.linear12);
		cardview10 = _view.findViewById(R.id.cardview10);
		gender_text = _view.findViewById(R.id.gender_text);
		linear16 = _view.findViewById(R.id.linear16);
		cardview12 = _view.findViewById(R.id.cardview12);
		transcient_text = _view.findViewById(R.id.transcient_text);
		fauth = FirebaseAuth.getInstance();
		data = getContext().getSharedPreferences("data", Activity.MODE_PRIVATE);
		vb = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
		
		notification_icon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getContext().getApplicationContext(), NotificationActivity.class);
				intent.putExtra("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				startActivity(intent);
			}
		});
		
		search_layout2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getContext().getApplicationContext(), SearchActivity.class);
				startActivity(intent);
			}
		});
		
		filter_icon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FilterBottomdialogFragmentDialogFragmentActivityN = new FilterBottomdialogFragmentDialogFragmentActivity();
				FilterBottomdialogFragmentDialogFragmentActivityN.show(getFragmentManager(),"1");
			}
		});
		
		featured_see_all.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		recommend_see_all.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getContext().getApplicationContext(), RecommendationsActivity.class);
				startActivity(intent);
			}
		});
		
		all_text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				all_text.setTextColor(0xFFFFFFFF);
				all_text.setBackgroundColor(0xFF176B87);
				female_text.setTextColor(0xFF176B87);
				female_text.setBackgroundColor(0xFFFFFFFF);
				male_text.setTextColor(0xFF176B87);
				male_text.setBackgroundColor(0xFFFFFFFF);
				coed_text.setTextColor(0xFF176B87);
				coed_text.setBackgroundColor(0xFFFFFFFF);
				gender_text.setTextColor(0xFF176B87);
				gender_text.setBackgroundColor(0xFFFFFFFF);
				transcient_text.setTextColor(0xFF176B87);
				transcient_text.setBackgroundColor(0xFFFFFFFF);
				recyclerview2.setVisibility(View.VISIBLE);
				recyclerview3.setVisibility(View.GONE);
				StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); recyclerview2.setLayoutManager(staggeredGridLayoutManager);
			}
		});
		
		female_text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				all_text.setTextColor(0xFF176B87);
				all_text.setBackgroundColor(0xFFFFFFFF);
				female_text.setTextColor(0xFFFFFFFF);
				female_text.setBackgroundColor(0xFF176B87);
				male_text.setTextColor(0xFF176B87);
				male_text.setBackgroundColor(0xFFFFFFFF);
				coed_text.setTextColor(0xFF176B87);
				coed_text.setBackgroundColor(0xFFFFFFFF);
				gender_text.setTextColor(0xFF176B87);
				gender_text.setBackgroundColor(0xFFFFFFFF);
				transcient_text.setTextColor(0xFF176B87);
				transcient_text.setBackgroundColor(0xFFFFFFFF);
				post2.removeEventListener(_post2_child_listener);
				recyclerview2.setVisibility(View.GONE);
				recyclerview3.setVisibility(View.VISIBLE);
				category = "Female Dormitory";
				StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); recyclerview3.setLayoutManager(staggeredGridLayoutManager);
				post2.addChildEventListener(_post2_child_listener);
			}
		});
		
		male_text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				all_text.setTextColor(0xFF176B87);
				all_text.setBackgroundColor(0xFFFFFFFF);
				female_text.setTextColor(0xFF176B87);
				female_text.setBackgroundColor(0xFFFFFFFF);
				male_text.setTextColor(0xFFFFFFFF);
				male_text.setBackgroundColor(0xFF176B87);
				coed_text.setTextColor(0xFF176B87);
				coed_text.setBackgroundColor(0xFFFFFFFF);
				gender_text.setTextColor(0xFF176B87);
				gender_text.setBackgroundColor(0xFFFFFFFF);
				transcient_text.setTextColor(0xFF176B87);
				transcient_text.setBackgroundColor(0xFFFFFFFF);
				post2.removeEventListener(_post2_child_listener);
				recyclerview2.setVisibility(View.GONE);
				recyclerview3.setVisibility(View.VISIBLE);
				category = "Male Dormitory";
				StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); recyclerview3.setLayoutManager(staggeredGridLayoutManager);
				post2.addChildEventListener(_post2_child_listener);
			}
		});
		
		coed_text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				all_text.setTextColor(0xFF176B87);
				all_text.setBackgroundColor(0xFFFFFFFF);
				female_text.setTextColor(0xFF176B87);
				female_text.setBackgroundColor(0xFFFFFFFF);
				male_text.setTextColor(0xFF176B87);
				male_text.setBackgroundColor(0xFFFFFFFF);
				coed_text.setTextColor(0xFFFFFFFF);
				coed_text.setBackgroundColor(0xFF176B87);
				gender_text.setTextColor(0xFF176B87);
				gender_text.setBackgroundColor(0xFFFFFFFF);
				transcient_text.setTextColor(0xFF176B87);
				transcient_text.setBackgroundColor(0xFFFFFFFF);
				post2.removeEventListener(_post2_child_listener);
				recyclerview2.setVisibility(View.GONE);
				recyclerview3.setVisibility(View.VISIBLE);
				category = "Co-ed Dormitory";
				StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); recyclerview3.setLayoutManager(staggeredGridLayoutManager);
				post2.addChildEventListener(_post2_child_listener);
			}
		});
		
		gender_text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				all_text.setTextColor(0xFF176B87);
				all_text.setBackgroundColor(0xFFFFFFFF);
				female_text.setTextColor(0xFF176B87);
				female_text.setBackgroundColor(0xFFFFFFFF);
				male_text.setTextColor(0xFF176B87);
				male_text.setBackgroundColor(0xFFFFFFFF);
				coed_text.setTextColor(0xFF176B87);
				coed_text.setBackgroundColor(0xFFFFFFFF);
				gender_text.setTextColor(0xFFFFFFFF);
				gender_text.setBackgroundColor(0xFF176B87);
				transcient_text.setTextColor(0xFF176B87);
				transcient_text.setBackgroundColor(0xFFFFFFFF);
				post2.removeEventListener(_post2_child_listener);
				recyclerview2.setVisibility(View.GONE);
				recyclerview3.setVisibility(View.VISIBLE);
				category = "Gender-neutral Dormitory";
				StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); recyclerview3.setLayoutManager(staggeredGridLayoutManager);
				post2.addChildEventListener(_post2_child_listener);
			}
		});
		
		transcient_text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				all_text.setTextColor(0xFF176B87);
				all_text.setBackgroundColor(0xFFFFFFFF);
				female_text.setTextColor(0xFF176B87);
				female_text.setBackgroundColor(0xFFFFFFFF);
				male_text.setTextColor(0xFF176B87);
				male_text.setBackgroundColor(0xFFFFFFFF);
				coed_text.setTextColor(0xFF176B87);
				coed_text.setBackgroundColor(0xFFFFFFFF);
				gender_text.setTextColor(0xFF176B87);
				gender_text.setBackgroundColor(0xFFFFFFFF);
				transcient_text.setTextColor(0xFFFFFFFF);
				transcient_text.setBackgroundColor(0xFF176B87);
				post2.removeEventListener(_post2_child_listener);
				recyclerview2.setVisibility(View.GONE);
				recyclerview3.setVisibility(View.VISIBLE);
				category = "Transcient";
				StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); recyclerview3.setLayoutManager(staggeredGridLayoutManager);
				post2.addChildEventListener(_post2_child_listener);
			}
		});
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					Glide.with(getContext().getApplicationContext()).load(Uri.parse(_childValue.get("profile").toString())).into(profile_icon);
					if (_childValue.get("firstname").toString().equals("")) {
						username.setText(_childValue.get("fullname").toString());
					}
					else {
						username.setText(_childValue.get("firstname").toString());
					}
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
		
		_post_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				post.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						post_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								post_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						recyclerview1.setAdapter(new Recyclerview1Adapter(post_listmap));
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
				post.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						post_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								post_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						recyclerview1.setAdapter(new Recyclerview1Adapter(post_listmap));
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
		post.addChildEventListener(_post_child_listener);
		
		_post1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				post1.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						recommend_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								recommend_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						recyclerview2.setAdapter(new Recyclerview2Adapter(recommend_listmap));
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
				post1.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						recommend_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								recommend_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						recyclerview2.setAdapter(new Recyclerview2Adapter(recommend_listmap));
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
		post1.addChildEventListener(_post1_child_listener);
		
		_post2_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				post2.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						category_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								category_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						recyclerview3.setAdapter(new Recyclerview3Adapter(category_listmap));
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
				post2.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						category_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								category_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						recyclerview3.setAdapter(new Recyclerview3Adapter(category_listmap));
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
		post2.addChildEventListener(_post2_child_listener);
		
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
						if (_childValue.containsKey("seen")) {
							if (_childValue.get("seen").toString().equals("true")) {
								notify_dot.setVisibility(View.GONE);
							}
							else {
								if (_childValue.get("seen").toString().equals("false")) {
									notify_dot.setVisibility(View.VISIBLE);
									if (data.getString(_childValue.get("getPost").toString(), "").equals("true")) {
										
									}
									else {
										data.edit().putString(_childValue.get("getPost").toString(), "true").commit();
										_notify();
									}
								}
							}
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
						if (_childValue.containsKey("seen")) {
							if (_childValue.get("seen").toString().equals("true")) {
								notify_dot.setVisibility(View.GONE);
							}
							else {
								if (_childValue.get("seen").toString().equals("false")) {
									notify_dot.setVisibility(View.VISIBLE);
									_notify();
								}
							}
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
		_setRadiusCorner(top, 0, 5, "#ffffff");
		_ImageColor(notification_icon, "#176b87");
		_ImageColor(search_icon, "#bdbdbd");
		_ImageColor(filter_icon, "#2196f3");
		_simpleRiffle(notification_icon);
		_simpleRiffle(featured_see_all);
		_simpleRiffle(recommend_see_all);
		_simpleriffle1(search_layout2);
		_riffleEffect("#f5f5f5", filter_icon);
		_removeScollBar(vscroll1);
		_removeScollBar(hscroll1);
		recyclerview3.setVisibility(View.GONE);
		sp = new SoundPool((int)(1), AudioManager.STREAM_MUSIC, 0);
		sound1 = sp.load(getContext().getApplicationContext(), R.raw.notification, 1);
		users.addChildEventListener(_users_child_listener);
		recyclerview1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
		post.addChildEventListener(_post_child_listener);
		StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); recyclerview2.setLayoutManager(staggeredGridLayoutManager);
		recyclerview3.setLayoutManager(new LinearLayoutManager(getContext()));
		androidx.core.view.ViewCompat.setNestedScrollingEnabled(recyclerview1, true);
		
		androidx.core.view.ViewCompat.setNestedScrollingEnabled(recyclerview2, true);
		
		androidx.core.view.ViewCompat.setNestedScrollingEnabled(recyclerview3, true);
		swiperefreshlayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				timer = new TimerTask() {
					@Override
					public void run() {
						getActivity().runOnUiThread(new Runnable() {
							@Override
							public void run() {
								swiperefreshlayout1.setRefreshing(false);
								recyclerview1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
								post.addChildEventListener(_post_child_listener);
								StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); recyclerview2.setLayoutManager(staggeredGridLayoutManager);
							}
						});
					}
				};
				_timer.schedule(timer, (int)(3000));
			}
		});
		str = "notification/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
		notification = _firebase.getReference(str);
		notification.addChildEventListener(_notification_child_listener);
	}
	
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	
	public void _simpleRiffle(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
		_view.setBackground(GA8PO9);
	}
	
	
	public void _simpleriffle1(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#eeeeee")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#f5f5f5")), null);
		
		_view.setBackground(GA8PO9);
	}
	
	
	public void _setRadiusCorner(final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
	}
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _setSingleLine(final TextView _view, final boolean _bool) {
		_view.setSingleLine(_bool);
	}
	
	
	public void _riffleEffect(final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)}); android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null); _view.setBackground(ripdr);
	}
	
	
	public void _lib() {
	}
	private FilterBottomdialogFragmentDialogFragmentActivity FilterBottomdialogFragmentDialogFragmentActivityN;
	private FragmentManager FilterBottomdialogFragmentDialogFragmentActivityFM;
	public void test_FilterBottomdialogFragmentDialogFragmentActivity () {
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
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.homepage_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout bg = _view.findViewById(R.id.bg);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final ImageView photo = _view.findViewById(R.id.photo);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final TextView rating = _view.findViewById(R.id.rating);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final TextView dormitory_name = _view.findViewById(R.id.dormitory_name);
			final TextView location = _view.findViewById(R.id.location);
			final LinearLayout linear9 = _view.findViewById(R.id.linear9);
			final TextView monthly_rent = _view.findViewById(R.id.monthly_rent);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_view.setLayoutParams(_lp);
			dormitory_name.setShadowLayer(1,1,1, Color.parseColor("#000000"));
			
			location.setShadowLayer(1,1,1, Color.parseColor("#000000"));
			
			monthly_rent.setShadowLayer(1,1,1, Color.parseColor("#000000"));
			
			textview5.setShadowLayer(1,1,1, Color.parseColor("#000000"));
			_simpleRiffle(linear1);
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("photo1")) {
				Glide.with(getContext().getApplicationContext()).load(Uri.parse(_data.get((int)(_data.size() - 1) - _position).get("photo1").toString())).into(photo);
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("dormitory name")) {
				dormitory_name.setText(_data.get((int)(_data.size() - 1) - _position).get("dormitory name").toString());
				_setSingleLine(dormitory_name, true);
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("street")) {
				location.setText(_data.get((int)(_data.size() - 1) - _position).get("street").toString().concat(" ".concat(_data.get((int)(_data.size() - 1) - _position).get("barangay").toString())));
				_setSingleLine(location, true);
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("rates monthly price")) {
				monthly_rent.setText("₱".concat(_data.get((int)(_data.size() - 1) - _position).get("rates monthly price").toString()));
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("rating")) {
				rating.setText("⭐ ".concat(_data.get((int)(_data.size() - 1) - _position).get("rating").toString()));
			}
			else {
				
			}
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getContext().getApplicationContext(), DormitoryDetailsActivity.class);
					intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
					intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("dormitory uid").toString());
					intent.putExtra("photo1", _data.get((int)(_data.size() - 1) - _position).get("photo1").toString());
					intent.putExtra("photo5", _data.get((int)(_data.size() - 1) - _position).get("photo5").toString());
					intent.putExtra("photo9", _data.get((int)(_data.size() - 1) - _position).get("photo9").toString());
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
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.homepage_post_gridview, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout background = _view.findViewById(R.id.background);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final androidx.cardview.widget.CardView cardview3 = _view.findViewById(R.id.cardview3);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final ImageView photo = _view.findViewById(R.id.photo);
			final TextView dormitory_name = _view.findViewById(R.id.dormitory_name);
			final TextView location = _view.findViewById(R.id.location);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final TextView monthly_rent = _view.findViewById(R.id.monthly_rent);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView rating = _view.findViewById(R.id.rating);
			
			_simpleRiffle(linear1);
			if (_data.get((int)_position).containsKey("photo1")) {
				Glide.with(getContext().getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("photo1").toString())).into(photo);
			}
			else {
				
			}
			if (_data.get((int)_position).containsKey("dormitory name")) {
				dormitory_name.setText(_data.get((int)_position).get("dormitory name").toString());
				_setSingleLine(dormitory_name, true);
			}
			else {
				
			}
			if (_data.get((int)_position).containsKey("street")) {
				location.setText(_data.get((int)_position).get("street").toString().concat(" ".concat(_data.get((int)(_data.size() - 1) - _position).get("barangay").toString())));
				_setSingleLine(location, true);
			}
			else {
				
			}
			if (_data.get((int)_position).containsKey("rates monthly price")) {
				monthly_rent.setText("₱".concat(_data.get((int)_position).get("rates monthly price").toString()));
			}
			else {
				
			}
			if (_data.get((int)_position).containsKey("rating")) {
				rating.setText("⭐ ".concat(_data.get((int)_position).get("rating").toString()));
			}
			else {
				
			}
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getContext().getApplicationContext(), DormitoryDetailsActivity.class);
					intent.putExtra("getPost", _data.get((int)_position).get("getPost").toString());
					intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("dormitory uid").toString());
					intent.putExtra("photo1", _data.get((int)_position).get("photo1").toString());
					intent.putExtra("photo5", _data.get((int)_position).get("photo5").toString());
					intent.putExtra("photo9", _data.get((int)_position).get("photo9").toString());
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
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.homepage_post_gridview, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout background = _view.findViewById(R.id.background);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final androidx.cardview.widget.CardView cardview3 = _view.findViewById(R.id.cardview3);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final ImageView photo = _view.findViewById(R.id.photo);
			final TextView dormitory_name = _view.findViewById(R.id.dormitory_name);
			final TextView location = _view.findViewById(R.id.location);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final TextView monthly_rent = _view.findViewById(R.id.monthly_rent);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView rating = _view.findViewById(R.id.rating);
			
			_simpleRiffle(linear1);
			if (_data.get((int)_position).get("type of dormitory").toString().contains(category)) {
				if (_data.get((int)_position).containsKey("photo1")) {
					Glide.with(getContext().getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("photo1").toString())).into(photo);
				}
				else {
					
				}
				if (_data.get((int)_position).containsKey("dormitory name")) {
					dormitory_name.setText(_data.get((int)_position).get("dormitory name").toString());
					_setSingleLine(dormitory_name, true);
				}
				else {
					
				}
				if (_data.get((int)_position).containsKey("street")) {
					location.setText(_data.get((int)_position).get("street").toString().concat(" ".concat(_data.get((int)(_data.size() - 1) - _position).get("barangay").toString())));
					_setSingleLine(location, true);
				}
				else {
					
				}
				if (_data.get((int)_position).containsKey("rates monthly price")) {
					monthly_rent.setText("₱".concat(_data.get((int)_position).get("rates monthly price").toString()));
				}
				else {
					
				}
				if (_data.get((int)_position).containsKey("rating")) {
					rating.setText("⭐ ".concat(_data.get((int)_position).get("rating").toString()));
				}
				else {
					
				}
				background.setVisibility(View.VISIBLE);
			}
			else {
				background.setVisibility(View.GONE);
			}
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getContext().getApplicationContext(), DormitoryDetailsActivity.class);
					intent.putExtra("getPost", _data.get((int)_position).get("getPost").toString());
					intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("dormitory uid").toString());
					intent.putExtra("photo1", _data.get((int)_position).get("photo1").toString());
					intent.putExtra("photo5", _data.get((int)_position).get("photo5").toString());
					intent.putExtra("photo9", _data.get((int)_position).get("photo9").toString());
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