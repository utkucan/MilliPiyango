package com.piyango.millipiyango;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.piyango.json.FetchJsonTask;
import com.piyango.json.RequestManager;
import com.piyango.model.SayisalSonuc;
import com.piyango.model.SonucTarih;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends Activity {
	public static ArrayList<String> tarihList = new ArrayList<String>();
    private ProgressDialog mConnectionProgressDialog;

    @Override
	protected void onCreate(Bundle savedInstanceState) {


		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


        mConnectionProgressDialog = new ProgressDialog(MainActivity.this);
        mConnectionProgressDialog.setCancelable(false);
        mConnectionProgressDialog.setMessage("Tarih bilgileri yükleniyor...");

        RequestManager.getSayisalSonucTarihleri(new CekilisRequest.Callback<String>() {
            @Override
            public void onFail() {
                mConnectionProgressDialog.dismiss();
            }

            @Override
            public void onStart() {
                mConnectionProgressDialog.show();
            }

            @Override
            public void onSuccess(String obj) {
                try {
                    JSONArray mJsonArray = new JSONArray(obj);
                    ArrayList<String> tarihList = new ArrayList<>();
                    JSONObject mJsonObject ;
                    for (int i = 0; i < mJsonArray.length(); i++) {
                        mJsonObject = mJsonArray.getJSONObject(i);
                        tarihList.add(mJsonObject.getString("tarih"));
                        mJsonObject.getString("tarihView");
                    }

                    ArrayAdapter<CharSequence> adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, tarihList);
                    Spinner spn = (Spinner) findViewById(R.id.tarihSpinner);
                    spn.setAdapter(adapter);

                    spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            RequestManager.getSayisal(new FetchJsonTask.Callback<SayisalSonuc>() {
                                @Override
                                public void onFail() {
                                    Log.d("MilliPiyango", "HATA!");
                                }

                                @Override
                                public void onStart() {
                                    Log.d("MilliPiyango", "ONSTART");
                                }

                                @Override
                                public void onSuccess(final SayisalSonuc obj) {
                                    Log.d("MilliPiyango", "YAY!");
                                    Log.d("MilliPiyango", obj.data.cekilisTarihi + "\t" + obj.data.rakamlarNumaraSirasi);
                                    TextView v1 = (TextView) findViewById(R.id.sonucTextView);
                                    v1.setText(obj.data.rakamlarNumaraSirasi);
                                    ((TextView) findViewById(R.id.tarihTextView)).setText(obj.data.cekilisTarihi);
                                }
                            }, parent.getAdapter().getItem(position).toString());
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            RequestManager.getSayisal(new FetchJsonTask.Callback<SayisalSonuc>() {
                                @Override
                                public void onFail() {
                                    Log.d("MilliPiyango", "HATA!");
                                }

                                @Override
                                public void onStart() {
                                    Log.d("MilliPiyango", "ONSTART");
                                }

                                @Override
                                public void onSuccess(final SayisalSonuc obj) {
                                    Log.d("MilliPiyango", "YAY!");
                                    Log.d("MilliPiyango", obj.data.cekilisTarihi + "\t" + obj.data.rakamlarNumaraSirasi + "\t" + obj.data.buyukIkrKazananIlIlceler.get(0).il);
                                    TextView v1 = (TextView) findViewById(R.id.sonucTextView);
                                    v1.setText(obj.data.rakamlarNumaraSirasi);
                                    ((TextView) findViewById(R.id.tarihTextView)).setText(obj.data.cekilisTarihi);
                                }
                            }, parent.getAdapter().getItem(0).toString());
                        }

                    });

                } catch (Exception e) {

                }
                mConnectionProgressDialog.dismiss();
            }
        }, "sayisal");


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
                },"20160213");
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
