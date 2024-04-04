package fastrust.dorm.finder;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.SharedPreferences;
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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.prime.arab.ware.everythingutils.*;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.FirebaseApp;
import com.shobhitpuri.custombuttons.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import com.google.android.material.slider.Slider;
import com.google.android.material.slider.RangeSlider;

public class FilterBottomdialogFragmentDialogFragmentActivity extends BottomSheetDialogFragment {
	
	private Timer _timer = new Timer();
	
	private boolean isVisible = false;
	
	private LinearLayout bg;
	private CardView cardview1;
	private TextView textview1;
	private ScrollView vscroll1;
	private LinearLayout bottom;
	private LinearLayout linear2;
	private LinearLayout center;
	private TextView textview2;
	private HorizontalScrollView hscroll1;
	private TextView textview3;
	private RangeSlider seekbar1;
	private TextView textview5;
	private HorizontalScrollView hscroll2;
	private TextView textview6;
	private HorizontalScrollView hscroll3;
	private TextView textview7;
	private HorizontalScrollView hscroll4;
	private LinearLayout linear4;
	private CardView cardview2;
	private CardView cardview3;
	private CardView cardview4;
	private CardView cardview5;
	private CardView cardview6;
	private CardView cardview79;
	private LinearLayout linear9;
	private CardView cardview23;
	private TextView select_all;
	private LinearLayout linear10;
	private CardView cardview24;
	private TextView select_female;
	private LinearLayout linear11;
	private CardView cardview25;
	private TextView select_male;
	private LinearLayout linear12;
	private CardView cardview26;
	private TextView select_co_ed;
	private LinearLayout linear13;
	private CardView cardview27;
	private TextView select_gender;
	private LinearLayout linear49;
	private CardView cardview80;
	private TextView select_transient;
	private LinearLayout linear5;
	private CardView cardview8;
	private CardView cardview9;
	private CardView cardview10;
	private CardView cardview11;
	private CardView cardview42;
	private CardView cardview34;
	private CardView cardview36;
	private CardView cardview39;
	private CardView cardview12;
	private LinearLayout linear16;
	private CardView cardview29;
	private TextView amenities_any;
	private LinearLayout linear17;
	private CardView cardview30;
	private TextView amenities_parking_lot;
	private LinearLayout linear18;
	private CardView cardview31;
	private TextView amenities_canteen;
	private LinearLayout linear19;
	private CardView cardview32;
	private TextView amenities_bathroom;
	private LinearLayout linear26;
	private CardView cardview43;
	private TextView amenities_laundry;
	private LinearLayout linear21;
	private CardView cardview35;
	private LinearLayout linear22;
	private TextView amenities_security;
	private LinearLayout linear23;
	private CardView cardview37;
	private TextView amenities_visiting;
	private LinearLayout linear24;
	private CardView cardview40;
	private TextView amenities_balcony;
	private LinearLayout linear20;
	private CardView cardview33;
	private TextView amenities_gated;
	private LinearLayout linear7;
	private CardView cardview13;
	private CardView cardview53;
	private CardView cardview52;
	private CardView cardview14;
	private CardView cardview44;
	private CardView cardview45;
	private CardView cardview46;
	private CardView cardview47;
	private CardView cardview48;
	private CardView cardview49;
	private CardView cardview50;
	private LinearLayout linear25;
	private CardView cardview38;
	private TextView inclusion_any;
	private LinearLayout linear27;
	private CardView cardview54;
	private TextView inclusion_refrigerator;
	private LinearLayout linear28;
	private CardView cardview55;
	private TextView inclusion_rice_cooker;
	private LinearLayout linear29;
	private CardView cardview56;
	private TextView inclusion_washing_machine;
	private LinearLayout linear30;
	private CardView cardview57;
	private TextView inclusion_electric_fan;
	private LinearLayout linear31;
	private CardView cardview58;
	private TextView inclusion_electric_stove;
	private LinearLayout linear32;
	private CardView cardview59;
	private TextView inclusion_cabinet;
	private LinearLayout linear33;
	private CardView cardview60;
	private TextView inclusion_charging_port;
	private LinearLayout linear34;
	private CardView cardview61;
	private TextView inclusion_ablution;
	private LinearLayout linear35;
	private CardView cardview62;
	private TextView inclusion_allow_pets;
	private LinearLayout linear36;
	private CardView cardview63;
	private TextView inclusion_allow_smoking;
	private LinearLayout linear8;
	private CardView cardview15;
	private CardView cardview16;
	private CardView cardview17;
	private CardView cardview18;
	private CardView cardview19;
	private CardView cardview20;
	private LinearLayout linear37;
	private CardView cardview64;
	private TextView rating_all;
	private LinearLayout linear44;
	private CardView cardview74;
	private TextView rating5;
	private LinearLayout linear45;
	private CardView cardview75;
	private TextView rating4;
	private LinearLayout linear46;
	private CardView cardview76;
	private TextView rating3;
	private LinearLayout linear47;
	private CardView cardview77;
	private TextView rating2;
	private LinearLayout linear48;
	private CardView cardview78;
	private TextView rating1;
	private CardView cardview21;
	private CardView cardview22;
	private LinearLayout reset_btn;
	private TextView textview8;
	private LinearLayout apply_btn;
	private TextView textview9;
	
