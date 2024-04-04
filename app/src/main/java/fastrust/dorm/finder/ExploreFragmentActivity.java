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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.FirebaseApp;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class ExploreFragmentActivity extends Fragment {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double n = 0;
	private double length = 0;
	private HashMap<String, Object> map = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> post_data_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> filter_listmap = new ArrayList<>();
	
	private LinearLayout bg;
	private LinearLayout linear1;
	private RecyclerView recyclerview1;
	private ListView listview1;
	private MapView mapview1;
	private GoogleMapController _mapview1_controller;
	private CardView cardview1;
	private LinearLayout linear2;
	private ImageView search_icon;
	private EditText edittext1;
	private ImageView filter_icon;
	
	private DatabaseReference post = _firebase.getReference("post");
	private ChildEventListener _post_child_listener;
	private Intent intent = new Intent();
	private SharedPreferences data;
	private DatabaseReference post_data = _firebase.getReference("post");
	private ChildEventListener _post_data_child_listener;
	private DatabaseReference filter_data = _firebase.getReference("post");
	private ChildEventListener _filter_data_child_listener;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.explore_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		bg = _view.findViewById(R.id.bg);
		linear1 = _view.findViewById(R.id.linear1);
		recyclerview1 = _view.findViewById(R.id.recyclerview1);
		listview1 = _view.findViewById(R.id.listview1);
		mapview1 = _view.findViewById(R.id.mapview1);
		mapview1.onCreate(_savedInstanceState);
		
		cardview1 = _view.findViewById(R.id.cardview1);
		linear2 = _view.findViewById(R.id.linear2);
		search_icon = _view.findViewById(R.id.search_icon);
		edittext1 = _view.findViewById(R.id.edittext1);
		filter_icon = _view.findViewById(R.id.filter_icon);
		data = getContext().getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				edittext1.setHint(listmap.get((int)_position).get("dormitory name").toString());
				edittext1.setText("");
				listview1.setVisibility(View.GONE);
				
				mapview1.setVisibility(View.VISIBLE);
				data.edit().putString("dorm", listmap.get((int)_position).get("dormitory name").toString()).commit();
				data.edit().putString("loc", listmap.get((int)_position).get("street").toString().concat(" ".concat(listmap.get((int)_position).get("barangay").toString()))).commit();
				data.edit().putString("photo", listmap.get((int)_position).get("photo1").toString()).commit();
				data.edit().putString("getPost", listmap.get((int)_position).get("getPost").toString()).commit();
				data.edit().putString("uid", listmap.get((int)_position).get("dormitory uid").toString()).commit();
				data.edit().putString("photo1", listmap.get((int)_position).get("photo1").toString()).commit();
				data.edit().putString("photo5", listmap.get((int)_position).get("photo5").toString()).commit();
				data.edit().putString("photo9", listmap.get((int)_position).get("photo9").toString()).commit();
				_mapview1_controller.moveCamera(Double.parseDouble(listmap.get((int)_position).get("latitude").toString()), Double.parseDouble(listmap.get((int)_position).get("longitude").toString()));
				_mapview1_controller.addMarker(listmap.get((int)_position).get("dormitory name").toString(), Double.parseDouble(listmap.get((int)_position).get("latitude").toString()), Double.parseDouble(listmap.get((int)_position).get("longitude").toString()));
				_mapview1_controller.setMarkerIcon(listmap.get((int)_position).get("dormitory name").toString(), R.drawable.dorm_location);
				_mapview1_controller.zoomTo(19);
				_Hide_Keyboard(edittext1);
			}
		});
		
		_mapview1_controller = new GoogleMapController(mapview1, new OnMapReadyCallback() {
			@Override
			public void onMapReady(GoogleMap _googleMap) {
				_mapview1_controller.setGoogleMap(_googleMap);
				
			}
		});
		
		_mapview1_controller.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
			@Override
			public boolean onMarkerClick(Marker _param1) {
				final String _id = _param1.getTag().toString();
				MapBottomdialogFragmentDialogFragmentActivityN = new MapBottomdialogFragmentDialogFragmentActivity();
				MapBottomdialogFragmentDialogFragmentActivityN.show(getFragmentManager(),"1");
				data.edit().putString("dorm", data.getString("dorm", "")).commit();
				data.edit().putString("loc", data.getString("loc", "")).commit();
				data.edit().putString("photo", data.getString("photo", "")).commit();
				data.edit().putString("getPost", data.getString("getPost", "")).commit();
				return false;
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (0 < edittext1.getText().toString().length()) {
					if (_charSeq.length() > 0) {
						post.addChildEventListener(_post_child_listener);
						filter_data.addChildEventListener(_filter_data_child_listener);
						listview1.setVisibility(View.VISIBLE);
						mapview1.setVisibility(View.GONE);
					}
				}
				else {
					listview1.setVisibility(View.GONE);
					_mapview1_controller.moveCamera(Double.parseDouble(data.getString("lat", "")), Double.parseDouble(data.getString("lng", "")));
					_mapview1_controller.addMarker("My Location", Double.parseDouble(data.getString("lat", "")), Double.parseDouble(data.getString("lng", "")));
					_mapview1_controller.zoomTo(19);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		filter_icon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FilterBottomdialogFragmentDialogFragmentActivityN = new FilterBottomdialogFragmentDialogFragmentActivity();
				FilterBottomdialogFragmentDialogFragmentActivityN.show(getFragmentManager(),"1");
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
						n = listmap.size() - 1;
						length = listmap.size();
						for(int _repeat20 = 0; _repeat20 < (int)(length); _repeat20++) {
							if (listmap.get((int)n).get("dormitory name").toString().toLowerCase().contains(edittext1.getText().toString().toLowerCase()) || (listmap.get((int)n).get("street").toString().toLowerCase().contains(edittext1.getText().toString().toLowerCase()) || (listmap.get((int)n).get("barangay").toString().toLowerCase().contains(edittext1.getText().toString().toLowerCase()) || (listmap.get((int)n).get("city").toString().toLowerCase().contains(edittext1.getText().toString().toLowerCase()) || listmap.get((int)n).get("province").toString().toLowerCase().contains(edittext1.getText().toString().toLowerCase()))))) {
								listview1.setAdapter(new Listview1Adapter(listmap));
								((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
							}
							else {
								listmap.remove((int)(n));
							}
							n--;
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
		
		_post_data_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				post_data.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						post_data_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								post_data_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (_childValue.containsKey("latitude") || _childValue.containsKey("longitude")) {
							_mapview1_controller.moveCamera(Double.parseDouble(_childValue.get("latitude").toString()), Double.parseDouble(_childValue.get("longitude").toString()));
							_mapview1_controller.zoomTo(19);
							_Hide_Keyboard(edittext1);
							edittext1.setHint(_childValue.get("dormitory name").toString());
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
		post_data.addChildEventListener(_post_data_child_listener);
		
		_filter_data_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				filter_data.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						filter_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								filter_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						recyclerview1.setAdapter(new Recyclerview1Adapter(filter_listmap));
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
				filter_data.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						filter_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								filter_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						recyclerview1.setAdapter(new Recyclerview1Adapter(filter_listmap));
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
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		filter_data.addChildEventListener(_filter_data_child_listener);
	}
	
	private void initializeLogic() {
		_ImageColor(search_icon, "#bdbdbd");
		_ImageColor(filter_icon, "#2196f3");
		edittext1.setSingleLine(true);
		listview1.setVisibility(View.GONE);
		listview1.setVerticalScrollBarEnabled(false);
		_mapview1_controller.moveCamera(Double.parseDouble(data.getString("lat", "")), Double.parseDouble(data.getString("lng", "")));
		_mapview1_controller.addMarker("My Location", Double.parseDouble(data.getString("lat", "")), Double.parseDouble(data.getString("lng", "")));
		_mapview1_controller.zoomTo(19);
		_Hide_Keyboard(edittext1);
		StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
		recyclerview1.setLayoutManager(staggeredGridLayoutManager);
		recyclerview1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
		filter_data.addChildEventListener(_filter_data_child_listener);
		post_data.addChildEventListener(_post_data_child_listener);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mapview1.onDestroy();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		mapview1.onStart();
	}
	
	@Override
	public void onPause() {
		super.onPause();
		mapview1.onPause();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		mapview1.onResume();
	}
	
	@Override
	public void onStop() {
		super.onStop();
		mapview1.onStop();
	}
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	
	public void _simpleRiffle(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
		_view.setBackground(GA8PO9);
	}
	
	
	public void _lib() {
	}
	private MapBottomdialogFragmentDialogFragmentActivity MapBottomdialogFragmentDialogFragmentActivityN;
	private FragmentManager MapBottomdialogFragmentDialogFragmentActivityFM;
	public void test_MapBottomdialogFragmentDialogFragmentActivity () {
	}
	
	
	public void _Hide_Keyboard(final TextView _edittext) {
		_edittext.setEnabled(false);
		_edittext.setEnabled(true);
	}
	
	
	public void _lib1() {
	}
	private FilterBottomdialogFragmentDialogFragmentActivity FilterBottomdialogFragmentDialogFragmentActivityN;
	private FragmentManager FilterBottomdialogFragmentDialogFragmentActivityFM;
	public void test_FilterBottomdialogFragmentDialogFragmentActivity () {
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.explore_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_view.setLayoutParams(_lp);
			linear1.setVisibility(View.GONE);
			if (data.getString("category", "").equals("All")) {
				textview2.setText(_data.get((int)_position).get("dormitory name").toString());
			}
			else {
				if (_data.get((int)_position).get("type of dormitory").toString().equals(data.getString("category", ""))) {
					if (Double.parseDouble(_data.get((int)_position).get("rates monthly price").toString()) < Double.parseDouble(data.getString("maximum price range", ""))) {
						textview2.setText(_data.get((int)_position).get("dormitory name").toString());
						cardview1.setVisibility(View.VISIBLE);
					}
					else {
						cardview1.setVisibility(View.GONE);
					}
				}
				else {
					cardview1.setVisibility(View.GONE);
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
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.explore_post, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			
			_simpleRiffle(linear1);
			cardview1.setVisibility(View.GONE);
			if (_data.get((int)_position).containsKey("dormitory name")) {
				textview1.setText(_data.get((int)_position).get("dormitory name").toString());
			}
			else {
				
			}
			
			return _view;
		}
	}
}