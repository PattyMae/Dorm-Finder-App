package fastrust.dorm.finder;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
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
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
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
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import androidx.core.widget.NestedScrollView;
import androidx.cardview.widget.CardView;

public class AdminDormitoryFragmentActivity extends Fragment {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private NestedScrollView vscroll1;
	private LinearLayout linear2;
	private CardView cardview1;
	private RecyclerView recyclerview1;
	private TextView add_dormotory;
	
	private DatabaseReference post = _firebase.getReference("post");
	private ChildEventListener _post_child_listener;
	private Intent intent = new Intent();
	private AlertDialog.Builder dialog;
	private StorageReference post_storage = _firebase_storage.getReference("post");
	private OnCompleteListener<Uri> _post_storage_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _post_storage_download_success_listener;
	private OnSuccessListener _post_storage_delete_success_listener;
	private OnProgressListener _post_storage_upload_progress_listener;
	private OnProgressListener _post_storage_download_progress_listener;
	private OnFailureListener _post_storage_failure_listener;
	
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
	
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.admin_dormitory_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear1 = _view.findViewById(R.id.linear1);
		vscroll1 = _view.findViewById(R.id.vscroll1);
		linear2 = _view.findViewById(R.id.linear2);
		cardview1 = _view.findViewById(R.id.cardview1);
		recyclerview1 = _view.findViewById(R.id.recyclerview1);
		add_dormotory = _view.findViewById(R.id.add_dormotory);
		dialog = new AlertDialog.Builder(getActivity());
		fauth = FirebaseAuth.getInstance();
		
		add_dormotory.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getContext().getApplicationContext(), AdminHomepageActivity.class);
				intent.putExtra("edit", "");
				startActivity(intent);
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
						recyclerview1.setAdapter(new Recyclerview1Adapter(listmap));
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
						recyclerview1.setAdapter(new Recyclerview1Adapter(listmap));
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
						recyclerview1.setAdapter(new Recyclerview1Adapter(listmap));
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
		post.addChildEventListener(_post_child_listener);
		
		_post_storage_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post_storage_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post_storage_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_post_storage_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_post_storage_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_post_storage_failure_listener = new OnFailureListener() {
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
		recyclerview1.setLayoutManager(new LinearLayoutManager(getContext()));
	}
	
	public void _simpleRiffle(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
		_view.setBackground(GA8PO9);
	}
	
	
	public void _riffleEffect(final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)}); android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null); _view.setBackground(ripdr);
	}
	
	
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.add_dorm_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final androidx.cardview.widget.CardView cardview3 = _view.findViewById(R.id.cardview3);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final ImageView dropdown = _view.findViewById(R.id.dropdown);
			final ImageView photo = _view.findViewById(R.id.photo);
			final TextView title = _view.findViewById(R.id.title);
			final TextView location = _view.findViewById(R.id.location);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final LinearLayout line1 = _view.findViewById(R.id.line1);
			final LinearLayout drop_page = _view.findViewById(R.id.drop_page);
			final TextView view = _view.findViewById(R.id.view);
			final TextView edit = _view.findViewById(R.id.edit);
			final TextView delete = _view.findViewById(R.id.delete);
			
			_ImageColor(dropdown, "#176b87");
			_simpleRiffle(linear5);
			_simpleRiffle(view);
			_simpleRiffle(edit);
			_simpleRiffle(delete);
			drop_page.setVisibility(View.GONE);
			if (_data.get((int)(_data.size() - 1) - _position).get("dormitory uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
				linear6.setVisibility(View.VISIBLE);
			}
			else {
				linear6.setVisibility(View.GONE);
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("photo1")) {
				Glide.with(getContext().getApplicationContext()).load(Uri.parse(_data.get((int)(_data.size() - 1) - _position).get("photo1").toString())).into(photo);
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("dormitory name")) {
				title.setText(_data.get((int)(_data.size() - 1) - _position).get("dormitory name").toString());
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("street")) {
				location.setText(_data.get((int)(_data.size() - 1) - _position).get("street").toString().concat(" ".concat(_data.get((int)(_data.size() - 1) - _position).get("barangay").toString().concat(" ".concat(_data.get((int)(_data.size() - 1) - _position).get("city").toString().concat(" ".concat(_data.get((int)(_data.size() - 1) - _position).get("province").toString())))))));
			}
			else {
				
			}
			linear5.setOnClickListener(new View.OnClickListener() {
								@Override
								public void onClick(View _view) {
										if (drop_page.isEnabled()) {
												drop_page.setVisibility(View.GONE);
												dropdown.setImageResource(R.drawable.down);
												drop_page.setEnabled(false);
										}
										else {
												drop_page.setVisibility(View.VISIBLE);
												dropdown.setImageResource(R.drawable.upp);
												drop_page.setEnabled(true);
										}
								}
						});
						drop_page.setVisibility(View.GONE);
						dropdown.setImageResource(R.drawable.down);
						drop_page.setEnabled(false);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getContext().getApplicationContext(), AdminHomepageActivity.class);
					intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
					intent.putExtra("edit", "false");
					startActivity(intent);
				}
			});
			edit.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getContext().getApplicationContext(), AdminHomepageActivity.class);
					intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
					intent.putExtra("edit", "true");
					startActivity(intent);
				}
			});
			delete.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					dialog.setTitle("Delete");
					dialog.setMessage("Are you sure tou want to delete this dormitory?");
					dialog.setPositiveButton("Yes, delete it", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							post.child(_data.get((int)(_data.size() - 1) - _position).get("getPost").toString()).removeValue();
							_firebase_storage.getReferenceFromUrl(_data.get((int)(_data.size() - 1) - _position).get("photo1").toString()).delete().addOnSuccessListener(_post_storage_delete_success_listener).addOnFailureListener(_post_storage_failure_listener);
							_firebase_storage.getReferenceFromUrl(_data.get((int)(_data.size() - 1) - _position).get("photo2").toString()).delete().addOnSuccessListener(_post_storage_delete_success_listener).addOnFailureListener(_post_storage_failure_listener);
							_firebase_storage.getReferenceFromUrl(_data.get((int)(_data.size() - 1) - _position).get("photo3").toString()).delete().addOnSuccessListener(_post_storage_delete_success_listener).addOnFailureListener(_post_storage_failure_listener);
							_firebase_storage.getReferenceFromUrl(_data.get((int)(_data.size() - 1) - _position).get("photo4").toString()).delete().addOnSuccessListener(_post_storage_delete_success_listener).addOnFailureListener(_post_storage_failure_listener);
							SketchwareUtil.showMessage(getContext().getApplicationContext(), "Deleted");
						}
					});
					dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
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
}