package uz.mobiler.mydrawelayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.mobiler.mydrawelayout.adapters.RvAdapters
import uz.mobiler.mydrawelayout.databinding.ActivityMyTripsBinding
import uz.mobiler.mydrawelayout.models.Taxi

class MyTripsActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyTripsBinding
    lateinit var rvAdapters: RvAdapters
    lateinit var list: ArrayList<Taxi>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyTripsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

        rvAdapters = RvAdapters(list)
        binding.rv.adapter = rvAdapters

        binding.toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun loadData() {
        list = ArrayList()
        for (i in 1..10) {
            list.add(
                Taxi(
                    "https://di-enrollment-api.s3.amazonaws.com/honda/honda-model-row/model-row-3/civic-sedan.png",
                    "улица Sharof Rashidov, Ташкент",
                    "5a улица Асадуллы Ходжаева",
                    "21:36 * 12 900 cум"
                )
            )
        }
    }
}