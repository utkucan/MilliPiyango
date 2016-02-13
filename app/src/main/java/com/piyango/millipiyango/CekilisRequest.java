//package com.piyango.millipiyango;
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.StringTokenizer;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicNameValuePair;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import android.os.AsyncTask;
//import android.util.Log;
//
//public class CekilisRequest extends AsyncTask<Void, Void, Void> {
//	String res ="";
//	public CekilisRequest() {
//
//	}
//
//	@Override
//	protected Void doInBackground(Void... arg0) {
//		HttpClient httpClient = new DefaultHttpClient();
//		HttpPost httpPost = new HttpPost("http://www.millipiyango.gov.tr/sonuclar/listCekilisleriTarihleri.php");
//		// Building post parameters, key and value pair
//		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(1);
//		nameValuePair.add(new BasicNameValuePair("tur", "superloto"));
//		// Url Encoding the POST parameters
//		try {
//			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
//		}
//		catch (UnsupportedEncodingException e) {
//			// writing error to Log
//			e.printStackTrace();
//		}
//		try {
//			HttpResponse response = httpClient.execute(httpPost);
//			BufferedReader inBuffer = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//
//			StringBuffer stringBuffer = new StringBuffer("");
//			String line = "";
//			StringBuilder content = new StringBuilder();
//			while ((line = inBuffer.readLine()) != null) {
//				 content.append(line);
//				Log.d("MilliPiyango", line);
//			}
//
//			JSONArray mJsonArray = new JSONArray(content.toString());
////			JSONObject mainObject = new JSONObject(content.toString());/
////			JSONObject uniObject = mainObject.getJSONObject("tarihView");
////			String  uniName = uniObject.getJSONObject("name");
////			String uniURL = uniObject.getJSONObject("url");
////
////			JSONObject oneObject = mainObject.getJSONObject("1");
////			String id = oneObject.getJSONObject("id");
//			ArrayList<String> tarihList =new ArrayList<String>();
//			JSONObject mJsonObject = new JSONObject();
//			for (int i = 0; i < mJsonArray.length(); i++) {
//
//					mJsonObject = mJsonArray.getJSONObject(i);
//					//http://www.millipiyango.gov.tr/sonuclar/cekilisler/sayisal/20131214.json
//					tarihList.add(mJsonObject.getString("tarih"));
//			    mJsonObject.getString("tarihView");
//			}
//			MainActivity.tarihList = tarihList;
//
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	@Override
//	protected void onPostExecute(Void result) {
//		// TODO Auto-generated method stub
//	}
//}