package lostankit7.droid.moodtracker.ui.entry.task.addTask

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import lostankit7.droid.moodtracker.base.BaseRvAdapter
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.databinding.ItemRvTaskIconBinding
import lostankit7.droid.moodtracker.data.database.entities.TaskIcon

class RvTaskItemAdapter(
    context: Context,
    list: MutableList<TaskIcon>,
    private val taskSelected: (TaskIcon) -> Unit
) : BaseRvAdapter<ItemRvTaskIconBinding, TaskIcon>(list, context) {
    
    override fun bindViewHolder(item: TaskIcon, position: Int, binding: ItemRvTaskIconBinding) {
        binding.tvName.text = item.name
        binding.tvIcon.text = item.icon

        binding.root.setOnClickListener {
            item.isSelected = !item.isSelected
            binding.tvIcon.apply {
                taskSelected.invoke(item)
                if (item.isSelected) {
                    setTextColor(ContextCompat.getColor(context, R.color.task_icon_bg))
                    solidColor(ContextCompat.getColor(context, R.color.task_icon))
                } else {
                    setTextColor(ContextCompat.getColor(context, R.color.task_icon))
                    solidColor(ContextCompat.getColor(context, R.color.task_icon_bg))
                }
            }
        }
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ) = ItemRvTaskIconBinding.inflate(layoutInflater, parent, attachToParent)

    companion object {
        fun newInstance(context: Context, list: MutableList<TaskIcon>, taskSelected: (TaskIcon) -> Unit) =
            RvTaskItemAdapter(context, list, taskSelected)
    }
}