	private SharedPreferences data;
	private TimerTask timer;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.filter_bottomdialog_fragment_dialog_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		bg = _view.findViewById(R.id.bg);
		cardview1 = _view.findViewById(R.id.cardview1);
		textview1 = _view.findViewById(R.id.textview1);
		vscroll1 = _view.findViewById(R.id.vscroll1);
		bottom = _view.findViewById(R.id.bottom);
		linear2 = _view.findViewById(R.id.linear2);
		center = _view.findViewById(R.id.center);
		textview2 = _view.findViewById(R.id.textview2);
		hscroll1 = _view.findViewById(R.id.hscroll1);
		textview3 = _view.findViewById(R.id.textview3);
		seekbar1 = _view.findViewById(R.id.seekbar1);
		textview5 = _view.findViewById(R.id.textview5);
		hscroll2 = _view.findViewById(R.id.hscroll2);
		textview6 = _view.findViewById(R.id.textview6);
		hscroll3 = _view.findViewById(R.id.hscroll3);
		textview7 = _view.findViewById(R.id.textview7);
		hscroll4 = _view.findViewById(R.id.hscroll4);
		linear4 = _view.findViewById(R.id.linear4);
		cardview2 = _view.findViewById(R.id.cardview2);
		cardview3 = _view.findViewById(R.id.cardview3);
		cardview4 = _view.findViewById(R.id.cardview4);
		cardview5 = _view.findViewById(R.id.cardview5);
		cardview6 = _view.findViewById(R.id.cardview6);
		cardview79 = _view.findViewById(R.id.cardview79);
		linear9 = _view.findViewById(R.id.linear9);
		cardview23 = _view.findViewById(R.id.cardview23);
		select_all = _view.findViewById(R.id.select_all);
		linear10 = _view.findViewById(R.id.linear10);
		cardview24 = _view.findViewById(R.id.cardview24);
		select_female = _view.findViewById(R.id.select_female);
		linear11 = _view.findViewById(R.id.linear11);
		cardview25 = _view.findViewById(R.id.cardview25);
		select_male = _view.findViewById(R.id.select_male);
		linear12 = _view.findViewById(R.id.linear12);
		cardview26 = _view.findViewById(R.id.cardview26);
		select_co_ed = _view.findViewById(R.id.select_co_ed);
		linear13 = _view.findViewById(R.id.linear13);
		cardview27 = _view.findViewById(R.id.cardview27);
		select_gender = _view.findViewById(R.id.select_gender);
		linear49 = _view.findViewById(R.id.linear49);
		cardview80 = _view.findViewById(R.id.cardview80);
		select_transient = _view.findViewById(R.id.select_transient);
		linear5 = _view.findViewById(R.id.linear5);
		cardview8 = _view.findViewById(R.id.cardview8);
		cardview9 = _view.findViewById(R.id.cardview9);
		cardview10 = _view.findViewById(R.id.cardview10);
		cardview11 = _view.findViewById(R.id.cardview11);
		cardview42 = _view.findViewById(R.id.cardview42);
		cardview34 = _view.findViewById(R.id.cardview34);
		cardview36 = _view.findViewById(R.id.cardview36);
		cardview39 = _view.findViewById(R.id.cardview39);
		cardview12 = _view.findViewById(R.id.cardview12);
		linear16 = _view.findViewById(R.id.linear16);
		cardview29 = _view.findViewById(R.id.cardview29);
		amenities_any = _view.findViewById(R.id.amenities_any);
		linear17 = _view.findViewById(R.id.linear17);
		cardview30 = _view.findViewById(R.id.cardview30);
		amenities_parking_lot = _view.findViewById(R.id.amenities_parking_lot);
		linear18 = _view.findViewById(R.id.linear18);
		cardview31 = _view.findViewById(R.id.cardview31);
		amenities_canteen = _view.findViewById(R.id.amenities_canteen);
		linear19 = _view.findViewById(R.id.linear19);
		cardview32 = _view.findViewById(R.id.cardview32);
		amenities_bathroom = _view.findViewById(R.id.amenities_bathroom);
		linear26 = _view.findViewById(R.id.linear26);
		cardview43 = _view.findViewById(R.id.cardview43);
		amenities_laundry = _view.findViewById(R.id.amenities_laundry);
		linear21 = _view.findViewById(R.id.linear21);
		cardview35 = _view.findViewById(R.id.cardview35);
		linear22 = _view.findViewById(R.id.linear22);
		amenities_security = _view.findViewById(R.id.amenities_security);
		linear23 = _view.findViewById(R.id.linear23);
		cardview37 = _view.findViewById(R.id.cardview37);
		amenities_visiting = _view.findViewById(R.id.amenities_visiting);
		linear24 = _view.findViewById(R.id.linear24);
		cardview40 = _view.findViewById(R.id.cardview40);
		amenities_balcony = _view.findViewById(R.id.amenities_balcony);
		linear20 = _view.findViewById(R.id.linear20);
		cardview33 = _view.findViewById(R.id.cardview33);
		amenities_gated = _view.findViewById(R.id.amenities_gated);
		linear7 = _view.findViewById(R.id.linear7);
		cardview13 = _view.findViewById(R.id.cardview13);
		cardview53 = _view.findViewById(R.id.cardview53);
		cardview52 = _view.findViewById(R.id.cardview52);
		cardview14 = _view.findViewById(R.id.cardview14);
		cardview44 = _view.findViewById(R.id.cardview44);
		cardview45 = _view.findViewById(R.id.cardview45);
		cardview46 = _view.findViewById(R.id.cardview46);
		cardview47 = _view.findViewById(R.id.cardview47);
		cardview48 = _view.findViewById(R.id.cardview48);
		cardview49 = _view.findViewById(R.id.cardview49);
		cardview50 = _view.findViewById(R.id.cardview50);
		linear25 = _view.findViewById(R.id.linear25);
		cardview38 = _view.findViewById(R.id.cardview38);
		inclusion_any = _view.findViewById(R.id.inclusion_any);
		linear27 = _view.findViewById(R.id.linear27);
		cardview54 = _view.findViewById(R.id.cardview54);
		inclusion_refrigerator = _view.findViewById(R.id.inclusion_refrigerator);
		linear28 = _view.findViewById(R.id.linear28);
		cardview55 = _view.findViewById(R.id.cardview55);
		inclusion_rice_cooker = _view.findViewById(R.id.inclusion_rice_cooker);
		linear29 = _view.findViewById(R.id.linear29);
		cardview56 = _view.findViewById(R.id.cardview56);
		inclusion_washing_machine = _view.findViewById(R.id.inclusion_washing_machine);
		linear30 = _view.findViewById(R.id.linear30);
		cardview57 = _view.findViewById(R.id.cardview57);
		inclusion_electric_fan = _view.findViewById(R.id.inclusion_electric_fan);
		linear31 = _view.findViewById(R.id.linear31);
		cardview58 = _view.findViewById(R.id.cardview58);
		inclusion_electric_stove = _view.findViewById(R.id.inclusion_electric_stove);
		linear32 = _view.findViewById(R.id.linear32);
		cardview59 = _view.findViewById(R.id.cardview59);
		inclusion_cabinet = _view.findViewById(R.id.inclusion_cabinet);
		linear33 = _view.findViewById(R.id.linear33);
		cardview60 = _view.findViewById(R.id.cardview60);
		inclusion_charging_port = _view.findViewById(R.id.inclusion_charging_port);
		linear34 = _view.findViewById(R.id.linear34);
		cardview61 = _view.findViewById(R.id.cardview61);
		inclusion_ablution = _view.findViewById(R.id.inclusion_ablution);
		linear35 = _view.findViewById(R.id.linear35);
		cardview62 = _view.findViewById(R.id.cardview62);
		inclusion_allow_pets = _view.findViewById(R.id.inclusion_allow_pets);
		linear36 = _view.findViewById(R.id.linear36);
		cardview63 = _view.findViewById(R.id.cardview63);
		inclusion_allow_smoking = _view.findViewById(R.id.inclusion_allow_smoking);
		linear8 = _view.findViewById(R.id.linear8);
		cardview15 = _view.findViewById(R.id.cardview15);
		cardview16 = _view.findViewById(R.id.cardview16);
		cardview17 = _view.findViewById(R.id.cardview17);
		cardview18 = _view.findViewById(R.id.cardview18);
		cardview19 = _view.findViewById(R.id.cardview19);
		cardview20 = _view.findViewById(R.id.cardview20);
		linear37 = _view.findViewById(R.id.linear37);
		cardview64 = _view.findViewById(R.id.cardview64);
		rating_all = _view.findViewById(R.id.rating_all);
		linear44 = _view.findViewById(R.id.linear44);
		cardview74 = _view.findViewById(R.id.cardview74);
		rating5 = _view.findViewById(R.id.rating5);
		linear45 = _view.findViewById(R.id.linear45);
		cardview75 = _view.findViewById(R.id.cardview75);
		rating4 = _view.findViewById(R.id.rating4);
		linear46 = _view.findViewById(R.id.linear46);
		cardview76 = _view.findViewById(R.id.cardview76);
		rating3 = _view.findViewById(R.id.rating3);
		linear47 = _view.findViewById(R.id.linear47);
		cardview77 = _view.findViewById(R.id.cardview77);
		rating2 = _view.findViewById(R.id.rating2);
		linear48 = _view.findViewById(R.id.linear48);
		cardview78 = _view.findViewById(R.id.cardview78);
		rating1 = _view.findViewById(R.id.rating1);
		cardview21 = _view.findViewById(R.id.cardview21);
		cardview22 = _view.findViewById(R.id.cardview22);
		reset_btn = _view.findViewById(R.id.reset_btn);
		textview8 = _view.findViewById(R.id.textview8);
		apply_btn = _view.findViewById(R.id.apply_btn);
		textview9 = _view.findViewById(R.id.textview9);
		data = getContext().getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		select_all.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("category", "All").commit();
				select_all.setTextColor(0xFFFFFFFF);
				select_female.setTextColor(0xFF176B87);
				select_male.setTextColor(0xFF176B87);
				select_transient.setTextColor(0xFF176B87);
				select_co_ed.setTextColor(0xFF176B87);
				select_gender.setTextColor(0xFF176B87);
				select_transient.setTextColor(0xFF176B87);
				select_all.setBackgroundColor(0xFF176B87);
				select_female.setBackgroundColor(0xFFFFFFFF);
				select_male.setBackgroundColor(0xFFFFFFFF);
				select_transient.setBackgroundColor(0xFFFFFFFF);
				select_co_ed.setBackgroundColor(0xFFFFFFFF);
				select_gender.setBackgroundColor(0xFFFFFFFF);
				select_transient.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		select_female.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("category", "Female Dormitory").commit();
				select_all.setTextColor(0xFF176B87);
				select_female.setTextColor(0xFFFFFFFF);
				select_male.setTextColor(0xFF176B87);
				select_transient.setTextColor(0xFF176B87);
				select_co_ed.setTextColor(0xFF176B87);
				select_gender.setTextColor(0xFF176B87);
				select_transient.setTextColor(0xFF176B87);
				select_all.setBackgroundColor(0xFFFFFFFF);
				select_female.setBackgroundColor(0xFF176B87);
				select_male.setBackgroundColor(0xFFFFFFFF);
				select_transient.setBackgroundColor(0xFFFFFFFF);
				select_co_ed.setBackgroundColor(0xFFFFFFFF);
				select_gender.setBackgroundColor(0xFFFFFFFF);
				select_transient.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		select_male.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("category", "Male Dormitory").commit();
				select_all.setTextColor(0xFF176B87);
				select_female.setTextColor(0xFF176B87);
				select_male.setTextColor(0xFFFFFFFF);
				select_transient.setTextColor(0xFF176B87);
				select_co_ed.setTextColor(0xFF176B87);
				select_gender.setTextColor(0xFF176B87);
				select_transient.setTextColor(0xFF176B87);
				select_all.setBackgroundColor(0xFFFFFFFF);
				select_female.setBackgroundColor(0xFFFFFFFF);
				select_male.setBackgroundColor(0xFF176B87);
				select_transient.setBackgroundColor(0xFFFFFFFF);
				select_co_ed.setBackgroundColor(0xFFFFFFFF);
				select_gender.setBackgroundColor(0xFFFFFFFF);
				select_transient.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		select_co_ed.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("category", "Co-ed Dormitory").commit();
				select_all.setTextColor(0xFF176B87);
				select_female.setTextColor(0xFF176B87);
				select_male.setTextColor(0xFF176B87);
				select_transient.setTextColor(0xFF176B87);
				select_co_ed.setTextColor(0xFFFFFFFF);
				select_gender.setTextColor(0xFF176B87);
				select_transient.setTextColor(0xFF176B87);
				select_all.setBackgroundColor(0xFFFFFFFF);
				select_female.setBackgroundColor(0xFFFFFFFF);
				select_male.setBackgroundColor(0xFFFFFFFF);
				select_transient.setBackgroundColor(0xFFFFFFFF);
				select_co_ed.setBackgroundColor(0xFF176B87);
				select_gender.setBackgroundColor(0xFFFFFFFF);
				select_transient.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		select_gender.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("category", "Gender-neutral Dormitory").commit();
				select_all.setTextColor(0xFF176B87);
				select_female.setTextColor(0xFF176B87);
				select_male.setTextColor(0xFF176B87);
				select_transient.setTextColor(0xFF176B87);
				select_co_ed.setTextColor(0xFF176B87);
				select_gender.setTextColor(0xFFFFFFFF);
				select_transient.setTextColor(0xFF176B87);
				select_all.setBackgroundColor(0xFFFFFFFF);
				select_female.setBackgroundColor(0xFFFFFFFF);
				select_male.setBackgroundColor(0xFFFFFFFF);
				select_transient.setBackgroundColor(0xFFFFFFFF);
				select_co_ed.setBackgroundColor(0xFFFFFFFF);
				select_gender.setBackgroundColor(0xFF176B87);
				select_transient.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		select_transient.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("category", "Transcient").commit();
				select_all.setTextColor(0xFF176B87);
				select_female.setTextColor(0xFF176B87);
				select_male.setTextColor(0xFF176B87);
				select_transient.setTextColor(0xFF176B87);
				select_co_ed.setTextColor(0xFF176B87);
				select_gender.setTextColor(0xFF176B87);
				select_transient.setTextColor(0xFFFFFFFF);
				select_all.setBackgroundColor(0xFFFFFFFF);
				select_female.setBackgroundColor(0xFFFFFFFF);
				select_male.setBackgroundColor(0xFFFFFFFF);
				select_transient.setBackgroundColor(0xFFFFFFFF);
				select_co_ed.setBackgroundColor(0xFFFFFFFF);
				select_gender.setBackgroundColor(0xFFFFFFFF);
				select_transient.setBackgroundColor(0xFF176B87);
			}
		});
		
		amenities_any.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				amenities_any.setTextColor(0xFFFFFFFF);
				amenities_parking_lot.setTextColor(0xFF176B87);
				amenities_canteen.setTextColor(0xFF176B87);
				amenities_bathroom.setTextColor(0xFF176B87);
				amenities_gated.setTextColor(0xFF176B87);
				amenities_security.setTextColor(0xFF176B87);
				amenities_visiting.setTextColor(0xFF176B87);
				amenities_balcony.setTextColor(0xFF176B87);
				amenities_laundry.setTextColor(0xFF176B87);
				data.edit().putString("amenities", amenities_any.getText().toString()).commit();
				amenities_any.setBackgroundColor(0xFF176B87);
				amenities_parking_lot.setBackgroundColor(0xFFFFFFFF);
				amenities_canteen.setBackgroundColor(0xFFFFFFFF);
				amenities_bathroom.setBackgroundColor(0xFFFFFFFF);
				amenities_gated.setBackgroundColor(0xFFFFFFFF);
				amenities_security.setBackgroundColor(0xFFFFFFFF);
				amenities_visiting.setBackgroundColor(0xFFFFFFFF);
				amenities_balcony.setBackgroundColor(0xFFFFFFFF);
				amenities_laundry.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		amenities_parking_lot.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				amenities_any.setTextColor(0xFF176B87);
				amenities_parking_lot.setTextColor(0xFFFFFFFF);
				amenities_canteen.setTextColor(0xFF176B87);
				amenities_bathroom.setTextColor(0xFF176B87);
				amenities_gated.setTextColor(0xFF176B87);
				amenities_security.setTextColor(0xFF176B87);
				amenities_visiting.setTextColor(0xFF176B87);
				amenities_balcony.setTextColor(0xFF176B87);
				amenities_laundry.setTextColor(0xFF176B87);
				data.edit().putString("amenities", amenities_parking_lot.getText().toString()).commit();
				amenities_any.setBackgroundColor(0xFFFFFFFF);
				amenities_parking_lot.setBackgroundColor(0xFF176B87);
				amenities_canteen.setBackgroundColor(0xFFFFFFFF);
				amenities_bathroom.setBackgroundColor(0xFFFFFFFF);
				amenities_gated.setBackgroundColor(0xFFFFFFFF);
				amenities_security.setBackgroundColor(0xFFFFFFFF);
				amenities_visiting.setBackgroundColor(0xFFFFFFFF);
				amenities_balcony.setBackgroundColor(0xFFFFFFFF);
				amenities_laundry.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		amenities_canteen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				amenities_any.setTextColor(0xFF176B87);
				amenities_parking_lot.setTextColor(0xFF176B87);
				amenities_canteen.setTextColor(0xFFFFFFFF);
				amenities_bathroom.setTextColor(0xFF176B87);
				amenities_gated.setTextColor(0xFF176B87);
				amenities_security.setTextColor(0xFF176B87);
				amenities_visiting.setTextColor(0xFF176B87);
				amenities_balcony.setTextColor(0xFF176B87);
				amenities_laundry.setTextColor(0xFF176B87);
				data.edit().putString("amenities", amenities_canteen.getText().toString()).commit();
				amenities_any.setBackgroundColor(0xFFFFFFFF);
				amenities_parking_lot.setBackgroundColor(0xFFFFFFFF);
				amenities_canteen.setBackgroundColor(0xFF176B87);
				amenities_bathroom.setBackgroundColor(0xFFFFFFFF);
				amenities_gated.setBackgroundColor(0xFFFFFFFF);
				amenities_security.setBackgroundColor(0xFFFFFFFF);
				amenities_visiting.setBackgroundColor(0xFFFFFFFF);
				amenities_balcony.setBackgroundColor(0xFFFFFFFF);
				amenities_laundry.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		amenities_bathroom.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				amenities_any.setTextColor(0xFF176B87);
				amenities_parking_lot.setTextColor(0xFF176B87);
				amenities_canteen.setTextColor(0xFF176B87);
				amenities_bathroom.setTextColor(0xFFFFFFFF);
				amenities_gated.setTextColor(0xFF176B87);
				amenities_security.setTextColor(0xFF176B87);
				amenities_visiting.setTextColor(0xFF176B87);
				amenities_balcony.setTextColor(0xFF176B87);
				amenities_laundry.setTextColor(0xFF176B87);
				data.edit().putString("amenities", amenities_bathroom.getText().toString()).commit();
				amenities_any.setBackgroundColor(0xFFFFFFFF);
				amenities_parking_lot.setBackgroundColor(0xFFFFFFFF);
				amenities_canteen.setBackgroundColor(0xFFFFFFFF);
				amenities_bathroom.setBackgroundColor(0xFF176B87);
				amenities_gated.setBackgroundColor(0xFFFFFFFF);
				amenities_security.setBackgroundColor(0xFFFFFFFF);
				amenities_visiting.setBackgroundColor(0xFFFFFFFF);
				amenities_balcony.setBackgroundColor(0xFFFFFFFF);
				amenities_laundry.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		amenities_laundry.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				amenities_any.setTextColor(0xFF176B87);
				amenities_parking_lot.setTextColor(0xFF176B87);
				amenities_canteen.setTextColor(0xFF176B87);
				amenities_bathroom.setTextColor(0xFF176B87);
				amenities_gated.setTextColor(0xFF176B87);
				amenities_security.setTextColor(0xFF176B87);
				amenities_visiting.setTextColor(0xFF176B87);
				amenities_balcony.setTextColor(0xFF176B87);
				amenities_laundry.setTextColor(0xFFFFFFFF);
				data.edit().putString("amenities", amenities_laundry.getText().toString()).commit();
				amenities_any.setBackgroundColor(0xFFFFFFFF);
				amenities_parking_lot.setBackgroundColor(0xFFFFFFFF);
				amenities_canteen.setBackgroundColor(0xFFFFFFFF);
				amenities_bathroom.setBackgroundColor(0xFFFFFFFF);
				amenities_gated.setBackgroundColor(0xFFFFFFFF);
				amenities_security.setBackgroundColor(0xFFFFFFFF);
				amenities_visiting.setBackgroundColor(0xFFFFFFFF);
				amenities_balcony.setBackgroundColor(0xFFFFFFFF);
				amenities_laundry.setBackgroundColor(0xFF176B87);
			}
		});
		
		amenities_security.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				amenities_any.setTextColor(0xFF176B87);
				amenities_parking_lot.setTextColor(0xFF176B87);
				amenities_canteen.setTextColor(0xFF176B87);
				amenities_bathroom.setTextColor(0xFF176B87);
				amenities_gated.setTextColor(0xFF176B87);
				amenities_security.setTextColor(0xFFFFFFFF);
				amenities_visiting.setTextColor(0xFF176B87);
				amenities_balcony.setTextColor(0xFF176B87);
				amenities_laundry.setTextColor(0xFF176B87);
				data.edit().putString("amenities", amenities_security.getText().toString()).commit();
				amenities_any.setBackgroundColor(0xFFFFFFFF);
				amenities_parking_lot.setBackgroundColor(0xFFFFFFFF);
				amenities_canteen.setBackgroundColor(0xFFFFFFFF);
				amenities_bathroom.setBackgroundColor(0xFFFFFFFF);
				amenities_gated.setBackgroundColor(0xFFFFFFFF);
				amenities_security.setBackgroundColor(0xFF176B87);
				amenities_visiting.setBackgroundColor(0xFFFFFFFF);
				amenities_balcony.setBackgroundColor(0xFFFFFFFF);
				amenities_laundry.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		amenities_visiting.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				amenities_any.setTextColor(0xFF176B87);
				amenities_parking_lot.setTextColor(0xFF176B87);
				amenities_canteen.setTextColor(0xFF176B87);
				amenities_bathroom.setTextColor(0xFF176B87);
				amenities_gated.setTextColor(0xFF176B87);
				amenities_security.setTextColor(0xFF176B87);
				amenities_visiting.setTextColor(0xFFFFFFFF);
				amenities_balcony.setTextColor(0xFF176B87);
				amenities_laundry.setTextColor(0xFF176B87);
				data.edit().putString("amenities", amenities_visiting.getText().toString()).commit();
				amenities_any.setBackgroundColor(0xFFFFFFFF);
				amenities_parking_lot.setBackgroundColor(0xFFFFFFFF);
				amenities_canteen.setBackgroundColor(0xFFFFFFFF);
				amenities_bathroom.setBackgroundColor(0xFFFFFFFF);
				amenities_gated.setBackgroundColor(0xFFFFFFFF);
				amenities_security.setBackgroundColor(0xFFFFFFFF);
				amenities_visiting.setBackgroundColor(0xFF176B87);
				amenities_balcony.setBackgroundColor(0xFFFFFFFF);
				amenities_laundry.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		amenities_balcony.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				amenities_any.setTextColor(0xFF176B87);
				amenities_parking_lot.setTextColor(0xFF176B87);
				amenities_canteen.setTextColor(0xFF176B87);
				amenities_bathroom.setTextColor(0xFF176B87);
				amenities_gated.setTextColor(0xFF176B87);
				amenities_security.setTextColor(0xFF176B87);
				amenities_visiting.setTextColor(0xFF176B87);
				amenities_balcony.setTextColor(0xFFFFFFFF);
				amenities_laundry.setTextColor(0xFF176B87);
				data.edit().putString("amenities", amenities_balcony.getText().toString()).commit();
				amenities_any.setBackgroundColor(0xFFFFFFFF);
				amenities_parking_lot.setBackgroundColor(0xFFFFFFFF);
				amenities_canteen.setBackgroundColor(0xFFFFFFFF);
				amenities_bathroom.setBackgroundColor(0xFFFFFFFF);
				amenities_gated.setBackgroundColor(0xFFFFFFFF);
				amenities_security.setBackgroundColor(0xFFFFFFFF);
				amenities_visiting.setBackgroundColor(0xFFFFFFFF);
				amenities_balcony.setBackgroundColor(0xFF176B87);
				amenities_laundry.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		amenities_gated.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				amenities_any.setTextColor(0xFF176B87);
				amenities_parking_lot.setTextColor(0xFF176B87);
				amenities_canteen.setTextColor(0xFF176B87);
				amenities_bathroom.setTextColor(0xFF176B87);
				amenities_gated.setTextColor(0xFFFFFFFF);
				amenities_security.setTextColor(0xFF176B87);
				amenities_visiting.setTextColor(0xFF176B87);
				amenities_balcony.setTextColor(0xFF176B87);
				amenities_laundry.setTextColor(0xFF176B87);
				data.edit().putString("amenities", amenities_gated.getText().toString()).commit();
				amenities_any.setBackgroundColor(0xFFFFFFFF);
				amenities_parking_lot.setBackgroundColor(0xFFFFFFFF);
				amenities_canteen.setBackgroundColor(0xFFFFFFFF);
				amenities_bathroom.setBackgroundColor(0xFFFFFFFF);
				amenities_gated.setBackgroundColor(0xFF176B87);
				amenities_security.setBackgroundColor(0xFFFFFFFF);
				amenities_visiting.setBackgroundColor(0xFFFFFFFF);
				amenities_balcony.setBackgroundColor(0xFFFFFFFF);
				amenities_laundry.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		inclusion_any.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inclusion_any.setTextColor(0xFFFFFFFF);
				inclusion_refrigerator.setTextColor(0xFF176B87);
				inclusion_rice_cooker.setTextColor(0xFF176B87);
				inclusion_washing_machine.setTextColor(0xFF176B87);
				inclusion_electric_fan.setTextColor(0xFF176B87);
				inclusion_electric_stove.setTextColor(0xFF176B87);
				inclusion_cabinet.setTextColor(0xFF176B87);
				inclusion_charging_port.setTextColor(0xFF176B87);
				inclusion_ablution.setTextColor(0xFF176B87);
				inclusion_allow_pets.setTextColor(0xFF176B87);
				inclusion_allow_smoking.setTextColor(0xFF176B87);
				data.edit().putString("inclusion", inclusion_any.getText().toString()).commit();
				inclusion_any.setBackgroundColor(0xFF176B87);
				inclusion_refrigerator.setBackgroundColor(0xFFFFFFFF);
				inclusion_rice_cooker.setBackgroundColor(0xFFFFFFFF);
				inclusion_washing_machine.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_fan.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_stove.setBackgroundColor(0xFFFFFFFF);
				inclusion_cabinet.setBackgroundColor(0xFFFFFFFF);
				inclusion_charging_port.setBackgroundColor(0xFFFFFFFF);
				inclusion_ablution.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_pets.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_smoking.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		inclusion_refrigerator.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inclusion_any.setTextColor(0xFF176B87);
				inclusion_refrigerator.setTextColor(0xFFFFFFFF);
				inclusion_rice_cooker.setTextColor(0xFF176B87);
				inclusion_washing_machine.setTextColor(0xFF176B87);
				inclusion_electric_fan.setTextColor(0xFF176B87);
				inclusion_electric_stove.setTextColor(0xFF176B87);
				inclusion_cabinet.setTextColor(0xFF176B87);
				inclusion_charging_port.setTextColor(0xFF176B87);
				inclusion_ablution.setTextColor(0xFF176B87);
				inclusion_allow_pets.setTextColor(0xFF176B87);
				inclusion_allow_smoking.setTextColor(0xFF176B87);
				data.edit().putString("inclusion", inclusion_refrigerator.getText().toString()).commit();
				inclusion_any.setBackgroundColor(0xFFFFFFFF);
				inclusion_refrigerator.setBackgroundColor(0xFF176B87);
				inclusion_rice_cooker.setBackgroundColor(0xFFFFFFFF);
				inclusion_washing_machine.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_fan.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_stove.setBackgroundColor(0xFFFFFFFF);
				inclusion_cabinet.setBackgroundColor(0xFFFFFFFF);
				inclusion_charging_port.setBackgroundColor(0xFFFFFFFF);
				inclusion_ablution.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_pets.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_smoking.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		inclusion_rice_cooker.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inclusion_any.setTextColor(0xFF176B87);
				inclusion_refrigerator.setTextColor(0xFF176B87);
				inclusion_rice_cooker.setTextColor(0xFFFFFFFF);
				inclusion_washing_machine.setTextColor(0xFF176B87);
				inclusion_electric_fan.setTextColor(0xFF176B87);
				inclusion_electric_stove.setTextColor(0xFF176B87);
				inclusion_cabinet.setTextColor(0xFF176B87);
				inclusion_charging_port.setTextColor(0xFF176B87);
				inclusion_ablution.setTextColor(0xFF176B87);
				inclusion_allow_pets.setTextColor(0xFF176B87);
				inclusion_allow_smoking.setTextColor(0xFF176B87);
				data.edit().putString("inclusion", inclusion_rice_cooker.getText().toString()).commit();
				inclusion_any.setBackgroundColor(0xFFFFFFFF);
				inclusion_refrigerator.setBackgroundColor(0xFFFFFFFF);
				inclusion_rice_cooker.setBackgroundColor(0xFF176B87);
				inclusion_washing_machine.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_fan.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_stove.setBackgroundColor(0xFFFFFFFF);
				inclusion_cabinet.setBackgroundColor(0xFFFFFFFF);
				inclusion_charging_port.setBackgroundColor(0xFFFFFFFF);
				inclusion_ablution.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_pets.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_smoking.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		inclusion_washing_machine.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inclusion_any.setTextColor(0xFF176B87);
				inclusion_refrigerator.setTextColor(0xFF176B87);
				inclusion_rice_cooker.setTextColor(0xFF176B87);
				inclusion_washing_machine.setTextColor(0xFFFFFFFF);
				inclusion_electric_fan.setTextColor(0xFF176B87);
				inclusion_electric_stove.setTextColor(0xFF176B87);
				inclusion_cabinet.setTextColor(0xFF176B87);
				inclusion_charging_port.setTextColor(0xFF176B87);
				inclusion_ablution.setTextColor(0xFF176B87);
				inclusion_allow_pets.setTextColor(0xFF176B87);
				inclusion_allow_smoking.setTextColor(0xFF176B87);
				data.edit().putString("inclusion", inclusion_washing_machine.getText().toString()).commit();
				inclusion_any.setBackgroundColor(0xFFFFFFFF);
				inclusion_refrigerator.setBackgroundColor(0xFFFFFFFF);
				inclusion_rice_cooker.setBackgroundColor(0xFFFFFFFF);
				inclusion_washing_machine.setBackgroundColor(0xFF176B87);
				inclusion_electric_fan.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_stove.setBackgroundColor(0xFFFFFFFF);
				inclusion_cabinet.setBackgroundColor(0xFFFFFFFF);
				inclusion_charging_port.setBackgroundColor(0xFFFFFFFF);
				inclusion_ablution.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_pets.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_smoking.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		inclusion_electric_fan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inclusion_any.setTextColor(0xFF176B87);
				inclusion_refrigerator.setTextColor(0xFF176B87);
				inclusion_rice_cooker.setTextColor(0xFF176B87);
				inclusion_washing_machine.setTextColor(0xFF176B87);
				inclusion_electric_fan.setTextColor(0xFFFFFFFF);
				inclusion_electric_stove.setTextColor(0xFF176B87);
				inclusion_cabinet.setTextColor(0xFF176B87);
				inclusion_charging_port.setTextColor(0xFF176B87);
				inclusion_ablution.setTextColor(0xFF176B87);
				inclusion_allow_pets.setTextColor(0xFF176B87);
				inclusion_allow_smoking.setTextColor(0xFF176B87);
				data.edit().putString("inclusion", inclusion_electric_fan.getText().toString()).commit();
				inclusion_any.setBackgroundColor(0xFFFFFFFF);
				inclusion_refrigerator.setBackgroundColor(0xFFFFFFFF);
				inclusion_rice_cooker.setBackgroundColor(0xFFFFFFFF);
				inclusion_washing_machine.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_fan.setBackgroundColor(0xFF176B87);
				inclusion_electric_stove.setBackgroundColor(0xFFFFFFFF);
				inclusion_cabinet.setBackgroundColor(0xFFFFFFFF);
				inclusion_charging_port.setBackgroundColor(0xFFFFFFFF);
				inclusion_ablution.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_pets.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_smoking.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		inclusion_electric_stove.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inclusion_any.setTextColor(0xFF176B87);
				inclusion_refrigerator.setTextColor(0xFF176B87);
				inclusion_rice_cooker.setTextColor(0xFF176B87);
				inclusion_washing_machine.setTextColor(0xFF176B87);
				inclusion_electric_fan.setTextColor(0xFF176B87);
				inclusion_electric_stove.setTextColor(0xFFFFFFFF);
				inclusion_cabinet.setTextColor(0xFF176B87);
				inclusion_charging_port.setTextColor(0xFF176B87);
				inclusion_ablution.setTextColor(0xFF176B87);
				inclusion_allow_pets.setTextColor(0xFF176B87);
				inclusion_allow_smoking.setTextColor(0xFF176B87);
				data.edit().putString("inclusion", inclusion_electric_stove.getText().toString()).commit();
				inclusion_any.setBackgroundColor(0xFFFFFFFF);
				inclusion_refrigerator.setBackgroundColor(0xFFFFFFFF);
				inclusion_rice_cooker.setBackgroundColor(0xFFFFFFFF);
				inclusion_washing_machine.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_fan.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_stove.setBackgroundColor(0xFF176B87);
				inclusion_cabinet.setBackgroundColor(0xFFFFFFFF);
				inclusion_charging_port.setBackgroundColor(0xFFFFFFFF);
				inclusion_ablution.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_pets.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_smoking.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		inclusion_cabinet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inclusion_any.setTextColor(0xFF176B87);
				inclusion_refrigerator.setTextColor(0xFF176B87);
				inclusion_rice_cooker.setTextColor(0xFF176B87);
				inclusion_washing_machine.setTextColor(0xFF176B87);
				inclusion_electric_fan.setTextColor(0xFF176B87);
				inclusion_electric_stove.setTextColor(0xFF176B87);
				inclusion_cabinet.setTextColor(0xFFFFFFFF);
				inclusion_charging_port.setTextColor(0xFF176B87);
				inclusion_ablution.setTextColor(0xFF176B87);
				inclusion_allow_pets.setTextColor(0xFF176B87);
				inclusion_allow_smoking.setTextColor(0xFF176B87);
				data.edit().putString("inclusion", inclusion_cabinet.getText().toString()).commit();
				inclusion_any.setBackgroundColor(0xFFFFFFFF);
				inclusion_refrigerator.setBackgroundColor(0xFFFFFFFF);
				inclusion_rice_cooker.setBackgroundColor(0xFFFFFFFF);
				inclusion_washing_machine.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_fan.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_stove.setBackgroundColor(0xFFFFFFFF);
				inclusion_cabinet.setBackgroundColor(0xFF176B87);
				inclusion_charging_port.setBackgroundColor(0xFFFFFFFF);
				inclusion_ablution.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_pets.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_smoking.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		inclusion_charging_port.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inclusion_any.setTextColor(0xFF176B87);
				inclusion_refrigerator.setTextColor(0xFF176B87);
				inclusion_rice_cooker.setTextColor(0xFF176B87);
				inclusion_washing_machine.setTextColor(0xFF176B87);
				inclusion_electric_fan.setTextColor(0xFF176B87);
				inclusion_electric_stove.setTextColor(0xFF176B87);
				inclusion_cabinet.setTextColor(0xFF176B87);
				inclusion_charging_port.setTextColor(0xFFFFFFFF);
				inclusion_ablution.setTextColor(0xFF176B87);
				inclusion_allow_pets.setTextColor(0xFF176B87);
				inclusion_allow_smoking.setTextColor(0xFF176B87);
				data.edit().putString("inclusion", inclusion_charging_port.getText().toString()).commit();
				inclusion_any.setBackgroundColor(0xFFFFFFFF);
				inclusion_refrigerator.setBackgroundColor(0xFFFFFFFF);
				inclusion_rice_cooker.setBackgroundColor(0xFFFFFFFF);
				inclusion_washing_machine.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_fan.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_stove.setBackgroundColor(0xFFFFFFFF);
				inclusion_cabinet.setBackgroundColor(0xFFFFFFFF);
				inclusion_charging_port.setBackgroundColor(0xFF176B87);
				inclusion_ablution.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_pets.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_smoking.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		inclusion_ablution.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inclusion_any.setTextColor(0xFF176B87);
				inclusion_refrigerator.setTextColor(0xFF176B87);
				inclusion_rice_cooker.setTextColor(0xFF176B87);
				inclusion_washing_machine.setTextColor(0xFF176B87);
				inclusion_electric_fan.setTextColor(0xFF176B87);
				inclusion_electric_stove.setTextColor(0xFF176B87);
				inclusion_cabinet.setTextColor(0xFF176B87);
				inclusion_charging_port.setTextColor(0xFF176B87);
				inclusion_ablution.setTextColor(0xFFFFFFFF);
				inclusion_allow_pets.setTextColor(0xFF176B87);
				inclusion_allow_smoking.setTextColor(0xFF176B87);
				data.edit().putString("inclusion", inclusion_ablution.getText().toString()).commit();
				inclusion_any.setBackgroundColor(0xFFFFFFFF);
				inclusion_refrigerator.setBackgroundColor(0xFFFFFFFF);
				inclusion_rice_cooker.setBackgroundColor(0xFFFFFFFF);
				inclusion_washing_machine.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_fan.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_stove.setBackgroundColor(0xFFFFFFFF);
				inclusion_cabinet.setBackgroundColor(0xFFFFFFFF);
				inclusion_charging_port.setBackgroundColor(0xFFFFFFFF);
				inclusion_ablution.setBackgroundColor(0xFF176B87);
				inclusion_allow_pets.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_smoking.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		inclusion_allow_pets.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inclusion_any.setTextColor(0xFF176B87);
				inclusion_refrigerator.setTextColor(0xFF176B87);
				inclusion_rice_cooker.setTextColor(0xFF176B87);
				inclusion_washing_machine.setTextColor(0xFF176B87);
				inclusion_electric_fan.setTextColor(0xFF176B87);
				inclusion_electric_stove.setTextColor(0xFF176B87);
				inclusion_cabinet.setTextColor(0xFF176B87);
				inclusion_charging_port.setTextColor(0xFF176B87);
				inclusion_ablution.setTextColor(0xFF176B87);
				inclusion_allow_pets.setTextColor(0xFFFFFFFF);
				inclusion_allow_smoking.setTextColor(0xFF176B87);
				data.edit().putString("inclusion", inclusion_allow_pets.getText().toString()).commit();
				inclusion_any.setBackgroundColor(0xFFFFFFFF);
				inclusion_refrigerator.setBackgroundColor(0xFFFFFFFF);
				inclusion_rice_cooker.setBackgroundColor(0xFFFFFFFF);
				inclusion_washing_machine.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_fan.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_stove.setBackgroundColor(0xFFFFFFFF);
				inclusion_cabinet.setBackgroundColor(0xFFFFFFFF);
				inclusion_charging_port.setBackgroundColor(0xFFFFFFFF);
				inclusion_ablution.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_pets.setBackgroundColor(0xFF176B87);
				inclusion_allow_smoking.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		inclusion_allow_smoking.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inclusion_any.setTextColor(0xFF176B87);
				inclusion_refrigerator.setTextColor(0xFF176B87);
				inclusion_rice_cooker.setTextColor(0xFF176B87);
				inclusion_washing_machine.setTextColor(0xFF176B87);
				inclusion_electric_fan.setTextColor(0xFF176B87);
				inclusion_electric_stove.setTextColor(0xFF176B87);
				inclusion_cabinet.setTextColor(0xFF176B87);
				inclusion_charging_port.setTextColor(0xFF176B87);
				inclusion_ablution.setTextColor(0xFF176B87);
				inclusion_allow_pets.setTextColor(0xFF176B87);
				inclusion_allow_smoking.setTextColor(0xFFFFFFFF);
				data.edit().putString("inclusion", inclusion_allow_smoking.getText().toString()).commit();
				inclusion_any.setBackgroundColor(0xFFFFFFFF);
				inclusion_refrigerator.setBackgroundColor(0xFFFFFFFF);
				inclusion_rice_cooker.setBackgroundColor(0xFFFFFFFF);
				inclusion_washing_machine.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_fan.setBackgroundColor(0xFFFFFFFF);
				inclusion_electric_stove.setBackgroundColor(0xFFFFFFFF);
				inclusion_cabinet.setBackgroundColor(0xFFFFFFFF);
				inclusion_charging_port.setBackgroundColor(0xFFFFFFFF);
				inclusion_ablution.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_pets.setBackgroundColor(0xFFFFFFFF);
				inclusion_allow_smoking.setBackgroundColor(0xFF176B87);
			}
		});
		
		rating_all.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				rating_all.setTextColor(0xFFFFFFFF);
				rating5.setTextColor(0xFF176B87);
				rating4.setTextColor(0xFF176B87);
				rating3.setTextColor(0xFF176B87);
				rating2.setTextColor(0xFF176B87);
				rating1.setTextColor(0xFF176B87);
				data.edit().putString("rating", "All").commit();
				rating_all.setBackgroundColor(0xFF176B87);
				rating5.setBackgroundColor(0xFFFFFFFF);
				rating4.setBackgroundColor(0xFFFFFFFF);
				rating3.setBackgroundColor(0xFFFFFFFF);
				rating2.setBackgroundColor(0xFFFFFFFF);
				rating1.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		rating5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				rating_all.setTextColor(0xFF176B87);
				rating5.setTextColor(0xFFFFFFFF);
				rating4.setTextColor(0xFF176B87);
				rating3.setTextColor(0xFF176B87);
				rating2.setTextColor(0xFF176B87);
				rating1.setTextColor(0xFF176B87);
				data.edit().putString("rating", "5").commit();
				rating_all.setBackgroundColor(0xFFFFFFFF);
				rating5.setBackgroundColor(0xFF176B87);
				rating4.setBackgroundColor(0xFFFFFFFF);
				rating3.setBackgroundColor(0xFFFFFFFF);
				rating2.setBackgroundColor(0xFFFFFFFF);
				rating1.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		rating4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				rating_all.setTextColor(0xFF176B87);
				rating5.setTextColor(0xFF176B87);
				rating4.setTextColor(0xFFFFFFFF);
				rating3.setTextColor(0xFF176B87);
				rating2.setTextColor(0xFF176B87);
				rating1.setTextColor(0xFF176B87);
				data.edit().putString("rating", "4").commit();
				rating_all.setBackgroundColor(0xFFFFFFFF);
				rating5.setBackgroundColor(0xFFFFFFFF);
				rating4.setBackgroundColor(0xFF176B87);
				rating3.setBackgroundColor(0xFFFFFFFF);
				rating2.setBackgroundColor(0xFFFFFFFF);
				rating1.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		rating3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				rating_all.setTextColor(0xFF176B87);
				rating5.setTextColor(0xFF176B87);
				rating4.setTextColor(0xFF176B87);
				rating3.setTextColor(0xFFFFFFFF);
				rating2.setTextColor(0xFF176B87);
				rating1.setTextColor(0xFF176B87);
				data.edit().putString("rating", "3").commit();
				rating_all.setBackgroundColor(0xFFFFFFFF);
				rating5.setBackgroundColor(0xFFFFFFFF);
				rating4.setBackgroundColor(0xFFFFFFFF);
				rating3.setBackgroundColor(0xFF176B87);
				rating2.setBackgroundColor(0xFFFFFFFF);
				rating1.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		rating2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				rating_all.setTextColor(0xFF176B87);
				rating5.setTextColor(0xFF176B87);
				rating4.setTextColor(0xFF176B87);
				rating3.setTextColor(0xFF176B87);
				rating2.setTextColor(0xFFFFFFFF);
				rating1.setTextColor(0xFF176B87);
				data.edit().putString("rating", "2").commit();
				rating_all.setBackgroundColor(0xFFFFFFFF);
				rating5.setBackgroundColor(0xFFFFFFFF);
				rating4.setBackgroundColor(0xFFFFFFFF);
				rating3.setBackgroundColor(0xFFFFFFFF);
				rating2.setBackgroundColor(0xFF176B87);
				rating1.setBackgroundColor(0xFFFFFFFF);
			}
		});
		
		rating1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				rating_all.setTextColor(0xFF176B87);
				rating5.setTextColor(0xFF176B87);
				rating4.setTextColor(0xFF176B87);
				rating3.setTextColor(0xFF176B87);
				rating2.setTextColor(0xFF176B87);
				rating1.setTextColor(0xFFFFFFFF);
				data.edit().putString("rating", "1").commit();
				rating_all.setBackgroundColor(0xFFFFFFFF);
				rating5.setBackgroundColor(0xFFFFFFFF);
				rating4.setBackgroundColor(0xFFFFFFFF);
				rating3.setBackgroundColor(0xFFFFFFFF);
				rating2.setBackgroundColor(0xFFFFFFFF);
				rating1.setBackgroundColor(0xFF176B87);
			}
		});
		
		reset_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				timer = new TimerTask() {
					@Override
					public void run() {
						getActivity().runOnUiThread(new Runnable() {
							@Override
							public void run() {
								data.edit().remove("category").commit();
								data.edit().remove("price range").commit();
								data.edit().remove("amenities").commit();
								data.edit().remove("inclusion").commit();
								data.edit().remove("rating").commit();
								data.edit().remove("filter").commit();
								SketchwareUtil.showMessage(getContext().getApplicationContext(), "Reset");
								_datashared();
							}
						});
					}
				};
				_timer.schedule(timer, (int)(1000));
			}
		});
		
		apply_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				timer = new TimerTask() {
					@Override
					public void run() {
						getActivity().runOnUiThread(new Runnable() {
							@Override
							public void run() {
								data.edit().putString("filter", data.getString("category", "").concat(", ".concat(data.getString("price range", "").concat(", ".concat(data.getString("amenities", "").concat(", ".concat(data.getString("inclusion", "").concat(", ".concat(data.getString("rating", "")))))))))).commit();
								SketchwareUtil.showMessage(getContext().getApplicationContext(), "Saved");
							}
						});
					}
				};
				_timer.schedule(timer, (int)(1000));
			}
		});
	}
	
	private void initializeLogic() {
		_rippleRoundStroke(reset_btn, "#ffffff", "#f5f5f5", 100, 100, "#ffffff");
		_rippleRoundStroke(apply_btn, "#176b87", "#f5f5f5", 100, 100, "#176b87");
		_removeScollBar(vscroll1);
		_removeScollBar(hscroll1);
		_removeScollBar(hscroll2);
		_removeScollBar(hscroll3);
		_removeScollBar(hscroll4);
		_datashared();
	}
	
	public void _simpleRiffle(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#9E9E9E")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
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
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _datashared() {
		_category();
		_price_range();
		_amenities();
		_inclusion();
		_rating();
	}
	
	
	public void _setSingleLine(final TextView _view, final boolean _bool) {
		_view.setSingleLine(_bool);
	}
	
	
	public void _ImageColor(final ImageView _image, final String _color) {
		_image.setColorFilter(Color.parseColor(_color),PorterDuff.Mode.SRC_ATOP);
	}
	
	
	public void _category() {
		if (data.getString("category", "").equals("")) {
			select_all.setTextColor(0xFF176B87);
			select_female.setTextColor(0xFF176B87);
			select_transient.setTextColor(0xFF176B87);
			select_co_ed.setTextColor(0xFF176B87);
			select_gender.setTextColor(0xFF176B87);
			select_all.setBackgroundColor(0xFFFFFFFF);
			select_female.setBackgroundColor(0xFFFFFFFF);
			select_transient.setBackgroundColor(0xFFFFFFFF);
			select_co_ed.setBackgroundColor(0xFFFFFFFF);
			select_gender.setBackgroundColor(0xFFFFFFFF);
		}
		else {
			if (data.getString("category", "").equals("✅ All")) {
				select_all.setTextColor(0xFFFFFFFF);
				select_all.setBackgroundColor(0xFF176B87);
			}
			else {
				if (data.getString("category", "").equals("🏡 Female Dormitory")) {
					select_female.setTextColor(0xFFFFFFFF);
					select_female.setBackgroundColor(0xFF176B87);
				}
				else {
					if (data.getString("category", "").equals("🏡 Male Dormitory")) {
						select_transient.setTextColor(0xFFFFFFFF);
						select_transient.setBackgroundColor(0xFF176B87);
					}
					else {
						if (data.getString("category", "").equals("🏡 Co-ed")) {
							select_co_ed.setTextColor(0xFFFFFFFF);
							select_co_ed.setBackgroundColor(0xFF176B87);
						}
						else {
							if (data.getString("category", "").equals("🏡 Gender-neutral")) {
								select_gender.setTextColor(0xFFFFFFFF);
								select_gender.setBackgroundColor(0xFF176B87);
							}
						}
					}
				}
			}
		}
	}
	
	
	public void _price_range() {
		seekbar1.setValueFrom((float) 1000);
		seekbar1.setValueTo((float) 10000);
		seekbar1.setStepSize((float) 100);
		seekbar1.addOnChangeListener(new RangeSlider.OnChangeListener() {
			@Override
			public void onValueChange(RangeSlider slider, float value, boolean fromUser) {
				final List <Float> seekbar1List = slider.getValues();
				data.edit().putString("minimum price range", seekbar1List.get(0).toString()).commit();
				data.edit().putString("maximum price range", seekbar1List.get(1).toString()).commit();
				data.edit().putString("price range", String.valueOf((long)(Double.parseDouble(seekbar1List.get(0).toString()))).concat(" - ".concat(String.valueOf((long)(Double.parseDouble(seekbar1List.get(1).toString())))))).commit();
			}
		});
	}
	
	
	public void _amenities() {
		if (data.getString("amenities", "").equals("")) {
			amenities_any.setTextColor(0xFF176B87);
			amenities_parking_lot.setTextColor(0xFF176B87);
			amenities_canteen.setTextColor(0xFF176B87);
			amenities_bathroom.setTextColor(0xFF176B87);
			amenities_gated.setTextColor(0xFF176B87);
			amenities_security.setTextColor(0xFF176B87);
			amenities_visiting.setTextColor(0xFF176B87);
			amenities_balcony.setTextColor(0xFF176B87);
			amenities_laundry.setTextColor(0xFF176B87);
			amenities_any.setBackgroundColor(0xFFFFFFFF);
			amenities_parking_lot.setBackgroundColor(0xFFFFFFFF);
			amenities_canteen.setBackgroundColor(0xFFFFFFFF);
			amenities_bathroom.setBackgroundColor(0xFFFFFFFF);
			amenities_gated.setBackgroundColor(0xFFFFFFFF);
			amenities_security.setBackgroundColor(0xFFFFFFFF);
			amenities_visiting.setBackgroundColor(0xFFFFFFFF);
			amenities_balcony.setBackgroundColor(0xFFFFFFFF);
			amenities_laundry.setBackgroundColor(0xFFFFFFFF);
		}
		else {
			if (data.getString("amenities", "").equals("Any")) {
				amenities_any.setTextColor(0xFFFFFFFF);
				amenities_any.setBackgroundColor(0xFF176B87);
			}
			else {
				if (data.getString("amenities", "").equals("Parking Lot")) {
					amenities_parking_lot.setTextColor(0xFFFFFFFF);
					amenities_parking_lot.setBackgroundColor(0xFF176B87);
				}
				else {
					if (data.getString("amenities", "").equals("Canteen")) {
						amenities_canteen.setTextColor(0xFFFFFFFF);
						amenities_canteen.setBackgroundColor(0xFF176B87);
					}
					else {
						if (data.getString("amenities", "").equals("Common Bathroom")) {
							amenities_bathroom.setTextColor(0xFFFFFFFF);
							amenities_bathroom.setBackgroundColor(0xFF176B87);
						}
						else {
							if (data.getString("amenities", "").equals("Common Kitchen Laundry")) {
								amenities_laundry.setTextColor(0xFFFFFFFF);
								amenities_laundry.setBackgroundColor(0xFF176B87);
							}
							else {
								if (data.getString("amenities", "").equals("Security System")) {
									amenities_security.setTextColor(0xFFFFFFFF);
									amenities_security.setBackgroundColor(0xFF176B87);
								}
								else {
									if (data.getString("amenities", "").equals("Visiting Area")) {
										amenities_visiting.setTextColor(0xFFFFFFFF);
										amenities_visiting.setBackgroundColor(0xFF176B87);
									}
									else {
										if (data.getString("amenities", "").equals("Balcony")) {
											amenities_balcony.setTextColor(0xFFFFFFFF);
											amenities_balcony.setBackgroundColor(0xFF176B87);
										}
										else {
											if (data.getString("amenities", "").equals("Gated Entry")) {
												amenities_gated.setTextColor(0xFFFFFFFF);
												amenities_gated.setBackgroundColor(0xFF176B87);
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
	}
	
	
	public void _inclusion() {
		if (data.getString("inclusion", "").equals("")) {
			inclusion_any.setTextColor(0xFF176B87);
			inclusion_refrigerator.setTextColor(0xFF176B87);
			inclusion_rice_cooker.setTextColor(0xFF176B87);
			inclusion_washing_machine.setTextColor(0xFF176B87);
			inclusion_electric_fan.setTextColor(0xFF176B87);
			inclusion_electric_stove.setTextColor(0xFF176B87);
			inclusion_cabinet.setTextColor(0xFF176B87);
			inclusion_charging_port.setTextColor(0xFF176B87);
			inclusion_ablution.setTextColor(0xFF176B87);
			inclusion_allow_pets.setTextColor(0xFF176B87);
			inclusion_allow_smoking.setTextColor(0xFF176B87);
			inclusion_any.setBackgroundColor(0xFFFFFFFF);
			inclusion_refrigerator.setBackgroundColor(0xFFFFFFFF);
			inclusion_rice_cooker.setBackgroundColor(0xFFFFFFFF);
			inclusion_washing_machine.setBackgroundColor(0xFFFFFFFF);
			inclusion_electric_fan.setBackgroundColor(0xFFFFFFFF);
			inclusion_electric_stove.setBackgroundColor(0xFFFFFFFF);
			inclusion_cabinet.setBackgroundColor(0xFFFFFFFF);
			inclusion_charging_port.setBackgroundColor(0xFFFFFFFF);
			inclusion_ablution.setBackgroundColor(0xFFFFFFFF);
			inclusion_allow_pets.setBackgroundColor(0xFFFFFFFF);
			inclusion_allow_smoking.setBackgroundColor(0xFFFFFFFF);
		}
		else {
			if (data.getString("inclusion", "").equals("Any")) {
				inclusion_any.setTextColor(0xFFFFFFFF);
				inclusion_any.setBackgroundColor(0xFF176B87);
			}
			else {
				if (data.getString("inclusion", "").equals("Refrigerator")) {
					inclusion_refrigerator.setTextColor(0xFFFFFFFF);
					inclusion_refrigerator.setBackgroundColor(0xFF176B87);
				}
				else {
					if (data.getString("inclusion", "").equals("Rice Cooker")) {
						inclusion_rice_cooker.setTextColor(0xFFFFFFFF);
						inclusion_rice_cooker.setBackgroundColor(0xFF176B87);
					}
					else {
						if (data.getString("inclusion", "").equals("Washing Machine")) {
							inclusion_washing_machine.setTextColor(0xFFFFFFFF);
							inclusion_washing_machine.setBackgroundColor(0xFF176B87);
						}
						else {
							if (data.getString("inclusion", "").equals("Electric Fan")) {
								inclusion_electric_fan.setTextColor(0xFFFFFFFF);
								inclusion_electric_fan.setBackgroundColor(0xFF176B87);
							}
							else {
								if (data.getString("inclusion", "").equals("Electric Stove")) {
									inclusion_electric_stove.setTextColor(0xFFFFFFFF);
									inclusion_electric_stove.setBackgroundColor(0xFF176B87);
								}
								else {
									if (data.getString("inclusion", "").equals("Cabinet")) {
										inclusion_cabinet.setTextColor(0xFFFFFFFF);
										inclusion_cabinet.setBackgroundColor(0xFF176B87);
									}
									else {
										if (data.getString("inclusion", "").equals("Charging Port")) {
											inclusion_charging_port.setTextColor(0xFFFFFFFF);
											inclusion_charging_port.setBackgroundColor(0xFF176B87);
										}
										else {
											if (data.getString("inclusion", "").equals("Ablution Space/Area")) {
												inclusion_ablution.setTextColor(0xFFFFFFFF);
												inclusion_ablution.setBackgroundColor(0xFF176B87);
											}
											else {
												if (data.getString("inclusion", "").equals("Allow Pets")) {
													inclusion_allow_pets.setTextColor(0xFFFFFFFF);
													inclusion_allow_pets.setBackgroundColor(0xFF176B87);
												}
												else {
													if (data.getString("inclusion", "").equals("Allow Smoking")) {
														inclusion_allow_smoking.setTextColor(0xFFFFFFFF);
														inclusion_allow_smoking.setBackgroundColor(0xFF176B87);
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
			}
		}
	}
	
	
	public void _rating() {
		if (data.getString("rating", "").equals("")) {
			rating_all.setTextColor(0xFF176B87);
			rating5.setTextColor(0xFF176B87);
			rating4.setTextColor(0xFF176B87);
			rating3.setTextColor(0xFF176B87);
			rating2.setTextColor(0xFF176B87);
			rating1.setTextColor(0xFF176B87);
			rating_all.setBackgroundColor(0xFFFFFFFF);
			rating5.setBackgroundColor(0xFFFFFFFF);
			rating4.setBackgroundColor(0xFFFFFFFF);
			rating3.setBackgroundColor(0xFFFFFFFF);
			rating2.setBackgroundColor(0xFFFFFFFF);
			rating1.setBackgroundColor(0xFFFFFFFF);
		}
		else {
			if (data.getString("rating", "").equals("⭐ All")) {
				rating_all.setTextColor(0xFFFFFFFF);
				rating_all.setBackgroundColor(0xFF176B87);
			}
			else {
				if (data.getString("rating", "").equals("⭐ 5")) {
					rating5.setTextColor(0xFFFFFFFF);
					rating5.setBackgroundColor(0xFF176B87);
				}
				else {
					if (data.getString("rating", "").equals("⭐ 4")) {
						rating4.setTextColor(0xFFFFFFFF);
						rating4.setBackgroundColor(0xFF176B87);
					}
					else {
						if (data.getString("rating", "").equals("⭐ 3")) {
							rating3.setTextColor(0xFFFFFFFF);
							rating3.setBackgroundColor(0xFF176B87);
						}
						else {
							if (data.getString("rating", "").equals("⭐ 2")) {
								rating2.setTextColor(0xFFFFFFFF);
								rating2.setBackgroundColor(0xFF176B87);
							}
							else {
								if (data.getString("rating", "").equals("⭐ 1")) {
									rating1.setTextColor(0xFFFFFFFF);
									rating1.setBackgroundColor(0xFF176B87);
								}
							}
						}
					}
				}
			}
		}
	}
	
}