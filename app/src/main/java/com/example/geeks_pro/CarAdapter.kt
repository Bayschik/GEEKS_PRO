package com.example.geeks_pro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.geeks_pro.databinding.ItemCarBinding

class CarAdapter(val onClick:(model:CarModel)->Unit):Adapter<CarAdapter.CarViewHolder>() {
    private val carList = arrayListOf<CarModel>(
        CarModel("https://www.mbusa.com/content/dam/mb-nafta/us/myco/my23/e/sedan/all-vehicles/2023-E350-SEDAN-AVP-D.png", "Mercedes", "2003"),
        CarModel("https://www.toyota.com/imgix/content/dam/toyota/jellies/max/2024/camry/xse/2548/2pt/36/5.png?fm=png&w=930&q=90", "Toyota Camry", "2020"),
        CarModel("https://www.carandbike.com/_next/image?url=https%3A%2F%2Fimages.carandbike.com%2Fcar-images%2Fcolors%2Fford%2Fmustang%2Fford-mustang-ingot-silver.png%3Fv%3D1&w=640&q=75", "Mustang", "2019"),
        CarModel("https://configurator.porsche.com/model-start/pictures/718/extcam01.webp", "Porsche", "2020"),
        CarModel("https://www.bmw.in/content/dam/bmw/marketIN/bmw_in/all-models/3-series/gl/2023/3gl-navigation.png", "BMW", "2020"),
        CarModel("https://www.kia.com/content/dam/kwcms/kme/uk/en/assets/vehicles/The-New-Ceed/kia-ceed_2018-gt-line-dark-penta-metal_1280x720.png", "KIA", "2021"),
        CarModel("https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/Tesla-Model-3%20%281%29.png", "Tesla", "2019"),
        CarModel("https://medias.fcacanada.ca/jellies/renditions/2023/800x510/CC23_LADH22_2DA_PQD_APA_XXX_XXX_XXX.d63f26e763460d4c8035c732cfd119c3.png", "Dodge", "2017"),
        CarModel("https://www.hondacarindia.com/_next/image?url=https%3A%2F%2Fcdn2.hondacarindia.com%2Fmodels%2FcarModelImage%2FhondeCityEhev%2FeHEV-Desktop.png&w=3840&q=75", "Honda", "2024"),
        CarModel("https://images.drive.com.au/driveau/image/upload/c_fill,f_auto,g_auto,h_675,q_auto:good,w_1200/vehicles/showrooms/models/nissan-gt-r", "Nissan", "2005"),
        CarModel("https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_default/v1/editorial/vhs/Lexus-RX_1.png", "Lexus", "2018"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() =  carList.size


    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(carList[position])
    }

    inner class CarViewHolder(private val binding:ItemCarBinding):ViewHolder(binding.root){
        fun bind(carModel: CarModel) {
            binding.tvCar.text = carModel.name
            binding.tvCarYear.text = carModel.year
            Glide.with(binding.imgCar).load(carModel.image).into(binding.imgCar)
            itemView.setOnClickListener {
                onClick(carModel)
            }
        }

    }
}