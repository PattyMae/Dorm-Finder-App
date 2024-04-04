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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.prime.arab.ware.everythingutils.*;
import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.FirebaseApp;
import com.shobhitpuri.custombuttons.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MapBottomdialogFragmentDialogFragmentActivity extends BottomSheetDialogFragment {
	
	private LinearLayout bg;
	private CardView cardview2;
	private LinearLayout linear1;
	private LinearLayout linear4;
	private CardView cardview1;
	private LinearLayout linear2;
	private ImageView imageview1;
	private TextView textview1;
	private TextView textview2;
	
	private SharedPreferences data;
	private Intent intent = new Intent();
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.map_bottomdialog_fragment_dialog_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		bg = _view.findViewById(R.id.bg);
		cardview2 = _view.findViewById(R.id.cardview2);
		linear1 = _view.findViewById(R.id.linear1);
		linear4 = _view.findViewById(R.id.linear4);
		cardview1 = _view.findViewById(R.id.cardview1);
		linear2 = _view.findViewById(R.id.linear2);
		imageview1 = _view.findViewById(R.id.imageview1);
		textview1 = _view.findViewById(R.id.textview1);
		textview2 = _view.findViewById(R.id.textview2);
		data = getContext().getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		linear1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getContext().getApplicationContext(), DormitoryDetailsActivity.class);
				intent.putExtra("getPost", data.getString("getPost", ""));
				intent.putExtra("uid", data.getString("uid", ""));
				intent.putExtra("photo1", data.getString("photo1", ""));
				intent.putExtra("photo5", data.getString("photo5", ""));
				intent.putExtra("photo9", data.getString("photo9", ""));
				startActivity(intent);
			}
		});
	}
	
	private void initializeLogic() {
		_simpleRiffle(linear1);
		textview1.setText(data.getString("dorm", ""));
		textview2.setText(data.getString("loc", ""));
		Glide.with(getContext().getApplicationContext()).load(Uri.parse(data.getString("photo", ""))).into(imageview1);
	}
	
	public void _simpleRiffle(final View _view) {
		android.graphics.drawable.RippleDrawable GA8PO9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#9E9E9E")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
		
		_view.setBackground(GA8PO9);
	}
	
}