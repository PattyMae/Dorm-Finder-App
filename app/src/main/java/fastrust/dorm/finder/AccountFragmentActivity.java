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
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class AccountFragmentActivity extends Fragment {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	
	private LinearLayout bg;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear6;
	private LinearLayout select_my_booking;
	private LinearLayout line1;
	private LinearLayout select_profile;
	private LinearLayout select_notification;
	private LinearLayout select_security;
	private LinearLayout select_language;
	private LinearLayout select_logout;
	private ImageView logo_icon;
	private TextView textview1;
	private LinearLayout linear5;
	private LinearLayout linear4;
	private CardView profile_layout;
	private CardView edit_layout;
	private ImageView profile_icon;
	private ImageView edit_icon;
	private TextView fullname;
	private ImageView imageview1;
	private TextView textview2;
	private ImageView imageview2;
	private ImageView imageview3;
	private TextView textview3;
	private ImageView imageview4;
	private ImageView imageview5;
	private TextView textview4;
	private ImageView imageview6;
	private ImageView imageview7;
	private TextView textview5;
	private ImageView imageview8;
	private ImageView imageview9;
	private TextView textview6;
	private TextView textview7;
	private ImageView imageview10;
	private ImageView imageview13;
	private TextView textview9;
	
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
	private Intent intent = new Intent();
	private SharedPreferences data;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.account_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		bg = _view.findViewById(R.id.bg);
		linear2 = _view.findViewById(R.id.linear2);
		linear3 = _view.findViewById(R.id.linear3);
		linear6 = _view.findViewById(R.id.linear6);
		select_my_booking = _view.findViewById(R.id.select_my_booking);
		line1 = _view.findViewById(R.id.line1);
		select_profile = _view.findViewById(R.id.select_profile);
		select_notification = _view.findViewById(R.id.select_notification);
		select_security = _view.findViewById(R.id.select_security);
		select_language = _view.findViewById(R.id.select_language);
		select_logout = _view.findViewById(R.id.select_logout);
		logo_icon = _view.findViewById(R.id.logo_icon);
		textview1 = _view.findViewById(R.id.textview1);
		linear5 = _view.findViewById(R.id.linear5);
		linear4 = _view.findViewById(R.id.linear4);
		profile_layout = _view.findViewById(R.id.profile_layout);
		edit_layout = _view.findViewById(R.id.edit_layout);
		profile_icon = _view.findViewById(R.id.profile_icon);
		edit_icon = _view.findViewById(R.id.edit_icon);
		fullname = _view.findViewById(R.id.fullname);
		imageview1 = _view.findViewById(R.id.imageview1);
		textview2 = _view.findViewById(R.id.textview2);
		imageview2 = _view.findViewById(R.id.imageview2);
		imageview3 = _view.findViewById(R.id.imageview3);
		textview3 = _view.findViewById(R.id.textview3);
		imageview4 = _view.findViewById(R.id.imageview4);
		imageview5 = _view.findViewById(R.id.imageview5);
		textview4 = _view.findViewById(R.id.textview4);
		imageview6 = _view.findViewById(R.id.imageview6);
		imageview7 = _view.findViewById(R.id.imageview7);
		textview5 = _view.findViewById(R.id.textview5);
		imageview8 = _view.findViewById(R.id.imageview8);
		imageview9 = _view.findViewById(R.id.imageview9);
		textview6 = _view.findViewById(R.id.textview6);
		textview7 = _view.findViewById(R.id.textview7);
		imageview10 = _view.findViewById(R.id.imageview10);
		imageview13 = _view.findViewById(R.id.imageview13);
		textview9 = _view.findViewById(R.id.textview9);
		fauth = FirebaseAuth.getInstance();
		data = getContext().getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		select_my_booking.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (data.getString("user", "").equals("owner")) {
					intent.setClass(getContext().getApplicationContext(), AdminBookingActivity.class);
					startActivity(intent);
				}
				else {
					if (data.getString("user", "").equals("student")) {
						intent.setClass(getContext().getApplicationContext(), MyBookingActivity.class);
						startActivity(intent);
					}
				}
			}
		});
		
		select_profile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getContext().getApplicationContext(), ProfileActivity.class);
				startActivity(intent);
			}
		});
		
		select_notification.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getContext().getApplicationContext(), SettingsNotificationActivity.class);
				startActivity(intent);
			}
		});
		
		select_security.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getContext().getApplicationContext(), SettingsSecurityActivity.class);
				startActivity(intent);
			}
		});
		
		select_language.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getContext().getApplicationContext(), "Default");
			}
		});
		
		select_logout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				LogoutBottomdialogFragmentDialogFragmentActivityN = new LogoutBottomdialogFragmentDialogFragmentActivity();
				LogoutBottomdialogFragmentDialogFragmentActivityN.show(getFragmentManager(),"1");
			}
		});
		
		edit_icon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getContext().getApplicationContext(), ProfileActivity.class);
				startActivity(intent);
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
					fullname.setText(_childValue.get("fullname").toString());
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
		_setRadiusCorner(linear2, 0, 5, "#ffffff");
		_ImageColor(logo_icon, "#176b87");
		_ImageColor(edit_icon, "#ffffff");
		_ImageColor(imageview1, "#176b87");
		_ImageColor(imageview2, "#176b87");
		_ImageColor(imageview3, "#176b87");
		_ImageColor(imageview4, "#176b87");
		_ImageColor(imageview5, "#176b87");
		_ImageColor(imageview6, "#176b87");
		_ImageColor(imageview7, "#176b87");
		_ImageColor(imageview8, "#176b87");
		_ImageColor(imageview9, "#176b87");
		_ImageColor(imageview10, "#176b87");
		_ImageColor(imageview13, "#f44336");
		_simpleRiffle(select_my_booking);
		_simpleRiffle(select_profile);
		_simpleRiffle(select_notification);
		_simpleRiffle(select_security);
		_simpleRiffle(select_language);
		_simpleRiffle(select_logout);
		if (data.getString("user", "").equals("owner")) {
			line1.setVisibility(View.GONE);
			linear2.setVisibility(View.GONE);
			textview2.setText("Bookings");
		}
		else {
			if (data.getString("user", "").equals("student")) {
				line1.setVisibility(View.VISIBLE);
				linear2.setVisibility(View.VISIBLE);
				textview2.setText("My Booking");
			}
		}
		users.addChildEventListener(_users_child_listener);
	}
	
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	
	public void _simpleRiffle(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
		_view.setBackground(GA8PO9);
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
	
	
	public void _lib() {
	}
	private LogoutBottomdialogFragmentDialogFragmentActivity LogoutBottomdialogFragmentDialogFragmentActivityN;
	private FragmentManager LogoutBottomdialogFragmentDialogFragmentActivityFM;
	public void test_LogoutBottomdialogFragmentDialogFragmentActivity () {
	}
	
	
	public void _setRadiusCorner(final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
	}
	
}
