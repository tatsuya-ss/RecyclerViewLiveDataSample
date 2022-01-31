package com.example.recyclerviewlivedatasample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlivedatasample.databinding.RowItemBinding

class RecyclerViewAdapter(var items: List<String> = listOf<String>("a", "b")): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(binding: RowItemBinding): RecyclerView.ViewHolder(binding.root) {
        val binding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("debug onBindViewHolder, ${position}")
        holder.binding.textView.text = items[position]
    }

    override fun getItemCount(): Int {
        println("debug getItemCount${items.size}")
        return items.size
    }

}

fun RecyclerViewAdapter.setItem(item: List<String>) {
    items = item
    println("debugsetItem, $items")
    notifyDataSetChanged()
}