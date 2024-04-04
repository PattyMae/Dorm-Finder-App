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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
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
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
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
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class SignupWithPasswordActivity extends AppCompatActivity {
	
	public final int REQ_CD_GAUTH = 101;
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	FirebaseUser FirebaseUser;
	GoogleSignInOptions options;
	private String getPost = "";
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ImageView logo;
	private TextView signup_signin_status;
	private CardView cardview1;
	private CardView cardview2;
	private CheckBox checkbox1;
	private CardView cardview5;
	private LinearLayout linear11;
	private TextView textview2;
	private CardView cardview6;
	private LinearLayout linear10;
	private ImageView back;
	private LinearLayout linear3;
	private CardView cardview3;
	private LinearLayout linear6;
	private ImageView imageview2;
	private EditText email;
	private LinearLayout linear4;
	private CardView cardview4;
	private LinearLayout linear7;
	private ImageView imageview3;
	private EditText password;
	private ImageView show;
	private LinearLayout signup_signin_button;
	private TextView textview1;
	private TextView forgot_password;
	private ImageView google;
	private TextView textview3;
	private TextView signin;
	
	private SharedPreferences data;
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
	private GoogleSignInClient gauth;
	private Calendar cal = Calendar.getInstance();
	private DatabaseReference notification = _firebase.getReference("notification");
	private ChildEventListener _notification_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.signup_with_password);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		logo = findViewById(R.id.logo);
		signup_signin_status = findViewById(R.id.signup_signin_status);
		cardview1 = findViewById(R.id.cardview1);
		cardview2 = findViewById(R.id.cardview2);
		checkbox1 = findViewById(R.id.checkbox1);
		cardview5 = findViewById(R.id.cardview5);
		linear11 = findViewById(R.id.linear11);
		textview2 = findViewById(R.id.textview2);
		cardview6 = findViewById(R.id.cardview6);
		linear10 = findViewById(R.id.linear10);
		back = findViewById(R.id.back);
		linear3 = findViewById(R.id.linear3);
		cardview3 = findViewById(R.id.cardview3);
		linear6 = findViewById(R.id.linear6);
		imageview2 = findViewById(R.id.imageview2);
		email = findViewById(R.id.email);
		linear4 = findViewById(R.id.linear4);
		cardview4 = findViewById(R.id.cardview4);
		linear7 = findViewById(R.id.linear7);
		imageview3 = findViewById(R.id.imageview3);
		password = findViewById(R.id.password);
		show = findViewById(R.id.show);
		signup_signin_button = findViewById(R.id.signup_signin_button);
		textview1 = findViewById(R.id.textview1);
		forgot_password = findViewById(R.id.forgot_password);
		google = findViewById(R.id.google);
		textview3 = findViewById(R.id.textview3);
		signin = findViewById(R.id.signin);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		fauth = FirebaseAuth.getInstance();
		
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					data.edit().putString("email", email.getText().toString()).commit();
					data.edit().putString("password", password.getText().toString()).commit();
				}
				else {
					data.edit().remove("email").commit();
					data.edit().remove("password").commit();
				}
			}
		});
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finishAffinity();
			}
		});
		
		password.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (0 < password.getText().toString().length()) {
					if (_charSeq.length() > 0) {
						show.setVisibility(View.VISIBLE);
					}
				}
				else {
					show.setVisibility(View.GONE);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		show.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (data.getString("pass", "").equals("true")) {
					data.edit().putString("pass", "false").commit();
					show.setImageResource(R.drawable.hide);
					password.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
					_Hide_Keyboard(password);
				}
				else {
					if (data.getString("pass", "").equals("false")) {
						data.edit().putString("pass", "true").commit();
						show.setImageResource(R.drawable.show);
						password.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
						_Hide_Keyboard(password);
					}
				}
			}
		});
		
		signup_signin_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (email.getText().toString().equals("") || password.getText().toString().equals("")) {
					if (email.getText().toString().equals("")) {
						((EditText)email).setError("Email is empty");
					}
					if (password.getText().toString().equals("")) {
						((EditText)password).setError("Password is empty");
						forgot_password.setVisibility(View.VISIBLE);
					}
				}
				else {
					if (textview1.getText().toString().equals("Sign in")) {
						fauth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(SignupWithPasswordActivity.this, _fauth_sign_in_listener);
						textview1.setText("Signing in...");
					}
					else {
						if (textview1.getText().toString().equals("Sign up")) {
							intent.setClass(getApplicationContext(), SigninSetupActivity.class);
							intent.putExtra("email", email.getText().toString());
							intent.putExtra("pass", password.getText().toString());
							startActivity(intent);
						}
					}
				}
			}
		});
		
		forgot_password.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ForgotPasswordActivity.class);
				startActivity(intent);
			}
		});
		
		google.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent signInIntent = gauth.getSignInIntent();
				
				startActivityForResult(signInIntent, REQ_CD_GAUTH);
			}
		});
		
		signin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (textview1.getText().toString().equals("Sign up")) {
					signup_signin_status.setText("Login to Your Account");
					textview1.setText("Sign in");
					signin.setText("Sign up");
					textview3.setText("Don't have an account? ");
				}
				else {
					if (textview1.getText().toString().equals("Sign in")) {
						signup_signin_status.setText("Create New Account");
						textview1.setText("Sign up");
						signin.setText("Sign in");
						textview3.setText("Already have an account? ");
					}
				}
			}
		});
		
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
				if (_success) {
					if (checkbox1.isChecked()) {
						data.edit().putString("email", email.getText().toString()).commit();
						data.edit().putString("password", password.getText().toString()).commit();
					}
					data.edit().putString("login", "true").commit();
					intent.setClass(getApplicationContext(), MainActivity.class);
					startActivity(intent);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
					forgot_password.setVisibility(View.VISIBLE);
					textview1.setText("Sign in");
				}
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
		_rippleRoundStroke(signup_signin_button, "#176b87", "#eeeeee", 100, 100, "#176b87");
		_simpleRiffle(google);
		_simpleRiffle(signin);
		_simpleRiffle(forgot_password);
		email.setSingleLine(true);
		password.setSingleLine(true);
		forgot_password.setVisibility(View.GONE);
		_ImageColor(logo, "#176b87");
		password.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
		textview1.setText(getIntent().getStringExtra("a"));
		signin.setText(getIntent().getStringExtra("b"));
		textview3.setText(getIntent().getStringExtra("c"));
		signup_signin_status.setText(getIntent().getStringExtra("d"));
		data.edit().putString("pass", "true").commit();
		if (data.getString("email", "").equals("")) {
			checkbox1.setChecked(false);
		}
		else {
			if (data.getString("email", "").equals(data.getString("email", ""))) {
				email.setText(data.getString("email", ""));
				password.setText(data.getString("password", ""));
				checkbox1.setChecked(true);
			}
		}
		GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("363016037239-igf0lm9rff8l3t5lt7am3msl70klbgmo.apps.googleusercontent.com").requestEmail().build();
		gauth = GoogleSignIn.getClient(this, options);
		fauth = FirebaseAuth.getInstance();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_GAUTH:
			if (_resultCode == Activity.RESULT_OK) {
				Task<GoogleSignInAccount> _task = GoogleSignIn.getSignedInAccountFromIntent(_data);
				
				try {
					                // Google Sign In was successful, authenticate with Firebase
					                GoogleSignInAccount account = _task.getResult(ApiException.class);
					                
					                firebaseAuthWithGoogle(account.getIdToken());
					            } catch (ApiException e) {
					                //On Fiailure
					                final String ErrorOnResultSign = e.getMessage();
					                SketchwareUtil.showMessage(getApplicationContext(), ErrorOnResultSign);
					            }
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		finishAffinity();
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
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#eeeeee")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
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
	
	
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	
	public void _signInWithGoogle() {
	}
	private void firebaseAuthWithGoogle(String idToken) {
		AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
		fauth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
			
			@Override
			public void onComplete(@NonNull Task<AuthResult> task) {
				if (task.isSuccessful()) {
					FirebaseUser = fauth.getCurrentUser();
					if (data.getString("login", "").equals("")) {
						map = new HashMap<>();
						map.put("profile", FirebaseUser.getPhotoUrl().toString());
						map.put("firstname", "");
						map.put("middle name", "");
						map.put("lastname", "");
						map.put("fullname", FirebaseUser.getDisplayName());
						map.put("nickname", FirebaseUser.getDisplayName());
						map.put("birthday", "");
						map.put("email", FirebaseUser.getEmail());
						map.put("phone", "");
						map.put("gender", "");
						map.put("userKey", FirebaseAuth.getInstance().getCurrentUser().getUid());
						map.put("user", data.getString("user", ""));
						users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
						cal = Calendar.getInstance();
						getPost = notification.push().getKey();
						map = new HashMap<>();
						map.put("profile", "account");
						map.put("title", "Account Setup Successfully!");
						map.put("date", String.valueOf((long)(cal.getTimeInMillis())));
						map.put("message", "Your account creation is successfully, you can now experience our services.");
						map.put("seen", "true");
						map.put("getPost", getPost);
						map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
						notification.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(getPost))).updateChildren(map);
						data.edit().putString("login", "true").commit();
					}
					else {
						
					}
					data.edit().putString("login", "true").commit();
					intent.setClass(getApplicationContext(), MainActivity.class);
					startActivity(intent);
				} else {
					SketchwareUtil.showMessage(getApplicationContext(), "Login error");
				}
			}
		});
	}
	//[END auth_with_google]
	{
	}
	
	
	public void _Hide_Keyboard(final TextView _edittext) {
		_edittext.setEnabled(false);
		_edittext.setEnabled(true);
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