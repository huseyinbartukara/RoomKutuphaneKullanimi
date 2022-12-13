package com.example.roomkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var vt:Veritabani
    private lateinit var kdao:KisilerDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        vt = Veritabani.veritabaniErisim(this)!!
        kdao = vt.getKisilerDao()

        //ekle()
        //guncelle()
        //sil()
        //kisileriYukle()
        //rasgele()
        //ara()
        //getir()
        kontrol()

    }

    fun kisileriYukle(){
        val job = CoroutineScope(Dispatchers.Main).launch{
            val gelenListe = kdao.tumKisiler()

            for(k in gelenListe){
                Log.e("Kisi id",k.kisi_id.toString())
                Log.e("Kisi ad",k.kisi_ad)
                Log.e("Kisi yas",k.kisi_yas.toString())
            }
        }
    }


    fun ekle() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniKisi = Kisiler(0,"Ahmet",40)
            kdao.kisiEkle(yeniKisi)
        }
    }

    fun guncelle() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenKisi = Kisiler(3,"YeniAhmet",50)
            kdao.kisiGuncelle(guncellenenKisi)
        }
    }

    fun sil() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenKisi = Kisiler(3,"YeniAhmet",50)
            kdao.kisiSil(silinenKisi)
        }
    }


    fun rasgele(){
        val job = CoroutineScope(Dispatchers.Main).launch{
            val gelenListe = kdao.rasgeleBirKisiGetir()

            for(k in gelenListe){
                Log.e("Kisi id",k.kisi_id.toString())
                Log.e("Kisi ad",k.kisi_ad)
                Log.e("Kisi yas",k.kisi_yas.toString())
            }
        }
    }


    fun ara(){
        val job = CoroutineScope(Dispatchers.Main).launch{
            val gelenListe = kdao.kisiAra("e")

            for(k in gelenListe){
                Log.e("Kisi id",k.kisi_id.toString())
                Log.e("Kisi ad",k.kisi_ad)
                Log.e("Kisi yas",k.kisi_yas.toString())
            }
        }
    }

    fun getir(){
        val job = CoroutineScope(Dispatchers.Main).launch{
            val kisi = kdao.kisiGetir(1)

            Log.e("Kisi id",kisi.kisi_id.toString())
            Log.e("Kisi ad",kisi.kisi_ad)
            Log.e("Kisi yas",kisi.kisi_yas.toString())
        }
    }

    fun kontrol(){
        val job = CoroutineScope(Dispatchers.Main).launch{
            val sonuc = kdao.kayıtKontrol("Ece")

            Log.e("Kisi Kontrol Sonucu",sonuc.toString())

        }
    }

}