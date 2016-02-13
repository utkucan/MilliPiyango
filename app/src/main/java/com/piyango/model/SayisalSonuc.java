package com.piyango.model;

import java.util.List;

/**
 * Created by koray on 13/02/16.
 */
public class SayisalSonuc {


    public String success;
    public SayisalModel data;


    public class IkramiyeDetay{
        public String oid, kisiBasinaDusenIkramiye, kisiSayisi, tur;
    }
    public class SayisalModel{
        public List<IkramiyeDetay> bilenKisiler;

        public String oid, hafta, buyukIkramiyeKazananIl, cekilisTarihi,cekilisTuru,rakamlar,rakamlarNumaraSirasi,devretti,devirSayisi,kibrisHasilati;
    }


//    {
//        "success": true,
//            "data": {
//        "oid": "64zlrohp78ctyh00",
//                "hafta": 892,
//                "buyukIkramiyeKazananIl": "",
//                "cekilisTarihi": "14/12/2013",
//                "cekilisTuru": "SAYISAL_LOTO",
//                "rakamlar": "47#18#42#26#01#11",
//                "rakamlarNumaraSirasi": "01 - 11 - 18 - 26 - 42 - 47",
//                "devretti": true,
//                "devirSayisi": 2,
//                "bilenKisiler": [
//        {
//            "oid": "64zlrshp78ctyd03",
//                "kisiBasinaDusenIkramiye": 6.05,
//                "kisiSayisi": 231575,
//                "tur": "$3_BILEN"
//        },
//        {
//            "oid": "64zlrshp78ctyd02",
//                "kisiBasinaDusenIkramiye": 41.85,
//                "kisiSayisi": 12162,
//                "tur": "$4_BILEN"
//        },
//        {
//            "oid": "64zlrshp78ctyd01",
//                "kisiBasinaDusenIkramiye": 3104.45,
//                "kisiSayisi": 214,
//                "tur": "$5_BILEN"
//        },
//        {
//            "oid": "64zlrshp78ctyd00",
//                "kisiBasinaDusenIkramiye": 3122383.17,
//                "kisiSayisi": 0,
//                "tur": "$6_BILEN"
//        }
//        ],
//        "buyukIkrKazananIlIlceler": [],
//        "kibrisHasilati": 53181,
//                "devirTutari": 1544545.66,
//                "kolonSayisi": 14504552,
//                "kdv": 1651306.73,
//                "toplamHasilat": 10878414,
//                "hasilat": 9227107.27,
//                "sov": 922710.73,
//                "ikramiyeEH": 8304396.539999999,
//                "buyukIkramiye": 1577835.34,
//                "haftayaDevredenTutar": 3122383.17
//    }

}
