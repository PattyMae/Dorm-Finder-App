package fastrust.dorm.finder;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.prime.arab.ware.everythingutils.*;
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
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class AdminHomeFragmentActivity extends Fragment {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	
	private LinearLayout linear1;
	private CardView cardview1;
	private CardView cardview2;
	private CardView cardview3;
	private LinearLayout linear2;
	private TextView textview1;
	private TextView total_bookings;
	private LinearLayout linear3;
	private TextView textview3;
	private TextView total_rooms_available;
	private LinearLayout linear4;
	private TextView textview5;
	private TextView total_rooms_occupied;
	
	private DatabaseReference total = _firebase.getReference("total");
	private ChildEventListener _total_child_listener;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.admin_home_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear1 = _view.findViewById(R.id.linear1);
		cardview1 = _view.findViewById(R.id.cardview1);
		cardview2 = _view.findViewById(R.id.cardview2);
		cardview3 = _view.findViewById(R.id.cardview3);
		linear2 = _view.findViewById(R.id.linear2);
		textview1 = _view.findViewById(R.id.textview1);
		total_bookings = _view.findViewById(R.id.total_bookings);
		linear3 = _view.findViewById(R.id.linear3);
		textview3 = _view.findViewById(R.id.textview3);
		total_rooms_available = _view.findViewById(R.id.total_rooms_available);
		linear4 = _view.findViewById(R.id.linear4);
		textview5 = _view.findViewById(R.id.textview5);
		total_rooms_occupied = _view.findViewById(R.id.total_rooms_occupied);
		
		_total_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("bookings")) {
					total_bookings.setText(_childValue.get("count").toString());
				}
				if (_childKey.equals("rooms available")) {
					total_rooms_available.setText(_childValue.get("count").toString());
				}
				if (_childKey.equals("rooms occupied")) {
					total_rooms_occupied.setText(_childValue.get("count").toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("bookings")) {
					total_bookings.setText(_childValue.get("count").toString());
				}
				if (_childKey.equals("rooms available")) {
					total_rooms_available.setText(_childValue.get("count").toString());
				}
				if (_childKey.equals("rooms occupied")) {
					total_rooms_occupied.setText(_childValue.get("count").toString());
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
	}
	
	private void initializeLogic() {
		total.addChildEventListener(_total_child_listener);
	}
	
}