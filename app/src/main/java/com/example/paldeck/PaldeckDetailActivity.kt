package com.example.paldeck

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.paldeck.databinding.ActivityPaldeckDetailBinding

class PaldeckDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaldeckDetailBinding
    private var paldeck: Paldeck? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPaldeckDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#6EBEFF")))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        paldeck = if (android.os.Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("paldeck", Paldeck::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("paldeck")
        }
        if(paldeck != null){
            supportActionBar?.title = "Paldeck Detail - ${paldeck?.name}"
            binding.tvPaldeckNameDetail.text = paldeck!!.name
            Glide.with(this).load(paldeck!!.image).into(binding.ivPaldeckDetail)

            for (element in paldeck!!.elements) {
                when (element) {
                    Element.FIRE -> binding.ivFire.visibility = View.VISIBLE
                    Element.WATER -> binding.ivWater.visibility = View.VISIBLE
                    Element.GRASS -> binding.ivGrass.visibility = View.VISIBLE
                    Element.ELECTRIC -> binding.ivElectric.visibility = View.VISIBLE
                    Element.ICE -> binding.ivIce.visibility = View.VISIBLE
                    Element.GROUND -> binding.ivGround.visibility = View.VISIBLE
                    Element.DARK -> binding.ivDark.visibility = View.VISIBLE
                    Element.DRAGON -> binding.ivDragon.visibility = View.VISIBLE
                    Element.NEUTRAL -> binding.ivNeutral.visibility = View.VISIBLE

                }
            }

            binding.tvPaldeckDescriptionDetail.text = paldeck!!.description
            binding.tvPaldeckHp.text = paldeck!!.stats.hp.toString()
            binding.tvPaldeckDefense.text = paldeck!!.stats.defense.toString()
            binding.tvPaldeckCraftingSpeed.text = paldeck!!.stats.craftingSpeed.toString()
            binding.tvPaldeckMeleeAtt.text = paldeck!!.stats.meleeAttack.toString()
            binding.tvPaldeckShoAtt.text = paldeck!!.stats.shotAttack.toString()
            binding.tvPaldeckPrice.text = paldeck!!.stats.price.toString()
            binding.tvPaldeckStamina.text = paldeck!!.stats.stamina.toString()
            binding.tvPaldeckSupport.text = paldeck!!.stats.support.toString()
            binding.tvPaldeckRunningSpeed.text = paldeck!!.stats.runningSpeed.toString()
            binding.tvPaldeckSprintingSpeed.text = paldeck!!.stats.sprintingSpeed.toString()
            binding.tvPaldeckSlowWalkSpeed.text = paldeck!!.stats.slowWalkSpeed.toString()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.action_share -> {
                val sendIntent:Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "${paldeck!!.name}, ${paldeck!!.description}")
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

}