package com.example.m017_recyclerview.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.m017_recyclerview.R
import com.example.m017_recyclerview.data.ConstData
import com.example.m017_recyclerview.data.Photo
import com.example.m017_recyclerview.databinding.FragmentFotoBinding

//private const val PHOTO = "photo"

class FotoFragment : Fragment() {


    private lateinit var binding: FragmentFotoBinding
    private var _photo: Photo? = null
    private var photo = _photo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFotoBinding.inflate(layoutInflater)
        arguments?.let {
            photo = it.getParcelable(ConstData.PHOTO)!!
        }
        if (photo != null) {
            Glide
                .with(this@FotoFragment)
                .load(photo!!.img_src)
                .into(binding.photo)
            binding.camera.text = requireContext().getString(R.string.camera, photo!!.camera.name)
            binding.earthDate.text =
                requireContext().getString(R.string.earth_date, photo!!.earth_date)
            binding.sol.text = requireContext().getString(R.string.sol, photo!!.sol)
            binding.rover.text = requireContext().getString(R.string.rover, photo!!.rover.name)
        }
        return binding.root
    }


}