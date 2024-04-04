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

public class UserDetailsActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private boolean isVisible = false;
	private double totalBooking = 0;
	private double totalAvailable = 0;
	private double totalOccupied = 0;
	private String getPost = "";
	private String str = "";
	private String getPost1 = "";
	private String str1 = "";
	private double quantity = 0;
	private double rates_bedroom_num = 0;
	
	private ArrayList<HashMap<String, Object>> booking_listmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout bottom_layout;
	private ImageView back;
	private ScrollView vscroll1;
	private LinearLayout linear5;
	private TextView textview1;
	private TextView textview3;
	private CardView cardview2;
	private TextView textview4;
	private CardView cardview3;
	private TextView textview5;
	private CardView cardview4;
	private TextView textview6;
	private CardView cardview5;
	private TextView textview7;
	private CardView cardview6;
	private TextView textview8;
	private CardView cardview7;
	private TextView textview9;
	private CardView cardview8;
	private TextView textview10;
	private CardView cardview9;
	private CardView cardview11;
	private TextView textview22;
	private CardView cardview12;
	private TextView textview11;
	private CardView cardview13;
	private LinearLayout payment_layout;
	private CardView cardview14;
	private LinearLayout accept_reject_layout;
	private CardView reason_layout;
	private EditText first_name;
	private EditText middle_name;
	private EditText last_name;
	private LinearLayout linear6;
	private TextView sex;
	private ImageView sex_option_icon;
	private LinearLayout linear7;
	private TextView birthday;
	private ImageView birthday_icon;
	private LinearLayout linear8;
	private TextView email;
	private ImageView email_icon;
	private LinearLayout linear9;
	private ImageView contact_icon;
	private TextView country_code;
	private EditText contact;
	private LinearLayout linear10;
	private CardView cardview10;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private ImageView dorm_photo;
	private TextView dorm_title;
	private TextView dorm_location;
	private TextView dorm_monthly_price;
	private TextView textview19;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private TextView textview20;
	private TextView date;
	private TextView textview21;
	private TextView time;
	private LinearLayout linear19;
	private TextView bedroom_gender;
	private RecyclerView recyclerview1;
	private LinearLayout linear36;
	private LinearLayout linear24;
	private LinearLayout linear25;
	private TextView textview43;
	private TextView amount_total_bed;
	private TextView textview26;
	private TextView amount_advance;
	private TextView textview27;
	private TextView amount_deposit;
	private LinearLayout linear26;
	private TextView textview28;
	private TextView payment_method;
	private LinearLayout linear30;
	private LinearLayout linear31;
	private TextView textview39;
	private CardView cardview24;
	private LinearLayout linear27;
	private LinearLayout linear28;
	private TextView textview29;
	private TextView textview30;
	private CardView cardview18;
	private TextView textview31;
	private TextView textview32;
	private CardView cardview19;
	private TextView textview33;
	private CardView cardview20;
	private TextView payment_method1;
	private TextView amount_rent;
	private TextView amount_deposit1;
	private TextView textview34;
	private TextView textview35;
	private CardView cardview21;
	private TextView textview36;
	private TextView textview37;
	private CardView cardview22;
	private TextView textview38;
	private CardView cardview23;
	private LinearLayout linear32;
	private TextView date_of_payment;
	private ImageView date_payment_option;
	private TextView amount_advance1;
	private TextView amount_total;
	private LinearLayout linear29;
	private TextView payment_text;
	private ImageView payment_option;
	private LinearLayout linear14;
	private TextView textview14;
	private TextView note;
	private CardView cardview16;
	private CardView cardview17;
	private TextView accept_btn;
	private TextView reject_btn;
	private LinearLayout linear15;
	private TextView textview15;
	private EditText reason;
	private CardView confirm_layout;
	private TextView confirm_btn;
	
	private DatabaseReference booking = _firebase.getReference("booking");
	private ChildEventListener _booking_child_listener;
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private AlertDialog.Builder dialog;
	private SharedPreferences data;
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private Intent intent = new Intent();
	private DatabaseReference total = _firebase.getReference("total");
	private ChildEventListener _total_child_listener;
	private DatabaseReference notification = _firebase.getReference("notification");
	private ChildEventListener _notification_child_listener;
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
	private DatabaseReference my_booking = _firebase.getReference("booking");
	private ChildEventListener _my_booking_child_listener;
	private DatabaseReference your_booking = _firebase.getReference("booking");
	private ChildEventListener _your_booking_child_listener;
	private DatabaseReference postBooking = _firebase.getReference("booking");
	private ChildEventListener _postBooking_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.user_details);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		bottom_layout = findViewById(R.id.bottom_layout);
		back = findViewById(R.id.back);
		vscroll1 = findViewById(R.id.vscroll1);
		linear5 = findViewById(R.id.linear5);
		textview1 = findViewById(R.id.textview1);
		textview3 = findViewById(R.id.textview3);
		cardview2 = findViewById(R.id.cardview2);
		textview4 = findViewById(R.id.textview4);
		cardview3 = findViewById(R.id.cardview3);
		textview5 = findViewById(R.id.textview5);
		cardview4 = findViewById(R.id.cardview4);
		textview6 = findViewById(R.id.textview6);
		cardview5 = findViewById(R.id.cardview5);
		textview7 = findViewById(R.id.textview7);
		cardview6 = findViewById(R.id.cardview6);
		textview8 = findViewById(R.id.textview8);
		cardview7 = findViewById(R.id.cardview7);
		textview9 = findViewById(R.id.textview9);
		cardview8 = findViewById(R.id.cardview8);
		textview10 = findViewById(R.id.textview10);
		cardview9 = findViewById(R.id.cardview9);
		cardview11 = findViewById(R.id.cardview11);
		textview22 = findViewById(R.id.textview22);
		cardview12 = findViewById(R.id.cardview12);
		textview11 = findViewById(R.id.textview11);
		cardview13 = findViewById(R.id.cardview13);
		payment_layout = findViewById(R.id.payment_layout);
		cardview14 = findViewById(R.id.cardview14);
		accept_reject_layout = findViewById(R.id.accept_reject_layout);
		reason_layout = findViewById(R.id.reason_layout);
		first_name = findViewById(R.id.first_name);
		middle_name = findViewById(R.id.middle_name);
		last_name = findViewById(R.id.last_name);
		linear6 = findViewById(R.id.linear6);
		sex = findViewById(R.id.sex);
		sex_option_icon = findViewById(R.id.sex_option_icon);
		linear7 = findViewById(R.id.linear7);
		birthday = findViewById(R.id.birthday);
		birthday_icon = findViewById(R.id.birthday_icon);
		linear8 = findViewById(R.id.linear8);
		email = findViewById(R.id.email);
		email_icon = findViewById(R.id.email_icon);
		linear9 = findViewById(R.id.linear9);
		contact_icon = findViewById(R.id.contact_icon);
		country_code = findViewById(R.id.country_code);
		contact = findViewById(R.id.contact);
		linear10 = findViewById(R.id.linear10);
		cardview10 = findViewById(R.id.cardview10);
		linear11 = findViewById(R.id.linear11);
		linear12 = findViewById(R.id.linear12);
		dorm_photo = findViewById(R.id.dorm_photo);
		dorm_title = findViewById(R.id.dorm_title);
		dorm_location = findViewById(R.id.dorm_location);
		dorm_monthly_price = findViewById(R.id.dorm_monthly_price);
		textview19 = findViewById(R.id.textview19);
		linear16 = findViewById(R.id.linear16);
		linear17 = findViewById(R.id.linear17);
		linear18 = findViewById(R.id.linear18);
		textview20 = findViewById(R.id.textview20);
		date = findViewById(R.id.date);
		textview21 = findViewById(R.id.textview21);
		time = findViewById(R.id.time);
		linear19 = findViewById(R.id.linear19);
		bedroom_gender = findViewById(R.id.bedroom_gender);
		recyclerview1 = findViewById(R.id.recyclerview1);
		linear36 = findViewById(R.id.linear36);
		linear24 = findViewById(R.id.linear24);
		linear25 = findViewById(R.id.linear25);
		textview43 = findViewById(R.id.textview43);
		amount_total_bed = findViewById(R.id.amount_total_bed);
		textview26 = findViewById(R.id.textview26);
		amount_advance = findViewById(R.id.amount_advance);
		textview27 = findViewById(R.id.textview27);
		amount_deposit = findViewById(R.id.amount_deposit);
		linear26 = findViewById(R.id.linear26);
		textview28 = findViewById(R.id.textview28);
		payment_method = findViewById(R.id.payment_method);
		linear30 = findViewById(R.id.linear30);
		linear31 = findViewById(R.id.linear31);
		textview39 = findViewById(R.id.textview39);
		cardview24 = findViewById(R.id.cardview24);
		linear27 = findViewById(R.id.linear27);
		linear28 = findViewById(R.id.linear28);
		textview29 = findViewById(R.id.textview29);
		textview30 = findViewById(R.id.textview30);
		cardview18 = findViewById(R.id.cardview18);
		textview31 = findViewById(R.id.textview31);
		textview32 = findViewById(R.id.textview32);
		cardview19 = findViewById(R.id.cardview19);
		textview33 = findViewById(R.id.textview33);
		cardview20 = findViewById(R.id.cardview20);
		payment_method1 = findViewById(R.id.payment_method1);
		amount_rent = findViewById(R.id.amount_rent);
		amount_deposit1 = findViewById(R.id.amount_deposit1);
		textview34 = findViewById(R.id.textview34);
		textview35 = findViewById(R.id.textview35);
		cardview21 = findViewById(R.id.cardview21);
		textview36 = findViewById(R.id.textview36);
		textview37 = findViewById(R.id.textview37);
		cardview22 = findViewById(R.id.cardview22);
		textview38 = findViewById(R.id.textview38);
		cardview23 = findViewById(R.id.cardview23);
		linear32 = findViewById(R.id.linear32);
		date_of_payment = findViewById(R.id.date_of_payment);
		date_payment_option = findViewById(R.id.date_payment_option);
		amount_advance1 = findViewById(R.id.amount_advance1);
		amount_total = findViewById(R.id.amount_total);
		linear29 = findViewById(R.id.linear29);
		payment_text = findViewById(R.id.payment_text);
		payment_option = findViewById(R.id.payment_option);
		linear14 = findViewById(R.id.linear14);
		textview14 = findViewById(R.id.textview14);
		note = findViewById(R.id.note);
		cardview16 = findViewById(R.id.cardview16);
		cardview17 = findViewById(R.id.cardview17);
		accept_btn = findViewById(R.id.accept_btn);
		reject_btn = findViewById(R.id.reject_btn);
		linear15 = findViewById(R.id.linear15);
		textview15 = findViewById(R.id.textview15);
		reason = findViewById(R.id.reason);
		confirm_layout = findViewById(R.id.confirm_layout);
		confirm_btn = findViewById(R.id.confirm_btn);
		dialog = new AlertDialog.Builder(this);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		network = new RequestNetwork(this);
		fauth = FirebaseAuth.getInstance();
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		date_payment_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int year, int month, int day) {
						month++;
						//Write here your code, on date picked
						//Sample action is given with an EditText
						date_of_payment.setText(day + "/" + month + "/" + year);
					}
				};
				showDatePicker(datePickerListener);
			}
		});
		
		payment_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(UserDetailsActivity.this, payment_option);
				
				Menu menu = popup.getMenu();
				menu.add("Paid");
				menu.add("Unpaid");
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "Paid":
							payment_text.setText("Paid");
							return true; case "Unpaid":
							payment_text.setText("Unpaid");
							return true; default: return false; } } }); popup.show();
			}
		});
		
		accept_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dialog.setMessage("Are you sure you want to accept booking?");
				dialog.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						map = new HashMap<>();
						map.put("status", "active");
						your_booking.child(getIntent().getStringExtra("uid").concat("/".concat(getIntent().getStringExtra("getPost")))).updateChildren(map);
						my_booking.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(getIntent().getStringExtra("getPost")))).updateChildren(map);
						cal = Calendar.getInstance();
						map = new HashMap<>();
						map.put("profile", "book");
						map.put("title", "Booking is Confirmed!");
						map.put("date", String.valueOf((long)(cal.getTimeInMillis())));
						map.put("message", "Your booking has been ".concat(dorm_title.getText().toString().concat(" on ".concat(date.getText().toString().concat(" has been Confirm. Click to see details or you can check your booking process on the menu profile -> My Booking")))));
						map.put("seen", "false");
						map.put("getPost", getIntent().getStringExtra("getPost"));
						map.put("uid", getIntent().getStringExtra("uid"));
						map.put("status", "active");
						notification.child(getIntent().getStringExtra("uid").concat("/".concat(getPost))).updateChildren(map);
						//FOR YOU
						map = new HashMap<>();
						map.put("status", "active");
						notification.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(getIntent().getStringExtra("getPost")))).updateChildren(map);
						SketchwareUtil.showMessage(getApplicationContext(), "Booking Accepted");
						finish();
					}
				});
				dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				dialog.setCancelable(false);
				dialog.create().show();
			}
		});
		
		reject_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dialog.setMessage("Are you sure you want to reject booking?");
				dialog.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						reason_layout.setVisibility(View.VISIBLE);
						bottom_layout.setVisibility(View.VISIBLE);
						accept_reject_layout.setVisibility(View.GONE);
						data.edit().putString("reject", "true").commit();
						reason.requestFocus();
						SketchwareUtil.showKeyboard(getApplicationContext());
					}
				});
				dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				dialog.setCancelable(false);
				dialog.create().show();
			}
		});
		
		confirm_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (getIntent().getStringExtra("status").equals("pending")) {
					map = new HashMap<>();
					map.put("status", "process");
					your_booking.child(getIntent().getStringExtra("uid").concat("/".concat(getIntent().getStringExtra("getPost")))).updateChildren(map);
					my_booking.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(getIntent().getStringExtra("getPost")))).updateChildren(map);
					//FOR THEM
					map = new HashMap<>();
					map.put("profile", "book");
					map.put("title", "Booking Confirmation");
					map.put("date", String.valueOf((long)(cal.getTimeInMillis())));
					map.put("message", "Your booking has been successfully processed. Click to see details or you can check your booking process on the menu profile -> My Booking");
					map.put("seen", "false");
					map.put("getPost", getIntent().getStringExtra("getPost"));
					map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					map.put("status", "process");
					notification.child(getIntent().getStringExtra("uid").concat("/".concat(getPost))).updateChildren(map);
					//FOR YOU
					map = new HashMap<>();
					map.put("status", "process");
					notification.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(getIntent().getStringExtra("getPost")))).updateChildren(map);
					SketchwareUtil.showMessage(getApplicationContext(), "Booking Confirmed");
					finish();
				}
				else {
					if (getIntent().getStringExtra("status").equals("active")) {
						if (date_of_payment.getText().toString().equals("") || payment_text.getText().toString().equals("")) {
							if (date_of_payment.getText().toString().equals("")) {
								_error(date_of_payment, "Required");
							}
							if (payment_text.getText().toString().equals("")) {
								_error(payment_text, "Required");
							}
						}
						else {
							_telegramLoaderDialog(true);
							network.startRequestNetwork(RequestNetworkController.GET, "https://dorm-finder-df3f2-default-rtdb.firebaseio.com/", "", _network_request_listener);
						}
					}
					else {
						if (data.getString("reject", "").equals("")) {
							if (date_of_payment.getText().toString().equals("") || payment_text.getText().toString().equals("")) {
								if (date_of_payment.getText().toString().equals("")) {
									_error(date_of_payment, "Select");
								}
								if (payment_text.getText().toString().equals("")) {
									_error(payment_text, "Select");
								}
							}
							else {
								_telegramLoaderDialog(true);
								network.startRequestNetwork(RequestNetworkController.GET, "https://dorm-finder-df3f2-default-rtdb.firebaseio.com/", "Error", _network_request_listener);
							}
						}
						else {
							if (data.getString("reject", "").equals("true")) {
								if (reason.getText().toString().equals("")) {
									if (reason.getText().toString().equals("")) {
										((EditText)reason).setError("Write a reason");
									}
								}
								else {
									map = new HashMap<>();
									map.put("status", "rejected");
									map.put("reason", reason.getText().toString());
									your_booking.child(getIntent().getStringExtra("uid").concat("/".concat(getIntent().getStringExtra("getPost")))).updateChildren(map);
									my_booking.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(getIntent().getStringExtra("getPost")))).updateChildren(map);
									map = new HashMap<>();
									map.put("profile", "book");
									map.put("title", "Booking has been declined");
									map.put("date", String.valueOf((long)(cal.getTimeInMillis())));
									map.put("message", "Your booking has been declined. Click to see details or you can check your booking process on the menu profile -> My Booking");
									map.put("seen", "false");
									map.put("getPost", getIntent().getStringExtra("getPost"));
									map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
									map.put("status", "rejected");
									notification.child(getIntent().getStringExtra("uid").concat("/".concat(getPost))).updateChildren(map);
									//FOR YOU
									map = new HashMap<>();
									map.put("status", "rejected");
									notification.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(getIntent().getStringExtra("getPost")))).updateChildren(map);
									SketchwareUtil.showMessage(getApplicationContext(), "Booking Rejected");
									finish();
								}
							}
						}
					}
				}
			}
		});
		
		_booking_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("getPost"))) {
					first_name.setText(_childValue.get("first name").toString());
					middle_name.setText(_childValue.get("middle name").toString());
					last_name.setText(_childValue.get("last name").toString());
					sex.setText(_childValue.get("gender").toString());
					birthday.setText(_childValue.get("birthday").toString());
					email.setText(_childValue.get("email").toString());
					contact.setText(_childValue.get("contact").toString());
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo").toString())).into(dorm_photo);
					dorm_title.setText(_childValue.get("dormitory name").toString());
					dorm_location.setText(_childValue.get("location").toString());
					dorm_monthly_price.setText("₱".concat(_childValue.get("booking price1").toString()));
					date.setText(_childValue.get("date").toString());
					time.setText(_childValue.get("time").toString());
					bedroom_gender.setText(_childValue.get("bedroom_select").toString());
					payment_method.setText(_childValue.get("payment method").toString());
					payment_method1.setText(_childValue.get("payment method").toString());
					amount_rent.setText(_childValue.get("booking price1").toString().concat("    P"));
					note.setText(_childValue.get("note").toString());
					if (getIntent().getStringExtra("status").equals("completed")) {
						date_of_payment.setText(_childValue.get("date of payment").toString());
						payment_text.setText(_childValue.get("payment status").toString());
					}
					if (_childValue.get("type of dormitory").toString().equals("Transcient")) {
						textview26.setText("Minimum Stay");
						amount_advance.setText(_childValue.get("minimum stay").toString().concat("    night(s)"));
						textview27.setText("Rates per Night");
						amount_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("minimum stay").toString()) * Double.parseDouble(_childValue.get("rates per night").toString())).concat("    P"));
					}
					else {
						amount_advance.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount advance").toString())).concat("    P"));
						amount_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("amount deposit").toString())).concat("    P"));
						amount_total.setText(_childValue.get("total price").toString().concat("    P"));
						amount_advance1.setText(_childValue.get("amount advance").toString().concat("    P"));
						amount_deposit1.setText(_childValue.get("amount deposit").toString());
						amount_total_bed.setText(_childValue.get("total price").toString());
						quantity = Double.parseDouble(_childValue.get("quantity").toString());
						rates_bedroom_num = 0;
						for(int _repeat214 = 0; _repeat214 < (int)(quantity); _repeat214++) {
							rates_bedroom_num++;
							map = new HashMap<>();
							map.put("final count2", "");
							map.put("final count", String.valueOf((long)(rates_bedroom_num)));
							booking_listmap.add(map);
							recyclerview1.setVisibility(View.VISIBLE);
						}
						str1 = "booking/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
						postBooking = _firebase.getReference(str1);
						postBooking.addChildEventListener(_postBooking_child_listener);
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
		booking.addChildEventListener(_booking_child_listener);
		
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
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				map = new HashMap<>();
				map.put("date of payment", date_of_payment.getText().toString());
				map.put("payment status", payment_text.getText().toString());
				map.put("status", "completed");
				your_booking.child(getIntent().getStringExtra("uid").concat("/".concat(getIntent().getStringExtra("getPost")))).updateChildren(map);
				my_booking.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(getIntent().getStringExtra("getPost")))).updateChildren(map);
				map = new HashMap<>();
				map.put("profile", "book");
				map.put("title", "Payment Transaction");
				map.put("date", String.valueOf((long)(cal.getTimeInMillis())));
				map.put("message", "Your recent payment transaction has been successfully processed and tour payment for Booking is now complete. Click to see details or you can check your booking process on the menu profile -> My Booking");
				map.put("seen", "false");
				map.put("getPost", getIntent().getStringExtra("getPost"));
				map.put("uid", getIntent().getStringExtra("uid"));
				map.put("status", "completed");
				notification.child(getIntent().getStringExtra("uid").concat("/".concat(getPost))).updateChildren(map);
				getPost1 = notification.push().getKey();
				map = new HashMap<>();
				map.put("profile", "book");
				map.put("title", "Booking Completed!");
				map.put("date", String.valueOf((long)(cal.getTimeInMillis())));
				map.put("message", "Congratulations! Your booking is now complete. Click to see details or you can check your booking process on the menu profile -> My Booking");
				map.put("seen", "false");
				map.put("getPost", getIntent().getStringExtra("getPost"));
				map.put("uid", getIntent().getStringExtra("uid"));
				map.put("status", "completed");
				notification.child(getIntent().getStringExtra("uid").concat("/".concat(getPost1))).updateChildren(map);
				//FOR YOU
				map = new HashMap<>();
				map.put("status", "completed");
				notification.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(getIntent().getStringExtra("getPost")))).updateChildren(map);
				_total_count();
				_telegramLoaderDialog(false);
				SketchwareUtil.showMessage(getApplicationContext(), payment_text.getText().toString());
				finish();
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				_telegramLoaderDialog(false);
				SketchwareUtil.showMessage(getApplicationContext(), _message);
			}
		};
		
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
		
		_my_booking_child_listener = new ChildEventListener() {
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
		my_booking.addChildEventListener(_my_booking_child_listener);
		
		_your_booking_child_listener = new ChildEventListener() {
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
		your_booking.addChildEventListener(_your_booking_child_listener);
		
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
					postBooking.addChildEventListener(_postBooking_child_listener);
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
					recyclerview1.setAdapter(new Recyclerview1Adapter(booking_listmap));
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
		_ImageColor(back, "#176b87");
		_ImageColor(sex_option_icon, "#176b87");
		_ImageColor(birthday_icon, "#176b87");
		_ImageColor(email_icon, "#176b87");
		_ImageColor(contact_icon, "#176b87");
		_ImageColor(date_payment_option, "#176b87");
		_ImageColor(payment_option, "#176b87");
		_riffleEffect("#f5f5f5", back);
		_simpleRiffle(accept_btn);
		_simpleRiffle(reject_btn);
		_simpleRiffle(confirm_btn);
		first_name.setSingleLine(true);
		middle_name.setSingleLine(true);
		last_name.setSingleLine(true);
		first_name.setEnabled(false);
		middle_name.setEnabled(false);
		last_name.setEnabled(false);
		last_name.setEnabled(true);
		contact.setEnabled(false);
		accept_reject_layout.setVisibility(View.GONE);
		reason_layout.setVisibility(View.GONE);
		payment_layout.setVisibility(View.GONE);
		bottom_layout.setVisibility(View.GONE);
		if (getIntent().getStringExtra("status").equals("pending")) {
			bottom_layout.setVisibility(View.VISIBLE);
		}
		else {
			if (getIntent().getStringExtra("status").equals("process")) {
				accept_reject_layout.setVisibility(View.VISIBLE);
			}
			else {
				if (getIntent().getStringExtra("status").equals("active")) {
					payment_layout.setVisibility(View.VISIBLE);
					bottom_layout.setVisibility(View.VISIBLE);
					confirm_btn.setText("Save");
				}
				else {
					if (getIntent().getStringExtra("status").equals("completed")) {
						payment_layout.setVisibility(View.VISIBLE);
						date_payment_option.setEnabled(false);
						payment_option.setEnabled(false);
					}
				}
			}
		}
		getPost = notification.push().getKey();
		str = "booking/".concat(getIntent().getStringExtra("uid"));
		booking = _firebase.getReference(str);
		booking.addChildEventListener(_booking_child_listener);
		total.addChildEventListener(_total_child_listener);
		recyclerview1.setLayoutManager(new LinearLayoutManager(this));
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
	
	
	public void _extra() {
	}
	
	public void showDatePicker(DatePickerDialog.OnDateSetListener listener) {
		DatePickerDialog datePicker = new DatePickerDialog(UserDetailsActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth);
		datePicker.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
		
		datePicker.setOnDateSetListener(listener);
		datePicker.show();
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
	
	
	public void _error(final TextView _textview, final String _message) {
		_textview.setError(_message);
	}
	
	
	public void _total_count() {
		map = new HashMap<>();
		map.put("count", String.valueOf((long)(totalOccupied + 1)));
		total.child("rooms occupied").updateChildren(map);
	}
	
	
	public void _simpleRiffle(final View _view) {
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