package com.example.lifetimeproject224

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE_ASK_PERMISSIONS = 1
    private val REQUIRED_SDK_PERMISSIONS = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
    private var dialog: Dialog? = null
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dialog = Dialog(this)
        dialog!!.setContentView(R.layout.dialog_checkper)
        dialog!!.setTitle("Please check permission request")
        dialog!!.setCanceledOnTouchOutside(
                false
        )
        checkPermissions()

        var listmap: ArrayList<Model> = ArrayList()
        var model1 = Model("So nha 100 Pham Van Dong", "so nha 100 ngo 401 /72/14, Pham Vam Dong , Tu Liem , Ha Noi, Viet Nam", "100m  200km", 1234567)
        var model2 = Model("so nha 20 pham van dong", "so nha 100 ngo 401 /72/14, Pham Vam Dong , Tu Liem , Ha Noi, Viet Nam", "100m  200km", 1234567)
        listmap.add(model1)
        listmap.add(model1)
        listmap.add(model1)
        listmap.add(model1)
        listmap.add(model1)
        listmap.add(model1)
        listmap.add(model1)
        listmap.add(model1)
        listmap.add(model1)


        var adapter = Adapter(this, listmap)
        rvmap.layoutManager = LinearLayoutManager(this@MainActivity) as RecyclerView.LayoutManager?


        imgsetting.setOnClickListener {
            val intent = Intent(this@MainActivity, SettingActivity::class.java)
            startActivity(intent)
        }
        floatingActionButton.setOnClickListener {
            rvmap.visibility = VISIBLE
            rvmap.adapter = adapter
            tvcontinueshipping.setTextColor(Color.parseColor("#009688"))
        }
    }


    protected fun checkPermissions() {
        val missingPermissions = ArrayList<String>()
        // check all required dynamic permissions
        for (permission in REQUIRED_SDK_PERMISSIONS) {
            val result = ContextCompat.checkSelfPermission(this, permission)
            if (result != PackageManager.PERMISSION_GRANTED) {
                missingPermissions.add(permission)
            }
        }
        if (!missingPermissions.isEmpty()) {
            // request all missing permissions
            val permissions = missingPermissions
                    .toTypedArray()
            ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_ASK_PERMISSIONS)
        } else {
            val grantResults = IntArray(REQUIRED_SDK_PERMISSIONS.size)
            Arrays.fill(grantResults, PackageManager.PERMISSION_GRANTED)
            onRequestPermissionsResult(REQUEST_CODE_ASK_PERMISSIONS, REQUIRED_SDK_PERMISSIONS,
                    grantResults)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        when (requestCode) {
            REQUEST_CODE_ASK_PERMISSIONS -> {
                for (index in permissions.indices.reversed()) {
                    if (grantResults[index] != PackageManager.PERMISSION_GRANTED) {
                        // exit the app if one permission is not granted
//                        Toast.makeText(this, "Required permission '" + permissions[index]
//                                + "' not granted, exiting", Toast.LENGTH_LONG).show()
                        dialog!!.show()
                        return
                    }
                }
                // all permissions were granted
            }
        }

    }

    fun cancel(view: View) {
        finish()
    }

//    fun ok(view: View) {
//        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)m
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        val uri = Uri.fromParts("package", packageName, null)
//        intent.setData(uri)
//        startActivity(intent)
//        dialog!!.cancel()
//
//    }


}
