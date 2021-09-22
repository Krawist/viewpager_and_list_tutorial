package cm.seeds.viewpagerandlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import cm.seeds.viewpagerandlist.adapters.ImageAdapter
import cm.seeds.viewpagerandlist.databinding.ActivityMainBinding
import cm.seeds.viewpagerandlist.models.Image

class MainActivity : AppCompatActivity() {

    private lateinit var databinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(databinding.root)

        setupViewpager()
    }

    private fun setupViewpager() {
        val images = listOf(
            Image(link = R.drawable.image1),
            Image(link = R.drawable.image2),
        )
        val adapter = ImageAdapter().apply {
            submitList(images)
        }
        databinding.recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setAdapter(adapter)
        }
    }
}