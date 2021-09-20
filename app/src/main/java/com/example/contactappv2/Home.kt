package com.example.contactappv2

import android.app.ActivityOptions
import android.os.Bundle
import android.util.Pair
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*

class Home : Fragment(), RecyclerViewAdapter.OnPlayerClickLister {
    lateinit var contact: List<Player>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        contact = listOf(
            Player("Lionel Messi", R.mipmap.auba, "(650) 555-1367", "lionelmessi@gmail.com"),
            Player("Pierre-Emerick Aubameyang", R.mipmap.auba, "(650) 445-1897", "aubameyang@gmail.com"),
            Player("Robert Lewadowski", R.mipmap.auba, "(330) 888-1367", "lewandowski@gmail.com"),
            Player("Kylian Mbappe", R.mipmap.auba,"(650) 544-0007", "kmbappe@gmail.com"),
            Player("Thomas Partey", R.mipmap.auba, "(777) 555-2267", "thomasp@gmail.com"),
            Player("Nicolas Pepe", R.mipmap.auba, "(651) 552-1367", "n_pepe@gmail.com"),
            Player("Bukayo Saka", R.mipmap.auba, "(+234) 8094156896", "saka.b@gmail.com"),
            Player("Smith Rowe", R.mipmap.auba, "(650) 555-0007", "smith-rowe@gmail.com")
        )

        val recAdapter = RecyclerViewAdapter(contact, this)
        val rec = view.findViewById<RecyclerView>(R.id.recView)
        rec.adapter = recAdapter
        val layoutManager = LinearLayoutManager(requireContext())
        rec.layoutManager = layoutManager
        return view
    }

    override fun onPlayerClick(position: Int) {
        contact[position]
        val action = HomeDirections.actionHome2ToProfile(contact[position])
        findNavController().navigate(action)

    }
}