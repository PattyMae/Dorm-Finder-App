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
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class BookingDetailsActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String str = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String getStatus = "";
	private boolean isVisible = false;
	private String getPost = "";
	private double quantity = 0;
	private double rates_bedroom_num = 0;
	private String str1 = "";
	
	private ArrayList<HashMap<String, Object>> booking_listmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout top;
	private LinearLayout center;
	private LinearLayout bottom;
	private ImageView back;
	private TextView textview1;
	private ScrollView vscroll1;
	private LinearLayout linear5;
	private CardView cardview1;
	private CardView cardview3;
	private TextView textview8;
	private CardView cardview4;
	private CardView cardview5;
	private CardView cardview6;
	private LinearLayout linear6;
	private CardView cardview2;
	private LinearLayout linear7;
	private LinearLayout price_layout;
	private ImageView photo;
	private TextView title;
	private TextView location;
	private TextView rent_amount;
	private TextView per_night_layout;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private TextView textview6;
	private TextView date;
	private TextView textview7;
	private TextView time;
	private LinearLayout linear12;
	private TextView textview17;
	private RecyclerView recyclerview1;
	private LinearLayout linear23;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private TextView textview21;
	private TextView amount_total_bed;
	private TextView textview12;
	private TextView amount_advance;
	private TextView textview13;
	private TextView amount_deposit;
	private LinearLayout linear19;
	private TextView textview14;
	private TextView payment_method;
	private LinearLayout linear20;
	private TextView textview16;
	private TextView note;
	private CardView cardview7;
	private TextView cancel_btn;
	
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
	
	private DatabaseReference booking = _firebase.getReference("booking");
	private ChildEventListener _booking_child_listener;
	private Intent intent = new Intent();
	private SharedPreferences data;
	private DatabaseReference postData = _firebase.getReference("booking");
	private ChildEventListener _postData_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.booking_details);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		top = findViewById(R.id.top);
		center = findViewById(R.id.center);
		bottom = findViewById(R.id.bottom);
		back = findViewById(R.id.back);
		textview1 = findViewById(R.id.textview1);
		vscroll1 = findViewById(R.id.vscroll1);
		linear5 = findViewById(R.id.linear5);
		cardview1 = findViewById(R.id.cardview1);
		cardview3 = findViewById(R.id.cardview3);
		textview8 = findViewById(R.id.textview8);
		cardview4 = findViewById(R.id.cardview4);
		cardview5 = findViewById(R.id.cardview5);
		cardview6 = findViewById(R.id.cardview6);
		linear6 = findViewById(R.id.linear6);
		cardview2 = findViewById(R.id.cardview2);
		linear7 = findViewById(R.id.linear7);
		price_layout = findViewById(R.id.price_layout);
		photo = findViewById(R.id.photo);
		title = findViewById(R.id.title);
		location = findViewById(R.id.location);
		rent_amount = findViewById(R.id.rent_amount);
		per_night_layout = findViewById(R.id.per_night_layout);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		textview6 = findViewById(R.id.textview6);
		date = findViewById(R.id.date);
		textview7 = findViewById(R.id.textview7);
		time = findViewById(R.id.time);
		linear12 = findViewById(R.id.linear12);
		textview17 = findViewById(R.id.textview17);
		recyclerview1 = findViewById(R.id.recyclerview1);
		linear23 = findViewById(R.id.linear23);
		linear17 = findViewById(R.id.linear17);
		linear18 = findViewById(R.id.linear18);
		textview21 = findViewById(R.id.textview21);
		amount_total_bed = findViewById(R.id.amount_total_bed);
		textview12 = findViewById(R.id.textview12);
		amount_advance = findViewById(R.id.amount_advance);
		textview13 = findViewById(R.id.textview13);
		amount_deposit = findViewById(R.id.amount_deposit);
		linear19 = findViewById(R.id.linear19);
		textview14 = findViewById(R.id.textview14);
		payment_method = findViewById(R.id.payment_method);
		linear20 = findViewById(R.id.linear20);
		textview16 = findViewById(R.id.textview16);
		note = findViewById(R.id.note);
		cardview7 = findViewById(R.id.cardview7);
		cancel_btn = findViewById(R.id.cancel_btn);
		fauth = FirebaseAuth.getInstance();
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		cancel_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (data.getString("user", "").equals("owner")) {
					
				}
				else {
					if (data.getString("user", "").equals("student")) {
						intent.setAction(Intent.ACTION_VIEW);
						intent.setClass(getApplicationContext(), CancelBookingActivity.class);
						intent.putExtra("getPost", getIntent().getStringExtra("getPost"));
						intent.putExtra("uid", getIntent().getStringExtra("uid"));
						startActivity(intent);
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
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo").toString())).into(photo);
					title.setText(_childValue.get("dormitory name").toString());
					location.setText(_childValue.get("location").toString());
					if (_childValue.get("type of dormitory").toString().equals("Transcient")) {
						textview12.setText("Minimum Stay");
						amount_advance.setText(_childValue.get("minimum stay").toString().concat("    night(s)"));
						textview13.setText("Rates per Night");
						amount_deposit.setText(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("minimum stay").toString()) * Double.parseDouble(_childValue.get("rates per night").toString())).concat("    P"));
						rent_amount.setText("₱".concat(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("rates per night").toString()))));
						per_night_layout.setText("/night");
					}
					else {
						amount_advance.setText(_childValue.get("amount advance").toString());
						amount_deposit.setText(_childValue.get("amount deposit").toString());
						rent_amount.setText("₱".concat(new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("price").toString()))));
						per_night_layout.setText("/month");
						amount_total_bed.setText(_childValue.get("total price").toString());
						quantity = Double.parseDouble(_childValue.get("quantity").toString());
						rates_bedroom_num = 0;
						for(int _repeat208 = 0; _repeat208 < (int)(quantity); _repeat208++) {
							rates_bedroom_num++;
							map = new HashMap<>();
							map.put("final count2", "");
							map.put("final count", String.valueOf((long)(rates_bedroom_num)));
							booking_listmap.add(map);
						}
						str1 = "booking/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
						postData = _firebase.getReference(str1);
						postData.addChildEventListener(_postData_child_listener);
					}
					date.setText(_childValue.get("date").toString());
					time.setText(_childValue.get("time").toString());
					textview17.setText(_childValue.get("bedroom_select").toString());
					payment_method.setText(_childValue.get("payment method").toString());
					note.setText(_childValue.get("note").toString());
					if (_childValue.get("status").toString().equals("pending")) {
						if (data.getString("user", "").equals("owner")) {
							bottom.setVisibility(View.GONE);
						}
						else {
							if (data.getString("user", "").equals("student")) {
								bottom.setVisibility(View.VISIBLE);
							}
						}
					}
					else {
						if (_childValue.get("status").toString().equals("canceled")) {
							cancel_btn.setText("Canceled");
							cancel_btn.setBackgroundColor(0xFF607D8B);
							cancel_btn.setEnabled(false);
							bottom.setVisibility(View.VISIBLE);
						}
						else {
							if (_childValue.get("status").toString().equals("rejected")) {
								cancel_btn.setText("Rejected");
								cancel_btn.setBackgroundColor(0xFF607D8B);
								cancel_btn.setEnabled(false);
								bottom.setVisibility(View.VISIBLE);
							}
							else {
								
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
		booking.addChildEventListener(_booking_child_listener);
		
		_postData_child_listener = new ChildEventListener() {
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
						postData.addChildEventListener(_postData_child_listener);
					}
					else {
						if (String.valueOf((long)(quantity)).equals("8")) {
							quantity--;
							data.edit().putString("data booking rates bedroom8", _childValue.get("booking bedroom8").toString()).commit();
							data.edit().putString("data booking rates bed8", _childValue.get("booking bed8").toString()).commit();
							data.edit().putString("data booking rates floor8", _childValue.get("booking floor8").toString()).commit();
							data.edit().putString("data booking rates price8", _childValue.get("booking price8").toString()).commit();
							data.edit().putString("data booking rates status8", _childValue.get("booking status8").toString()).commit();
							postData.addChildEventListener(_postData_child_listener);
						}
						else {
							if (String.valueOf((long)(quantity)).equals("7")) {
								quantity--;
								data.edit().putString("data booking rates bedroom7", _childValue.get("booking bedroom7").toString()).commit();
								data.edit().putString("data booking rates bed7", _childValue.get("booking bed7").toString()).commit();
								data.edit().putString("data booking rates floor7", _childValue.get("booking floor7").toString()).commit();
								data.edit().putString("data booking rates price7", _childValue.get("booking price7").toString()).commit();
								data.edit().putString("data booking rates status7", _childValue.get("booking status7").toString()).commit();
								postData.addChildEventListener(_postData_child_listener);
							}
							else {
								if (String.valueOf((long)(quantity)).equals("6")) {
									quantity--;
									data.edit().putString("data booking rates bedroom6", _childValue.get("booking bedroom6").toString()).commit();
									data.edit().putString("data booking rates bed6", _childValue.get("booking bed6").toString()).commit();
									data.edit().putString("data booking rates floor6", _childValue.get("booking floor6").toString()).commit();
									data.edit().putString("data booking rates price6", _childValue.get("booking price6").toString()).commit();
									data.edit().putString("data booking rates status6", _childValue.get("booking status6").toString()).commit();
									postData.addChildEventListener(_postData_child_listener);
								}
								else {
									if (String.valueOf((long)(quantity)).equals("5")) {
										quantity--;
										data.edit().putString("data booking rates bedroom5", _childValue.get("booking bedroom5").toString()).commit();
										data.edit().putString("data booking rates bed5", _childValue.get("booking bed5").toString()).commit();
										data.edit().putString("data booking rates floor5", _childValue.get("booking floor5").toString()).commit();
										data.edit().putString("data booking rates price5", _childValue.get("booking price5").toString()).commit();
										data.edit().putString("data booking rates status5", _childValue.get("booking status5").toString()).commit();
										postData.addChildEventListener(_postData_child_listener);
									}
									else {
										if (String.valueOf((long)(quantity)).equals("4")) {
											quantity--;
											data.edit().putString("data booking rates bedroom4", _childValue.get("booking bedroom4").toString()).commit();
											data.edit().putString("data booking rates bed4", _childValue.get("booking bed4").toString()).commit();
											data.edit().putString("data booking rates floor4", _childValue.get("booking floor4").toString()).commit();
											data.edit().putString("data booking rates price4", _childValue.get("booking price4").toString()).commit();
											data.edit().putString("data booking rates status4", _childValue.get("booking status4").toString()).commit();
											postData.addChildEventListener(_postData_child_listener);
										}
										else {
											if (String.valueOf((long)(quantity)).equals("3")) {
												quantity--;
												data.edit().putString("data booking rates bedroom3", _childValue.get("booking bedroom3").toString()).commit();
												data.edit().putString("data booking rates bed3", _childValue.get("booking bed3").toString()).commit();
												data.edit().putString("data booking rates floor3", _childValue.get("booking floor3").toString()).commit();
												data.edit().putString("data booking rates price3", _childValue.get("booking price3").toString()).commit();
												data.edit().putString("data booking rates status3", _childValue.get("booking status3").toString()).commit();
												postData.addChildEventListener(_postData_child_listener);
											}
											else {
												if (String.valueOf((long)(quantity)).equals("2")) {
													quantity--;
													data.edit().putString("data booking rates bedroom2", _childValue.get("booking bedroom2").toString()).commit();
													data.edit().putString("data booking rates bed2", _childValue.get("booking bed2").toString()).commit();
													data.edit().putString("data booking rates floor2", _childValue.get("booking floor2").toString()).commit();
													data.edit().putString("data booking rates price2", _childValue.get("booking price2").toString()).commit();
													data.edit().putString("data booking rates status2", _childValue.get("booking status2").toString()).commit();
													postData.addChildEventListener(_postData_child_listener);
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
		postData.addChildEventListener(_postData_child_listener);
		
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
		_riffleEffect("#176b87", back);
		_simpleRiffle(cancel_btn);
		bottom.setVisibility(View.GONE);
		str = "booking/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
		booking = _firebase.getReference(str);
		booking.addChildEventListener(_booking_child_listener);
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
	
	
	public void _simpleRiffle(final View _view) {
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