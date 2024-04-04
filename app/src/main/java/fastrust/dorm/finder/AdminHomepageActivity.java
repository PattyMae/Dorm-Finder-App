package fastrust.dorm.finder;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
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
import android.widget.ScrollView;
import android.widget.Switch;
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
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class AdminHomepageActivity extends AppCompatActivity {
	
	public final int REQ_CD_PHOTO1 = 101;
	public final int REQ_CD_PHOTO2 = 102;
	public final int REQ_CD_PHOTO3 = 103;
	public final int REQ_CD_PHOTO4 = 104;
	public final int REQ_CD_PHOTO5 = 105;
	public final int REQ_CD_PHOTO6 = 106;
	public final int REQ_CD_PHOTO7 = 107;
	public final int REQ_CD_PHOTO8 = 108;
	public final int REQ_CD_PHOTO9 = 109;
	public final int REQ_CD_PHOTO10 = 110;
	public final int REQ_CD_PHOTO11 = 111;
	public final int REQ_CD_PHOTO12 = 112;
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private String img1 = "";
	private String img2 = "";
	private String img3 = "";
	private String img4 = "";
	private boolean isVisible = false;
	private String success_img1 = "";
	private String success_img2 = "";
	private String success_img3 = "";
	private String success_img4 = "";
	private String getPost = "";
	private String edit = "";
	private String strAdd = "";
	private double lat = 0;
	private double lng = 0;
	private String success_img5 = "";
	private String success_img6 = "";
	private String success_img7 = "";
	private String success_img8 = "";
	private String success_img9 = "";
	private String success_img10 = "";
	private String success_img11 = "";
	private String success_img12 = "";
	private String img5 = "";
	private String img6 = "";
	private String img7 = "";
	private String img8 = "";
	private String img9 = "";
	private String img10 = "";
	private String img11 = "";
	private String img12 = "";
	private double totalBooking = 0;
	private double totalAvailable = 0;
	private double totalOccupied = 0;
	private double bedRoom = 0;
	private double bedType = 0;
	private String bedroom1 = "";
	private String bedtype1 = "";
	private String bedroom2 = "";
	private String bedtype2 = "";
	private String bedroom3 = "";
	private String bedtype3 = "";
	private String bedroom4 = "";
	private String bedtype4 = "";
	private String bedroom5 = "";
	private String bedtype5 = "";
	private String bedroom6 = "";
	private String bedtype6 = "";
	private String bedroom7 = "";
	private String bedtype7 = "";
	private String bedroom8 = "";
	private String bedtype8 = "";
	private String bedroom9 = "";
	private String bedtype9 = "";
	private double num = 0;
	private double floor = 0;
	private double bedroomNum = 0;
	private double bedroomRemove = 0;
	private String photoPath = "";
	private String bedroom = "";
	private String bedtype = "";
	private String rates_floor = "";
	private String rates_floor1 = "";
	private double girlsNum = 0;
	private double girlsRemove = 0;
	private double boysRemove = 0;
	private double boysNum = 0;
	private double boysCount = 0;
	private double boysBedroomNum = 0;
	private double boysBedroomRemove = 0;
	private String str = "";
	private double rev = 0;
	private double reviewCount = 0;
	TextView user_fullname;
	ImageView user_profile;
	private HashMap<String, Object> UserProfile = new HashMap<>();
	private HashMap<String, Object> UserName = new HashMap<>();
	private String data_bedroom1 = "";
	private String data_bedtype1 = "";
	private String data_floor1 = "";
	private String CharQue = "";
	private double amountAdvance = 0;
	private double amountDeposit = 0;
	private String type_of_dormitory = "";
	private double bedroom_data = 0;
	private String bedroom1_data = "";
	private String bedtype1_data = "";
	private String floor1_data = "";
	private String bedroom2_data = "";
	private String bedtype2_data = "";
	private String floor2_data = "";
	private double girls_rate_total = 0;
	private double boys_rate_total = 0;
	private double girlsBedCount = 0;
	private double boysBedCount = 0;
	private String latitude_data = "";
	private String longitude_data = "";
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> bedroom_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> rates_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> girls_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> boys_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> boys_bedroom_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> review_listmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout top;
	private LinearLayout center;
	private ImageView back;
	private LinearLayout dormitory_layout;
	private LinearLayout add_dormitory_layout;
	private ScrollView vscroll1;
	private LinearLayout linear10;
	private LinearLayout linear40;
	private TextView textview11;
	private CardView cardview4;
	private TextView textview33;
	private LinearLayout linear41;
	private CardView cardview32;
	private TextView textview15;
	private CardView cardview24;
	private TextView textview41;
	private LinearLayout linear19;
	private LinearLayout linear20;
	private LinearLayout linear38;
	private LinearLayout linear58;
	private TextView textview25;
	private CardView cardview45;
	private LinearLayout advance_deposit_layout;
	private LinearLayout rates_amount_layout;
	private LinearLayout reviews_layout;
	private CardView add_save_layout;
	private TextView textview30;
	private CardView cardview27;
	private CardView cardview28;
	private CardView cardview29;
	private EditText owners_firstname;
	private EditText owners_middle_initial;
	private EditText owners_lastname;
	private LinearLayout linear11;
	private CardView cardview5;
	private LinearLayout linear12;
	private TextView textview12;
	private CardView cardview6;
	private TextView textview13;
	private CardView cardview7;
	private TextView textview14;
	private LinearLayout linear15;
	private LinearLayout linear13;
	private EditText dormitory_name;
	private LinearLayout linear14;
	private EditText description;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private CardView cardview8;
	private CardView cardview9;
	private EditText street;
	private EditText city;
	private CardView cardview10;
	private CardView cardview11;
	private EditText barangay;
	private EditText province;
	private ImageView location_icon;
	private LinearLayout linear42;
	private LinearLayout linear43;
	private TextView textview34;
	private CardView cardview33;
	private EditText latitude;
	private TextView textview35;
	private CardView cardview34;
	private EditText longitude;
	private MapView mapview1;
	private GoogleMapController _mapview1_controller;
	private LinearLayout linear34;
	private CardView cardview25;
	private LinearLayout linear35;
	private LinearLayout linear18;
	private TextView textview27;
	private LinearLayout linear36;
	private LinearLayout linear37;
	private LinearLayout linear44;
	private TextView add_bedroom;
	private LinearLayout linear24;
	private LinearLayout linear81;
	private LinearLayout coed_layout;
	private CheckBox female_dormitory;
	private CheckBox gender_neutral_dormitory;
	private CheckBox transient_;
	private CheckBox male_dormitory;
	private CheckBox co_ed_dormitory;
	private TextView textview36;
	private CardView cardview35;
	private RecyclerView recyclerview2;
	private EditText total_bedrooms;
	private LinearLayout added_layout;
	private LinearLayout bedroom_layout;
	private LinearLayout bedtype_layout;
	private LinearLayout floor_layout;
	private ImageView remove_bed2;
	private TextView bedroom_count;
	private CardView cardview30;
	private EditText number_bed2;
	private TextView bedtype_count;
	private CardView cardview31;
	private TextView textview57;
	private LinearLayout linear47;
	private EditText bed_type2;
	private ImageView bedtype2_option;
	private TextView floor_count;
	private CardView cardview58;
	private LinearLayout linear85;
	private EditText number_floor2;
	private LinearLayout linear82;
	private LinearLayout linear83;
	private TextView textview17;
	private CardView cardview13;
	private EditText room_available;
	private TextView textview19;
	private CardView cardview15;
	private EditText room_occupied;
	private TextView textview58;
	private LinearLayout linear45;
	private RecyclerView coed_girls_recycler;
	private TextView girls_add_bedroom;
	private TextView textview60;
	private LinearLayout linear89;
	private RecyclerView coed_boys_recycler;
	private TextView boys_add_bedroom;
	private LinearLayout linear90;
	private LinearLayout linear91;
	private LinearLayout linear92;
	private TextView textview62;
	private CardView cardview59;
	private EditText bedroom_girls;
	private TextView textview63;
	private CardView cardview60;
	private LinearLayout linear96;
	private TextView girls_bedtype;
	private ImageView girls_bedtype_option;
	private TextView textview64;
	private CardView cardview61;
	private EditText girls_floor;
	private LinearLayout linear93;
	private LinearLayout linear94;
	private LinearLayout linear95;
	private TextView textview65;
	private CardView cardview62;
	private EditText boys_bedroom;
	private TextView textview66;
	private CardView cardview63;
	private LinearLayout linear97;
	private TextView boys_bedtype;
	private ImageView boys_bedtype_option;
	private TextView textview67;
	private CardView cardview64;
	private EditText boys_floor;
	private TextView textview20;
	private LinearLayout linear27;
	private TextView textview39;
	private LinearLayout linear48;
	private TextView textview40;
	private LinearLayout linear49;
	private CardView cardview16;
	private CardView cardview17;
	private CardView cardview18;
	private CardView cardview19;
	private LinearLayout linear28;
	private ImageView insert_photo1;
	private LinearLayout linear29;
	private ImageView insert_photo2;
	private LinearLayout linear30;
	private ImageView insert_photo3;
	private LinearLayout linear31;
	private ImageView insert_photo4;
	private CardView cardview36;
	private CardView cardview37;
	private CardView cardview38;
	private CardView cardview39;
	private LinearLayout linear50;
	private ImageView insert_photo5;
	private LinearLayout linear51;
	private ImageView insert_photo6;
	private LinearLayout linear52;
	private ImageView insert_photo7;
	private LinearLayout linear53;
	private ImageView insert_photo8;
	private CardView cardview40;
	private CardView cardview41;
	private CardView cardview42;
	private CardView cardview43;
	private LinearLayout linear54;
	private ImageView insert_photo9;
	private LinearLayout linear55;
	private ImageView insert_photo10;
	private LinearLayout linear56;
	private ImageView insert_photo11;
	private LinearLayout linear57;
	private ImageView insert_photo12;
	private TextView textview21;
	private CheckBox canteen;
	private CheckBox visiting_area;
	private CheckBox parking_area;
	private CheckBox common_bathroom;
	private CheckBox laundry;
	private LinearLayout linear32;
	private TextView textview22;
	private CardView cardview20;
	private EditText others_amenities;
	private TextView textview28;
	private CheckBox included_internet;
	private CheckBox included_cabinet;
	private CheckBox included_electric_fan;
	private CheckBox included_rice_cooker;
	private CheckBox included_parking_area;
	private CheckBox included_charging_port;
	private CheckBox included_common_bathroom;
	private CheckBox included_water;
	private CheckBox included_electricity;
	private LinearLayout linear39;
	private TextView textview29;
	private CardView cardview26;
	private EditText others_inclusion;
	private TextView textview42;
	private CheckBox policy_pets_allowed;
	private CheckBox policy_pets_not_allowed;
	private CheckBox policy_smoking_allowed;
	private CheckBox policy_not_smoking_allowed;
	private LinearLayout linear59;
	private TextView textview43;
	private CardView cardview44;
	private EditText others_policy;
	private LinearLayout linear60;
	private CardView cardview46;
	private LinearLayout rates_layout;
	private LinearLayout coed_layout1;
	private TextView textview46;
	private TextView girls_text;
	private LinearLayout linear61;
	private LinearLayout linear67;
	private RecyclerView recyclerview3;
	private TextView add_beds;
	private TextView boys_text;
	private LinearLayout coed_layout2;
	private LinearLayout linear105;
	private LinearLayout linear106;
	private TextView textview74;
	private CardView cardview67;
	private EditText room_available_boys;
	private TextView textview75;
	private CardView cardview68;
	private EditText room_available_girls;
	private LinearLayout linear62;
	private LinearLayout linear63;
	private LinearLayout linear68;
	private TextView textview44;
	private CardView cardview47;
	private LinearLayout linear86;
	private EditText price_bedroom1;
	private ImageView rates_bedroom_option;
	private TextView textview50;
	private CardView cardview48;
	private LinearLayout linear79;
	private EditText price_bedtype;
	private TextView textview51;
	private CardView cardview51;
	private LinearLayout linear88;
	private EditText price_floor;
	private ImageView rates_floor_option;
	private LinearLayout monthly_price_layout;
	private LinearLayout linear69;
	private LinearLayout linear87;
	private TextView textview45;
	private CardView cardview22;
	private EditText room_rent;
	private TextView textview52;
	private CardView cardview52;
	private LinearLayout linear71;
	private TextView rates_status;
	private ImageView rates_status_option;
	private LinearLayout linear107;
	private LinearLayout linear108;
	private RecyclerView recyclerview4;
	private TextView boys_add_beds;
	private LinearLayout linear109;
	private LinearLayout linear110;
	private LinearLayout linear111;
	private TextView textview77;
	private CardView cardview69;
	private LinearLayout linear115;
	private TextView price_boys_bedroom;
	private ImageView boys_bedroom_option;
	private TextView textview78;
	private CardView cardview70;
	private EditText price_boys_bed;
	private TextView textview79;
	private CardView cardview71;
	private LinearLayout linear116;
	private TextView price_boys_floor;
	private ImageView boys_floor_option;
	private LinearLayout boys_monthly_price_layout;
	private LinearLayout linear113;
	private LinearLayout linear114;
	private TextView textview80;
	private CardView cardview72;
	private EditText price_boys_monthly;
	private TextView textview81;
	private CardView cardview73;
	private LinearLayout linear117;
	private TextView price_boys_status;
	private ImageView boys_status_option;
	private LinearLayout linear77;
	private LinearLayout linear78;
	private Switch switch1;
	private CardView cardview55;
	private EditText amount_advance;
	private Switch switch2;
	private CardView cardview56;
	private EditText amount_deposit;
	private TextView textview68;
	private LinearLayout linear98;
	private LinearLayout linear99;
	private LinearLayout linear100;
	private TextView textview69;
	private CardView cardview65;
	private EditText rates_per_night;
	private TextView textview70;
	private CardView cardview66;
	private LinearLayout linear101;
	private EditText minimum_stay;
	private TextView textview71;
	private TextView textview82;
	private RecyclerView recyclerview1;
	private CardView cardview57;
	private TextView select_reviews_ratings;
	private LinearLayout select_add_dormitory;
	private TextView textview26;
	
	private Intent intent = new Intent();
	private Intent photo1 = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent photo2 = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent photo3 = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent photo4 = new Intent(Intent.ACTION_GET_CONTENT);
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private StorageReference post1 = _firebase_storage.getReference("post");
	private OnCompleteListener<Uri> _post1_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _post1_download_success_listener;
	private OnSuccessListener _post1_delete_success_listener;
	private OnProgressListener _post1_upload_progress_listener;
	private OnProgressListener _post1_download_progress_listener;
	private OnFailureListener _post1_failure_listener;
	
	private StorageReference post2 = _firebase_storage.getReference("post");
	private OnCompleteListener<Uri> _post2_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _post2_download_success_listener;
	private OnSuccessListener _post2_delete_success_listener;
	private OnProgressListener _post2_upload_progress_listener;
	private OnProgressListener _post2_download_progress_listener;
	private OnFailureListener _post2_failure_listener;
	
	private StorageReference post3 = _firebase_storage.getReference("post");
	private OnCompleteListener<Uri> _post3_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _post3_download_success_listener;
	private OnSuccessListener _post3_delete_success_listener;
	private OnProgressListener _post3_upload_progress_listener;
	private OnProgressListener _post3_download_progress_listener;
	private OnFailureListener _post3_failure_listener;
	
	private StorageReference post4 = _firebase_storage.getReference("post");
	private OnCompleteListener<Uri> _post4_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _post4_download_success_listener;
	private OnSuccessListener _post4_delete_success_listener;
	private OnProgressListener _post4_upload_progress_listener;
	private OnProgressListener _post4_download_progress_listener;
	private OnFailureListener _post4_failure_listener;
	
	private SharedPreferences data;
	private DatabaseReference post = _firebase.getReference("post");
	private ChildEventListener _post_child_listener;
	private DatabaseReference getpost = _firebase.getReference("post");
	private ChildEventListener _getpost_child_listener;
	private RequestNetwork edit_network;
	private RequestNetwork.RequestListener _edit_network_request_listener;
	private LocationManager loc;
	private LocationListener _loc_location_listener;
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
	
	private Intent photo5 = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent photo6 = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent photo7 = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent photo8 = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent photo9 = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent photo10 = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent photo11 = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent photo12 = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference post5 = _firebase_storage.getReference("post");
	private OnCompleteListener<Uri> _post5_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _post5_download_success_listener;
	private OnSuccessListener _post5_delete_success_listener;
	private OnProgressListener _post5_upload_progress_listener;
	private OnProgressListener _post5_download_progress_listener;
	private OnFailureListener _post5_failure_listener;
	
	private StorageReference post6 = _firebase_storage.getReference("post");
	private OnCompleteListener<Uri> _post6_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _post6_download_success_listener;
	private OnSuccessListener _post6_delete_success_listener;
	private OnProgressListener _post6_upload_progress_listener;
	private OnProgressListener _post6_download_progress_listener;
	private OnFailureListener _post6_failure_listener;
	
	private StorageReference post7 = _firebase_storage.getReference("post");
	private OnCompleteListener<Uri> _post7_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _post7_download_success_listener;
	private OnSuccessListener _post7_delete_success_listener;
	private OnProgressListener _post7_upload_progress_listener;
	private OnProgressListener _post7_download_progress_listener;
	private OnFailureListener _post7_failure_listener;
	
	private StorageReference post8 = _firebase_storage.getReference("post");
	private OnCompleteListener<Uri> _post8_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _post8_download_success_listener;
	private OnSuccessListener _post8_delete_success_listener;
	private OnProgressListener _post8_upload_progress_listener;
	private OnProgressListener _post8_download_progress_listener;
	private OnFailureListener _post8_failure_listener;
	
	private StorageReference post9 = _firebase_storage.getReference("post");
	private OnCompleteListener<Uri> _post9_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _post9_download_success_listener;
	private OnSuccessListener _post9_delete_success_listener;
	private OnProgressListener _post9_upload_progress_listener;
	private OnProgressListener _post9_download_progress_listener;
	private OnFailureListener _post9_failure_listener;
	
	private StorageReference post10 = _firebase_storage.getReference("post");
	private OnCompleteListener<Uri> _post10_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _post10_download_success_listener;
	private OnSuccessListener _post10_delete_success_listener;
	private OnProgressListener _post10_upload_progress_listener;
	private OnProgressListener _post10_download_progress_listener;
	private OnFailureListener _post10_failure_listener;
	
	private StorageReference post11 = _firebase_storage.getReference("post");
	private OnCompleteListener<Uri> _post11_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _post11_download_success_listener;
	private OnSuccessListener _post11_delete_success_listener;
	private OnProgressListener _post11_upload_progress_listener;
	private OnProgressListener _post11_download_progress_listener;
	private OnFailureListener _post11_failure_listener;
	
	private StorageReference post12 = _firebase_storage.getReference("post");
	private OnCompleteListener<Uri> _post12_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _post12_download_success_listener;
	private OnSuccessListener _post12_delete_success_listener;
	private OnProgressListener _post12_upload_progress_listener;
	private OnProgressListener _post12_download_progress_listener;
	private OnFailureListener _post12_failure_listener;
	
	private DatabaseReference total = _firebase.getReference("total");
	private ChildEventListener _total_child_listener;
	private RequestNetwork network1;
	private RequestNetwork.RequestListener _network1_request_listener;
	private AlertDialog.Builder d_bed;
	private AlertDialog.Builder d_monthly_price;
	private RequestNetwork girls_network;
	private RequestNetwork.RequestListener _girls_network_request_listener;
	private RequestNetwork boys_network;
	private RequestNetwork.RequestListener _boys_network_request_listener;
	private RequestNetwork network2;
	private RequestNetwork.RequestListener _network2_request_listener;
	private DatabaseReference reviews = _firebase.getReference("reviews");
	private ChildEventListener _reviews_child_listener;
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private Calendar cal = Calendar.getInstance();
	private Calendar now = Calendar.getInstance();
	private DatabaseReference post_data = _firebase.getReference("post");
	private ChildEventListener _post_data_child_listener;
	private DatabaseReference post_data_rate = _firebase.getReference("post");
	private ChildEventListener _post_data_rate_child_listener;
	private DatabaseReference post_data_rate_boy = _firebase.getReference("post");
	private ChildEventListener _post_data_rate_boy_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.admin_homepage);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
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
		top = findViewById(R.id.top);
		center = findViewById(R.id.center);
		back = findViewById(R.id.back);
		dormitory_layout = findViewById(R.id.dormitory_layout);
		add_dormitory_layout = findViewById(R.id.add_dormitory_layout);
		vscroll1 = findViewById(R.id.vscroll1);
		linear10 = findViewById(R.id.linear10);
		linear40 = findViewById(R.id.linear40);
		textview11 = findViewById(R.id.textview11);
		cardview4 = findViewById(R.id.cardview4);
		textview33 = findViewById(R.id.textview33);
		linear41 = findViewById(R.id.linear41);
		cardview32 = findViewById(R.id.cardview32);
		textview15 = findViewById(R.id.textview15);
		cardview24 = findViewById(R.id.cardview24);
		textview41 = findViewById(R.id.textview41);
		linear19 = findViewById(R.id.linear19);
		linear20 = findViewById(R.id.linear20);
		linear38 = findViewById(R.id.linear38);
		linear58 = findViewById(R.id.linear58);
		textview25 = findViewById(R.id.textview25);
		cardview45 = findViewById(R.id.cardview45);
		advance_deposit_layout = findViewById(R.id.advance_deposit_layout);
		rates_amount_layout = findViewById(R.id.rates_amount_layout);
		reviews_layout = findViewById(R.id.reviews_layout);
		add_save_layout = findViewById(R.id.add_save_layout);
		textview30 = findViewById(R.id.textview30);
		cardview27 = findViewById(R.id.cardview27);
		cardview28 = findViewById(R.id.cardview28);
		cardview29 = findViewById(R.id.cardview29);
		owners_firstname = findViewById(R.id.owners_firstname);
		owners_middle_initial = findViewById(R.id.owners_middle_initial);
		owners_lastname = findViewById(R.id.owners_lastname);
		linear11 = findViewById(R.id.linear11);
		cardview5 = findViewById(R.id.cardview5);
		linear12 = findViewById(R.id.linear12);
		textview12 = findViewById(R.id.textview12);
		cardview6 = findViewById(R.id.cardview6);
		textview13 = findViewById(R.id.textview13);
		cardview7 = findViewById(R.id.cardview7);
		textview14 = findViewById(R.id.textview14);
		linear15 = findViewById(R.id.linear15);
		linear13 = findViewById(R.id.linear13);
		dormitory_name = findViewById(R.id.dormitory_name);
		linear14 = findViewById(R.id.linear14);
		description = findViewById(R.id.description);
		linear16 = findViewById(R.id.linear16);
		linear17 = findViewById(R.id.linear17);
		cardview8 = findViewById(R.id.cardview8);
		cardview9 = findViewById(R.id.cardview9);
		street = findViewById(R.id.street);
		city = findViewById(R.id.city);
		cardview10 = findViewById(R.id.cardview10);
		cardview11 = findViewById(R.id.cardview11);
		barangay = findViewById(R.id.barangay);
		province = findViewById(R.id.province);
		location_icon = findViewById(R.id.location_icon);
		linear42 = findViewById(R.id.linear42);
		linear43 = findViewById(R.id.linear43);
		textview34 = findViewById(R.id.textview34);
		cardview33 = findViewById(R.id.cardview33);
		latitude = findViewById(R.id.latitude);
		textview35 = findViewById(R.id.textview35);
		cardview34 = findViewById(R.id.cardview34);
		longitude = findViewById(R.id.longitude);
		mapview1 = findViewById(R.id.mapview1);
		mapview1.onCreate(_savedInstanceState);
		
		linear34 = findViewById(R.id.linear34);
		cardview25 = findViewById(R.id.cardview25);
		linear35 = findViewById(R.id.linear35);
		linear18 = findViewById(R.id.linear18);
		textview27 = findViewById(R.id.textview27);
		linear36 = findViewById(R.id.linear36);
		linear37 = findViewById(R.id.linear37);
		linear44 = findViewById(R.id.linear44);
		add_bedroom = findViewById(R.id.add_bedroom);
		linear24 = findViewById(R.id.linear24);
		linear81 = findViewById(R.id.linear81);
		coed_layout = findViewById(R.id.coed_layout);
		female_dormitory = findViewById(R.id.female_dormitory);
		gender_neutral_dormitory = findViewById(R.id.gender_neutral_dormitory);
		transient_ = findViewById(R.id.transient_);
		male_dormitory = findViewById(R.id.male_dormitory);
		co_ed_dormitory = findViewById(R.id.co_ed_dormitory);
		textview36 = findViewById(R.id.textview36);
		cardview35 = findViewById(R.id.cardview35);
		recyclerview2 = findViewById(R.id.recyclerview2);
		total_bedrooms = findViewById(R.id.total_bedrooms);
		added_layout = findViewById(R.id.added_layout);
		bedroom_layout = findViewById(R.id.bedroom_layout);
		bedtype_layout = findViewById(R.id.bedtype_layout);
		floor_layout = findViewById(R.id.floor_layout);
		remove_bed2 = findViewById(R.id.remove_bed2);
		bedroom_count = findViewById(R.id.bedroom_count);
		cardview30 = findViewById(R.id.cardview30);
		number_bed2 = findViewById(R.id.number_bed2);
		bedtype_count = findViewById(R.id.bedtype_count);
		cardview31 = findViewById(R.id.cardview31);
		textview57 = findViewById(R.id.textview57);
		linear47 = findViewById(R.id.linear47);
		bed_type2 = findViewById(R.id.bed_type2);
		bedtype2_option = findViewById(R.id.bedtype2_option);
		floor_count = findViewById(R.id.floor_count);
		cardview58 = findViewById(R.id.cardview58);
		linear85 = findViewById(R.id.linear85);
		number_floor2 = findViewById(R.id.number_floor2);
		linear82 = findViewById(R.id.linear82);
		linear83 = findViewById(R.id.linear83);
		textview17 = findViewById(R.id.textview17);
		cardview13 = findViewById(R.id.cardview13);
		room_available = findViewById(R.id.room_available);
		textview19 = findViewById(R.id.textview19);
		cardview15 = findViewById(R.id.cardview15);
		room_occupied = findViewById(R.id.room_occupied);
		textview58 = findViewById(R.id.textview58);
		linear45 = findViewById(R.id.linear45);
		coed_girls_recycler = findViewById(R.id.coed_girls_recycler);
		girls_add_bedroom = findViewById(R.id.girls_add_bedroom);
		textview60 = findViewById(R.id.textview60);
		linear89 = findViewById(R.id.linear89);
		coed_boys_recycler = findViewById(R.id.coed_boys_recycler);
		boys_add_bedroom = findViewById(R.id.boys_add_bedroom);
		linear90 = findViewById(R.id.linear90);
		linear91 = findViewById(R.id.linear91);
		linear92 = findViewById(R.id.linear92);
		textview62 = findViewById(R.id.textview62);
		cardview59 = findViewById(R.id.cardview59);
		bedroom_girls = findViewById(R.id.bedroom_girls);
		textview63 = findViewById(R.id.textview63);
		cardview60 = findViewById(R.id.cardview60);
		linear96 = findViewById(R.id.linear96);
		girls_bedtype = findViewById(R.id.girls_bedtype);
		girls_bedtype_option = findViewById(R.id.girls_bedtype_option);
		textview64 = findViewById(R.id.textview64);
		cardview61 = findViewById(R.id.cardview61);
		girls_floor = findViewById(R.id.girls_floor);
		linear93 = findViewById(R.id.linear93);
		linear94 = findViewById(R.id.linear94);
		linear95 = findViewById(R.id.linear95);
		textview65 = findViewById(R.id.textview65);
		cardview62 = findViewById(R.id.cardview62);
		boys_bedroom = findViewById(R.id.boys_bedroom);
		textview66 = findViewById(R.id.textview66);
		cardview63 = findViewById(R.id.cardview63);
		linear97 = findViewById(R.id.linear97);
		boys_bedtype = findViewById(R.id.boys_bedtype);
		boys_bedtype_option = findViewById(R.id.boys_bedtype_option);
		textview67 = findViewById(R.id.textview67);
		cardview64 = findViewById(R.id.cardview64);
		boys_floor = findViewById(R.id.boys_floor);
		textview20 = findViewById(R.id.textview20);
		linear27 = findViewById(R.id.linear27);
		textview39 = findViewById(R.id.textview39);
		linear48 = findViewById(R.id.linear48);
		textview40 = findViewById(R.id.textview40);
		linear49 = findViewById(R.id.linear49);
		cardview16 = findViewById(R.id.cardview16);
		cardview17 = findViewById(R.id.cardview17);
		cardview18 = findViewById(R.id.cardview18);
		cardview19 = findViewById(R.id.cardview19);
		linear28 = findViewById(R.id.linear28);
		insert_photo1 = findViewById(R.id.insert_photo1);
		linear29 = findViewById(R.id.linear29);
		insert_photo2 = findViewById(R.id.insert_photo2);
		linear30 = findViewById(R.id.linear30);
		insert_photo3 = findViewById(R.id.insert_photo3);
		linear31 = findViewById(R.id.linear31);
		insert_photo4 = findViewById(R.id.insert_photo4);
		cardview36 = findViewById(R.id.cardview36);
		cardview37 = findViewById(R.id.cardview37);
		cardview38 = findViewById(R.id.cardview38);
		cardview39 = findViewById(R.id.cardview39);
		linear50 = findViewById(R.id.linear50);
		insert_photo5 = findViewById(R.id.insert_photo5);
		linear51 = findViewById(R.id.linear51);
		insert_photo6 = findViewById(R.id.insert_photo6);
		linear52 = findViewById(R.id.linear52);
		insert_photo7 = findViewById(R.id.insert_photo7);
		linear53 = findViewById(R.id.linear53);
		insert_photo8 = findViewById(R.id.insert_photo8);
		cardview40 = findViewById(R.id.cardview40);
		cardview41 = findViewById(R.id.cardview41);
		cardview42 = findViewById(R.id.cardview42);
		cardview43 = findViewById(R.id.cardview43);
		linear54 = findViewById(R.id.linear54);
		insert_photo9 = findViewById(R.id.insert_photo9);
		linear55 = findViewById(R.id.linear55);
		insert_photo10 = findViewById(R.id.insert_photo10);
		linear56 = findViewById(R.id.linear56);
		insert_photo11 = findViewById(R.id.insert_photo11);
		linear57 = findViewById(R.id.linear57);
		insert_photo12 = findViewById(R.id.insert_photo12);
		textview21 = findViewById(R.id.textview21);
		canteen = findViewById(R.id.canteen);
		visiting_area = findViewById(R.id.visiting_area);
		parking_area = findViewById(R.id.parking_area);
		common_bathroom = findViewById(R.id.common_bathroom);
		laundry = findViewById(R.id.laundry);
		linear32 = findViewById(R.id.linear32);
		textview22 = findViewById(R.id.textview22);
		cardview20 = findViewById(R.id.cardview20);
		others_amenities = findViewById(R.id.others_amenities);
		textview28 = findViewById(R.id.textview28);
		included_internet = findViewById(R.id.included_internet);
		included_cabinet = findViewById(R.id.included_cabinet);
		included_electric_fan = findViewById(R.id.included_electric_fan);
		included_rice_cooker = findViewById(R.id.included_rice_cooker);
		included_parking_area = findViewById(R.id.included_parking_area);
		included_charging_port = findViewById(R.id.included_charging_port);
		included_common_bathroom = findViewById(R.id.included_common_bathroom);
		included_water = findViewById(R.id.included_water);
		included_electricity = findViewById(R.id.included_electricity);
		linear39 = findViewById(R.id.linear39);
		textview29 = findViewById(R.id.textview29);
		cardview26 = findViewById(R.id.cardview26);
		others_inclusion = findViewById(R.id.others_inclusion);
		textview42 = findViewById(R.id.textview42);
		policy_pets_allowed = findViewById(R.id.policy_pets_allowed);
		policy_pets_not_allowed = findViewById(R.id.policy_pets_not_allowed);
		policy_smoking_allowed = findViewById(R.id.policy_smoking_allowed);
		policy_not_smoking_allowed = findViewById(R.id.policy_not_smoking_allowed);
		linear59 = findViewById(R.id.linear59);
		textview43 = findViewById(R.id.textview43);
		cardview44 = findViewById(R.id.cardview44);
		others_policy = findViewById(R.id.others_policy);
		linear60 = findViewById(R.id.linear60);
		cardview46 = findViewById(R.id.cardview46);
		rates_layout = findViewById(R.id.rates_layout);
		coed_layout1 = findViewById(R.id.coed_layout1);
		textview46 = findViewById(R.id.textview46);
		girls_text = findViewById(R.id.girls_text);
		linear61 = findViewById(R.id.linear61);
		linear67 = findViewById(R.id.linear67);
		recyclerview3 = findViewById(R.id.recyclerview3);
		add_beds = findViewById(R.id.add_beds);
		boys_text = findViewById(R.id.boys_text);
		coed_layout2 = findViewById(R.id.coed_layout2);
		linear105 = findViewById(R.id.linear105);
		linear106 = findViewById(R.id.linear106);
		textview74 = findViewById(R.id.textview74);
		cardview67 = findViewById(R.id.cardview67);
		room_available_boys = findViewById(R.id.room_available_boys);
		textview75 = findViewById(R.id.textview75);
		cardview68 = findViewById(R.id.cardview68);
		room_available_girls = findViewById(R.id.room_available_girls);
		linear62 = findViewById(R.id.linear62);
		linear63 = findViewById(R.id.linear63);
		linear68 = findViewById(R.id.linear68);
		textview44 = findViewById(R.id.textview44);
		cardview47 = findViewById(R.id.cardview47);
		linear86 = findViewById(R.id.linear86);
		price_bedroom1 = findViewById(R.id.price_bedroom1);
		rates_bedroom_option = findViewById(R.id.rates_bedroom_option);
		textview50 = findViewById(R.id.textview50);
		cardview48 = findViewById(R.id.cardview48);
		linear79 = findViewById(R.id.linear79);
		price_bedtype = findViewById(R.id.price_bedtype);
		textview51 = findViewById(R.id.textview51);
		cardview51 = findViewById(R.id.cardview51);
		linear88 = findViewById(R.id.linear88);
		price_floor = findViewById(R.id.price_floor);
		rates_floor_option = findViewById(R.id.rates_floor_option);
		monthly_price_layout = findViewById(R.id.monthly_price_layout);
		linear69 = findViewById(R.id.linear69);
		linear87 = findViewById(R.id.linear87);
		textview45 = findViewById(R.id.textview45);
		cardview22 = findViewById(R.id.cardview22);
		room_rent = findViewById(R.id.room_rent);
		textview52 = findViewById(R.id.textview52);
		cardview52 = findViewById(R.id.cardview52);
		linear71 = findViewById(R.id.linear71);
		rates_status = findViewById(R.id.rates_status);
		rates_status_option = findViewById(R.id.rates_status_option);
		linear107 = findViewById(R.id.linear107);
		linear108 = findViewById(R.id.linear108);
		recyclerview4 = findViewById(R.id.recyclerview4);
		boys_add_beds = findViewById(R.id.boys_add_beds);
		linear109 = findViewById(R.id.linear109);
		linear110 = findViewById(R.id.linear110);
		linear111 = findViewById(R.id.linear111);
		textview77 = findViewById(R.id.textview77);
		cardview69 = findViewById(R.id.cardview69);
		linear115 = findViewById(R.id.linear115);
		price_boys_bedroom = findViewById(R.id.price_boys_bedroom);
		boys_bedroom_option = findViewById(R.id.boys_bedroom_option);
		textview78 = findViewById(R.id.textview78);
		cardview70 = findViewById(R.id.cardview70);
		price_boys_bed = findViewById(R.id.price_boys_bed);
		textview79 = findViewById(R.id.textview79);
		cardview71 = findViewById(R.id.cardview71);
		linear116 = findViewById(R.id.linear116);
		price_boys_floor = findViewById(R.id.price_boys_floor);
		boys_floor_option = findViewById(R.id.boys_floor_option);
		boys_monthly_price_layout = findViewById(R.id.boys_monthly_price_layout);
		linear113 = findViewById(R.id.linear113);
		linear114 = findViewById(R.id.linear114);
		textview80 = findViewById(R.id.textview80);
		cardview72 = findViewById(R.id.cardview72);
		price_boys_monthly = findViewById(R.id.price_boys_monthly);
		textview81 = findViewById(R.id.textview81);
		cardview73 = findViewById(R.id.cardview73);
		linear117 = findViewById(R.id.linear117);
		price_boys_status = findViewById(R.id.price_boys_status);
		boys_status_option = findViewById(R.id.boys_status_option);
		linear77 = findViewById(R.id.linear77);
		linear78 = findViewById(R.id.linear78);
		switch1 = findViewById(R.id.switch1);
		cardview55 = findViewById(R.id.cardview55);
		amount_advance = findViewById(R.id.amount_advance);
		switch2 = findViewById(R.id.switch2);
		cardview56 = findViewById(R.id.cardview56);
		amount_deposit = findViewById(R.id.amount_deposit);
		textview68 = findViewById(R.id.textview68);
		linear98 = findViewById(R.id.linear98);
		linear99 = findViewById(R.id.linear99);
		linear100 = findViewById(R.id.linear100);
		textview69 = findViewById(R.id.textview69);
		cardview65 = findViewById(R.id.cardview65);
		rates_per_night = findViewById(R.id.rates_per_night);
		textview70 = findViewById(R.id.textview70);
		cardview66 = findViewById(R.id.cardview66);
		linear101 = findViewById(R.id.linear101);
		minimum_stay = findViewById(R.id.minimum_stay);
		textview71 = findViewById(R.id.textview71);
		textview82 = findViewById(R.id.textview82);
		recyclerview1 = findViewById(R.id.recyclerview1);
		cardview57 = findViewById(R.id.cardview57);
		select_reviews_ratings = findViewById(R.id.select_reviews_ratings);
		select_add_dormitory = findViewById(R.id.select_add_dormitory);
		textview26 = findViewById(R.id.textview26);
		photo1.setType("image/*");
		photo1.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		photo2.setType("image/*");
		photo2.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		photo3.setType("image/*");
		photo3.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		photo4.setType("image/*");
		photo4.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		network = new RequestNetwork(this);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		edit_network = new RequestNetwork(this);
		loc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		fauth = FirebaseAuth.getInstance();
		photo5.setType("image/*");
		photo5.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		photo6.setType("image/*");
		photo6.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		photo7.setType("image/*");
		photo7.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		photo8.setType("image/*");
		photo8.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		photo9.setType("image/*");
		photo9.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		photo10.setType("image/*");
		photo10.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		photo11.setType("image/*");
		photo11.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		photo12.setType("image/*");
		photo12.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		network1 = new RequestNetwork(this);
		d_bed = new AlertDialog.Builder(this);
		d_monthly_price = new AlertDialog.Builder(this);
		girls_network = new RequestNetwork(this);
		boys_network = new RequestNetwork(this);
		network2 = new RequestNetwork(this);
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		latitude.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (0 < latitude.getText().toString().length()) {
					if (_charSeq.length() > 0) {
						lat = Double.parseDouble(latitude.getText().toString());
					}
				}
				else {
					lat = 0;
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		longitude.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (0 < longitude.getText().toString().length()) {
					if (_charSeq.length() > 0) {
						lng = Double.parseDouble(longitude.getText().toString());
					}
				}
				else {
					lng = 0;
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		_mapview1_controller = new GoogleMapController(mapview1, new OnMapReadyCallback() {
			@Override
			public void onMapReady(GoogleMap _googleMap) {
				_mapview1_controller.setGoogleMap(_googleMap);
				_mapview1_controller.addMarker(dormitory_name.getText().toString(), lat, lng);
				_mapview1_controller.moveCamera(lat, lng);
				_mapview1_controller.zoomTo(19);
			}
		});
		
		add_bedroom.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (co_ed_dormitory.isChecked()) {
					SketchwareUtil.showMessage(getApplicationContext(), "Not available for Co-ed Dormitory");
				}
				else {
					added_layout.setVisibility(View.VISIBLE);
					add_bedroom.setVisibility(View.GONE);
					textview57.setVisibility(View.GONE);
					bedroom_count.setText("Bedroom ".concat(String.valueOf((long)(num + 1))));
				}
			}
		});
		
		female_dormitory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					female_dormitory.setChecked(true);
					gender_neutral_dormitory.setChecked(false);
					male_dormitory.setChecked(false);
					co_ed_dormitory.setChecked(false);
					transient_.setChecked(false);
					data.edit().putString("type of dormitory", female_dormitory.getText().toString()).commit();
					recyclerview2.setVisibility(View.VISIBLE);
					coed_layout.setVisibility(View.GONE);
					advance_deposit_layout.setVisibility(View.VISIBLE);
					rates_amount_layout.setVisibility(View.GONE);
					coed_layout1.setVisibility(View.GONE);
					girls_text.setVisibility(View.GONE);
					coed_layout2.setVisibility(View.GONE);
					boys_text.setVisibility(View.GONE);
					monthly_price_layout.setVisibility(View.VISIBLE);
					advance_deposit_layout.setVisibility(View.VISIBLE);
					data.edit().putString("transcient", "false").commit();
				}
				else {
					
				}
			}
		});
		
		gender_neutral_dormitory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					female_dormitory.setChecked(false);
					gender_neutral_dormitory.setChecked(true);
					male_dormitory.setChecked(false);
					co_ed_dormitory.setChecked(false);
					transient_.setChecked(false);
					data.edit().putString("type of dormitory", gender_neutral_dormitory.getText().toString()).commit();
					recyclerview2.setVisibility(View.VISIBLE);
					coed_layout.setVisibility(View.GONE);
					advance_deposit_layout.setVisibility(View.VISIBLE);
					rates_amount_layout.setVisibility(View.GONE);
					coed_layout1.setVisibility(View.GONE);
					girls_text.setVisibility(View.GONE);
					coed_layout2.setVisibility(View.GONE);
					boys_text.setVisibility(View.GONE);
					monthly_price_layout.setVisibility(View.VISIBLE);
					advance_deposit_layout.setVisibility(View.VISIBLE);
					data.edit().putString("transcient", "false").commit();
				}
				else {
					
				}
			}
		});
		
		transient_.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					female_dormitory.setChecked(false);
					gender_neutral_dormitory.setChecked(false);
					male_dormitory.setChecked(false);
					co_ed_dormitory.setChecked(false);
					transient_.setChecked(true);
					data.edit().putString("type of dormitory", transient_.getText().toString()).commit();
					recyclerview2.setVisibility(View.VISIBLE);
					coed_layout.setVisibility(View.GONE);
					advance_deposit_layout.setVisibility(View.GONE);
					rates_amount_layout.setVisibility(View.VISIBLE);
					coed_layout1.setVisibility(View.GONE);
					girls_text.setVisibility(View.GONE);
					coed_layout2.setVisibility(View.GONE);
					boys_text.setVisibility(View.GONE);
					monthly_price_layout.setVisibility(View.GONE);
					advance_deposit_layout.setVisibility(View.GONE);
					data.edit().putString("transcient", "true").commit();
				}
				else {
					advance_deposit_layout.setVisibility(View.VISIBLE);
					rates_amount_layout.setVisibility(View.GONE);
					monthly_price_layout.setVisibility(View.VISIBLE);
					advance_deposit_layout.setVisibility(View.VISIBLE);
					data.edit().putString("transcient", "false").commit();
				}
			}
		});
		
		male_dormitory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					female_dormitory.setChecked(false);
					gender_neutral_dormitory.setChecked(false);
					male_dormitory.setChecked(true);
					co_ed_dormitory.setChecked(false);
					transient_.setChecked(false);
					data.edit().putString("type of dormitory", male_dormitory.getText().toString()).commit();
					recyclerview2.setVisibility(View.VISIBLE);
					coed_layout.setVisibility(View.GONE);
					advance_deposit_layout.setVisibility(View.VISIBLE);
					rates_amount_layout.setVisibility(View.GONE);
					coed_layout1.setVisibility(View.GONE);
					girls_text.setVisibility(View.GONE);
					coed_layout2.setVisibility(View.GONE);
					boys_text.setVisibility(View.GONE);
					monthly_price_layout.setVisibility(View.VISIBLE);
					advance_deposit_layout.setVisibility(View.VISIBLE);
					data.edit().putString("transcient", "false").commit();
				}
				else {
					
				}
			}
		});
		
		co_ed_dormitory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					female_dormitory.setChecked(false);
					gender_neutral_dormitory.setChecked(false);
					male_dormitory.setChecked(false);
					co_ed_dormitory.setChecked(true);
					transient_.setChecked(false);
					data.edit().putString("type of dormitory", co_ed_dormitory.getText().toString()).commit();
					recyclerview2.setVisibility(View.GONE);
					add_bedroom.setVisibility(View.GONE);
					added_layout.setVisibility(View.GONE);
					coed_layout.setVisibility(View.VISIBLE);
					advance_deposit_layout.setVisibility(View.VISIBLE);
					rates_amount_layout.setVisibility(View.GONE);
					coed_layout1.setVisibility(View.VISIBLE);
					girls_text.setVisibility(View.VISIBLE);
					coed_layout2.setVisibility(View.VISIBLE);
					boys_text.setVisibility(View.VISIBLE);
					monthly_price_layout.setVisibility(View.VISIBLE);
					advance_deposit_layout.setVisibility(View.VISIBLE);
					data.edit().putString("transcient", "false").commit();
				}
				else {
					recyclerview2.setVisibility(View.VISIBLE);
					coed_layout.setVisibility(View.GONE);
					coed_layout1.setVisibility(View.GONE);
					girls_text.setVisibility(View.GONE);
					coed_layout2.setVisibility(View.GONE);
					boys_text.setVisibility(View.GONE);
				}
			}
		});
		
		total_bedrooms.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (0 < total_bedrooms.getText().toString().length()) {
					if (_charSeq.length() > 0) {
						bedRoom = 0;
						bedType = 0;
						floor = 0;
						add_bedroom.setVisibility(View.VISIBLE);
						textview57.setVisibility(View.VISIBLE);
						co_ed_dormitory.setChecked(false);
						for(int _repeat199 = 0; _repeat199 < (int)(Double.parseDouble(_charSeq)); _repeat199++) {
							bedRoom++;
							bedType++;
							floor++;
							map = new HashMap<>();
							map.put("bedroom", String.valueOf((long)(bedRoom)));
							map.put("bedtype", String.valueOf((long)(bedType)));
							map.put("floor", String.valueOf((long)(floor)));
							bedroom_listmap.add(map);
							recyclerview2.setAdapter(new Recyclerview2Adapter(bedroom_listmap));
							if (getIntent().getStringExtra("edit").equals("false")) {
								add_bedroom.setVisibility(View.GONE);
							}
						}
					}
				}
				else {
					num = 0;
					add_bedroom.setVisibility(View.GONE);
					textview57.setVisibility(View.GONE);
					bedroom_listmap.clear();
					recyclerview2.setAdapter(new Recyclerview2Adapter(bedroom_listmap));
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		remove_bed2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				added_layout.setVisibility(View.GONE);
				add_bedroom.setVisibility(View.VISIBLE);
			}
		});
		
		bedtype2_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedtype2_option);
				
				Menu menu = popup.getMenu();
				menu.add("Single Bed");
				menu.add("Double Bed");
				menu.add("Double Deck");
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "Single Bed":
							bed_type2.setText("Single Bed");
							return true; case "Double Bed":
							bed_type2.setText("Double Bed");
							return true; case "Double Deck":
							bed_type2.setText("Double Deck");
							return true; default: return false; } } }); popup.show();
			}
		});
		
		girls_add_bedroom.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (1 < girlsRemove) {
					if (girlsRemove > 1) {
						girls_add_bedroom.setVisibility(View.GONE);
						girlsNum = girlsNum;
						for(int _repeat54 = 0; _repeat54 < (int)(1); _repeat54++) {
							girlsNum++;
							map = new HashMap<>();
							map.put("girls bedroom num", String.valueOf((long)(girlsNum)));
							girls_listmap.add(map);
							coed_girls_recycler.setAdapter(new Coed_girls_recyclerAdapter(girls_listmap));
						}
					}
				}
				else {
					girlsNum = girlsNum;
					for(int _repeat20 = 0; _repeat20 < (int)(1); _repeat20++) {
						girlsNum++;
						map = new HashMap<>();
						map.put("girls bedroom num", String.valueOf((long)(girlsNum)));
						girls_listmap.add(map);
						coed_girls_recycler.setAdapter(new Coed_girls_recyclerAdapter(girls_listmap));
					}
				}
			}
		});
		
		boys_add_bedroom.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (1 < boysRemove) {
					if (boysRemove > 1) {
						boys_add_bedroom.setVisibility(View.GONE);
						boysNum = boysNum;
						for(int _repeat18 = 0; _repeat18 < (int)(1); _repeat18++) {
							boysNum++;
							map = new HashMap<>();
							map.put("boys bedroom num", String.valueOf((long)(boysNum)));
							boys_listmap.add(map);
							coed_boys_recycler.setAdapter(new Coed_boys_recyclerAdapter(boys_listmap));
						}
					}
				}
				else {
					boysNum = boysNum;
					for(int _repeat42 = 0; _repeat42 < (int)(1); _repeat42++) {
						boysNum++;
						map = new HashMap<>();
						map.put("boys bedroom num", String.valueOf((long)(boysNum)));
						boys_listmap.add(map);
						coed_boys_recycler.setAdapter(new Coed_boys_recyclerAdapter(boys_listmap));
					}
				}
			}
		});
		
		girls_bedtype_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, girls_bedtype_option);
				
				Menu menu = popup.getMenu();
				menu.add("Single Bed");
				menu.add("Double Bed");
				menu.add("Double Deck");
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "Single Bed":
							girls_bedtype.setText("Single Bed");
							return true; case "Double Bed":
							girls_bedtype.setText("Double Bed");
							return true; case "Double Deck":
							girls_bedtype.setText("Double Deck");
							return true; default: return false; } } }); popup.show();
			}
		});
		
		boys_bedtype_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_bedtype_option);
				
				Menu menu = popup.getMenu();
				menu.add("Single Bed");
				menu.add("Double Bed");
				menu.add("Double Deck");
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "Single Bed":
							boys_bedtype.setText("Single Bed");
							return true; case "Double Bed":
							boys_bedtype.setText("Double Bed");
							return true; case "Double Deck":
							boys_bedtype.setText("Double Deck");
							return true; default: return false; } } }); popup.show();
			}
		});
		
		insert_photo1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(photo1, REQ_CD_PHOTO1);
			}
		});
		
		insert_photo2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(photo2, REQ_CD_PHOTO2);
			}
		});
		
		insert_photo3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(photo3, REQ_CD_PHOTO3);
			}
		});
		
		insert_photo4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(photo4, REQ_CD_PHOTO4);
			}
		});
		
		insert_photo5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(photo5, REQ_CD_PHOTO5);
			}
		});
		
		insert_photo6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(photo6, REQ_CD_PHOTO6);
			}
		});
		
		insert_photo7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(photo7, REQ_CD_PHOTO7);
			}
		});
		
		insert_photo8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(photo8, REQ_CD_PHOTO8);
			}
		});
		
		insert_photo9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(photo9, REQ_CD_PHOTO9);
			}
		});
		
		insert_photo10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(photo10, REQ_CD_PHOTO10);
			}
		});
		
		insert_photo11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(photo11, REQ_CD_PHOTO11);
			}
		});
		
		insert_photo12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(photo12, REQ_CD_PHOTO12);
			}
		});
		
		policy_pets_allowed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					policy_pets_not_allowed.setChecked(false);
				}
				else {
					
				}
			}
		});
		
		policy_pets_not_allowed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					policy_pets_allowed.setChecked(false);
				}
				else {
					
				}
			}
		});
		
		policy_smoking_allowed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					policy_not_smoking_allowed.setChecked(false);
				}
				else {
					
				}
			}
		});
		
		policy_not_smoking_allowed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					policy_smoking_allowed.setChecked(false);
				}
				else {
					
				}
			}
		});
		
		add_beds.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (1 < bedroomNum) {
					if (bedroomNum > 1) {
						add_beds.setVisibility(View.GONE);
					}
				}
				else {
					
				}
				bedroomNum = bedroomNum;
				for(int _repeat23 = 0; _repeat23 < (int)(1); _repeat23++) {
					bedroomNum++;
					map = new HashMap<>();
					map.put("bedroom num", String.valueOf((long)(bedroomNum)));
					rates_listmap.add(map);
					recyclerview3.setAdapter(new Recyclerview3Adapter(rates_listmap));
				}
			}
		});
		
		rates_bedroom_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (String.valueOf((long)(num)).equals("1")) {
					PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, rates_bedroom_option);
					
					Menu menu = popup.getMenu();
					menu.add("1");
					 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
								price_bedroom1.setText("1");
								return true; default: return false; } } }); popup.show();
				}
				else {
					if (String.valueOf((long)(num)).equals("2")) {
						PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, rates_bedroom_option);
						
						Menu menu = popup.getMenu();
						menu.add("1");
						menu.add("2");
						 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
									price_bedroom1.setText("1");
									return true; case "2":
									price_bedroom1.setText("2");
									return true; default: return false; } } }); popup.show();
					}
					else {
						if (String.valueOf((long)(num)).equals("3")) {
							PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, rates_bedroom_option);
							
							Menu menu = popup.getMenu();
							menu.add("1");
							menu.add("2");
							menu.add("3");
							 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
										price_bedroom1.setText("1");
										return true; case "2":
										price_bedroom1.setText("2");
										return true; case "3":
										price_bedroom1.setText("3");
										return true; default: return false; } } }); popup.show();
						}
						else {
							if (String.valueOf((long)(num)).equals("4")) {
								PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, rates_bedroom_option);
								
								Menu menu = popup.getMenu();
								menu.add("1");
								menu.add("2");
								menu.add("3");
								menu.add("4");
								 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
											price_bedroom1.setText("1");
											return true; case "2":
											price_bedroom1.setText("2");
											return true; case "3":
											price_bedroom1.setText("3");
											return true; case "4":
											price_bedroom1.setText("4");
											return true; default: return false; } } }); popup.show();
							}
							else {
								if (String.valueOf((long)(num)).equals("5")) {
									PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, rates_bedroom_option);
									
									Menu menu = popup.getMenu();
									menu.add("1");
									menu.add("2");
									menu.add("3");
									menu.add("4");
									menu.add("5");
									 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
												price_bedroom1.setText("1");
												return true; case "2":
												price_bedroom1.setText("2");
												return true; case "3":
												price_bedroom1.setText("3");
												return true; case "4":
												price_bedroom1.setText("4");
												return true; case "5":
												price_bedroom1.setText("5");
												return true; default: return false; } } }); popup.show();
								}
								else {
									if (String.valueOf((long)(num)).equals("6")) {
										PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, rates_bedroom_option);
										
										Menu menu = popup.getMenu();
										menu.add("1");
										menu.add("2");
										menu.add("3");
										menu.add("4");
										menu.add("5");
										menu.add("6");
										 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
													price_bedroom1.setText("1");
													return true; case "2":
													price_bedroom1.setText("2");
													return true; case "3":
													price_bedroom1.setText("3");
													return true; case "4":
													price_bedroom1.setText("4");
													return true; case "5":
													price_bedroom1.setText("5");
													return true; case "6":
													price_bedroom1.setText("6");
													return true; default: return false; } } }); popup.show();
									}
									else {
										if (String.valueOf((long)(num)).equals("7")) {
											PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, rates_bedroom_option);
											
											Menu menu = popup.getMenu();
											menu.add("1");
											menu.add("2");
											menu.add("3");
											menu.add("4");
											menu.add("5");
											menu.add("6");
											menu.add("7");
											 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
														price_bedroom1.setText("1");
														return true; case "2":
														price_bedroom1.setText("2");
														return true; case "3":
														price_bedroom1.setText("3");
														return true; case "4":
														price_bedroom1.setText("4");
														return true; case "5":
														price_bedroom1.setText("5");
														return true; case "6":
														price_bedroom1.setText("6");
														return true; case "7":
														price_bedroom1.setText("7");
														return true; default: return false; } } }); popup.show();
										}
										else {
											if (String.valueOf((long)(num)).equals("8")) {
												PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, rates_bedroom_option);
												
												Menu menu = popup.getMenu();
												menu.add("1");
												menu.add("2");
												menu.add("3");
												menu.add("4");
												menu.add("5");
												menu.add("6");
												menu.add("7");
												menu.add("8");
												 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
															price_bedroom1.setText("1");
															return true; case "2":
															price_bedroom1.setText("2");
															return true; case "3":
															price_bedroom1.setText("3");
															return true; case "4":
															price_bedroom1.setText("4");
															return true; case "5":
															price_bedroom1.setText("5");
															return true; case "6":
															price_bedroom1.setText("6");
															return true; case "7":
															price_bedroom1.setText("7");
															return true; case "8":
															price_bedroom1.setText("8");
															return true; default: return false; } } }); popup.show();
											}
											else {
												if (String.valueOf((long)(num)).equals("9")) {
													PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, rates_bedroom_option);
													
													Menu menu = popup.getMenu();
													menu.add("1");
													menu.add("2");
													menu.add("3");
													menu.add("4");
													menu.add("5");
													menu.add("6");
													menu.add("7");
													menu.add("8");
													menu.add("9");
													 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
																price_bedroom1.setText("1");
																return true; case "2":
																price_bedroom1.setText("2");
																return true; case "3":
																price_bedroom1.setText("3");
																return true; case "4":
																price_bedroom1.setText("4");
																return true; case "5":
																price_bedroom1.setText("5");
																return true; case "6":
																price_bedroom1.setText("6");
																return true; case "7":
																price_bedroom1.setText("7");
																return true; case "8":
																price_bedroom1.setText("8");
																return true; case "9":
																price_bedroom1.setText("9");
																return true; default: return false; } } }); popup.show();
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
		
		rates_floor_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, rates_floor_option);
				
				Menu menu = popup.getMenu();
				menu.add("1");
				menu.add("2");
				menu.add("3");
				menu.add("4");
				menu.add("5");
				menu.add("6");
				menu.add("7");
				menu.add("8");
				menu.add("9");
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
							price_floor.setText("1");
							return true; case "2":
							price_floor.setText("2");
							return true; case "3":
							price_floor.setText("3");
							return true; case "4":
							price_floor.setText("4");
							return true; case "5":
							price_floor.setText("5");
							return true; case "6":
							price_floor.setText("6");
							return true; case "7":
							price_floor.setText("7");
							return true; case "8":
							price_floor.setText("8");
							return true; case "9":
							price_floor.setText("9");
							return true; default: return false; } } }); popup.show();
			}
		});
		
		rates_status_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, rates_status_option);
				
				Menu menu = popup.getMenu();
				menu.add("Available");
				menu.add("Occupied");
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "Available":
							rates_status.setText("Available");
							return true; case "Occupied":
							rates_status.setText("Occupied");
							return true; default: return false; } } }); popup.show();
			}
		});
		
		boys_add_beds.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (1 < boysBedroomNum) {
					if (boysBedroomNum > 1) {
						boys_add_beds.setVisibility(View.GONE);
					}
				}
				else {
					
				}
				boysBedroomNum = boysBedroomNum;
				for(int _repeat13 = 0; _repeat13 < (int)(1); _repeat13++) {
					boysBedroomNum++;
					map = new HashMap<>();
					map.put("boys bedroom num", String.valueOf((long)(boysBedroomNum)));
					boys_bedroom_listmap.add(map);
					recyclerview4.setAdapter(new Recyclerview4Adapter(boys_bedroom_listmap));
				}
			}
		});
		
		boys_bedroom_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (String.valueOf((long)(num)).equals("1")) {
					PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_bedroom_option);
					
					Menu menu = popup.getMenu();
					menu.add("1");
					 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
								price_boys_bedroom.setText("1");
								return true; default: return false; } } }); popup.show();
				}
				else {
					if (String.valueOf((long)(num)).equals("2")) {
						PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_bedroom_option);
						
						Menu menu = popup.getMenu();
						menu.add("1");
						menu.add("2");
						 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
									price_boys_bedroom.setText("1");
									return true; case "2":
									price_boys_bedroom.setText("2");
									return true; default: return false; } } }); popup.show();
					}
					else {
						if (String.valueOf((long)(num)).equals("3")) {
							PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_bedroom_option);
							
							Menu menu = popup.getMenu();
							menu.add("1");
							menu.add("2");
							menu.add("3");
							 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
										price_boys_bedroom.setText("1");
										return true; case "2":
										price_boys_bedroom.setText("2");
										return true; case "3":
										price_boys_bedroom.setText("3");
										return true; default: return false; } } }); popup.show();
						}
						else {
							if (String.valueOf((long)(num)).equals("4")) {
								PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_bedroom_option);
								
								Menu menu = popup.getMenu();
								menu.add("1");
								menu.add("2");
								menu.add("3");
								menu.add("4");
								 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
											price_boys_bedroom.setText("1");
											return true; case "2":
											price_boys_bedroom.setText("2");
											return true; case "3":
											price_boys_bedroom.setText("3");
											return true; case "4":
											price_boys_bedroom.setText("4");
											return true; default: return false; } } }); popup.show();
							}
							else {
								if (String.valueOf((long)(num)).equals("5")) {
									PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_bedroom_option);
									
									Menu menu = popup.getMenu();
									menu.add("1");
									menu.add("2");
									menu.add("3");
									menu.add("4");
									menu.add("5");
									 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
												price_boys_bedroom.setText("1");
												return true; case "2":
												price_boys_bedroom.setText("2");
												return true; case "3":
												price_boys_bedroom.setText("3");
												return true; case "4":
												price_boys_bedroom.setText("4");
												return true; case "5":
												price_boys_bedroom.setText("5");
												return true; default: return false; } } }); popup.show();
								}
								else {
									if (String.valueOf((long)(num)).equals("6")) {
										PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_bedroom_option);
										
										Menu menu = popup.getMenu();
										menu.add("1");
										menu.add("2");
										menu.add("3");
										menu.add("4");
										menu.add("5");
										menu.add("6");
										 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
													price_boys_bedroom.setText("1");
													return true; case "2":
													price_boys_bedroom.setText("2");
													return true; case "3":
													price_boys_bedroom.setText("3");
													return true; case "4":
													price_boys_bedroom.setText("4");
													return true; case "5":
													price_boys_bedroom.setText("5");
													return true; case "6":
													price_boys_bedroom.setText("6");
													return true; default: return false; } } }); popup.show();
									}
									else {
										if (String.valueOf((long)(num)).equals("7")) {
											PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_bedroom_option);
											
											Menu menu = popup.getMenu();
											menu.add("1");
											menu.add("2");
											menu.add("3");
											menu.add("4");
											menu.add("5");
											menu.add("6");
											menu.add("7");
											 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
														price_boys_bedroom.setText("1");
														return true; case "2":
														price_boys_bedroom.setText("2");
														return true; case "3":
														price_boys_bedroom.setText("3");
														return true; case "4":
														price_boys_bedroom.setText("4");
														return true; case "5":
														price_boys_bedroom.setText("5");
														return true; case "6":
														price_boys_bedroom.setText("6");
														return true; case "7":
														price_boys_bedroom.setText("7");
														return true; default: return false; } } }); popup.show();
										}
										else {
											if (String.valueOf((long)(num)).equals("8")) {
												PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_bedroom_option);
												
												Menu menu = popup.getMenu();
												menu.add("1");
												menu.add("2");
												menu.add("3");
												menu.add("4");
												menu.add("5");
												menu.add("6");
												menu.add("7");
												menu.add("8");
												 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
															price_boys_bedroom.setText("1");
															return true; case "2":
															price_boys_bedroom.setText("2");
															return true; case "3":
															price_boys_bedroom.setText("3");
															return true; case "4":
															price_boys_bedroom.setText("4");
															return true; case "5":
															price_boys_bedroom.setText("5");
															return true; case "6":
															price_boys_bedroom.setText("6");
															return true; case "7":
															price_boys_bedroom.setText("7");
															return true; case "8":
															price_boys_bedroom.setText("8");
															return true; default: return false; } } }); popup.show();
											}
											else {
												if (String.valueOf((long)(num)).equals("9")) {
													PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_bedroom_option);
													
													Menu menu = popup.getMenu();
													menu.add("1");
													menu.add("2");
													menu.add("3");
													menu.add("4");
													menu.add("5");
													menu.add("6");
													menu.add("7");
													menu.add("8");
													menu.add("9");
													 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
																price_boys_bedroom.setText("1");
																return true; case "2":
																price_boys_bedroom.setText("2");
																return true; case "3":
																price_boys_bedroom.setText("3");
																return true; case "4":
																price_boys_bedroom.setText("4");
																return true; case "5":
																price_boys_bedroom.setText("5");
																return true; case "6":
																price_boys_bedroom.setText("6");
																return true; case "7":
																price_boys_bedroom.setText("7");
																return true; case "8":
																price_boys_bedroom.setText("8");
																return true; case "9":
																price_boys_bedroom.setText("9");
																return true; default: return false; } } }); popup.show();
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
		
		boys_floor_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_floor_option);
				
				Menu menu = popup.getMenu();
				menu.add("1");
				menu.add("2");
				menu.add("3");
				menu.add("4");
				menu.add("5");
				menu.add("6");
				menu.add("7");
				menu.add("8");
				menu.add("9");
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
							price_boys_floor.setText("1");
							return true; case "2":
							price_boys_floor.setText("2");
							return true; case "3":
							price_boys_floor.setText("3");
							return true; case "4":
							price_boys_floor.setText("4");
							return true; case "5":
							price_boys_floor.setText("5");
							return true; case "6":
							price_boys_floor.setText("6");
							return true; case "7":
							price_boys_floor.setText("7");
							return true; case "8":
							price_boys_floor.setText("8");
							return true; case "9":
							price_boys_floor.setText("9");
							return true; default: return false; } } }); popup.show();
			}
		});
		
		boys_status_option.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_status_option);
				
				Menu menu = popup.getMenu();
				menu.add("Available");
				menu.add("Occupied");
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "Available":
							price_boys_status.setText("Available");
							return true; case "Occupied":
							price_boys_status.setText("Occupied");
							return true; default: return false; } } }); popup.show();
			}
		});
		
		switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					amount_advance.setEnabled(true);
				}
				else {
					amount_advance.setEnabled(false);
				}
			}
		});
		
		amount_advance.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (0 < amount_advance.getText().toString().length()) {
					if (_charSeq.length() > 0) {
						data.edit().putString("advance", amount_advance.getText().toString()).commit();
						amountAdvance = Double.parseDouble(amount_advance.getText().toString());
					}
				}
				else {
					data.edit().remove("advance").commit();
					amountAdvance = 0;
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					amount_deposit.setEnabled(true);
				}
				else {
					amount_deposit.setEnabled(false);
				}
			}
		});
		
		amount_deposit.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (0 < amount_deposit.getText().toString().length()) {
					if (_charSeq.length() > 0) {
						data.edit().putString("deposit", amount_deposit.getText().toString()).commit();
						amountDeposit = Double.parseDouble(amount_deposit.getText().toString());
					}
				}
				else {
					data.edit().remove("deposit").commit();
					amountDeposit = 0;
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		rates_per_night.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		select_reviews_ratings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), AllReviewsActivity.class);
				intent.putExtra("getPost", getIntent().getStringExtra("getPost"));
				startActivity(intent);
			}
		});
		
		select_add_dormitory.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				//AMENITIES
				if (canteen.isChecked()) {
					data.edit().putString("canteen", canteen.getText().toString()).commit();
				}
				else {
					data.edit().remove("canteen").commit();
				}
				if (visiting_area.isChecked()) {
					data.edit().putString("visiting_area", visiting_area.getText().toString()).commit();
				}
				else {
					data.edit().remove("visiting_area").commit();
				}
				if (parking_area.isChecked()) {
					data.edit().putString("parking_area", parking_area.getText().toString()).commit();
				}
				else {
					data.edit().remove("parking_area").commit();
				}
				if (common_bathroom.isChecked()) {
					data.edit().putString("common_bathroom", common_bathroom.getText().toString()).commit();
				}
				else {
					data.edit().remove("common_bathroom").commit();
				}
				if (laundry.isChecked()) {
					data.edit().putString("laundry", laundry.getText().toString()).commit();
				}
				else {
					data.edit().remove("laundry").commit();
				}
				//INCLUSION
				if (included_internet.isChecked()) {
					data.edit().putString("included_internet", included_internet.getText().toString()).commit();
				}
				else {
					data.edit().remove("included_internet").commit();
				}
				if (included_cabinet.isChecked()) {
					data.edit().putString("included_cabinet", included_cabinet.getText().toString()).commit();
				}
				else {
					data.edit().remove("included_cabinet").commit();
				}
				if (policy_pets_allowed.isChecked()) {
					data.edit().putString("included_allow_pets", policy_pets_allowed.getText().toString()).commit();
				}
				else {
					data.edit().remove("included_allow_pets").commit();
				}
				if (included_electric_fan.isChecked()) {
					data.edit().putString("included_electric_fan", included_electric_fan.getText().toString()).commit();
				}
				else {
					data.edit().remove("included_electric_fan").commit();
				}
				if (included_rice_cooker.isChecked()) {
					data.edit().putString("included_rice_cooker", included_rice_cooker.getText().toString()).commit();
				}
				else {
					data.edit().remove("included_rice_cooker").commit();
				}
				if (included_parking_area.isChecked()) {
					data.edit().putString("included_parking_area", included_parking_area.getText().toString()).commit();
				}
				else {
					data.edit().remove("included_parking_area").commit();
				}
				if (included_common_bathroom.isChecked()) {
					data.edit().putString("included_common_bathroom", included_common_bathroom.getText().toString()).commit();
				}
				else {
					data.edit().remove("included_common_bathroom").commit();
				}
				if (included_charging_port.isChecked()) {
					data.edit().putString("included_charging_port", included_charging_port.getText().toString()).commit();
				}
				else {
					data.edit().remove("included_charging_port").commit();
				}
				if (included_water.isChecked()) {
					data.edit().putString("included_water", included_water.getText().toString()).commit();
				}
				else {
					data.edit().remove("included_water").commit();
				}
				if (included_electricity.isChecked()) {
					data.edit().putString("included_electricity", included_electricity.getText().toString()).commit();
				}
				else {
					data.edit().remove("included_electricity").commit();
				}
				//POLICY
				if (policy_pets_allowed.isChecked()) {
					data.edit().putString("policy_pets_allowed", policy_pets_allowed.getText().toString()).commit();
				}
				else {
					data.edit().remove("policy_pets_allowed").commit();
				}
				if (policy_pets_not_allowed.isChecked()) {
					data.edit().putString("policy_pets_not_allowed", policy_pets_not_allowed.getText().toString()).commit();
				}
				else {
					data.edit().remove("policy_pets_not_allowed").commit();
				}
				if (policy_smoking_allowed.isChecked()) {
					data.edit().putString("policy_smoking_allowed", policy_smoking_allowed.getText().toString()).commit();
				}
				else {
					data.edit().remove("policy_smoking_allowed").commit();
				}
				if (policy_not_smoking_allowed.isChecked()) {
					data.edit().putString("policy_not_smoking_allowed", policy_not_smoking_allowed.getText().toString()).commit();
				}
				else {
					data.edit().remove("policy_not_smoking_allowed").commit();
				}
				if (edit.equals("")) {
					network.startRequestNetwork(RequestNetworkController.GET, "https://dorm-finder-df3f2-default-rtdb.firebaseio.com/", "Error", _network_request_listener);
					_telegramLoaderDialog(true);
				}
				else {
					if (edit.equals("true")) {
						edit_network.startRequestNetwork(RequestNetworkController.GET, "https://dorm-finder-df3f2-default-rtdb.firebaseio.com/", "Error", _edit_network_request_listener);
						_telegramLoaderDialog(true);
					}
				}
			}
		});
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				post1.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo1/".concat(getPost))))))).putFile(Uri.fromFile(new File(img1))).addOnFailureListener(_post1_failure_listener).addOnProgressListener(_post1_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return post1.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo1/".concat(getPost))))))).getDownloadUrl();
					}}).addOnCompleteListener(_post1_upload_success_listener);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_post1_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post1_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post1_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				post2.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo2/".concat(getPost))))))).putFile(Uri.fromFile(new File(img2))).addOnFailureListener(_post2_failure_listener).addOnProgressListener(_post2_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return post2.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo2/".concat(getPost))))))).getDownloadUrl();
					}}).addOnCompleteListener(_post2_upload_success_listener);
				success_img1 = _downloadUrl;
			}
		};
		
		_post1_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_post1_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_post1_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_post2_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post2_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post2_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				post3.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo3/".concat(getPost))))))).putFile(Uri.fromFile(new File(img3))).addOnFailureListener(_post3_failure_listener).addOnProgressListener(_post3_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return post3.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo3/".concat(getPost))))))).getDownloadUrl();
					}}).addOnCompleteListener(_post3_upload_success_listener);
				success_img2 = _downloadUrl;
			}
		};
		
		_post2_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_post2_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_post2_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_post3_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post3_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post3_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				post4.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo4/".concat(getPost))))))).putFile(Uri.fromFile(new File(img4))).addOnFailureListener(_post4_failure_listener).addOnProgressListener(_post4_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return post4.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo4/".concat(getPost))))))).getDownloadUrl();
					}}).addOnCompleteListener(_post4_upload_success_listener);
				success_img3 = _downloadUrl;
			}
		};
		
		_post3_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_post3_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_post3_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_post4_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post4_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post4_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				post5.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo5/".concat(getPost))))))).putFile(Uri.fromFile(new File(img5))).addOnFailureListener(_post5_failure_listener).addOnProgressListener(_post5_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return post5.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo5/".concat(getPost))))))).getDownloadUrl();
					}}).addOnCompleteListener(_post5_upload_success_listener);
				success_img4 = _downloadUrl;
			}
		};
		
		_post4_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_post4_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_post4_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_post_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("getPost"))) {
					lat = Double.parseDouble(_childValue.get("latitude").toString());
					lng = Double.parseDouble(_childValue.get("longitude").toString());
					type_of_dormitory = _childValue.get("type of dormitory").toString();
					owners_firstname.setText(_childValue.get("dormitory firstname").toString());
					owners_middle_initial.setText(_childValue.get("dormitory middle").toString());
					owners_lastname.setText(_childValue.get("dormitory lastname").toString());
					dormitory_name.setText(_childValue.get("dormitory name").toString());
					description.setText(_childValue.get("description").toString());
					street.setText(_childValue.get("street").toString());
					barangay.setText(_childValue.get("barangay").toString());
					city.setText(_childValue.get("city").toString());
					province.setText(_childValue.get("province").toString());
					latitude.setText(_childValue.get("latitude").toString());
					longitude.setText(_childValue.get("longitude").toString());
					if (_childValue.get("rates bedroom").toString().equals("") || (_childValue.get("rates bed").toString().equals("") || _childValue.get("rates floor").toString().equals(""))) {
						
					}
					else {
						bedroom = _childValue.get("rates bedroom").toString();
						bedtype = _childValue.get("rates bed").toString();
						rates_floor = _childValue.get("rates floor").toString();
					}
					room_available.setText(_childValue.get("room available").toString());
					room_occupied.setText(_childValue.get("room occupied").toString());
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo1").toString())).into(insert_photo1);
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo2").toString())).into(insert_photo2);
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo3").toString())).into(insert_photo3);
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo4").toString())).into(insert_photo4);
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo5").toString())).into(insert_photo5);
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo6").toString())).into(insert_photo6);
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo7").toString())).into(insert_photo7);
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo8").toString())).into(insert_photo8);
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo9").toString())).into(insert_photo9);
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo10").toString())).into(insert_photo10);
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo11").toString())).into(insert_photo11);
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("photo12").toString())).into(insert_photo12);
					total_bedrooms.setText(_childValue.get("total bed rooms").toString());
					if (_childValue.get("type of dormitory").toString().contains("Transcient")) {
						transient_.setChecked(true);
						data.edit().putString("type of dormitory", _childValue.get("type of dormitory").toString()).commit();
					}
					else {
						if (_childValue.get("type of dormitory").toString().contains("Female Dormitory")) {
							female_dormitory.setChecked(true);
							data.edit().putString("type of dormitory", _childValue.get("type of dormitory").toString()).commit();
						}
						else {
							if (_childValue.get("type of dormitory").toString().contains("Male Dormitory")) {
								male_dormitory.setChecked(true);
								data.edit().putString("type of dormitory", _childValue.get("type of dormitory").toString()).commit();
							}
							else {
								if (_childValue.get("type of dormitory").toString().contains("Co-ed Dormitory")) {
									co_ed_dormitory.setChecked(true);
									data.edit().putString("type of dormitory", _childValue.get("type of dormitory").toString()).commit();
								}
								else {
									if (_childValue.get("type of dormitory").toString().contains("Gender Neutral Dormitory")) {
										gender_neutral_dormitory.setChecked(true);
										data.edit().putString("type of dormitory", _childValue.get("type of dormitory").toString()).commit();
									}
								}
							}
						}
					}
					if (_childValue.get("amenities").toString().contains("Canteen")) {
						canteen.setChecked(true);
					}
					else {
						canteen.setChecked(false);
					}
					if (_childValue.get("amenities").toString().contains("Visiting Area")) {
						visiting_area.setChecked(true);
					}
					else {
						visiting_area.setChecked(false);
					}
					if (_childValue.get("amenities").toString().contains("Parking Area")) {
						parking_area.setChecked(true);
					}
					else {
						parking_area.setChecked(false);
					}
					if (_childValue.get("amenities").toString().contains("Common Bathroom")) {
						common_bathroom.setChecked(true);
					}
					else {
						common_bathroom.setChecked(false);
					}
					if (_childValue.get("amenities").toString().contains("Laundry")) {
						laundry.setChecked(true);
					}
					else {
						laundry.setChecked(false);
					}
					others_amenities.setText(_childValue.get("other amenities").toString());
					if (_childValue.get("policy").toString().contains("Pets allowed")) {
						policy_pets_allowed.setChecked(true);
					}
					else {
						policy_pets_allowed.setChecked(false);
					}
					if (_childValue.get("inclusion").toString().contains("Internet")) {
						included_internet.setChecked(true);
					}
					else {
						included_internet.setChecked(false);
					}
					if (_childValue.get("inclusion").toString().contains("Cabinet")) {
						included_cabinet.setChecked(true);
					}
					else {
						included_cabinet.setChecked(false);
					}
					if (_childValue.get("inclusion").toString().contains("Electric Fan")) {
						included_electric_fan.setChecked(true);
					}
					else {
						included_electric_fan.setChecked(false);
					}
					if (_childValue.get("inclusion").toString().contains("Rice Cooker")) {
						included_rice_cooker.setChecked(true);
					}
					else {
						included_rice_cooker.setChecked(false);
					}
					if (_childValue.get("inclusion").toString().contains("Parking Area")) {
						included_parking_area.setChecked(true);
					}
					else {
						included_common_bathroom.setChecked(false);
					}
					if (_childValue.get("inclusion").toString().contains("Charging Port")) {
						included_charging_port.setChecked(true);
					}
					else {
						included_charging_port.setChecked(false);
					}
					if (_childValue.get("inclusion").toString().contains("Common Bathroom")) {
						included_common_bathroom.setChecked(true);
					}
					else {
						included_common_bathroom.setChecked(false);
					}
					if (_childValue.get("inclusion").toString().contains("Water")) {
						included_water.setChecked(true);
					}
					else {
						included_water.setChecked(false);
					}
					if (_childValue.get("inclusion").toString().contains("Electricity")) {
						included_electricity.setChecked(true);
					}
					else {
						included_electricity.setChecked(false);
					}
					others_inclusion.setText(_childValue.get("other inclusion").toString());
					if (_childValue.get("policy").toString().contains("Pets not allowed")) {
						policy_pets_not_allowed.setChecked(true);
					}
					else {
						policy_pets_not_allowed.setChecked(false);
					}
					if (_childValue.get("policy").toString().contains("Smoking allowed")) {
						policy_smoking_allowed.setChecked(true);
					}
					else {
						policy_smoking_allowed.setChecked(false);
					}
					if (_childValue.get("policy").toString().contains("Smoking not allowed")) {
						policy_not_smoking_allowed.setChecked(true);
					}
					else {
						policy_not_smoking_allowed.setChecked(false);
					}
					others_amenities.setText(_childValue.get("other policy").toString());
					price_bedroom1.setText(_childValue.get("rates bedroom").toString());
					price_bedtype.setText(_childValue.get("rates bed").toString());
					price_floor.setText(_childValue.get("rates floor").toString());
					room_rent.setText(_childValue.get("rates monthly price").toString());
					rates_status.setText(_childValue.get("rates status").toString());
					if (_childValue.get("type of dormitory").toString().equals("Transcient")) {
						rates_per_night.setText(_childValue.get("rates per night").toString());
						minimum_stay.setText(_childValue.get("minimum stay").toString());
					}
					else {
						if (_childValue.get("type of dormitory").toString().equals("Female Dormitory") || (_childValue.get("type of dormitory").toString().equals("Male Dormitory") || (_childValue.get("type of dormitory").toString().equals("Co-ed Dormitory") || _childValue.get("type of dormitory").toString().equals("Gender-neutral Dormitory")))) {
							if (Double.parseDouble(_childValue.get("amount advance").toString()) > 0) {
								switch1.setChecked(true);
							}
							if (Double.parseDouble(_childValue.get("amount deposit").toString()) > 0) {
								switch2.setChecked(true);
							}
							amount_advance.setText(_childValue.get("amount advance").toString());
							amount_deposit.setText(_childValue.get("amount deposit").toString());
						}
					}
					if (_childValue.get("type of dormitory").toString().equals("Female Dormitory") || (_childValue.get("type of dormitory").toString().equals("Male Dormitory") || (_childValue.get("type of dormitory").toString().equals("Transcient") || _childValue.get("type of dormitory").toString().equals("Gender-neutral Dormitory")))) {
						bedroom_data = Double.parseDouble(_childValue.get("total bed rooms").toString());
					}
					else {
						
					}
					if (_childValue.get("type of dormitory").toString().equals("Female Dormitory") || (_childValue.get("type of dormitory").toString().equals("Male Dormitory") || _childValue.get("type of dormitory").toString().equals("Gender-neutral Dormitory"))) {
						girls_rate_total = Double.parseDouble(_childValue.get("bedroom count").toString());
						bedroomNum = 0;
						for(int _repeat1683 = 0; _repeat1683 < (int)(girls_rate_total); _repeat1683++) {
							bedroomNum++;
							map = new HashMap<>();
							map.put("bedroom num", String.valueOf((long)(bedroomNum)));
							rates_listmap.add(map);
						}
						post_data_rate.addChildEventListener(_post_data_rate_child_listener);
					}
					else {
						if (_childValue.get("type of dormitory").toString().equals("Co-ed Dormitory")) {
							price_boys_bedroom.setText(_childValue.get("boys rates bedroom").toString());
							price_boys_bed.setText(_childValue.get("boys rates bed").toString());
							price_boys_floor.setText(_childValue.get("boys rates floor").toString());
							price_boys_monthly.setText(_childValue.get("boys rates monthly price").toString());
							price_boys_status.setText(_childValue.get("boys rates status").toString());
							girlsBedCount = Double.parseDouble(_childValue.get("girls bed count").toString());
							boysBedCount = Double.parseDouble(_childValue.get("boys bed count").toString());
							girls_rate_total = Double.parseDouble(_childValue.get("bedroom count").toString());
							boys_rate_total = Double.parseDouble(_childValue.get("boys bedroom count").toString());
							//GIRLS BEDS
							if (girlsBedCount == 3) {
								girls_add_bedroom.setVisibility(View.GONE);
							}
							girlsNum = 0;
							for(int _repeat1791 = 0; _repeat1791 < (int)(girlsBedCount); _repeat1791++) {
								girlsNum++;
								map = new HashMap<>();
								map.put("girls bedroom num", String.valueOf((long)(girlsNum)));
								girls_listmap.add(map);
							}
							//BOYS BEDS
							if (boysBedCount == 3) {
								boys_add_bedroom.setVisibility(View.GONE);
							}
							boysNum = 0;
							for(int _repeat1817 = 0; _repeat1817 < (int)(boysBedCount); _repeat1817++) {
								boysNum++;
								map = new HashMap<>();
								map.put("boys bedroom num", String.valueOf((long)(boysNum)));
								boys_listmap.add(map);
							}
							//GIRLS RATES
							if (girls_rate_total == 3) {
								add_beds.setVisibility(View.GONE);
							}
							bedroomNum = 0;
							for(int _repeat1731 = 0; _repeat1731 < (int)(girls_rate_total); _repeat1731++) {
								bedroomNum++;
								map = new HashMap<>();
								map.put("bedroom num", String.valueOf((long)(bedroomNum)));
								rates_listmap.add(map);
							}
							//BOYS RATES
							if (boys_rate_total == 3) {
								boys_add_beds.setVisibility(View.GONE);
							}
							boysBedroomNum = 0;
							for(int _repeat1752 = 0; _repeat1752 < (int)(boys_rate_total); _repeat1752++) {
								boysBedroomNum++;
								map = new HashMap<>();
								map.put("boys bedroom num", String.valueOf((long)(boysBedroomNum)));
								boys_bedroom_listmap.add(map);
							}
							post_data_rate_boy.addChildEventListener(_post_data_rate_boy_child_listener);
						}
						else {
							
						}
					}
					post_data.addChildEventListener(_post_data_child_listener);
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
		post.addChildEventListener(_post_child_listener);
		
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
		
		_edit_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				getPost = getIntent().getStringExtra("getPost");
				map = new HashMap<>();
				map.put("dormitory firstname", owners_firstname.getText().toString());
				map.put("dormitory middle", owners_middle_initial.getText().toString());
				map.put("dormitory lastname", owners_lastname.getText().toString());
				map.put("dormitory name", dormitory_name.getText().toString());
				map.put("description", description.getText().toString());
				map.put("street", street.getText().toString());
				map.put("barangay", barangay.getText().toString());
				map.put("city", city.getText().toString());
				map.put("province", province.getText().toString());
				map.put("latitude", String.valueOf(lat));
				map.put("longitude", String.valueOf(lng));
				_bedRoomType();
				if (co_ed_dormitory.isChecked()) {
					_girls_coed();
					_boys_coed();
					map.put("room available boys", room_available_boys.getText().toString());
					map.put("room available girls", room_available_girls.getText().toString());
					_rates();
					_boys_rates();
					map.put("amount advance", String.valueOf((long)(amountAdvance)));
					map.put("amount deposit", String.valueOf((long)(amountDeposit)));
					map.put("bedroom count", String.valueOf((long)(bedroomNum)));
					map.put("boys bedroom count", String.valueOf((long)(boysBedroomNum)));
					map.put("girls bed count", String.valueOf((long)(girlsNum)));
					map.put("boys bed count", String.valueOf((long)(boysNum)));
				}
				else {
					if (transient_.isChecked()) {
						_transcient();
						map.put("rates per night", rates_per_night.getText().toString());
						map.put("minimum stay", minimum_stay.getText().toString());
					}
					else {
						if (female_dormitory.isChecked() || (gender_neutral_dormitory.isChecked() || male_dormitory.isChecked())) {
							_rates();
							map.put("amount advance", String.valueOf((long)(amountAdvance)));
							map.put("amount deposit", String.valueOf((long)(amountDeposit)));
							map.put("bedroom count", String.valueOf((long)(bedroomNum)));
						}
					}
				}
				map.put("room available", room_available.getText().toString());
				map.put("room occupied", room_occupied.getText().toString());
				map.put("type of dormitory", data.getString("type of dormitory", ""));
				map.put("amenities", data.getString("canteen", "").concat(" ".concat(data.getString("visiting_area", "").concat(" ".concat(data.getString("parking_area", "").concat(" ".concat(data.getString("common_bathroom", "").concat(" ".concat(data.getString("laundry", ""))))))))));
				map.put("other amenities", others_amenities.getText().toString());
				map.put("inclusion", data.getString("included_internet", "").concat(" ".concat(data.getString("included_cabinet", "").concat(" ".concat(data.getString("included_allow_pets", "").concat(" ".concat(data.getString("included_electric_fan", "").concat(" ".concat(data.getString("included_rice_cooker", "").concat(" ".concat(data.getString("included_parking_area", "").concat(" ".concat(data.getString("included_charging_port", "").concat(" ".concat(data.getString("included_common_bathroom", "").concat(" ".concat(data.getString("included_water", "").concat(" ".concat(data.getString("included_electricity", "").concat(" ".concat(others_inclusion.getText().toString())))))))))))))))))))));
				map.put("other inclusion", others_inclusion.getText().toString());
				map.put("policy", data.getString("policy_pets_allowed", "").concat(" ".concat(data.getString("policy_pets_not_allowed", "").concat(" ".concat(data.getString("policy_smoking_allowed", "").concat(" ".concat(data.getString("policy_not_smoking_allowed", "").concat(" ".concat(others_policy.getText().toString())))))))));
				map.put("other policy", others_policy.getText().toString());
				map.put("getPost", getPost);
				map.put("dormitory uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				map.put("rating", "0");
				post.child(getPost).updateChildren(map);
				_booking_count();
				SketchwareUtil.showMessage(getApplicationContext(), "Posted");
				_telegramLoaderDialog(false);
				finish();
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_loc_location_listener = new LocationListener() {
			@Override
			public void onLocationChanged(Location _param1) {
				final double _lat = _param1.getLatitude();
				final double _lng = _param1.getLongitude();
				final double _acc = _param1.getAccuracy();
				_mapview1_controller.addMarker(dormitory_name.getText().toString(), lat, lng);
				_mapview1_controller.moveCamera(lat, lng);
				_mapview1_controller.zoomTo(19);
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
		
		_post5_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post5_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post5_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				post6.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo6/".concat(getPost))))))).putFile(Uri.fromFile(new File(img6))).addOnFailureListener(_post6_failure_listener).addOnProgressListener(_post6_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return post6.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo6/".concat(getPost))))))).getDownloadUrl();
					}}).addOnCompleteListener(_post6_upload_success_listener);
				success_img5 = _downloadUrl;
			}
		};
		
		_post5_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_post5_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_post5_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_post6_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post6_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post6_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				post7.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo7/".concat(getPost))))))).putFile(Uri.fromFile(new File(img7))).addOnFailureListener(_post7_failure_listener).addOnProgressListener(_post7_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return post7.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo7/".concat(getPost))))))).getDownloadUrl();
					}}).addOnCompleteListener(_post7_upload_success_listener);
				success_img6 = _downloadUrl;
			}
		};
		
		_post6_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_post6_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_post6_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_post7_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post7_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post7_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				post8.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo8/".concat(getPost))))))).putFile(Uri.fromFile(new File(img8))).addOnFailureListener(_post8_failure_listener).addOnProgressListener(_post8_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return post8.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo8/".concat(getPost))))))).getDownloadUrl();
					}}).addOnCompleteListener(_post8_upload_success_listener);
				success_img7 = _downloadUrl;
			}
		};
		
		_post7_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_post7_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_post7_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_post8_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post8_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post8_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				post9.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo9/".concat(getPost))))))).putFile(Uri.fromFile(new File(img9))).addOnFailureListener(_post9_failure_listener).addOnProgressListener(_post9_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return post9.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo9/".concat(getPost))))))).getDownloadUrl();
					}}).addOnCompleteListener(_post9_upload_success_listener);
				success_img8 = _downloadUrl;
			}
		};
		
		_post8_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_post8_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_post8_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_post9_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post9_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post9_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				post10.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo10/".concat(getPost))))))).putFile(Uri.fromFile(new File(img10))).addOnFailureListener(_post10_failure_listener).addOnProgressListener(_post10_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return post10.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo10/".concat(getPost))))))).getDownloadUrl();
					}}).addOnCompleteListener(_post10_upload_success_listener);
				success_img9 = _downloadUrl;
			}
		};
		
		_post9_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_post9_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_post9_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_post10_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post10_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post10_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				post11.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo11/".concat(getPost))))))).putFile(Uri.fromFile(new File(img11))).addOnFailureListener(_post11_failure_listener).addOnProgressListener(_post11_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return post11.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo11/".concat(getPost))))))).getDownloadUrl();
					}}).addOnCompleteListener(_post11_upload_success_listener);
				success_img10 = _downloadUrl;
			}
		};
		
		_post10_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_post10_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_post10_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_post11_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post11_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post11_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				post12.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo12/".concat(getPost))))))).putFile(Uri.fromFile(new File(img12))).addOnFailureListener(_post12_failure_listener).addOnProgressListener(_post12_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return post12.child(owners_firstname.getText().toString().concat(" ".concat(owners_lastname.getText().toString().concat("/".concat(data.getString("type of dormitory", "").concat("/photo12/".concat(getPost))))))).getDownloadUrl();
					}}).addOnCompleteListener(_post12_upload_success_listener);
				img11 = _downloadUrl;
			}
		};
		
		_post11_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_post11_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_post11_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_post12_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post12_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_post12_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				img12 = _downloadUrl;
				map = new HashMap<>();
				map.put("dormitory firstname", owners_firstname.getText().toString());
				map.put("dormitory middle", owners_middle_initial.getText().toString());
				map.put("dormitory lastname", owners_lastname.getText().toString());
				map.put("dormitory name", dormitory_name.getText().toString());
				map.put("description", description.getText().toString());
				map.put("street", street.getText().toString());
				map.put("barangay", barangay.getText().toString());
				map.put("city", city.getText().toString());
				map.put("province", province.getText().toString());
				map.put("latitude", String.valueOf(lat));
				map.put("longitude", String.valueOf(lng));
				_bedRoomType();
				if (co_ed_dormitory.isChecked()) {
					_girls_coed();
					_boys_coed();
					map.put("room available boys", room_available_boys.getText().toString());
					map.put("room available girls", room_available_girls.getText().toString());
					_rates();
					_boys_rates();
					map.put("amount advance", String.valueOf((long)(amountAdvance)));
					map.put("amount deposit", String.valueOf((long)(amountDeposit)));
					map.put("bedroom count", String.valueOf((long)(bedroomRemove)));
					map.put("boys bedroom count", String.valueOf((long)(boysBedroomRemove)));
					map.put("girls bed count", String.valueOf((long)(girlsNum)));
					map.put("boys bed count", String.valueOf((long)(boysNum)));
				}
				else {
					if (transient_.isChecked()) {
						_transcient();
						map.put("rates per night", rates_per_night.getText().toString());
						map.put("minimum stay", minimum_stay.getText().toString());
					}
					else {
						if (female_dormitory.isChecked() || (gender_neutral_dormitory.isChecked() || male_dormitory.isChecked())) {
							_rates();
							map.put("amount advance", String.valueOf((long)(amountAdvance)));
							map.put("amount deposit", String.valueOf((long)(amountDeposit)));
							map.put("bedroom count", String.valueOf((long)(bedroomRemove)));
						}
					}
				}
				map.put("room available", room_available.getText().toString());
				map.put("room occupied", room_occupied.getText().toString());
				map.put("type of dormitory", data.getString("type of dormitory", ""));
				map.put("photo1", success_img1);
				map.put("photo2", success_img2);
				map.put("photo3", success_img3);
				map.put("photo4", success_img4);
				map.put("photo5", success_img5);
				map.put("photo6", success_img6);
				map.put("photo7", success_img7);
				map.put("photo8", success_img8);
				map.put("photo9", success_img9);
				map.put("photo10", success_img10);
				map.put("photo11", success_img11);
				map.put("photo12", success_img12);
				map.put("amenities", data.getString("canteen", "").concat(" ".concat(data.getString("visiting_area", "").concat(" ".concat(data.getString("parking_area", "").concat(" ".concat(data.getString("common_bathroom", "").concat(" ".concat(data.getString("laundry", ""))))))))));
				map.put("other amenities", others_amenities.getText().toString());
				map.put("inclusion", data.getString("included_internet", "").concat(" ".concat(data.getString("included_cabinet", "").concat(" ".concat(data.getString("included_allow_pets", "").concat(" ".concat(data.getString("included_electric_fan", "").concat(" ".concat(data.getString("included_rice_cooker", "").concat(" ".concat(data.getString("included_parking_area", "").concat(" ".concat(data.getString("included_charging_port", "").concat(" ".concat(data.getString("included_common_bathroom", "").concat(" ".concat(data.getString("included_water", "").concat(" ".concat(data.getString("included_electricity", "").concat(" ".concat(others_inclusion.getText().toString())))))))))))))))))))));
				map.put("other inclusion", others_inclusion.getText().toString());
				map.put("policy", data.getString("policy_pets_allowed", "").concat(" ".concat(data.getString("policy_pets_not_allowed", "").concat(" ".concat(data.getString("policy_smoking_allowed", "").concat(" ".concat(data.getString("policy_not_smoking_allowed", "").concat(" ".concat(others_policy.getText().toString())))))))));
				map.put("other policy", others_policy.getText().toString());
				map.put("getPost", getPost);
				map.put("dormitory uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				map.put("rating", "0");
				post.child(getPost).updateChildren(map);
				_booking_count();
				SketchwareUtil.showMessage(getApplicationContext(), "Posted");
				_telegramLoaderDialog(false);
				finish();
			}
		};
		
		_post12_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_post12_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_post12_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_total_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("bookings")) {
					totalBooking = Double.parseDouble(_childValue.get("count").toString());
				}
				if (_childKey.equals("rooms available")) {
					totalAvailable = Double.parseDouble(_childValue.get("count").toString());
				}
				if (_childKey.equals("rooms occupied")) {
					totalOccupied = Double.parseDouble(_childValue.get("count").toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("bookings")) {
					totalBooking = Double.parseDouble(_childValue.get("count").toString());
				}
				if (_childKey.equals("rooms available")) {
					totalAvailable = Double.parseDouble(_childValue.get("count").toString());
				}
				if (_childKey.equals("rooms occupied")) {
					totalOccupied = Double.parseDouble(_childValue.get("count").toString());
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
		
		_network1_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				bedroomNum = bedroomRemove;
				for(int _repeat13 = 0; _repeat13 < (int)(1); _repeat13++) {
					bedroomNum--;
					recyclerview3.setAdapter(new Recyclerview3Adapter(rates_listmap));
					_telegramLoaderDialog(false);
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				bedroomNum = bedroomRemove;
				for(int _repeat12 = 0; _repeat12 < (int)(1); _repeat12++) {
					bedroomNum--;
					recyclerview3.setAdapter(new Recyclerview3Adapter(rates_listmap));
					_telegramLoaderDialog(false);
				}
			}
		};
		
		_girls_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				girlsNum = girlsRemove;
				for(int _repeat12 = 0; _repeat12 < (int)(1); _repeat12++) {
					girlsNum--;
					coed_girls_recycler.setAdapter(new Coed_girls_recyclerAdapter(girls_listmap));
					_telegramLoaderDialog(false);
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				girlsNum = girlsRemove;
				for(int _repeat12 = 0; _repeat12 < (int)(1); _repeat12++) {
					girlsNum--;
					coed_girls_recycler.setAdapter(new Coed_girls_recyclerAdapter(girls_listmap));
					_telegramLoaderDialog(false);
				}
			}
		};
		
		_boys_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				boysNum = boysRemove;
				for(int _repeat12 = 0; _repeat12 < (int)(1); _repeat12++) {
					boysNum--;
					coed_boys_recycler.setAdapter(new Coed_boys_recyclerAdapter(boys_listmap));
					_telegramLoaderDialog(false);
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				boysNum = boysRemove;
				for(int _repeat12 = 0; _repeat12 < (int)(1); _repeat12++) {
					boysNum--;
					coed_boys_recycler.setAdapter(new Coed_boys_recyclerAdapter(boys_listmap));
					_telegramLoaderDialog(false);
				}
			}
		};
		
		_network2_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				boysBedroomNum = boysBedroomRemove;
				for(int _repeat12 = 0; _repeat12 < (int)(1); _repeat12++) {
					boysBedroomNum--;
					recyclerview4.setAdapter(new Recyclerview4Adapter(boys_bedroom_listmap));
					_telegramLoaderDialog(false);
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				boysBedroomNum = boysBedroomRemove;
				for(int _repeat12 = 0; _repeat12 < (int)(1); _repeat12++) {
					boysBedroomNum--;
					recyclerview4.setAdapter(new Recyclerview4Adapter(boys_bedroom_listmap));
					_telegramLoaderDialog(false);
				}
			}
		};
		
		_reviews_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				rev++;
				reviewCount = rev;
				reviews.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						review_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								review_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (review_listmap.size() > 0) {
							recyclerview1.setAdapter(new Recyclerview1Adapter(review_listmap));
							reviews_layout.setVisibility(View.VISIBLE);
						}
						else {
							reviews_layout.setVisibility(View.GONE);
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
		reviews.addChildEventListener(_reviews_child_listener);
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("userKey") && _childValue.containsKey("profile")) {
					UserProfile.put(_childValue.get("userKey").toString(), _childValue.get("profile").toString());
				}
				if (_childValue.containsKey("userKey") && _childValue.containsKey("fullname")) {
					UserName.put(_childValue.get("userKey").toString(), _childValue.get("fullname").toString());
				}
				reviews.addChildEventListener(_reviews_child_listener);
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
		
		_post_data_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("getPost"))) {
					if (_childValue.get("type of dormitory").toString().equals("Female Dormitory") || (_childValue.get("type of dormitory").toString().equals("Male Dormitory") || (_childValue.get("type of dormitory").toString().equals("Transcient") || _childValue.get("type of dormitory").toString().equals("Gender-neutral Dormitory")))) {
						if (_childValue.containsKey("bedroom10")) {
							bedroom_count.setText("Bedroom 10");
							number_bed2.setText(_childValue.get("bedroom10").toString());
							bed_type2.setText(_childValue.get("bedtype10").toString());
							number_floor2.setText(_childValue.get("floor10").toString());
							added_layout.setVisibility(View.VISIBLE);
						}
						if (String.valueOf((long)(bedroom_data)).equals("9")) {
							bedroom_data--;
							data.edit().putString("bedroom9", _childValue.get("bedroom".concat(data.getString("9", ""))).toString()).commit();
							data.edit().putString("bedtype9", _childValue.get("bedtype".concat(data.getString("9", ""))).toString()).commit();
							data.edit().putString("floor9", _childValue.get("floor".concat(data.getString("9", ""))).toString()).commit();
							post_data.addChildEventListener(_post_data_child_listener);
						}
						else {
							if (String.valueOf((long)(bedroom_data)).equals("8")) {
								bedroom_data--;
								data.edit().putString("bedroom8", _childValue.get("bedroom".concat(data.getString("8", ""))).toString()).commit();
								data.edit().putString("bedtype8", _childValue.get("bedtype".concat(data.getString("8", ""))).toString()).commit();
								data.edit().putString("floor8", _childValue.get("floor".concat(data.getString("8", ""))).toString()).commit();
								post_data.addChildEventListener(_post_data_child_listener);
							}
							else {
								if (String.valueOf((long)(bedroom_data)).equals("7")) {
									bedroom_data--;
									data.edit().putString("bedroom7", _childValue.get("bedroom".concat(data.getString("7", ""))).toString()).commit();
									data.edit().putString("bedtype7", _childValue.get("bedtype".concat(data.getString("7", ""))).toString()).commit();
									data.edit().putString("floor7", _childValue.get("floor".concat(data.getString("7", ""))).toString()).commit();
									post_data.addChildEventListener(_post_data_child_listener);
								}
								else {
									if (String.valueOf((long)(bedroom_data)).equals("6")) {
										bedroom_data--;
										data.edit().putString("bedroom6", _childValue.get("bedroom".concat(data.getString("6", ""))).toString()).commit();
										data.edit().putString("bedtype6", _childValue.get("bedtype".concat(data.getString("6", ""))).toString()).commit();
										data.edit().putString("floor6", _childValue.get("floor".concat(data.getString("6", ""))).toString()).commit();
										post_data.addChildEventListener(_post_data_child_listener);
									}
									else {
										if (String.valueOf((long)(bedroom_data)).equals("5")) {
											bedroom_data--;
											data.edit().putString("bedroom5", _childValue.get("bedroom".concat(data.getString("5", ""))).toString()).commit();
											data.edit().putString("bedtype5", _childValue.get("bedtype".concat(data.getString("5", ""))).toString()).commit();
											data.edit().putString("floor5", _childValue.get("floor".concat(data.getString("5", ""))).toString()).commit();
											post_data.addChildEventListener(_post_data_child_listener);
										}
										else {
											if (String.valueOf((long)(bedroom_data)).equals("4")) {
												bedroom_data--;
												data.edit().putString("bedroom4", _childValue.get("bedroom".concat(data.getString("4", ""))).toString()).commit();
												data.edit().putString("bedtype4", _childValue.get("bedtype".concat(data.getString("4", ""))).toString()).commit();
												data.edit().putString("floor4", _childValue.get("floor".concat(data.getString("4", ""))).toString()).commit();
												post_data.addChildEventListener(_post_data_child_listener);
											}
											else {
												if (String.valueOf((long)(bedroom_data)).equals("3")) {
													bedroom_data--;
													data.edit().putString("bedroom3", _childValue.get("bedroom".concat(data.getString("3", ""))).toString()).commit();
													data.edit().putString("bedtype3", _childValue.get("bedtype".concat(data.getString("3", ""))).toString()).commit();
													data.edit().putString("floor3", _childValue.get("floor".concat(data.getString("3", ""))).toString()).commit();
													post_data.addChildEventListener(_post_data_child_listener);
												}
												else {
													if (String.valueOf((long)(bedroom_data)).equals("2")) {
														bedroom_data--;
														data.edit().putString("bedroom2", _childValue.get("bedroom".concat(data.getString("2", ""))).toString()).commit();
														data.edit().putString("bedtype2", _childValue.get("bedtype".concat(data.getString("2", ""))).toString()).commit();
														data.edit().putString("floor2", _childValue.get("floor".concat(data.getString("2", ""))).toString()).commit();
														post_data.addChildEventListener(_post_data_child_listener);
													}
													else {
														if (String.valueOf((long)(bedroom_data)).equals("1")) {
															data.edit().putString("bedroom1", _childValue.get("bedroom".concat(data.getString("1", ""))).toString()).commit();
															data.edit().putString("bedtype1", _childValue.get("bedtype".concat(data.getString("1", ""))).toString()).commit();
															data.edit().putString("floor1", _childValue.get("floor".concat(data.getString("1", ""))).toString()).commit();
														}
													}
												}
											}
										}
									}
								}
							}
						}
						recyclerview2.setAdapter(new Recyclerview2Adapter(bedroom_listmap));
					}
					else {
						
					}
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
		post_data.addChildEventListener(_post_data_child_listener);
		
		_post_data_rate_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("getPost"))) {
					if (_childValue.get("type of dormitory").toString().equals("Female Dormitory") || (_childValue.get("type of dormitory").toString().equals("Male Dormitory") || _childValue.get("type of dormitory").toString().equals("Gender-neutral Dormitory"))) {
						if (String.valueOf((long)(girls_rate_total)).equals("3")) {
							girls_rate_total--;
							data.edit().putString(" data rates bedroom3", _childValue.get("rates bedroom3").toString()).commit();
							data.edit().putString("data rates bed3", _childValue.get("rates bed3").toString()).commit();
							data.edit().putString("data rates floor3", _childValue.get("rates floor3").toString()).commit();
							data.edit().putString("data rates monthly price3", _childValue.get("rates monthly price3").toString()).commit();
							data.edit().putString("data rates status3", _childValue.get("rates status3").toString()).commit();
							post_data_rate.addChildEventListener(_post_data_rate_child_listener);
						}
						else {
							if (String.valueOf((long)(girls_rate_total)).equals("2")) {
								girls_rate_total--;
								data.edit().putString(" data rates bedroom2", _childValue.get("rates bedroom2").toString()).commit();
								data.edit().putString("data rates bed2", _childValue.get("rates bed2").toString()).commit();
								data.edit().putString("data rates floor2", _childValue.get("rates floor2").toString()).commit();
								data.edit().putString("data rates monthly price2", _childValue.get("rates monthly price2").toString()).commit();
								data.edit().putString("data rates status2", _childValue.get("rates status2").toString()).commit();
								post_data_rate.addChildEventListener(_post_data_rate_child_listener);
							}
							else {
								if (String.valueOf((long)(girls_rate_total)).equals("1")) {
									data.edit().putString(" data rates bedroom1", _childValue.get("rates bedroom1").toString()).commit();
									data.edit().putString("data rates bed1", _childValue.get("rates bed1").toString()).commit();
									data.edit().putString("data rates floor1", _childValue.get("rates floor1").toString()).commit();
									data.edit().putString("data rates monthly price1", _childValue.get("rates monthly price1").toString()).commit();
									data.edit().putString("data rates status1", _childValue.get("rates status1").toString()).commit();
								}
								else {
									
								}
							}
						}
						recyclerview3.setAdapter(new Recyclerview3Adapter(rates_listmap));
					}
					else {
						
					}
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
		post_data_rate.addChildEventListener(_post_data_rate_child_listener);
		
		_post_data_rate_boy_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("getPost"))) {
					if (_childValue.get("type of dormitory").toString().equals("Co-ed Dormitory")) {
						if (String.valueOf((long)(girls_rate_total)).equals("3")) {
							girls_rate_total--;
							data.edit().putString(" data rates bedroom3", _childValue.get("rates bedroom3").toString()).commit();
							data.edit().putString("data rates bed3", _childValue.get("rates bed3").toString()).commit();
							data.edit().putString("data rates floor3", _childValue.get("rates floor3").toString()).commit();
							data.edit().putString("data rates monthly price3", _childValue.get("rates monthly price3").toString()).commit();
							data.edit().putString("data rates status3", _childValue.get("rates status3").toString()).commit();
							post_data_rate.addChildEventListener(_post_data_rate_child_listener);
						}
						else {
							if (String.valueOf((long)(girls_rate_total)).equals("2")) {
								girls_rate_total--;
								data.edit().putString(" data rates bedroom2", _childValue.get("rates bedroom2").toString()).commit();
								data.edit().putString("data rates bed2", _childValue.get("rates bed2").toString()).commit();
								data.edit().putString("data rates floor2", _childValue.get("rates floor2").toString()).commit();
								data.edit().putString("data rates monthly price2", _childValue.get("rates monthly price2").toString()).commit();
								data.edit().putString("data rates status2", _childValue.get("rates status2").toString()).commit();
								post_data_rate.addChildEventListener(_post_data_rate_child_listener);
							}
							else {
								if (String.valueOf((long)(girls_rate_total)).equals("1")) {
									data.edit().putString(" data rates bedroom1", _childValue.get("rates bedroom1").toString()).commit();
									data.edit().putString("data rates bed1", _childValue.get("rates bed1").toString()).commit();
									data.edit().putString("data rates floor1", _childValue.get("rates floor1").toString()).commit();
									data.edit().putString("data rates monthly price1", _childValue.get("rates monthly price1").toString()).commit();
									data.edit().putString("data rates status1", _childValue.get("rates status1").toString()).commit();
								}
								else {
									
								}
							}
						}
						recyclerview3.setAdapter(new Recyclerview3Adapter(rates_listmap));
						if (String.valueOf((long)(boys_rate_total)).equals("3")) {
							boys_rate_total--;
							data.edit().putString(" boys data rates bedroom3", _childValue.get("boys rates bedroom3").toString()).commit();
							data.edit().putString("boys data rates bed3", _childValue.get("boys rates bed3").toString()).commit();
							data.edit().putString("boys data rates floor3", _childValue.get("boys rates floor3").toString()).commit();
							data.edit().putString("boys data rates monthly price3", _childValue.get("boys rates monthly price3").toString()).commit();
							data.edit().putString("boys data rates status3", _childValue.get("boys rates status3").toString()).commit();
							post_data_rate_boy.addChildEventListener(_post_data_rate_boy_child_listener);
						}
						else {
							if (String.valueOf((long)(boys_rate_total)).equals("2")) {
								boys_rate_total--;
								data.edit().putString(" boys data rates bedroom2", _childValue.get("boys rates bedroom2").toString()).commit();
								data.edit().putString("boys data rates bed2", _childValue.get("boys rates bed2").toString()).commit();
								data.edit().putString("boys data rates floor2", _childValue.get("boys rates floor2").toString()).commit();
								data.edit().putString("boys data rates monthly price2", _childValue.get("boys rates monthly price2").toString()).commit();
								data.edit().putString("boys data rates status2", _childValue.get("boys rates status2").toString()).commit();
								post_data_rate_boy.addChildEventListener(_post_data_rate_boy_child_listener);
							}
							else {
								if (String.valueOf((long)(boys_rate_total)).equals("1")) {
									data.edit().putString(" boys data rates bedroom1", _childValue.get("boys rates bedroom1").toString()).commit();
									data.edit().putString("boys data rates bed1", _childValue.get("boys rates bed1").toString()).commit();
									data.edit().putString("boys data rates floor1", _childValue.get("boys rates floor1").toString()).commit();
									data.edit().putString("boys data rates monthly price1", _childValue.get("boys rates monthly price1").toString()).commit();
									data.edit().putString("boys data rates status1", _childValue.get("boys rates status1").toString()).commit();
								}
								else {
									
								}
							}
						}
						recyclerview4.setAdapter(new Recyclerview4Adapter(boys_bedroom_listmap));
						bedroom_girls.setText(_childValue.get("girls bedroom").toString());
						girls_bedtype.setText(_childValue.get("girls bedtype").toString());
						girls_floor.setText(_childValue.get("girls floor").toString());
						if (String.valueOf((long)(girlsBedCount)).equals("3")) {
							girlsBedCount--;
							data.edit().putString(" girls bedroom num3", _childValue.get("girls bedroom3").toString()).commit();
							data.edit().putString("girls bedtype num3", _childValue.get("girls bedtype3").toString()).commit();
							data.edit().putString("girls floor num3", _childValue.get("girls floor3").toString()).commit();
							post_data_rate_boy.addChildEventListener(_post_data_rate_boy_child_listener);
						}
						else {
							if (String.valueOf((long)(girlsBedCount)).equals("2")) {
								girlsBedCount--;
								data.edit().putString(" girls bedroom num2", _childValue.get("girls bedroom2").toString()).commit();
								data.edit().putString("girls bedtype num2", _childValue.get("girls bedtype2").toString()).commit();
								data.edit().putString("girls floor num2", _childValue.get("girls floor2").toString()).commit();
								post_data_rate_boy.addChildEventListener(_post_data_rate_boy_child_listener);
							}
							else {
								if (String.valueOf((long)(girlsBedCount)).equals("1")) {
									data.edit().putString(" girls bedroom num1", _childValue.get("girls bedroom1").toString()).commit();
									data.edit().putString("girls bedtype num1", _childValue.get("girls bedtype1").toString()).commit();
									data.edit().putString("girls floor num1", _childValue.get("girls floor1").toString()).commit();
								}
								else {
									
								}
							}
						}
						coed_girls_recycler.setAdapter(new Coed_girls_recyclerAdapter(girls_listmap));
						boys_bedroom.setText(_childValue.get("boys bedroom").toString());
						boys_bedtype.setText(_childValue.get("boys bedtype").toString());
						boys_floor.setText(_childValue.get("boys floor").toString());
						if (String.valueOf((long)(boysBedCount)).equals("3")) {
							boysBedCount--;
							data.edit().putString(" boys bedroom num3", _childValue.get("boys bedroom3").toString()).commit();
							data.edit().putString("boys bedtype num3", _childValue.get("boys bedtype3").toString()).commit();
							data.edit().putString("boys floor num3", _childValue.get("boys floor3").toString()).commit();
							post_data_rate_boy.addChildEventListener(_post_data_rate_boy_child_listener);
						}
						else {
							if (String.valueOf((long)(girlsBedCount)).equals("2")) {
								boysBedCount--;
								data.edit().putString("boys bedroom num2", _childValue.get("boys bedroom2").toString()).commit();
								data.edit().putString("boys bedtype num2", _childValue.get("boys bedtype2").toString()).commit();
								data.edit().putString("boys floor num2", _childValue.get("boys floor2").toString()).commit();
								post_data_rate_boy.addChildEventListener(_post_data_rate_boy_child_listener);
							}
							else {
								if (String.valueOf((long)(boysBedCount)).equals("1")) {
									data.edit().putString("boys bedroom num1", _childValue.get("boys bedroom1").toString()).commit();
									data.edit().putString("boys bedtype num1", _childValue.get("boys bedtype1").toString()).commit();
									data.edit().putString("boys floor num1", _childValue.get("boys floor1").toString()).commit();
								}
								else {
									
								}
							}
						}
						coed_boys_recycler.setAdapter(new Coed_boys_recyclerAdapter(boys_listmap));
					}
					else {
						
					}
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
		post_data_rate_boy.addChildEventListener(_post_data_rate_boy_child_listener);
		
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
		_ui();
		remove_bed2.setVisibility(View.GONE);
		add_bedroom.setVisibility(View.GONE);
		girls_add_bedroom.setVisibility(View.GONE);
		boys_add_bedroom.setVisibility(View.GONE);
		add_bedroom.setVisibility(View.GONE);
		added_layout.setVisibility(View.GONE);
		add_beds.setVisibility(View.GONE);
		boys_add_beds.setVisibility(View.GONE);
		recyclerview2.setLayoutManager(new LinearLayoutManager(this));
		post.removeEventListener(_post_child_listener);
		post_data.removeEventListener(_post_data_child_listener);
		post_data_rate.removeEventListener(_post_data_rate_child_listener);
		post_data_rate_boy.removeEventListener(_post_data_rate_boy_child_listener);
		if (getIntent().getStringExtra("edit").equals("")) {
			edit = getIntent().getStringExtra("edit");
			textview26.setText("Add Dormitory");
			add_save_layout.setVisibility(View.VISIBLE);
			remove_bed2.setVisibility(View.VISIBLE);
			girls_add_bedroom.setVisibility(View.VISIBLE);
			boys_add_bedroom.setVisibility(View.VISIBLE);
			add_beds.setVisibility(View.VISIBLE);
			boys_add_beds.setVisibility(View.VISIBLE);
		}
		else {
			if (getIntent().getStringExtra("edit").equals("true")) {
				post.addChildEventListener(_post_child_listener);
				edit = getIntent().getStringExtra("edit");
				textview26.setText("Save Dormitory");
				add_save_layout.setVisibility(View.VISIBLE);
				remove_bed2.setVisibility(View.VISIBLE);
				girls_add_bedroom.setVisibility(View.VISIBLE);
				boys_add_bedroom.setVisibility(View.VISIBLE);
				add_bedroom.setVisibility(View.VISIBLE);
				add_beds.setVisibility(View.VISIBLE);
				boys_add_beds.setVisibility(View.VISIBLE);
			}
			else {
				if (getIntent().getStringExtra("edit").equals("false")) {
					_view_data();
					post.addChildEventListener(_post_child_listener);
					edit = getIntent().getStringExtra("edit");
					str = "post/".concat(getIntent().getStringExtra("getPost").concat("/reviews"));
					reviews = _firebase.getReference(str);
					reviews.addChildEventListener(_reviews_child_listener);
				}
			}
		}
		total.addChildEventListener(_total_child_listener);
		recyclerview1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		coed_girls_recycler.setLayoutManager(new LinearLayoutManager(this));
		coed_boys_recycler.setLayoutManager(new LinearLayoutManager(this));
		recyclerview3.setLayoutManager(new LinearLayoutManager(this));
		recyclerview4.setLayoutManager(new LinearLayoutManager(this));
		getPost = getpost.push().getKey();
		photoPath = "/storage/emulated/0/Download/";
		girlsRemove = 0;
		boysRemove = 0;
		rev = 0;
		amountAdvance = 0;
		amountDeposit = 0;
		bedroomNum = 0;
		boysBedroomNum = 0;
		girlsNum = 0;
		boysNum = 0;
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_PHOTO1:
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
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), photoPath.concat("photo1"), 480);
				img1 = photoPath.concat("photo1");
				insert_photo1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img1, 1024, 1024));
				edit = "";
			}
			else {
				
			}
			break;
			
			case REQ_CD_PHOTO2:
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
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), photoPath.concat("photo2"), 480);
				img2 = photoPath.concat("photo2");
				insert_photo2.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img2, 1024, 1024));
				edit = "";
			}
			else {
				
			}
			break;
			
			case REQ_CD_PHOTO3:
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
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), photoPath.concat("photo3"), 480);
				img3 = photoPath.concat("photo3");
				insert_photo3.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img3, 1024, 1024));
				edit = "";
			}
			else {
				
			}
			break;
			
			case REQ_CD_PHOTO4:
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
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), photoPath.concat("photo4"), 480);
				img4 = photoPath.concat("photo4");
				insert_photo4.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img4, 1024, 1024));
				edit = "";
			}
			else {
				
			}
			break;
			
			case REQ_CD_PHOTO5:
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
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), photoPath.concat("photo5"), 480);
				img5 = photoPath.concat("photo5");
				insert_photo5.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img5, 1024, 1024));
				edit = "";
			}
			else {
				
			}
			break;
			
			case REQ_CD_PHOTO6:
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
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), photoPath.concat("photo6"), 480);
				img6 = photoPath.concat("photo6");
				insert_photo6.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img6, 1024, 1024));
				edit = "";
			}
			else {
				
			}
			break;
			
			case REQ_CD_PHOTO7:
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
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), photoPath.concat("photo7"), 480);
				img7 = photoPath.concat("photo7");
				insert_photo7.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img7, 1024, 1024));
				edit = "";
			}
			else {
				
			}
			break;
			
			case REQ_CD_PHOTO8:
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
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), photoPath.concat("photo8"), 480);
				img8 = photoPath.concat("photo8");
				insert_photo8.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img8, 1024, 1024));
				edit = "";
			}
			else {
				
			}
			break;
			
			case REQ_CD_PHOTO9:
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
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), photoPath.concat("photo9"), 480);
				img9 = photoPath.concat("photo9");
				insert_photo9.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img9, 1024, 1024));
				edit = "";
			}
			else {
				
			}
			break;
			
			case REQ_CD_PHOTO10:
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
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), photoPath.concat("photo10"), 480);
				img10 = photoPath.concat("photo10");
				insert_photo10.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img10, 1024, 1024));
				edit = "";
			}
			else {
				
			}
			break;
			
			case REQ_CD_PHOTO11:
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
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), photoPath.concat("photo11"), 480);
				img11 = photoPath.concat("photo11");
				insert_photo11.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img11, 1024, 1024));
				edit = "";
			}
			else {
				
			}
			break;
			
			case REQ_CD_PHOTO12:
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
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), photoPath.concat("photo12"), 480);
				img12 = photoPath.concat("photo12");
				insert_photo12.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img12, 1024, 1024));
				edit = "";
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (ContextCompat.checkSelfPermission(AdminHomepageActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			loc.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1, _loc_location_listener);
		}
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mapview1.onDestroy();
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
	
	
	public void _ui() {
		_advance(linear1);
		_ImageColor(back, "#176b87");
		_ImageColor(location_icon, "#176b87");
		_simpleRiffle(insert_photo1);
		_simpleRiffle(insert_photo2);
		_simpleRiffle(insert_photo3);
		_simpleRiffle(insert_photo4);
		_simpleRiffle2(select_reviews_ratings);
		_simpleRiffle2(select_add_dormitory);
		_Validate_keyboards();
		owners_firstname.setSingleLine(true);
		owners_middle_initial.setSingleLine(true);
		owners_lastname.setSingleLine(true);
		street.setSingleLine(true);
		city.setSingleLine(true);
		barangay.setSingleLine(true);
		province.setSingleLine(true);
		bed_type2.setSingleLine(true);
		bed_type2.setEnabled(false);
		_setSingleLine(girls_bedtype, true);
		_setSingleLine(boys_bedtype, true);
		add_bedroom.setVisibility(View.GONE);
		textview57.setVisibility(View.GONE);
		added_layout.setVisibility(View.GONE);
		coed_layout.setVisibility(View.GONE);
		rates_amount_layout.setVisibility(View.GONE);
		coed_layout1.setVisibility(View.GONE);
		girls_text.setVisibility(View.GONE);
		coed_layout2.setVisibility(View.GONE);
		boys_text.setVisibility(View.GONE);
		reviews_layout.setVisibility(View.GONE);
		add_save_layout.setVisibility(View.GONE);
		_removeScollBar(vscroll1);
		insert_photo1.setImageResource(R.drawable.insert_image);
		insert_photo2.setImageResource(R.drawable.insert_image);
		insert_photo3.setImageResource(R.drawable.insert_image);
		insert_photo4.setImageResource(R.drawable.insert_image);
		insert_photo5.setImageResource(R.drawable.insert_image);
		insert_photo6.setImageResource(R.drawable.insert_image);
		insert_photo7.setImageResource(R.drawable.insert_image);
		insert_photo8.setImageResource(R.drawable.insert_image);
		insert_photo9.setImageResource(R.drawable.insert_image);
		insert_photo10.setImageResource(R.drawable.insert_image);
		insert_photo11.setImageResource(R.drawable.insert_image);
		insert_photo12.setImageResource(R.drawable.insert_image);
		price_bedroom1.setEnabled(false);
		price_floor.setEnabled(false);
		amount_advance.setEnabled(false);
		amount_deposit.setEnabled(false);
		lat = 0;
		lng = 0;
		users.addChildEventListener(_users_child_listener);
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
	
	
	public void _simpleRiffle2(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#f5f5f5")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#176b87")), null);
		
		_view.setBackground(GA8PO9);
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
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _booking_count() {
		map = new HashMap<>();
		map.put("count", String.valueOf((long)(totalAvailable + Double.parseDouble(room_available.getText().toString()))));
		total.child("rooms available").updateChildren(map);
	}
	
	
	public void _bedRoomType() {
		map.put("total bed rooms", total_bedrooms.getText().toString());
		map.put("bedroom".concat(String.valueOf((long)(Double.parseDouble(data.getString("bedroom count", "")) + 1))), number_bed2.getText().toString());
		map.put("bedtype".concat(String.valueOf((long)(Double.parseDouble(data.getString("bedtype count", "")) + 1))), bed_type2.getText().toString());
		map.put("floor".concat(String.valueOf((long)(Double.parseDouble(data.getString("floor count", "")) + 1))), number_floor2.getText().toString());
		if (data.getString("1", "").equals("1")) {
			map.put("bedroom1", data.getString("bedroom num1", ""));
			map.put("bedtype1", data.getString("bedtype num1", ""));
			map.put("floor1", data.getString("floor num1", ""));
		}
		else {
			
		}
		if (data.getString("2", "").equals("2")) {
			map.put("bedroom2", data.getString("bedroom num2", ""));
			map.put("bedtype2", data.getString("bedtype num2", ""));
			map.put("floor2", data.getString("floor num2", ""));
		}
		else {
			
		}
		if (data.getString("3", "").equals("3")) {
			map.put("bedroom3", data.getString("bedroom num3", ""));
			map.put("bedtype3", data.getString("bedtype num3", ""));
			map.put("floor3", data.getString("floor num3", ""));
		}
		else {
			
		}
		if (data.getString("4", "").equals("4")) {
			map.put("bedroom4", data.getString("bedroom num4", ""));
			map.put("bedtype4", data.getString("bedtype num4", ""));
			map.put("floor4", data.getString("floor num4", ""));
		}
		else {
			
		}
		if (data.getString("5", "").equals("5")) {
			map.put("bedroom5", data.getString("bedroom num5", ""));
			map.put("bedtype5", data.getString("bedtype num5", ""));
			map.put("floor5", data.getString("floor num5", ""));
		}
		else {
			
		}
		if (data.getString("6", "").equals("6")) {
			map.put("bedroom6", data.getString("bedroom num6", ""));
			map.put("bedtype6", data.getString("bedtype num6", ""));
			map.put("floor6", data.getString("floor num6", ""));
		}
		else {
			
		}
		if (data.getString("7", "").equals("7")) {
			map.put("bedroom7", data.getString("bedroom num7", ""));
			map.put("bedtype7", data.getString("bedtype num7", ""));
			map.put("floor7", data.getString("floor num7", ""));
		}
		else {
			
		}
		if (data.getString("8", "").equals("8")) {
			map.put("bedroom8", data.getString("bedroom num8", ""));
			map.put("bedtype8", data.getString("bedtype num8", ""));
			map.put("floor8", data.getString("floor num8", ""));
		}
		else {
			
		}
		if (data.getString("9", "").equals("9")) {
			map.put("bedroom9", data.getString("bedroom num9", ""));
			map.put("bedtype9", data.getString("bedtype num9", ""));
			map.put("floor9", data.getString("floor num9", ""));
		}
		else {
			
		}
	}
	
	
	public void _rates() {
		map.put("rates bedroom", price_bedroom1.getText().toString());
		map.put("rates bed", price_bedtype.getText().toString());
		map.put("rates floor", price_floor.getText().toString());
		map.put("rates monthly price", room_rent.getText().toString());
		map.put("rates status", rates_status.getText().toString());
		if (data.getString("rate1", "").equals("1")) {
			map.put("rates bedroom1", data.getString("rates bedroom1", ""));
			map.put("rates bed1", data.getString("rates bed1", ""));
			map.put("rates floor1", data.getString("rates floor1", ""));
			map.put("rates monthly price1", data.getString("rates monthly price1", ""));
			map.put("rates status1", data.getString("rates status1", ""));
		}
		else {
			
		}
		if (data.getString("rate2", "").equals("2")) {
			map.put("rates bedroom2", data.getString("rates bedroom2", ""));
			map.put("rates bed2", data.getString("rates bed2", ""));
			map.put("rates floor2", data.getString("rates floor2", ""));
			map.put("rates monthly price2", data.getString("rates monthly price2", ""));
			map.put("rates status2", data.getString("rates status2", ""));
		}
		else {
			
		}
		if (data.getString("rate3", "").equals("3")) {
			map.put("rates bedroom3", data.getString("rates bedroom3", ""));
			map.put("rates bed3", data.getString("rates bed3", ""));
			map.put("rates floor3", data.getString("rates floor3", ""));
			map.put("rates monthly price3", data.getString("rates monthly price3", ""));
			map.put("rates status3", data.getString("rates status3", ""));
		}
		else {
			
		}
	}
	
	
	public void _girls_coed() {
		map.put("girls bedroom", bedroom_girls.getText().toString());
		map.put("girls bedtype", girls_bedtype.getText().toString());
		map.put("girls floor", girls_floor.getText().toString());
		if (data.getString("girls1", "").equals("1")) {
			map.put("girls bedroom1", data.getString("girls bedroom num1", ""));
			map.put("girls bedtype1", data.getString("girls bedtype num1", ""));
			map.put("girls floor1", data.getString("girls floor num1", ""));
		}
		else {
			
		}
		if (data.getString("girls2", "").equals("2")) {
			map.put("girls bedroom2", data.getString("girls bedroom num2", ""));
			map.put("girls bedtype2", data.getString("girls bedtype num2", ""));
			map.put("girls floor2", data.getString("girls floor num2", ""));
		}
		else {
			
		}
		if (data.getString("girls3", "").equals("3")) {
			map.put("girls bedroom3", data.getString("girls bedroom num3", ""));
			map.put("girls bedtype3", data.getString("girls bedtype num3", ""));
			map.put("girls floor3", data.getString("girls floor num3", ""));
		}
		else {
			
		}
	}
	
	
	public void _setSingleLine(final TextView _view, final boolean _bool) {
		_view.setSingleLine(_bool);
	}
	
	
	public void _boys_coed() {
		map.put("boys bedroom", boys_bedroom.getText().toString());
		map.put("boys bedtype", boys_bedtype.getText().toString());
		map.put("boys floor", boys_floor.getText().toString());
		if (data.getString("boys1", "").equals("1")) {
			map.put("boys bedroom1", data.getString("boys bedroom num1", ""));
			map.put("boys bedtype1", data.getString("boys bedtype num1", ""));
			map.put("boys floor1", data.getString("boys floor num1", ""));
		}
		else {
			
		}
		if (data.getString("boys2", "").equals("2")) {
			map.put("boys bedroom2", data.getString("boys bedroom num2", ""));
			map.put("boys bedtype2", data.getString("boys bedtype num2", ""));
			map.put("boys floor2", data.getString("boys floor num2", ""));
		}
		else {
			
		}
		if (data.getString("boys3", "").equals("3")) {
			map.put("boys bedroom3", data.getString("boys bedroom num3", ""));
			map.put("boys bedtype3", data.getString("boys bedtype num3", ""));
			map.put("boys floor3", data.getString("boys floor num3", ""));
		}
		else {
			
		}
	}
	
	
	public void _transcient() {
		if (transient_.isChecked()) {
			map.put("rates per night", rates_per_night.getText().toString());
			map.put("minimum stay", minimum_stay.getText().toString());
		}
		else {
			
		}
	}
	
	
	public void _boys_rates() {
		map.put("boys rates bedroom", price_boys_bedroom.getText().toString());
		map.put("boys rates bed", price_boys_bed.getText().toString());
		map.put("boys rates floor", price_boys_floor.getText().toString());
		map.put("boys rates monthly price", price_boys_monthly.getText().toString());
		map.put("boys rates status", price_boys_status.getText().toString());
		if (data.getString("boy rate1", "").equals("1")) {
			map.put("boys rates bedroom1", data.getString("boys rates bedroom1", ""));
			map.put("boys rates bed1", data.getString("boys rates bed1", ""));
			map.put("boys rates floor1", data.getString("boys rates floor1", ""));
			map.put("boys rates monthly price1", data.getString("boys rates monthly price1", ""));
			map.put("boys rates status1", data.getString("boys rates status1", ""));
		}
		else {
			
		}
		if (data.getString("boy rate2", "").equals("2")) {
			map.put("boys rates bedroom2", data.getString("boys rates bedroom2", ""));
			map.put("boys rates bed2", data.getString("boys rates bed2", ""));
			map.put("boys rates floor2", data.getString("boys rates floor2", ""));
			map.put("boys rates monthly price2", data.getString("boys rates monthly price2", ""));
			map.put("boys rates status2", data.getString("boys rates status2", ""));
		}
		else {
			
		}
		if (data.getString("boy rate3", "").equals("3")) {
			map.put("boys rates bedroom3", data.getString("boys rates bedroom3", ""));
			map.put("boys rates bed3", data.getString("boys rates bed3", ""));
			map.put("boys rates floor3", data.getString("boys rates floor3", ""));
			map.put("boys rates monthly price3", data.getString("boys rates monthly price3", ""));
			map.put("boys rates status3", data.getString("boys rates status3", ""));
		}
		else {
			
		}
	}
	
	
	public void _riffleEffect(final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)}); android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null); _view.setBackground(ripdr);
	}
	
	
	public void _view_data() {
		owners_firstname.setEnabled(false);
		owners_middle_initial.setEnabled(false);
		owners_lastname.setEnabled(false);
		dormitory_name.setEnabled(false);
		description.setEnabled(false);
		street.setEnabled(false);
		city.setEnabled(false);
		barangay.setEnabled(false);
		province.setEnabled(false);
		latitude.setEnabled(false);
		longitude.setEnabled(false);
		add_bedroom.setEnabled(false);
		female_dormitory.setEnabled(false);
		gender_neutral_dormitory.setEnabled(false);
		transient_.setEnabled(false);
		male_dormitory.setEnabled(false);
		co_ed_dormitory.setEnabled(false);
		total_bedrooms.setEnabled(false);
		remove_bed2.setEnabled(false);
		number_bed2.setEnabled(false);
		bedtype2_option.setEnabled(false);
		number_floor2.setEnabled(false);
		room_available.setEnabled(false);
		room_occupied.setEnabled(false);
		girls_add_bedroom.setEnabled(false);
		bedroom_girls.setEnabled(false);
		girls_bedtype_option.setEnabled(false);
		girls_floor.setEnabled(false);
		boys_add_bedroom.setEnabled(false);
		boys_bedroom.setEnabled(false);
		boys_bedtype_option.setEnabled(false);
		boys_floor.setEnabled(false);
		insert_photo1.setEnabled(false);
		insert_photo2.setEnabled(false);
		insert_photo3.setEnabled(false);
		insert_photo4.setEnabled(false);
		insert_photo5.setEnabled(false);
		insert_photo6.setEnabled(false);
		insert_photo7.setEnabled(false);
		insert_photo8.setEnabled(false);
		insert_photo9.setEnabled(false);
		insert_photo10.setEnabled(false);
		insert_photo11.setEnabled(false);
		insert_photo12.setEnabled(false);
		canteen.setEnabled(false);
		visiting_area.setEnabled(false);
		parking_area.setEnabled(false);
		common_bathroom.setEnabled(false);
		laundry.setEnabled(false);
		others_amenities.setEnabled(false);
		included_internet.setEnabled(false);
		included_cabinet.setEnabled(false);
		included_electric_fan.setEnabled(false);
		included_rice_cooker.setEnabled(false);
		included_parking_area.setEnabled(false);
		included_charging_port.setEnabled(false);
		included_common_bathroom.setEnabled(false);
		included_water.setEnabled(false);
		included_electricity.setEnabled(false);
		others_inclusion.setEnabled(false);
		policy_pets_allowed.setEnabled(false);
		policy_pets_not_allowed.setEnabled(false);
		policy_smoking_allowed.setEnabled(false);
		policy_not_smoking_allowed.setEnabled(false);
		others_policy.setEnabled(false);
		add_beds.setEnabled(false);
		room_available_boys.setEnabled(false);
		room_available_girls.setEnabled(false);
		rates_bedroom_option.setEnabled(false);
		price_bedtype.setEnabled(false);
		rates_floor_option.setEnabled(false);
		room_rent.setEnabled(false);
		rates_status_option.setEnabled(false);
		boys_add_beds.setEnabled(false);
		boys_bedroom_option.setEnabled(false);
		price_boys_bed.setEnabled(false);
		boys_floor_option.setEnabled(false);
		price_boys_monthly.setEnabled(false);
		boys_status_option.setEnabled(false);
		switch1.setEnabled(false);
		switch2.setEnabled(false);
		rates_per_night.setEnabled(false);
		minimum_stay.setEnabled(false);
	}
	
	
	public void _Restrict_Input(final TextView _koshurboiitxt) {
		_koshurboiitxt.setInputType(InputType.TYPE_CLASS_NUMBER); 
	}
	
	
	public void _Validate_keyboards() {
		_Restrict_Input(total_bedrooms);
		_Restrict_Input(number_bed2);
		_Restrict_Input(number_floor2);
		_Restrict_Input(room_available);
		_Restrict_Input(room_occupied);
		_Restrict_Input(bedroom_girls);
		_Restrict_Input(girls_floor);
		_Restrict_Input(boys_bedroom);
		_Restrict_Input(boys_floor);
		_Restrict_Input(room_available_boys);
		_Restrict_Input(room_available_girls);
		_Restrict_Input(price_bedtype);
		_Restrict_Input(room_rent);
		_Restrict_Input(price_boys_bed);
		_Restrict_Input(price_boys_monthly);
		_Restrict_Input(amount_advance);
		_Restrict_Input(amount_deposit);
		_Restrict_Input(rates_per_night);
		_Restrict_Input(minimum_stay);
	}
	
	public class Recyclerview2Adapter extends RecyclerView.Adapter<Recyclerview2Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.bedroom_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final ImageView remove_btn = _view.findViewById(R.id.remove_btn);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final EditText edittext1 = _view.findViewById(R.id.edittext1);
			final ImageView bedroom_option = _view.findViewById(R.id.bedroom_option);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final EditText edittext2 = _view.findViewById(R.id.edittext2);
			final ImageView bedtype_option = _view.findViewById(R.id.bedtype_option);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final androidx.cardview.widget.CardView cardview3 = _view.findViewById(R.id.cardview3);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final EditText edittext3 = _view.findViewById(R.id.edittext3);
			final ImageView floor_option = _view.findViewById(R.id.floor_option);
			
			edittext1.setEnabled(false);
			edittext2.setEnabled(false);
			edittext3.setEnabled(false);
			edittext2.setSingleLine(true);
			remove_btn.setVisibility(View.GONE);
			textview1.setText("Bedroom ".concat(_data.get((int)_position).get("bedroom").toString()));
			data.edit().putString(_data.get((int)_position).get("bedroom").toString(), _data.get((int)_position).get("bedroom").toString()).commit();
			data.edit().putString("bedroom count", _data.get((int)_position).get("bedroom").toString()).commit();
			data.edit().putString("bedtype count", _data.get((int)_position).get("bedtype").toString()).commit();
			data.edit().putString("floor count", _data.get((int)_position).get("floor").toString()).commit();
			num = Double.parseDouble(_data.get((int)_position).get("bedroom").toString());
			bedroom_option.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedroom_option);
					
					Menu menu = popup.getMenu();
					menu.add("1");
					menu.add("2");
					menu.add("3");
					menu.add("4");
					menu.add("5");
					menu.add("6");
					menu.add("7");
					menu.add("8");
					menu.add("9");
					 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
								edittext1.setText("1");
								data.edit().putString("bedroom num".concat(_data.get((int)_position).get("bedroom").toString()), edittext1.getText().toString()).commit();
								return true; case "2":
								edittext1.setText("2");
								data.edit().putString("bedroom num".concat(_data.get((int)_position).get("bedroom").toString()), edittext1.getText().toString()).commit();
								return true; case "3":
								edittext1.setText("3");
								data.edit().putString("bedroom num".concat(_data.get((int)_position).get("bedroom").toString()), edittext1.getText().toString()).commit();
								return true; case "4":
								edittext1.setText("4");
								data.edit().putString("bedroom num".concat(_data.get((int)_position).get("bedroom").toString()), edittext1.getText().toString()).commit();
								return true; case "5":
								edittext1.setText("5");
								data.edit().putString("bedroom num".concat(_data.get((int)_position).get("bedroom").toString()), edittext1.getText().toString()).commit();
								return true; case "6":
								edittext1.setText("6");
								data.edit().putString("bedroom num".concat(_data.get((int)_position).get("bedroom").toString()), edittext1.getText().toString()).commit();
								return true; case "7":
								edittext1.setText("7");
								data.edit().putString("bedroom num".concat(_data.get((int)_position).get("bedroom").toString()), edittext1.getText().toString()).commit();
								return true; case "8":
								edittext1.setText("8");
								data.edit().putString("bedroom num".concat(_data.get((int)_position).get("bedroom").toString()), edittext1.getText().toString()).commit();
								return true; case "9":
								edittext1.setText("9");
								data.edit().putString("bedroom num".concat(_data.get((int)_position).get("bedroom").toString()), edittext1.getText().toString()).commit();
								return true; default: return false; } } }); popup.show();
				}
			});
			bedtype_option.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedtype_option);
					
					Menu menu = popup.getMenu();
					menu.add("Single Bed");
					menu.add("Double Bed");
					menu.add("Double Deck");
					 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "Single Bed":
								edittext2.setText("Single Bed");
								data.edit().putString("bedtype num".concat(_data.get((int)_position).get("bedroom").toString()), edittext2.getText().toString()).commit();
								return true; case "Double Bed":
								edittext2.setText("Double Bed");
								data.edit().putString("bedtype num".concat(_data.get((int)_position).get("bedroom").toString()), edittext2.getText().toString()).commit();
								return true; case "Double Deck":
								edittext2.setText("Double Deck");
								data.edit().putString("bedtype num".concat(_data.get((int)_position).get("bedroom").toString()), edittext2.getText().toString()).commit();
								return true; default: return false; } } }); popup.show();
				}
			});
			floor_option.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, floor_option);
					
					Menu menu = popup.getMenu();
					menu.add("1");
					menu.add("2");
					menu.add("3");
					menu.add("4");
					menu.add("5");
					menu.add("6");
					menu.add("7");
					menu.add("8");
					menu.add("9");
					 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
								edittext3.setText("1");
								data.edit().putString("floor num".concat(_data.get((int)_position).get("bedroom").toString()), edittext3.getText().toString()).commit();
								return true; case "2":
								edittext3.setText("2");
								data.edit().putString("floor num".concat(_data.get((int)_position).get("bedroom").toString()), edittext3.getText().toString()).commit();
								return true; case "3":
								edittext3.setText("3");
								data.edit().putString("floor num".concat(_data.get((int)_position).get("bedroom").toString()), edittext3.getText().toString()).commit();
								return true; case "4":
								edittext3.setText("4");
								data.edit().putString("floor num".concat(_data.get((int)_position).get("bedroom").toString()), edittext3.getText().toString()).commit();
								return true; case "5":
								edittext3.setText("5");
								data.edit().putString("floor num".concat(_data.get((int)_position).get("bedroom").toString()), edittext3.getText().toString()).commit();
								return true; case "6":
								edittext3.setText("6");
								data.edit().putString("floor num".concat(_data.get((int)_position).get("bedroom").toString()), edittext3.getText().toString()).commit();
								return true; case "7":
								edittext3.setText("7");
								data.edit().putString("floor num".concat(_data.get((int)_position).get("bedroom").toString()), edittext3.getText().toString()).commit();
								return true; case "8":
								edittext3.setText("8");
								data.edit().putString("floor num".concat(_data.get((int)_position).get("bedroom").toString()), edittext3.getText().toString()).commit();
								return true; case "9":
								edittext3.setText("9");
								data.edit().putString("floor num".concat(_data.get((int)_position).get("bedroom").toString()), edittext3.getText().toString()).commit();
								return true; default: return false; } } }); popup.show();
				}
			});
			if (getIntent().getStringExtra("edit").equals("false")) {
				bedroom_option.setEnabled(false);
				bedtype_option.setEnabled(false);
				floor_option.setEnabled(false);
				remove_btn.setEnabled(false);
				if (type_of_dormitory.contains("Transcient") || (type_of_dormitory.contains("Female Dormitory") || (type_of_dormitory.contains("Male Dormitory") || type_of_dormitory.contains("Gender Neutral Dormitory")))) {
					if (_data.get((int)_position).get("bedroom").toString().equals("1")) {
						edittext1.setText(data.getString("bedroom1", ""));
						edittext2.setText(data.getString("bedtype1", ""));
						edittext3.setText(data.getString("floor1", ""));
					}
					if (_data.get((int)_position).get("bedroom").toString().equals("2")) {
						edittext1.setText(data.getString("bedroom2", ""));
						edittext2.setText(data.getString("bedtype2", ""));
						edittext3.setText(data.getString("floor2", ""));
					}
					if (_data.get((int)_position).get("bedroom").toString().equals("3")) {
						edittext1.setText(data.getString("bedroom3", ""));
						edittext2.setText(data.getString("bedtype3", ""));
						edittext3.setText(data.getString("floor3", ""));
					}
					if (_data.get((int)_position).get("bedroom").toString().equals("4")) {
						edittext1.setText(data.getString("bedroom4", ""));
						edittext2.setText(data.getString("bedtype4", ""));
						edittext3.setText(data.getString("floor4", ""));
					}
					if (_data.get((int)_position).get("bedroom").toString().equals("5")) {
						edittext1.setText(data.getString("bedroom5", ""));
						edittext2.setText(data.getString("bedtype5", ""));
						edittext3.setText(data.getString("floor5", ""));
					}
					if (_data.get((int)_position).get("bedroom").toString().equals("6")) {
						edittext1.setText(data.getString("bedroom6", ""));
						edittext2.setText(data.getString("bedtype6", ""));
						edittext3.setText(data.getString("floor6", ""));
					}
					if (_data.get((int)_position).get("bedroom").toString().equals("7")) {
						edittext1.setText(data.getString("bedroom7", ""));
						edittext2.setText(data.getString("bedtype7", ""));
						edittext3.setText(data.getString("floor7", ""));
					}
					if (_data.get((int)_position).get("bedroom").toString().equals("8")) {
						edittext1.setText(data.getString("bedroom8", ""));
						edittext2.setText(data.getString("bedtype8", ""));
						edittext3.setText(data.getString("floor8", ""));
					}
					if (_data.get((int)_position).get("bedroom").toString().equals("9")) {
						edittext1.setText(data.getString("bedroom9", ""));
						edittext2.setText(data.getString("bedtype9", ""));
						edittext3.setText(data.getString("floor9", ""));
					}
				}
				else {
					
				}
			}
			else {
				if (getIntent().getStringExtra("edit").equals("true")) {
					if (type_of_dormitory.contains("Transcient") || (type_of_dormitory.contains("Female Dormitory") || (type_of_dormitory.contains("Male Dormitory") || type_of_dormitory.contains("Gender Neutral Dormitory")))) {
						if (_data.get((int)_position).get("bedroom").toString().equals("1")) {
							edittext1.setText(data.getString("bedroom1", ""));
							edittext2.setText(data.getString("bedtype1", ""));
							edittext3.setText(data.getString("floor1", ""));
						}
						if (_data.get((int)_position).get("bedroom").toString().equals("2")) {
							edittext1.setText(data.getString("bedroom2", ""));
							edittext2.setText(data.getString("bedtype2", ""));
							edittext3.setText(data.getString("floor2", ""));
						}
						if (_data.get((int)_position).get("bedroom").toString().equals("3")) {
							edittext1.setText(data.getString("bedroom3", ""));
							edittext2.setText(data.getString("bedtype3", ""));
							edittext3.setText(data.getString("floor3", ""));
						}
						if (_data.get((int)_position).get("bedroom").toString().equals("4")) {
							edittext1.setText(data.getString("bedroom4", ""));
							edittext2.setText(data.getString("bedtype4", ""));
							edittext3.setText(data.getString("floor4", ""));
						}
						if (_data.get((int)_position).get("bedroom").toString().equals("5")) {
							edittext1.setText(data.getString("bedroom5", ""));
							edittext2.setText(data.getString("bedtype5", ""));
							edittext3.setText(data.getString("floor5", ""));
						}
						if (_data.get((int)_position).get("bedroom").toString().equals("6")) {
							edittext1.setText(data.getString("bedroom6", ""));
							edittext2.setText(data.getString("bedtype6", ""));
							edittext3.setText(data.getString("floor6", ""));
						}
						if (_data.get((int)_position).get("bedroom").toString().equals("7")) {
							edittext1.setText(data.getString("bedroom7", ""));
							edittext2.setText(data.getString("bedtype7", ""));
							edittext3.setText(data.getString("floor7", ""));
						}
						if (_data.get((int)_position).get("bedroom").toString().equals("8")) {
							edittext1.setText(data.getString("bedroom8", ""));
							edittext2.setText(data.getString("bedtype8", ""));
							edittext3.setText(data.getString("floor8", ""));
						}
						if (_data.get((int)_position).get("bedroom").toString().equals("9")) {
							edittext1.setText(data.getString("bedroom9", ""));
							edittext2.setText(data.getString("bedtype9", ""));
							edittext3.setText(data.getString("floor9", ""));
						}
						if (String.valueOf((long)(Double.parseDouble(_data.get((int)_position).get("bedroom").toString()) + 1)).equals("10")) {
							edittext1.setText(data.getString("bedroom10", ""));
							edittext2.setText(data.getString("bedtype10", ""));
							edittext3.setText(data.getString("floor10", ""));
						}
					}
					else {
						
					}
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
	
	public class Coed_girls_recyclerAdapter extends RecyclerView.Adapter<Coed_girls_recyclerAdapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Coed_girls_recyclerAdapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.bedroom_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final ImageView remove_btn = _view.findViewById(R.id.remove_btn);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final EditText edittext1 = _view.findViewById(R.id.edittext1);
			final ImageView bedroom_option = _view.findViewById(R.id.bedroom_option);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final EditText edittext2 = _view.findViewById(R.id.edittext2);
			final ImageView bedtype_option = _view.findViewById(R.id.bedtype_option);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final androidx.cardview.widget.CardView cardview3 = _view.findViewById(R.id.cardview3);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final EditText edittext3 = _view.findViewById(R.id.edittext3);
			final ImageView floor_option = _view.findViewById(R.id.floor_option);
			
			edittext2.setSingleLine(true);
			if (getIntent().getStringExtra("edit").equals("")) {
				
			}
			else {
				if (getIntent().getStringExtra("edit").equals("true")) {
					
				}
				else {
					if (getIntent().getStringExtra("edit").equals("false")) {
						remove_btn.setVisibility(View.GONE);
						bedroom_option.setEnabled(false);
						bedtype_option.setEnabled(false);
						floor_option.setEnabled(false);
					}
				}
			}
			textview1.setText("Bedroom ".concat(String.valueOf((long)(Double.parseDouble(_data.get((int)_position).get("girls bedroom num").toString()) + 1))));
			girlsRemove = Double.parseDouble(_data.get((int)_position).get("girls bedroom num").toString());
			data.edit().putString("girls".concat(_data.get((int)_position).get("girls bedroom num").toString()), _data.get((int)_position).get("girls bedroom num").toString()).commit();
			bedroom_option.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedroom_option);
					
					Menu menu = popup.getMenu();
					menu.add("1");
					menu.add("2");
					menu.add("3");
					menu.add("4");
					menu.add("5");
					menu.add("6");
					menu.add("7");
					menu.add("8");
					menu.add("9");
					 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
								edittext1.setText("1");
								data.edit().putString("girls bedroom num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "2":
								edittext1.setText("2");
								data.edit().putString("girls bedroom num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "3":
								edittext1.setText("3");
								data.edit().putString("girls bedroom num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "4":
								edittext1.setText("4");
								data.edit().putString("girls bedroom num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "5":
								edittext1.setText("5");
								data.edit().putString("girls bedroom num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "6":
								edittext1.setText("6");
								data.edit().putString("girls bedroom num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "7":
								edittext1.setText("7");
								data.edit().putString("girls bedroom num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "8":
								edittext1.setText("8");
								data.edit().putString("girls bedroom num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "9":
								edittext1.setText("9");
								data.edit().putString("girls bedroom num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; default: return false; } } }); popup.show();
				}
			});
			bedtype_option.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedtype_option);
					
					Menu menu = popup.getMenu();
					menu.add("Single Bed");
					menu.add("Double Bed");
					menu.add("Double Deck");
					 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "Single Bed":
								edittext2.setText("Single Bed");
								data.edit().putString("girls bedtype num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext2.getText().toString()).commit();
								return true; case "Double Bed":
								edittext2.setText("Double Bed");
								data.edit().putString("girls bedtype num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext2.getText().toString()).commit();
								return true; case "Double Deck":
								edittext2.setText("Double Deck");
								data.edit().putString("girls bedtype num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext2.getText().toString()).commit();
								return true; default: return false; } } }); popup.show();
				}
			});
			floor_option.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, floor_option);
					
					Menu menu = popup.getMenu();
					menu.add("1");
					menu.add("2");
					menu.add("3");
					menu.add("4");
					menu.add("5");
					menu.add("6");
					menu.add("7");
					menu.add("8");
					menu.add("9");
					 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
								edittext3.setText("1");
								data.edit().putString("girls floor num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "2":
								edittext3.setText("2");
								data.edit().putString("girls floor num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "3":
								edittext3.setText("3");
								data.edit().putString("girls floor num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "4":
								edittext3.setText("4");
								data.edit().putString("girls floor num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "5":
								edittext3.setText("5");
								data.edit().putString("girls floor num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "6":
								edittext3.setText("6");
								data.edit().putString("girls floor num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "7":
								edittext3.setText("7");
								data.edit().putString("girls floor num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "8":
								edittext3.setText("8");
								data.edit().putString("girls floor num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "9":
								edittext3.setText("9");
								data.edit().putString("girls floor num".concat(_data.get((int)_position).get("girls bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; default: return false; } } }); popup.show();
				}
			});
			remove_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					_telegramLoaderDialog(true);
					girlsRemove = Double.parseDouble(_data.get((int)_position).get("girls bedroom num").toString()) - 1;
					data.edit().remove("girls".concat(_data.get((int)_position).get("girls bedroom num").toString())).commit();
					girls_listmap.remove((int)(_position));
					girls_network.startRequestNetwork(RequestNetworkController.GET, "https://google.com", "Error", _girls_network_request_listener);
				}
			});
			if (type_of_dormitory.contains("Co-ed Dormitory")) {
				if (_data.get((int)_position).get("girls bedroom num").toString().equals("1")) {
					edittext1.setText(data.getString("girls bedroom num1", ""));
					edittext2.setText(data.getString("girls bedtype num1", ""));
					edittext3.setText(data.getString("girls floor num1", ""));
				}
				if (_data.get((int)_position).get("girls bedroom num").toString().equals("2")) {
					edittext1.setText(data.getString("girls bedroom num2", ""));
					edittext2.setText(data.getString("girls bedtype num2", ""));
					edittext3.setText(data.getString("girls floor num2", ""));
				}
				if (_data.get((int)_position).get("girls bedroom num").toString().equals("3")) {
					edittext1.setText(data.getString("girls bedroom num3", ""));
					edittext2.setText(data.getString("girls bedtype num3", ""));
					edittext3.setText(data.getString("girls floor num3", ""));
				}
			}
			else {
				
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
	
	public class Coed_boys_recyclerAdapter extends RecyclerView.Adapter<Coed_boys_recyclerAdapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Coed_boys_recyclerAdapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.bedroom_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final ImageView remove_btn = _view.findViewById(R.id.remove_btn);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final EditText edittext1 = _view.findViewById(R.id.edittext1);
			final ImageView bedroom_option = _view.findViewById(R.id.bedroom_option);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final EditText edittext2 = _view.findViewById(R.id.edittext2);
			final ImageView bedtype_option = _view.findViewById(R.id.bedtype_option);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final androidx.cardview.widget.CardView cardview3 = _view.findViewById(R.id.cardview3);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final EditText edittext3 = _view.findViewById(R.id.edittext3);
			final ImageView floor_option = _view.findViewById(R.id.floor_option);
			
			edittext2.setSingleLine(true);
			if (getIntent().getStringExtra("edit").equals("")) {
				
			}
			else {
				if (getIntent().getStringExtra("edit").equals("true")) {
					
				}
				else {
					if (getIntent().getStringExtra("edit").equals("false")) {
						remove_btn.setVisibility(View.GONE);
						bedroom_option.setEnabled(false);
						bedtype_option.setEnabled(false);
						floor_option.setEnabled(false);
					}
				}
			}
			textview1.setText("Bedroom ".concat(String.valueOf((long)(Double.parseDouble(_data.get((int)_position).get("boys bedroom num").toString()) + 1))));
			boysRemove = Double.parseDouble(_data.get((int)_position).get("boys bedroom num").toString());
			data.edit().putString("boys".concat(_data.get((int)_position).get("boys bedroom num").toString()), _data.get((int)_position).get("boys bedroom num").toString()).commit();
			bedroom_option.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedroom_option);
					
					Menu menu = popup.getMenu();
					menu.add("1");
					menu.add("2");
					menu.add("3");
					menu.add("4");
					menu.add("5");
					menu.add("6");
					menu.add("7");
					menu.add("8");
					menu.add("9");
					 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
								edittext1.setText("1");
								data.edit().putString("boys bedroom num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "2":
								edittext1.setText("2");
								data.edit().putString("boys bedroom num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "3":
								edittext1.setText("3");
								data.edit().putString("boys bedroom num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "4":
								edittext1.setText("4");
								data.edit().putString("boys bedroom num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "5":
								edittext1.setText("5");
								data.edit().putString("boys bedroom num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "6":
								edittext1.setText("6");
								data.edit().putString("boys bedroom num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "7":
								edittext1.setText("7");
								data.edit().putString("boys bedroom num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "8":
								edittext1.setText("8");
								data.edit().putString("boys bedroom num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; case "9":
								edittext1.setText("9");
								data.edit().putString("boys bedroom num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext1.getText().toString()).commit();
								return true; default: return false; } } }); popup.show();
				}
			});
			bedtype_option.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedtype_option);
					
					Menu menu = popup.getMenu();
					menu.add("Single Bed");
					menu.add("Double Bed");
					menu.add("Double Deck");
					 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "Single Bed":
								edittext2.setText("Single Bed");
								data.edit().putString("boys bedtype num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext2.getText().toString()).commit();
								return true; case "Double Bed":
								edittext2.setText("Double Bed");
								data.edit().putString("boys bedtype num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext2.getText().toString()).commit();
								return true; case "Double Deck":
								edittext2.setText("Double Deck");
								data.edit().putString("boys bedtype num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext2.getText().toString()).commit();
								return true; default: return false; } } }); popup.show();
				}
			});
			floor_option.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, floor_option);
					
					Menu menu = popup.getMenu();
					menu.add("1");
					menu.add("2");
					menu.add("3");
					menu.add("4");
					menu.add("5");
					menu.add("6");
					menu.add("7");
					menu.add("8");
					menu.add("9");
					 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
								edittext3.setText("1");
								data.edit().putString("boys floor num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "2":
								edittext3.setText("2");
								data.edit().putString("boys floor num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "3":
								edittext3.setText("3");
								data.edit().putString("boys floor num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "4":
								edittext3.setText("4");
								data.edit().putString("boys floor num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "5":
								edittext3.setText("5");
								data.edit().putString("boys floor num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "6":
								edittext3.setText("6");
								data.edit().putString("boys floor num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "7":
								edittext3.setText("7");
								data.edit().putString("boys floor num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "8":
								edittext3.setText("8");
								data.edit().putString("boys floor num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; case "9":
								edittext3.setText("9");
								data.edit().putString("boys floor num".concat(_data.get((int)_position).get("boys bedroom num").toString()), edittext3.getText().toString()).commit();
								return true; default: return false; } } }); popup.show();
				}
			});
			remove_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					_telegramLoaderDialog(true);
					boysRemove = Double.parseDouble(_data.get((int)_position).get("boys bedroom num").toString()) - 1;
					data.edit().remove("boys".concat(_data.get((int)_position).get("boys bedroom num").toString())).commit();
					boys_listmap.remove((int)(_position));
					boys_network.startRequestNetwork(RequestNetworkController.GET, "https://google.com", "Error", _boys_network_request_listener);
				}
			});
			if (type_of_dormitory.contains("Co-ed Dormitory")) {
				if (_data.get((int)_position).get("boys bedroom num").toString().equals("1")) {
					edittext1.setText(data.getString("boys bedroom num1", ""));
					edittext2.setText(data.getString("boys bedtype num1", ""));
					edittext3.setText(data.getString("boys floor num1", ""));
				}
				if (_data.get((int)_position).get("boys bedroom num").toString().equals("2")) {
					edittext1.setText(data.getString("boys bedroom num2", ""));
					edittext2.setText(data.getString("boys bedtype num2", ""));
					edittext3.setText(data.getString("boys floor num2", ""));
				}
				if (_data.get((int)_position).get("boys bedroom num").toString().equals("3")) {
					edittext1.setText(data.getString("boys bedroom num3", ""));
					edittext2.setText(data.getString("boys bedtype num3", ""));
					edittext3.setText(data.getString("boys floor num3", ""));
				}
			}
			else {
				
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
	
	public class Recyclerview3Adapter extends RecyclerView.Adapter<Recyclerview3Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview3Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.rates_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear15 = _view.findViewById(R.id.linear15);
			final CheckBox checkbox1 = _view.findViewById(R.id.checkbox1);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear10 = _view.findViewById(R.id.linear10);
			final EditText bedroom = _view.findViewById(R.id.bedroom);
			final ImageView bedroom_option = _view.findViewById(R.id.bedroom_option);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final LinearLayout linear11 = _view.findViewById(R.id.linear11);
			final EditText bed = _view.findViewById(R.id.bed);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final androidx.cardview.widget.CardView cardview3 = _view.findViewById(R.id.cardview3);
			final LinearLayout linear12 = _view.findViewById(R.id.linear12);
			final EditText floor = _view.findViewById(R.id.floor);
			final ImageView floor_option = _view.findViewById(R.id.floor_option);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final LinearLayout linear9 = _view.findViewById(R.id.linear9);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final androidx.cardview.widget.CardView cardview4 = _view.findViewById(R.id.cardview4);
			final LinearLayout linear13 = _view.findViewById(R.id.linear13);
			final EditText monthly_price = _view.findViewById(R.id.monthly_price);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final androidx.cardview.widget.CardView cardview5 = _view.findViewById(R.id.cardview5);
			final LinearLayout linear14 = _view.findViewById(R.id.linear14);
			final EditText status = _view.findViewById(R.id.status);
			final ImageView status_option = _view.findViewById(R.id.status_option);
			final ImageView remove = _view.findViewById(R.id.remove);
			
			bedroom.setEnabled(false);
			floor.setEnabled(false);
			status.setEnabled(false);
			checkbox1.setVisibility(View.GONE);
			if (getIntent().getStringExtra("edit").equals("false")) {
				remove.setVisibility(View.GONE);
				bedroom_option.setEnabled(false);
				floor_option.setEnabled(false);
				status_option.setEnabled(false);
				bed.setEnabled(false);
				monthly_price.setEnabled(false);
			}
			else {
				
			}
			if (data.getString("transcient", "").equals("true")) {
				linear7.setVisibility(View.GONE);
			}
			else {
				if (data.getString("transcient", "").equals("false")) {
					linear7.setVisibility(View.VISIBLE);
				}
			}
			data.edit().putString("rate".concat(_data.get((int)_position).get("bedroom num").toString()), _data.get((int)_position).get("bedroom num").toString()).commit();
			bedroomRemove = Double.parseDouble(_data.get((int)_position).get("bedroom num").toString());
			bedroom_option.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (String.valueOf((long)(num)).equals("1")) {
						PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedroom_option);
						
						Menu menu = popup.getMenu();
						menu.add("1");
						 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
									bedroom.setText("1");
									data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
									return true; default: return false; } } }); popup.show();
					}
					else {
						if (String.valueOf((long)(num)).equals("2")) {
							PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedroom_option);
							
							Menu menu = popup.getMenu();
							menu.add("1");
							menu.add("2");
							 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
										bedroom.setText("1");
										data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
										return true; case "2":
										bedroom.setText("2");
										data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
										return true; default: return false; } } }); popup.show();
						}
						else {
							if (String.valueOf((long)(num)).equals("3")) {
								PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedroom_option);
								
								Menu menu = popup.getMenu();
								menu.add("1");
								menu.add("2");
								menu.add("3");
								 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
											bedroom.setText("1");
											data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
											return true; case "2":
											bedroom.setText("2");
											data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
											return true; case "3":
											bedroom.setText("3");
											data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
											return true; default: return false; } } }); popup.show();
							}
							else {
								if (String.valueOf((long)(num)).equals("4")) {
									PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedroom_option);
									
									Menu menu = popup.getMenu();
									menu.add("1");
									menu.add("2");
									menu.add("3");
									menu.add("4");
									 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
												bedroom.setText("1");
												data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
												return true; case "2":
												bedroom.setText("2");
												data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
												return true; case "3":
												bedroom.setText("3");
												data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
												return true; case "4":
												bedroom.setText("4");
												data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
												return true; default: return false; } } }); popup.show();
								}
								else {
									if (String.valueOf((long)(num)).equals("5")) {
										PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedroom_option);
										
										Menu menu = popup.getMenu();
										menu.add("1");
										menu.add("2");
										menu.add("3");
										menu.add("4");
										menu.add("5");
										 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
													bedroom.setText("1");
													data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
													return true; case "2":
													bedroom.setText("2");
													data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
													return true; case "3":
													bedroom.setText("3");
													data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
													return true; case "4":
													bedroom.setText("4");
													data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
													return true; case "5":
													bedroom.setText("5");
													data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
													return true; default: return false; } } }); popup.show();
									}
									else {
										if (String.valueOf((long)(num)).equals("6")) {
											PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedroom_option);
											
											Menu menu = popup.getMenu();
											menu.add("1");
											menu.add("2");
											menu.add("3");
											menu.add("4");
											menu.add("5");
											menu.add("6");
											 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
														bedroom.setText("1");
														data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
														return true; case "2":
														bedroom.setText("2");
														data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
														return true; case "3":
														bedroom.setText("3");
														data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
														return true; case "4":
														bedroom.setText("4");
														data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
														return true; case "5":
														bedroom.setText("5");
														data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
														return true; case "6":
														bedroom.setText("6");
														data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
														return true; default: return false; } } }); popup.show();
										}
										else {
											if (String.valueOf((long)(num)).equals("7")) {
												PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedroom_option);
												
												Menu menu = popup.getMenu();
												menu.add("1");
												menu.add("2");
												menu.add("3");
												menu.add("4");
												menu.add("5");
												menu.add("6");
												menu.add("7");
												 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
															bedroom.setText("1");
															data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
															return true; case "2":
															bedroom.setText("2");
															data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
															return true; case "3":
															bedroom.setText("3");
															data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
															return true; case "4":
															bedroom.setText("4");
															data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
															return true; case "5":
															bedroom.setText("5");
															data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
															return true; case "6":
															bedroom.setText("6");
															data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
															return true; case "7":
															bedroom.setText("7");
															data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
															return true; default: return false; } } }); popup.show();
											}
											else {
												if (String.valueOf((long)(num)).equals("8")) {
													PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedroom_option);
													
													Menu menu = popup.getMenu();
													menu.add("1");
													menu.add("2");
													menu.add("3");
													menu.add("4");
													menu.add("5");
													menu.add("6");
													menu.add("7");
													menu.add("8");
													 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
																bedroom.setText("1");
																data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; case "2":
																bedroom.setText("2");
																data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; case "3":
																bedroom.setText("3");
																data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; case "4":
																bedroom.setText("4");
																data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; case "5":
																bedroom.setText("5");
																data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; case "6":
																bedroom.setText("6");
																data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; case "7":
																bedroom.setText("7");
																data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; case "8":
																bedroom.setText("8");
																data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; default: return false; } } }); popup.show();
												}
												else {
													if (String.valueOf((long)(num)).equals("9")) {
														PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, bedroom_option);
														
														Menu menu = popup.getMenu();
														menu.add("1");
														menu.add("2");
														menu.add("3");
														menu.add("4");
														menu.add("5");
														menu.add("6");
														menu.add("7");
														menu.add("8");
														menu.add("9");
														 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
																	bedroom.setText("1");
																	data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "2":
																	bedroom.setText("2");
																	data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "3":
																	bedroom.setText("3");
																	data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "4":
																	bedroom.setText("4");
																	data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "5":
																	bedroom.setText("5");
																	data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "6":
																	bedroom.setText("6");
																	data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "7":
																	bedroom.setText("7");
																	data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "8":
																	bedroom.setText("8");
																	data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "9":
																	bedroom.setText("9");
																	data.edit().putString("rates bedroom".concat(_data.get((int)_position).get("bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; default: return false; } } }); popup.show();
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			});
			bed.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					d_bed.setTitle("Input Number of Beds");
					final EditText edittext1= new EditText(AdminHomepageActivity.this);
					
					LinearLayout.LayoutParams lpar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
					
					edittext1.setLayoutParams(lpar);
					
					d_bed.setView(edittext1);
					d_bed.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							bed.setText(edittext1.getText());
							data.edit().putString("rates bed".concat(_data.get((int)_position).get("bedroom num").toString()), bed.getText().toString()).commit();
						}
					});
					d_bed.create().show();
				}
			});
			floor_option.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, floor_option);
					
					Menu menu = popup.getMenu();
					menu.add("1");
					menu.add("2");
					menu.add("3");
					menu.add("4");
					menu.add("5");
					menu.add("6");
					menu.add("7");
					menu.add("8");
					menu.add("9");
					 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
								floor.setText("1");
								data.edit().putString("rates floor".concat(_data.get((int)_position).get("bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "2":
								floor.setText("2");
								data.edit().putString("rates floor".concat(_data.get((int)_position).get("bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "3":
								floor.setText("3");
								data.edit().putString("rates floor".concat(_data.get((int)_position).get("bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "4":
								floor.setText("4");
								data.edit().putString("rates floor".concat(_data.get((int)_position).get("bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "5":
								floor.setText("5");
								data.edit().putString("rates floor".concat(_data.get((int)_position).get("bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "6":
								floor.setText("6");
								data.edit().putString("rates floor".concat(_data.get((int)_position).get("bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "7":
								floor.setText("7");
								data.edit().putString("rates floor".concat(_data.get((int)_position).get("bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "8":
								floor.setText("8");
								data.edit().putString("rates floor".concat(_data.get((int)_position).get("bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "9":
								floor.setText("9");
								data.edit().putString("rates floor".concat(_data.get((int)_position).get("bedroom num").toString()), floor.getText().toString()).commit();
								return true; default: return false; } } }); popup.show();
				}
			});
			monthly_price.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					d_monthly_price.setTitle("Input Monthly Price");
					final EditText edittext1= new EditText(AdminHomepageActivity.this);
					
					LinearLayout.LayoutParams lpar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
					
					edittext1.setLayoutParams(lpar);
					
					d_monthly_price.setView(edittext1);
					d_monthly_price.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							monthly_price.setText(edittext1.getText());
							data.edit().putString("rates monthly price".concat(_data.get((int)_position).get("bedroom num").toString()), monthly_price.getText().toString()).commit();
						}
					});
					d_monthly_price.create().show();
				}
			});
			status_option.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, status_option);
					
					Menu menu = popup.getMenu();
					menu.add("Available");
					menu.add("Occupied");
					 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "Available":
								status.setText("Available");
								data.edit().putString("rates status".concat(_data.get((int)_position).get("bedroom num").toString()), status.getText().toString()).commit();
								return true; case "Occupied":
								status.setText("Occupied");
								data.edit().putString("rates status".concat(_data.get((int)_position).get("bedroom num").toString()), status.getText().toString()).commit();
								return true; default: return false; } } }); popup.show();
				}
			});
			remove.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					_telegramLoaderDialog(true);
					rates_listmap.remove((int)(_position));
					network1.startRequestNetwork(RequestNetworkController.GET, "https://google.com", "Error", _network1_request_listener);
				}
			});
			if (type_of_dormitory.contains("Co-ed Dormitory") || (type_of_dormitory.contains("Female Dormitory") || (type_of_dormitory.contains("Male Dormitory") || type_of_dormitory.contains("Gender Neutral Dormitory")))) {
				if (_data.get((int)_position).get("bedroom num").toString().equals("1")) {
					bedroom.setText(data.getString("data rates bedroom1", ""));
					bed.setText(data.getString("data rates bed1", ""));
					floor.setText(data.getString("data rates floor1", ""));
					monthly_price.setText(data.getString("data rates monthly price1", ""));
					status.setText(data.getString("data rates status1", ""));
				}
				if (_data.get((int)_position).get("bedroom num").toString().equals("2")) {
					bedroom.setText(data.getString("data rates bedroom2", ""));
					bed.setText(data.getString("data rates bed2", ""));
					floor.setText(data.getString("data rates floor2", ""));
					monthly_price.setText(data.getString("data rates monthly price2", ""));
					status.setText(data.getString("data rates status2", ""));
				}
				if (_data.get((int)_position).get("bedroom num").toString().equals("3")) {
					bedroom.setText(data.getString("data rates bedroom3", ""));
					bed.setText(data.getString("data rates bed3", ""));
					floor.setText(data.getString("data rates floor3", ""));
					monthly_price.setText(data.getString("data rates monthly price3", ""));
					status.setText(data.getString("data rates status3", ""));
				}
			}
			else {
				
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
	
	public class Recyclerview4Adapter extends RecyclerView.Adapter<Recyclerview4Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview4Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.rates_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear15 = _view.findViewById(R.id.linear15);
			final CheckBox checkbox1 = _view.findViewById(R.id.checkbox1);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear10 = _view.findViewById(R.id.linear10);
			final EditText bedroom = _view.findViewById(R.id.bedroom);
			final ImageView bedroom_option = _view.findViewById(R.id.bedroom_option);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final LinearLayout linear11 = _view.findViewById(R.id.linear11);
			final EditText bed = _view.findViewById(R.id.bed);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final androidx.cardview.widget.CardView cardview3 = _view.findViewById(R.id.cardview3);
			final LinearLayout linear12 = _view.findViewById(R.id.linear12);
			final EditText floor = _view.findViewById(R.id.floor);
			final ImageView floor_option = _view.findViewById(R.id.floor_option);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final LinearLayout linear9 = _view.findViewById(R.id.linear9);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final androidx.cardview.widget.CardView cardview4 = _view.findViewById(R.id.cardview4);
			final LinearLayout linear13 = _view.findViewById(R.id.linear13);
			final EditText monthly_price = _view.findViewById(R.id.monthly_price);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final androidx.cardview.widget.CardView cardview5 = _view.findViewById(R.id.cardview5);
			final LinearLayout linear14 = _view.findViewById(R.id.linear14);
			final EditText status = _view.findViewById(R.id.status);
			final ImageView status_option = _view.findViewById(R.id.status_option);
			final ImageView remove = _view.findViewById(R.id.remove);
			
			bedroom.setEnabled(false);
			floor.setEnabled(false);
			status.setEnabled(false);
			checkbox1.setVisibility(View.GONE);
			if (getIntent().getStringExtra("edit").equals("false")) {
				remove.setVisibility(View.GONE);
				bedroom_option.setEnabled(false);
				floor_option.setEnabled(false);
				status_option.setEnabled(false);
				bed.setEnabled(false);
				monthly_price.setEnabled(false);
			}
			else {
				
			}
			data.edit().putString("boy rate".concat(_data.get((int)_position).get("boys bedroom num").toString()), _data.get((int)_position).get("boys bedroom num").toString()).commit();
			boysBedroomRemove = Double.parseDouble(_data.get((int)_position).get("boys bedroom num").toString());
			bedroom_option.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (String.valueOf((long)(num)).equals("1")) {
						PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_add_beds);
						
						Menu menu = popup.getMenu();
						menu.add("1");
						 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
									bedroom.setText("1");
									data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
									return true; default: return false; } } }); popup.show();
					}
					else {
						if (String.valueOf((long)(num)).equals("2")) {
							PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_add_beds);
							
							Menu menu = popup.getMenu();
							menu.add("1");
							menu.add("2");
							 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
										bedroom.setText("1");
										data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
										return true; case "2":
										bedroom.setText("2");
										data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
										return true; default: return false; } } }); popup.show();
						}
						else {
							if (String.valueOf((long)(num)).equals("3")) {
								PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_add_beds);
								
								Menu menu = popup.getMenu();
								menu.add("1");
								menu.add("2");
								menu.add("3");
								 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
											bedroom.setText("1");
											data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
											return true; case "2":
											bedroom.setText("2");
											data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
											return true; case "3":
											bedroom.setText("3");
											data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
											return true; default: return false; } } }); popup.show();
							}
							else {
								if (String.valueOf((long)(num)).equals("4")) {
									PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_add_beds);
									
									Menu menu = popup.getMenu();
									menu.add("1");
									menu.add("2");
									menu.add("3");
									menu.add("4");
									 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
												bedroom.setText("1");
												data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
												return true; case "2":
												bedroom.setText("2");
												data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
												return true; case "3":
												bedroom.setText("3");
												data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
												return true; case "4":
												bedroom.setText("4");
												data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
												return true; default: return false; } } }); popup.show();
								}
								else {
									if (String.valueOf((long)(num)).equals("5")) {
										PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_add_beds);
										
										Menu menu = popup.getMenu();
										menu.add("1");
										menu.add("2");
										menu.add("3");
										menu.add("4");
										menu.add("5");
										 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
													bedroom.setText("1");
													data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
													return true; case "2":
													bedroom.setText("2");
													data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
													return true; case "3":
													bedroom.setText("3");
													data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
													return true; case "4":
													bedroom.setText("4");
													data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
													return true; case "5":
													bedroom.setText("5");
													data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
													return true; default: return false; } } }); popup.show();
									}
									else {
										if (String.valueOf((long)(num)).equals("6")) {
											PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_add_beds);
											
											Menu menu = popup.getMenu();
											menu.add("1");
											menu.add("2");
											menu.add("3");
											menu.add("4");
											menu.add("5");
											menu.add("6");
											 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
														bedroom.setText("1");
														data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
														return true; case "2":
														bedroom.setText("2");
														data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
														return true; case "3":
														bedroom.setText("3");
														data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
														return true; case "4":
														bedroom.setText("4");
														data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
														return true; case "5":
														bedroom.setText("5");
														data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
														return true; case "6":
														bedroom.setText("6");
														data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
														return true; default: return false; } } }); popup.show();
										}
										else {
											if (String.valueOf((long)(num)).equals("7")) {
												PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_add_beds);
												
												Menu menu = popup.getMenu();
												menu.add("1");
												menu.add("2");
												menu.add("3");
												menu.add("4");
												menu.add("5");
												menu.add("6");
												menu.add("7");
												 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
															bedroom.setText("1");
															data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
															return true; case "2":
															bedroom.setText("2");
															data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
															return true; case "3":
															bedroom.setText("3");
															data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
															return true; case "4":
															bedroom.setText("4");
															data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
															return true; case "5":
															bedroom.setText("5");
															data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
															return true; case "6":
															bedroom.setText("6");
															data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
															return true; case "7":
															bedroom.setText("7");
															data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
															return true; default: return false; } } }); popup.show();
											}
											else {
												if (String.valueOf((long)(num)).equals("8")) {
													PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_add_beds);
													
													Menu menu = popup.getMenu();
													menu.add("1");
													menu.add("2");
													menu.add("3");
													menu.add("4");
													menu.add("5");
													menu.add("6");
													menu.add("7");
													menu.add("8");
													 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
																bedroom.setText("1");
																data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; case "2":
																bedroom.setText("2");
																data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; case "3":
																bedroom.setText("3");
																data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; case "4":
																bedroom.setText("4");
																data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; case "5":
																bedroom.setText("5");
																data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; case "6":
																bedroom.setText("6");
																data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; case "7":
																bedroom.setText("7");
																data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; case "8":
																bedroom.setText("8");
																data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																return true; default: return false; } } }); popup.show();
												}
												else {
													if (String.valueOf((long)(num)).equals("9")) {
														PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, boys_add_beds);
														
														Menu menu = popup.getMenu();
														menu.add("1");
														menu.add("2");
														menu.add("3");
														menu.add("4");
														menu.add("5");
														menu.add("6");
														menu.add("7");
														menu.add("8");
														menu.add("9");
														 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
																	bedroom.setText("1");
																	data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "2":
																	bedroom.setText("2");
																	data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "3":
																	bedroom.setText("3");
																	data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "4":
																	bedroom.setText("4");
																	data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "5":
																	bedroom.setText("5");
																	data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "6":
																	bedroom.setText("6");
																	data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "7":
																	bedroom.setText("7");
																	data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "8":
																	bedroom.setText("8");
																	data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; case "9":
																	bedroom.setText("9");
																	data.edit().putString("boys rates bedroom".concat(_data.get((int)_position).get("boys bedroom num").toString()), bedroom.getText().toString()).commit();
																	return true; default: return false; } } }); popup.show();
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			});
			bed.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					d_bed.setTitle("Input Number of Beds");
					final EditText edittext1= new EditText(AdminHomepageActivity.this);
					
					LinearLayout.LayoutParams lpar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
					
					edittext1.setLayoutParams(lpar);
					
					d_bed.setView(edittext1);
					d_bed.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							bed.setText(edittext1.getText());
							data.edit().putString("boys rates bed".concat(_data.get((int)_position).get("boys bedroom num").toString()), bed.getText().toString()).commit();
						}
					});
					d_bed.create().show();
				}
			});
			floor_option.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, floor_option);
					
					Menu menu = popup.getMenu();
					menu.add("1");
					menu.add("2");
					menu.add("3");
					menu.add("4");
					menu.add("5");
					menu.add("6");
					menu.add("7");
					menu.add("8");
					menu.add("9");
					 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "1":
								floor.setText("1");
								data.edit().putString("boys rates floor".concat(_data.get((int)_position).get("boys bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "2":
								floor.setText("2");
								data.edit().putString("boys rates floor".concat(_data.get((int)_position).get("boys bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "3":
								floor.setText("3");
								data.edit().putString("boys rates floor".concat(_data.get((int)_position).get("boys bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "4":
								floor.setText("4");
								data.edit().putString("boys rates floor".concat(_data.get((int)_position).get("boys bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "5":
								floor.setText("5");
								data.edit().putString("boys rates floor".concat(_data.get((int)_position).get("boys bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "6":
								floor.setText("6");
								data.edit().putString("boys rates floor".concat(_data.get((int)_position).get("boys bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "7":
								floor.setText("7");
								data.edit().putString("boys rates floor".concat(_data.get((int)_position).get("boys bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "8":
								floor.setText("8");
								data.edit().putString("boys rates floor".concat(_data.get((int)_position).get("boys bedroom num").toString()), floor.getText().toString()).commit();
								return true; case "9":
								floor.setText("9");
								data.edit().putString("boys rates floor".concat(_data.get((int)_position).get("boys bedroom num").toString()), floor.getText().toString()).commit();
								return true; default: return false; } } }); popup.show();
				}
			});
			monthly_price.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					d_monthly_price.setTitle("Input Monthly Price");
					final EditText edittext1= new EditText(AdminHomepageActivity.this);
					
					LinearLayout.LayoutParams lpar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
					
					edittext1.setLayoutParams(lpar);
					
					d_monthly_price.setView(edittext1);
					d_monthly_price.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							monthly_price.setText(edittext1.getText());
							data.edit().putString("boys rates monthly price".concat(_data.get((int)_position).get("boys bedroom num").toString()), monthly_price.getText().toString()).commit();
						}
					});
					d_monthly_price.create().show();
				}
			});
			status_option.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					PopupMenu popup = new PopupMenu(AdminHomepageActivity.this, status_option);
					
					Menu menu = popup.getMenu();
					menu.add("Available");
					menu.add("Occupied");
					 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { public boolean onMenuItemClick(MenuItem item) { switch (item.getTitle().toString()) { case "Available":
								status.setText("Available");
								data.edit().putString("boys rates status".concat(_data.get((int)_position).get("boys bedroom num").toString()), status.getText().toString()).commit();
								return true; case "Occupied":
								status.setText("Occupied");
								data.edit().putString("boys rates status".concat(_data.get((int)_position).get("boys bedroom num").toString()), status.getText().toString()).commit();
								return true; default: return false; } } }); popup.show();
				}
			});
			remove.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					_telegramLoaderDialog(true);
					boys_bedroom_listmap.remove((int)(_position));
					network2.startRequestNetwork(RequestNetworkController.GET, "https://google.com", "Error", _network2_request_listener);
				}
			});
			if (type_of_dormitory.contains("Co-ed Dormitory")) {
				if (_data.get((int)_position).get("boys bedroom num").toString().equals("1")) {
					bedroom.setText(data.getString("boys data rates bedroom1", ""));
					bed.setText(data.getString("boys data rates bed1", ""));
					floor.setText(data.getString("boys data rates floor1", ""));
					monthly_price.setText(data.getString("boys data rates monthly price1", ""));
					status.setText(data.getString("boys data rates status1", ""));
				}
				if (_data.get((int)_position).get("boys bedroom num").toString().equals("2")) {
					bedroom.setText(data.getString("boys data rates bedroom2", ""));
					bed.setText(data.getString("boys data rates bed2", ""));
					floor.setText(data.getString("boys data rates floor2", ""));
					monthly_price.setText(data.getString("boys data rates monthly price2", ""));
					status.setText(data.getString("boys data rates status2", ""));
				}
				if (_data.get((int)_position).get("boys bedroom num").toString().equals("3")) {
					bedroom.setText(data.getString("boys data rates bedroom3", ""));
					bed.setText(data.getString("boys data rates bed3", ""));
					floor.setText(data.getString("boys data rates floor3", ""));
					monthly_price.setText(data.getString("boys data rates monthly price3", ""));
					status.setText(data.getString("boys data rates status3", ""));
				}
			}
			else {
				
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
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.review_post, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final TextView message = _view.findViewById(R.id.message);
			final TextView date = _view.findViewById(R.id.date);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final TextView user_fullname = _view.findViewById(R.id.user_fullname);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final ImageView see_review = _view.findViewById(R.id.see_review);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final androidx.cardview.widget.CardView cardview4 = _view.findViewById(R.id.cardview4);
			final ImageView user_profile = _view.findViewById(R.id.user_profile);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final androidx.cardview.widget.CardView cardview3 = _view.findViewById(R.id.cardview3);
			final TextView rate = _view.findViewById(R.id.rate);
			
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_view.setLayoutParams(_lp);
			_simpleRiffle(linear1);
			_riffleEffect("#f5f5f5", see_review);
			_setSingleLine(user_fullname, true);
			_ImageColor(see_review, "#176b87");
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("profile")) {
				Glide.with(getApplicationContext()).load(Uri.parse(UserProfile.get(_data.get((int)(_data.size() - 1) - _position).get("profile").toString()).toString())).into(user_profile);
			}
			else {
				user_profile.setImageResource(R.drawable.profile);
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("fullname")) {
				user_fullname.setText(UserName.get(_data.get((int)(_data.size() - 1) - _position).get("fullname").toString()).toString());
			}
			else {
				user_fullname.setText("Anonymous");
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("rating")) {
				rate.setText("⭐ ".concat(_data.get((int)(_data.size() - 1) - _position).get("rating").toString()));
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("msg")) {
				message.setText(_data.get((int)(_data.size() - 1) - _position).get("msg").toString());
			}
			else {
				
			}
			if (_data.get((int)(_data.size() - 1) - _position).containsKey("date")) {
				cal.setTimeInMillis((long)(Double.parseDouble(_data.get((int)(_data.size() - 1) - _position).get("date").toString())));
				now = Calendar.getInstance();
				if ((long)(now.getTimeInMillis() - cal.getTimeInMillis()) > (1000 * (3600 * 24))) {
					date.setText(new SimpleDateFormat("MMM dd, yyyy").format(cal.getTime()));
				}
				else {
					date.setText(new SimpleDateFormat("hh:mm a").format(cal.getTime()));
				}
			}
			else {
				
			}
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					
				}
			});
			see_review.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), ReteDormitoryActivity.class);
					intent.putExtra("post getPost", getIntent().getStringExtra("getPost"));
					intent.putExtra("getPost", _data.get((int)(_data.size() - 1) - _position).get("getPost").toString());
					intent.putExtra("uid", _data.get((int)(_data.size() - 1) - _position).get("uid").toString());
					intent.putExtra("review", "true");
					startActivity(intent);
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