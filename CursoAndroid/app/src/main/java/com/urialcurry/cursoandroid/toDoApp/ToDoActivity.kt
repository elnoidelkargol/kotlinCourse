package com.urialcurry.cursoandroid.toDoApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.urialcurry.cursoandroid.R
import com.urialcurry.cursoandroid.toDoApp.TaskCategory.*

class ToDoActivity : AppCompatActivity() {

    private val categories = listOf<TaskCategory>(
        Bussines,
        Personal,
        Other
    )

    private val tasks = mutableListOf<Task>(
        Task("PruebaBusiness", Bussines),
        Task("PruebaPersonal", Personal),
        Task("PruebaOther", Other)
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView
    private lateinit var taskAdapter: TaskAdapter

    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)

        initComponents()
        initUI()
        initListeners()
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        taskAdapter = TaskAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter
    }

    private fun onItemSelected(position:Int)
    {
        tasks[position].isSelected = !tasks[position].isSelected
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showAddDialog() }
    }

    private fun showAddDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_add_task)

        val buttonAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTaskName: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        etTaskName.addTextChangedListener {
            buttonAddTask.isEnabled = !(etTaskName.text.toString().isEmpty())
        }
        buttonAddTask.setOnClickListener {
            val taskText: String = etTaskName.text.toString()
            val selectedId = rgCategories.checkedRadioButtonId
            val selectedRb: RadioButton = rgCategories.findViewById(selectedId)
            val currentCategory: TaskCategory = when (selectedRb.text) {
                getString(R.string.negocios) -> Bussines
                getString(R.string.personal) -> Personal
                else -> Other
            }
            tasks.add(Task(taskText, currentCategory))
            updateTasks()
            dialog.hide()
        }


        dialog.show()

    }

    private fun updateTasks() {
        taskAdapter.notifyDataSetChanged()
    }
}