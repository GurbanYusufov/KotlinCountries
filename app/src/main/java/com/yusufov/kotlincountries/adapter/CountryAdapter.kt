package com.yusufov.kotlincountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.yusufov.kotlincountries.R
import com.yusufov.kotlincountries.Util.downloadFromUrl
import com.yusufov.kotlincountries.Util.placeHolderProgressBar
import com.yusufov.kotlincountries.model.Country
import com.yusufov.kotlincountries.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList: ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(var view: View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.view.name.text=countryList[position].countryName
        holder.view.region.text=countryList[position].countryRegion

        holder.view.setOnClickListener{
            val action=FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            Navigation.findNavController(it).navigate(action)
        }

        holder.view.imageView.downloadFromUrl(countryList[position].imageUrl,
            placeHolderProgressBar(holder.view.context)
        )
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateCountryList(newCountryList: List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }
}