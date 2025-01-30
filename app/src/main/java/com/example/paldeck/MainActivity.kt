package com.example.paldeck

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paldeck.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var paldeckAdapter: PaldeckAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#AAC7FF")))

        val paldeckList = listOf<Paldeck>(
            Paldeck("Anubis","Once seen as a symbol of nobility, and an idol for those who shunned wealth and power. Yet over time, this Pal became a token of death.", listOf(Element.GROUND), Stats( 120, 100, 100, 130, 130, 4960, 100, 100, 800, 1000, 80), "https://palworld.gg/_ipx/q_80&s_130x130/images/full_palicon/T_Anubis_icon_normal.png"),
        )

        paldeckAdapter = PaldeckAdapter(paldeckList, object: PaldeckAdapter.OnItemClickListener{
            override fun onItemClick(paldeck: Paldeck) {
                val intent = Intent(this@MainActivity, PaldeckDetailActivity::class.java)
                intent.putExtra("paldeck", paldeck)
                startActivity(intent)
            }

        })
        binding.rvPaldeck.apply {
            adapter = paldeckAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }


    }




}