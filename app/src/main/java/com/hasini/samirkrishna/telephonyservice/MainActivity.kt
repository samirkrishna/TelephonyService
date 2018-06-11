package com.hasini.samirkrishna.telephonyservice

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.telecom.Connection
import android.telecom.ConnectionService
import android.telephony.TelephonyManager
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var lview:ListView?=null
    @RequiresApi(Build.VERSION_CODES.M)
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

        var cManager:ConnectivityManager=getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        //these lines of code for connectivity
        if(cManager.activeNetwork!=null)
        list.add(cManager.activeNetworkInfo.isConnected.toString())
        else
            Toast.makeText(this,"no internet connection",Toast.LENGTH_LONG).show()


        var adapter=ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list)

        lview?.adapter=adapter
        adapter.setNotifyOnChange(true)
    }
}
