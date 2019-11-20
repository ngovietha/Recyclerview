package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val heros:ArrayList<Hero> = ArrayList<Hero>()
        for(i in 1..100){
            heros.add(Hero("Thor",R.drawable.thor))
        }
        for(i in 1..100){
            heros.add(Hero("Hulk",R.drawable.hulk))
        }
        for(i in 1..100){
            heros.add(Hero("Cap",R.drawable.cap))
        }
        for(i in 1..100){
            heros.add(Hero("Iron man",R.drawable.ironman))
        }
        for(i in 1..100){
            heros.add(Hero("Superman",R.drawable.sm))
        }

        Collections.shuffle(heros)
//        heros.add(Hero("Hulk",R.drawable.hulk))
//        heros.add(Hero("Superman",R.drawable.sm))
//        heros.add(Hero("Spiderman",R.drawable.spiderman))

        recyclerHero.setHasFixedSize(true)
        recyclerHero.layoutManager= StaggeredGridLayoutManager(3,LinearLayoutManager.VERTICAL)
        recyclerHero.adapter= HeroAdapter(heros,applicationContext)
    }


}
