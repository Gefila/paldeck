package com.example.paldeck

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#6EBEFF")))

        val paldeckList = getPaldeckList()

        paldeckAdapter = PaldeckAdapter(paldeckList, object : PaldeckAdapter.OnItemClickListener {
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getPaldeckList(): List<Paldeck> {
        return listOf<Paldeck>(
            Paldeck(
                "Anubis",
                "Once seen as a symbol of nobility, and an idol for those who shunned wealth and power. Yet over time, this Pal became a token of death.",
                listOf(Element.GROUND),
                Stats(120, 100, 100, 130, 130, 4960, 100, 100, 800, 1000, 80),
                "https://palworld.gg/_ipx/q_80&s_130x130/images/full_palicon/T_Anubis_icon_normal.png"
            ),
            Paldeck(
                "Arsox",
                "In ancient times, carnivorous Pals pursued them relentlessly. The absurd fury in the cries of FlameBuffalo transformed into a raging inferno, which has been passed on to this day.",
                listOf(Element.FIRE),
                Stats(85, 95, 100, 100, 95, 3520, 100, 100, 600, 800, 87),
                "https://palworld.gg/_ipx/q_80&s_130x130/images/full_palicon/T_FlameBuffalo_icon_normal.png"
            ),
            Paldeck(
                "Azurobe",
                "This Pal's white ribbon turns black if doused with impure water. Given its usefulness in detecting poison, this Pal was once overhunted. This past has left them bitter towards humanity.",
                listOf(Element.WATER),
                Stats(110, 100, 100, 70, 100, 5600, 100, 100, 600, 800, 75),
                "https://palworld.gg/_ipx/q_80&s_130x130/images/full_palicon/T_BlueDragon_icon_normal.png"
            ),
            Paldeck(
                "Blazamut Ryu",
                "Long ago, it emerged from the depths of the earth. With relentless, raging flames showing no mercy, it burned the entire island until nothing remained. It was known as the Eternal Flame.",
                listOf(Element.FIRE, Element.DRAGON),
                Stats(105, 125, 100, 150, 130, 10520, 100, 50, 700, 900, 150),
                "https://palworld.gg/_ipx/q_80&s_130x130/images/full_palicon/T_KingBahamut_Dragon_icon_normal.png"
            ),
            Paldeck(
                "Faleris",
                "When it finds its prey it unleashes a whirlwind of flames, burning the entire area to ash. Horus breath is known for its pleasing scent.",
                listOf(Element.FIRE),
                Stats(100, 110, 100, 100, 105, 6720, 230, 90, 1000, 1400, 150),
                "https://palworld.gg/_ipx/q_80&s_130x130/images/full_palicon/T_Horus_icon_normal.png"
            ),
            Paldeck(
                "Astegon",
                "A savage beast born of the abyss. Thou shall not stand before the beast. Thou shall not heed the beast.",
                listOf(Element.DRAGON,Element.DARK),
                Stats(100, 125, 100, 100, 125, 8200, 300, 100, 600, 800, 100),
                "https://palworld.gg/_ipx/q_80&s_130x130/images/full_palicon/T_BlackMetalDragon_icon_normal.png"
            ),
            Paldeck(
                "Grizzbolt",
                "With a friendly smile and a hardy physique, it is docile towards one it recognizes as a partner. For reasons unexplained, its personality undergoes a drastic change when wielding a minigun.",
                listOf(Element.ELECTRIC),
                Stats(105, 100, 100, 120, 100, 7720, 100, 100, 470, 550, 80),
                "https://palworld.gg/_ipx/q_80&s_130x130/images/full_palicon/T_ElecPanda_icon_normal.png"
            ),
            Paldeck(
                "Paladius",
                "Once one with BlackCentaur. Its gleaming form is free of all negative emotions. However, a glimmer of hatred can still be seen deep within its eyes.",
                listOf(Element.NEUTRAL),
                Stats(130, 145, 100, 110, 120, 8810, 100, 100, 800, 1400, 50),
                "https://palworld.gg/_ipx/q_80&s_130x130/images/full_palicon/T_SaintCentaur_icon_normal.png"
            ),
            Paldeck(
                "Reindrix",
                "Its transparent cerulean antlers glow with the cold of absolute zero. Any who touch them with their bare hands are instantly frozen and smashed to pieces.",
                listOf(Element.ICE),
                Stats(100, 110, 100, 80, 85, 2800, 100, 100, 550, 700, 35),
                "https://palworld.gg/_ipx/q_80&s_130x130/images/full_palicon/T_IceDeer_icon_normal.png"
            ),
            Paldeck(
                "Verdash",
                "Land that GrassRabbitMan has run across becomes extremely fertile, with thick vegetation growing soon after. It will not run anywhere that herbicide has been used.",
                listOf(Element.GRASS),
                Stats(90, 90, 100, 100, 115, 2200, 100, 100, 500, 700, 50),
                "https://palworld.gg/_ipx/q_80&s_130x130/images/full_palicon/T_GrassRabbitMan_icon_normal.png"
            ),
            Paldeck(
                "Rushoar",
                "Being an extremely aggressive Pal, it often picks fights before gauging its opponents' strength. Though small, its powerful charge can even send boulders flying.",
                listOf(Element.GROUND),
                Stats(80, 70, 100, 100, 70, 1680, 100, 100, 450, 700, 70),
                "https://palworld.gg/_ipx/q_80&s_130x130/images/full_palicon/T_Boar_icon_normal.png"
            )
        )
    }

}