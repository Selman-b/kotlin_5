package com.example.recycleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var superKahramanListesi :ArrayList<superkahraman>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val batman = superkahraman("batman","patron",R.drawable.batman)
        val aquaman = superkahraman ("aquaman","kral",R.drawable.aquaman)
        val ironman = superkahraman("ironman","sirket",R.drawable.ironman)
        val superman = superkahraman("superman","gazeteci",R.drawable.superman)//R.drawable. yazınca cıkan fotodan sec

        superKahramanListesi= arrayListOf(batman,aquaman,ironman,superman)
        val adapter = Superkahramanadapter(superKahramanListesi)
        binding.superKahramanRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.superKahramanRecyclerView.adapter=adapter

    }
}

