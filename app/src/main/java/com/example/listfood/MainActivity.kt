package com.example.listfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    data class Food(val name: String, val chef: String)

    private val foodList = listOf(
        Food("Feijão tropeiro", "Ana Laura"),
        Food("Frango caipira", "Julio"),
        Food("Pamonha", "Gabriel"),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = FoodAdapter(foodList)

        recyclerView.adapter = adapter

    }

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(food: Food) {
            itemView.findViewById<TextView>(R.id.foodName).text = food.name
            itemView.findViewById<TextView>(R.id.foodChef).text = food.chef
        }
    }


    class FoodAdapter(private val foods: List<Food>) : RecyclerView.Adapter<FoodViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
            return FoodViewHolder(view)
        }

        override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
            val food = foods[position]
            holder.bind(food)
        }

        override fun getItemCount(): Int {
            return foods.size
        }
    }


}