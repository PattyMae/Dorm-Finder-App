package fastrust.dorm.finder;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
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
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class BookingActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private String dateToday = "";
	private String getPost = "";
	private String page = "";
	private String chooseDay = "";
	private String chooseYear = "";
	private String chooseMonth = "";
	private String str = "";
	private boolean isVisible = false;
	private String profile = "";
	private String noti_getPost = "";
	private String guessName = "";
	private double totalBooking = 0;
	private double totalAvailable = 0;
	private double totalOccupied = 0;
	private String phone = "";
	private String getStatus = "";
	private String data_rates_per_night = "";
	private String data_minimum_stay = "";
	private String data_advance = "";
	private String data_deposit = "";
	private String data_photo = "";
	private String data_dormitory_name = "";
	private String data_location = "";
	private String data_type_of_dormitory = "";
	private String data_monthly_price = "";
	private String data_dormitory_uid = "";
	private String data_guess_name = "";
	private String data_dorm_post = "";
	private double bedroomNum = 0;
	private double summary_bedroomNum = 0;
	private String data_status = "";
	private double bedroomRemove = 0;
	private double totalBedroomCount = 0;
	private double totalBoysBedroomCount = 0;
	private double totalBedCount = 0;
	private double rates_beroom_num = 0;
	private double boysBedroomRemove = 0;
	private double finalCount = 0;
	private double totalPrice = 0;
	private double totalBedroom = 0;
	private double totalBeds = 0;
	private double totalFloor = 0;
	private double quantity = 0;
	private double book = 0;
	private String dormPost = "";
	private String bookingPost = "";
	private String booking_bedroom = "";
	private String booking_bed = "";
	private String booking_floor = "";
	private String booking_price = "";
	
	private ArrayList<HashMap<String, Object>> rates_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> summary_rates_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> beds_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> final_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> booking_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> booking_lstmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear5;
	private LinearLayout linear4;
	private ImageView back;
	private TextView textview1;
	private LinearLayout page1;
	private LinearLayout page2;
	private LinearLayout page3;
	private ScrollView vscroll1;
	private LinearLayout linear30;
	private TextView textview2;
	private CardView cardview1;
	private TextView textview11;
	private LinearLayout linear29;
	private TextView textview13;
	private LinearLayout coed_layout;
	private RecyclerView recyclerview3;
	private LinearLayout advance_deposit_layout;
	private LinearLayout rates_layout;
	private TextView textview34;
	private CardView cardview26;
	private TextView textview3;
	private CardView cardview27;
	private CalendarView calendarview1;
	private CardView cardview14;
	private CardView cardview15;
	private EditText time_paste;
	private ImageView select_time_icon;
	private TextView girls;
	private LinearLayout girls_layout;
	private RecyclerView recyclerview1;
	private TextView boys;
	private LinearLayout boys_layout;
	private CheckBox checkbox1;
	private LinearLayout linear65;
	private LinearLayout linear33;
	private LinearLayout linear60;
	private LinearLayout linear34;
	private LinearLayout linear62;
	private LinearLayout linear63;
	private TextView textview14;
	private CardView cardview16;
	private LinearLayout linear67;
	private TextView girls_bedroom;
	private ImageView girls_bedroom_option;
	private TextView textview47;
	private CardView cardview35;
	private LinearLayout linear69;
	private TextView girls_bed;
	private ImageView girls_bed_option;
	private TextView textview48;
	private CardView cardview36;
	private LinearLayout linear71;
	private TextView girls_floor;
	private ImageView girls_floor_option;
	private LinearLayout monthly_layout;
	private LinearLayout linear35;
	private LinearLayout linear66;
	private TextView textview16;
	private CardView cardview18;
	private TextView girls_price;
	private TextView textview15;
	private CardView cardview17;
	private TextView girls_status;
	private CheckBox checkbox2;
	private LinearLayout linear74;
	private LinearLayout linear37;
	private LinearLayout linear61;
	private LinearLayout linear38;
	private LinearLayout linear75;
	private LinearLayout linear76;
	private TextView textview22;
	private CardView cardview19;
	private LinearLayout linear78;
	private TextView boys_bedroom;
	private ImageView boys_bedroom_option;
	private TextView textview51;
	private CardView cardview40;
	private LinearLayout linear80;
	private TextView boys_bed;
	private ImageView boys_bed_option;
	private TextView textview52;
	private CardView cardview41;
	private LinearLayout linear82;
	private TextView boys_floor;
	private ImageView boys_floor_option;
	private LinearLayout linear40;
	private LinearLayout linear39;
	private LinearLayout linear77;
	private TextView textview24;
	private CardView cardview21;
	private TextView boys_price;
	private TextView textview23;
	private CardView cardview20;
	private TextView boys_status;
	private LinearLayout linear42;
	private LinearLayout linear43;
	private TextView textview25;
	private CardView cardview22;
	private TextView amount_advance;
	private TextView textview26;
	private CardView cardview23;
	private TextView amount_deposit;
	private TextView textview27;
	private TextView textview28;
	private LinearLayout linear44;
	private CheckBox checkbox3;
	private LinearLayout linear45;
	private LinearLayout linear46;
	private TextView textview29;
	private CardView cardview24;
	private TextView rates_per_night;
	private TextView textview30;
	private CardView cardview25;
	private LinearLayout linear49;
	private CardView cardview28;
	private LinearLayout linear47;
	private TextView minimum_stay;
	private TextView textview33;
	private TextView payment_method;
	private LinearLayout linear48;
	private EditText edittext1;
	private TextView textview4;
	private TextView firstname;
	private TextView middle_name;
	private TextView lastname;
	private LinearLayout linear7;
	private LinearLayout linear6;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private TextView gender;
	private ImageView imageview2;
	private TextView birthday;
	private ImageView imageview1;
	private TextView email;
	private ImageView imageview3;
	private ImageView imageview4;
	private TextView phone_number;
	private ScrollView vscroll2;
	private LinearLayout linear50;
	private CardView book_progress_layout;
	private TextView progress_note;
	private CardView cardview3;
	private CardView cardview5;
	private CardView cardview29;
	private CardView cardview30;
	private CardView cardview31;
	private LinearLayout linear28;
	private CardView cardview13;
	private LinearLayout linear18;
	private LinearLayout linear15;
	private LinearLayout linear19;
	private CardView cardview7;
	private LinearLayout linear16;
	private CardView cardview8;
	private LinearLayout linear17;
	private CardView cardview9;
	private LinearLayout linear21;
	private CardView cardview10;
	private LinearLayout progress1;
	private LinearLayout linear22;
	private CardView cardview11;
	private LinearLayout progress2;
	private LinearLayout linear23;
	private CardView cardview12;
	private LinearLayout progress3;
	private TextView textview8;
	private TextView textview9;
	private TextView textview10;
	private LinearLayout linear11;
	private CardView cardview4;
	private LinearLayout linear10;
	private LinearLayout linear12;
	private ImageView photo;
	private TextView dormitory_name;
	private TextView location;
	private TextView price_per_night;
	private TextView textview6;
	private LinearLayout linear14;
	private LinearLayout linear31;
	private LinearLayout linear32;
	private TextView textview7;
	private TextView schedule;
	private TextView textview12;
	private TextView time;
	private LinearLayout linear51;
	private TextView textview35;
	private TextView beds_gender;
	private RecyclerView recyclerview4;
	private RecyclerView recyclerview2;
	private LinearLayout linear88;
	private LinearLayout linear56;
	private LinearLayout linear57;
	private TextView textview58;
	private TextView amount_total_beds;
	private TextView textview40;
	private TextView select_advance;
	private TextView textview41;
	private TextView select_deposit;
	private LinearLayout linear58;
	private LinearLayout linear87;
	private LinearLayout payment_status_layout;
	private TextView textview44;
	private TextView select_payment;
	private TextView textview57;
	private TextView payment_status;
	private LinearLayout linear59;
	private TextView textview46;
	private TextView select_note;
	private CardView continue_layout;
	private CardView done_layout;
	private CardView goto_booking_layout;
	private TextView continue_btn;
	private TextView done_btn;
	private TextView goto_btn;
	
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
	private Calendar cal = Calendar.getInstance();
	private SharedPreferences data;
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private Intent intent = new Intent();
	private DatabaseReference getpost = _firebase.getReference("getPost");
	private ChildEventListener _getpost_child_listener;
	private DatabaseReference notification = _firebase.getReference("notification");
	private ChildEventListener _notification_child_listener;
	private DatabaseReference post = _firebase.getReference("post");
	private ChildEventListener _post_child_listener;
	private DatabaseReference my_booking = _firebase.getReference("booking");
	private ChildEventListener _my_booking_child_listener;
	private DatabaseReference booking = _firebase.getReference("booking");
	private ChildEventListener _booking_child_listener;
	private DatabaseReference total = _firebase.getReference("total");
	private ChildEventListener _total_child_listener;
	private RequestNetwork network1;
	private RequestNetwork.RequestListener _network1_request_listener;
	private AlertDialog.Builder d_bed;
	private DatabaseReference postData = _firebase.getReference("post");
	private ChildEventListener _postData_child_listener;
	private DatabaseReference coed_data = _firebase.getReference("post");
	private ChildEventListener _coed_data_child_listener;
	private DatabaseReference postBooking = _firebase.getReference("booking");
	private ChildEventListener _postBooking_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.booking);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear5 = findViewById(R.id.linear5);
		linear4 = findViewById(R.id.linear4);
		back = findViewById(R.id.back);
		textview1 = findViewById(R.id.textview1);
		page1 = findViewById(R.id.page1);
		page2 = findViewById(R.id.page2);
		page3 = findViewById(R.id.page3);
		vscroll1 = findViewById(R.id.vscroll1);
		linear30 = findViewById(R.id.linear30);
		textview2 = findViewById(R.id.textview2);
		cardview1 = findViewById(R.id.cardview1);
		textview11 = findViewById(R.id.textview11);
		linear29 = findViewById(R.id.linear29);
		textview13 = findViewById(R.id.textview13);
		coed_layout = findViewById(R.id.coed_layout);
		recyclerview3 = findViewById(R.id.recyclerview3);
		advance_deposit_layout = findViewById(R.id.advance_deposit_layout);
		rates_layout = findViewById(R.id.rates_layout);
		textview34 = findViewById(R.id.textview34);
		cardview26 = findViewById(R.id.cardview26);
		textview3 = findViewById(R.id.textview3);
		cardview27 = findViewById(R.id.cardview27);
		calendarview1 = findViewById(R.id.calendarview1);
		cardview14 = findViewById(R.id.cardview14);
		cardview15 = findViewById(R.id.cardview15);
		time_paste = findViewById(R.id.time_paste);
		select_time_icon = findViewById(R.id.select_time_icon);
		girls = findViewById(R.id.girls);
		girls_layout = findViewById(R.id.girls_layout);
		recyclerview1 = findViewById(R.id.recyclerview1);
		boys = findViewById(R.id.boys);
		boys_layout = findViewById(R.id.boys_layout);
		checkbox1 = findViewById(R.id.checkbox1);
		linear65 = findViewById(R.id.linear65);
		linear33 = findViewById(R.id.linear33);
		linear60 = findViewById(R.id.linear60);
		linear34 = findViewById(R.id.linear34);
		linear62 = findViewById(R.id.linear62);
		linear63 = findViewById(R.id.linear63);
		textview14 = findViewById(R.id.textview14);
		cardview16 = findViewById(R.id.cardview16);
		linear67 = findViewById(R.id.linear67);
		girls_bedroom = findViewById(R.id.girls_bedroom);
		girls_bedroom_option = findViewById(R.id.girls_bedroom_option);
		textview47 = findViewById(R.id.textview47);
		cardview35 = findViewById(R.id.cardview35);
		linear69 = findViewById(R.id.linear69);
		girls_bed = findViewById(R.id.girls_bed);
		girls_bed_option = findViewById(R.id.girls_bed_option);
		textview48 = findViewById(R.id.textview48);
		cardview36 = findViewById(R.id.cardview36);
		linear71 = findViewById(R.id.linear71);
		girls_floor = findViewById(R.id.girls_floor);
		girls_floor_option = findViewById(R.id.girls_floor_option);
		monthly_layout = findViewById(R.id.monthly_layout);
		linear35 = findViewById(R.id.linear35);
		linear66 = findViewById(R.id.linear66);
		textview16 = findViewById(R.id.textview16);
		cardview18 = findViewById(R.id.cardview18);
		girls_price = findViewById(R.id.girls_price);
		textview15 = findViewById(R.id.textview15);
		cardview17 = findViewById(R.id.cardview17);
		girls_status = findViewById(R.id.girls_status);
		checkbox2 = findViewById(R.id.checkbox2);
		linear74 = findViewById(R.id.linear74);
		linear37 = findViewById(R.id.linear37);
		linear61 = findViewById(R.id.linear61);
		linear38 = findViewById(R.id.linear38);
		linear75 = findViewById(R.id.linear75);
		linear76 = findViewById(R.id.linear76);
		textview22 = findViewById(R.id.textview22);
		cardview19 = findViewById(R.id.cardview19);
		linear78 = findViewById(R.id.linear78);
		boys_bedroom = findViewById(R.id.boys_bedroom);
		boys_bedroom_option = findViewById(R.id.boys_bedroom_option);
		textview51 = findViewById(R.id.textview51);
		cardview40 = findViewById(R.id.cardview40);
		linear80 = findViewById(R.id.linear80);
		boys_bed = findViewById(R.id.boys_bed);
		boys_bed_option = findViewById(R.id.boys_bed_option);
		textview52 = findViewById(R.id.textview52);
		cardview41 = findViewById(R.id.cardview41);
		linear82 = findViewById(R.id.linear82);
		boys_floor = findViewById(R.id.boys_floor);
		boys_floor_option = findViewById(R.id.boys_floor_option);
		linear40 = findViewById(R.id.linear40);
		linear39 = findViewById(R.id.linear39);
		linear77 = findViewById(R.id.linear77);
		textview24 = findViewById(R.id.textview24);
		cardview21 = findViewById(R.id.cardview21);
		boys_price = findViewById(R.id.boys_price);
		textview23 = findViewById(R.id.textview23);
		cardview20 = findViewById(R.id.cardview20);
		boys_status = findViewById(R.id.boys_status);
		linear42 = findViewById(R.id.linear42);
		linear43 = findViewById(R.id.linear43);
		textview25 = findViewById(R.id.textview25);
		cardview22 = findViewById(R.id.cardview22);
		amount_advance = findViewById(R.id.amount_advance);
		textview26 = findViewById(R.id.textview26);
		cardview23 = findViewById(R.id.cardview23);
		amount_deposit = findViewById(R.id.amount_deposit);
		textview27 = findViewById(R.id.textview27);
		textview28 = findViewById(R.id.textview28);
		linear44 = findViewById(R.id.linear44);
		checkbox3 = findViewById(R.id.checkbox3);
		linear45 = findViewById(R.id.linear45);
		linear46 = findViewById(R.id.linear46);
		textview29 = findViewById(R.id.textview29);
		cardview24 = findViewById(R.id.cardview24);
		rates_per_night = findViewById(R.id.rates_per_night);
		textview30 = findViewById(R.id.textview30);
		cardview25 = findViewById(R.id.cardview25);
		linear49 = findViewById(R.id.linear49);
		cardview28 = findViewById(R.id.cardview28);
		linear47 = findViewById(R.id.linear47);
		minimum_stay = findViewById(R.id.minimum_stay);
		textview33 = findViewById(R.id.textview33);
		payment_method = findViewById(R.id.payment_method);
		linear48 = findViewById(R.id.linear48);
		edittext1 = findViewById(R.id.edittext1);
		textview4 = findViewById(R.id.textview4);
		firstname = findViewById(R.id.firstname);
		middle_name = findViewById(R.id.middle_name);
		lastname = findViewById(R.id.lastname);
		linear7 = findViewById(R.id.linear7);
		linear6 = findViewById(R.id.linear6);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		gender = findViewById(R.id.gender);
		imageview2 = findViewById(R.id.imageview2);
		birthday = findViewById(R.id.birthday);
		imageview1 = findViewById(R.id.imageview1);
		email = findViewById(R.id.email);
		imageview3 = findViewById(R.id.imageview3);
		imageview4 = findViewById(R.id.imageview4);
		phone_number = findViewById(R.id.phone_number);
		vscroll2 = findViewById(R.id.vscroll2);
		linear50 = findViewById(R.id.linear50);
		book_progress_layout = findViewById(R.id.book_progress_layout);
		progress_note = findViewById(R.id.progress_note);
		cardview3 = findViewById(R.id.cardview3);
		cardview5 = findViewById(R.id.cardview5);
		cardview29 = findViewById(R.id.cardview29);
		cardview30 = findViewById(R.id.cardview30);
		cardview31 = findViewById(R.id.cardview31);
		linear28 = findViewById(R.id.linear28);
		cardview13 = findViewById(R.id.cardview13);
		linear18 = findViewById(R.id.linear18);
		linear15 = findViewById(R.id.linear15);
		linear19 = findViewById(R.id.linear19);
		cardview7 = findViewById(R.id.cardview7);
		linear16 = findViewById(R.id.linear16);
		cardview8 = findViewById(R.id.cardview8);
		linear17 = findViewById(R.id.linear17);
		cardview9 = findViewById(R.id.cardview9);
		linear21 = findViewById(R.id.linear21);
		cardview10 = findViewById(R.id.cardview10);
		progress1 = findViewById(R.id.progress1);
		linear22 = findViewById(R.id.linear22);
		cardview11 = findViewById(R.id.cardview11);
		progress2 = findViewById(R.id.progress2);
		linear23 = findViewById(R.id.linear23);
		cardview12 = findViewById(R.id.cardview12);
		progress3 = findViewById(R.id.progress3);
		textview8 = findViewById(R.id.textview8);
		textview9 = findViewById(R.id.textview9);
		textview10 = findViewById(R.id.textview10);
		linear11 = findViewById(R.id.linear11);
		cardview4 = findViewById(R.id.cardview4);
		linear10 = findViewById(R.id.linear10);
		linear12 = findViewById(R.id.linear12);
		photo = findViewById(R.id.photo);
		dormitory_name = findViewById(R.id.dormitory_name);
		location = findViewById(R.id.location);
		price_per_night = findViewById(R.id.price_per_night);
		textview6 = findViewById(R.id.textview6);
		linear14 = findViewById(R.id.linear14);
		linear31 = findViewById(R.id.linear31);
		linear32 = findViewById(R.id.linear32);
		textview7 = findViewById(R.id.textview7);
		schedule = findViewById(R.id.schedule);
		textview12 = findViewById(R.id.textview12);
		time = findViewById(R.id.time);
		linear51 = findViewById(R.id.linear51);
		textview35 = findViewById(R.id.textview35);
		beds_gender = findViewById(R.id.beds_gender);
		recyclerview4 = findViewById(R.id.recyclerview4);
		recyclerview2 = findViewById(R.id.recyclerview2);
		linear88 = findViewById(R.id.linear88);
		linear56 = findViewById(R.id.linear56);
		linear57 = findViewById(R.id.linear57);
		textview58 = findViewById(R.id.textview58);
		amount_total_beds = findViewById(R.id.amount_total_beds);
		textview40 = findViewById(R.id.textview40);
		select_advance = findViewById(R.id.select_advance);
		textview41 = findViewById(R.id.textview41);
		select_deposit = findViewById(R.id.select_deposit);
		linear58 = findViewById(R.id.linear58);
		linear87 = findViewById(R.id.linear87);
		payment_status_layout = findViewById(R.id.payment_status_layout);
		textview44 = findViewById(R.id.textview44);
		select_payment = findViewById(R.id.select_payment);
		textview57 = findViewById(R.id.textview57);
		payment_status = findViewById(R.id.payment_status);
		linear59 = findViewById(R.id.linear59);
		textview46 = findViewById(R.id.textview46);
		select_note = findViewById(R.id.select_note);
		continue_layout = findViewById(R.id.continue_layout);
		done_layout = findViewById(R.id.done_layout);
		goto_booking_layout = findViewById(R.id.goto_booking_layout);
		continue_btn = findViewById(R.id.continue_btn);
		done_btn = findViewById(R.id.done_btn);
		goto_btn = findViewById(R.id.goto_btn);
		fauth = FirebaseAuth.getInstance();
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		network = new RequestNetwork(this);
		net = new RequestNetwork(this);
		network1 = new RequestNetwork(this);
		d_bed = new AlertDialog.Builder(this);
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (page.equals("3")) {
					page = "2";
					page1.setVisibility(View.GONE);
					page2.setVisibility(View.VISIBLE);
					page3.setVisibility(View.GONE);
				}
				else {
					if (page.equals("2")) {
						page = "1";
						page1.setVisibility(View.VISIBLE);
						page2.setVisibility(View.GONE);
						page3.setVisibility(View.GONE);
					}
					else {
						if (page.equals("1")) {
							finish();
						}
					}
				}
			}
		});
		
		calendarview1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
			@Override
			public void onSelectedDayChange(CalendarView _param1, int _param2, int _param3, int _param4) {
				final int _year = _param2;
				final int _month = _param3;
				final int _day = _param4;
				chooseDay = String.valueOf((long)(_day));
				chooseYear = String.valueOf((long)(_year));
				_months(_month + 1);
			}
		});
		
		select_time_icon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				DialogFragment newFragment = new TimePickerFragment();
				newFragment.show(getSupportFragmentManager(), "timePicker");
			}
		});
		
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					checkbox1.setChecked(true);
					checkbox2.setChecked(false);
					girls_bedroom_option.setEnabled(true);
					girls_bed_option.setEnabled(true);
					girls_floor_option.setEnabled(true);
					booking_bedroom = girls_bedroom.getText().toString();
					booking_bed = girls_bed.getText().toString();
					booking_floor = girls_floor.getText().toString();
					booking_price = girls_price.getText().toString();
					for(int _repeat76 = 0; _repeat76 < (int)(1); _repeat76++) {
						map = new HashMap<>();
						map.put("final count", "");
						booking_lstmap.add(map);
						recyclerview4.setAdapter(new Recyclerview4Adapter(booking_lstmap));
					}
					checkbox2.setEnabled(false);
					recyclerview1.setVisibility(View.VISIBLE);
					recyclerview3.setVisibility(View.GONE);
					totalPrice = Double.parseDouble(girls_price.getText().toString());
					totalBedroom = Double.parseDouble(girls_bedroom.getText().toString());
					totalBeds = Double.parseDouble(girls_bed.getText().toString());
					totalFloor = Double.parseDouble(girls_floor.getText().toString());
					intent.putExtra("beds gender", "Girl(s)");
				}
				else {
					checkbox1.setChecked(false);
					girls_bedroom_option.setEnabled(false);
					girls_bed_option.setEnabled(false);
					girls_floor_option.setEnabled(false);
					finalCount--;
					checkbox2.setEnabled(true);
					totalPrice = 0;
					totalBedroom = 0;
					totalBeds = 0;
					totalFloor = 0;
					finalCount = 0;
					booking_lstmap.remove(map);
					recyclerview4.setAdapter(new Recyclerview4Adapter(booking_lstmap));
				}
			}
		});
		
		girls_bedroom_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(BookingActivity.this, girls_bedroom_option);
				
				Menu menu = popup.getMenu();
				menu.add("1");
				menu.add("2");
				menu.add("3");
				menu.add("4");
				menu.add("5");
				menu.add("6");
				menu.add("7");
				menu.add("8");
				menu.add("9");
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
							girls_bedroom.setText("1");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), girls_bedroom.getText().toString()).commit();
							return true; case "2":
							girls_bedroom.setText("2");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), girls_bedroom.getText().toString()).commit();
							return true; case "3":
							girls_bedroom.setText("3");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), girls_bedroom.getText().toString()).commit();
							return true; case "4":
							girls_bedroom.setText("4");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), girls_bedroom.getText().toString()).commit();
							return true; case "5":
							girls_bedroom.setText("5");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), girls_bedroom.getText().toString()).commit();
							return true; case "6":
							girls_bedroom.setText("6");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), girls_bedroom.getText().toString()).commit();
							return true; case "7":
							girls_bedroom.setText("7");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), girls_bedroom.getText().toString()).commit();
							return true; case "8":
							girls_bedroom.setText("8");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), girls_bedroom.getText().toString()).commit();
							return true; case "9":
							girls_bedroom.setText("9");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), girls_bedroom.getText().toString()).commit();
							return true; default: return false; } } }); popup.show();
			}
		});
		
		girls_bed_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(BookingActivity.this, girls_bed_option);
				
				Menu menu = popup.getMenu();
				menu.add("1");
				menu.add("2");
				menu.add("3");
				menu.add("4");
				menu.add("5");
				menu.add("6");
				menu.add("7");
				menu.add("8");
				menu.add("9");
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
							girls_bed.setText("1");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), girls_bed.getText().toString()).commit();
							return true; case "2":
							girls_bed.setText("2");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), girls_bed.getText().toString()).commit();
							return true; case "3":
							girls_bed.setText("3");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), girls_bed.getText().toString()).commit();
							return true; case "4":
							girls_bed.setText("4");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), girls_bed.getText().toString()).commit();
							return true; case "5":
							girls_bed.setText("5");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), girls_bed.getText().toString()).commit();
							return true; case "6":
							girls_bed.setText("6");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), girls_bed.getText().toString()).commit();
							return true; case "7":
							girls_bed.setText("7");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), girls_bed.getText().toString()).commit();
							return true; case "8":
							girls_bed.setText("8");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), girls_bed.getText().toString()).commit();
							return true; case "9":
							girls_bed.setText("9");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), girls_bed.getText().toString()).commit();
							return true; default: return false; } } }); popup.show();
			}
		});
		
		girls_floor_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(BookingActivity.this, girls_floor_option);
				
				Menu menu = popup.getMenu();
				menu.add("1");
				menu.add("2");
				menu.add("3");
				menu.add("4");
				menu.add("5");
				menu.add("6");
				menu.add("7");
				menu.add("8");
				menu.add("9");
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
							girls_floor.setText("1");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), girls_floor.getText().toString()).commit();
							return true; case "2":
							girls_floor.setText("2");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), girls_floor.getText().toString()).commit();
							return true; case "3":
							girls_floor.setText("3");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), girls_floor.getText().toString()).commit();
							return true; case "4":
							girls_floor.setText("4");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), girls_floor.getText().toString()).commit();
							return true; case "5":
							girls_floor.setText("5");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), girls_floor.getText().toString()).commit();
							return true; case "6":
							girls_floor.setText("6");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), girls_floor.getText().toString()).commit();
							return true; case "7":
							girls_floor.setText("7");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), girls_floor.getText().toString()).commit();
							return true; case "8":
							girls_floor.setText("8");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), girls_floor.getText().toString()).commit();
							return true; case "9":
							girls_floor.setText("9");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), girls_floor.getText().toString()).commit();
							return true; default: return false; } } }); popup.show();
			}
		});
		
		checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					checkbox1.setChecked(false);
					checkbox2.setChecked(true);
					boys_bedroom_option.setEnabled(true);
					boys_bed_option.setEnabled(true);
					boys_floor_option.setEnabled(true);
					data.edit().putString("beds gender", "Boy(s)").commit();
					booking_bedroom = boys_bedroom.getText().toString();
					booking_bed = boys_bed.getText().toString();
					booking_floor = boys_floor.getText().toString();
					booking_price = boys_price.getText().toString();
					for(int _repeat104 = 0; _repeat104 < (int)(1); _repeat104++) {
						map = new HashMap<>();
						map.put("final count", "");
						booking_lstmap.add(map);
						recyclerview4.setAdapter(new Recyclerview4Adapter(booking_lstmap));
					}
					checkbox1.setEnabled(false);
					recyclerview1.setVisibility(View.GONE);
					recyclerview3.setVisibility(View.VISIBLE);
					totalPrice = Double.parseDouble(boys_price.getText().toString());
					totalBedroom = Double.parseDouble(boys_bedroom.getText().toString());
					totalBeds = Double.parseDouble(boys_bed.getText().toString());
					totalFloor = Double.parseDouble(boys_floor.getText().toString());
				}
				else {
					checkbox2.setChecked(false);
					boys_bedroom_option.setEnabled(false);
					boys_bed_option.setEnabled(false);
					boys_floor_option.setEnabled(false);
					finalCount--;
					checkbox1.setEnabled(true);
					totalPrice = 0;
					totalBedroom = 0;
					totalBeds = 0;
					totalFloor = 0;
					finalCount = 0;
					booking_lstmap.remove(map);
					recyclerview4.setAdapter(new Recyclerview4Adapter(booking_lstmap));
				}
			}
		});
		
		boys_bedroom_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(BookingActivity.this, boys_bedroom_option);
				
				Menu menu = popup.getMenu();
				menu.add("1");
				menu.add("2");
				menu.add("3");
				menu.add("4");
				menu.add("5");
				menu.add("6");
				menu.add("7");
				menu.add("8");
				menu.add("9");
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
							boys_bedroom.setText("1");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), boys_bedroom.getText().toString()).commit();
							return true; case "2":
							boys_bedroom.setText("2");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), boys_bedroom.getText().toString()).commit();
							return true; case "3":
							boys_bedroom.setText("3");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), boys_bedroom.getText().toString()).commit();
							return true; case "4":
							boys_bedroom.setText("4");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), boys_bedroom.getText().toString()).commit();
							return true; case "5":
							boys_bedroom.setText("5");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), boys_bedroom.getText().toString()).commit();
							return true; case "6":
							boys_bedroom.setText("6");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), boys_bedroom.getText().toString()).commit();
							return true; case "7":
							boys_bedroom.setText("7");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), boys_bedroom.getText().toString()).commit();
							return true; case "8":
							boys_bedroom.setText("8");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), boys_bedroom.getText().toString()).commit();
							return true; case "9":
							boys_bedroom.setText("9");
							data.edit().putString("rates bedroom".concat(String.valueOf((long)(finalCount))), boys_bedroom.getText().toString()).commit();
							return true; default: return false; } } }); popup.show();
			}
		});
		
		boys_bed_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(BookingActivity.this, boys_bed_option);
				
				Menu menu = popup.getMenu();
				menu.add("1");
				menu.add("2");
				menu.add("3");
				menu.add("4");
				menu.add("5");
				menu.add("6");
				menu.add("7");
				menu.add("8");
				menu.add("9");
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
							boys_bed.setText("1");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), boys_bed.getText().toString()).commit();
							return true; case "2":
							boys_bed.setText("2");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), boys_bed.getText().toString()).commit();
							return true; case "3":
							boys_bed.setText("3");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), boys_bed.getText().toString()).commit();
							return true; case "4":
							boys_bed.setText("4");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), boys_bed.getText().toString()).commit();
							return true; case "5":
							boys_bed.setText("5");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), boys_bed.getText().toString()).commit();
							return true; case "6":
							boys_bed.setText("6");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), boys_bed.getText().toString()).commit();
							return true; case "7":
							boys_bed.setText("7");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), boys_bed.getText().toString()).commit();
							return true; case "8":
							boys_bed.setText("8");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), boys_bed.getText().toString()).commit();
							return true; case "9":
							boys_bed.setText("9");
							data.edit().putString("rates bed".concat(String.valueOf((long)(finalCount))), boys_bed.getText().toString()).commit();
							return true; default: return false; } } }); popup.show();
			}
		});
		
		boys_floor_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(BookingActivity.this, boys_floor_option);
				
				Menu menu = popup.getMenu();
				menu.add("1");
				menu.add("2");
				menu.add("3");
				menu.add("4");
				menu.add("5");
				menu.add("6");
				menu.add("7");
				menu.add("8");
				menu.add("9");
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
							boys_floor.setText("1");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), boys_floor.getText().toString()).commit();
							return true; case "2":
							boys_floor.setText("2");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), boys_floor.getText().toString()).commit();
							return true; case "3":
							boys_floor.setText("3");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), boys_floor.getText().toString()).commit();
							return true; case "4":
							boys_floor.setText("4");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), boys_floor.getText().toString()).commit();
							return true; case "5":
							boys_floor.setText("5");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), boys_floor.getText().toString()).commit();
							return true; case "6":
							boys_floor.setText("6");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), boys_floor.getText().toString()).commit();
							return true; case "7":
							boys_floor.setText("7");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), boys_floor.getText().toString()).commit();
							return true; case "8":
							boys_floor.setText("8");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), boys_floor.getText().toString()).commit();
							return true; case "9":
							boys_floor.setText("9");
							data.edit().putString("rates floor".concat(String.valueOf((long)(finalCount))), boys_floor.getText().toString()).commit();
							return true; default: return false; } } }); popup.show();
			}
		});
		
		checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					data.edit().putString("rates per night", rates_per_night.getText().toString()).commit();
					data.edit().putString("minimum stay", minimum_stay.getText().toString()).commit();
				}
				else {
					data.edit().remove("rates per night").commit();
					data.edit().remove("minimum stay").commit();
				}
			}
		});
		
		continue_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (chooseDay.equals("") || time_paste.getText().toString().equals("")) {
					if (chooseDay.equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "You haven't select date");
					}
					if (time_paste.getText().toString().equals("")) {
						((EditText)time_paste).setError("Select time");
					}
				}
				else {
					if (page.equals("1")) {
						page1.setVisibility(View.GONE);
						page2.setVisibility(View.VISIBLE);
						page3.setVisibility(View.GONE);
						page = "2";
						_Hide_Keyboard(edittext1);
					}
					else {
						if (page.equals("2")) {
							schedule.setText(chooseMonth.concat(" ".concat(chooseDay.concat(", ".concat(chooseYear)))));
							time.setText(time_paste.getText().toString());
							beds_gender.setText(data.getString("beds gender", ""));
							amount_total_beds.setText(String.valueOf((long)(totalPrice)));
							select_advance.setText(amount_advance.getText().toString());
							select_deposit.setText(amount_deposit.getText().toString());
							select_payment.setText(payment_method.getText().toString());
							select_note.setText(edittext1.getText().toString());
							if (data_type_of_dormitory.equals("Co-ed Dormitory")) {
								if (checkbox1.isChecked() || checkbox2.isChecked()) {
									textview1.setText("Review Summary");
									page1.setVisibility(View.GONE);
									page2.setVisibility(View.GONE);
									page3.setVisibility(View.VISIBLE);
									page = "3";
									_Hide_Keyboard(edittext1);
									recyclerview4.setAdapter(new Recyclerview4Adapter(booking_lstmap));
									recyclerview4.setVisibility(View.VISIBLE);
									beds_gender.setVisibility(View.VISIBLE);
								}
								else {
									SketchwareUtil.showMessage(getApplicationContext(), "Select bedroom");
								}
							}
							else {
								if (data_type_of_dormitory.equals("Transcient")) {
									if (checkbox1.isChecked() && checkbox3.isChecked()) {
										textview1.setText("Review Summary");
										textview40.setText("Rates per Night");
										select_advance.setText(new DecimalFormat("#,###").format(Double.parseDouble(rates_per_night.getText().toString())).concat("    P"));
										textview41.setText("Minimum Stay");
										select_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(minimum_stay.getText().toString())).concat("    P"));
										page1.setVisibility(View.GONE);
										page2.setVisibility(View.GONE);
										page3.setVisibility(View.VISIBLE);
										page = "3";
										_Hide_Keyboard(edittext1);
									}
									else {
										if (checkbox1.isChecked()) {
											
										}
										else {
											SketchwareUtil.showMessage(getApplicationContext(), "Select bedroom");
										}
										if (checkbox3.isChecked()) {
											
										}
										else {
											SketchwareUtil.showMessage(getApplicationContext(), "Select rates for overnight booking");
										}
									}
								}
								else {
									if (data_type_of_dormitory.equals("Male Dormitory") || (data_type_of_dormitory.equals("Female Dormitory") || data_type_of_dormitory.equals("Gender-neutral Dormitory"))) {
										if (checkbox1.isChecked()) {
											textview1.setText("Review Summary");
											page1.setVisibility(View.GONE);
											page2.setVisibility(View.GONE);
											page3.setVisibility(View.VISIBLE);
											page = "3";
											_Hide_Keyboard(edittext1);
											recyclerview4.setAdapter(new Recyclerview4Adapter(booking_lstmap));
											recyclerview4.setVisibility(View.VISIBLE);
										}
										else {
											SketchwareUtil.showMessage(getApplicationContext(), "Select bedroom");
										}
									}
								}
							}
						}
						else {
							if (page.equals("3")) {
								_telegramLoaderDialog(true);
								network.startRequestNetwork(RequestNetworkController.GET, "https://dorm-finder-df3f2-default-rtdb.firebaseio.com/", "Error", _network_request_listener);
							}
						}
					}
				}
			}
		});
		
		done_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (done_btn.getText().toString().equals("RATE")) {
					intent.setClass(getApplicationContext(), ReteDormitoryActivity.class);
					intent.putExtra("getPost", data_dorm_post);
					intent.putExtra("review", "");
					startActivity(intent);
					finish();
				}
				else {
					intent.setClass(getApplicationContext(), DashboardActivity.class);
					startActivity(intent);
				}
			}
		});
		
		goto_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (goto_btn.getText().toString().equals("Home")) {
					intent.setClass(getApplicationContext(), DashboardActivity.class);
					startActivity(intent);
				}
				else {
					intent.setClass(getApplicationContext(), MyBookingActivity.class);
					startActivity(intent);
					finish();
				}
			}
		});
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					firstname.setText(_childValue.get("firstname").toString());
					middle_name.setText(_childValue.get("middle name").toString());
					lastname.setText(_childValue.get("lastname").toString());
					birthday.setText(_childValue.get("birthday").toString());
					gender.setText(_childValue.get("gender").toString());
					email.setText(_childValue.get("email").toString());
					phone_number.setText("+63".concat(_childValue.get("phone").toString()));
					phone = _childValue.get("phone").toString();
					profile = _childValue.get("profile").toString();
					guessName = _childValue.get("firstname").toString().concat(" ".concat(_childValue.get("lastname").toString()));
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
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				map = new HashMap<>();
				map.put("first name", firstname.getText().toString());
				map.put("middle name", middle_name.getText().toString());
				map.put("last name", lastname.getText().toString());
				map.put("gender", gender.getText().toString());
				map.put("birthday", birthday.getText().toString());
				map.put("email", email.getText().toString());
				map.put("contact", phone);
				map.put("dormitory name", data_dormitory_name);
				map.put("location", data_location);
				map.put("photo", data_photo);
				map.put("price", data_monthly_price);
				map.put("dorm post", getIntent().getStringExtra("getPost"));
				map.put("getPost", getPost);
				map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				map.put("status", "pending");
				map.put("date", schedule.getText().toString());
				map.put("time", time.getText().toString());
				map.put("bedroom_select", data.getString("beds gender", ""));
				map.put("total bedroom", String.valueOf((long)(totalBedroom)));
				map.put("total bed", String.valueOf((long)(totalBeds)));
				map.put("total floor", String.valueOf((long)(totalFloor)));
				map.put("total status", data_status);
				map.put("total price", String.valueOf((long)(totalPrice)));
				map.put("amount total price", String.valueOf((long)(totalPrice)));
				map.put("quantity", String.valueOf((long)(finalCount + 1)));
				if (data_type_of_dormitory.equals("Transcient")) {
					map.put("rates per night", data_rates_per_night);
					map.put("minimum stay", data_minimum_stay);
				}
				else {
					map.put("amount advance", data_advance);
					map.put("amount deposit", data_deposit);
					map.put("girls total bedroom", String.valueOf((long)(bedroomNum)));
					map.put("boys total bedroom", String.valueOf((long)(0)));
				}
				map.put("payment method", payment_method.getText().toString());
				map.put("note", edittext1.getText().toString());
				map.put("type of dormitory", data_type_of_dormitory);
				map.put("guess name", data_guess_name);
				_more_booking();
				booking.child(data_dormitory_uid.concat("/".concat(getPost))).updateChildren(map);
				my_booking.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(getPost))).updateChildren(map);
				//NOTIFY FOR ME
				cal = Calendar.getInstance();
				map = new HashMap<>();
				map.put("profile", "book");
				map.put("title", "Booking Successful!");
				map.put("date", String.valueOf((long)(cal.getTimeInMillis())));
				map.put("message", "Congratulations! You have successfully booked a dormitory go to my booking.");
				map.put("seen", "false");
				map.put("dorm post", getIntent().getStringExtra("getPost"));
				map.put("getPost", getPost);
				map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				map.put("status", "pending");
				notification.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(getPost))).updateChildren(map);
				//NOTIFY FOR ADMIN
				map = new HashMap<>();
				map.put("profile", "book");
				map.put("title", "New Booking");
				map.put("date", String.valueOf((long)(cal.getTimeInMillis())));
				map.put("message", "New dormitory booking has been made. Click to see details");
				map.put("seen", "false");
				map.put("dorm post", getIntent().getStringExtra("getPost"));
				map.put("getPost", getPost);
				map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				map.put("status", "pending");
				notification.child(data_dormitory_uid.concat("/".concat(getPost))).updateChildren(map);
				_booking_count();
				net.startRequestNetwork(RequestNetworkController.GET, "https://dorm-finder-df3f2-default-rtdb.firebaseio.com/", "Error", _net_request_listener);
				continue_btn.setVisibility(View.GONE);
				done_layout.setVisibility(View.VISIBLE);
				goto_booking_layout.setVisibility(View.VISIBLE);
				page = "4";
				SketchwareUtil.showMessage(getApplicationContext(), "Booking request sent");
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				_telegramLoaderDialog(false);
				str = "booking/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
				my_booking = _firebase.getReference(str);
				my_booking.addChildEventListener(_my_booking_child_listener);
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
		
		_notification_child_listener = new ChildEventListener() {
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
		notification.addChildEventListener(_notification_child_listener);
		
		_post_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("getPost"))) {
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo1").toString())).into(photo);
					dormitory_name.setText(_childValue.get("dormitory name").toString());
					location.setText(_childValue.get("street").toString().concat(" ".concat(_childValue.get("barangay").toString().concat(" ".concat(_childValue.get("city").toString().concat("".concat(_childValue.get("province").toString())))))));
					data_photo = _childValue.get("photo1").toString();
					data_dormitory_name = _childValue.get("dormitory name").toString();
					data_location = _childValue.get("street").toString().concat(" ".concat(_childValue.get("barangay").toString().concat(" ".concat(_childValue.get("city").toString().concat("".concat(_childValue.get("province").toString()))))));
					data_type_of_dormitory = _childValue.get("type of dormitory").toString();
					data_monthly_price = _childValue.get("rates monthly price").toString();
					data_status = _childValue.get("rates status").toString();
					data_dormitory_uid = _childValue.get("dormitory uid").toString();
					data_guess_name = _childValue.get("dormitory firstname").toString().concat(" ".concat(_childValue.get("dormitory lastname").toString()));
					//GIRLS AND FOR FEMALE, MALE AND GENDER DORMITORY
					girls_bedroom.setText(_childValue.get("rates bedroom").toString());
					girls_bed.setText(_childValue.get("rates bed").toString());
					girls_floor.setText(_childValue.get("rates floor").toString());
					girls_price.setText(_childValue.get("rates monthly price").toString());
					girls_status.setText(_childValue.get("rates status").toString());
					if (_childValue.get("type of dormitory").toString().equals("Co-ed Dormitory")) {
						girls.setVisibility(View.VISIBLE);
						boys.setVisibility(View.VISIBLE);
						boys_layout.setVisibility(View.VISIBLE);
						price_per_night.setText("₱".concat(_childValue.get("rates monthly price").toString()));
						textview6.setText("/month");
						if ((Double.parseDouble(_childValue.get("amount advance").toString()) > 0) || (Double.parseDouble(_childValue.get("amount deposit").toString()) > 0)) {
							advance_deposit_layout.setVisibility(View.VISIBLE);
							linear56.setVisibility(View.GONE);
							linear57.setVisibility(View.GONE);
							amount_advance.setText(_childValue.get("amount advance").toString());
							amount_deposit.setText(_childValue.get("amount deposit").toString());
							data_advance = _childValue.get("amount advance").toString();
							data_deposit = _childValue.get("amount deposit").toString();
						}
						//BOYS
						boys_bedroom.setText(_childValue.get("boys rates bedroom").toString());
						boys_bed.setText(_childValue.get("boys rates bed").toString());
						boys_floor.setText(_childValue.get("boys rates floor").toString());
						boys_price.setText(_childValue.get("boys rates monthly price").toString());
						boys_status.setText(_childValue.get("boys rates status").toString());
						//BEDROOM COUNT
						totalBedroomCount = Double.parseDouble(_childValue.get("girls bed count").toString());
						totalBoysBedroomCount = Double.parseDouble(_childValue.get("boys bed count").toString());
						rates_beroom_num = 0;
						for(int _repeat674 = 0; _repeat674 < (int)(totalBedroomCount); _repeat674++) {
							rates_beroom_num++;
							map = new HashMap<>();
							map.put("bedroom num", String.valueOf((long)(rates_beroom_num)));
							rates_listmap.add(map);
							recyclerview1.setVisibility(View.VISIBLE);
						}
						//BOYS BEDROOM COUNT
						summary_bedroomNum = 0;
						for(int _repeat764 = 0; _repeat764 < (int)(totalBoysBedroomCount); _repeat764++) {
							summary_bedroomNum++;
							map = new HashMap<>();
							map.put("summary bedroom num", String.valueOf((long)(summary_bedroomNum)));
							summary_rates_listmap.add(map);
						}
						//BOYS BEDROOM COUNT
					}
					else {
						if (_childValue.get("type of dormitory").toString().equals("Transcient")) {
							monthly_layout.setVisibility(View.GONE);
							rates_layout.setVisibility(View.VISIBLE);
							price_per_night.setText("₱".concat(_childValue.get("rates per night").toString()));
							rates_per_night.setText(data.getString("rates per night", ""));
							minimum_stay.setText(data.getString("minimum stay", ""));
							data_rates_per_night = _childValue.get("rates per night").toString();
							data_minimum_stay = _childValue.get("minimum stay").toString();
						}
						else {
							if (_childValue.get("type of dormitory").toString().equals("Male Dormitory") || (_childValue.get("type of dormitory").toString().equals("Female Dormitory") || _childValue.get("type of dormitory").toString().equals("Gender-neutral Dormitory"))) {
								price_per_night.setText("₱".concat(_childValue.get("rates monthly price").toString()));
								textview6.setText("/month");
								if ((Double.parseDouble(_childValue.get("amount advance").toString()) > 0) || (Double.parseDouble(_childValue.get("amount deposit").toString()) > 0)) {
									advance_deposit_layout.setVisibility(View.VISIBLE);
									linear56.setVisibility(View.GONE);
									linear57.setVisibility(View.GONE);
									amount_advance.setText(_childValue.get("amount advance").toString());
									amount_deposit.setText(_childValue.get("amount deposit").toString());
									data_advance = _childValue.get("amount advance").toString();
									data_deposit = _childValue.get("amount deposit").toString();
								}
								//BEDROOM COUNT
								totalBedCount = Double.parseDouble(_childValue.get("bedroom count").toString());
								bedroomNum = 0;
								for(int _repeat753 = 0; _repeat753 < (int)(totalBedCount); _repeat753++) {
									bedroomNum++;
									map = new HashMap<>();
									map.put("bedroom num", String.valueOf((long)(bedroomNum)));
									rates_listmap.add(map);
									recyclerview1.setVisibility(View.VISIBLE);
								}
							}
						}
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
		post.addChildEventListener(_post_child_listener);
		
		_my_booking_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("getPost"))) {
					Glide.with(getApplicationContext()).load(Uri.parse(data_photo)).into(photo);
					dormitory_name.setText(data_dormitory_name);
					location.setText(data_location);
					bookingPost = _childValue.get("getPost").toString();
					quantity = Double.parseDouble(_childValue.get("quantity").toString());
					book = 0;
					for(int _repeat329 = 0; _repeat329 < (int)(quantity); _repeat329++) {
						book++;
						map = new HashMap<>();
						map.put("final count", String.valueOf((long)(book)));
						final_listmap.add(map);
						recyclerview2.setVisibility(View.VISIBLE);
					}
					//BOYS BEDROOM COUNT
					if (_childValue.get("status").toString().equals("pending") || _childValue.get("status").toString().equals("process")) {
						schedule.setText(_childValue.get("date").toString());
						time.setText(_childValue.get("time").toString());
						beds_gender.setText(_childValue.get("bedroom_select").toString());
						select_payment.setText(_childValue.get("payment method").toString());
						select_note.setText(_childValue.get("note").toString());
						progress1.setBackgroundColor(0xFF176B87);
						progress2.setBackgroundColor(0xFFFFFFFF);
						progress3.setBackgroundColor(0xFFFFFFFF);
						book_progress_layout.setVisibility(View.VISIBLE);
						textview1.setVisibility(View.GONE);
						continue_layout.setVisibility(View.GONE);
						done_btn.setText("Done");
						goto_btn.setText("Go to My booking");
						done_layout.setVisibility(View.VISIBLE);
						goto_booking_layout.setVisibility(View.VISIBLE);
						progress_note.setText("Our team is working  to review and process your booking request. We understand the importance of your reservation and aim to provide a seamless experience.\nTo keep you informed about the progress of your booking request, please check your notifications regularly");
						progress_note.setVisibility(View.VISIBLE);
						if (_childValue.get("dormitory name").toString().equals("Transcient")) {
							textview40.setText("Rates per Night");
							select_advance.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("rates per night").toString())).concat("    P"));
							textview41.setText("Minimum Stay");
							select_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("minimum stay").toString())).concat("    P"));
						}
						else {
							select_advance.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount advance").toString())).concat("    P"));
							select_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount deposit").toString())).concat("    P"));
							amount_total_beds.setText("₱".concat(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("total price").toString()))));
						}
						page1.setVisibility(View.GONE);
						page3.setVisibility(View.VISIBLE);
					}
					else {
						if (_childValue.get("status").toString().equals("active")) {
							schedule.setText(_childValue.get("date").toString());
							time.setText(_childValue.get("time").toString());
							beds_gender.setText(_childValue.get("bedroom_select").toString());
							select_payment.setText(_childValue.get("payment method").toString());
							select_note.setText(_childValue.get("note").toString());
							progress1.setBackgroundColor(0xFF176B87);
							progress2.setBackgroundColor(0xFF176B87);
							progress3.setBackgroundColor(0xFFFFFFFF);
							book_progress_layout.setVisibility(View.VISIBLE);
							continue_layout.setVisibility(View.GONE);
							done_btn.setText("Done");
							goto_btn.setText("Go to My booking");
							done_layout.setVisibility(View.VISIBLE);
							goto_booking_layout.setVisibility(View.VISIBLE);
							progress_note.setText("Your booking for Q & M Dormitory  on ".concat(chooseMonth.concat(chooseDay.concat(", ".concat(chooseYear.concat(" has been confirmed.\nTo secure your booking, we kindly request that payment has to be made. Completing this payment step is crucial to finalize your booking and ensure your spot at Q & M Dormitory."))))));
							progress_note.setVisibility(View.VISIBLE);
							if (_childValue.get("dormitory name").toString().equals("Transcient")) {
								textview40.setText("Rates per Night");
								select_advance.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("rates per night").toString())).concat("    P"));
								textview41.setText("Minimum Stay");
								select_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("minimum stay").toString())).concat("    P"));
							}
							else {
								select_advance.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount advance").toString())).concat("    P"));
								select_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount deposit").toString())).concat("    P"));
								amount_total_beds.setText("₱".concat(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("total price").toString()))));
							}
							page1.setVisibility(View.GONE);
							page3.setVisibility(View.VISIBLE);
						}
						else {
							if (_childValue.get("status").toString().equals("completed")) {
								data_dorm_post = _childValue.get("dorm post").toString();
								schedule.setText(_childValue.get("date").toString());
								time.setText(_childValue.get("time").toString());
								beds_gender.setText(_childValue.get("bedroom_select").toString());
								select_payment.setText(_childValue.get("payment method").toString());
								select_note.setText(_childValue.get("note").toString());
								payment_status.setText(_childValue.get("payment status").toString());
								progress1.setBackgroundColor(0xFF176B87);
								progress2.setBackgroundColor(0xFF176B87);
								progress3.setBackgroundColor(0xFF176B87);
								book_progress_layout.setVisibility(View.VISIBLE);
								textview1.setVisibility(View.GONE);
								continue_layout.setVisibility(View.GONE);
								done_btn.setText("RATE");
								goto_btn.setText("Home");
								done_layout.setVisibility(View.VISIBLE);
								goto_booking_layout.setVisibility(View.VISIBLE);
								progress_note.setText("Congratulations! Your booking is now complete, and we appreciate your prompt action in finalizing the payment transaction.\nYour booking is confirmed, and we look forward to welcoming you. Should you have any questions or need further assistance, please don't hesitate to reach out to our customer support team. Thank you for choosing us, and we hope you have a wonderful experience!\"");
								progress_note.setVisibility(View.VISIBLE);
								if (_childValue.get("dormitory name").toString().equals("Transcient")) {
									textview40.setText("Rates per Night");
									select_advance.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("rates per night").toString())).concat("    P"));
									textview41.setText("Minimum Stay");
									select_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("minimum stay").toString())).concat("    P"));
								}
								else {
									select_advance.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount advance").toString())).concat("    P"));
									select_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount deposit").toString())).concat("    P"));
									amount_total_beds.setText("₱".concat(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("total price").toString()))));
								}
								page1.setVisibility(View.GONE);
								page3.setVisibility(View.VISIBLE);
							}
							else {
								continue_layout.setVisibility(View.VISIBLE);
								done_layout.setVisibility(View.GONE);
								goto_booking_layout.setVisibility(View.GONE);
								book_progress_layout.setVisibility(View.GONE);
								progress_note.setVisibility(View.GONE);
								page1.setVisibility(View.VISIBLE);
								page3.setVisibility(View.GONE);
							}
						}
					}
				}
				else {
					
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("getPost"))) {
					Glide.with(getApplicationContext()).load(Uri.parse(data_photo)).into(photo);
					dormitory_name.setText(data_dormitory_name);
					location.setText(data_location);
					if (_childValue.get("status").toString().equals("pending") || _childValue.get("status").toString().equals("process")) {
						schedule.setText(_childValue.get("date").toString());
						time.setText(_childValue.get("time").toString());
						beds_gender.setText(_childValue.get("bedroom_select").toString());
						select_payment.setText(_childValue.get("payment method").toString());
						select_note.setText(_childValue.get("note").toString());
						progress1.setBackgroundColor(0xFF176B87);
						progress2.setBackgroundColor(0xFFFFFFFF);
						progress3.setBackgroundColor(0xFFFFFFFF);
						book_progress_layout.setVisibility(View.VISIBLE);
						textview1.setVisibility(View.GONE);
						continue_layout.setVisibility(View.GONE);
						done_btn.setText("Done");
						goto_btn.setText("Go to My booking");
						done_layout.setVisibility(View.VISIBLE);
						goto_booking_layout.setVisibility(View.VISIBLE);
						progress_note.setText("Our team is working  to review and process your booking request. We understand the importance of your reservation and aim to provide a seamless experience.\nTo keep you informed about the progress of your booking request, please check your notifications regularly");
						progress_note.setVisibility(View.VISIBLE);
						if (_childValue.get("dormitory name").toString().equals("Transcient")) {
							textview40.setText("Rates per Night");
							select_advance.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("rates per night").toString())).concat("    P"));
							textview41.setText("Minimum Stay");
							select_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("minimum stay").toString())).concat("    P"));
						}
						else {
							select_advance.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount advance").toString())).concat("    P"));
							select_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount deposit").toString())).concat("    P"));
							amount_total_beds.setText("₱".concat(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount total price").toString()) * Double.parseDouble(_childValue.get("girls total bedroom").toString()))));
						}
						page1.setVisibility(View.GONE);
						page3.setVisibility(View.VISIBLE);
					}
					else {
						if (_childValue.get("status").toString().equals("active")) {
							schedule.setText(_childValue.get("date").toString());
							time.setText(_childValue.get("time").toString());
							beds_gender.setText(_childValue.get("bedroom_select").toString());
							select_payment.setText(_childValue.get("payment method").toString());
							select_note.setText(_childValue.get("note").toString());
							progress1.setBackgroundColor(0xFF176B87);
							progress2.setBackgroundColor(0xFF176B87);
							progress3.setBackgroundColor(0xFFFFFFFF);
							book_progress_layout.setVisibility(View.VISIBLE);
							continue_layout.setVisibility(View.GONE);
							done_btn.setText("Done");
							goto_btn.setText("Go to My booking");
							done_layout.setVisibility(View.VISIBLE);
							goto_booking_layout.setVisibility(View.VISIBLE);
							progress_note.setText("Your booking for Q & M Dormitory  on ".concat(chooseMonth.concat(chooseDay.concat(", ".concat(chooseYear.concat(" has been confirmed.\nTo secure your booking, we kindly request that payment has to be made. Completing this payment step is crucial to finalize your booking and ensure your spot at Q & M Dormitory."))))));
							progress_note.setVisibility(View.VISIBLE);
							if (_childValue.get("dormitory name").toString().equals("Transcient")) {
								textview40.setText("Rates per Night");
								select_advance.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("rates per night").toString())).concat("    P"));
								textview41.setText("Minimum Stay");
								select_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("minimum stay").toString())).concat("    P"));
							}
							else {
								select_advance.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount advance").toString())).concat("    P"));
								select_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount deposit").toString())).concat("    P"));
								amount_total_beds.setText("₱".concat(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount total price").toString()) * Double.parseDouble(_childValue.get("girls total bedroom").toString()))));
							}
							page1.setVisibility(View.GONE);
							page3.setVisibility(View.VISIBLE);
						}
						else {
							if (_childValue.get("status").toString().equals("completed")) {
								data_dorm_post = _childValue.get("dorm post").toString();
								schedule.setText(_childValue.get("date").toString());
								time.setText(_childValue.get("time").toString());
								beds_gender.setText(_childValue.get("bedroom_select").toString());
								select_payment.setText(_childValue.get("payment method").toString());
								select_note.setText(_childValue.get("note").toString());
								payment_status.setText(_childValue.get("payment status").toString());
								progress1.setBackgroundColor(0xFF176B87);
								progress2.setBackgroundColor(0xFF176B87);
								progress3.setBackgroundColor(0xFF176B87);
								book_progress_layout.setVisibility(View.VISIBLE);
								textview1.setVisibility(View.GONE);
								continue_layout.setVisibility(View.GONE);
								done_btn.setText("RATE");
								goto_btn.setText("Home");
								done_layout.setVisibility(View.VISIBLE);
								goto_booking_layout.setVisibility(View.VISIBLE);
								progress_note.setText("Congratulations! Your booking is now complete, and we appreciate your prompt action in finalizing the payment transaction.\nYour booking is confirmed, and we look forward to welcoming you. Should you have any questions or need further assistance, please don't hesitate to reach out to our customer support team. Thank you for choosing us, and we hope you have a wonderful experience!\"");
								progress_note.setVisibility(View.VISIBLE);
								if (_childValue.get("dormitory name").toString().equals("Transcient")) {
									textview40.setText("Rates per Night");
									select_advance.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("rates per night").toString())).concat("    P"));
									textview41.setText("Minimum Stay");
									select_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("minimum stay").toString())).concat("    P"));
								}
								else {
									select_advance.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount advance").toString())).concat("    P"));
									select_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount deposit").toString())).concat("    P"));
									amount_total_beds.setText("₱".concat(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount total price").toString()) * Double.parseDouble(_childValue.get("girls total bedroom").toString()))));
								}
								page1.setVisibility(View.GONE);
								page3.setVisibility(View.VISIBLE);
							}
							else {
								continue_layout.setVisibility(View.VISIBLE);
								done_layout.setVisibility(View.GONE);
								goto_booking_layout.setVisibility(View.GONE);
								book_progress_layout.setVisibility(View.GONE);
								progress_note.setVisibility(View.GONE);
								page1.setVisibility(View.VISIBLE);
								page3.setVisibility(View.GONE);
							}
						}
					}
				}
				else {
					
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
		my_booking.addChildEventListener(_my_booking_child_listener);
		
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
		
		_total_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("bookings")) {
					totalBooking = Double.parseDouble(_childValue.get("count").toString());
				}
				if (_childKey.equals("rooms available")) {
					totalAvailable = Double.parseDouble(_childValue.get("count").toString());
				}
				if (_childKey.equals("rooms occupied")) {
					totalOccupied = Double.parseDouble(_childValue.get("count").toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("bookings")) {
					totalBooking = Double.parseDouble(_childValue.get("count").toString());
				}
				if (_childKey.equals("rooms available")) {
					totalAvailable = Double.parseDouble(_childValue.get("count").toString());
				}
				if (_childKey.equals("rooms occupied")) {
					totalOccupied = Double.parseDouble(_childValue.get("count").toString());
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
		total.addChildEventListener(_total_child_listener);
		
		_network1_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				bedroomNum = bedroomRemove;
				for(int _repeat12 = 0; _repeat12 < (int)(1); _repeat12++) {
					bedroomNum--;
					
					_telegramLoaderDialog(false);
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				bedroomNum = bedroomRemove;
				for(int _repeat12 = 0; _repeat12 < (int)(1); _repeat12++) {
					bedroomNum--;
					
					_telegramLoaderDialog(false);
				}
			}
		};
		
		_postData_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("getPost"))) {
					if (_childValue.get("type of dormitory").toString().equals("Female Dormitory") || (_childValue.get("type of dormitory").toString().equals("Male Dormitory") || _childValue.get("type of dormitory").toString().equals("Gender-neutral Dormitory"))) {
						data.edit().putString("data rates bedroom", _childValue.get("rates bedroom".concat("")).toString()).commit();
						data.edit().putString("data rates bed", _childValue.get("rates bed".concat("")).toString()).commit();
						data.edit().putString("data rates floor", _childValue.get("rates floor".concat("")).toString()).commit();
						data.edit().putString("data rates price", _childValue.get("rates monthly price".concat("")).toString()).commit();
						data.edit().putString("data rates status", _childValue.get("rates status".concat("")).toString()).commit();
						if (String.valueOf((long)(totalBedCount)).equals("9")) {
							totalBedCount--;
							data.edit().putString("data rates bedroom9", _childValue.get("rates bedroom".concat("9")).toString()).commit();
							data.edit().putString("data rates bed9", _childValue.get("rates bed".concat("9")).toString()).commit();
							data.edit().putString("data rates floor9", _childValue.get("rates floor".concat("9")).toString()).commit();
							data.edit().putString("data rates price9", _childValue.get("rates monthly price".concat("9")).toString()).commit();
							data.edit().putString("data rates status9", _childValue.get("rates status".concat("9")).toString()).commit();
							postData.addChildEventListener(_postData_child_listener);
						}
						else {
							if (String.valueOf((long)(totalBedCount)).equals("8")) {
								totalBedCount--;
								data.edit().putString("data rates bedroom8", _childValue.get("rates bedroom".concat("8")).toString()).commit();
								data.edit().putString("data rates bed8", _childValue.get("rates bed".concat("8")).toString()).commit();
								data.edit().putString("data rates floor8", _childValue.get("rates floor".concat("8")).toString()).commit();
								data.edit().putString("data rates price8", _childValue.get("rates monthly price".concat("8")).toString()).commit();
								data.edit().putString("data rates status8", _childValue.get("rates status".concat("8")).toString()).commit();
								postData.addChildEventListener(_postData_child_listener);
							}
							else {
								if (String.valueOf((long)(totalBedCount)).equals("7")) {
									totalBedCount--;
									data.edit().putString("data rates bedroom7", _childValue.get("rates bedroom".concat("7")).toString()).commit();
									data.edit().putString("data rates bed7", _childValue.get("rates bed".concat("7")).toString()).commit();
									data.edit().putString("data rates floor7", _childValue.get("rates floor".concat("7")).toString()).commit();
									data.edit().putString("data rates price7", _childValue.get("rates monthly price".concat("7")).toString()).commit();
									data.edit().putString("data rates status7", _childValue.get("rates status".concat("7")).toString()).commit();
									postData.addChildEventListener(_postData_child_listener);
								}
								else {
									if (String.valueOf((long)(totalBedCount)).equals("6")) {
										totalBedCount--;
										data.edit().putString("data rates bedroom6", _childValue.get("rates bedroom".concat("6")).toString()).commit();
										data.edit().putString("data rates bed6", _childValue.get("rates bed".concat("6")).toString()).commit();
										data.edit().putString("data rates floor6", _childValue.get("rates floor".concat("6")).toString()).commit();
										data.edit().putString("data rates price6", _childValue.get("rates monthly price".concat("6")).toString()).commit();
										data.edit().putString("data rates status6", _childValue.get("rates status".concat("6")).toString()).commit();
										postData.addChildEventListener(_postData_child_listener);
									}
									else {
										if (String.valueOf((long)(totalBedCount)).equals("5")) {
											totalBedCount--;
											data.edit().putString("data rates bedroom5", _childValue.get("rates bedroom".concat("5")).toString()).commit();
											data.edit().putString("data rates bed5", _childValue.get("rates bed".concat("5")).toString()).commit();
											data.edit().putString("data rates floor5", _childValue.get("rates floor".concat("5")).toString()).commit();
											data.edit().putString("data rates price5", _childValue.get("rates monthly price".concat("5")).toString()).commit();
											data.edit().putString("data rates status5", _childValue.get("rates status".concat("5")).toString()).commit();
											postData.addChildEventListener(_postData_child_listener);
										}
										else {
											if (String.valueOf((long)(totalBedCount)).equals("4")) {
												totalBedCount--;
												data.edit().putString("data rates bedroom4", _childValue.get("rates bedroom".concat("4")).toString()).commit();
												data.edit().putString("data rates bed4", _childValue.get("rates bed".concat("4")).toString()).commit();
												data.edit().putString("data rates floor4", _childValue.get("rates floor".concat("4")).toString()).commit();
												data.edit().putString("data rates price4", _childValue.get("rates monthly price".concat("4")).toString()).commit();
												data.edit().putString("data rates status4", _childValue.get("rates status".concat("4")).toString()).commit();
												postData.addChildEventListener(_postData_child_listener);
											}
											else {
												if (String.valueOf((long)(totalBedCount)).equals("3")) {
													totalBedCount--;
													data.edit().putString("data rates bedroom3", _childValue.get("rates bedroom".concat("3")).toString()).commit();
													data.edit().putString("data rates bed3", _childValue.get("rates bed".concat("3")).toString()).commit();
													data.edit().putString("data rates floor3", _childValue.get("rates floor".concat("3")).toString()).commit();
													data.edit().putString("data rates price3", _childValue.get("rates monthly price".concat("3")).toString()).commit();
													data.edit().putString("data rates status3", _childValue.get("rates status".concat("3")).toString()).commit();
													postData.addChildEventListener(_postData_child_listener);
												}
												else {
													if (String.valueOf((long)(totalBedCount)).equals("2")) {
														totalBedCount--;
														data.edit().putString("data rates bedroom2", _childValue.get("rates bedroom".concat("2")).toString()).commit();
														data.edit().putString("data rates bed2", _childValue.get("rates bed".concat("2")).toString()).commit();
														data.edit().putString("data rates floor2", _childValue.get("rates floor".concat("2")).toString()).commit();
														data.edit().putString("data rates price2", _childValue.get("rates monthly price".concat("2")).toString()).commit();
														data.edit().putString("data rates status2", _childValue.get("rates status".concat("2")).toString()).commit();
														postData.addChildEventListener(_postData_child_listener);
													}
													else {
														if (String.valueOf((long)(totalBedCount)).equals("1")) {
															data.edit().putString("data rates bedroom1", _childValue.get("rates bedroom".concat("1")).toString()).commit();
															data.edit().putString("data rates bed1", _childValue.get("rates bed".concat("1")).toString()).commit();
															data.edit().putString("data rates floor1", _childValue.get("rates floor".concat("1")).toString()).commit();
															data.edit().putString("data rates price1", _childValue.get("rates monthly price".concat("1")).toString()).commit();
															data.edit().putString("data rates status1", _childValue.get("rates status".concat("1")).toString()).commit();
														}
													}
												}
											}
										}
									}
								}
							}
						}
						recyclerview1.setAdapter(new Recyclerview1Adapter(rates_listmap));
					}
					else {
						
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
		postData.addChildEventListener(_postData_child_listener);
		
		_coed_data_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("getPost"))) {
					if (_childValue.get("type of dormitory").toString().equals("Co-ed Dormitory")) {
						//GIRLS
						data.edit().putString("data rates bedroom", _childValue.get("rates bedroom").toString()).commit();
						data.edit().putString("data rates bed", _childValue.get("rates bed").toString()).commit();
						data.edit().putString("data rates floor", _childValue.get("rates floor").toString()).commit();
						data.edit().putString("data rates price", _childValue.get("rates monthly price").toString()).commit();
						data.edit().putString("data rates status", _childValue.get("rates status").toString()).commit();
						if (String.valueOf((long)(totalBedroomCount)).equals("3")) {
							totalBedroomCount--;
							data.edit().putString("data rates bedroom3", _childValue.get("rates bedroom3").toString()).commit();
							data.edit().putString("data rates bed3", _childValue.get("rates bed3").toString()).commit();
							data.edit().putString("data rates floor3", _childValue.get("rates floor3").toString()).commit();
							data.edit().putString("data rates price3", _childValue.get("rates monthly price3").toString()).commit();
							data.edit().putString("data rates status3", _childValue.get("rates status3").toString()).commit();
							coed_data.addChildEventListener(_coed_data_child_listener);
						}
						else {
							if (String.valueOf((long)(totalBedroomCount)).equals("2")) {
								totalBedroomCount--;
								data.edit().putString("data rates bedroom2", _childValue.get("rates bedroom2").toString()).commit();
								data.edit().putString("data rates bed2", _childValue.get("rates bed2").toString()).commit();
								data.edit().putString("data rates floor2", _childValue.get("rates floor2").toString()).commit();
								data.edit().putString("data rates price2", _childValue.get("rates monthly price2").toString()).commit();
								data.edit().putString("data rates status2", _childValue.get("rates status2").toString()).commit();
								coed_data.addChildEventListener(_coed_data_child_listener);
							}
							else {
								if (String.valueOf((long)(totalBedroomCount)).equals("1")) {
									totalBedroomCount--;
									data.edit().putString("data rates bedroom1", _childValue.get("rates bedroom1").toString()).commit();
									data.edit().putString("data rates bed1", _childValue.get("rates bed1").toString()).commit();
									data.edit().putString("data rates floor1", _childValue.get("rates floor1").toString()).commit();
									data.edit().putString("data rates price1", _childValue.get("rates monthly price1").toString()).commit();
									data.edit().putString("data rates status1", _childValue.get("rates status1").toString()).commit();
								}
								else {
									
								}
							}
						}
						recyclerview1.setAdapter(new Recyclerview1Adapter(rates_listmap));
						//BOYS
						data.edit().putString("boys data rates bedroom", _childValue.get("boys rates bedroom").toString()).commit();
						data.edit().putString("boys data rates bed", _childValue.get("boys rates bed").toString()).commit();
						data.edit().putString("boys data rates floor", _childValue.get("boys rates floor").toString()).commit();
						data.edit().putString("boys data rates price", _childValue.get("boys rates monthly price").toString()).commit();
						data.edit().putString("boys data rates status", _childValue.get("boys rates status").toString()).commit();
						if (String.valueOf((long)(totalBoysBedroomCount)).equals("3")) {
							totalBoysBedroomCount--;
							data.edit().putString("boys data rates bedroom3", _childValue.get("boys rates bedroom3").toString()).commit();
							data.edit().putString("boys data rates bed3", _childValue.get("boys rates bed3").toString()).commit();
							data.edit().putString("boys data rates floor3", _childValue.get("boys rates floor3").toString()).commit();
							data.edit().putString("boys data rates price3", _childValue.get("boys rates monthly price3").toString()).commit();
							data.edit().putString("boys data rates status3", _childValue.get("boys rates status3").toString()).commit();
							coed_data.addChildEventListener(_coed_data_child_listener);
						}
						else {
							if (String.valueOf((long)(totalBoysBedroomCount)).equals("2")) {
								totalBoysBedroomCount--;
								data.edit().putString("boys data rates bedroom2", _childValue.get("boys rates bedroom2").toString()).commit();
								data.edit().putString("boys data rates bed2", _childValue.get("boys rates bed2").toString()).commit();
								data.edit().putString("boys data rates floor2", _childValue.get("boys rates floor2").toString()).commit();
								data.edit().putString("boys data rates price2", _childValue.get("boys rates monthly price2").toString()).commit();
								data.edit().putString("boys data rates status2", _childValue.get("boys rates status2").toString()).commit();
								coed_data.addChildEventListener(_coed_data_child_listener);
							}
							else {
								if (String.valueOf((long)(totalBoysBedroomCount)).equals("1")) {
									totalBoysBedroomCount--;
									data.edit().putString("boys data rates bedroom1", _childValue.get("boys rates bedroom1").toString()).commit();
									data.edit().putString("boys data rates bed1", _childValue.get("boys rates bed1").toString()).commit();
									data.edit().putString("boys data rates floor1", _childValue.get("boys rates floor1").toString()).commit();
									data.edit().putString("boys data rates price1", _childValue.get("boys rates monthly price1").toString()).commit();
									data.edit().putString("boys data rates status1", _childValue.get("boys rates status1").toString()).commit();
								}
								else {
									
								}
							}
						}
						recyclerview3.setAdapter(new Recyclerview3Adapter(summary_rates_listmap));
					}
					else {
						
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
		coed_data.addChildEventListener(_coed_data_child_listener);
		
		_postBooking_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("getPost"))) {
					data.edit().putString("data booking rates bedroom", _childValue.get("booking bedroom").toString()).commit();
					data.edit().putString("data booking rates bed", _childValue.get("booking bed").toString()).commit();
					data.edit().putString("data booking rates floor", _childValue.get("booking floor").toString()).commit();
					data.edit().putString("data booking rates price", _childValue.get("booking price").toString()).commit();
					data.edit().putString("data booking rates status", _childValue.get("booking status").toString()).commit();
					if (String.valueOf((long)(quantity)).equals("9")) {
						quantity--;
						data.edit().putString("data booking rates bedroom9", _childValue.get("booking bedroom9").toString()).commit();
						data.edit().putString("data booking rates bed9", _childValue.get("booking bed9").toString()).commit();
						data.edit().putString("data booking rates floor9", _childValue.get("booking floor9").toString()).commit();
						data.edit().putString("data booking rates price9", _childValue.get("booking price9").toString()).commit();
						data.edit().putString("data booking rates status9", _childValue.get("booking status9").toString()).commit();
						postBooking.addChildEventListener(_postBooking_child_listener);
					}
					else {
						if (String.valueOf((long)(quantity)).equals("8")) {
							quantity--;
							data.edit().putString("data booking rates bedroom8", _childValue.get("booking bedroom8").toString()).commit();
							data.edit().putString("data booking rates bed8", _childValue.get("booking bed8").toString()).commit();
							data.edit().putString("data booking rates floor8", _childValue.get("booking floor8").toString()).commit();
							data.edit().putString("data booking rates price8", _childValue.get("booking price8").toString()).commit();
							data.edit().putString("data booking rates status8", _childValue.get("booking status8").toString()).commit();
							postBooking.addChildEventListener(_postBooking_child_listener);
						}
						else {
							if (String.valueOf((long)(quantity)).equals("7")) {
								quantity--;
								data.edit().putString("data booking rates bedroom7", _childValue.get("booking bedroom7").toString()).commit();
								data.edit().putString("data booking rates bed7", _childValue.get("booking bed7").toString()).commit();
								data.edit().putString("data booking rates floor7", _childValue.get("booking floor7").toString()).commit();
								data.edit().putString("data booking rates price7", _childValue.get("booking price7").toString()).commit();
								data.edit().putString("data booking rates status7", _childValue.get("booking status7").toString()).commit();
								postBooking.addChildEventListener(_postBooking_child_listener);
							}
							else {
								if (String.valueOf((long)(quantity)).equals("6")) {
									quantity--;
									data.edit().putString("data booking rates bedroom6", _childValue.get("booking bedroom6").toString()).commit();
									data.edit().putString("data booking rates bed6", _childValue.get("booking bed6").toString()).commit();
									data.edit().putString("data booking rates floor6", _childValue.get("booking floor6").toString()).commit();
									data.edit().putString("data booking rates price6", _childValue.get("booking price6").toString()).commit();
									data.edit().putString("data booking rates status6", _childValue.get("booking status6").toString()).commit();
									postBooking.addChildEventListener(_postBooking_child_listener);
								}
								else {
									if (String.valueOf((long)(quantity)).equals("5")) {
										quantity--;
										data.edit().putString("data booking rates bedroom5", _childValue.get("booking bedroom5").toString()).commit();
										data.edit().putString("data booking rates bed5", _childValue.get("booking bed5").toString()).commit();
										data.edit().putString("data booking rates floor5", _childValue.get("booking floor5").toString()).commit();
										data.edit().putString("data booking rates price5", _childValue.get("booking price5").toString()).commit();
										data.edit().putString("data booking rates status5", _childValue.get("booking status5").toString()).commit();
										postBooking.addChildEventListener(_postBooking_child_listener);
									}
									else {
										if (String.valueOf((long)(quantity)).equals("4")) {
											quantity--;
											data.edit().putString("data booking rates bedroom4", _childValue.get("booking bedroom4").toString()).commit();
											data.edit().putString("data booking rates bed4", _childValue.get("booking bed4").toString()).commit();
											data.edit().putString("data booking rates floor4", _childValue.get("booking floor4").toString()).commit();
											data.edit().putString("data booking rates price4", _childValue.get("booking price4").toString()).commit();
											data.edit().putString("data booking rates status4", _childValue.get("booking status4").toString()).commit();
											postBooking.addChildEventListener(_postBooking_child_listener);
										}
										else {
											if (String.valueOf((long)(quantity)).equals("3")) {
												quantity--;
												data.edit().putString("data booking rates bedroom3", _childValue.get("booking bedroom3").toString()).commit();
												data.edit().putString("data booking rates bed3", _childValue.get("booking bed3").toString()).commit();
												data.edit().putString("data booking rates floor3", _childValue.get("booking floor3").toString()).commit();
												data.edit().putString("data booking rates price3", _childValue.get("booking price3").toString()).commit();
												data.edit().putString("data booking rates status3", _childValue.get("booking status3").toString()).commit();
												postBooking.addChildEventListener(_postBooking_child_listener);
											}
											else {
												if (String.valueOf((long)(quantity)).equals("2")) {
													quantity--;
													data.edit().putString("data booking rates bedroom2", _childValue.get("booking bedroom2").toString()).commit();
													data.edit().putString("data booking rates bed2", _childValue.get("booking bed2").toString()).commit();
													data.edit().putString("data booking rates floor2", _childValue.get("booking floor2").toString()).commit();
													data.edit().putString("data booking rates price2", _childValue.get("booking price2").toString()).commit();
													data.edit().putString("data booking rates status2", _childValue.get("booking status2").toString()).commit();
													postBooking.addChildEventListener(_postBooking_child_listener);
												}
												else {
													if (String.valueOf((long)(quantity)).equals("1")) {
														data.edit().putString("data booking rates bedroom1", _childValue.get("booking bedroom1").toString()).commit();
														data.edit().putString("data booking rates bed1", _childValue.get("booking bed1").toString()).commit();
														data.edit().putString("data booking rates floor1", _childValue.get("booking floor1").toString()).commit();
														data.edit().putString("data booking rates price1", _childValue.get("booking price1").toString()).commit();
														data.edit().putString("data booking rates status1", _childValue.get("booking status1").toString()).commit();
													}
												}
											}
										}
									}
								}
							}
						}
					}
					recyclerview2.setAdapter(new Recyclerview2Adapter(final_listmap));
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
		postBooking.addChildEventListener(_postBooking_child_listener);
		
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
		_riffleEffect("#f5f5f5", back);
		time_paste.setEnabled(false);
		_ImageColor(back, "#176b87");
		_ImageColor(imageview1, "#176b87");
		_ImageColor(imageview2, "#176b87");
		_ImageColor(imageview3, "#176b87");
		_ImageColor(select_time_icon, "#176b87");
		_simpleRiffle(continue_btn);
		_simpleRiffle(done_btn);
		_simpleRiffle1(goto_btn);
		_removeScollBar(vscroll1);
		_removeScollBar(vscroll2);
		page2.setVisibility(View.GONE);
		page3.setVisibility(View.GONE);
		book_progress_layout.setVisibility(View.GONE);
		done_layout.setVisibility(View.GONE);
		goto_booking_layout.setVisibility(View.GONE);
		girls.setVisibility(View.GONE);
		boys.setVisibility(View.GONE);
		boys_layout.setVisibility(View.GONE);
		rates_layout.setVisibility(View.GONE);
		advance_deposit_layout.setVisibility(View.GONE);
		linear56.setVisibility(View.GONE);
		linear57.setVisibility(View.GONE);
		progress_note.setVisibility(View.GONE);
		recyclerview1.setVisibility(View.GONE);
		recyclerview2.setVisibility(View.GONE);
		recyclerview3.setVisibility(View.GONE);
		recyclerview4.setVisibility(View.GONE);
		girls_bedroom_option.setEnabled(false);
		girls_bed_option.setEnabled(false);
		girls_floor_option.setEnabled(false);
		boys_bedroom_option.setEnabled(false);
		boys_bed_option.setEnabled(false);
		boys_floor_option.setEnabled(false);
		girls_bedroom_option.setVisibility(View.GONE);
		girls_bed_option.setVisibility(View.GONE);
		girls_floor_option.setVisibility(View.GONE);
		boys_bedroom_option.setVisibility(View.GONE);
		boys_bed_option.setVisibility(View.GONE);
		boys_floor_option.setVisibility(View.GONE);
		beds_gender.setVisibility(View.GONE);
		cal = Calendar.getInstance();
		dateToday = new SimpleDateFormat("MMM dd").format(cal.getTime());
		chooseDay = "";
		page = "1";
		getPost = post.push().getKey();
		data_advance = "0";
		data_deposit = "0";
		bedroomNum = 0;
		summary_bedroomNum = 0;
		finalCount = 0;
		totalPrice = 0;
		totalBedroom = 0;
		totalBeds = 0;
		totalFloor = 0;
		users.addChildEventListener(_users_child_listener);
		recyclerview1.setLayoutManager(new LinearLayoutManager(this));
		recyclerview3.setLayoutManager(new LinearLayoutManager(this));
		recyclerview2.setLayoutManager(new LinearLayoutManager(this));
		recyclerview4.setLayoutManager(new LinearLayoutManager(this));
		if (getIntent().getStringExtra("book").equals("")) {
			
		}
		else {
			if (getIntent().getStringExtra("book").equals("true")) {
				_telegramLoaderDialog(true);
				net.startRequestNetwork(RequestNetworkController.GET, "https://dorm-finder-df3f2-default-rtdb.firebaseio.com/", "Error", _net_request_listener);
			}
		}
	}
	
	@Override
	public void onBackPressed() {
		if (page.equals("4")) {
			
		}
		else {
			if (page.equals("3")) {
				page = "2";
				page1.setVisibility(View.GONE);
				page2.setVisibility(View.VISIBLE);
				page3.setVisibility(View.GONE);
			}
			else {
				if (page.equals("2")) {
					page = "1";
					page1.setVisibility(View.VISIBLE);
					page2.setVisibility(View.GONE);
					page3.setVisibility(View.GONE);
				}
				else {
					if (page.equals("1")) {
						finish();
					}
				}
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
	
	
	public void _simpleRiffle(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#176b87")), null);
		
		_view.setBackground(GA8PO9);
	}
	
	
	public void _riffleEffect(final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)}); android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null); _view.setBackground(ripdr);
	}
	
	
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	
	public void _months(final double _month) {
		if (String.valueOf((long)(_month)).equals("1")) {
			chooseMonth = "Jan";
		}
		else {
			if (String.valueOf((long)(_month)).equals("2")) {
				chooseMonth = "Feb";
			}
			else {
				if (String.valueOf((long)(_month)).equals("3")) {
					chooseMonth = "Mar";
				}
				else {
					if (String.valueOf((long)(_month)).equals("4")) {
						chooseMonth = "Apr";
					}
					else {
						if (String.valueOf((long)(_month)).equals("5")) {
							chooseMonth = "Apr";
						}
						else {
							if (String.valueOf((long)(_month)).equals("5")) {
								chooseMonth = "May";
							}
							else {
								if (String.valueOf((long)(_month)).equals("6")) {
									chooseMonth = "Jun";
								}
								else {
									if (String.valueOf((long)(_month)).equals("7")) {
										chooseMonth = "Jul";
									}
									else {
										if (String.valueOf((long)(_month)).equals("8")) {
											chooseMonth = "Aug";
										}
										else {
											if (String.valueOf((long)(_month)).equals("9")) {
												chooseMonth = "Sep";
											}
											else {
												if (String.valueOf((long)(_month)).equals("10")) {
													chooseMonth = "Oct";
												}
												else {
													if (String.valueOf((long)(_month)).equals("11")) {
														chooseMonth = "Nov";
													}
													else {
														if (String.valueOf((long)(_month)).equals("12")) {
															chooseMonth = "Dec";
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
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
	
	
	public void _fade_translate() {
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	}
	
	
	public void _extra() {
	}
	
	public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
		
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			
			final Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);
			
			return new TimePickerDialog(getActivity(), this, hour, minute, android.text.format.DateFormat.is24HourFormat(getActivity()));
		}
		
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			TextView textview101 = getActivity().findViewById(R.id.time_paste);
			textview101.setText(hourOfDay + ":" + minute);
		}
		
	}
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _simpleRiffle1(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
		_view.setBackground(GA8PO9);
	}
	
	
	public void _booking_count() {
		map = new HashMap<>();
		map.put("count", String.valueOf((long)(totalBooking + 1)));
		total.child("bookings").updateChildren(map);
	}
	
	
	public void _Hide_Keyboard(final TextView _edittext) {
		_edittext.setEnabled(false);
		_edittext.setEnabled(true);
	}
	
	
	public void _more_booking() {
		if (data.getString("booking", "").equals("")) {
			map.put("booking bedroom", data.getString("booking bedroom", ""));
			map.put("booking bed", data.getString("booking bed", ""));
			map.put("booking floor", data.getString("booking floor", ""));
			map.put("booking price", data.getString("booking price", ""));
			map.put("booking status", data.getString("booking status", ""));
		}
		if (data.getString("booking1", "").equals("1")) {
			map.put("booking bedroom1", data.getString("booking bedroom1", ""));
			map.put("booking bed1", data.getString("booking bed1", ""));
			map.put("booking floor1", data.getString("booking floor1", ""));
			map.put("booking price1", data.getString("booking price1", ""));
			map.put("booking status1", data.getString("booking status1", ""));
		}
		if (data.getString("booking2", "").equals("2")) {
			map.put("booking bedroom2", data.getString("booking bedroom2", ""));
			map.put("booking bed2", data.getString("booking bed2", ""));
			map.put("booking floor2", data.getString("booking floor2", ""));
			map.put("booking price2", data.getString("booking price2", ""));
			map.put("booking status2", data.getString("booking status2", ""));
		}
		if (data.getString("booking3", "").equals("3")) {
			map.put("booking bedroom3", data.getString("booking bedroom3", ""));
			map.put("booking bed3", data.getString("booking bed3", ""));
			map.put("booking floor3", data.getString("booking floor3", ""));
			map.put("booking price3", data.getString("booking price3", ""));
			map.put("booking status3", data.getString("booking status3", ""));
		}
		if (data.getString("booking4", "").equals("4")) {
			map.put("booking bedroom4", data.getString("booking bedroom4", ""));
			map.put("booking bed4", data.getString("booking bed4", ""));
			map.put("booking floor4", data.getString("booking floor4", ""));
			map.put("booking price4", data.getString("booking price4", ""));
			map.put("booking status4", data.getString("booking status4", ""));
		}
		if (data.getString("booking5", "").equals("5")) {
			map.put("booking bedroom5", data.getString("booking bedroom5", ""));
			map.put("booking bed5", data.getString("booking bed5", ""));
			map.put("booking floor5", data.getString("booking floor5", ""));
			map.put("booking price5", data.getString("booking price5", ""));
			map.put("booking status5", data.getString("booking status5", ""));
		}
		if (data.getString("booking6", "").equals("6")) {
			map.put("booking bedroom6", data.getString("booking bedroom6", ""));
			map.put("booking bed6", data.getString("booking bed6", ""));
			map.put("booking floor6", data.getString("booking floor6", ""));
			map.put("booking price6", data.getString("booking price6", ""));
			map.put("booking status6", data.getString("booking status6", ""));
		}
		if (data.getString("booking7", "").equals("7")) {
			map.put("booking bedroom7", data.getString("booking bedroom7", ""));
			map.put("booking bed7", data.getString("booking bed7", ""));
			map.put("booking floor7", data.getString("booking floor7", ""));
			map.put("booking price7", data.getString("booking price7", ""));
			map.put("booking status7", data.getString("booking status7", ""));
		}
		if (data.getString("booking8", "").equals("8")) {
			map.put("booking bedroom8", data.getString("booking bedroom8", ""));
			map.put("booking bed8", data.getString("booking bed8", ""));
			map.put("booking floor8", data.getString("booking floor8", ""));
			map.put("booking price8", data.getString("booking price8", ""));
			map.put("booking status8", data.getString("booking status8", ""));
		}
		if (data.getString("booking9", "").equals("9")) {
			map.put("booking bedroom9", data.getString("booking bedroom9", ""));
			map.put("booking bed9", data.getString("booking bed9", ""));
			map.put("booking floor9", data.getString("booking floor9", ""));
			map.put("booking price9", data.getString("booking price9", ""));
			map.put("booking status9", data.getString("booking status9", ""));
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
			View _v = _inflater.inflate(R.layout.rates_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear15 = _view.findViewById(R.id.linear15);
			final CheckBox checkbox1 = _view.findViewById(R.id.checkbox1);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear10 = _view.findViewById(R.id.linear10);
			final EditText bedroom = _view.findViewById(R.id.bedroom);
			final ImageView bedroom_option = _view.findViewById(R.id.bedroom_option);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final LinearLayout linear11 = _view.findViewById(R.id.linear11);
			final EditText bed = _view.findViewById(R.id.bed);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final androidx.cardview.widget.CardView cardview3 = _view.findViewById(R.id.cardview3);
			final LinearLayout linear12 = _view.findViewById(R.id.linear12);
			final EditText floor = _view.findViewById(R.id.floor);
			final ImageView floor_option = _view.findViewById(R.id.floor_option);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final LinearLayout linear9 = _view.findViewById(R.id.linear9);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final androidx.cardview.widget.CardView cardview4 = _view.findViewById(R.id.cardview4);
			final LinearLayout linear13 = _view.findViewById(R.id.linear13);
			final EditText monthly_price = _view.findViewById(R.id.monthly_price);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final androidx.cardview.widget.CardView cardview5 = _view.findViewById(R.id.cardview5);
			final LinearLayout linear14 = _view.findViewById(R.id.linear14);
			final EditText status = _view.findViewById(R.id.status);
			final ImageView status_option = _view.findViewById(R.id.status_option);
			final ImageView remove = _view.findViewById(R.id.remove);
			
			bedroom.setEnabled(false);
			bed.setEnabled(false);
			floor.setEnabled(false);
			status.setEnabled(false);
			monthly_price.setEnabled(false);
			bedroom_option.setVisibility(View.GONE);
			floor_option.setVisibility(View.GONE);
			status_option.setVisibility(View.GONE);
			remove.setVisibility(View.GONE);
			monthly_price.setTextSize((int)12);
			monthly_price.setTextColor(0xFF607D8B);
			monthly_price.setBackgroundColor(0xFFE0E0E0);
			monthly_price.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			status.setTextSize((int)12);
			status.setTextColor(0xFF607D8B);
			status.setBackgroundColor(0xFFE0E0E0);
			status.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			monthly_price.setText(data_monthly_price);
			status.setText(data_status);
			data.edit().putString("boys rate_data".concat(_data.get((int)_position).get("summary bedroom num").toString()), _data.get((int)_position).get("summary bedroom num").toString()).commit();
			boysBedroomRemove = Double.parseDouble(_data.get((int)_position).get("summary bedroom num").toString());
			checkbox1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (checkbox1.isChecked()) {
						bedroom_option.setEnabled(true);
						bed.setEnabled(true);
						floor_option.setEnabled(true);
						finalCount = finalCount;
						for(int _repeat334 = 0; _repeat334 < (int)(1); _repeat334++) {
							finalCount++;
							map = new HashMap<>();
							map.put("final count", String.valueOf((long)(finalCount)));
							booking_lstmap.add(map);
						}
						data.edit().putString("bedroom".concat(_data.get((int)_position).get("summary bedroom num").toString()), bedroom.getText().toString()).commit();
						data.edit().putString("bed".concat(_data.get((int)_position).get("summary bedroom num").toString()), bed.getText().toString()).commit();
						data.edit().putString("floor".concat(_data.get((int)_position).get("summary bedroom num").toString()), floor.getText().toString()).commit();
						data.edit().putString("price".concat(_data.get((int)_position).get("summary bedroom num").toString()), monthly_price.getText().toString()).commit();
						data.edit().putString("beds gender", "Boy(s)").commit();
						data.edit().putString("rates price".concat(_data.get((int)_position).get("summary bedroom num").toString()), monthly_price.getText().toString()).commit();
						data.edit().putString("rates status".concat(_data.get((int)_position).get("summary bedroom num").toString()), status.getText().toString()).commit();
						checkbox1.setChecked(true);
						totalPrice = totalPrice + Double.parseDouble(monthly_price.getText().toString());
						totalBedroom = totalBedroom + Double.parseDouble(bedroom.getText().toString());
						totalBeds = totalBeds + Double.parseDouble(bed.getText().toString());
						totalFloor = totalFloor + Double.parseDouble(floor.getText().toString());
					}
					else {
						bedroom_option.setEnabled(false);
						bed.setEnabled(false);
						floor_option.setEnabled(false);
						finalCount--;
						checkbox1.setChecked(false);
						totalPrice = totalPrice - Double.parseDouble(monthly_price.getText().toString());
						totalBedroom = totalBedroom - Double.parseDouble(bedroom.getText().toString());
						totalBeds = totalBeds - Double.parseDouble(bed.getText().toString());
						totalFloor = totalFloor - Double.parseDouble(floor.getText().toString());
					}
				}
			});
			if (data_type_of_dormitory.contains("Co-ed Dormitory")) {
				if (_data.get((int)_position).get("summary bedroom num").toString().equals("1")) {
					bedroom.setText(data.getString("boys data rates bedroom1", ""));
					bed.setText(data.getString("boys data rates bed1", ""));
					floor.setText(data.getString("boys data rates floor1", ""));
					monthly_price.setText(data.getString("boys data rates price1", ""));
					status.setText(data.getString("boys data rates status1", ""));
				}
				if (_data.get((int)_position).get("summary bedroom num").toString().equals("2")) {
					bedroom.setText(data.getString("boys data rates bedroom2", ""));
					bed.setText(data.getString("boys data rates bed2", ""));
					floor.setText(data.getString("boys data rates floor2", ""));
					monthly_price.setText(data.getString("boys data rates price2", ""));
					status.setText(data.getString("boys data rates status2", ""));
				}
				if (_data.get((int)_position).get("summary bedroom num").toString().equals("3")) {
					bedroom.setText(data.getString("boys data rates bedroom3", ""));
					bed.setText(data.getString("boys data rates bed3", ""));
					floor.setText(data.getString("boys data rates floor3", ""));
					monthly_price.setText(data.getString("boys data rates price3", ""));
					status.setText(data.getString("boys data rates status3", ""));
				}
			}
			else {
				
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
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.rates_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear15 = _view.findViewById(R.id.linear15);
			final CheckBox checkbox1 = _view.findViewById(R.id.checkbox1);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear10 = _view.findViewById(R.id.linear10);
			final EditText bedroom = _view.findViewById(R.id.bedroom);
			final ImageView bedroom_option = _view.findViewById(R.id.bedroom_option);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final LinearLayout linear11 = _view.findViewById(R.id.linear11);
			final EditText bed = _view.findViewById(R.id.bed);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final androidx.cardview.widget.CardView cardview3 = _view.findViewById(R.id.cardview3);
			final LinearLayout linear12 = _view.findViewById(R.id.linear12);
			final EditText floor = _view.findViewById(R.id.floor);
			final ImageView floor_option = _view.findViewById(R.id.floor_option);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final LinearLayout linear9 = _view.findViewById(R.id.linear9);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final androidx.cardview.widget.CardView cardview4 = _view.findViewById(R.id.cardview4);
			final LinearLayout linear13 = _view.findViewById(R.id.linear13);
			final EditText monthly_price = _view.findViewById(R.id.monthly_price);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final androidx.cardview.widget.CardView cardview5 = _view.findViewById(R.id.cardview5);
			final LinearLayout linear14 = _view.findViewById(R.id.linear14);
			final EditText status = _view.findViewById(R.id.status);
			final ImageView status_option = _view.findViewById(R.id.status_option);
			final ImageView remove = _view.findViewById(R.id.remove);
			
			bedroom.setEnabled(false);
			bed.setEnabled(false);
			floor.setEnabled(false);
			status.setEnabled(false);
			monthly_price.setEnabled(false);
			bedroom_option.setVisibility(View.GONE);
			floor_option.setVisibility(View.GONE);
			status_option.setVisibility(View.GONE);
			remove.setVisibility(View.GONE);
			monthly_price.setTextSize((int)12);
			monthly_price.setTextColor(0xFF607D8B);
			monthly_price.setBackgroundColor(0xFFE0E0E0);
			monthly_price.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			status.setTextSize((int)12);
			status.setTextColor(0xFF607D8B);
			status.setBackgroundColor(0xFFE0E0E0);
			status.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			monthly_price.setText(data_monthly_price);
			status.setText(data_status);
			data.edit().putString("rate_data".concat(_data.get((int)_position).get("bedroom num").toString()), _data.get((int)_position).get("bedroom num").toString()).commit();
			bedroomRemove = Double.parseDouble(_data.get((int)_position).get("bedroom num").toString());
			checkbox1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (checkbox1.isChecked()) {
						bedroom_option.setEnabled(true);
						bed.setEnabled(true);
						floor_option.setEnabled(true);
						finalCount = finalCount;
						for(int _repeat539 = 0; _repeat539 < (int)(1); _repeat539++) {
							finalCount++;
							map = new HashMap<>();
							map.put("final count", String.valueOf((long)(finalCount)));
							booking_lstmap.add(map);
						}
						data.edit().putString("bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
						data.edit().putString("bed".concat(_data.get((int)_position).get("bedroom num").toString()), bed.getText().toString()).commit();
						data.edit().putString("floor".concat(_data.get((int)_position).get("bedroom num").toString()), floor.getText().toString()).commit();
						data.edit().putString("price".concat(_data.get((int)_position).get("bedroom num").toString()), monthly_price.getText().toString()).commit();
						data.edit().putString("beds gender", "Girl(s)").commit();
						data.edit().putString("rates price".concat(_data.get((int)_position).get("bedroom num").toString()), monthly_price.getText().toString()).commit();
						data.edit().putString("rates status".concat(_data.get((int)_position).get("bedroom num").toString()), status.getText().toString()).commit();
						checkbox1.setChecked(true);
						totalPrice = totalPrice + Double.parseDouble(monthly_price.getText().toString());
						totalBedroom = totalBedroom + Double.parseDouble(bedroom.getText().toString());
						totalBeds = totalBeds + Double.parseDouble(bed.getText().toString());
						totalFloor = totalFloor + Double.parseDouble(floor.getText().toString());
					}
					else {
						bedroom_option.setEnabled(false);
						bed.setEnabled(false);
						floor_option.setEnabled(false);
						finalCount--;
						checkbox1.setChecked(false);
						totalPrice = totalPrice - Double.parseDouble(monthly_price.getText().toString());
						totalBedroom = totalBedroom - Double.parseDouble(bedroom.getText().toString());
						totalBeds = totalBeds - Double.parseDouble(bed.getText().toString());
						totalFloor = totalFloor - Double.parseDouble(floor.getText().toString());
					}
				}
			});
			if (data_type_of_dormitory.contains("Female Dormitory") || (data_type_of_dormitory.contains("Male Dormitory") || data_type_of_dormitory.contains("Gender Neutral Dormitory"))) {
				if (_data.get((int)_position).get("bedroom num").toString().equals("1")) {
					bedroom.setText(data.getString("data rates bedroom1", ""));
					bed.setText(data.getString("data rates bed1", ""));
					floor.setText(data.getString("data rates floor1", ""));
					monthly_price.setText(data.getString("data rates price1", ""));
					status.setText(data_status);
				}
				if (_data.get((int)_position).get("bedroom num").toString().equals("2")) {
					bedroom.setText(data.getString("data rates bedroom2", ""));
					bed.setText(data.getString("data rates bed2", ""));
					floor.setText(data.getString("data rates floor2", ""));
					monthly_price.setText(data.getString("data rates price2", ""));
					status.setText(data_status);
				}
				if (_data.get((int)_position).get("bedroom num").toString().equals("3")) {
					bedroom.setText(data.getString("data rates bedroom3", ""));
					bed.setText(data.getString("data rates bed3", ""));
					floor.setText(data.getString("data rates floor3", ""));
					monthly_price.setText(data.getString("data rates price3", ""));
					status.setText(data_status);
				}
				if (_data.get((int)_position).get("bedroom num").toString().equals("4")) {
					bedroom.setText(data.getString("data rates bedroom4", ""));
					bed.setText(data.getString("data rates bed4", ""));
					floor.setText(data.getString("data rates floor4", ""));
					monthly_price.setText(data.getString("data rates price4", ""));
					status.setText(data_status);
				}
				if (_data.get((int)_position).get("bedroom num").toString().equals("5")) {
					bedroom.setText(data.getString("data rates bedroom5", ""));
					bed.setText(data.getString("data rates bed5", ""));
					floor.setText(data.getString("data rates floor5", ""));
					monthly_price.setText(data.getString("data rates price5", ""));
					status.setText(data_status);
				}
				if (_data.get((int)_position).get("bedroom num").toString().equals("6")) {
					bedroom.setText(data.getString("data rates bedroom6", ""));
					bed.setText(data.getString("data rates bed6", ""));
					floor.setText(data.getString("data rates floor6", ""));
					monthly_price.setText(data.getString("data rates price6", ""));
					status.setText(data_status);
				}
				if (_data.get((int)_position).get("bedroom num").toString().equals("7")) {
					bedroom.setText(data.getString("data rates bedroom7", ""));
					bed.setText(data.getString("data rates bed7", ""));
					floor.setText(data.getString("data rates floor7", ""));
					monthly_price.setText(data.getString("data rates price7", ""));
					status.setText(data_status);
				}
				if (_data.get((int)_position).get("bedroom num").toString().equals("8")) {
					bedroom.setText(data.getString("data rates bedroom8", ""));
					bed.setText(data.getString("data rates bed8", ""));
					floor.setText(data.getString("data rates floor8", ""));
					monthly_price.setText(data.getString("data rates price8", ""));
					status.setText(data_status);
				}
				if (_data.get((int)_position).get("bedroom num").toString().equals("9")) {
					bedroom.setText(data.getString("data rates bedroom9", ""));
					bed.setText(data.getString("data rates bed9", ""));
					floor.setText(data.getString("data rates floor9", ""));
					monthly_price.setText(data.getString("data rates price9", ""));
					status.setText(data_status);
				}
			}
			else {
				if (data_type_of_dormitory.contains("Co-ed Dormitory")) {
					if (_data.get((int)_position).get("bedroom num").toString().equals("1")) {
						bedroom.setText(data.getString("data rates bedroom1", ""));
						bed.setText(data.getString("data rates bed1", ""));
						floor.setText(data.getString("data rates floor1", ""));
						monthly_price.setText(data.getString("data rates price1", ""));
						status.setText(data_status);
					}
					if (_data.get((int)_position).get("bedroom num").toString().equals("2")) {
						bedroom.setText(data.getString("data rates bedroom2", ""));
						bed.setText(data.getString("data rates bed2", ""));
						floor.setText(data.getString("data rates floor2", ""));
						monthly_price.setText(data.getString("data rates price2", ""));
						status.setText(data_status);
					}
					if (_data.get((int)_position).get("bedroom num").toString().equals("3")) {
						bedroom.setText(data.getString("data rates bedroom3", ""));
						bed.setText(data.getString("data rates bed3", ""));
						floor.setText(data.getString("data rates floor3", ""));
						monthly_price.setText(data.getString("data rates price3", ""));
						status.setText(data_status);
					}
				}
				else {
					
				}
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
	
	public class Recyclerview4Adapter extends RecyclerView.Adapter<Recyclerview4Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview4Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.booking_rates, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView bedroom = _view.findViewById(R.id.bedroom);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final TextView bed = _view.findViewById(R.id.bed);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final TextView floor = _view.findViewById(R.id.floor);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final TextView price = _view.findViewById(R.id.price);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final TextView status = _view.findViewById(R.id.status);
			
			data.edit().putString("booking".concat(_data.get((int)_position).get("final count").toString()), _data.get((int)_position).get("final count").toString()).commit();
			data.edit().putString("booking bedroom".concat(_data.get((int)_position).get("final count").toString()), data.getString("data rates bedroom".concat(_data.get((int)_position).get("final count").toString()), "")).commit();
			data.edit().putString("booking bed".concat(_data.get((int)_position).get("final count").toString()), data.getString("data rates bed".concat(_data.get((int)_position).get("final count").toString()), "")).commit();
			data.edit().putString("booking floor".concat(_data.get((int)_position).get("final count").toString()), data.getString("data rates floor".concat(_data.get((int)_position).get("final count").toString()), "")).commit();
			data.edit().putString("booking price".concat(_data.get((int)_position).get("final count").toString()), data.getString("data rates price".concat(_data.get((int)_position).get("final count").toString()), "")).commit();
			data.edit().putString("booking status".concat(_data.get((int)_position).get("final count").toString()), data_status).commit();
			if (_data.get((int)_position).get("final count").toString().equals("")) {
				bedroom.setText(booking_bedroom);
				bed.setText(booking_bed);
				floor.setText(booking_floor);
				price.setText(booking_price);
				status.setText(data_status);
			}
			else {
				bedroom.setText(data.getString("data rates bedroom".concat(_data.get((int)_position).get("final count").toString()), ""));
				bed.setText(data.getString("data rates bed".concat(_data.get((int)_position).get("final count").toString()), ""));
				floor.setText(data.getString("data rates floor".concat(_data.get((int)_position).get("final count").toString()), ""));
				price.setText(data.getString("data rates price".concat(_data.get((int)_position).get("final count").toString()), ""));
				status.setText(data_status);
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
			View _v = _inflater.inflate(R.layout.booking_rates, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView bedroom = _view.findViewById(R.id.bedroom);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final TextView bed = _view.findViewById(R.id.bed);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final TextView floor = _view.findViewById(R.id.floor);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final TextView price = _view.findViewById(R.id.price);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final TextView status = _view.findViewById(R.id.status);
			
			bedroom.setText(data.getString("data booking rates bedroom", ""));
			bed.setText(data.getString("data booking rates bed", ""));
			floor.setText(data.getString("data booking rates floor", ""));
			price.setText(data.getString("data booking rates price", ""));
			status.setText(data.getString("data booking rates status", ""));
			if (_data.get((int)_position).get("final count").toString().equals("1")) {
				bedroom.setText(data.getString("data booking rates bedroom1", ""));
				bed.setText(data.getString("data booking rates bed1", ""));
				floor.setText(data.getString("data booking rates floor1", ""));
				price.setText(data.getString("data booking rates price1", ""));
				status.setText(data.getString("data booking rates status1", ""));
			}
			if (_data.get((int)_position).get("final count").toString().equals("2")) {
				bedroom.setText(data.getString("data booking rates bedroom2", ""));
				bed.setText(data.getString("data booking rates bed2", ""));
				floor.setText(data.getString("data booking rates floor2", ""));
				price.setText(data.getString("data booking rates price2", ""));
				status.setText(data.getString("data booking rates status2", ""));
			}
			if (_data.get((int)_position).get("final count").toString().equals("3")) {
				bedroom.setText(data.getString("data booking rates bedroom3", ""));
				bed.setText(data.getString("data booking rates bed3", ""));
				floor.setText(data.getString("data booking rates floor3", ""));
				price.setText(data.getString("data booking rates price3", ""));
				status.setText(data.getString("data booking rates status3", ""));
			}
			if (_data.get((int)_position).get("final count").toString().equals("4")) {
				bedroom.setText(data.getString("data booking rates bedroom4", ""));
				bed.setText(data.getString("data booking rates bed4", ""));
				floor.setText(data.getString("data booking rates floor4", ""));
				price.setText(data.getString("data booking rates price4", ""));
				status.setText(data.getString("data booking rates status4", ""));
			}
			if (_data.get((int)_position).get("final count").toString().equals("5")) {
				bedroom.setText(data.getString("data booking rates bedroom5", ""));
				bed.setText(data.getString("data booking rates bed5", ""));
				floor.setText(data.getString("data booking rates floor5", ""));
				price.setText(data.getString("data booking rates price5", ""));
				status.setText(data.getString("data booking rates status5", ""));
			}
			if (_data.get((int)_position).get("final count").toString().equals("6")) {
				bedroom.setText(data.getString("data booking rates bedroom6", ""));
				bed.setText(data.getString("data booking rates bed6", ""));
				floor.setText(data.getString("data booking rates floor6", ""));
				price.setText(data.getString("data booking rates price6", ""));
				status.setText(data.getString("data booking rates status6", ""));
			}
			if (_data.get((int)_position).get("final count").toString().equals("7")) {
				bedroom.setText(data.getString("data booking rates bedroom7", ""));
				bed.setText(data.getString("data booking rates bed7", ""));
				floor.setText(data.getString("data booking rates floor7", ""));
				price.setText(data.getString("data booking rates price7", ""));
				status.setText(data.getString("data booking rates status7", ""));
			}
			if (_data.get((int)_position).get("final count").toString().equals("8")) {
				bedroom.setText(data.getString("data booking rates bedroom8", ""));
				bed.setText(data.getString("data booking rates bed8", ""));
				floor.setText(data.getString("data booking rates floor8", ""));
				price.setText(data.getString("data booking rates price8", ""));
				status.setText(data.getString("data booking rates status8", ""));
			}
			if (_data.get((int)_position).get("final count").toString().equals("9")) {
				bedroom.setText(data.getString("data booking rates bedroom9", ""));
				bed.setText(data.getString("data booking rates bed9", ""));
				floor.setText(data.getString("data booking rates floor9", ""));
				price.setText(data.getString("data booking rates price9", ""));
				status.setText(data.getString("data booking rates status9", ""));
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