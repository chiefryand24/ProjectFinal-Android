package com.asep.tugas_final_android.ui.DetailBerita

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asep.tugas_final_android.R
import com.asep.tugas_final_android.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_berita.*
import kotlinx.android.synthetic.main.item_berita.view.*

class DetailBeritaFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_berita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }

        val img = ""+ selectedBerita!!.urlToImage
        if(img != "null" && img != "") {
            Picasso.get()
                .load(img)
                .into(detailThumb)
        }

        detailTitle.text = selectedBerita!!.title
        detailSource.text = selectedBerita!!.source.name
        detailDesc.text = ""+selectedBerita!!.description
        detailContent.text = ""+selectedBerita!!.content

        shareBtn.setOnClickListener {
            shareAction()
        }

        sumberBtn.setOnClickListener {
            val url = selectedBerita!!.url
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

    }

    private fun shareAction() {

        val text = "${selectedBerita!!.title} - Link : ${selectedBerita!!.url}"

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(
                Intent.EXTRA_TEXT, text)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    companion object {

        @JvmStatic
        fun newInstance() = DetailBeritaFragment()
        var selectedBerita: Article? = null
    }
}