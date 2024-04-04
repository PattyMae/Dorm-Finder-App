package fastrust.dorm.finder;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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
import java.io.InputStream;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class SigninSetupActivity extends AppCompatActivity {
	
	public final int REQ_CD_FILE = 101;
	public final int REQ_CD_VALID = 102;
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private String img = "";
	private HashMap<String, Object> map = new HashMap<>();
	private boolean isVisible = false;
	private String img2 = "";
	private String getPost = "";
	private String validID = "";
	private String validID_done = "";
	private String profilePath = "";
	private String validIDPath = "";
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private CardView cardview2;
	private CardView cardview11;
	private CardView cardview12;
	private CardView cardview4;
	private CardView cardview5;
	private CardView cardview3;
	private CardView cardview6;
	private CardView cardview7;
	private CardView cardview8;
	private ImageView back;
	private TextView textview1;
	private LinearLayout linear4;
	private CardView cardview10;
	private CardView cardview1;
	private ImageView profile_photo;
	private ImageView select_profile;
	private LinearLayout linear5;
	private EditText firstname;
	private LinearLayout linear11;
	private EditText middle_name;
	private LinearLayout linear12;
	private EditText lastname;
	private LinearLayout linear7;
	private EditText birthday;
	private ImageView select_calendar;
	private LinearLayout linear8;
	private EditText email;
	private ImageView email_icon;
	private LinearLayout linear6;
	private EditText photo_paste;
	private ImageView upload_id_option;
	private LinearLayout linear9;
	private ImageView imageview1;
	private TextView textview2;
	private EditText contact_num;
	private LinearLayout linear10;
	private EditText gender;
	private ImageView select_gender;
	private LinearLayout continue_button;
	private TextView textview3;
	
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
	private Intent file = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent intent = new Intent();
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private StorageReference profile = _firebase_storage.getReference("profile");
	private OnCompleteListener<Uri> _profile_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _profile_download_success_listener;
	private OnSuccessListener _profile_delete_success_listener;
	private OnProgressListener _profile_upload_progress_listener;
	private OnProgressListener _profile_download_progress_listener;
	private OnFailureListener _profile_failure_listener;
	
	private SharedPreferences data;
	private DatabaseReference notification = _firebase.getReference("notification");
	private ChildEventListener _notification_child_listener;
	private Calendar cal = Calendar.getInstance();
	private StorageReference valid_id = _firebase_storage.getReference("valid id");
	private OnCompleteListener<Uri> _valid_id_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _valid_id_download_success_listener;
	private OnSuccessListener _valid_id_delete_success_listener;
	private OnProgressListener _valid_id_upload_progress_listener;
	private OnProgressListener _valid_id_download_progress_listener;
	private OnFailureListener _valid_id_failure_listener;
	
	private Intent valid = new Intent(Intent.ACTION_GET_CONTENT);
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.signin_setup);
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
		cardview2 = findViewById(R.id.cardview2);
		cardview11 = findViewById(R.id.cardview11);
		cardview12 = findViewById(R.id.cardview12);
		cardview4 = findViewById(R.id.cardview4);
		cardview5 = findViewById(R.id.cardview5);
		cardview3 = findViewById(R.id.cardview3);
		cardview6 = findViewById(R.id.cardview6);
		cardview7 = findViewById(R.id.cardview7);
		cardview8 = findViewById(R.id.cardview8);
		back = findViewById(R.id.back);
		textview1 = findViewById(R.id.textview1);
		linear4 = findViewById(R.id.linear4);
		cardview10 = findViewById(R.id.cardview10);
		cardview1 = findViewById(R.id.cardview1);
		profile_photo = findViewById(R.id.profile_photo);
		select_profile = findViewById(R.id.select_profile);
		linear5 = findViewById(R.id.linear5);
		firstname = findViewById(R.id.firstname);
		linear11 = findViewById(R.id.linear11);
		middle_name = findViewById(R.id.middle_name);
		linear12 = findViewById(R.id.linear12);
		lastname = findViewById(R.id.lastname);
		linear7 = findViewById(R.id.linear7);
		birthday = findViewById(R.id.birthday);
		select_calendar = findViewById(R.id.select_calendar);
		linear8 = findViewById(R.id.linear8);
		email = findViewById(R.id.email);
		email_icon = findViewById(R.id.email_icon);
		linear6 = findViewById(R.id.linear6);
		photo_paste = findViewById(R.id.photo_paste);
		upload_id_option = findViewById(R.id.upload_id_option);
		linear9 = findViewById(R.id.linear9);
		imageview1 = findViewById(R.id.imageview1);
		textview2 = findViewById(R.id.textview2);
		contact_num = findViewById(R.id.contact_num);
		linear10 = findViewById(R.id.linear10);
		gender = findViewById(R.id.gender);
		select_gender = findViewById(R.id.select_gender);
		continue_button = findViewById(R.id.continue_button);
		textview3 = findViewById(R.id.textview3);
		fauth = FirebaseAuth.getInstance();
		file.setType("image/*");
		file.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		network = new RequestNetwork(this);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		valid.setType("image/*");
		valid.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		select_profile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(file, REQ_CD_FILE);
			}
		});
		
		select_calendar.setOnClickListener(new View.OnClickListener() {
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
		
		email.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (0 < email.getText().toString().length()) {
					if (_charSeq.length() > 0) {
						_ImageColor(email_icon, "#176b87");
					}
				}
				else {
					_ImageColor(email_icon, "#e0e0e0");
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		upload_id_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(valid, REQ_CD_VALID);
			}
		});
		
		select_gender.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(SigninSetupActivity.this, select_gender);
				
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
		
		continue_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (firstname.getText().toString().equals("") || (lastname.getText().toString().equals("") || (photo_paste.getText().toString().equals("") || (birthday.getText().toString().equals("") || (email.getText().toString().equals("") || (contact_num.getText().toString().equals("") || gender.getText().toString().equals(""))))))) {
					if (firstname.getText().toString().equals("")) {
						((EditText)firstname).setError("Fullname is empty");
					}
					if (lastname.getText().toString().equals("")) {
						((EditText)lastname).setError("Fullname is empty");
					}
					if (photo_paste.getText().toString().equals("")) {
						((EditText)photo_paste).setError("Valid ID is empty");
					}
					if (birthday.getText().toString().equals("")) {
						((EditText)birthday).setError("Date of Birth is empty");
					}
					if (email.getText().toString().equals("")) {
						((EditText)email).setError("Email is empty");
					}
					if (contact_num.getText().toString().equals("")) {
						((EditText)contact_num).setError("Phone Number is empty");
					}
					if (gender.getText().toString().equals("")) {
						((EditText)gender).setError("Gender is empty");
					}
				}
				else {
					if (img.equals("")) {
						
					}
					else {
						_telegramLoaderDialog(true);
						network.startRequestNetwork(RequestNetworkController.GET, "https://dorm-finder-df3f2-default-rtdb.firebaseio.com/", "Error", _network_request_listener);
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
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				valid_id.child(firstname.getText().toString().concat(" ".concat(middle_name.getText().toString().concat(" ".concat(lastname.getText().toString()))))).putFile(Uri.fromFile(new File(validID))).addOnFailureListener(_valid_id_failure_listener).addOnProgressListener(_valid_id_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return valid_id.child(firstname.getText().toString().concat(" ".concat(middle_name.getText().toString().concat(" ".concat(lastname.getText().toString()))))).getDownloadUrl();
					}}).addOnCompleteListener(_valid_id_upload_success_listener);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
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
				img2 = _downloadUrl;
				fauth.createUserWithEmailAndPassword(email.getText().toString(), getIntent().getStringExtra("pass")).addOnCompleteListener(SigninSetupActivity.this, _fauth_create_user_listener);
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
		
		_valid_id_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_valid_id_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_valid_id_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				validID_done = _downloadUrl;
				profile.child(firstname.getText().toString().concat(" ".concat(middle_name.getText().toString().concat(" ".concat(lastname.getText().toString()))))).putFile(Uri.fromFile(new File(img))).addOnFailureListener(_profile_failure_listener).addOnProgressListener(_profile_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return profile.child(firstname.getText().toString().concat(" ".concat(middle_name.getText().toString().concat(" ".concat(lastname.getText().toString()))))).getDownloadUrl();
					}}).addOnCompleteListener(_profile_upload_success_listener);
			}
		};
		
		_valid_id_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_valid_id_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_valid_id_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
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
				if (_success) {
					map = new HashMap<>();
					map.put("profile", img2);
					map.put("firstname", firstname.getText().toString());
					map.put("middle name", middle_name.getText().toString());
					map.put("lastname", lastname.getText().toString());
					map.put("valid id", validID_done);
					map.put("fullname", firstname.getText().toString().concat(" ".concat(lastname.getText().toString())));
					map.put("birthday", birthday.getText().toString());
					map.put("email", email.getText().toString());
					map.put("phone", contact_num.getText().toString());
					map.put("gender", gender.getText().toString());
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
					intent.setClass(getApplicationContext(), MainActivity.class);
					startActivity(intent);
					data.edit().putString("login", "true").commit();
					_telegramLoaderDialog(false);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
					_telegramLoaderDialog(false);
				}
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
		_rippleRoundStroke(continue_button, "#176b87", "#eeeeee", 100, 100, "#176b87");
		_ImageColor(select_profile, "#ffffff");
		_ImageColor(select_calendar, "#e0e0e0");
		_ImageColor(email_icon, "#e0e0e0");
		_ImageColor(select_gender, "#e0e0e0");
		_ImageColor(upload_id_option, "#e0e0e0");
		_riffleEffect("#f5f5f5", back);
		_riffleEffect("#f5f5f5", upload_id_option);
		firstname.setSingleLine(true);
		middle_name.setSingleLine(true);
		lastname.setSingleLine(true);
		photo_paste.setSingleLine(true);
		birthday.setSingleLine(true);
		email.setSingleLine(true);
		contact_num.setSingleLine(true);
		gender.setSingleLine(true);
		firstname.setEnabled(false);
		middle_name.setEnabled(false);
		lastname.setEnabled(false);
		photo_paste.setEnabled(false);
		birthday.setEnabled(false);
		email.setEnabled(false);
		contact_num.setEnabled(false);
		gender.setEnabled(false);
		continue_button.setEnabled(false);
		select_calendar.setEnabled(false);
		select_gender.setEnabled(false);
		upload_id_option.setEnabled(false);
		email.setText(getIntent().getStringExtra("email"));
		profilePath = "/storage/emulated/0/Download/profile.png";
		validIDPath = "/storage/emulated/0/Download/validID.png";
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
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), profilePath, 480);
				img = profilePath;
				profile_photo.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img, 1024, 1024));
				firstname.setEnabled(true);
				middle_name.setEnabled(true);
				lastname.setEnabled(true);
				photo_paste.setEnabled(true);
				email.setEnabled(true);
				contact_num.setEnabled(true);
				continue_button.setEnabled(true);
				select_calendar.setEnabled(true);
				select_gender.setEnabled(true);
				upload_id_option.setEnabled(true);
				_ImageColor(select_calendar, "#176b87");
				_ImageColor(email_icon, "#176b87");
				_ImageColor(select_gender, "#176b87");
				_ImageColor(upload_id_option, "#176b87");
			}
			else {
				
			}
			break;
			
			case REQ_CD_VALID:
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
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), validIDPath, 480);
				validID = validIDPath;
				photo_paste.setText(validID);
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
	
	
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
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
	
	
	public void _extra() {
	}
	
	public void showDatePicker(DatePickerDialog.OnDateSetListener listener) {
		DatePickerDialog datePicker = new DatePickerDialog(SigninSetupActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth);
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
	
	
	public void _riffleEffect(final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)}); android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null); _view.setBackground(ripdr);
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