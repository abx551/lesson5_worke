package com.guzya.lesson5_worke


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.guzya.lesson5_worke.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private val carsListAdapter = CarListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fillCarsList()
        setupRecyclerView()
    }

    private fun fillCarsList() {
        val carsList = listOf(
            Car("Bugatti Divo", R.drawable.bugatti, 4, 380),
            Car("Bmw", R.drawable.ferrari, 4, 290),
            Car("bmw f90", R.drawable.bmwf90, 4, 240),
            Car("Lamborghini Aventador", R.drawable.lamborghini, 4, 230),
            Car("Ford Mustang", R.drawable.mustang, 4, 210),
            Car("Lamborghini", R.drawable.lamborghini, 4, 420),
        )
        carsListAdapter.setData(carsList)
    }

    private fun setupRecyclerView() {
        binding.rvCar.adapter = carsListAdapter
    }
}
