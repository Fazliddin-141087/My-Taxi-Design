package uz.mobiler.mydrawelayout.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.mobiler.mydrawelayout.databinding.ItemRvBinding
import uz.mobiler.mydrawelayout.models.Taxi

class RvAdapters(val list:List<Taxi>) :RecyclerView.Adapter<RvAdapters.Vh>(){

    inner class Vh(val itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBund(taxi: Taxi){
            itemRvBinding.tv1.text=taxi.text1
            itemRvBinding.tv2.text=taxi.text2
            itemRvBinding.time.text=taxi.time
            Picasso.get().load(taxi.image).into(itemRvBinding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBund(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}