package com.fischautofisher

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private var running = false
    private lateinit var status: TextView
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(Color.rgb(15, 22, 35))
        }

        val title = TextView(this).apply {
            text = "🎣 FISCH AUTO FISHER"
            textSize = 26f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        status = TextView(this).apply {
            text = "Status: Ready"
            textSize = 18f
            setTextColor(Color.GREEN)
            gravity = Gravity.CENTER
            setPadding(0, 40, 0, 40)
        }

        startButton = Button(this).apply {
            text = "START FISHING"
            setOnClickListener { toggleFishing() }
        }

        val info = TextView(this).apply {
            text = "Dreambreaker Edition\n\nAutomatic fishing controls\nVersion 1.0"
            textSize = 16f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 40, 0, 0)
        }

        layout.addView(title)
        layout.addView(status)
        layout.addView(startButton)
        layout.addView(info)

        setContentView(layout)
    }

    private fun toggleFishing() {
        running = !running

        if (running) {
            status.text = "Status: RUNNING"
            status.setTextColor(Color.GREEN)
            startButton.text = "STOP FISHING"
        } else {
            status.text = "Status: STOPPED"
            status.setTextColor(Color.RED)
            startButton.text = "START FISHING"
        }
    }
}
