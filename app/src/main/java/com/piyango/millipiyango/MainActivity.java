package com.piyango.millipiyango;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.piyango.json.FetchJsonTask;
import com.piyango.json.RequestManager;
import com.piyango.model.SayisalSonuc;

public class MainActivity extends Activity {
	public static ArrayList<String> tarihList = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {



		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn = (Button)findViewById(R.id.requestButton);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
//				new CekilisRequest().execute();

                RequestManager.getSayisal(new FetchJsonTask.Callback<SayisalSonuc>() {
                    @Override
                    public void onFail() {
                        Log.d("MilliPiyango", "HATA!");
//				Toast.makeText(.getContext(), "BAŞARISIZLIK!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStart() {
                        Log.d("MilliPiyango", "ONSTART");
                    }

                    @Override
                    public void onSuccess(final SayisalSonuc obj) {
                        Log.d("MilliPiyango", "YAY!");
                        Log.d("MilliPiyango", obj.data.cekilisTarihi + "\t" + obj.data.rakamlarNumaraSirasi + "\t" + obj.data.buyukIkrKazananIlIlceler.get(0).il );
						TextView v1 = (TextView)findViewById(R.id.sonucTextView);
						v1.setText(obj.data.rakamlarNumaraSirasi);
                    }
                },"20160213" ,"","");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		
		return true;
	}

}
