package com.piyango.json;

import java.util.List;
import java.util.Locale;

import com.piyango.model.SayisalSonuc;

public class RequestManager {

	public static void getSayisal(FetchJsonTask.Callback<SayisalSonuc> c,String hafta,String ui,String aspSessionId){
		new FetchJsonTask<SayisalSonuc>(SayisalSonuc.class, "sayisal/"+hafta+".json", c).execute();
	}

}
