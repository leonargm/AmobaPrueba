package com.leonargm.amobaprueba.Profile.Adapter

import android.R
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.leonargm.amobaprueba.People.Adapter.PeopleAdapter
import com.leonargm.amobaprueba.databinding.ActivityPeopleBinding

class ProfileAdapter(var firestore: FirebaseFirestore) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    /*fun ProfileAdapter(binding: ActivityPeopleBinding, documents: MutableList<DocumentSnapshot>) {
        val people: ArrayList<String> = ArrayList()
        for (name in documents) {
            people.add(name.data?.get("nombre").toString())
        }
    }*/
    class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /*@BindView(R.id.channelImage)
        var imageView: ImageView? = null

        @BindView(R.id.channelName)
        var textView: TextView? = null

        @BindView(R.id.channelR)
        var relativeLayout: LinearLayout? = null

        @BindView(R.id.fav_btn)
        var mImageViewFav: ImageView? = null
        var channelEvent: Channel? = null
        fun bindData(channel: Channel) {
            channelEvent = channel
            Glide.with(mCtx)
                .load(channel.getChannelImage())
                .placeholder(R.drawable.item_gris)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)
            textView.setText(channel.getChannelName())
            mImageViewFav!!.visibility = View.GONE
        }

        @OnClick(R.id.channelR)
        fun onClickImageChanel() {
            event.openPlayer(channelEvent)
        }

        init {
            ButterKnife.bind(this, itemView)
        }*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
