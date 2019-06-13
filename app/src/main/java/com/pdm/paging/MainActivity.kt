package com.pdm.paging

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pdm.paging.Fragments.HomeFragment

class MainActivity : AppCompatActivity(), HomeFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment.newInstance("","")
        supportFragmentManager.beginTransaction().replace(R.id.framelayout,homeFragment).addToBackStack("").commit()
    }
}
