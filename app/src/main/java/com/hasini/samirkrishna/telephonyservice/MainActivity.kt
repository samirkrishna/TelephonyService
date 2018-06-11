package com.hasini.samirkrishna.telephonyservice

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    var lview:ListView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lview=findViewById(R.id.lview)

        var tManager:TelephonyManager=getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        var list= mutableListOf<String>()
        list.add("IMEI:"+tManager.getImei())
        list.add("Sim Sno:"+tManager.simSerialNumber)
        list.add("Network name:"+tManager.simOperatorName)
        list.add("Country:"+tManager.networkCountryIso)
        list.add("Sim type:"+tManager.phoneType)
        list.add("Connect:"+tManager.simState)

        var adapter=ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list)

        lview?.adapter=adapter
    }
}
