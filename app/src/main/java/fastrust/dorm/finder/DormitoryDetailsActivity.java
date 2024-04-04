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
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.android.prime.arab.ware.everythingutils.*;
import com.bumptech.glide.Glide;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class DormitoryDetailsActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double position = 0;
	private HashMap<String, Object> map = new HashMap<>();
	private double num = 0;
	private String dormitory_name = "";
	private String dormitory_location = "";
	private String dormitory_photo = "";
	private String dormitory_price = "";
	private String dormitory_getPost = "";
	private String owner_uid = "";
	private double review = 0;
	private String rate_beds = "";
	private String rate_status = "";
	private String rates_monthly_rent = "";
	private String amount_advance = "";
	private String amount_deposit = "";
	private String payment_method = "";
	private String p1 = "";
	private String p2 = "";
	private String p3 = "";
	private String p4 = "";
	private String p5 = "";
	private String p6 = "";
	private String p7 = "";
	private String p8 = "";
	private String p9 = "";
	private String p10 = "";
	private String p11 = "";
	private String p12 = "";
	private String rates_per_night = "";
	private double reviewCount = 0;
	private double rev = 0;
	private String getPost = "";
	private boolean isVisible = false;
	private String str = "";
	private HashMap<String, Object> UserProfile = new HashMap<>();
	private HashMap<String, Object> UserName = new HashMap<>();
	ImageView user_profile;
	TextView user_fullname;
	private String ratingCount = "";
	private double limit = 0;
	private String key = "";
	private String type_of_dormitory = "";
	private String review_paste = "";
	private String CharQue = "";
	private String minimum_stay = "";
	private String textfiltered = "";
	private String ownerPhoto = "";
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> review_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> reviewsCount_listmap = new ArrayList<>();
	
	private LinearLayout bg;
	private ScrollView vscroll1;
	private LinearLayout bottom;
	private LinearLayout body;
	private LinearLayout linear4;
	private LinearLayout linear6;
	private ViewPager viewpager1;
	private LinearLayout linear21;
	private RecyclerView recyclerview1;
	private TextView dorm_name;
	private LinearLayout linear7;
	private LinearLayout linear10;
	private LinearLayout line1;
	private LinearLayout linear8;
	private TextView textview9;
	private TextView discription;
	private TextView textview6;
	private TextView amenities;
	private TextView textview4;
	private TextView inclusion;
	private LinearLayout linear11;
	private LinearLayout linear14;
	private TextView textview17;
	private LinearLayout linear13;
	private CardView cardview3;
	private LinearLayout reviews_layout;
	private LinearLayout room_information;
	private CardView cardview1;
	private TextView owner_review;
	private TextView textview1;
	private ImageView available_icon;
	private TextView available;
	private CardView cardview2;
	private LinearLayout linear9;
	private ImageView message_icon;
	private ImageView owner_photo;
	private TextView owner_name;
	private TextView textview11;
	private TextView textview15;
	private TextView see_all;
	private CardView cardview4;
	private CardView cardview5;
	private CardView cardview6;
	private ImageView photo1;
	private ImageView photo2;
	private ImageView photo3;
	private ImageView location_icon;
	private TextView location;
	private MapView mapview1;
	private GoogleMapController _mapview1_controller;
	private LinearLayout linear17;
	private RecyclerView recyclerview2;
	private TextView owner_review1;
	private TextView comment_see_all;
	private TextView textview23;
	private CardView cardview8;
	private LinearLayout coed_layout2;
	private LinearLayout transcient_layout2;
	private LinearLayout linear23;
	private CardView cardview10;
	private LinearLayout linear24;
	private LinearLayout linear27;
	private LinearLayout linear28;
	private LinearLayout transcient_layout1;
	private LinearLayout linear39;
	private LinearLayout coed_layout1;
	private TextView textview26;
	private TextView info_type_of_dormitory;
	private TextView textview28;
	private TextView info_total_number_of_bedrooms;
	private TextView textview30;
	private TextView info_bedroom1;
	private TextView textview31;
	private TextView info_bedtype;
	private TextView textview32;
	private TextView info_floor;
	private TextView textview36;
	private TextView info_room_available;
	private TextView textview38;
	private TextView info_room_occupied;
	private LinearLayout linear32;
	private TextView textview41;
	private LinearLayout linear33;
	private TextView textview42;
	private LinearLayout linear38;
	private TextView textview43;
	private TextView boys_room_available;
	private TextView textview45;
	private TextView girls_room_available;
	private TextView textview46;
	private TextView girls_bedroom;
	private TextView textview48;
	private TextView girls_bed;
	private TextView textview50;
	private TextView girls_bedtype;
	private TextView textview52;
	private TextView girls_floor;
	private TextView textview53;
	private TextView boys_bedroom;
	private TextView textview55;
	private TextView boys_bed;
	private TextView textview57;
	private TextView boys_bedtype;
	private TextView textview59;
	private TextView boys_floor;
	private TextView textview24;
	private CardView cardview9;
	private LinearLayout linear25;
	private CardView cardview11;
	private LinearLayout linear26;
	private LinearLayout linear45;
	private TextView textview66;
	private TextView textview68;
	private LinearLayout linear47;
	private LinearLayout linear46;
	private TextView textview67;
	private LinearLayout linear48;
	private LinearLayout linear49;
	private LinearLayout linear50;
	private TextView textview69;
	private TextView rates_room_available_boys;
	private TextView textview71;
	private TextView rates_room_available_girls;
	private TextView textview74;
	private TextView rates_girls_bedroom;
	private TextView textview76;
	private TextView rates_girls_beds;
	private TextView textview78;
	private TextView rates_girls_status;
	private TextView textview79;
	private TextView rates_girls_floor;
	private TextView textview81;
	private TextView rates_girls_monthly_price;
	private TextView textview82;
	private TextView rates_boys_bedroom;
	private TextView textview84;
	private TextView rates_boys_beds;
	private TextView textview86;
	private TextView rates_boys_status;
	private TextView textview88;
	private TextView rates_boys_floor;
	private TextView textview90;
	private TextView rates_boys_monthly_price;
	private LinearLayout linear51;
	private LinearLayout linear52;
	private TextView textview72;
	private CardView cardview14;
	private LinearLayout linear53;
	private TextView rates_advance;
	private TextView textview92;
	private TextView textview73;
	private CardView cardview15;
	private LinearLayout linear54;
	private TextView rates_deposit;
	private TextView textview94;
	private TextView textview60;
	private LinearLayout linear40;
	private LinearLayout linear41;
	private LinearLayout linear42;
	private TextView textview61;
	private CardView cardview12;
	private LinearLayout linear43;
	private EditText rates_per_night2;
	private TextView textview63;
	private TextView textview62;
	private CardView cardview13;
	private LinearLayout linear44;
	private EditText rates_minimum_stay;
	private TextView textview65;
	private LinearLayout linear19;
	private LinearLayout linear15;
	private CardView cardview7;
	private TextView textview19;
	private LinearLayout linear16;
	private TextView monthly_rent;
	private TextView textview22;
	private TextView book_now;
	
	private DatabaseReference post = _firebase.getReference("post");
	private ChildEventListener _post_child_listener;
	private TimerTask timer;
	private Intent intent = new Intent();
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
	
	private SharedPreferences data;
	private DatabaseReference reviews = _firebase.getReference("reviews");
	private ChildEventListener _reviews_child_listener;
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private Calendar cal = Calendar.getInstance();
	private Calendar now = Calendar.getInstance();
	private DatabaseReference reviewsCount = _firebase.getReference("reviews");
	private ChildEventListener _reviewsCount_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.dormitory_details);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		bg = findViewById(R.id.bg);
		vscroll1 = findViewById(R.id.vscroll1);
		bottom = findViewById(R.id.bottom);
		body = findViewById(R.id.body);
		linear4 = findViewById(R.id.linear4);
		linear6 = findViewById(R.id.linear6);
		viewpager1 = findViewById(R.id.viewpager1);
		linear21 = findViewById(R.id.linear21);
		recyclerview1 = findViewById(R.id.recyclerview1);
		dorm_name = findViewById(R.id.dorm_name);
		linear7 = findViewById(R.id.linear7);
		linear10 = findViewById(R.id.linear10);
		line1 = findViewById(R.id.line1);
		linear8 = findViewById(R.id.linear8);
		textview9 = findViewById(R.id.textview9);
		discription = findViewById(R.id.discription);
		textview6 = findViewById(R.id.textview6);
		amenities = findViewById(R.id.amenities);
		textview4 = findViewById(R.id.textview4);
		inclusion = findViewById(R.id.inclusion);
		linear11 = findViewById(R.id.linear11);
		linear14 = findViewById(R.id.linear14);
		textview17 = findViewById(R.id.textview17);
		linear13 = findViewById(R.id.linear13);
		cardview3 = findViewById(R.id.cardview3);
		reviews_layout = findViewById(R.id.reviews_layout);
		room_information = findViewById(R.id.room_information);
		cardview1 = findViewById(R.id.cardview1);
		owner_review = findViewById(R.id.owner_review);
		textview1 = findViewById(R.id.textview1);
		available_icon = findViewById(R.id.available_icon);
		available = findViewById(R.id.available);
		cardview2 = findViewById(R.id.cardview2);
		linear9 = findViewById(R.id.linear9);
		message_icon = findViewById(R.id.message_icon);
		owner_photo = findViewById(R.id.owner_photo);
		owner_name = findViewById(R.id.owner_name);
		textview11 = findViewById(R.id.textview11);
		textview15 = findViewById(R.id.textview15);
		see_all = findViewById(R.id.see_all);
		cardview4 = findViewById(R.id.cardview4);
		cardview5 = findViewById(R.id.cardview5);
		cardview6 = findViewById(R.id.cardview6);
		photo1 = findViewById(R.id.photo1);
		photo2 = findViewById(R.id.photo2);
		photo3 = findViewById(R.id.photo3);
		location_icon = findViewById(R.id.location_icon);
		location = findViewById(R.id.location);
		mapview1 = findViewById(R.id.mapview1);
		mapview1.onCreate(_savedInstanceState);
		
		linear17 = findViewById(R.id.linear17);
		recyclerview2 = findViewById(R.id.recyclerview2);
		owner_review1 = findViewById(R.id.owner_review1);
		comment_see_all = findViewById(R.id.comment_see_all);
		textview23 = findViewById(R.id.textview23);
		cardview8 = findViewById(R.id.cardview8);
		coed_layout2 = findViewById(R.id.coed_layout2);
		transcient_layout2 = findViewById(R.id.transcient_layout2);
		linear23 = findViewById(R.id.linear23);
		cardview10 = findViewById(R.id.cardview10);
		linear24 = findViewById(R.id.linear24);
		linear27 = findViewById(R.id.linear27);
		linear28 = findViewById(R.id.linear28);
		transcient_layout1 = findViewById(R.id.transcient_layout1);
		linear39 = findViewById(R.id.linear39);
		coed_layout1 = findViewById(R.id.coed_layout1);
		textview26 = findViewById(R.id.textview26);
		info_type_of_dormitory = findViewById(R.id.info_type_of_dormitory);
		textview28 = findViewById(R.id.textview28);
		info_total_number_of_bedrooms = findViewById(R.id.info_total_number_of_bedrooms);
		textview30 = findViewById(R.id.textview30);
		info_bedroom1 = findViewById(R.id.info_bedroom1);
		textview31 = findViewById(R.id.textview31);
		info_bedtype = findViewById(R.id.info_bedtype);
		textview32 = findViewById(R.id.textview32);
		info_floor = findViewById(R.id.info_floor);
		textview36 = findViewById(R.id.textview36);
		info_room_available = findViewById(R.id.info_room_available);
		textview38 = findViewById(R.id.textview38);
		info_room_occupied = findViewById(R.id.info_room_occupied);
		linear32 = findViewById(R.id.linear32);
		textview41 = findViewById(R.id.textview41);
		linear33 = findViewById(R.id.linear33);
		textview42 = findViewById(R.id.textview42);
		linear38 = findViewById(R.id.linear38);
		textview43 = findViewById(R.id.textview43);
		boys_room_available = findViewById(R.id.boys_room_available);
		textview45 = findViewById(R.id.textview45);
		girls_room_available = findViewById(R.id.girls_room_available);
		textview46 = findViewById(R.id.textview46);
		girls_bedroom = findViewById(R.id.girls_bedroom);
		textview48 = findViewById(R.id.textview48);
		girls_bed = findViewById(R.id.girls_bed);
		textview50 = findViewById(R.id.textview50);
		girls_bedtype = findViewById(R.id.girls_bedtype);
		textview52 = findViewById(R.id.textview52);
		girls_floor = findViewById(R.id.girls_floor);
		textview53 = findViewById(R.id.textview53);
		boys_bedroom = findViewById(R.id.boys_bedroom);
		textview55 = findViewById(R.id.textview55);
		boys_bed = findViewById(R.id.boys_bed);
		textview57 = findViewById(R.id.textview57);
		boys_bedtype = findViewById(R.id.boys_bedtype);
		textview59 = findViewById(R.id.textview59);
		boys_floor = findViewById(R.id.boys_floor);
		textview24 = findViewById(R.id.textview24);
		cardview9 = findViewById(R.id.cardview9);
		linear25 = findViewById(R.id.linear25);
		cardview11 = findViewById(R.id.cardview11);
		linear26 = findViewById(R.id.linear26);
		linear45 = findViewById(R.id.linear45);
		textview66 = findViewById(R.id.textview66);
		textview68 = findViewById(R.id.textview68);
		linear47 = findViewById(R.id.linear47);
		linear46 = findViewById(R.id.linear46);
		textview67 = findViewById(R.id.textview67);
		linear48 = findViewById(R.id.linear48);
		linear49 = findViewById(R.id.linear49);
		linear50 = findViewById(R.id.linear50);
		textview69 = findViewById(R.id.textview69);
		rates_room_available_boys = findViewById(R.id.rates_room_available_boys);
		textview71 = findViewById(R.id.textview71);
		rates_room_available_girls = findViewById(R.id.rates_room_available_girls);
		textview74 = findViewById(R.id.textview74);
		rates_girls_bedroom = findViewById(R.id.rates_girls_bedroom);
		textview76 = findViewById(R.id.textview76);
		rates_girls_beds = findViewById(R.id.rates_girls_beds);
		textview78 = findViewById(R.id.textview78);
		rates_girls_status = findViewById(R.id.rates_girls_status);
		textview79 = findViewById(R.id.textview79);
		rates_girls_floor = findViewById(R.id.rates_girls_floor);
		textview81 = findViewById(R.id.textview81);
		rates_girls_monthly_price = findViewById(R.id.rates_girls_monthly_price);
		textview82 = findViewById(R.id.textview82);
		rates_boys_bedroom = findViewById(R.id.rates_boys_bedroom);
		textview84 = findViewById(R.id.textview84);
		rates_boys_beds = findViewById(R.id.rates_boys_beds);
		textview86 = findViewById(R.id.textview86);
		rates_boys_status = findViewById(R.id.rates_boys_status);
		textview88 = findViewById(R.id.textview88);
		rates_boys_floor = findViewById(R.id.rates_boys_floor);
		textview90 = findViewById(R.id.textview90);
		rates_boys_monthly_price = findViewById(R.id.rates_boys_monthly_price);
		linear51 = findViewById(R.id.linear51);
		linear52 = findViewById(R.id.linear52);
		textview72 = findViewById(R.id.textview72);
		cardview14 = findViewById(R.id.cardview14);
		linear53 = findViewById(R.id.linear53);
		rates_advance = findViewById(R.id.rates_advance);
		textview92 = findViewById(R.id.textview92);
		textview73 = findViewById(R.id.textview73);
		cardview15 = findViewById(R.id.cardview15);
		linear54 = findViewById(R.id.linear54);
		rates_deposit = findViewById(R.id.rates_deposit);
		textview94 = findViewById(R.id.textview94);
		textview60 = findViewById(R.id.textview60);
		linear40 = findViewById(R.id.linear40);
		linear41 = findViewById(R.id.linear41);
		linear42 = findViewById(R.id.linear42);
		textview61 = findViewById(R.id.textview61);
		cardview12 = findViewById(R.id.cardview12);
		linear43 = findViewById(R.id.linear43);
		rates_per_night2 = findViewById(R.id.rates_per_night2);
		textview63 = findViewById(R.id.textview63);
		textview62 = findViewById(R.id.textview62);
		cardview13 = findViewById(R.id.cardview13);
		linear44 = findViewById(R.id.linear44);
		rates_minimum_stay = findViewById(R.id.rates_minimum_stay);
		textview65 = findViewById(R.id.textview65);
		linear19 = findViewById(R.id.linear19);
		linear15 = findViewById(R.id.linear15);
		cardview7 = findViewById(R.id.cardview7);
		textview19 = findViewById(R.id.textview19);
		linear16 = findViewById(R.id.linear16);
		monthly_rent = findViewById(R.id.monthly_rent);
		textview22 = findViewById(R.id.textview22);
		book_now = findViewById(R.id.book_now);
		fauth = FirebaseAuth.getInstance();
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		net = new RequestNetwork(this);
		
		viewpager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int _position, float _positionOffset, int _positionOffsetPixels) {
				
			}
			
			@Override
			public void onPageSelected(int _position) {
				recyclerview1.setAdapter(new Recyclerview1Adapter(listmap));
				recyclerview1.smoothScrollToPosition((int)_position);
				position = _position;
				num = _position;
			}
			
			@Override
			public void onPageScrollStateChanged(int _scrollState) {
				
			}
		});
		
		message_icon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ChatActivity.class);
				intent.putExtra("seconduser", owner_uid);
				intent.putExtra("firstuser", FirebaseAuth.getInstance().getCurrentUser().getUid());
				intent.putExtra("getPost", getIntent().getStringExtra("getPost"));
				startActivity(intent);
			}
		});
		
		see_all.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), GalleryActivity.class);
				intent.putExtra("photo1", p1);
				intent.putExtra("photo2", p2);
				intent.putExtra("photo3", p3);
				intent.putExtra("photo4", p4);
				intent.putExtra("photo5", p5);
				intent.putExtra("photo6", p6);
				intent.putExtra("photo7", p7);
				intent.putExtra("photo8", p8);
				intent.putExtra("photo9", p9);
				intent.putExtra("photo10", p10);
				intent.putExtra("photo11", p11);
				intent.putExtra("photo12", p12);
				startActivity(intent);
			}
		});
		
		photo1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ViewPhotoActivity.class);
				intent.putExtra("link", getIntent().getStringExtra("photo1"));
				startActivity(intent);
			}
		});
		
		photo2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ViewPhotoActivity.class);
				intent.putExtra("link", getIntent().getStringExtra("photo5"));
				startActivity(intent);
			}
		});
		
		photo3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ViewPhotoActivity.class);
				intent.putExtra("link", getIntent().getStringExtra("photo9"));
				startActivity(intent);
			}
		});
		
		_mapview1_controller = new GoogleMapController(mapview1, new OnMapReadyCallback() {
			@Override
			public void onMapReady(GoogleMap _googleMap) {
				_mapview1_controller.setGoogleMap(_googleMap);
				
			}
		});
		
		comment_see_all.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), AllReviewsActivity.class);
				intent.putExtra("getPost", getIntent().getStringExtra("getPost"));
				intent.putExtra("review", owner_review.getText().toString());
				startActivity(intent);
			}
		});
		
		rates_minimum_stay.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (0 < rates_minimum_stay.getText().toString().length()) {
					if (_charSeq.length() > 0) {
						rates_per_night2.setText(String.valueOf((long)(Double.parseDouble(rates_minimum_stay.getText().toString()) * Double.parseDouble(rates_per_night))));
					}
				}
				else {
					rates_per_night2.setHint(rates_per_night);
					rates_minimum_stay.setHint(minimum_stay);
					_Hide_Keyboard(rates_minimum_stay);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		book_now.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (data.getString("login", "").equals("true")) {
					data.edit().putString("rates per night", rates_per_night2.getText().toString()).commit();
					data.edit().putString("minimum stay", rates_minimum_stay.getText().toString()).commit();
					intent.setClass(getApplicationContext(), BookingActivity.class);
					intent.putExtra("getPost", dormitory_getPost);
					intent.putExtra("book", "");
					startActivity(intent);
				}
				else {
					intent.setAction(Intent.ACTION_VIEW);
					intent.setClass(getApplicationContext(), SigninDialogActivity.class);
					startActivity(intent);
				}
			}
		});
		
		_post_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				post.addListenerForSingleValueEvent(new ValueEventListener() {
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
						if (_childValue.get("getPost").toString().equals(getIntent().getStringExtra("getPost"))) {
							if (_childValue.get("rates status").toString().equals("Available")) {
								book_now.setText("Book Now");
								book_now.setEnabled(true);
							}
							else {
								if (_childValue.get("rates status").toString().equals("Occupied")) {
									book_now.setText("Occupied");
									book_now.setEnabled(false);
								}
							}
							ratingCount = _childValue.get("rating").toString();
							owner_name.setText(_childValue.get("dormitory firstname").toString().concat(" ".concat(_childValue.get("dormitory middle").toString().concat(" ".concat(_childValue.get("dormitory lastname").toString())))));
							Glide.with(getApplicationContext()).load(Uri.parse(ownerPhoto)).into(owner_photo);
							dorm_name.setText(_childValue.get("dormitory name").toString());
							available.setText(_childValue.get("room available").toString().concat(" Rooms Available"));
							discription.setText(_childValue.get("description").toString());
							amenities.setText(_childValue.get("amenities").toString());
							inclusion.setText(_childValue.get("inclusion").toString());
							location.setText(_childValue.get("street").toString().concat(" ".concat(_childValue.get("barangay").toString().concat(" ".concat(_childValue.get("city").toString().concat("".concat(_childValue.get("province").toString())))))));
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo1").toString())).into(photo1);
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo5").toString())).into(photo2);
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo9").toString())).into(photo3);
							monthly_rent.setText("₱".concat(_childValue.get("rates monthly price").toString()));
							owner_review.setText("⭐ ".concat(String.valueOf(Double.parseDouble(_childValue.get("rating").toString())).concat(" (".concat(String.valueOf((long)(reviewCount)).concat(" ".concat(review_paste.concat(")")))))));
							owner_review1.setText("⭐ ".concat(String.valueOf(Double.parseDouble(_childValue.get("rating").toString())).concat(" (".concat(String.valueOf((long)(reviewCount)).concat(" ".concat(review_paste.concat(")")))))));
							dormitory_name = _childValue.get("dormitory name").toString();
							dormitory_location = _childValue.get("street").toString().concat(" ".concat(_childValue.get("barangay").toString().concat(" ".concat(_childValue.get("city").toString().concat("".concat(_childValue.get("province").toString()))))));
							_mapview1_controller.moveCamera(Double.parseDouble(_childValue.get("latitude").toString()), Double.parseDouble(_childValue.get("longitude").toString()));
							_mapview1_controller.addMarker(dormitory_name, Double.parseDouble(_childValue.get("latitude").toString()), Double.parseDouble(_childValue.get("longitude").toString()));
							_mapview1_controller.zoomTo(19);
							dormitory_photo = _childValue.get("photo1").toString();
							dormitory_price = _childValue.get("rates monthly price").toString();
							dormitory_getPost = _childValue.get("getPost").toString();
							owner_uid = _childValue.get("dormitory uid").toString();
							rate_beds = _childValue.get("rates bedroom").toString();
							rate_status = _childValue.get("rates status").toString();
							p1 = _childValue.get("photo1").toString();
							p2 = _childValue.get("photo2").toString();
							p3 = _childValue.get("photo3").toString();
							p4 = _childValue.get("photo4").toString();
							p5 = _childValue.get("photo5").toString();
							p6 = _childValue.get("photo6").toString();
							p7 = _childValue.get("photo7").toString();
							p8 = _childValue.get("photo8").toString();
							p9 = _childValue.get("photo9").toString();
							p10 = _childValue.get("photo10").toString();
							p11 = _childValue.get("photo11").toString();
							p12 = _childValue.get("photo12").toString();
							type_of_dormitory = _childValue.get("type of dormitory").toString();
							info_type_of_dormitory.setText(_childValue.get("type of dormitory").toString());
							info_total_number_of_bedrooms.setText(_childValue.get("total bed rooms").toString());
							if (_childValue.get("type of dormitory").toString().equals("Co-ed Dormitory")) {
								room_information.setVisibility(View.VISIBLE);
								coed_layout1.setVisibility(View.VISIBLE);
								coed_layout2.setVisibility(View.VISIBLE);
								textview36.setText("Total No. of Room Available: ");
								info_room_available.setText(_childValue.get("room available").toString());
								textview38.setText("Total No. of Room Occupied: ");
								info_room_occupied.setText(_childValue.get("room occupied").toString());
								rates_advance.setText(_childValue.get("amount advance").toString());
								rates_deposit.setText(_childValue.get("amount deposit").toString());
								//BOYS
								boys_room_available.setText(_childValue.get("room available boys").toString());
								boys_bedroom.setText(_childValue.get("boys bedroom").toString());
								boys_bed.setText(_childValue.get("boys rates bed").toString());
								boys_bedtype.setText(_childValue.get("boys bedtype").toString());
								boys_floor.setText(_childValue.get("boys floor").toString());
								rates_room_available_boys.setText(_childValue.get("room available boys").toString());
								rates_boys_bedroom.setText(_childValue.get("boys rates bedroom").toString());
								rates_boys_beds.setText(_childValue.get("boys rates bed").toString());
								rates_boys_status.setText(_childValue.get("boys rates status").toString());
								rates_boys_floor.setText(_childValue.get("boys rates floor").toString());
								rates_boys_monthly_price.setText(_childValue.get("boys rates monthly price").toString());
								//GIRLS
								girls_room_available.setText(_childValue.get("room available girls").toString());
								girls_bedroom.setText(_childValue.get("girls bedroom").toString());
								girls_bed.setText(_childValue.get("rates bed").toString());
								girls_bedtype.setText(_childValue.get("girls bedtype").toString());
								girls_floor.setText(_childValue.get("girls floor").toString());
								rates_room_available_girls.setText(_childValue.get("room available girls").toString());
								rates_girls_bedroom.setText(_childValue.get("rates bedroom").toString());
								rates_girls_beds.setText(_childValue.get("rates bed").toString());
								rates_girls_status.setText(_childValue.get("rates status").toString());
								rates_girls_floor.setText(_childValue.get("rates floor").toString());
								rates_girls_monthly_price.setText(_childValue.get("rates monthly price").toString());
								amount_advance = _childValue.get("amount advance").toString();
								amount_deposit = _childValue.get("amount deposit").toString();
							}
							else {
								if (_childValue.get("type of dormitory").toString().equals("Transcient")) {
									room_information.setVisibility(View.VISIBLE);
									transcient_layout1.setVisibility(View.VISIBLE);
									transcient_layout2.setVisibility(View.VISIBLE);
									info_bedroom1.setText(_childValue.get("bedroom1").toString());
									info_bedtype.setText(_childValue.get("bedtype1").toString());
									info_floor.setText(_childValue.get("floor1").toString());
									info_room_available.setText(_childValue.get("room available").toString());
									info_room_occupied.setText(_childValue.get("room occupied").toString());
									rates_minimum_stay.setHint(_childValue.get("minimum stay").toString());
									rates_per_night2.setHint(String.valueOf((long)(Double.parseDouble(_childValue.get("minimum stay").toString()) * Double.parseDouble(_childValue.get("rates per night").toString()))));
									rates_per_night = _childValue.get("rates per night").toString();
									minimum_stay = _childValue.get("minimum stay").toString();
								}
								else {
									if (_childValue.get("type of dormitory").toString().equals("Male Dormitory") || (_childValue.get("type of dormitory").toString().equals("Female Dormitory") || _childValue.get("type of dormitory").toString().equals("Gender-neutral Dormitory"))) {
										room_information.setVisibility(View.VISIBLE);
										coed_layout1.setVisibility(View.GONE);
										coed_layout2.setVisibility(View.VISIBLE);
										transcient_layout1.setVisibility(View.VISIBLE);
										textview67.setVisibility(View.GONE);
										linear45.setVisibility(View.GONE);
										linear48.setVisibility(View.GONE);
										linear49.setVisibility(View.GONE);
										textview68.setVisibility(View.GONE);
										info_bedroom1.setText(_childValue.get("bedroom1").toString());
										info_bedtype.setText(_childValue.get("bedtype1").toString());
										info_floor.setText(_childValue.get("floor1").toString());
										info_room_available.setText(_childValue.get("room available").toString());
										info_room_occupied.setText(_childValue.get("room occupied").toString());
										textview36.setText("Total No. of Room Available: ");
										info_room_available.setText(_childValue.get("room available").toString());
										textview38.setText("Total No. of Room Occupied: ");
										info_room_occupied.setText(_childValue.get("room occupied").toString());
										rates_girls_bedroom.setText(_childValue.get("rates bedroom").toString());
										rates_girls_beds.setText(_childValue.get("rates bed").toString());
										rates_girls_status.setText(_childValue.get("rates status").toString());
										rates_girls_floor.setText(_childValue.get("rates floor").toString());
										rates_girls_monthly_price.setText(_childValue.get("rates monthly price").toString());
										rates_advance.setText(_childValue.get("amount advance").toString());
										rates_deposit.setText(_childValue.get("amount deposit").toString());
										amount_advance = _childValue.get("amount advance").toString();
										amount_deposit = _childValue.get("amount deposit").toString();
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
				rev++;
				reviewCount = rev;
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
						if (review_listmap.size() > 0) {
							recyclerview2.setAdapter(new Recyclerview2Adapter(review_listmap));
							reviews_layout.setVisibility(View.VISIBLE);
							review_paste = "review";
							if (review_listmap.size() > 1) {
								review_paste = "reviews";
							}
						}
						else {
							
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
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				_telegramLoaderDialog(false);
				post.addChildEventListener(_post_child_listener);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("uid"))) {
					ownerPhoto = _childValue.get("userKey").toString();
				}
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
		
		_reviewsCount_child_listener = new ChildEventListener() {
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
		reviewsCount.addChildEventListener(_reviewsCount_child_listener);
		
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
		_ImageColor(message_icon, "#176b87");
		_ImageColor(available_icon, "#176b87");
		_ImageColor(location_icon, "#176b87");
		_advancedCorners(bottom, "#f5f5f5", 100, 100, 0, 0);
		_advancedCorners(linear19, "#ffffff", 100, 100, 0, 0);
		_simpleRiffle(see_all);
		_simpleRiffle(comment_see_all);
		_simpleriffle2(book_now);
		_riffleEffect("#f5f5f5", message_icon);
		_removeScollBar(vscroll1);
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("text", getIntent().getStringExtra("photo1"));
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("text", getIntent().getStringExtra("photo5"));
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("text", getIntent().getStringExtra("photo9"));
			listmap.add(_item);
		}
		
		viewpager1.setAdapter(new Viewpager1Adapter(listmap));
		recyclerview1.setAdapter(new Recyclerview1Adapter(listmap));
		recyclerview1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		recyclerview1.setHasFixedSize(true);
		reviews_layout.setVisibility(View.GONE);
		review_paste = "review";
		room_information.setVisibility(View.GONE);
		transcient_layout1.setVisibility(View.GONE);
		transcient_layout2.setVisibility(View.GONE);
		coed_layout1.setVisibility(View.GONE);
		coed_layout2.setVisibility(View.GONE);
		rates_per_night2.setEnabled(false);
		_Restrict_Input(rates_minimum_stay);
		rates_minimum_stay.requestFocus();
		position = 0;
		num = 0;
		rev = 0;
		if (data.getString("user", "").equals("owner")) {
			cardview7.setVisibility(View.GONE);
		}
		else {
			if (data.getString("user", "").equals("student")) {
				cardview7.setVisibility(View.VISIBLE);
			}
		}
		users.addChildEventListener(_users_child_listener);
		recyclerview2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		str = "post/".concat(getIntent().getStringExtra("getPost").concat("/reviews"));
		reviews = _firebase.getReference(str);
		reviews.addChildEventListener(_reviews_child_listener);
		_telegramLoaderDialog(true);
		net.startRequestNetwork(RequestNetworkController.GET, "https://dorm-finder-df3f2-default-rtdb.firebaseio.com/", "Error", _net_request_listener);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mapview1.onDestroy();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		mapview1.onStart();
	}
	
	@Override
	public void onPause() {
		super.onPause();
		mapview1.onPause();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		mapview1.onResume();
	}
	
	@Override
	public void onStop() {
		super.onStop();
		mapview1.onStop();
	}
	public void _advance(final View _linear) {
		try{
			
			_linear.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
			Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(Color.parseColor("#ffffff"));
			
		}catch (Exception ex) {
			
		}finally{
			
		}
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
	
	
	public void _simpleRiffle(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff")), null);
		
		_view.setBackground(GA8PO9);
	}
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _advancedCorners(final View _view, final String _color, final double _n1, final double _n2, final double _n3, final double _n4) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		
		gd.setCornerRadii(new float[]{(int)_n1,(int)_n1,(int)_n2,(int)_n2,(int)_n4,(int)_n4,(int)_n3,(int)_n3});
		
		_view.setBackground(gd);
	}
	
	
	public void _simpleriffle2(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#176b87")), null);
		
		_view.setBackground(GA8PO9);
	}
	
	
	public void _riffleEffect(final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)}); android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null); _view.setBackground(ripdr);
	}
	
	
	public void _setRadiusCorner(final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
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
	
	
	public void _setSingleLine(final TextView _view, final boolean _bool) {
		_view.setSingleLine(_bool);
	}
	
	
	public void _Restrict_Input(final TextView _koshurboiitxt) {
		_koshurboiitxt.setInputType(InputType.TYPE_CLASS_NUMBER); 
	}
	
	
	public void _Hide_Keyboard(final TextView _edittext) {
		_edittext.setEnabled(false);
		_edittext.setEnabled(true);
	}
	
	public class Viewpager1Adapter extends PagerAdapter {
		
		Context _context;
		ArrayList<HashMap<String, Object>> _data;
		
		public Viewpager1Adapter(Context _ctx, ArrayList<HashMap<String, Object>> _arr) {
			_context = _ctx;
			_data = _arr;
		}
		
		public Viewpager1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_context = getApplicationContext();
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public boolean isViewFromObject(View _view, Object _object) {
			return _view == _object;
		}
		
		@Override
		public void destroyItem(ViewGroup _container, int _position, Object _object) {
			_container.removeView((View) _object);
		}
		
		@Override
		public int getItemPosition(Object _object) {
			return super.getItemPosition(_object);
		}
		
		@Override
		public CharSequence getPageTitle(int pos) {
			// Use the Activity Event (onTabLayoutNewTabAdded) in order to use this method
			return "page " + String.valueOf(pos);
		}
		
		@Override
		public Object instantiateItem(ViewGroup _container,  final int _position) {
			View _view = LayoutInflater.from(_context).inflate(R.layout.slider, _container, false);
			
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			
			Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("text").toString())).into(imageview1);
			
			_container.addView(_view);
			return _view;
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
			View _v = _inflater.inflate(R.layout.slider_dot, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
			_view.setLayoutParams(_lp);
			_rippleRoundStroke(linear1, "#FFFFFF", "#FFFFFF", 555, 0, "#FFFFFF");
			if (position == _position) {
				_rippleRoundStroke(linear1, "#FFFFFF", "#FFFFFF", 555, 0, "#FFFFFF");
				linear1.setAlpha((float)(1.0d));
			}
			else {
				_rippleRoundStroke(linear1, "#FFFFFF", "#FFFFFF", 555, 0, "#FFFFFF");
				linear1.setAlpha((float)(0.5d));
			}
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
			
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_view.setLayoutParams(_lp);
			_simpleRiffle(linear1);
			_riffleEffect("#f5f5f5", see_review);
			_setSingleLine(user_fullname, true);
			_ImageColor(see_review, "#176b87");
			see_review.setVisibility(View.GONE);
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
				message.setVisibility(View.GONE);
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