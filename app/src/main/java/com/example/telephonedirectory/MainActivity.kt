package com.example.telephonedirectory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    var itemsList:ArrayList<Item> = arrayListOf(
        Item(R.drawable.ic_emailj,"Id1", "Jaby shark", "0123456789", "AEmail@gmail.com"),
        Item(R.drawable.ic_emailj,"Id2", "Jeon Jimin", "0324567891", "BEmail@gmail.com"),
        Item(R.drawable.ic_emailj,"Id3", "Jung Hoseok", "0336739209", "CEmail@gmail.com"),
        Item(R.drawable.ic_emailj,"Id4", "Jacobak", "0367492949", "DEmail@gmail.com"),
        Item(R.drawable.ic_emailj,"Id5", "John Baiden", "0365427497", "OneEmail@gmail.com"),
        Item(R.drawable.ic_emailj,"Id6", "Justin Bieber", "0367993829", "TwoEmail@gmail.com"),
        Item(R.drawable.ic_emailj,"Id7", "Just trustme", "0347652930", "threeEmail@gmail.com"),
    );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView:ListView = findViewById(R.id.list_view);
        val adapter = ListViewAdapter(this, itemsList);
        listView.adapter = adapter;
        listView.isClickable = true;
        listView.setOnItemClickListener { parent, view, position, id ->
            val id = itemsList[position].id;
            val name = itemsList[position].name;
            val phoneNumber = itemsList[position].phoneNumber;
            val email = itemsList[position].email;

            val i = Intent(this, ItemActivity::class.java);
            i.putExtra("id", id);
            i.putExtra("name", name);
            i.putExtra("phoneNumber", phoneNumber);
            i.putExtra("email", email);
            Log.v("TAG", "Item clicked")
            startActivity(i);
        }
        registerForContextMenu(listView);
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context_menu, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return super.onContextItemSelected(item)
    }
}
