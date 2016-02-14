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
    public class IkramiyeIlIlce{
        public String il, ilView,ilce,ilceView;
        //        "il": "09",
//            "ilView": "AYDIN",
//            "ilce": "00917",
//            "ilceView": "DİDİM"
    }
    public class SayisalModel{
        public List<IkramiyeDetay> bilenKisiler;
        public List<IkramiyeIlIlce> buyukIkrKazananIlIlceler;
        public String oid, hafta, buyukIkramiyeKazananIl, cekilisTarihi,cekilisTuru,rakamlar,rakamlarNumaraSirasi,devretti,devirSayisi,kibrisHasilati,buyukIkramiye;
    }


//{
//    "success": true,
//        "data": {
//    "oid": "64myutiklhnhgq00",
//            "hafta": 1005,
//            "buyukIkramiyeKazananIl": "",
//            "cekilisTarihi": "13/02/2016",
//            "cekilisTuru": "SAYISAL_LOTO",
//            "rakamlar": "34#17#32#19#28#25",
//            "rakamlarNumaraSirasi": "17 - 19 - 25 - 28 - 32 - 34",
//            "devretti": false,
//            "devirSayisi": 0,
//            "bilenKisiler": [
//    {
//        "oid": "64j463iklhnhgl03",
//            "kisiBasinaDusenIkramiye": 7.05,
//            "kisiSayisi": 216587,
//            "tur": "$3_BILEN"
//    },
//    {
//        "oid": "64j463iklhnhgl02",
//            "kisiBasinaDusenIkramiye": 45.55,
//            "kisiSayisi": 11942,
//            "tur": "$4_BILEN"
//    },
//    {
//        "oid": "64j463iklhnhgl01",
//            "kisiBasinaDusenIkramiye": 3132.7,
//            "kisiSayisi": 230,
//            "tur": "$5_BILEN"
//    },
//    {
//        "oid": "64j463iklhnhgl00",
//            "kisiBasinaDusenIkramiye": 1710869.8,
//            "kisiSayisi": 1,
//            "tur": "$6_BILEN"
//    }
//    ],
//    "buyukIkrKazananIlIlceler": [
//    {
//        "il": "09",
//            "ilView": "AYDIN",
//            "ilce": "00917",
//            "ilceView": "DİDİM"
//    }
//    ],
//    "kibrisHasilati": 57170,
//            "devirTutari": 0.04,
//            "kolonSayisi": 11795707,
//            "kdv": 1790624.29,
//            "toplamHasilat": 11795707,
//            "hasilat": 10005082.71,
//            "sov": 1000508.27,
//            "ikramiyeEH": 9004574.440000001,
//            "buyukIkramiye": 1710869.14,
//            "haftayaDevredenTutar": 0.01
//}
//}

}
