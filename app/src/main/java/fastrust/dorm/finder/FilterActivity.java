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
import android.widget.HorizontalScrollView;
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
import com.shobhitpuri.custombuttons.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import com.google.android.material.slider.Slider;
import com.google.android.material.slider.RangeSlider;

public class FilterActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private boolean isVisible = false;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview2;
	private LinearLayout line1;
	private HorizontalScrollView hscroll1;
	private TextView textview3;
	private RangeSlider seekbar1;
	private TextView textview15;
	private HorizontalScrollView hscroll3;
	private LinearLayout line2;
	private LinearLayout linear40;
	private TextView textview1;
	private LinearLayout linear4;
	private CardView all;
	private CardView female_dorm;
	private CardView male_dorm;
	private CardView Co_ed;
	private CardView gender_neutral;
	private CardView transient_;
	private LinearLayout linear5;
	private CardView cardview6;
	private LinearLayout all_layout;
	private TextView all_text;
	private LinearLayout linear7;
	private CardView cardview7;
	private LinearLayout female_dorm_layout;
	private TextView female_dorm_text;
	private LinearLayout linear9;
	private CardView cardview8;
	private LinearLayout male_dorm_layout;
	private TextView male_dorm_text;
	private LinearLayout linear11;
	private CardView cardview9;
	private LinearLayout co_ed_layout;
	private TextView co_ed_text;
	private LinearLayout linear13;
	private CardView cardview10;
	private LinearLayout gender_neutral_layout;
	private TextView gender_neutral_text;
	private LinearLayout linear41;
	private CardView cardview38;
	private LinearLayout transient_layout;
	private TextView transient_text;
	private LinearLayout linear25;
	private CardView star_all;
	private CardView star5;
	private CardView star4;
	private CardView star3;
	private CardView star2;
	private CardView star1;
	private CardView star0;
	private LinearLayout linear26;
	private CardView cardview28;
	private LinearLayout star_all_layout;
	private TextView star_all_text;
	private LinearLayout linear27;
	private CardView cardview29;
	private LinearLayout star5_layout;
	private TextView star5_text;
	private LinearLayout linear28;
	private CardView cardview30;
	private LinearLayout star4_layout;
	private TextView star4_text;
	private LinearLayout linear29;
	private CardView cardview31;
	private LinearLayout star3_layout;
	private TextView star3_text;
	private LinearLayout linear30;
	private CardView cardview32;
	private LinearLayout star2_layout;
	private TextView star2_text;
	private LinearLayout linear31;
	private CardView cardview33;
	private LinearLayout star1_layout;
	private TextView star1_text;
	private LinearLayout linear32;
	private CardView cardview34;
	private LinearLayout star0_layout;
	private TextView star0_text;
	private CardView cardview35;
	private CardView cardview36;
	private LinearLayout reset;
	private TextView textview23;
	private LinearLayout apply;
	private TextView textview24;
	
	private Intent intent = new Intent();
	private SharedPreferences data;
	private TimerTask timer;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.filter);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		textview2 = findViewById(R.id.textview2);
		line1 = findViewById(R.id.line1);
		hscroll1 = findViewById(R.id.hscroll1);
		textview3 = findViewById(R.id.textview3);
		seekbar1 = findViewById(R.id.seekbar1);
		textview15 = findViewById(R.id.textview15);
		hscroll3 = findViewById(R.id.hscroll3);
		line2 = findViewById(R.id.line2);
		linear40 = findViewById(R.id.linear40);
		textview1 = findViewById(R.id.textview1);
		linear4 = findViewById(R.id.linear4);
		all = findViewById(R.id.all);
		female_dorm = findViewById(R.id.female_dorm);
		male_dorm = findViewById(R.id.male_dorm);
		Co_ed = findViewById(R.id.Co_ed);
		gender_neutral = findViewById(R.id.gender_neutral);
		transient_ = findViewById(R.id.transient_);
		linear5 = findViewById(R.id.linear5);
		cardview6 = findViewById(R.id.cardview6);
		all_layout = findViewById(R.id.all_layout);
		all_text = findViewById(R.id.all_text);
		linear7 = findViewById(R.id.linear7);
		cardview7 = findViewById(R.id.cardview7);
		female_dorm_layout = findViewById(R.id.female_dorm_layout);
		female_dorm_text = findViewById(R.id.female_dorm_text);
		linear9 = findViewById(R.id.linear9);
		cardview8 = findViewById(R.id.cardview8);
		male_dorm_layout = findViewById(R.id.male_dorm_layout);
		male_dorm_text = findViewById(R.id.male_dorm_text);
		linear11 = findViewById(R.id.linear11);
		cardview9 = findViewById(R.id.cardview9);
		co_ed_layout = findViewById(R.id.co_ed_layout);
		co_ed_text = findViewById(R.id.co_ed_text);
		linear13 = findViewById(R.id.linear13);
		cardview10 = findViewById(R.id.cardview10);
		gender_neutral_layout = findViewById(R.id.gender_neutral_layout);
		gender_neutral_text = findViewById(R.id.gender_neutral_text);
		linear41 = findViewById(R.id.linear41);
		cardview38 = findViewById(R.id.cardview38);
		transient_layout = findViewById(R.id.transient_layout);
		transient_text = findViewById(R.id.transient_text);
		linear25 = findViewById(R.id.linear25);
		star_all = findViewById(R.id.star_all);
		star5 = findViewById(R.id.star5);
		star4 = findViewById(R.id.star4);
		star3 = findViewById(R.id.star3);
		star2 = findViewById(R.id.star2);
		star1 = findViewById(R.id.star1);
		star0 = findViewById(R.id.star0);
		linear26 = findViewById(R.id.linear26);
		cardview28 = findViewById(R.id.cardview28);
		star_all_layout = findViewById(R.id.star_all_layout);
		star_all_text = findViewById(R.id.star_all_text);
		linear27 = findViewById(R.id.linear27);
		cardview29 = findViewById(R.id.cardview29);
		star5_layout = findViewById(R.id.star5_layout);
		star5_text = findViewById(R.id.star5_text);
		linear28 = findViewById(R.id.linear28);
		cardview30 = findViewById(R.id.cardview30);
		star4_layout = findViewById(R.id.star4_layout);
		star4_text = findViewById(R.id.star4_text);
		linear29 = findViewById(R.id.linear29);
		cardview31 = findViewById(R.id.cardview31);
		star3_layout = findViewById(R.id.star3_layout);
		star3_text = findViewById(R.id.star3_text);
		linear30 = findViewById(R.id.linear30);
		cardview32 = findViewById(R.id.cardview32);
		star2_layout = findViewById(R.id.star2_layout);
		star2_text = findViewById(R.id.star2_text);
		linear31 = findViewById(R.id.linear31);
		cardview33 = findViewById(R.id.cardview33);
		star1_layout = findViewById(R.id.star1_layout);
		star1_text = findViewById(R.id.star1_text);
		linear32 = findViewById(R.id.linear32);
		cardview34 = findViewById(R.id.cardview34);
		star0_layout = findViewById(R.id.star0_layout);
		star0_text = findViewById(R.id.star0_text);
		cardview35 = findViewById(R.id.cardview35);
		cardview36 = findViewById(R.id.cardview36);
		reset = findViewById(R.id.reset);
		textview23 = findViewById(R.id.textview23);
		apply = findViewById(R.id.apply);
		textview24 = findViewById(R.id.textview24);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		all.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("category", "All").commit();
				all_layout.setBackgroundColor(0xFF176B87);
				female_dorm_layout.setBackgroundColor(0xFFFFFFFF);
				male_dorm_layout.setBackgroundColor(0xFFFFFFFF);
				co_ed_layout.setBackgroundColor(0xFFFFFFFF);
				gender_neutral_layout.setBackgroundColor(0xFFFFFFFF);
				transient_layout.setBackgroundColor(0xFFFFFFFF);
				all_text.setTextColor(0xFFFFFFFF);
				female_dorm_text.setTextColor(0xFF176B87);
				male_dorm_text.setTextColor(0xFF176B87);
				co_ed_text.setTextColor(0xFF176B87);
				gender_neutral_text.setTextColor(0xFF176B87);
				transient_text.setTextColor(0xFF176B87);
			}
		});
		
		female_dorm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("category", "Female Dormitory").commit();
				all_layout.setBackgroundColor(0xFFFFFFFF);
				female_dorm_layout.setBackgroundColor(0xFF176B87);
				male_dorm_layout.setBackgroundColor(0xFFFFFFFF);
				co_ed_layout.setBackgroundColor(0xFFFFFFFF);
				gender_neutral_layout.setBackgroundColor(0xFFFFFFFF);
				transient_layout.setBackgroundColor(0xFFFFFFFF);
				all_text.setTextColor(0xFF176B87);
				female_dorm_text.setTextColor(0xFFFFFFFF);
				male_dorm_text.setTextColor(0xFF176B87);
				co_ed_text.setTextColor(0xFF176B87);
				gender_neutral_text.setTextColor(0xFF176B87);
				transient_text.setTextColor(0xFF176B87);
			}
		});
		
		male_dorm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("category", "Male Dormitory").commit();
				all_layout.setBackgroundColor(0xFFFFFFFF);
				female_dorm_layout.setBackgroundColor(0xFFFFFFFF);
				male_dorm_layout.setBackgroundColor(0xFF176B87);
				co_ed_layout.setBackgroundColor(0xFFFFFFFF);
				gender_neutral_layout.setBackgroundColor(0xFFFFFFFF);
				transient_layout.setBackgroundColor(0xFFFFFFFF);
				all_text.setTextColor(0xFF176B87);
				female_dorm_text.setTextColor(0xFF176B87);
				male_dorm_text.setTextColor(0xFFFFFFFF);
				co_ed_text.setTextColor(0xFF176B87);
				gender_neutral_text.setTextColor(0xFF176B87);
				transient_text.setTextColor(0xFF176B87);
			}
		});
		
		Co_ed.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("category", "Co-ed Dormitory").commit();
				all_layout.setBackgroundColor(0xFFFFFFFF);
				female_dorm_layout.setBackgroundColor(0xFFFFFFFF);
				male_dorm_layout.setBackgroundColor(0xFFFFFFFF);
				co_ed_layout.setBackgroundColor(0xFF176B87);
				gender_neutral_layout.setBackgroundColor(0xFFFFFFFF);
				transient_layout.setBackgroundColor(0xFFFFFFFF);
				all_text.setTextColor(0xFF176B87);
				female_dorm_text.setTextColor(0xFF176B87);
				male_dorm_text.setTextColor(0xFF176B87);
				co_ed_text.setTextColor(0xFFFFFFFF);
				gender_neutral_text.setTextColor(0xFF176B87);
				transient_text.setTextColor(0xFF176B87);
			}
		});
		
		gender_neutral.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("category", "Gender-neutral Dormitory").commit();
				all_layout.setBackgroundColor(0xFFFFFFFF);
				female_dorm_layout.setBackgroundColor(0xFFFFFFFF);
				male_dorm_layout.setBackgroundColor(0xFFFFFFFF);
				co_ed_layout.setBackgroundColor(0xFFFFFFFF);
				gender_neutral_layout.setBackgroundColor(0xFF176B87);
				transient_layout.setBackgroundColor(0xFFFFFFFF);
				all_text.setTextColor(0xFF176B87);
				female_dorm_text.setTextColor(0xFF176B87);
				male_dorm_text.setTextColor(0xFF176B87);
				co_ed_text.setTextColor(0xFF176B87);
				gender_neutral_text.setTextColor(0xFFFFFFFF);
				transient_text.setTextColor(0xFF176B87);
			}
		});
		
		transient_.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("category", "Transcient").commit();
				all_layout.setBackgroundColor(0xFFFFFFFF);
				female_dorm_layout.setBackgroundColor(0xFFFFFFFF);
				male_dorm_layout.setBackgroundColor(0xFFFFFFFF);
				co_ed_layout.setBackgroundColor(0xFFFFFFFF);
				gender_neutral_layout.setBackgroundColor(0xFFFFFFFF);
				transient_layout.setBackgroundColor(0xFF176B87);
				all_text.setTextColor(0xFF176B87);
				female_dorm_text.setTextColor(0xFF176B87);
				male_dorm_text.setTextColor(0xFF176B87);
				co_ed_text.setTextColor(0xFF176B87);
				gender_neutral_text.setTextColor(0xFF176B87);
				transient_text.setTextColor(0xFFFFFFFF);
			}
		});
		
		star_all.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("rating", "All").commit();
				star_all_layout.setBackgroundColor(0xFF176B87);
				star5_layout.setBackgroundColor(0xFFFFFFFF);
				star4_layout.setBackgroundColor(0xFFFFFFFF);
				star3_layout.setBackgroundColor(0xFFFFFFFF);
				star2_layout.setBackgroundColor(0xFFFFFFFF);
				star1_layout.setBackgroundColor(0xFFFFFFFF);
				star0_layout.setBackgroundColor(0xFFFFFFFF);
				star_all_text.setTextColor(0xFFFFFFFF);
				star5_text.setTextColor(0xFF176B87);
				star4_text.setTextColor(0xFF176B87);
				star3_text.setTextColor(0xFF176B87);
				star2_text.setTextColor(0xFF176B87);
				star1_text.setTextColor(0xFF176B87);
				star0_text.setTextColor(0xFF176B87);
			}
		});
		
		star5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("rating", "5").commit();
				star_all_layout.setBackgroundColor(0xFFFFFFFF);
				star5_layout.setBackgroundColor(0xFF176B87);
				star4_layout.setBackgroundColor(0xFFFFFFFF);
				star3_layout.setBackgroundColor(0xFFFFFFFF);
				star2_layout.setBackgroundColor(0xFFFFFFFF);
				star1_layout.setBackgroundColor(0xFFFFFFFF);
				star0_layout.setBackgroundColor(0xFFFFFFFF);
				star_all_text.setTextColor(0xFF176B87);
				star5_text.setTextColor(0xFFFFFFFF);
				star4_text.setTextColor(0xFF176B87);
				star3_text.setTextColor(0xFF176B87);
				star2_text.setTextColor(0xFF176B87);
				star1_text.setTextColor(0xFF176B87);
				star0_text.setTextColor(0xFF176B87);
			}
		});
		
		star4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("rating", "4").commit();
				star_all_layout.setBackgroundColor(0xFFFFFFFF);
				star5_layout.setBackgroundColor(0xFFFFFFFF);
				star4_layout.setBackgroundColor(0xFF176B87);
				star3_layout.setBackgroundColor(0xFFFFFFFF);
				star2_layout.setBackgroundColor(0xFFFFFFFF);
				star1_layout.setBackgroundColor(0xFFFFFFFF);
				star0_layout.setBackgroundColor(0xFFFFFFFF);
				star_all_text.setTextColor(0xFF176B87);
				star5_text.setTextColor(0xFF176B87);
				star4_text.setTextColor(0xFFFFFFFF);
				star3_text.setTextColor(0xFF176B87);
				star2_text.setTextColor(0xFF176B87);
				star1_text.setTextColor(0xFF176B87);
				star0_text.setTextColor(0xFF176B87);
			}
		});
		
		star3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("rating", "3").commit();
				star_all_layout.setBackgroundColor(0xFFFFFFFF);
				star5_layout.setBackgroundColor(0xFFFFFFFF);
				star4_layout.setBackgroundColor(0xFFFFFFFF);
				star3_layout.setBackgroundColor(0xFF176B87);
				star2_layout.setBackgroundColor(0xFFFFFFFF);
				star1_layout.setBackgroundColor(0xFFFFFFFF);
				star0_layout.setBackgroundColor(0xFFFFFFFF);
				star_all_text.setTextColor(0xFF176B87);
				star5_text.setTextColor(0xFF176B87);
				star4_text.setTextColor(0xFF176B87);
				star3_text.setTextColor(0xFFFFFFFF);
				star2_text.setTextColor(0xFF176B87);
				star1_text.setTextColor(0xFF176B87);
				star0_text.setTextColor(0xFF176B87);
			}
		});
		
		star2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("rating", "2").commit();
				star_all_layout.setBackgroundColor(0xFFFFFFFF);
				star5_layout.setBackgroundColor(0xFFFFFFFF);
				star4_layout.setBackgroundColor(0xFFFFFFFF);
				star3_layout.setBackgroundColor(0xFFFFFFFF);
				star2_layout.setBackgroundColor(0xFF176B87);
				star1_layout.setBackgroundColor(0xFFFFFFFF);
				star0_layout.setBackgroundColor(0xFFFFFFFF);
				star_all_text.setTextColor(0xFF176B87);
				star5_text.setTextColor(0xFF176B87);
				star4_text.setTextColor(0xFF176B87);
				star3_text.setTextColor(0xFF176B87);
				star2_text.setTextColor(0xFFFFFFFF);
				star1_text.setTextColor(0xFF176B87);
				star0_text.setTextColor(0xFF176B87);
			}
		});
		
		star1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("rating", "1").commit();
				star_all_layout.setBackgroundColor(0xFFFFFFFF);
				star5_layout.setBackgroundColor(0xFFFFFFFF);
				star4_layout.setBackgroundColor(0xFFFFFFFF);
				star3_layout.setBackgroundColor(0xFFFFFFFF);
				star2_layout.setBackgroundColor(0xFFFFFFFF);
				star1_layout.setBackgroundColor(0xFF176B87);
				star0_layout.setBackgroundColor(0xFFFFFFFF);
				star_all_text.setTextColor(0xFF176B87);
				star5_text.setTextColor(0xFF176B87);
				star4_text.setTextColor(0xFF176B87);
				star3_text.setTextColor(0xFF176B87);
				star2_text.setTextColor(0xFF176B87);
				star1_text.setTextColor(0xFFFFFFFF);
				star0_text.setTextColor(0xFF176B87);
			}
		});
		
		star0.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("rating", "0").commit();
				star_all_layout.setBackgroundColor(0xFFFFFFFF);
				star5_layout.setBackgroundColor(0xFFFFFFFF);
				star4_layout.setBackgroundColor(0xFFFFFFFF);
				star3_layout.setBackgroundColor(0xFFFFFFFF);
				star2_layout.setBackgroundColor(0xFFFFFFFF);
				star1_layout.setBackgroundColor(0xFFFFFFFF);
				star0_layout.setBackgroundColor(0xFF176B87);
				star_all_text.setTextColor(0xFF176B87);
				star5_text.setTextColor(0xFF176B87);
				star4_text.setTextColor(0xFF176B87);
				star3_text.setTextColor(0xFF176B87);
				star2_text.setTextColor(0xFF176B87);
				star1_text.setTextColor(0xFF176B87);
				star0_text.setTextColor(0xFFFFFFFF);
			}
		});
		
		reset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (data.getString("login", "").equals("true")) {
					data.edit().remove("filter category").commit();
					data.edit().remove("filter price range").commit();
					data.edit().remove("filter rating").commit();
					_telegramLoaderDialog(true);
					timer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									_telegramLoaderDialog(false);
									_reset_ui();
									SketchwareUtil.showMessage(getApplicationContext(), "Done");
								}
							});
						}
					};
					_timer.schedule(timer, (int)(3000));
				}
				else {
					intent.setAction(Intent.ACTION_VIEW);
					intent.setClass(getApplicationContext(), SigninDialogActivity.class);
					startActivity(intent);
				}
			}
		});
		
		apply.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (data.getString("login", "").equals("true")) {
					data.edit().putString("filter", data.getString("category", "").concat(", ".concat(data.getString("price range", "").concat(", ".concat(data.getString("rating", "")))))).commit();
					SketchwareUtil.showMessage(getApplicationContext(), "Saved");
					finish();
				}
				else {
					intent.setAction(Intent.ACTION_VIEW);
					intent.setClass(getApplicationContext(), SigninDialogActivity.class);
					startActivity(intent);
				}
			}
		});
	}
	
	private void initializeLogic() {
		_ui();
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
	
	
	public void _ui() {
		_advance(linear1);
		_removeScollBar(hscroll1);
		_removeScollBar(hscroll3);
		_simpleRiffle(star_all_layout);
		_simpleRiffle(star5_layout);
		_simpleRiffle(star4_layout);
		_simpleRiffle(star3_layout);
		_simpleRiffle(star2_layout);
		_simpleRiffle(star1_layout);
		_simpleRiffle(star0_layout);
		_removeScollBar(hscroll3);
		_simpleRiffle(reset);
		_rippleRoundStroke(apply, "#176b87", "#eeeeee", 100, 100, "#176b87");
	}
	
	
	public void _reset_ui() {
		all_layout.setBackgroundColor(0xFFFFFFFF);
		female_dorm_layout.setBackgroundColor(0xFFFFFFFF);
		male_dorm_layout.setBackgroundColor(0xFFFFFFFF);
		co_ed_layout.setBackgroundColor(0xFFFFFFFF);
		gender_neutral_layout.setBackgroundColor(0xFFFFFFFF);
		all_text.setTextColor(0xFF176B87);
		female_dorm_text.setTextColor(0xFF176B87);
		male_dorm_text.setTextColor(0xFF176B87);
		co_ed_text.setTextColor(0xFF176B87);
		gender_neutral_text.setTextColor(0xFF176B87);
		
		seekbar1.setValueFrom((float) 1000);
		seekbar1.setValueTo((float) 10000);
		seekbar1.setStepSize((float) 100);
		
		
		
		
		
		
		
		
		
		
		
		
		star_all_layout.setBackgroundColor(0xFFFFFFFF);
		star5_layout.setBackgroundColor(0xFFFFFFFF);
		star4_layout.setBackgroundColor(0xFFFFFFFF);
		star3_layout.setBackgroundColor(0xFFFFFFFF);
		star2_layout.setBackgroundColor(0xFFFFFFFF);
		star1_layout.setBackgroundColor(0xFFFFFFFF);
		star0_layout.setBackgroundColor(0xFFFFFFFF);
		star_all_text.setTextColor(0xFF176B87);
		star5_text.setTextColor(0xFF176B87);
		star4_text.setTextColor(0xFF176B87);
		star3_text.setTextColor(0xFF176B87);
		star2_text.setTextColor(0xFF176B87);
		star1_text.setTextColor(0xFF176B87);
		star0_text.setTextColor(0xFF176B87);
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