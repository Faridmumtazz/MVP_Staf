package mumtaz.binar.mvp_staf.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import mumtaz.binar.mvp_staf.R
import mumtaz.binar.mvp_staf.adapter.AdapterStaf
import mumtaz.binar.mvp_staf.model.GetAllStafResponseItem
import mumtaz.binar.mvp_staf.presenter.StafPresenter
import mumtaz.binar.mvp_staf.presenter.StafView

class MainActivity : AppCompatActivity(), StafView {

    private lateinit var presenterstaf : StafPresenter
    lateinit var adapterstaf : AdapterStaf
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenterstaf = StafPresenter(this)
        presenterstaf.getDataStaf()
    }

    override fun onSuccess(pesan: String, staf: List<GetAllStafResponseItem>) {
        rv_staf.layoutManager = LinearLayoutManager(this)
        adapterstaf = AdapterStaf(staf){
            val pindah = Intent(this@MainActivity, DetailStafActivity::class.java)
            pindah.putExtra("detailstaf", it)
            startActivity(pindah)
        }
        rv_staf.adapter = adapterstaf
    }
    override fun onError(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
    }
}