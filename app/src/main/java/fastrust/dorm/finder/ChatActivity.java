package fastrust.dorm.finder;

import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import androidx.core.widget.NestedScrollView;
import androidx.cardview.widget.CardView;

public class ChatActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private String getPost = "";
	private String chatroom = "";
	private String chatcopy = "";
	private String fullname = "";
	private String ownerProfile = "";
	private String myProfile = "";
	private String ownerName = "";
	private String myName = "";
	private String str = "";
	private String str1 = "";
	private HashMap<String, Object> profile = new HashMap<>();
	private String str2 = "";
	private String uid = "";
	private String photo1 = "";
	private String photo5 = "";
	private String photo9 = "";
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> chat1_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> link_listmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout top;
	private LinearLayout body;
	private LinearLayout bottom;
	private ImageView back;
	private TextView chat_name;
	private LinearLayout link_layout;
	private ListView listview1;
	private CardView cardview4;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private ImageView photo;
	private TextView title;
	private TextView location;
	private TextView price;
	private TextView textview4;
	private CardView cardview1;
	private LinearLayout linear5;
	private CardView cardview2;
	private LinearLayout linear6;
	private EditText edittext1;
	private ImageView send_icon;
	
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
	private DatabaseReference getpost = _firebase.getReference("getpost");
	private ChildEventListener _getpost_child_listener;
	private DatabaseReference chat1 = _firebase.getReference("+chatroom+");
	private ChildEventListener _chat1_child_listener;
	private DatabaseReference chat2 = _firebase.getReference("+chatcopy+");
	private ChildEventListener _chat2_child_listener;
	private Calendar cal = Calendar.getInstance();
	private DatabaseReference message = _firebase.getReference("message");
	private ChildEventListener _message_child_listener;
	private DatabaseReference user1 = _firebase.getReference("users");
	private ChildEventListener _user1_child_listener;
	private DatabaseReference post = _firebase.getReference("post");
	private ChildEventListener _post_child_listener;
	private Intent intent = new Intent();
	private AlertDialog.Builder dialog;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.chat);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		top = findViewById(R.id.top);
		body = findViewById(R.id.body);
		bottom = findViewById(R.id.bottom);
		back = findViewById(R.id.back);
		chat_name = findViewById(R.id.chat_name);
		link_layout = findViewById(R.id.link_layout);
		listview1 = findViewById(R.id.listview1);
		cardview4 = findViewById(R.id.cardview4);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		photo = findViewById(R.id.photo);
		title = findViewById(R.id.title);
		location = findViewById(R.id.location);
		price = findViewById(R.id.price);
		textview4 = findViewById(R.id.textview4);
		cardview1 = findViewById(R.id.cardview1);
		linear5 = findViewById(R.id.linear5);
		cardview2 = findViewById(R.id.cardview2);
		linear6 = findViewById(R.id.linear6);
		edittext1 = findViewById(R.id.edittext1);
		send_icon = findViewById(R.id.send_icon);
		fauth = FirebaseAuth.getInstance();
		dialog = new AlertDialog.Builder(this);
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		link_layout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), DormitoryDetailsActivity.class);
				intent.putExtra("getPost", getIntent().getStringExtra("getPost"));
				intent.putExtra("uid", uid);
				intent.putExtra("photo1", photo1);
				intent.putExtra("photo5", photo5);
				intent.putExtra("photo9", photo9);
				startActivity(intent);
			}
		});
		
		send_icon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Write a message");
				}
				else {
					cal = Calendar.getInstance();
					map = new HashMap<>();
					map.put("message", edittext1.getText().toString());
					map.put("date", new SimpleDateFormat("hh:mm").format(cal.getTime()));
					map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					map.put("getPost", getPost);
					chat1.child(getPost).updateChildren(map);
					chat2.child(getPost).updateChildren(map);
					map = new HashMap<>();
					map.put("uid", getIntent().getStringExtra("seconduser"));
					map.put("message", edittext1.getText().toString());
					map.put("myuid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					map.put("date", String.valueOf((long)(cal.getTimeInMillis())));
					map.put("getPost", getIntent().getStringExtra("getPost"));
					map.put("seen", "true");
					message.child(getIntent().getStringExtra("firstuser").concat("/".concat(getIntent().getStringExtra("seconduser")))).updateChildren(map);
					map = new HashMap<>();
					map.put("uid", getIntent().getStringExtra("firstuser"));
					map.put("message", edittext1.getText().toString());
					map.put("myuid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					map.put("date", String.valueOf((long)(cal.getTimeInMillis())));
					map.put("getPost", getIntent().getStringExtra("getPost"));
					map.put("seen", "false");
					message.child(getIntent().getStringExtra("seconduser").concat("/".concat(getIntent().getStringExtra("firstuser")))).updateChildren(map);
					listview1.setTranscriptMode(ListView.TRANSCRIPT_MODE_NORMAL);
					listview1.setStackFromBottom(true);
					edittext1.setText("");
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
					myProfile = _childValue.get("profile").toString();
					myName = _childValue.get("fullname").toString();
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
		
		_chat1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				chat1.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						chat1_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								chat1_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(chat1_listmap));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
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
				chat1.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						chat1_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								chat1_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(chat1_listmap));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
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
				chat1.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						chat1_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								chat1_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(chat1_listmap));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		chat1.addChildEventListener(_chat1_child_listener);
		
		_chat2_child_listener = new ChildEventListener() {
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
		chat2.addChildEventListener(_chat2_child_listener);
		
		_message_child_listener = new ChildEventListener() {
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
		message.addChildEventListener(_message_child_listener);
		
		_user1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("seconduser"))) {
					chat_name.setText(_childValue.get("fullname").toString());
					ownerProfile = _childValue.get("profile").toString();
					ownerName = _childValue.get("fullname").toString();
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
		user1.addChildEventListener(_user1_child_listener);
		
		_post_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				post.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						link_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								link_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (_childValue.containsKey("getPost")) {
							if (_childValue.get("getPost").toString().equals(getIntent().getStringExtra("getPost"))) {
								link_layout.setVisibility(View.VISIBLE);
								Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo1").toString())).into(photo);
								title.setText(_childValue.get("dormitory name").toString());
								location.setText(_childValue.get("street").toString().concat(" ".concat(_childValue.get("barangay").toString())));
								price.setText(_childValue.get("rates monthly price").toString());
								uid = _childValue.get("dormitory uid").toString();
								photo1 = _childValue.get("photo1").toString();
								photo5 = _childValue.get("photo5").toString();
								photo9 = _childValue.get("photo9").toString();
								_setSingleLine(location, true);
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
		_ImageColor(send_icon, "#176b87");
		_simpleRiffle(back);
		_setSingleLine(chat_name, true);
		androidx.core.view.ViewCompat.setNestedScrollingEnabled(listview1, true);
		getPost = getpost.push().getKey();
		users.addChildEventListener(_users_child_listener);
		user1.addChildEventListener(_user1_child_listener);
		listview1.setTranscriptMode(ListView.TRANSCRIPT_MODE_NORMAL);
		listview1.setStackFromBottom(true);
		chat1.removeEventListener(_chat1_child_listener);
		chat2.removeEventListener(_chat2_child_listener);
		chatroom = "chat/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(getIntent().getStringExtra("seconduser"))));
		chatcopy = "chat/".concat(getIntent().getStringExtra("seconduser").concat("/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid())));
		chat1 =
		_firebase.getReference(chatroom);
		chat2 =
		_firebase.getReference(chatcopy);
		chat1.addChildEventListener(_chat1_child_listener);
		chat2.addChildEventListener(_chat2_child_listener);
		if (getIntent().getStringExtra("getPost").equals("")) {
			link_layout.setVisibility(View.GONE);
		}
		else {
			if (getIntent().getStringExtra("getPost").equals(getIntent().getStringExtra("getPost"))) {
				post.addChildEventListener(_post_child_listener);
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
	
	
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	
	public void _simpleRiffle(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
		_view.setBackground(GA8PO9);
	}
	
	
	public void _setSingleLine(final TextView _view, final boolean _bool) {
		_view.setSingleLine(_bool);
	}
	
	
	public void _setRadiusCorner(final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.convo_post, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final TextView message = _view.findViewById(R.id.message);
			final TextView date = _view.findViewById(R.id.date);
			
			date.setTextSize((int)8);
			_simpleRiffle(linear2);
			if (_data.get((int)_position).get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
				linear1.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
				linear3.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
				_setRadiusCorner(linear2, 20, 0, "#176b87");
				message.setTextColor(0xFFFFFFFF);
				date.setTextColor(0xFFCFD8DC);
			}
			else {
				linear1.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
				linear3.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
				_setRadiusCorner(linear2, 20, 0, "#eeeeee");
				message.setTextColor(0xFF176B87);
				date.setTextColor(0xFF607D8B);
			}
			if (_data.get((int)_position).containsKey("message")) {
				message.setText(_data.get((int)_position).get("message").toString());
			}
			else {
				
			}
			if (_data.get((int)_position).containsKey("date")) {
				date.setText(_data.get((int)_position).get("date").toString());
			}
			else {
				
			}
			linear2.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					if (_data.get((int)_position).get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
						PopupMenu popup = new PopupMenu(ChatActivity.this, linear2);
						
						Menu menu = popup.getMenu();
						menu.add("Copy");
						menu.add("Delete");
						 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "Copy":
									((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _data.get((int)_position).get("message").toString()));
									SketchwareUtil.showMessage(getApplicationContext(), "Copied");
									return true; case "Delete":
									dialog.setMessage("Delete message? It cannot be undone.");
									dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											chat1.child(_data.get((int)_position).get("getPost").toString()).removeValue();
											chat2.child(_data.get((int)_position).get("getPost").toString()).removeValue();
											SketchwareUtil.showMessage(getApplicationContext(), "Deleted");
										}
									});
									dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											
										}
									});
									dialog.create().show();
									return true; default: return false; } } }); popup.show();
					}
					else {
						PopupMenu popup = new PopupMenu(ChatActivity.this, linear2);
						
						Menu menu = popup.getMenu();
						menu.add("Copy");
						 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "Copy":
									((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _data.get((int)_position).get("message").toString()));
									SketchwareUtil.showMessage(getApplicationContext(), "Copied");
									return true; default: return false; } } }); popup.show();
					}
					return true;
				}
			});
			
			return _view;
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