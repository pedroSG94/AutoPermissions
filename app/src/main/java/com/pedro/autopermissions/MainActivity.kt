package com.pedro.autopermissions

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    b_all.setOnClickListener {
      startActivity(Intent(this, AllExampleActivity::class.java))
    }
    b_activity.setOnClickListener {
      startActivity(Intent(this, ActivityExampleActivity::class.java))
    }
  }
}
