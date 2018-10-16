package com.example.bestl.kitdee.activity

import android.os.Bundle
import android.view.View
import com.example.bestl.kitdee.BaseActivity
import com.example.bestl.kitdee.R
import com.example.bestl.kitdee.interface_listener.OnCreateListener
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : BaseActivity(),OnCreateListener,View.OnClickListener {

    private var day: Int = 0
    private var month: Int = 0
    private var year: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        setView()
        setListener()

    }

    override fun init() {
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        getCurrntTime()
    }

    override fun setView() {

    }

    override fun setListener() {
    }

    override fun onClick(v: View?) {
    }

    fun getCurrntTime() {
        val t = object : Thread() {
            override fun run() {
                try {
                    while (!isInterrupted) {
                        Thread.sleep(1000)
                        runOnUiThread {
                            val date = System.currentTimeMillis()
//                            val sdf = SimpleDateFormat("MMM dd yyyy\nhh-mm-ss a")
//                            val sdf = SimpleDateFormat("dd/MMM/yyyy hh-mm")
                            val dateString = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(date)
                            tv_date_time.text = dateString
                        }
                    }
                } catch (e: InterruptedException) {
                }

            }
        }
        t.start()
    }
}
