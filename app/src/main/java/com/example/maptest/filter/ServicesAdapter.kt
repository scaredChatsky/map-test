package com.example.maptest.filter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maptest.databinding.ItemServiceBinding
import com.example.maptest.domain.model.Service
import com.example.maptest.inflater

class ServicesAdapter(
    private val itemClick: (Service) -> Unit
) : RecyclerView.Adapter<ServicesAdapter.ViewHolder>() {

    private var data: List<Service> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(services: List<Service>) {
        data = services
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemServiceBinding.inflate(parent.inflater(), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(private val binding: ItemServiceBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(service: Service) {
            with(binding) {
                itemView.setOnClickListener {
                    cbEnabled.isChecked = !cbEnabled.isChecked
                    itemClick(service)
                }

                tvServiceName.text = service.name
                cbEnabled.isChecked = service.enabled
            }
        }
    }
}