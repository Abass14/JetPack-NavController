package com.example.contactappv2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_profile.*

class Profile : Fragment() {
    private val args :  ProfileArgs by navArgs()
    lateinit var name: TextView
    lateinit var getContactNo: TextView
    lateinit var image: ImageView
    lateinit var getEmail: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        name = view.findViewById(R.id.getNameTxt)
        getContactNo = view.findViewById(R.id.contactNo)
        image = view.findViewById(R.id.getImage)
        getEmail = view.findViewById(R.id.email)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contact = args.contactData
        name.text = contact?.theText
        getContactNo.text = contact?.phone
        image.setImageResource(contact?.image!!)
        getEmail.text = contact.email
    }
}