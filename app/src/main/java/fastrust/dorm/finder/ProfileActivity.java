package fastrust.dorm.finder;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
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
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.prime.arab.ware.everythingutils.*;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.shobhitpuri.custombuttons.*;
import java.io.*;
import java.io.File;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class ProfileActivity extends AppCompatActivity {
	
	public final int REQ_CD_FILE = 101;
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private boolean isVisible = false;
	private String img = "";
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear12;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private CardView cardview3;
	private ImageView back;
	private TextView textview3;
	private LinearLayout linear11;
	private CardView cardview1;
	private CardView cardview2;
	private ImageView profile_photo;
	private ImageView change_profile;
	private EditText firstname;
	private EditText middle_name;
	private EditText lastname;
	private EditText birthday;
	private ImageView imageview2;
	private EditText gender;
	private ImageView imageview3;
	private TextView email;
	private ImageView imageview4;
	private ImageView imageview5;
	private TextView textview1;
	private EditText mobile;
	private TextView country;
	private ImageView country_icon;
	private LinearLayout update_button;
	private TextView textview2;
	
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
	private StorageReference profile = _firebase_storage.getReference("profile");
	private OnCompleteListener<Uri> _profile_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _profile_download_success_listener;
	private OnSuccessListener _profile_delete_success_listener;
	private OnProgressListener _profile_upload_progress_listener;
	private OnProgressListener _profile_download_progress_listener;
	private OnFailureListener _profile_failure_listener;
	
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private Intent file = new Intent(Intent.ACTION_GET_CONTENT);
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profile);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		linear12 = findViewById(R.id.linear12);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		cardview3 = findViewById(R.id.cardview3);
		back = findViewById(R.id.back);
		textview3 = findViewById(R.id.textview3);
		linear11 = findViewById(R.id.linear11);
		cardview1 = findViewById(R.id.cardview1);
		cardview2 = findViewById(R.id.cardview2);
		profile_photo = findViewById(R.id.profile_photo);
		change_profile = findViewById(R.id.change_profile);
		firstname = findViewById(R.id.firstname);
		middle_name = findViewById(R.id.middle_name);
		lastname = findViewById(R.id.lastname);
		birthday = findViewById(R.id.birthday);
		imageview2 = findViewById(R.id.imageview2);
		gender = findViewById(R.id.gender);
		imageview3 = findViewById(R.id.imageview3);
		email = findViewById(R.id.email);
		imageview4 = findViewById(R.id.imageview4);
		imageview5 = findViewById(R.id.imageview5);
		textview1 = findViewById(R.id.textview1);
		mobile = findViewById(R.id.mobile);
		country = findViewById(R.id.country);
		country_icon = findViewById(R.id.country_icon);
		update_button = findViewById(R.id.update_button);
		textview2 = findViewById(R.id.textview2);
		fauth = FirebaseAuth.getInstance();
		network = new RequestNetwork(this);
		file.setType("image/*");
		file.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		change_profile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(file, REQ_CD_FILE);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int year, int month, int day) {
						month++;
						//Write here your code, on date picked
						//Sample action is given with an EditText
						birthday.setText(day + "/" + month + "/" + year);
					}
				};
				showDatePicker(datePickerListener);
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(ProfileActivity.this, imageview3);
				
				Menu menu = popup.getMenu();
				menu.add("Male");
				menu.add("Female");
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "Male":
							gender.setText("Male");
							return true; case "Female":
							gender.setText("Female");
							return true; default: return false; } } }); popup.show();
			}
		});
		
		update_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (firstname.getText().toString().equals("") || (middle_name.getText().toString().equals("") || (lastname.getText().toString().equals("") || (birthday.getText().toString().equals("") || (email.getText().toString().equals("") || (mobile.getText().toString().equals("") || gender.getText().toString().equals(""))))))) {
					if (firstname.getText().toString().equals("")) {
						((EditText)firstname).setError("First name is empty");
					}
					if (middle_name.getText().toString().equals("")) {
						((EditText)middle_name).setError("Middle name is empty");
					}
					if (lastname.getText().toString().equals("")) {
						((EditText)lastname).setError("Last name is empty");
					}
					if (birthday.getText().toString().equals("")) {
						((EditText)birthday).setError("Date of Birth is empty");
					}
					if (email.getText().toString().equals("")) {
						((EditText)email).setError("Email is empty");
					}
					if (mobile.getText().toString().equals("")) {
						((EditText)mobile).setError("Phone Number is empty");
					}
					if (gender.getText().toString().equals("")) {
						((EditText)gender).setError("Gender is empty");
					}
				}
				else {
					_telegramLoaderDialog(true);
					network.startRequestNetwork(RequestNetworkController.GET, "https://dorm-finder-df3f2-default-rtdb.firebaseio.com/", "Error", _network_request_listener);
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
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("profile").toString())).into(profile_photo);
					firstname.setText(_childValue.get("firstname").toString());
					middle_name.setText(_childValue.get("middle name").toString());
					lastname.setText(_childValue.get("lastname").toString());
					birthday.setText(_childValue.get("birthday").toString());
					gender.setText(_childValue.get("gender").toString());
					email.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
					mobile.setText(_childValue.get("phone").toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("profile").toString())).into(profile_photo);
					firstname.setText(_childValue.get("firstname").toString());
					middle_name.setText(_childValue.get("middle name").toString());
					lastname.setText(_childValue.get("lastname").toString());
					birthday.setText(_childValue.get("birthday").toString());
					gender.setText(_childValue.get("gender").toString());
					email.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
					mobile.setText(_childValue.get("phone").toString());
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
		
		_profile_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_profile_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_profile_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				map = new HashMap<>();
				map.put("profile", _downloadUrl);
				users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
			}
		};
		
		_profile_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_profile_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_profile_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				map = new HashMap<>();
				map.put("firstname", firstname.getText().toString());
				map.put("middle name", middle_name.getText().toString());
				map.put("lastname", lastname.getText().toString());
				map.put("birthday", birthday.getText().toString());
				map.put("email", email.getText().toString());
				map.put("phone", mobile.getText().toString());
				map.put("gender", gender.getText().toString());
				map.put("userKey", FirebaseAuth.getInstance().getCurrentUser().getUid());
				users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
				_telegramLoaderDialog(false);
				SketchwareUtil.showMessage(getApplicationContext(), "Profile is updated");
				finish();
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
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
		_ImageColor(change_profile, "#ffffff");
		_ImageColor(country_icon, "#eeeeee");
		_rippleRoundStroke(update_button, "#176b87", "#eeeeee", 100, 100, "#176b87");
		_setSingleLine(firstname, true);
		_setSingleLine(middle_name, true);
		_setSingleLine(lastname, true);
		_setSingleLine(birthday, true);
		_setSingleLine(mobile, true);
		_setSingleLine(email, true);
		_setSingleLine(country, true);
		_setSingleLine(gender, true);
		users.addChildEventListener(_users_child_listener);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FILE:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				img = _filePath.get((int)(0));
				profile_photo.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img, 1024, 1024));
				profile.child(img).putFile(Uri.fromFile(new File(img))).addOnFailureListener(_profile_failure_listener).addOnProgressListener(_profile_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return profile.child(img).getDownloadUrl();
					}}).addOnCompleteListener(_profile_upload_success_listener);
			}
			else {
				
			}
			break;
			default:
			break;
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
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#eeeeee")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
		_view.setBackground(GA8PO9);
	}
	
	
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	
	public void _setSingleLine(final TextView _view, final boolean _bool) {
		_view.setSingleLine(_bool);
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
	
	
	public void _extra() {
	}
	
	public void showDatePicker(DatePickerDialog.OnDateSetListener listener) {
		DatePickerDialog datePicker = new DatePickerDialog(ProfileActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth);
		datePicker.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
		
		datePicker.setOnDateSetListener(listener);
		datePicker.show();
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