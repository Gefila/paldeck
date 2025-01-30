package com.example.paldeck

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

        var paldeckList = listOf<Paldeck>(
            Paldeck(1,"ya","mantap", listOf(Element.FIRE, Element.WATER), Stats( 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), "https://palworld.gg/_ipx/q_80&s_60x60/images/full_palicon/T_BirdDragon_icon_normal.png"),
            Paldeck(2,"yas","mantap", listOf(Element.FIRE, Element.WATER), Stats( 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), "https://palworld.gg/_ipx/q_80&s_60x60/images/full_palicon/T_BirdDragon_icon_normal.png")
        )

        paldeckAdapter = PaldeckAdapter(paldeckList)
        binding.rvPaldeck.apply {
            adapter = paldeckAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }


    }




}