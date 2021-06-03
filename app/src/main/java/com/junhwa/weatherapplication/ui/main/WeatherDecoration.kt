package com.junhwa.weatherapplication.ui.main

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.core.view.children
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.junhwa.weatherapplication.R
import com.junhwa.weatherapplication.ui.dipToInt


class WeatherDecoration(
    context: Context,
    @RecyclerView.Orientation private val orientation: Int
) : RecyclerView.ItemDecoration() {

    private val dividerHeight: Int = context.dipToInt(1f)
    private var paint: Paint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = dividerHeight.toFloat()
        color = context.getColor(R.color.divider_color)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.set(dividerHeight, 0, dividerHeight, 0)
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        if (orientation == LinearLayoutManager.VERTICAL) {
            vertical(c, parent)
        }
    }

    private fun vertical(c: Canvas, parent: RecyclerView) {
        val left = parent.paddingLeft + dividerHeight
        val right = parent.width - parent.paddingRight - dividerHeight

        val childCount = parent.childCount

        parent.children.forEachIndexed { index, child ->
            val translationY: Int = (child.translationY + 0.5f).toInt()
            val top = child.top + dividerHeight + translationY
            val bottom = if (index == childCount -1) {
                child.bottom + translationY
            } else {
                child.bottom + dividerHeight + translationY
            }

            c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), paint)
        }
    }

}