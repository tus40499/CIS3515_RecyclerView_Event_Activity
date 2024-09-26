package edu.temple.simplerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberDisplayAdapter(
    private val numbers: Array<Int>,
    private val onClick: (Int) -> Unit // Lambda that takes an integer and returns nothing
) : RecyclerView.Adapter<NumberDisplayAdapter.NumberViewHolder>() {

    inner class NumberViewHolder (layout: View) : RecyclerView.ViewHolder (layout) {
        // enumerate views inside layout
        val textView = layout.findViewById<TextView>(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.textview_layout, parent, false)
        return NumberViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

    // Step 1b: Invoke lambda via onClickListener
    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.textView.text = numbers[position].toString()

        // Set an OnClickListener on the TextView
        holder.textView.setOnClickListener {
            onClick(numbers[position]) // Call the lambda with the clicked number
        }
    }

}