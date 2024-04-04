package fastrust.dorm.finder;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.prime.arab.ware.everythingutils.*;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.FirebaseApp;
import com.shobhitpuri.custombuttons.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class WelcomeMapActivity extends AppCompatActivity {
	
	private double lat = 0;
	private double lng = 0;
	private double lat1 = 0;
	private double lng1 = 0;
	private String strAdd = "";
	
	private LinearLayout linear1;
	private CardView cardview1;
	private CardView cardview2;
	private LinearLayout search;
	private ImageView search_icon;
	private TextView textview1;
	private ImageView filter_icon;
	private MapView mapview1;
	private GoogleMapController _mapview1_controller;
	
	private LocationManager location;
	private LocationListener _location_location_listener;
	private SharedPreferences data;
	private AlertDialog.Builder dialog;
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.welcome_map);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
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
		cardview1 = findViewById(R.id.cardview1);
		cardview2 = findViewById(R.id.cardview2);
		search = findViewById(R.id.search);
		search_icon = findViewById(R.id.search_icon);
		textview1 = findViewById(R.id.textview1);
		filter_icon = findViewById(R.id.filter_icon);
		mapview1 = findViewById(R.id.mapview1);
		mapview1.onCreate(_savedInstanceState);
		
		location = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		
		search.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), SearchActivity.class);
				startActivity(intent);
			}
		});
		
		filter_icon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), FilterActivity.class);
				startActivity(intent);
			}
		});
		
		_mapview1_controller = new GoogleMapController(mapview1, new OnMapReadyCallback() {
			@Override
			public void onMapReady(GoogleMap _googleMap) {
				_mapview1_controller.setGoogleMap(_googleMap);
				gmap = _googleMap;
				_mapview1_controller.setMapType(GoogleMap.MAP_TYPE_NORMAL);
				if (data.getString("lat", "").equals("")) {
					
				}
				else {
					lat = Double.parseDouble(data.getString("lat", ""));
					lng = Double.parseDouble(data.getString("lng", ""));
				}
				_mapview1_controller.addMarker("a", lat, lng);
				_mapview1_controller.moveCamera(lat, lng);
				_mapview1_controller.zoomTo(16);
			}
		});
		
		_mapview1_controller.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
			@Override
			public boolean onMarkerClick(Marker _param1) {
				final String _id = _param1.getTag().toString();
				final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(WelcomeMapActivity.this);
				
				View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.set_location,null );
				bottomSheetDialog.setContentView(bottomSheetView);
				
				bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
				TextView address = (TextView) bottomSheetView.findViewById(R.id.address);
				
				ImageView more = (ImageView) bottomSheetView.findViewById(R.id.more);
				
				LinearLayout reset = (LinearLayout) bottomSheetView.findViewById(R.id.reset);
				
				LinearLayout apply = (LinearLayout) bottomSheetView.findViewById(R.id.apply);
				_rippleRoundStroke(reset, "#FFFFFF", "#eeeeee", 0, 0, "#ffffff");
				_rippleRoundStroke(apply, "#186b87", "#eeeeee", 0, 0, "#176b87");
				_setSingleLine(address, true);
				_getLocation(lat1, lng1);
				address.setText(strAdd);
				more.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						
						dialog.setMessage(strAdd);
						dialog.create().show();
					}
				});
				reset.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						
						location.removeUpdates(_location_location_listener);
						if (ContextCompat.checkSelfPermission(WelcomeMapActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
							location.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1, _location_location_listener);
						}
						bottomSheetDialog.dismiss();
					}
				});
				apply.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						
						intent.setAction(Intent.ACTION_VIEW);
						intent.setClass(getApplicationContext(), SigninDialogActivity.class);
						startActivity(intent);
						bottomSheetDialog.dismiss();
					}
				});
				bottomSheetDialog.setCancelable(true);
				bottomSheetDialog.show();
				return false;
			}
		});
		
		_location_location_listener = new LocationListener() {
			@Override
			public void onLocationChanged(Location _param1) {
				final double _lat = _param1.getLatitude();
				final double _lng = _param1.getLongitude();
				final double _acc = _param1.getAccuracy();
				lat = 6.9140641d;
				lng = 122.0633368d;
				_mapview1_controller.addMarker("a", lat, lng);
				_mapview1_controller.moveCamera(lat, lng);
				_mapview1_controller.zoomTo(16);
			}
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
			}
			
			@Override
			public void onProviderEnabled(String provider) {
			}
			
			@Override
			public void onProviderDisabled(String provider) {
			}
		};
	}
	
	private void initializeLogic() {
		_advance(linear1);
		_simpleRiffle(search);
		_simpleRiffle(filter_icon);
		_ImageColor(search_icon, "#bdbdbd");
		_ImageColor(filter_icon, "#2196f3");
		if (ContextCompat.checkSelfPermission(WelcomeMapActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			location.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1, _location_location_listener);
		}
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
	
	
	public void _extra() {
	}
	
	com.google.android.gms.maps.GoogleMap gmap;
	com.google.android.gms.maps.Projection proj;
	 @Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		int actionType = ev.getAction();
		
		switch (actionType) {
			case MotionEvent.ACTION_UP:
			
			proj = gmap.getProjection();
			com.google.android.gms.maps.model.LatLng loc = proj.fromScreenLocation(new Point ((int)ev.getX(), (int)ev.getY()));
			
			lat1 = loc.latitude;
			lng1 = loc.longitude;
			data.edit().putString("lat", String.valueOf(lat1)).commit();
			data.edit().putString("lng", String.valueOf(lng1)).commit();
		}
		return super.dispatchTouchEvent(ev);
	}
	
	{
	}
	
	
	public void _getLocation(final double _LATITUDE, final double _LONGITUDE) {
		android.location.Geocoder geocoder = new android.location.Geocoder(getApplicationContext(), Locale.getDefault());
		
		try {
			List<android.location.Address> addresses = geocoder.getFromLocation(_LATITUDE, _LONGITUDE, 1);
			if (addresses != null) {
				android.location.Address returnedAddress = addresses.get(0);
				StringBuilder strReturnedAddress = new StringBuilder("");
				StringBuilder strReturnedCity = new StringBuilder("");
				StringBuilder strReturnedState = new StringBuilder("");
				StringBuilder strReturnedCountry = new StringBuilder("");
				StringBuilder strReturnedPC = new StringBuilder("");
				StringBuilder strReturnedKN = new StringBuilder("");
				for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
					strReturnedAddress.append(returnedAddress.getAddressLine(i));
					strReturnedCity.append(returnedAddress.getLocality()); 
					strReturnedState.append(returnedAddress.getAdminArea());
					strReturnedCountry.append(returnedAddress.getCountryName());
					strReturnedPC.append(returnedAddress.getPostalCode());
					strReturnedKN.append(returnedAddress.getFeatureName());
				}
				strAdd = strReturnedAddress.toString();
			}
			else
			{
				strAdd = "No Address Found";
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			strAdd = "Can't get Address";
		}
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
	
	
	public void _setSingleLine(final TextView _view, final boolean _bool) {
		_view.setSingleLine(_bool);
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