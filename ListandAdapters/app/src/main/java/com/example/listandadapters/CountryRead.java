package com.example.listandadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;

public class CountryRead extends AppCompatActivity implements DownloadFile.Listener{
    PDFPagerAdapter adapter;
    RemotePDFViewPager remotePDFViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_read);

        String url = getIntent().getStringExtra("url");
        Toast.makeText(this,url,Toast.LENGTH_SHORT);
        remotePDFViewPager = new RemotePDFViewPager(CountryRead.this,url,CountryRead.this);
    }

    @Override
    public void onSuccess(String url, String destinationPath) {
        adapter = new PDFPagerAdapter(this, url.substring(url.lastIndexOf('/'+1)));
        PDFViewPager PDFViewPager = findViewById(R.id.pdfViewPager);
        PDFViewPager.setAdapter(adapter);
//        adapter = new PDFPagerAdapter(this, extract(url));
//        remotePDFViewPager.setAdapter(adapter);
//        setContentView(remotePDFViewPager);
        Toast.makeText(this,url,Toast.LENGTH_SHORT).show();
    }
    public static String extract(String url){
        return url.substring(url.lastIndexOf('/'+1));
    }

    @Override
    public void onFailure(Exception e) {
        Toast.makeText(this,"failed",Toast.LENGTH_SHORT);
    }

    @Override
    public void onProgressUpdate(int progress, int total) {
        Toast.makeText(this,"Loading ",Toast.LENGTH_SHORT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        adapter.close();
    }
}