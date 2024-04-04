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

public class SigninDialogActivity extends AppCompatActivity {
	
	public final int REQ_CD_GAUTH = 101;
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	GoogleSignInOptions options;
	private HashMap<String, Object> map = new HashMap<>();
	FirebaseUser FirebaseUser;
	private String getPost = "";
	
	private CardView cardview1;
	private LinearLayout linear1;
	private ImageView imageview1;
	private CardView cardview2;
	private TextView textview2;
	private CardView cardview3;
	private LinearLayout linear4;
	private LinearLayout continue_with_google;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout signin_with_password;
	private TextView textview3;
	private TextView textview4;
	private TextView signup;
	
	private GoogleSignInClient gauth;
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
	private Calendar cal = Calendar.getInstance();
	private DatabaseReference notification = _firebase.getReference("notification");
	private ChildEventListener _notification_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.signin_dialog);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		cardview1 = findViewById(R.id.cardview1);
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		cardview2 = findViewById(R.id.cardview2);
		textview2 = findViewById(R.id.textview2);
		cardview3 = findViewById(R.id.cardview3);
		linear4 = findViewById(R.id.linear4);
		continue_with_google = findViewById(R.id.continue_with_google);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		signin_with_password = findViewById(R.id.signin_with_password);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		signup = findViewById(R.id.signup);
		fauth = FirebaseAuth.getInstance();
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		continue_with_google.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent signInIntent = gauth.getSignInIntent();
				
				startActivityForResult(signInIntent, REQ_CD_GAUTH);
			}
		});
		
		signin_with_password.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), SignupWithPasswordActivity.class);
				intent.putExtra("a", "Sign in");
				intent.putExtra("b", "Sign up");
				intent.putExtra("c", "Don't have an account? ");
				intent.putExtra("d", "Login to Your Account");
				startActivity(intent);
			}
		});
		
		signup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), SignupWithPasswordActivity.class);
				intent.putExtra("a", "Sign up");
				intent.putExtra("b", "Sign in");
				intent.putExtra("c", "Already have an account? ");
				intent.putExtra("d", "Create New Account");
				startActivity(intent);
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
		_simpleRiffle(continue_with_google);
		_simpleRiffle(signup);
		_rippleRoundStroke(signin_with_password, "#176b87", "#eeeeee", 100, 100, "#176b87");
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
	
	
	public void _dt() {
	}
	// setTheme() should be set before setContentView() so a small hack to do this in sketchware
	 @Override 
	    public void setContentView( int layoutResID) {
		if(getIntent().getBooleanExtra("dialogTheme",true)){
			supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
			setTheme(R.style.Theme_AppCompat_Light_Dialog);
			setFinishOnTouchOutside(true);
			
			//change true to false if you want to make dialog non cancellable when clicked outside
			//if you want to use this without app compat  change supportRequestWindowFeature() and setTheme() to below codes.
			/*
requestWindowFeature(Window.FEATURE_NO_TITLE);
setTheme(android.R.style.Theme_Dialog);
*/
			// Calling this allows the Activity behind this one to be seen again. Once all such Activities have been redrawn
			try {
				 	java.lang.reflect.Method getActivityOptions = Activity.class.getDeclaredMethod("getActivityOptions"); getActivityOptions.setAccessible(true);
				 Object options = getActivityOptions.invoke(this); Class<?>[] classes = Activity.class.getDeclaredClasses(); Class<?> translucentConversionListenerClazz = null; 
				for (Class clazz : classes) { if (clazz.getSimpleName().contains("TranslucentConversionListener")) { translucentConversionListenerClazz = clazz; } } 
				java.lang.reflect.Method convertToTranslucent = Activity.class.getDeclaredMethod("convertToTranslucent", translucentConversionListenerClazz, ActivityOptions.class); convertToTranslucent.setAccessible(true); convertToTranslucent.invoke(this, null, options); } catch (Throwable t) {
			}
		}
		super.setContentView(layoutResID);  
	}
	{
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