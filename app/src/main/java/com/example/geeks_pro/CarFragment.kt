package com.example.geeks_pro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geeks_pro.databinding.FragmentCarBinding

class CarFragment : Fragment() {
    private lateinit var binding:FragmentCarBinding
    private val adapter = CarAdapter(this::onClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
    }

    private fun onClick(carModel: CarModel){
        val bundle = Bundle()
        bundle.putSerializable("car", carModel)
        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.car_fragment, detailFragment)
    }
}